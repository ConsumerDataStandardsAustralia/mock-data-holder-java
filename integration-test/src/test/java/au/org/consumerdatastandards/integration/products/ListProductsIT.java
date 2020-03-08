package au.org.consumerdatastandards.integration.products;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.api.BankingProductsAPI;
import au.org.consumerdatastandards.client.model.BankingProduct;
import au.org.consumerdatastandards.client.model.BankingProductCategory;
import au.org.consumerdatastandards.client.model.BankingProductV1;
import au.org.consumerdatastandards.client.model.BankingProductV2;
import au.org.consumerdatastandards.client.model.ResponseBankingProductList;
import au.org.consumerdatastandards.integration.utils.ApiUtil;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.CustomDataType;
import au.org.consumerdatastandards.client.Header;
import au.org.consumerdatastandards.integration.utils.ResponseCode;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static au.org.consumerdatastandards.client.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;
import static au.org.consumerdatastandards.client.ConformanceError.Type.MISSING_HEADER;

public class ListProductsIT {
    private static final String APPLICATION_JSON = "application/json";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final BankingProductsAPI api = new BankingProductsAPI();

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
        api.setApiClient(ApiUtil.createApiClient(getApiBasePath(), false));

        ApiResponse<ResponseBankingProductList<BankingProductV1>> resp = api.listProductsWithHttpInfo(effective, updatedSince, brand, productCategory, 1,  page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                "Conformance errors found in response payload: " + buildConformanceErrorsDescription(conformanceErrors));
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
        api.setApiClient(ApiUtil.createApiClient(getApiBasePath(), false));

        ApiResponse<ResponseBankingProductList<BankingProductV2>> resp = api.listProductsWithHttpInfo(effective, updatedSince, brand, productCategory, 2,  page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> errors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), errors);
        List<BankingProductV2> prods = resp.getData().getData().getProducts();
        if (prods != null) {
            for (BankingProductV2 bankingProduct : prods) {
                checkEffectiveDate(bankingProduct, effective, errors);
                checkUpdatedSince(bankingProduct, updatedSince, errors);
                checkBrand(bankingProduct, brand, errors);
                checkProductCategory(bankingProduct, productCategory, errors);
            }
        }
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

    protected String buildConformanceErrorsDescription(List<ConformanceError> conformanceErrors) {
        return conformanceErrors.stream().map(ConformanceError::getDescription).collect(Collectors.joining(System.lineSeparator()));
    }

    protected void dumpConformanceErrors(List<ConformanceError> conformanceErrors) {
        for (ConformanceError error : conformanceErrors) {
            logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            logger.error(error.getDescription());
        }
    }

    protected void checkResponseHeaders(Map<String, List<String>> headers, List<ConformanceError> conformanceErrors) {
        String version = retrieveHeader(headers.get(Header.VERSION.getKey()));
        if (StringUtils.isBlank(version)) {
            conformanceErrors.add(new ConformanceError().errorType(MISSING_HEADER)
                    .errorMessage("missing '" + Header.VERSION.getKey() + "' in response header"));
        } else {
            checkHeaderValue(version, Header.VERSION, conformanceErrors);
            String contentType = retrieveHeader(headers.get("content-type"));
            if (contentType == null) {
                conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage("missing content-type application/json in response header"));
            } else if (!isContentTypeValid(contentType)) {
                conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format("invalid content-type of %s specified", contentType)));
            }
        }
    }

    protected boolean isContentTypeValid(String contentType) {
        return contentType != null && contentType.startsWith(APPLICATION_JSON);
    }

    private String retrieveHeader(List<String> headerPack) {
        if (headerPack == null || headerPack.isEmpty()) {
            return null;
        }
        return headerPack.get(0);
    }

    public static void checkHeaderValue(String value, Header header, List<ConformanceError> errors) {
        CustomDataType customDataType = header.getCustomDataType();
        if (customDataType.getPattern() != null) {
            if (!value.matches(customDataType.getPattern())) {
                errors.add(new ConformanceError()
                        .errorType(ConformanceError.Type.INCORRECT_HEADER_VALUE)
                        .errorMessage(String.format("Header '%s' value '%s' does not conform to CDS type %s",
                                header.getKey(), value, header.getCustomDataType().getName()))
                );
            }
        }
        Number min = customDataType.getMin();
        if (min != null && new BigDecimal(min.toString()).compareTo(new BigDecimal(value)) > 0) {
            errors.add(new ConformanceError()
                    .errorType(ConformanceError.Type.INCORRECT_HEADER_VALUE)
                    .errorMessage(String.format("Header '%s' value %s is smaller than CDS type %s minimum value %s",
                            header.getKey(), value, header.getCustomDataType().getName(), header.getCustomDataType().getMin()))
            );
        }
        Number max = customDataType.getMax();
        if (max != null && new BigDecimal(max.toString()).compareTo(new BigDecimal(value)) < 0) {
            errors.add(new ConformanceError()
                    .errorType(ConformanceError.Type.INCORRECT_HEADER_VALUE)
                    .errorMessage(String.format("Header '%s' value %s is bigger than CDS type %s max value %s.",
                            header.getKey(), value, header.getCustomDataType().getName(), header.getCustomDataType().getMin()))
            );
        }
        if (CustomDataType.URI.equals(customDataType)) {
            try {
                new URI(value);
            } catch (URISyntaxException e) {
                errors.add(new ConformanceError()
                        .errorType(ConformanceError.Type.INCORRECT_HEADER_VALUE)
                        .errorMessage(String.format("Header '%s' value '%s' does not conform to CDS type %s",
                                header.getKey(), value, header.getCustomDataType().getName()))
                );
            }
        }
        switch (customDataType) {
            case URI:
                try {
                    new URI(value);
                } catch (URISyntaxException e) {
                    errors.add(new ConformanceError()
                            .errorType(ConformanceError.Type.INCORRECT_HEADER_VALUE)
                            .errorMessage(String.format("Header '%s' value '%s' does not conform to CDS type %s",
                                    header.getKey(), value, header.getCustomDataType().getName()))
                    );
                }
                break;
            case Base64:
                if (!Base64.isBase64(value)) {
                    errors.add(new ConformanceError()
                            .errorType(ConformanceError.Type.INCORRECT_HEADER_VALUE)
                            .errorMessage(String.format("Header '%s' value '%s' does not conform to CDS type %s",
                                    header.getKey(), value, header.getCustomDataType().getName()))
                    );
                }
                break;
            case UUID:
                try {
                    UUID.fromString(value);
                } catch (IllegalArgumentException e) {
                    errors.add(new ConformanceError()
                            .errorType(ConformanceError.Type.INCORRECT_HEADER_VALUE)
                            .errorMessage(String.format("Header '%s' value '%s' does not conform to CDS type %s",
                                    header.getKey(), value, header.getCustomDataType().getName()))
                    );
                }
                break;
        }
    }

    private String getApiBasePath() {
        return System.getProperty("apiBase", "http://localhost:8383/cds-au/v1");
    }
}
