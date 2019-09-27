package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.conformance.util.ModelConformanceConverter;
import au.org.consumerdatastandards.support.EndpointResponse;
import au.org.consumerdatastandards.support.ResponseCode;
import au.org.consumerdatastandards.support.model.ModelBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static au.org.consumerdatastandards.conformance.util.ConformanceUtil.createObjectMapper;

public class PayloadValidator {

    private static Logger LOGGER = LoggerFactory.getLogger(PayloadValidator.class);

    private ConformanceModel conformanceModel;

    public PayloadValidator() {
        ModelBuilder modelBuilder = new ModelBuilder();
        conformanceModel = ModelConformanceConverter.convert(modelBuilder.build());
    }

    public String getEndpointVersion(String operationId) {
        return conformanceModel.getEndpointVersionMap().get(operationId);
    }

    public List<ConformanceError> validateFile(File jsonFile) {
        LOGGER.info("Validating " + jsonFile.getAbsolutePath());
        byte[] jsonData;
        try {
            jsonData = Files.readAllBytes(Paths.get(jsonFile.getCanonicalPath()));
            return validatePayload(jsonData);
        } catch (IOException e) {
            return Collections.singletonList(new ConformanceError().errorMessage(
                "Failed to load file " + jsonFile.getAbsolutePath()
            ));
        }
    }

    public List<ConformanceError> validatePayload(String json) {
        if (StringUtils.isBlank(json)) {
            return Collections.singletonList(
                new ConformanceError().errorMessage("Blank json text... Ignored."));
        }
        return validatePayload(json.getBytes());
    }

    private List<ConformanceError> validatePayload(byte[] jsonData) {
        for (Class<?> modelClass : conformanceModel.getPayloadModels()) {
            try {
                ObjectMapper objectMapper = createObjectMapper();
                Payload payload = conformanceModel.getPayload(modelClass);
                Object data = objectMapper.readValue(jsonData, payload.getDataClass());
                List<ConformanceError> errors = new ArrayList<>();
                ConformanceUtil.checkAgainstModel(data, modelClass, errors);
                LOGGER.info("Found matching model " + modelClass.getSimpleName());
                return errors;
            } catch (IOException e) {
                // ignored
            }
        }
        return Collections.singletonList(new ConformanceError()
            .errorType(ConformanceError.Type.NO_MATCHING_MODEL)
            .errorMessage("No matching model found"));
    }

    public List<ConformanceError> validateResponse(String requestUrl, Object response, String operationId, ResponseCode responseCode) {
        List<ConformanceError> errors = new ArrayList<>();
        EndpointResponse endpointResponse = conformanceModel.getResponse(operationId, responseCode);
        if (endpointResponse == null) {
            return Collections.singletonList(new ConformanceError().errorMessage(
                String.format("No response model found for operation %s with response code %s", operationId, responseCode)));
        }
        Class<?> responseModel = endpointResponse.content();
        ConformanceUtil.checkAgainstModel(response, responseModel, errors);
        errors.addAll(checkMetaAndLinks(requestUrl, response));
        return errors;
    }

    public List<ConformanceError> validateResponse(String requestUrl, Object response, String operationId, int httpResponseCode) {
        ResponseCode responseCode = ResponseCode.fromCode(httpResponseCode);
        if (responseCode == null) {
            return Collections.singletonList(new ConformanceError().errorMessage(
                String.format("No response defined with code %d", httpResponseCode)
            ));
        }
        return validateResponse(requestUrl, response, operationId, responseCode);
    }

    private List<ConformanceError> checkMetaAndLinks(String requestUrl, Object response) {
        Integer page = 1, pageSize = 25;
        Map<String, Object> params = extractParameters(requestUrl);
        List<ConformanceError> errors = new ArrayList<>();
        try {
            Integer pageParam = getPageParameter(params);
            if (pageParam != null) page = pageParam;
        } catch (NumberFormatException e) {
            errors.add(new ConformanceError()
                .errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                .errorMessage("Invalid 'page' parameter value " + getParameter(params, "page"))
            );
        }
        try {
            Integer pageSizeParam = getPageSizeParameter(params);
            if (pageSizeParam != null) pageSize = pageSizeParam;
        } catch (NumberFormatException e) {
            errors.add(new ConformanceError()
                .errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                .errorMessage("Invalid 'page-size' parameter value " + getParameter(params, "page-size"))
            );
        }

        Object meta = getMeta(response);
        Object links = getLinks(response);
        if (isPaginatedResponse(meta, links)) {
            Integer totalRecords, totalPages = null;
            if (meta != null) {
                totalRecords = getTotalRecords(meta);
                totalPages = getTotalPages(meta);
                if (totalRecords != null && totalPages != null
                    && (totalRecords / pageSize + (totalRecords % pageSize > 0 ? 1 : 0)) != totalPages) {
                    errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format(
                             "totalPages %d does not match totalRecords / page-size + remainder of (totalRecords / page-size), "
                             + "where page-size is " + pageSize + " . See below:\n%s", totalPages, ConformanceUtil.toJson(meta)))
                    );
                }
            }
            if (links != null) {
                String linksJson = ConformanceUtil.toJson(links);
                String first = getFieldValueAsString(links, "first");
                String prev = getFieldValueAsString(links, "prev");
                String next = getFieldValueAsString(links, "next");
                String last = getFieldValueAsString(links, "last");
                String self = getFieldValueAsString(links, "self");
                checkFirstLink(pageSize, errors, totalPages, linksJson, first);
                checkLastLink(page, pageSize, errors, totalPages, linksJson, last);
                checkSelfLink(requestUrl, errors, linksJson, self);
                checkPrevLink(page, errors, linksJson, prev);
                checkNextLink(page, errors, totalPages, linksJson, next);
            }
        } else if (isBaseResponse(meta, links)) {
            checkSelfLink(requestUrl, response, errors);
        }
        return errors;
    }

    private void checkPrevLink(Integer page, List<ConformanceError> errors, String linksJson, String prev) {
        if (page == 1 && !StringUtils.isBlank(prev)) {
            errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                .errorMessage(String.format("Prev %s should be null as current page is the first page. See below:\n%s", prev, linksJson))
            );
        } else if (page > 1 && StringUtils.isBlank(prev)) {
            errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                .errorMessage(String.format("Prev %s should be not null as current page is not the first page. See below:\n%s", prev, linksJson))
            );
        } else if (page > 1 && !StringUtils.isBlank(prev)) {
            Map<String, Object> prevLinkParams = extractParameters(prev);
            String prevLinkPageParam = getParameter(prevLinkParams, "page");
            if (StringUtils.isBlank(prevLinkPageParam)) {
                errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format("prev link %s does not have page param. See below:\n%s",
                                prev, linksJson))
                );
            } else {
                try {
                    int prevLinkPage = Integer.parseInt(prevLinkPageParam);
                    if (prevLinkPage != page - 1 ) {
                        errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                                .errorMessage(String.format("prev link %s have invalid page param %s. See below:\n%s",
                                        prev, prevLinkPage, linksJson))
                        );
                    }
                } catch (NumberFormatException e) {
                    errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                            .dataJson(linksJson)
                            .errorMessage(String.format("prev link %s does not have page param", prev))
                    );
                }
            }
        }
    }

    private void checkNextLink(Integer page, List<ConformanceError> errors, Integer totalPages, String linksJson, String next) {
        if (page.equals(totalPages) && !StringUtils.isBlank(next)) {
            errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format("Next %s should be null as current page is the last page. See below:\n%s", next, linksJson))
            );
        } else if (page < totalPages && StringUtils.isBlank(next)) {
            errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format("Next %s should be not null as current page is not the last page. See below:\n%s", next, linksJson))
            );
        } else if (page < totalPages && !StringUtils.isBlank(next)) {
            Map<String, Object> nextLinkParams = extractParameters(next);
            String nextLinkPageParam = getParameter(nextLinkParams, "page");
            if (StringUtils.isBlank(nextLinkPageParam)) {
                errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format("next link %s does not have page param. See below:\n%s",
                                next, linksJson))
                );
            } else {
                try {
                    int nextLinkPage = Integer.parseInt(nextLinkPageParam);
                    if (nextLinkPage != page + 1 ) {
                        errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                                .errorMessage(String.format("next link %s have invalid page param %s. See below:\n%s",
                                        next, nextLinkPage, linksJson))
                        );
                    }
                } catch (NumberFormatException e) {
                    errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                            .dataJson(linksJson)
                            .errorMessage(String.format("next link %s does not have page param", next))
                    );
                }
            }
        }
    }


    private void checkSelfLink(String requestUrl, List<ConformanceError> errors, String linksJson, String self) {
        if (!requestUrl.equals(self)) {
            errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                .errorMessage(String.format("Self %s does not match request url %s. See below:\n%s",
                    self, requestUrl, linksJson))
            );
        }
    }

    private void checkLastLink(Integer page, Integer pageSize, List<ConformanceError> errors, Integer totalPages, String linksJson, String last) {
        if (StringUtils.isBlank(last) && totalPages != null && totalPages > 0) {
            errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                .errorMessage(String.format("last link data is missing given totalPages %d in meta. See below:\n%s",
                    totalPages, linksJson))
            );
        } else if (totalPages != null && totalPages == 0 && !StringUtils.isBlank(last)) {
            errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                .errorMessage(String.format("There should be no last link given totalPages %s in meta. See below:\n%s",
                    totalPages, linksJson))
            );
        } else if (!StringUtils.isBlank(last)) {
            Map<String, Object> lastLinkParams = extractParameters(last);
            String lastLinkPageParam = getParameter(lastLinkParams, "page");
            if (StringUtils.isBlank(lastLinkPageParam)) {
                errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format("last link %s does not have page param. See below:\n%s",
                        last, linksJson))
                );
            } else {
                try {
                    Integer lastLinkPage = Integer.parseInt(lastLinkPageParam);
                    if (lastLinkPage < page) {
                        errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                            .errorMessage(String.format("last link %s have invalid page param %s. See below:\n%s",
                                last, lastLinkPage, linksJson))
                        );
                    }
                } catch (NumberFormatException e) {
                    errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                        .dataJson(linksJson)
                        .errorMessage(String.format("last link %s does not have page param", last))
                    );
                }
            }
            String lastLinkPageSizeParam = getParameter(lastLinkParams, "page-size");
            if (!pageSize.toString().equals(lastLinkPageSizeParam)) {
                errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format("last link %s page-size param value %s does not match request page-size %s. See below:\n%s",
                        last, lastLinkPageSizeParam, pageSize, linksJson))
                );
            }
        }
    }

    private void checkFirstLink(Integer pageSize, List<ConformanceError> errors, Integer totalPages, String linksJson, String first) {
        if (StringUtils.isBlank(first) && totalPages != null && totalPages > 0) {
            errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                .errorMessage(String.format("first link data is missing given totalPages %d in meta. See below:\n%s",
                    totalPages, linksJson))
            );
        } else if (totalPages != null && totalPages == 0 && !StringUtils.isBlank(first)) {
            errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                .errorMessage(String.format("There should be no first link given totalPages %s in meta. See below:\n%s",
                    totalPages, linksJson))
            );
        } else if (!StringUtils.isBlank(first)) {
            Map<String, Object> firstLinkParams = extractParameters(first);
            String firstLinkPageParam = getParameter(firstLinkParams, "page");
            if (!"1".equals(firstLinkPageParam)) {
                errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format("first link %s does not have page param value as 1. See below:\n%s",
                        first, linksJson))
                );
            }
            String firstLinkPageSizeParam = getParameter(firstLinkParams, "page-size");
            if (!pageSize.toString().equals(firstLinkPageSizeParam)) {
                errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format("first link %s page-size param value %s does not match request page-size %s. See below:\n%s",
                        first, firstLinkPageSizeParam, pageSize, linksJson))
                );
            }
        }
    }

    private boolean isBaseResponse(Object meta, Object links) {
        if (meta == null && links == null) return false;
        return links != null && FieldUtils.getAllFields(links.getClass()).length == 1 ||
            meta != null && FieldUtils.getAllFields(meta.getClass()).length == 0;
    }

    private boolean isPaginatedResponse(Object meta, Object links) {
        if (meta == null && links == null) return false;
        return links != null && FieldUtils.getAllFields(links.getClass()).length == 5 ||
            meta != null && FieldUtils.getAllFields(meta.getClass()).length == 2;
    }

    private String getParameter(Map<String, Object> params, String paramName) {
        if (params == null || params.get(paramName) == null) return null;
        return params.get(paramName).toString();
    }

    private Integer getIntParameter(Map<String, Object> params, String paramName) {
        String s = getParameter(params, paramName);
        if (StringUtils.isBlank(s)) return null;
        return Integer.parseInt(s);
    }

    private Integer getPageParameter(Map<String, Object> params) {
        return getIntParameter(params, "page");
    }

    private Integer getPageSizeParameter(Map<String, Object> params) {
        return getIntParameter(params, "page-size");
    }

    private Map<String, Object> extractParameters(String url) {
        String[] parts = url.split("\\?");
        if (parts.length < 2) return null;
        String queryString = parts[1];
        Map<String, Object> params = new HashMap<>();
        String[] queryParams = queryString.split("&");
        for (String queryParam : queryParams) {
            String[] keyValue = queryParam.split("=");
            String key = keyValue[0];
            Object value = keyValue.length > 1 ? keyValue[1] : Boolean.TRUE;
            if (params.containsKey(key)) {
                if (params.get(key) instanceof List) {
                    ((List) params.get(key)).add(value);
                } else {
                    List<Object> valueList = new ArrayList<>();
                    valueList.add(params.get(key));
                    valueList.add(value);
                }
            } else {
                params.put(key, value);
            }
        }
        return params;
    }

    private Integer getTotalRecords(Object meta) {
        return getFieldValueAsInteger(meta, "totalRecords");
    }

    private Integer getTotalPages(Object meta) {
        return getFieldValueAsInteger(meta, "totalPages");
    }

    private String getFieldValueAsString(Object o, String fieldName) {
        Field field = FieldUtils.getField(o.getClass(), ConformanceUtil.getFieldName(o, fieldName), true);
        Object fieldValue = ReflectionUtils.getField(field, o);
        return fieldValue == null ? null : fieldValue.toString();
    }

    private Integer getFieldValueAsInteger(Object o, String fieldName) {
        String s = getFieldValueAsString(o, fieldName);
        return s == null ? null : Integer.parseInt(s);
    }

    private Object getLinks(Object response) {
        Field linksField = FieldUtils.getField(response.getClass(), ConformanceUtil.getFieldName(response, "links"), true);
        return ReflectionUtils.getField(linksField, response);
    }

    private Object getMeta(Object response) {
        Field metaField = FieldUtils.getField(response.getClass(), ConformanceUtil.getFieldName(response, "meta"), true);
        return ReflectionUtils.getField(metaField, response);
    }

    private void checkSelfLink(String requestUrl, Object response, List<ConformanceError> errors) {
        Field linksField = FieldUtils.getField(response.getClass(), ConformanceUtil.getFieldName(response, "links"), true);
        Object links = ReflectionUtils.getField(linksField, response);
        if (links != null) {
            String selfLink = getFieldValueAsString(links, "self");
            if (!requestUrl.equals(selfLink)) {
                errors.add(new ConformanceError().errorType(ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format("Self %s does not match original request url %s. See below:\n%s",
                        selfLink, requestUrl, ConformanceUtil.toJson(links)))
                );
            }
        }
    }
}
