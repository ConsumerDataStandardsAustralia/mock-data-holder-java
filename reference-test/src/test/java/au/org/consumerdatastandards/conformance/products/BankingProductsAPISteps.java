package au.org.consumerdatastandards.conformance.products;

import au.org.consumerdatastandards.api.banking.models.BankingProduct;
import au.org.consumerdatastandards.api.banking.models.BankingProductCategory;
import au.org.consumerdatastandards.api.banking.models.ParamProductCategory;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingProductById;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingProductList;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingProductListData;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static au.org.consumerdatastandards.api.banking.BankingProductsAPI.ParamEffective;
import static au.org.consumerdatastandards.conformance.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;
import static net.serenitybdd.rest.SerenityRest.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BankingProductsAPISteps extends APIStepsBase {

    private Response listProductsResponse;

    private Response getProductDetailResponse;

    private String requestUrl;

    private ResponseBankingProductList responseBankingProductList;

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
                responseBankingProductList = objectMapper.readValue(json, ResponseBankingProductList.class);
                conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseBankingProductList,
                        "listProducts", statusCode));
                ResponseBankingProductListData data = getProductListData(responseBankingProductList);
                List<BankingProduct> products = getProducts(data);
                if (products != null && !products.isEmpty()) {
                    for (BankingProduct bankingProduct : products) {
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

    private List<ConformanceError> checkDataAgainstCriteria(BankingProduct bankingProduct, String effective,
                                                            String updatedSince, String brand, String productCategory) {
        List<ConformanceError> errors = new ArrayList<>();
        checkEffectiveDate(bankingProduct, effective, errors);
        checkUpdatedSince(bankingProduct, updatedSince, errors);
        checkBrand(bankingProduct, brand, errors);
        checkProductCategory(bankingProduct, productCategory, errors);
        return errors;
    }

    private void checkProductCategory(BankingProduct bankingProduct, String productCategory,
                                      List<ConformanceError> errors) {
        if (!StringUtils.isBlank(productCategory)) {
            BankingProductCategory bankingProductCategory = getProductCategory(bankingProduct);
            if (bankingProductCategory == null || !bankingProductCategory.name().equals(productCategory)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingProduct.class, "productCategory", true))
                        .dataJson(ConformanceUtil.toJson(bankingProduct))
                        .errorMessage(String.format(
                                "BankingProduct productCategory %s does not match productCategory query %s",
                                bankingProductCategory, productCategory)));
            }
        }
    }

    private BankingProductCategory getProductCategory(BankingProduct bankingProduct) {
        Field dataField = FieldUtils.getField(bankingProduct.getClass(), "productCategory", true);
        return (BankingProductCategory) ReflectionUtils.getField(dataField, bankingProduct);
    }

    private void checkBrand(BankingProduct bankingProduct, String brand, List<ConformanceError> errors) {
        if (!StringUtils.isBlank(brand)) {
            String productBrand = getProductBrand(bankingProduct);
            if (StringUtils.isBlank(productBrand) || !productBrand.contains(brand)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingProduct.class, "effectiveFrom", true))
                        .dataJson(ConformanceUtil.toJson(bankingProduct)).errorMessage(String
                                .format("BankingProduct brand %s does not match brand query %s", productBrand, brand)));
            }
        }
    }

    private String getProductBrand(BankingProduct bankingProduct) {
        Field dataField = FieldUtils.getField(bankingProduct.getClass(), "brand", true);
        return (String) ReflectionUtils.getField(dataField, bankingProduct);
    }

    private void checkUpdatedSince(BankingProduct bankingProduct, String updatedSince, List<ConformanceError> errors) {
        if (!StringUtils.isBlank(updatedSince)) {
            DateTime updatedSinceTime = DateTime.parseRfc3339(updatedSince);
            DateTime lastUpdatedTime = getLastUpdatedTime(bankingProduct);
            if (updatedSinceTime.getValue() > lastUpdatedTime.getValue()) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingProduct.class, "effectiveFrom", true))
                        .dataJson(ConformanceUtil.toJson(bankingProduct))
                        .errorMessage(String.format("BankingProduct lastUpdated %s is before updatedSince %s",
                                lastUpdatedTime, updatedSinceTime)));
            }
        }
    }

    private DateTime getLastUpdatedTime(BankingProduct bankingProduct) {
        return getDateTimeFieldValue(bankingProduct, "lastUpdated");
    }

    private DateTime getDateTimeFieldValue(Object dataObject, String fieldName) {
        Field dataField = FieldUtils.getField(dataObject.getClass(), fieldName, true);
        String fieldValue = (String) ReflectionUtils.getField(dataField, dataObject);
        if (StringUtils.isBlank(fieldValue))
            return null;
        return DateTime.parseRfc3339(fieldValue);
    }

    private void checkEffectiveDate(BankingProduct bankingProduct, String effective, List<ConformanceError> errors) {
        long now = System.currentTimeMillis();
        DateTime effectiveFromDate = getEffectiveFromDate(bankingProduct);
        DateTime effectiveToDate = getEffectiveToDate(bankingProduct);
        if (StringUtils.isBlank(effective) || effective.equals(ParamEffective.CURRENT.name())) {
            if (effectiveFromDate != null && effectiveFromDate.getValue() > now) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingProduct.class, "effectiveFrom", true))
                        .dataJson(ConformanceUtil.toJson(bankingProduct))
                        .errorMessage(String.format("BankingProduct effectiveFrom %s is after current time %s",
                                effectiveFromDate, new Date(now))));
            }
            if (effectiveToDate != null && effectiveToDate.getValue() < now) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingProduct.class, "effectiveTo", true))
                        .dataJson(ConformanceUtil.toJson(bankingProduct))
                        .errorMessage(String.format("BankingProduct effectiveTo %s is before current time %s",
                                effectiveFromDate, new Date(now))));
            }
        }
        if (ParamEffective.FUTURE.name().equals(effective)) {
            if (effectiveFromDate == null || effectiveFromDate.getValue() <= now) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingProduct.class, "effectiveFrom", true))
                        .dataJson(ConformanceUtil.toJson(bankingProduct))
                        .errorMessage(String.format("BankingProduct effectiveFrom %s is not after current time %s",
                                effectiveFromDate, new Date(now))));
            }
        }
    }

    private DateTime getEffectiveFromDate(BankingProduct bankingProduct) {
        return getDateTimeFieldValue(bankingProduct, "effectiveFrom");
    }

    private DateTime getEffectiveToDate(BankingProduct bankingProduct) {
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

    private ResponseBankingProductListData getProductListData(ResponseBankingProductList productList) {
        Field dataField = FieldUtils.getField(ResponseBankingProductList.class, "data", true);
        return (ResponseBankingProductListData) ReflectionUtils.getField(dataField, productList);
    }

    @SuppressWarnings("unchecked")
    private List<BankingProduct> getProducts(ResponseBankingProductListData productListData) {
        Field dataField = FieldUtils.getField(ResponseBankingProductListData.class, "products", true);
        return (List<BankingProduct>) ReflectionUtils.getField(dataField, productListData);
    }

    List<String> getProductIds() {
        String json = listProductsResponse.getBody().asString();
        ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
        try {
            responseBankingProductList = objectMapper.readValue(json, ResponseBankingProductList.class);
            if (responseBankingProductList != null) {
                List<BankingProduct> products = getProducts(getProductListData(responseBankingProductList));
                if (products == null || products.isEmpty()) return null;
                List<String> productIds = new ArrayList<>();
                for (BankingProduct product : products) {
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
                    Class<?> expandedResponseClass = ConformanceUtil.expandModel(ResponseBankingProductById.class);
                    Object responseBankingProductById = objectMapper.readValue(json, expandedResponseClass);
                    conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseBankingProductById,
                            "getProductDetail", statusCode));
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
