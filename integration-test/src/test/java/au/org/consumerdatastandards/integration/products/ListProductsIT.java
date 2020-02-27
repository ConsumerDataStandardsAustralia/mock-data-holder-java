package au.org.consumerdatastandards.integration.products;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.api.BankingProductsAPI;
import au.org.consumerdatastandards.client.model.ParamProductCategory;
import au.org.consumerdatastandards.client.model.ResponseBankingProductList;
import au.org.consumerdatastandards.integration.utils.ApiUtil;
import au.org.consumerdatastandards.integration.utils.ConformanceError;
import au.org.consumerdatastandards.integration.utils.CustomDataType;
import au.org.consumerdatastandards.integration.utils.Header;
import au.org.consumerdatastandards.integration.utils.ResponseCode;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static au.org.consumerdatastandards.integration.utils.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;
import static au.org.consumerdatastandards.integration.utils.ConformanceError.Type.MISSING_HEADER;

public class ListProductsIT {
    private static final String APPLICATION_JSON = "application/json";

    private final BankingProductsAPI api = new BankingProductsAPI();

    @ParameterizedTest
    @CsvSource({
            "ALL,,,,,",
            "CURRENT,,,,,",
            "FUTURE,,,,,",
            "ALL,,,BUSINESS_LOANS,,",
            "ALL,,,,,20"
    })
    public void listProducts(BankingProductsAPI.ParamEffective effective, OffsetDateTime updatedSince, String brand,
                             ParamProductCategory productCategory, Integer page, Integer pageSize) throws ApiException {
        api.setApiClient(ApiUtil.createApiClient(getApiBasePath(), false));

        ApiResponse<ResponseBankingProductList> resp = api.listProductsWithHttpInfo(effective, updatedSince, brand, productCategory, 1,  page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
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
