package au.org.consumerdatastandards.conformance.products;

import au.org.consumerdatastandards.api.v1_1_1.banking.models.ParamProductCategory;
import au.org.consumerdatastandards.conformance.APIStepsBase;
import au.org.consumerdatastandards.conformance.ConformanceError;
import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.support.Header;
import au.org.consumerdatastandards.support.ResponseCode;
import au.org.consumerdatastandards.support.data.CustomDataType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.util.DateTime;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static au.org.consumerdatastandards.api.v1_0_0.banking.BankingProductsAPI.ParamEffective;
import static au.org.consumerdatastandards.conformance.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;
import static net.serenitybdd.rest.SerenityRest.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BankingProductsAPISteps extends APIStepsBase {

    private Response listProductsResponse;

    private Response getProductDetailResponse;

    private String requestUrl;

    private Object responseBankingProductList;

    private Class<?> responseBankingProductListClass;
    private Class<?> bankingProductClass;
    private Class<?> responseBankingProductByIdClass;
    private Class<?> responseBankingProductListDataClass;
    private int endpointVersion;

    @Step("Request /banking/products")
    void listProducts(String effective, String updatedSince, String brand, String productCategory, Integer page,
                      Integer pageSize) {
        String url = getApiBasePath() + "/banking/products";
        requestUrl = url;
        boolean paramAdded = false;
        RequestSpecification given = buildHeaders(given())
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("listProducts"));
        if (!StringUtils.isBlank(effective)) {
            given.queryParam("effective", effective);
            requestUrl += "?effective=" + effective;
            paramAdded = true;
        }
        if (!StringUtils.isBlank(updatedSince)) {
            given.queryParam("updated-since", updatedSince);
            requestUrl += (paramAdded ? "&" : "?") + "updated-since=" + updatedSince;
            paramAdded = true;
        }
        if (!StringUtils.isBlank(brand)) {
            given.queryParam("brand", brand);
            requestUrl += (paramAdded ? "&" : "?") + "brand=" + brand;
            paramAdded = true;
        }
        if (!StringUtils.isBlank(productCategory)) {
            given.queryParam("product-category", productCategory);
            requestUrl += (paramAdded ? "&" : "?") + "product-category=" + productCategory;
            paramAdded = true;
        }
        if (page != null) {
            given.queryParam("page", page);
            requestUrl += (paramAdded ? "&" : "?") + "page=" + page;
            paramAdded = true;
        }
        if (pageSize != null) {
            given.queryParam("page-size", pageSize);
            requestUrl += (paramAdded ? "&" : "?") + "page-size=" + pageSize;
        }

        listProductsResponse = given.when().get(url).then().log().all().extract().response();
        endpointVersion = getEndpointVersion(listProductsResponse);
        responseBankingProductListClass = getResponseBankingProductListClass(endpointVersion);
        responseBankingProductListDataClass = getResponseBankingProductListDataClass(endpointVersion);
        responseBankingProductByIdClass = getResponseBankingProductByIdClass(endpointVersion);
        bankingProductClass = getBankingProductClass(endpointVersion);
    }

    @Step("Validate /banking/products response")
    void validateListProductsResponse(String effective, String updatedSince, String brand, String productCategory,
                                      Integer page, Integer pageSize) {
        boolean paramsValid = validateListProductsParams(effective, updatedSince, productCategory, page, pageSize);
        int statusCode = listProductsResponse.statusCode();
        if (!paramsValid) {
            assertEquals(ResponseCode.BAD_REQUEST.getCode(), statusCode);
        } else {
            assertEquals(ResponseCode.OK.getCode(), statusCode);
            List<ConformanceError> conformanceErrors = new ArrayList<>();
            checkResponseHeaders(listProductsResponse, conformanceErrors);
            String contentType = listProductsResponse.contentType();
            if (contentType == null) {
                conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage("missing content-type application/json in response header"));
            } else if (!isContentTypeValid(contentType)) {
                conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format("invalid content-type of %s specified", contentType)));
            }
            String json = listProductsResponse.getBody().asString();
            ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
            try {
                responseBankingProductList = objectMapper.readValue(json, responseBankingProductListClass);
                conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseBankingProductList,
                        "listProducts", endpointVersion, statusCode));
                Object data = getProductListData(responseBankingProductList);
                List<Object> products = getProducts(data);
                if (products != null && !products.isEmpty()) {
                    for (Object bankingProduct : products) {
                        conformanceErrors.addAll(checkDataAgainstCriteria(bankingProduct, effective, updatedSince,
                                brand, productCategory));
                    }
                }

                dumpConformanceErrors(conformanceErrors);

                assertTrue("Conformance errors found in response payload:"
                        + buildConformanceErrorsDescription(conformanceErrors), conformanceErrors.isEmpty());
            } catch (IOException e) {
                fail(e.getMessage());
            }
        }
    }

    private Class<?> getResponseBankingProductListClass(int version) {
        switch (version) {
            case 1:
                return au.org.consumerdatastandards.api.v1_0_0.banking.models.ResponseBankingProductList.class;
            case 2:
                return au.org.consumerdatastandards.api.v1_1_1.banking.models.ResponseBankingProductList.class;
            default:
                throw new RuntimeException("Unknown version: " + version);
        }
    }

    private Class<?> getResponseBankingProductListDataClass(int version) {
        switch (version) {
            case 1:
                return au.org.consumerdatastandards.api.v1_0_0.banking.models.ResponseBankingProductListData.class;
            case 2:
                return au.org.consumerdatastandards.api.v1_1_1.banking.models.ResponseBankingProductListData.class;
            default:
                throw new RuntimeException("Unknown version: " + version);
        }
    }

    private Class<?> getResponseBankingProductByIdClass(int version) {
        switch (version) {
            case 1:
                return au.org.consumerdatastandards.api.v1_0_0.banking.models.ResponseBankingProductById.class;
            case 2:
                return au.org.consumerdatastandards.api.v1_1_1.banking.models.ResponseBankingProductById.class;
            default:
                throw new RuntimeException("Unknown version: " + version);
        }
    }

    private Class<?> getBankingProductClass(int version) {
        switch (version) {
            case 1:
                return au.org.consumerdatastandards.api.v1_0_0.banking.models.BankingProduct.class;
            case 2:
                return au.org.consumerdatastandards.api.v1_1_1.banking.models.BankingProductV2.class;
            default:
                throw new RuntimeException("Unknown version: " + version);
        }
    }


    private List<ConformanceError> checkDataAgainstCriteria(Object bankingProduct, String effective,
                                                            String updatedSince, String brand, String productCategory) {
        List<ConformanceError> errors = new ArrayList<>();
        checkEffectiveDate(bankingProduct, effective, errors);
        checkUpdatedSince(bankingProduct, updatedSince, errors);
        checkBrand(bankingProduct, brand, errors);
        checkProductCategory(bankingProduct, productCategory, errors);
        return errors;
    }

    private void checkProductCategory(Object bankingProduct, String productCategory,
                                      List<ConformanceError> errors) {
        if (!StringUtils.isBlank(productCategory)) {
            Object bankingProductCategory = getProductCategory(bankingProduct);
            if (bankingProductCategory == null || !getBankingProductCategoryName(bankingProductCategory).equals(productCategory)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(bankingProductClass, "productCategory", true))
                        .dataJson(ConformanceUtil.toJson(bankingProduct))
                        .errorMessage(String.format(
                                "BankingProduct productCategory %s does not match productCategory query %s",
                                bankingProductCategory, productCategory)));
            }
        }
    }

    private String getBankingProductCategoryName(Object bankingProductCategory) {
        return bankingProductCategory.toString();
    }

    private Object getProductCategory(Object bankingProduct) {
        Field dataField = FieldUtils.getField(bankingProduct.getClass(), "productCategory", true);
        return ReflectionUtils.getField(dataField, bankingProduct);
    }

    private void checkBrand(Object bankingProduct, String brand, List<ConformanceError> errors) {
        if (!StringUtils.isBlank(brand)) {
            String productBrand = getProductBrand(bankingProduct);
            if (StringUtils.isBlank(productBrand) || !productBrand.contains(brand)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(bankingProductClass, "effectiveFrom", true))
                        .dataJson(ConformanceUtil.toJson(bankingProduct)).errorMessage(String
                                .format("BankingProduct brand %s does not match brand query %s", productBrand, brand)));
            }
        }
    }

    private String getProductBrand(Object bankingProduct) {
        Field dataField = FieldUtils.getField(bankingProduct.getClass(), "brand", true);
        return (String) ReflectionUtils.getField(dataField, bankingProduct);
    }

    private void checkUpdatedSince(Object bankingProduct, String updatedSince, List<ConformanceError> errors) {
        if (!StringUtils.isBlank(updatedSince)) {
            long updatedSinceTime = DateTime.parseRfc3339(updatedSince).getValue();
            long lastUpdatedTime = getLastUpdatedTime(bankingProduct);
            if (updatedSinceTime > lastUpdatedTime) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(bankingProductClass, "effectiveFrom", true))
                        .dataJson(ConformanceUtil.toJson(bankingProduct))
                        .errorMessage(String.format("BankingProduct lastUpdated %s is before updatedSince %s",
                                lastUpdatedTime, updatedSinceTime)));
            }
        }
    }

    private long getLastUpdatedTime(Object bankingProduct) {
        return getDateTimeFieldValue(bankingProduct, "lastUpdated");
    }

    private long getDateTimeFieldValue(Object dataObject, String fieldName) {
        Field dataField = FieldUtils.getField(dataObject.getClass(), fieldName, true);
        Object fieldValue = ReflectionUtils.getField(dataField, dataObject);
        if (fieldValue instanceof String) {
            return DateTime.parseRfc3339((String)fieldValue).getValue();
        } else if (fieldValue instanceof OffsetDateTime) {
            return ((OffsetDateTime)fieldValue).toInstant().toEpochMilli();
        }
        return -1L;
    }

    private void checkEffectiveDate(Object bankingProduct, String effective, List<ConformanceError> errors) {
        long now = System.currentTimeMillis();
        long effectiveFromDate = getEffectiveFromDate(bankingProduct);
        long effectiveToDate = getEffectiveToDate(bankingProduct);
        if (StringUtils.isBlank(effective) || effective.equals(ParamEffective.CURRENT.name())) {
            if (effectiveFromDate > now) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(bankingProductClass, "effectiveFrom", true))
                        .dataJson(ConformanceUtil.toJson(bankingProduct))
                        .errorMessage(String.format("BankingProduct effectiveFrom %s is after current time %s",
                                new Date(effectiveFromDate), new Date(now))));
            }
            if (effectiveToDate > 0  && effectiveToDate < now) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(bankingProductClass, "effectiveTo", true))
                        .dataJson(ConformanceUtil.toJson(bankingProduct))
                        .errorMessage(String.format("BankingProduct effectiveTo %s is before current time %s",
                            new Date(effectiveToDate), new Date(now))));
            }
        }
        if (ParamEffective.FUTURE.name().equals(effective)) {
            if (effectiveFromDate <= now) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(bankingProductClass, "effectiveFrom", true))
                        .dataJson(ConformanceUtil.toJson(bankingProduct))
                        .errorMessage(String.format("BankingProduct effectiveFrom %s is not after current time %s",
                                new Date(effectiveFromDate), new Date(now))));
            }
        }
    }

    private long getEffectiveFromDate(Object bankingProduct) {
        return getDateTimeFieldValue(bankingProduct, "effectiveFrom");
    }

    private long getEffectiveToDate(Object bankingProduct) {
        return getDateTimeFieldValue(bankingProduct, "effectiveTo");
    }

    private boolean validateListProductsParams(String effective, String updatedSince, String productCategory,
                                               Integer page, Integer pageSize) {
        if (!StringUtils.isBlank(effective)) {
            try {
                ParamEffective.valueOf(effective);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        if (!StringUtils.isBlank(productCategory)) {
            try {
                ParamProductCategory.valueOf(productCategory);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        if (!StringUtils.isBlank(updatedSince)) {
            try {
                DateTime.parseRfc3339(updatedSince);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return (page == null || page >= 1) && (pageSize == null || pageSize >= 1);
    }

    private Object getProductListData(Object productList) {
        Field dataField = FieldUtils.getField(responseBankingProductListClass, "data", true);
        return ReflectionUtils.getField(dataField, productList);
    }

    @SuppressWarnings("unchecked")
    private List<Object> getProducts(Object productListData) {
        Field dataField = FieldUtils.getField(responseBankingProductListDataClass, "products", true);
        return (List<Object>) ReflectionUtils.getField(dataField, productListData);
    }

    List<String> getProductIds() {
        String json = listProductsResponse.getBody().asString();
        ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
        try {
            responseBankingProductList = objectMapper.readValue(json, responseBankingProductListClass);
            if (responseBankingProductList != null) {
                List<Object> products = getProducts(getProductListData(responseBankingProductList));
                if (products == null || products.isEmpty()) return null;
                List<String> productIds = new ArrayList<>();
                for (Object product : products) {
                    productIds.add(getProductId(product));
                }
                return productIds;
            }
        } catch (IOException e) {
            fail(e.getMessage());
        }
        return null;
    }

    @Step("Request /banking/products/{productId}")
    void getProductDetail(String productId) {
        String url = getApiBasePath() + "/banking/products/" + productId;
        requestUrl = url;
        getProductDetailResponse = buildHeaders(given())
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("getProductDetail"))
                .when().get(url).then().log().body().extract().response();
        endpointVersion = getEndpointVersion(getProductDetailResponse);
        responseBankingProductListClass = getResponseBankingProductListClass(endpointVersion);
        responseBankingProductListDataClass = getResponseBankingProductListDataClass(endpointVersion);
        responseBankingProductByIdClass = getResponseBankingProductByIdClass(endpointVersion);
        bankingProductClass = getBankingProductClass(endpointVersion);
    }

    @Step(value = "Validate /banking/products/{productId} response")
    void validateGetProductDetailResponse(String productId) {
        int statusCode = getProductDetailResponse.statusCode();
        if (!productId.matches(CustomDataType.ASCII.getPattern())) {
            assertEquals(ResponseCode.BAD_REQUEST.getCode(), statusCode);
        } else {
            assertTrue(statusCode == ResponseCode.OK.getCode() || statusCode == ResponseCode.NOT_FOUND.getCode());
            if (statusCode == ResponseCode.OK.getCode()) {
                List<ConformanceError> conformanceErrors = new ArrayList<>();
                checkResponseHeaders(getProductDetailResponse, conformanceErrors);
                checkJsonContentType(getProductDetailResponse.contentType(), conformanceErrors);
                String json = getProductDetailResponse.getBody().asString();
                ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
                try {
                    Class<?> expandedResponseClass = ConformanceUtil.expandModel(responseBankingProductByIdClass);
                    Object responseBankingProductById = objectMapper.readValue(json, expandedResponseClass);
                    conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseBankingProductById,
                            "getProductDetail", endpointVersion, statusCode));
                    Object data = getBankingProductDetail(responseBankingProductById);
                    String id = getProductId(data);
                    if (!id.equals(productId)) {
                        conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                                .dataJson(ConformanceUtil.toJson(responseBankingProductById)).errorMessage(String.format(
                                        "Response productId %s does not match request productId %s", id, productId)));
                    }

                    dumpConformanceErrors(conformanceErrors);

                    String message = "Conformance errors found in response payload: "
                            + buildConformanceErrorsDescription(conformanceErrors);
                    assertTrue(message, conformanceErrors.isEmpty());
                } catch (IOException e) {
                    fail(e.getMessage());
                }
            }
        }
    }

    private Object getBankingProductDetail(Object responseBankingProductById) {
        String dataFieldName = ConformanceUtil.getFieldName(responseBankingProductById, "data");
        Field dataField = FieldUtils.getField(responseBankingProductById.getClass(), dataFieldName, true);
        return ReflectionUtils.getField(dataField, responseBankingProductById);
    }

    private String getProductId(Object data) {
        String idFieldName = ConformanceUtil.getFieldName(data, "productId");
        Field idField = FieldUtils.getField(data.getClass(), idFieldName, true);
        return (String) ReflectionUtils.getField(idField, data);
    }
}
