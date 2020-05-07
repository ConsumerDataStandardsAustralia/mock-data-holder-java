package au.org.consumerdatastandards.integration;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.BankingProductsAPI;
import au.org.consumerdatastandards.client.model.BankingProduct;
import au.org.consumerdatastandards.client.model.BankingProductCategory;
import au.org.consumerdatastandards.client.model.BankingProductV1;
import au.org.consumerdatastandards.client.model.BankingProductV2;
import au.org.consumerdatastandards.client.model.ResponseBankingProductById;
import au.org.consumerdatastandards.client.model.ResponseBankingProductList;
import au.org.consumerdatastandards.integration.utils.ResponseCode;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static au.org.consumerdatastandards.client.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;

public class BankingProductsIT extends ITBase {
    private final BankingProductsAPI api = new BankingProductsAPI();

    public BankingProductsIT() throws ApiException, IOException {
        super();
        api.setApiClient(clientFactory.create(false, false));
    }

    @ParameterizedTest
    @CsvSource({
            "ALL,,,,,",
            "CURRENT,,,,,",
            "FUTURE,,,,,",
            "ALL,,,BUSINESS_LOANS,,",
            "ALL,,,,,20"
    })
    public void listProductsV1(BankingProductsAPI.ParamEffective effective, OffsetDateTime updatedSince, String brand,
                             BankingProductCategory productCategory, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<ResponseBankingProductList<BankingProductV1>> resp = api.listProductsWithHttpInfo(effective, updatedSince, brand, productCategory, 1,  page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        List<BankingProductV1> prods = resp.getData().getData().getProducts();
        if (prods != null) {
            for (BankingProductV1 bankingProduct : prods) {
                checkProducts(bankingProduct, effective, updatedSince, brand, productCategory, conformanceErrors);
            }
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @CsvSource({
            "ALL,,,,,",
            "CURRENT,,,,,",
            "FUTURE,,,,,",
            "ALL,,,BUSINESS_LOANS,,",
            "ALL,,,,,20"
    })
    public void listProductsV2(BankingProductsAPI.ParamEffective effective, OffsetDateTime updatedSince, String brand,
                             BankingProductCategory productCategory, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<ResponseBankingProductList<BankingProductV2>> resp = api.listProductsWithHttpInfo(effective, updatedSince, brand, productCategory, 2,  page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        List<BankingProductV2> prods = resp.getData().getData().getProducts();
        if (prods != null) {
            for (BankingProductV2 bankingProduct : prods) {
                checkProducts(bankingProduct, effective, updatedSince, brand, productCategory, conformanceErrors);
            }
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void getProductDetail(Integer version) throws ApiException {
        List<ConformanceError> conformanceErrors = new ArrayList<>();

        ResponseBankingProductList<BankingProduct> prods = api.listProducts(null, null, null, null, version, null, 50);
        for (BankingProduct prod : prods.getData().getProducts()) {
            ApiResponse<ResponseBankingProductById> resp = api.getProductDetailWithHttpInfo(prod.getProductId(), version);
            Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
            checkResponseHeaders(resp.getHeaders(), conformanceErrors);
            Assertions.assertEquals(prod.getProductId(), resp.getData().getData().getProductId());
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    private void checkProducts(BankingProduct bankingProduct, BankingProductsAPI.ParamEffective effective, OffsetDateTime updatedSince, String brand, BankingProductCategory productCategory, List<ConformanceError> errors) {
        checkEffectiveDate(bankingProduct, effective, errors);
        checkUpdatedSince(bankingProduct, updatedSince, errors);
        checkBrand(bankingProduct, brand, errors);
        checkProductCategory(bankingProduct, productCategory, errors);
    }

    private void checkEffectiveDate(BankingProduct bankingProduct, BankingProductsAPI.ParamEffective effective, List<ConformanceError> errors) {
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime effectiveFromDate = bankingProduct.getEffectiveFrom();
        OffsetDateTime effectiveToDate = bankingProduct.getEffectiveTo();
        if (effective == null || effective == BankingProductsAPI.ParamEffective.CURRENT) {
            if (effectiveFromDate != null && effectiveFromDate.isAfter(now)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format("BankingProduct effectiveFrom %s is after current time %s",
                                effectiveFromDate, now)));
            }
            if (effectiveToDate != null && effectiveToDate.isBefore(now)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format("BankingProduct effectiveTo %s is before current time %s",
                                effectiveToDate, now)));
            }
        } else if (effective == BankingProductsAPI.ParamEffective.FUTURE) {
            if (effectiveFromDate != null && !effectiveFromDate.isAfter(now)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format("BankingProduct effectiveFrom %s is not after current time %s",
                                effectiveFromDate, now)));
            }
        }
    }

    private void checkUpdatedSince(BankingProduct bankingProduct, OffsetDateTime updatedSince, List<ConformanceError> errors) {
        if (updatedSince != null) {
            OffsetDateTime lastUpdatedTime = bankingProduct.getLastUpdated();
            if (updatedSince.isAfter(lastUpdatedTime)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format("BankingProduct lastUpdated %s is before updatedSince %s",
                                lastUpdatedTime, updatedSince)));
            }
        }
    }

    private void checkBrand(BankingProduct bankingProduct, String brand, List<ConformanceError> errors) {
        if (!StringUtils.isBlank(brand)) {
            String productBrand = bankingProduct.getBrand();
            if (StringUtils.isBlank(productBrand) || !productBrand.contains(brand)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format("BankingProduct brand %s does not match brand query %s",
                                productBrand, brand)));
            }
        }
    }

    private void checkProductCategory(BankingProduct bankingProduct, BankingProductCategory productCategory, List<ConformanceError> errors) {
        if (productCategory != null) {
            BankingProductCategory bankingProductCategory = bankingProduct.getProductCategory();
            if (bankingProductCategory == null || bankingProductCategory != productCategory) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format(
                                "BankingProduct productCategory %s does not match productCategory query %s",
                                bankingProductCategory, productCategory)));
            }
        }
    }
}
