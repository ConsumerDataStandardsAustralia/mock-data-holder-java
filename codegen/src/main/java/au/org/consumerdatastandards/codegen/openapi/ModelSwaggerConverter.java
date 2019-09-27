package au.org.consumerdatastandards.codegen.openapi;

import au.org.consumerdatastandards.reflection.ReflectionUtil;
import au.org.consumerdatastandards.support.Endpoint;
import au.org.consumerdatastandards.support.EndpointResponse;
import au.org.consumerdatastandards.support.Param;
import au.org.consumerdatastandards.support.data.*;
import au.org.consumerdatastandards.support.model.APIModel;
import au.org.consumerdatastandards.support.model.EndpointModel;
import au.org.consumerdatastandards.support.model.ParamModel;
import au.org.consumerdatastandards.support.model.SectionModel;
import au.org.consumerdatastandards.support.util.CustomAttributesUtil;
import io.swagger.models.*;
import io.swagger.models.parameters.*;
import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.ObjectProperty;
import io.swagger.models.properties.PropertyBuilder;
import io.swagger.models.properties.StringProperty;
import io.swagger.models.utils.PropertyModelConverter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.*;

public class ModelSwaggerConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModelSwaggerConverter.class);
    private static Properties TYPE_MAPPING;

    static {
        TYPE_MAPPING = new Properties();
        InputStream inputStream = ModelSwaggerConverter.class.getResourceAsStream("/swagger/java-swagger-mapping.properties");
        try {
            TYPE_MAPPING.load(inputStream);
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    private static class SwaggerTypeFormat {
        String type = ObjectProperty.TYPE, format;
    }

    public static Swagger convert(APIModel apiModel) {
        LOGGER.debug("Initiating conversion of APIModel to swagger-core object");
        Swagger swagger = new Swagger();
        Properties swaggerProp = loadSwaggerProperties();
        swagger = swagger.info(getInfo(swaggerProp)).host(swaggerProp.getProperty("host"))
            .basePath(swaggerProp.getProperty("basePath")).schemes(Arrays.asList(getSchemes(swaggerProp)))
            .produces(Arrays.asList(getTrimmedValues(swaggerProp.getProperty("produces").split(","))))
            .consumes(Arrays.asList(getTrimmedValues(swaggerProp.getProperty("consumes").split(","))));
        setPaths(swagger, apiModel);
        sortMaps(swagger);
        return swagger;
    }

    private static void sortMaps(Swagger swagger) {
        sortDefinitions(swagger);
        sortParameters(swagger);
    }

    private static void sortDefinitions(Swagger swagger) {
        Map<String, Model> definitions = swagger.getDefinitions();
        if (definitions != null && !definitions.isEmpty()) {
            Map<String, Model> sortedDefinitions = new TreeMap<>(definitions);
            swagger.setDefinitions(sortedDefinitions);
        }
    }

    private static void sortParameters(Swagger swagger) {
        Map<String, Parameter> parameters = swagger.getParameters();
        if (parameters != null && !parameters.isEmpty()) {
            Map<String, Parameter> sortedParameters = new TreeMap<>(parameters);
            swagger.setParameters(sortedParameters);
        }
    }

    private static Info getInfo(Properties swaggerProp) {

        return new Info().version(swaggerProp.getProperty("version")).title(swaggerProp.getProperty("title"))
            .description(swaggerProp.getProperty("description")).license(new License()
                .name(swaggerProp.getProperty("license.name")).url(swaggerProp.getProperty("license.url")));
    }

    private static Scheme[] getSchemes(Properties swaggerProp) {
        String[] schemeNames = swaggerProp.getProperty("schemes").split(",");
        Scheme[] schemes = new Scheme[schemeNames.length];
        for (int i = 0; i < schemeNames.length; i++) {
            schemes[i] = Scheme.forValue(schemeNames[i].trim());
        }
        return schemes;
    }

    private static String[] getTrimmedValues(String[] values) {

        String[] trimmedValues = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            trimmedValues[i] = values[i].trim();
        }
        return trimmedValues;
    }

    private static void setPaths(Swagger swagger, APIModel apiModel) {
        LOGGER.debug("Setting swagger-core paths from APIModel");
        for (SectionModel sectionModel : apiModel.getSectionModels()) {
            List<String> tags = Arrays.asList(sectionModel.getTags());
            for (EndpointModel endpointModel : sectionModel.getEndpointModels()) {
                Endpoint endpoint = endpointModel.getEndpoint();
                String method = endpoint.requestMethod().toString().toLowerCase();
                Operation operation = new Operation().operationId(endpoint.operationId())
                    .description(endpoint.description()).summary(endpoint.summary()).tags(tags)
                    .vendorExtensions(endpointModel.getGroupedAttributes());
                for (EndpointResponse response : endpoint.responses()) {
                    operation = operation.response(response.responseCode().getCode(),
                        new Response().description(response.description())
                            .responseSchema(convertToModel(swagger, response.content())));
                }
                for (ParamModel paramModel : endpointModel.getParamModels()) {
                    operation.parameter(convertToParameter(swagger, paramModel));
                }
                Path path = new Path().set(method, operation);
                swagger = swagger.path(endpoint.path(), path);
            }
        }
    }

    private static Properties loadSwaggerProperties() {

        Properties prop = new Properties();
        InputStream inputStream = ModelSwaggerConverter.class.getResourceAsStream("/swagger/static-values.properties");
        try {
            prop.load(inputStream);
            return prop;
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    private static Parameter convertToParameter(Swagger swagger, ParamModel paramModel) {

        Param param = paramModel.getParam();
        Map<String, Object> vendorExtensions = paramModel.getGroupedAttributes();
        LOGGER.debug("Converting {} to Swagger Parameter model", param.in());
        switch (param.in()) {
            case BODY:
                BodyParameter bodyParameter = new BodyParameter().description(param.description()).name(param.name())
                    .schema(convertToModel(swagger, paramModel.getParamDataType()));
                bodyParameter.setVendorExtensions(vendorExtensions);
                if (!StringUtils.isBlank(param.reference())) {
                    return buildRefParameter(swagger, param.reference(), bodyParameter);
                }
                return bodyParameter;
            case HEADER:
                HeaderParameter headerParameter = new HeaderParameter();
                headerParameter.setVendorExtensions(vendorExtensions);
                buildSerializableParameter(paramModel, param, headerParameter);
                if (!StringUtils.isBlank(param.reference())) {
                    return buildRefParameter(swagger, param.reference(), headerParameter);
                }
                return headerParameter;
            case PATH:
                PathParameter pathParameter = new PathParameter();
                pathParameter.setVendorExtensions(vendorExtensions);
                buildSerializableParameter(paramModel, param, pathParameter);
                if (!StringUtils.isBlank(param.reference())) {
                    return buildRefParameter(swagger, param.reference(), pathParameter);
                }
                return pathParameter;
            case FORM:
                FormParameter formParameter = new FormParameter();
                formParameter.setVendorExtensions(vendorExtensions);
                buildSerializableParameter(paramModel, param, formParameter);
                if (!StringUtils.isBlank(param.reference())) {
                    return buildRefParameter(swagger, param.reference(), formParameter);
                }
                return formParameter;
            case QUERY:
                QueryParameter queryParameter = new QueryParameter();
                queryParameter.setVendorExtensions(vendorExtensions);
                buildSerializableParameter(paramModel, param, queryParameter);
                if (!StringUtils.isBlank(param.reference())) {
                    return buildRefParameter(swagger, param.reference(), queryParameter);
                }
                return queryParameter;
            case COOKIE:
                CookieParameter cookieParameter = new CookieParameter();
                cookieParameter.setVendorExtensions(vendorExtensions);
                buildSerializableParameter(paramModel, param, cookieParameter);
                if (!StringUtils.isBlank(param.reference())) {
                    return buildRefParameter(swagger, param.reference(), cookieParameter);
                }
                return cookieParameter;
            default:
                LOGGER.error("Unsupported ParamLocation of {} supplied", param.in());
                throw new Error(String.format("Unsupported ParamLocation of %s supplied", param.in()));
        }
    }

    private static Parameter buildRefParameter(Swagger swagger, String reference, Parameter parameter) {

        swagger.parameter(reference, parameter);
        return new RefParameter(reference);
    }

    private static void buildSerializableParameter(ParamModel paramModel, Param param,
                                                   AbstractSerializableParameter<?> parameter) {
        SwaggerTypeFormat swaggerTypeFormat = getSwaggerTypeFormat(paramModel.getParamDataType());
        if (paramModel.getStringFormat() != null) {
            swaggerTypeFormat.format = paramModel.getStringFormat().format().toString();
        }
        if (paramModel.getCDSDataType() != null) {
            CustomDataType customDataType = paramModel.getCDSDataType().value();
            LOGGER.debug("Processing CDS Custom Data Type for Parameter of {}", customDataType);
            if (customDataType.getFormat() != null) {
                swaggerTypeFormat.format = customDataType.getFormat().toString();
            }
            if (customDataType.getPattern() != null) {
                parameter.setPattern(customDataType.getPattern());
            }
            if (customDataType.getMin() != null) {
                parameter.setMinimum(new BigDecimal(customDataType.getMin().toString()));
            }
            if (customDataType.getMin() != null) {
                parameter.setMaximum(new BigDecimal(customDataType.getMax().toString()));
            }
        }
        parameter.description(param.description()).name(param.name()).type(swaggerTypeFormat.type).format(swaggerTypeFormat.format);
        if (!StringUtils.isBlank(param.defaultValue())) {
            parameter.setDefaultValue(param.defaultValue());
        }
        if (paramModel.getPattern() != null) {
            parameter.setPattern(paramModel.getPattern().regex());
        }
        IntegerRange integerRange = paramModel.getIntegerRange();
        if (integerRange != null) {
            if (integerRange.min() != Integer.MIN_VALUE) {
                parameter.setMinimum(new BigDecimal(integerRange.min()));
            }
            if (integerRange.max() != Integer.MAX_VALUE) {
                parameter.setMaximum(new BigDecimal(integerRange.max()));
            }
        }
        if (paramModel.getParamDataType().isEnum()) {
            parameter.setEnum(getEnumValues(paramModel.getParamDataType()));
        }
    }

    private static Model convertToModel(Swagger swagger, Class<?> dataType) {

        DataDefinition dataDefinition = dataType.getAnnotation(DataDefinition.class);
        if (dataDefinition == null || !dataDefinition.referenced()) {
            return convertToModelImpl(swagger, dataType);
        } else {
            LOGGER.debug("Convert {} to RefModel", dataType.getSimpleName());
            if (swagger.getDefinitions() == null || !swagger.getDefinitions().containsKey(dataType.getSimpleName())) {
                if (dataDefinition.allOf().length == 0) {
                    swagger.addDefinition(dataType.getSimpleName(), convertToModelImpl(swagger, dataType));
                } else {
                    swagger.addDefinition(dataType.getSimpleName(),
                        convertToComposedModel(swagger, dataType, dataDefinition.allOf()));
                }
            }
            return new RefModel(dataType.getSimpleName());
        }
    }

    private static ModelImpl convertToModelImpl(Swagger swagger, Class<?> dataType) {
        LOGGER.debug("Convert {} to Model Implementation", dataType.getSimpleName());
        ModelImpl modelImpl = new ModelImpl();
        modelImpl.setVendorExtensions(CustomAttributesUtil.getGroupedAttributes(dataType));
        modelImpl.name(dataType.getSimpleName());
        DataDefinition dataDefinition = dataType.getAnnotation(DataDefinition.class);
        if (dataDefinition != null && !StringUtils.isBlank(dataDefinition.description())) {
            modelImpl.description(dataDefinition.description());
        }
        if (dataType.isEnum()) {
            modelImpl.type(StringProperty.TYPE)._enum(getEnumValues(dataType));
        } else {
            modelImpl.type(ModelImpl.OBJECT);
            List<String> required = new ArrayList<>();
            for (Field field : sortFields(FieldUtils.getAllFieldsList(dataType))) {
                if (field.isAnnotationPresent(Property.class)) {
                    Property property = field.getAnnotation(Property.class);
                    if (property.required()) {
                        required.add(field.getName());
                    }
                    modelImpl.addProperty(field.getName(), convertToProperty(swagger, field));
                }
            }
            modelImpl.setRequired(required);
        }
        return modelImpl;
    }

    private static Set<Field> sortFields(List<Field> fields) {
        Set<Field> sortedFields = new TreeSet<>(Comparator.comparing(Field::getName));
        sortedFields.addAll(fields);
        return sortedFields;
    }

    private static ComposedModel convertToComposedModel(Swagger swagger, Class<?> dataType, Class<?>[] allOf) {
        LOGGER.debug("Convert {} to Composed Model", dataType.getSimpleName());

        ComposedModel composedModel = new ComposedModel();
        DataDefinition dataDefinition = dataType.getAnnotation(DataDefinition.class);
        if (dataDefinition != null && !StringUtils.isBlank(dataDefinition.description())) {
            composedModel.setDescription(dataDefinition.description());
        }
        composedModel.setReference(dataType.getSimpleName());
        List<RefModel> interfaces = new ArrayList<>();
        for (Class<?> allOfClass : allOf) {
            Model model = convertToModel(swagger, allOfClass);
            composedModel.child(model);
            if (model instanceof RefModel) {
                interfaces.add((RefModel) model);
            }
        }
        composedModel.child(convertToModelImpl(swagger, dataType));
        composedModel.interfaces(interfaces);
        composedModel.setVendorExtensions(CustomAttributesUtil.getGroupedAttributes(dataType));
        return composedModel;
    }

    private static io.swagger.models.properties.Property convertToProperty(Swagger swagger, Field field) {
        // figure out swagger type and format from field
        SwaggerTypeFormat typeFormat = getSwaggerTypeFormat(field.getType());
        StringFormat stringFormat = field.getAnnotation(StringFormat.class);
        if (stringFormat != null) {
            typeFormat.format = stringFormat.format().toString();
        }

        return buildProperty(swagger, field, typeFormat);
    }

    private static io.swagger.models.properties.Property buildProperty(Swagger swagger, Field field,
                                                                       SwaggerTypeFormat typeFormat) {

        if (ObjectProperty.isType(typeFormat.type, typeFormat.format) || field.getType().isEnum()) {
            LOGGER.debug("Convert {} to Swagger Object Property", field.getName());
            io.swagger.models.properties.Property property = buildObjectProperty(swagger, field.getType());
            if (property instanceof ObjectProperty) {
                ((ObjectProperty) property).setVendorExtensions(CustomAttributesUtil.getGroupedAttributes(field));
            }
            return property;
        } else if (ArrayProperty.isType(typeFormat.type)) {
            LOGGER.debug("Convert {} to Swagger Array Property", field.getName());
            ArrayProperty property = (ArrayProperty) buildArrayProperty(swagger, field, typeFormat);
            property.setVendorExtensions(CustomAttributesUtil.getGroupedAttributes(field));
            return property;
        }
        LOGGER.debug("Convert {} to Generic Property", field.getName());
        return PropertyBuilder.build(typeFormat.type, typeFormat.format, argsFromField(field, false));
    }

    private static io.swagger.models.properties.Property buildArrayProperty(Swagger swagger, Field field,
                                                                            SwaggerTypeFormat typeFormat) {
        ArrayProperty arrayProperty = new ArrayProperty();
        Property property = field.getAnnotation(Property.class);
        if (!StringUtils.isBlank(property.description())) {
            arrayProperty.description(property.description());
        }
        Class<?> itemType = ReflectionUtil.getFieldItemType(field);
        Map<PropertyBuilder.PropertyId, Object> args = argsFromField(field, true);
        Type genericType = field.getGenericType();
        arrayProperty.setItems(convertItemToProperty(swagger, itemType, genericType, typeFormat.format, args));
        return arrayProperty;
    }

    private static io.swagger.models.properties.Property buildItemsProperty(
        Swagger swagger,
        Class<?> type,
        Type genericType,
        SwaggerTypeFormat typeFormat,
        Map<PropertyBuilder.PropertyId, Object> args) {

        if (ObjectProperty.isType(typeFormat.type, typeFormat.format)) {
            return buildObjectProperty(swagger, type);
        } else if (ArrayProperty.isType(typeFormat.type)) {
            ArrayProperty arrayProperty = new ArrayProperty();
            Class<?> itemType = ReflectionUtil.getItemType(type, genericType);
            arrayProperty.setItems(convertItemToProperty(swagger, itemType, genericType, typeFormat.format, args));
            return arrayProperty;
        }
        return PropertyBuilder.build(typeFormat.type, typeFormat.format, args);
    }

    private static io.swagger.models.properties.Property buildObjectProperty(Swagger swagger, Class<?> fieldType) {

        Model model = convertToModel(swagger, fieldType);
        return new PropertyModelConverter().modelToProperty(model);
    }

    private static SwaggerTypeFormat getSwaggerTypeFormat(Class<?> type) {

        SwaggerTypeFormat swaggerTypeFormat = new SwaggerTypeFormat();
        if (type.isArray() || ReflectionUtil.isSetOrList(type)) {
            swaggerTypeFormat.type = ArrayProperty.TYPE;
        } else if (type.isEnum()) {
            swaggerTypeFormat.type = StringProperty.TYPE;
        } else {
            String mappedTypeFormat = TYPE_MAPPING.getProperty(type.getSimpleName().toLowerCase());
            if (mappedTypeFormat != null) {
                String[] typeAndFormat = getTrimmedValues(mappedTypeFormat.split(","));
                if (typeAndFormat.length == 1) {
                    swaggerTypeFormat.type = typeAndFormat[0];
                } else if (typeAndFormat.length == 2) {
                    swaggerTypeFormat.type = typeAndFormat[0];
                    swaggerTypeFormat.format = typeAndFormat[1];
                } else {
                    LOGGER.debug("Too many commas in {}", mappedTypeFormat);
                    throw new Error(String.format("Too many commas in '%s'", mappedTypeFormat));
                }
            }
        }
        return swaggerTypeFormat;
    }

    private static io.swagger.models.properties.Property convertItemToProperty(Swagger swagger, Class<?> type,
                                                                               Type genericType, String format, Map<PropertyBuilder.PropertyId, Object> args) {
        SwaggerTypeFormat typeFormat = getSwaggerTypeFormat(type);
        if (!type.isArray() && !ReflectionUtil.isSetOrList(type) && !StringUtils.isBlank(format)) {
            typeFormat.format = format;
        }
        if (!type.isArray() && !ReflectionUtil.isSetOrList(type)) {
            setEnum(type, args);
        }
        return buildItemsProperty(swagger, type, genericType, typeFormat, args);
    }

    private static Map<PropertyBuilder.PropertyId, Object> argsFromField(Field field, boolean forItem) {

        Map<PropertyBuilder.PropertyId, Object> args = new HashMap<>();
        if (forItem) {
            setItemDescription(field, args);
        } else {
            setDescription(field, args);
        }
        setEnum(field.getType(), args);
        processCDSDataType(field, args);
        setMinMax(field, args);
        setFormat(field, args);
        setPattern(field, args);
        setDefaultValue(field, args);
        setVendorExtensions(field, args);
        return args;
    }

    private static void processCDSDataType(Field field, Map<PropertyBuilder.PropertyId, Object> args) {
        LOGGER.debug("Processing CDS Custom Data Type for Swagger Property for Field of {}", field.getName());
        CDSDataType cdsDataType = field.getAnnotation(CDSDataType.class);
        if (cdsDataType != null) {
            CustomDataType customDataType = cdsDataType.value();
            if (customDataType.getFormat() != null) {
                args.put(PropertyBuilder.PropertyId.FORMAT, customDataType.getFormat().toString());
            }
            if (customDataType.getPattern() != null) {
                args.put(PropertyBuilder.PropertyId.PATTERN, customDataType.getPattern());
            }
            if (customDataType.getMin() != null) {
                args.put(PropertyBuilder.PropertyId.MINIMUM, new BigDecimal(customDataType.getMin().toString()));
            }
            if (customDataType.getMax() != null) {
                args.put(PropertyBuilder.PropertyId.MAXIMUM, new BigDecimal(customDataType.getMax().toString()));
            }
        }
    }

    private static void setDescription(Field field, Map<PropertyBuilder.PropertyId, Object> args) {

        Property property = field.getAnnotation(Property.class);
        if (!StringUtils.isBlank(property.description())) {
            args.put(PropertyBuilder.PropertyId.DESCRIPTION, property.description());
        }
    }

    private static void setItemDescription(Field field, Map<PropertyBuilder.PropertyId, Object> args) {

        Item element = field.getAnnotation(Item.class);
        if (element != null && !StringUtils.isBlank(element.description())) {
            args.put(PropertyBuilder.PropertyId.DESCRIPTION, element.description());
        }
    }

    private static void setEnum(Class<?> type, Map<PropertyBuilder.PropertyId, Object> args) {

        if (type.isEnum()) {
            args.put(PropertyBuilder.PropertyId.ENUM, getEnumValues(type));
        }
    }

    private static List<String> getEnumValues(Class<?> type) {

        Object[] enumConstants = type.getEnumConstants();
        Set<String> values = new TreeSet<>();
        for (Object enumConstant : enumConstants) {
            values.add(((Enum<?>) enumConstant).name());
        }
        return new ArrayList<>(values);
    }

    private static void setFormat(Field field, Map<PropertyBuilder.PropertyId, Object> args) {

        StringFormat stringFormat = field.getAnnotation(StringFormat.class);
        if (stringFormat != null) {
            args.put(PropertyBuilder.PropertyId.FORMAT, stringFormat.format().toString());
        }
    }

    private static void setPattern(Field field, Map<PropertyBuilder.PropertyId, Object> args) {

        Pattern pattern = field.getAnnotation(Pattern.class);
        if (pattern != null) {
            args.put(PropertyBuilder.PropertyId.PATTERN, pattern.regex());
        }
    }

    private static void setMinMax(Field field, Map<PropertyBuilder.PropertyId, Object> args) {

        IntegerRange integerRange = field.getAnnotation(IntegerRange.class);
        if (integerRange != null) {
            if (integerRange.min() != Integer.MIN_VALUE) {
                args.put(PropertyBuilder.PropertyId.MINIMUM, new BigDecimal(integerRange.min()));
            }
            if (integerRange.max() != Integer.MAX_VALUE) {
                args.put(PropertyBuilder.PropertyId.MAXIMUM, new BigDecimal(integerRange.max()));
            }
        }
    }

    private static void setDefaultValue(Field field, Map<PropertyBuilder.PropertyId, Object> args) {

        try {
            Object target = field.getDeclaringClass().newInstance();
            Object defaultValue = FieldUtils.readField(field, target, true);
            if (defaultValue != null && !ReflectionUtil.isTypeDefaultValue(defaultValue)) {
                if (defaultValue.getClass().isEnum()) {
                    args.put(PropertyBuilder.PropertyId.DEFAULT, ((Enum<?>) defaultValue).name());
                } else {
                    args.put(PropertyBuilder.PropertyId.DEFAULT, defaultValue.toString());
                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new Error(e);
        }
    }

    private static void setVendorExtensions(Field field, Map<PropertyBuilder.PropertyId, Object> args) {

        args.put(PropertyBuilder.PropertyId.VENDOR_EXTENSIONS, CustomAttributesUtil.getGroupedAttributes(field));
    }
}
