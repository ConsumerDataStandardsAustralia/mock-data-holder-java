package au.org.consumerdatastandards.conformance.util;

import au.org.consumerdatastandards.conformance.CglibBeanDeserializerModifier;
import au.org.consumerdatastandards.conformance.CglibBeanSerializerModifier;
import au.org.consumerdatastandards.conformance.ConformanceError;
import au.org.consumerdatastandards.conformance.validator.ModelValidator;
import au.org.consumerdatastandards.conformance.validator.ModelValidatorRegistry;
import au.org.consumerdatastandards.reflection.ReflectionUtil;
import au.org.consumerdatastandards.support.Header;
import au.org.consumerdatastandards.support.data.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import net.sf.cglib.beans.BeanGenerator;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;


public class ConformanceUtil {

    public static final String GENERATED_CLASS_SUFFIX = "$ByCDS";
    public static final String GENERATED_PROPERTY_PREFIX = "$cglib_prop_";

    public static void checkAgainstModel(Object data, Class<?> model, List<ConformanceError> errors) {
        String[] anyOfProperties = getAnyOfProperties(model);
        if (anyOfProperties != null && anyOfProperties.length > 1) {
            Map<String, Object> propertyValues = getPropertyValues(data, anyOfProperties);
            if (propertyValues.isEmpty()) {
                errors.add(new ConformanceError()
                    .errorType(ConformanceError.Type.BROKEN_CONSTRAINT)
                    .dataJson(toJson(data))
                    .errorMessage(buildAnyOfErrorMessage(anyOfProperties))
                );
            }
        }
        List<Field> properties = getAllProperties(model);
        Map<String, Field> propertyMap = buildPropertyMap(properties);
        for (Field modelField : properties) {
            Object dataFieldValue = getDataFieldValue(data, modelField.getName());
            Property property = modelField.getAnnotation(Property.class);
            if (property.required() && dataFieldValue == null) {
                errors.add(new ConformanceError()
                    .errorType(ConformanceError.Type.MISSING_VALUE)
                    .dataJson(toJson(data))
                    .errorField(modelField));
            } else if (dataFieldValue != null && modelField.isAnnotationPresent(CDSDataType.class)) {
                CDSDataType cdsDataType = modelField.getAnnotation(CDSDataType.class);
                checkAgainstCDSDataType(data, modelField, dataFieldValue, cdsDataType, errors);
            }
            Condition[] requiredIfConditions = property.requiredIf();
            if (requiredIfConditions.length > 0) {
                Condition condition = requiredIfConditions[0];
                Field relatedProperty = propertyMap.get(condition.propertyName());
                if (relatedProperty != null) {
                    Object relatedPropertyValue = getDataFieldValue(data, relatedProperty.getName());
                    boolean conditionsMet = isValueSpecified(relatedPropertyValue, condition.values());
                    if (conditionsMet && dataFieldValue == null) {
                        errors.add(new ConformanceError()
                            .errorType(ConformanceError.Type.MISSING_VALUE)
                            .dataJson(toJson(data))
                            .errorField(modelField)
                            .errorMessage(String.format("%s is required given %s value is %s",
                                modelField.getName(), relatedProperty.getName(), relatedPropertyValue)));
                    } else if (conditionsMet) {
                        CDSDataType requiredCDSDataType = null;
                        ConditionalCDSDataType[] conditionalCDSDataTypes = condition.conditionalCDSDataTypes();
                        if (conditionalCDSDataTypes.length > 0) {
                            for (ConditionalCDSDataType conditionalCDSDataType : conditionalCDSDataTypes) {
                                if (conditionalCDSDataType.value().equals("" + relatedPropertyValue)) {
                                    requiredCDSDataType = conditionalCDSDataType.cdsDataType();
                                }
                            }
                        }
                        if (requiredCDSDataType != null) {
                            checkAgainstCDSDataType(data, modelField, dataFieldValue, requiredCDSDataType, errors);
                        }
                    }
                }
            }
            Condition[] nullIfConditions = property.nullIf();
            if (nullIfConditions.length > 0) {
                Condition condition = nullIfConditions[0];
                Field relatedProperty = propertyMap.get(condition.propertyName());
                if (relatedProperty != null) {
                    Object relatedPropertyValue = getDataFieldValue(data, relatedProperty.getName());
                    boolean conditionsMet = isValueSpecified(relatedPropertyValue, condition.values());
                    if (conditionsMet && dataFieldValue != null) {
                        errors.add(new ConformanceError()
                            .errorType(ConformanceError.Type.REDUNDANT_VALUE)
                            .dataJson(toJson(data))
                            .errorField(modelField)
                            .errorMessage(String.format("%s should be null given %s value is %s",
                                modelField.getName(), relatedProperty.getName(), relatedPropertyValue)));
                    }
                }
            }
            Class<?> modelFieldType = modelField.getType();
            if (modelFieldType.isArray()) {
                if (modelFieldType.getComponentType().isAnnotationPresent(DataDefinition.class)
                    && dataFieldValue != null
                    && Array.getLength(dataFieldValue) > 0) {
                    Object[] values = ReflectionUtil.unpack(dataFieldValue);
                    for (Object value : values) {
                        checkAgainstModel(value, modelFieldType.getComponentType(), errors);
                    }
                }
            } else if (ReflectionUtil.isSetOrList(modelFieldType)) {
                Class<?> itemType = ReflectionUtil.getItemType(modelFieldType, modelField.getGenericType());
                if (itemType.isAnnotationPresent(DataDefinition.class)
                    && dataFieldValue != null) {
                    if (dataFieldValue.getClass().isArray()) {
                        Object[] values = ReflectionUtil.unpack(dataFieldValue);
                        for (Object value : values) {
                            checkAgainstModel(value, itemType, errors);
                        }
                    } else {
                        for (Object value : (Collection) dataFieldValue) {
                            checkAgainstModel(value, itemType, errors);
                        }
                    }
                }
            }
            if (dataFieldValue != null && modelFieldType.isAnnotationPresent(DataDefinition.class)) {
                checkAgainstModel(dataFieldValue, modelFieldType, errors);
            }
        }
        String modelName = model.getSimpleName().replace(GENERATED_CLASS_SUFFIX, "");
        ModelValidator validator = ModelValidatorRegistry.getModelValidator(modelName);
        if (validator != null) {
            errors.addAll(validator.validate(data));
        }
    }

    public static ObjectMapper createObjectMapper() {
        return new ObjectMapper().registerModule(new ParameterNamesModule())
            .registerModule(new Jdk8Module()).registerModule(new JavaTimeModule())
            .registerModule(new SimpleModule().setDeserializerModifier(new CglibBeanDeserializerModifier()))
            .registerModule(new SimpleModule().setSerializerModifier(new CglibBeanSerializerModifier()))
            .setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE)
            .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
            .configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true)
            .configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true)
            .setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private static boolean isValueSpecified(Object relatedPropertyValue, String[] values) {
        if (relatedPropertyValue == null) return false;
        for (String value : values) {
            if (value.equals(relatedPropertyValue.toString())) {
                return true;
            }
        }
        return false;
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

    private static void checkAgainstCDSDataType(Object data, Field modelField, Object dataFieldValue, CDSDataType cdsDataType, List<ConformanceError> errors) {
        CustomDataType customDataType = cdsDataType.value();
        if (customDataType.getPattern() != null) {
            if (!dataFieldValue.toString().matches(customDataType.getPattern())) {
                errors.add(new ConformanceError()
                    .errorType(ConformanceError.Type.PATTERN_NOT_MATCHED)
                    .cdsDataType(cdsDataType)
                    .dataJson(toJson(data))
                    .errorField(modelField)
                    .errorFieldValue(dataFieldValue)
                );
            }
        }
        Number min = customDataType.getMin();
        if (min != null) {
            if (!NumberUtils.isParsable(dataFieldValue.toString())) {
                errors.add(new ConformanceError()
                    .errorType(ConformanceError.Type.PATTERN_NOT_MATCHED)
                    .cdsDataType(cdsDataType)
                    .dataJson(toJson(data))
                    .errorField(modelField)
                    .errorFieldValue(dataFieldValue)
                );
            } else if (new BigDecimal(min.toString()).compareTo(new BigDecimal(dataFieldValue.toString())) > 0) {
                errors.add(new ConformanceError()
                    .errorType(ConformanceError.Type.NUMBER_TOO_SMALL)
                    .cdsDataType(cdsDataType)
                    .dataJson(toJson(data))
                    .errorField(modelField)
                    .errorFieldValue(dataFieldValue)
                );
            }
        }
        Number max = customDataType.getMax();
        if (max != null) {
            if (!NumberUtils.isParsable(dataFieldValue.toString())) {
                errors.add(new ConformanceError()
                    .errorType(ConformanceError.Type.PATTERN_NOT_MATCHED)
                    .cdsDataType(cdsDataType)
                    .dataJson(toJson(data))
                    .errorField(modelField)
                    .errorFieldValue(dataFieldValue)
                );
            } else if (new BigDecimal(max.toString()).compareTo(new BigDecimal(dataFieldValue.toString())) < 0) {
                errors.add(new ConformanceError()
                    .errorType(ConformanceError.Type.NUMBER_TOO_BIG)
                    .cdsDataType(cdsDataType)
                    .dataJson(toJson(data))
                    .errorField(modelField)
                    .errorFieldValue(dataFieldValue)
                );
            }
        }
        switch (customDataType) {
            case URI:
                try {
                    new URI(dataFieldValue.toString());
                } catch (URISyntaxException e) {
                    errors.add(new ConformanceError()
                        .errorType(ConformanceError.Type.PATTERN_NOT_MATCHED)
                        .cdsDataType(cdsDataType)
                        .dataJson(toJson(data))
                        .errorField(modelField)
                        .errorFieldValue(dataFieldValue)
                    );
                }
                break;
            case Base64:
                if (!Base64.isBase64(dataFieldValue.toString())) {
                    errors.add(new ConformanceError()
                        .errorType(ConformanceError.Type.PATTERN_NOT_MATCHED)
                        .cdsDataType(cdsDataType)
                        .dataJson(toJson(data))
                        .errorField(modelField)
                        .errorFieldValue(dataFieldValue)
                    );
                }
                break;
            case UUID:
                try {
                    UUID.fromString(dataFieldValue.toString());
                } catch (IllegalArgumentException e) {
                    errors.add(new ConformanceError()
                        .errorType(ConformanceError.Type.PATTERN_NOT_MATCHED)
                        .cdsDataType(cdsDataType)
                        .dataJson(toJson(data))
                        .errorField(modelField)
                        .errorFieldValue(dataFieldValue)
                    );
                }
                break;
        }
    }

    private static String buildAnyOfErrorMessage(String[] anyOfProperties) {
        StringBuilder sb = new StringBuilder("At least one of the [");
        for (int i = 0; i < anyOfProperties.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(anyOfProperties[i]);
        }
        sb.append("] properties should have value, but none of them have values");
        return sb.toString();
    }

    private static List<Field> getAllProperties(Class<?> model) {
        List<Field> properties = FieldUtils.getFieldsListWithAnnotation(model, Property.class);
        DataDefinition dataDefinition = model.getAnnotation(DataDefinition.class);
        if (dataDefinition != null && dataDefinition.allOf().length > 0) {
            for (Class<?> clazz : dataDefinition.allOf()) {
                properties.addAll(FieldUtils.getFieldsListWithAnnotation(clazz, Property.class));
            }
        }
        return properties;
    }

    private static Map<String, Field> buildPropertyMap(List<Field> properties) {
        Map<String, Field> map = new HashMap<>();
        properties.forEach(p -> map.put(p.getName(), p));
        return map;
    }

    private static String[] getAnyOfProperties(Class<?> model) {
        DataDefinition dataDefinition = model.getAnnotation(DataDefinition.class);
        if (dataDefinition != null) {
            return dataDefinition.anyOf();
        }
        return null;
    }

    private static Map<String, Object> getPropertyValues(Object data, String[] properties) {
        Map<String, Object> values = new HashMap<>();
        for (String property : properties) {
            Object value = getDataFieldValue(data, property);
            if (value != null) {
                values.put(property, value);
            }
        }
        return values;
    }

    public static Object getDataFieldValue(Object data, String fieldName) {
        if (isGeneratedClass(data.getClass()) && !fieldName.startsWith(GENERATED_PROPERTY_PREFIX)) {
            fieldName = GENERATED_PROPERTY_PREFIX + fieldName;
        }
        Field dataField = FieldUtils.getField(data.getClass(), fieldName, true);
        Object dataFieldValue;
        try {
            dataFieldValue = dataField.get(data);
        } catch (IllegalAccessException e) {
            throw new Error(e); // should never happen
        }
        return dataFieldValue;
    }

    private static boolean isGeneratedClass(Class<?> clazz) {
        return clazz.getSimpleName().endsWith(GENERATED_CLASS_SUFFIX);
    }

    public static Class<?> expandModel(Class<?> modelClass) {
        if (allOfExists(modelClass)) {
            DataDefinition dataDefinition = modelClass.getAnnotation(DataDefinition.class);
            if (dataDefinition != null && dataDefinition.allOf().length > 0) {
                return ConformanceUtil.combine(modelClass, dataDefinition.allOf());
            } else {
                final BeanGenerator beanGenerator = new BeanGenerator();
                beanGenerator.setNamingPolicy((s, s1, o, predicate) -> modelClass.getName() + GENERATED_CLASS_SUFFIX);
                addProperties(beanGenerator, modelClass);
                return (Class<?>) beanGenerator.createClass();
            }
        } else {
            return modelClass;
        }
    }

    private static Class<?> combine(Class<?> primaryClass, Class<?>[] allOf) {
        final BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.setNamingPolicy((s, s1, o, predicate) -> primaryClass.getName() + GENERATED_CLASS_SUFFIX);
        addProperties(beanGenerator, primaryClass);
        for (Class<?> clazz : allOf) {
            addProperties(beanGenerator, clazz);
        }
        return (Class<?>) beanGenerator.createClass();
    }

    private static boolean allOfExists(Class<?> modelClass) {
        if (modelClass.isEnum() || !ReflectionUtil.isCDSModel(modelClass)) return false;
        DataDefinition dataDefinition = modelClass.getAnnotation(DataDefinition.class);
        if (dataDefinition != null && dataDefinition.allOf().length > 0) {
            return true;
        }
        Field[] allFields = FieldUtils.getAllFields(modelClass);
        for (Field field : allFields) {
            if (ReflectionUtil.isSetOrList(field.getType())) {
                Class<?> itemType = ReflectionUtil.getItemType(field.getType(), field.getGenericType());
                if (allOfExists(itemType)) return true;
            } else if (allOfExists(field.getType())) {
                return true;
            }
        }
        return false;
    }

    private static void addProperties(BeanGenerator beanGenerator, Class<?> clazz) {
        Field[] allFields = FieldUtils.getAllFields(clazz);
        for (Field field : allFields) {
            beanGenerator.addProperty(field.getName(), getFieldType(field));
        }
    }

    private static Class<?> getFieldType(Field field) {
        if (ReflectionUtil.isSetOrList(field.getType())) {
            Class<?> itemType = ReflectionUtil.getItemType(field.getType(), field.getGenericType());
            return Array.newInstance(expandModel(itemType), 0).getClass();
        }
        return expandModel(field.getType());
    }

    public static String toJson(Object dataObject) {
        try {
            return createObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(dataObject);
        } catch (JsonProcessingException e) {
            return dataObject.toString();
        }
    }

    public static String getFieldName(Object dataObject, String originalFieldName) {
        if (isGeneratedClass(dataObject.getClass())) {
            return GENERATED_PROPERTY_PREFIX + originalFieldName;
        }
        return originalFieldName;
    }
}
