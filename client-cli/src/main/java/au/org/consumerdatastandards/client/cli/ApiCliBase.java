package au.org.consumerdatastandards.client.cli;

import au.org.consumerdatastandards.conformance.ConformanceError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ApiCliBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiCliBase.class);

    protected void logConformanceErrors(List<ConformanceError> conformanceErrors) {
        if (conformanceErrors != null) {
            if (conformanceErrors.isEmpty()) {
                LOGGER.info("Received zero conformance errors for listProductsCall");
            } else {
                LOGGER.warn("Received {} conformance errors for listProductsCall", conformanceErrors.size());
                for (ConformanceError conformanceError : conformanceErrors) {
                    LOGGER.warn("Conformance Error: {}", conformanceError.getDescription());
                }
                LOGGER.info("Found a total of {} conformance errors", conformanceErrors.size());
            }
        }
    }
}
