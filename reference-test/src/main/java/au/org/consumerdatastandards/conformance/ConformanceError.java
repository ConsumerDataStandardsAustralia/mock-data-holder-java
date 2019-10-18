package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.CustomDataType;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

public class ConformanceError {

    private String dataJson;

    private Type errorType;

    private Field errorField;

    private Object errorFieldValue;

    private CDSDataType cdsDataType;

    private String message;

    public ConformanceError dataJson(String dataJson) {
        this.dataJson = dataJson;
        return this;
    }

    public ConformanceError errorType(Type errorType) {
        this.errorType = errorType;
        return this;
    }

    public ConformanceError errorField(Field errorField) {
        this.errorField = errorField;
        return this;
    }

    public ConformanceError errorFieldValue(Object errorFieldValue) {
        this.errorFieldValue = errorFieldValue;
        return this;
    }

    public ConformanceError cdsDataType(CDSDataType cdsDataType) {
        this.cdsDataType = cdsDataType;
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
                    errorField.getName().replace(ConformanceUtil.GENERATED_PROPERTY_PREFIX, ""), dataJson);
            case MISSING_PROPERTY:
                return String.format("Required field '%s' is missing in\n%s",
                    errorField.getName().replace(ConformanceUtil.GENERATED_PROPERTY_PREFIX, ""), dataJson);
            case PATTERN_NOT_MATCHED:
                CustomDataType customDataType = cdsDataType.value();
                return String.format("%s '%s' does not conform to CDS type %s. See below:\n%s",
                    errorField.getName().replace(ConformanceUtil.GENERATED_PROPERTY_PREFIX, ""),
                    errorFieldValue, customDataType.getName(), dataJson);
            case NUMBER_TOO_SMALL:
                CustomDataType customType = cdsDataType.value();
                return String.format("%s '%s' is smaller than CDS type %s minimum value %s. See below:\n%s",
                    errorField.getName().replace(ConformanceUtil.GENERATED_PROPERTY_PREFIX, ""),
                    errorFieldValue, customType.getName(), customType.getMin(), dataJson);
            case NUMBER_TOO_BIG:
                CustomDataType dataType = cdsDataType.value();
                return String.format("%s '%s' is bigger than CDS type %s max value %s. See below:\n%s",
                    errorField.getName().replace(ConformanceUtil.GENERATED_PROPERTY_PREFIX, ""),
                    errorFieldValue, dataType.getName(), dataType.getMax(), dataJson);
            case BROKEN_CONSTRAINT:
            case REDUNDANT_VALUE:
                return String.format("%s. See below:\n%s", message, dataJson);
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
        NO_MATCHING_MODEL,
        BROKEN_CONSTRAINT,
        PATTERN_NOT_MATCHED,
        NUMBER_TOO_SMALL,
        NUMBER_TOO_BIG,
        DATA_NOT_MATCHING_CRITERIA
    }
}
