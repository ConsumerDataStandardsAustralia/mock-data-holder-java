package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.banking.ErrorV2;
import au.org.consumerdatastandards.holder.model.LinksPaginated;
import au.org.consumerdatastandards.holder.model.MetaPaginated;
import au.org.consumerdatastandards.holder.model.banking.ResponseErrorListV2;
import au.org.consumerdatastandards.holder.model.TxMetaPaginated;
import au.org.consumerdatastandards.holder.util.WebUtil;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ApiControllerBase {
    protected final static UUID NO_INTERACTION_ID = UUID.randomUUID();

    private final static String V = "x-v";
    private final static String MIN_V = "x-min-v";
    private final static String CORRELATION_ID = "x-Correlation-Id";
    private final static String FAPI_INTERACTION_ID = "x-fapi-interaction-id";
    private final static String BASE64_PATTERN = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$";

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected Integer getPagingValue(Integer page, int defaultValue) {
        return page != null && page > 0 ? page : defaultValue;
    }

    protected void throwCDSUnprocessableErrors(UUID interactionId, List<ErrorV2> errorList) {
        throwCDSErrors(interactionId, errorList, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    protected void throwCDSErrors(UUID interactionId, List<ErrorV2> errorList, HttpStatus httpStatus) {
        ResponseErrorListV2 errors = new ResponseErrorListV2();
        errors.setErrors(errorList);
        MultiValueMap<String, String> headers;
        if (interactionId == NO_INTERACTION_ID) {
            headers = null;
        } else {
            headers = new HttpHeaders();
            headers.add("x-fapi-interaction-id", (interactionId == null ? UUID.randomUUID() : interactionId).toString());
        }
        throw new CDSException(errors, headers, httpStatus);
    }

    protected ErrorV2 createError(String title, String code, String detail) {
        ErrorV2 error = new ErrorV2();
        error.setTitle(title);
        error.setCode(code);
        error.setDetail(detail);
        return error;
    }

    protected void validatePageRange(Integer page, int totalPages, UUID interactionId) {
        if (totalPages > 0 && page != null && page > totalPages) {
            throwCDSUnprocessableErrors(interactionId, Collections.singletonList(
                    createError("Invalid Page", "urn:au-cds:error:cds-all:Field/InvalidPage", String.valueOf(totalPages))));
        }
    }

    protected void validatePageSize(Integer pageSize, UUID interactionId) {
        if (pageSize != null && pageSize > 1000) {
            String message = String.format(
                    "Invalid page size requested: %d. Page size has to be between 1 and 1000",
                    pageSize);
            throwCDSErrors(interactionId, Collections.singletonList(
                    createError("Invalid Page Size", "urn:au-cds:error:cds-all:Field/InvalidPageSize", message)),
                    HttpStatus.NOT_ACCEPTABLE);
        }
    }

    protected boolean hasSupportedVersion(Integer xMinV, Integer xV) {
        if (xV == null) return false;
        return (xMinV == null || getCurrentVersion() >= xMinV) && (xMinV != null || getCurrentVersion() >= xV);
    }

    protected Integer getSupportedVersion(Integer xMinV, Integer xV) {
        if (xMinV == null) return xV;
        return Math.min(xV, getCurrentVersion());
    }

    protected Integer getCurrentVersion() {
        return 3;
    }

    protected HttpHeaders generateResponseHeaders(NativeWebRequest request) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("content-type", "application/json");
        Integer xMinV = null;
        String minV = request.getHeader(MIN_V);
        if (StringUtils.hasText(minV)) {
            xMinV = Integer.parseInt(minV);
        }
        Integer xV = Integer.parseInt(Objects.requireNonNull(request.getHeader(V)));
        responseHeaders.set(V, "" + getSupportedVersion(xMinV, xV));
        String correlationId = request.getHeader(CORRELATION_ID);
        if (!StringUtils.isEmpty(correlationId)) {
            responseHeaders.set(CORRELATION_ID, correlationId);
        }
        String fapiInteractionId = request.getHeader(FAPI_INTERACTION_ID);
        if (!StringUtils.isEmpty(fapiInteractionId)) {
            responseHeaders.set(FAPI_INTERACTION_ID, fapiInteractionId);
        } else {
            responseHeaders.set(FAPI_INTERACTION_ID, UUID.randomUUID().toString());
        }
        return responseHeaders;
    }

    protected void validateSupportedVersion(Integer xMinV, Integer xV, UUID interactionId) {
        if (!hasSupportedVersion(xMinV, xV)) {
            String message = String.format(
                "Unsupported version requested, minimum version specified is %d, maximum version specified is %d, current version is %d",
                xMinV, xV, getCurrentVersion());
            ErrorV2 error = createError("Unsupported Version", "urn:au-cds:error:cds-all:Header/UnsupportedVersion", message);
            throwCDSErrors(interactionId, Collections.singletonList(error), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    protected void validateHeaders(String xCdsClientHeaders,
                                   String xFapiCustomerIpAddress,
                                   UUID interactionId,
                                   Integer xMinV, Integer xV) {
        validateSupportedVersion(xMinV, xV, interactionId);
        if (StringUtils.hasText(xFapiCustomerIpAddress)) {
            ArrayList<ErrorV2> errorList = new ArrayList<>();
            InetAddressValidator inetAddressValidator = InetAddressValidator.getInstance();
            if (!inetAddressValidator.isValid(xFapiCustomerIpAddress)) {
                errorList.add(createError("Invalid Header", "urn:au-cds:error:cds-all:Header/Invalid", "x-fapi-customer-ip-address: request header value is not a valid IP address"));
            }
            if (StringUtils.isEmpty(xCdsClientHeaders)) {
                errorList.add(createError("Missing Required Header", "urn:au-cds:error:cds-all:Header/Missing", "x-cds-client-headers: request header is not present"));
            } else if (!xCdsClientHeaders.matches(BASE64_PATTERN)) {
                errorList.add(createError("Invalid Header", "urn:au-cds:error:cds-all:Header/Invalid", "x-cds-client-headers: request header value is not Base64 encoded"));
            }
            if (!errorList.isEmpty()) {
                throwCDSErrors(interactionId, errorList, HttpStatus.BAD_REQUEST);
            }
        }
    }

    protected LinksPaginated getLinkData(NativeWebRequest request, @SuppressWarnings("rawtypes") Page page, Integer actualPage, Integer actualPageSize) {
        LinksPaginated linkData = new LinksPaginated();
        linkData.setSelf(WebUtil.getOriginalUrl(request));

        if (page.getTotalPages() == 0) {
            linkData.setFirst(null);
            linkData.setLast(null);
        } else {
            linkData.setFirst(WebUtil.getPaginatedLink(request, 1, actualPageSize));
            linkData.setLast(WebUtil.getPaginatedLink(request, page.getTotalPages(), actualPageSize));
        }

        if (page.hasPrevious()) {
            linkData.setPrev(WebUtil.getPaginatedLink(request, actualPage - 1, actualPageSize));
        }

        if (page.hasNext()) {
            linkData.setNext(WebUtil.getPaginatedLink(request, actualPage + 1, actualPageSize));
        }
        return linkData;
    }

    protected MetaPaginated getMetaData(@SuppressWarnings("rawtypes") Page page) {
        MetaPaginated metaData = new MetaPaginated();
        metaData.setTotalPages(page.getTotalPages());
        metaData.setTotalRecords((int)page.getTotalElements());
        return metaData;
    }

    protected TxMetaPaginated getTxMetaData(@SuppressWarnings("rawtypes") Page page, boolean isQueryParamUnsupported) {
        TxMetaPaginated metaData = new TxMetaPaginated();
        metaData.setTotalPages(page.getTotalPages());
        metaData.setTotalRecords((int)page.getTotalElements());
        metaData.setIsQueryParamUnsupported(isQueryParamUnsupported);
        return metaData;
    }
}
