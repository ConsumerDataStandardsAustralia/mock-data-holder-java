package au.org.consumerdatastandards.client;

import org.apache.commons.lang3.StringUtils;

public class ConformanceError {

    private String dataJson;

    private Type errorType;

    private String errorField;

    private String message;

    public ConformanceError dataJson(String dataJson) {
        this.dataJson = dataJson;
        return this;
    }

    public ConformanceError errorType(Type errorType) {
        this.errorType = errorType;
        return this;
    }

    public ConformanceError errorField(String errorField) {
        this.errorField = errorField;
        return this;
    }

    public ConformanceError errorMessage(String message) {
        this.message = message;
        return this;
    }

    public String getDescription() {
        switch (errorType) {
            case MISSING_VALUE:
                return String.format("Required field '%s' has null value in\n%s",
                        errorField, dataJson);
            case MISSING_PROPERTY:
                return String.format("Required field '%s' is missing in response", errorField);
            case BROKEN_CONSTRAINT:
            case REDUNDANT_VALUE:
                return String.format("%s.", message);
            default:
                if (!StringUtils.isBlank(message)) return message;
                else return "Unknown error";
        }
    }

    public enum Type {
        MISSING_HEADER,
        INCORRECT_HEADER_VALUE,
        MISSING_PROPERTY,
        MISSING_VALUE,
        REDUNDANT_VALUE,
        BROKEN_CONSTRAINT,
        DATA_NOT_MATCHING_CRITERIA
    }
}
