package au.org.consumerdatastandards.integration;

import au.org.consumerdatastandards.client.ApiClientFactory;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.CustomDataType;
import au.org.consumerdatastandards.client.Header;
import au.org.consumerdatastandards.integration.utils.ITClientOptions;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static au.org.consumerdatastandards.client.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;
import static au.org.consumerdatastandards.client.ConformanceError.Type.MISSING_HEADER;

public abstract class ITBase {
    protected static final String CONFORMANCE_ERRORS_FOUND = "Conformance errors found in response payload: ";

    private static final String APPLICATION_JSON = "application/json";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected ApiClientFactory clientFactory;

    public ITBase() throws IOException {
        clientFactory = new ApiClientFactory(new ITClientOptions());
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
        return contentType.startsWith(APPLICATION_JSON);
    }

    protected String retrieveHeader(List<String> headerPack) {
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
}
