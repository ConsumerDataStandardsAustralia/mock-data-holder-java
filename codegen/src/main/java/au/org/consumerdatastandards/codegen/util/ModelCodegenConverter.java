package au.org.consumerdatastandards.codegen.util;

import au.org.consumerdatastandards.codegen.generator.CodegenDataDefinition;
import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.generator.CodegenSection;
import au.org.consumerdatastandards.reflection.ReflectionUtil;
import au.org.consumerdatastandards.support.EndpointResponse;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;

public class ModelCodegenConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModelCodegenConverter.class);
    public static final Set<Class<?>> BASE_TYPES = getBaseTypes();

    public static CodegenModel convert(APIModel apiModel) {

        CodegenModel codegenModel = new CodegenModel();
        for (SectionModel sectionModel : apiModel.getSectionModels()) {
            codegenModel.addCodegenSection(convert(sectionModel));
        }
        processSections(codegenModel, apiModel.getSectionModels());
        return codegenModel;
    }

    private static CodegenSection convert(SectionModel sectionModel) {
        CodegenSection codegenSection = new CodegenSection(sectionModel);
        return codegenSection;
    }

    private static void processSections(CodegenModel codegenModel, Set<SectionModel> sectionModels) {
        for (SectionModel sectionModel : sectionModels) {
            processSection(codegenModel, sectionModel);
        }
    }

    private static void processSection(CodegenModel codegenModel, SectionModel sectionModel) {
        LOGGER.debug("Processing single section {}", sectionModel.getName());
        processEndpoints(codegenModel, sectionModel.getEndpointModels());
    }

    private static void processEndpoints(CodegenModel codegenModel, Set<EndpointModel> endpointModels) {

        LOGGER.debug("Processing a total of {} endpoints", endpointModels.size());
        for (EndpointModel endpointModel : endpointModels) {
            processEndpoint(codegenModel, endpointModel);
        }
    }

    private static void processEndpoint(CodegenModel codegenModel, EndpointModel endpointModel) {
        LOGGER.debug("Process single Endpoint named {} with a total of {} responses and {} parameters",
                endpointModel.getEndpoint().operationId(), endpointModel.getEndpoint().responses().length,
                endpointModel.getParamModels().size());
        processResponses(codegenModel, endpointModel.getEndpoint().responses());
        processParamModels(codegenModel, endpointModel.getParamModels());
    }

    private static void processParamModels(CodegenModel codegenModel, Set<ParamModel> paramModels) {
        // Parameters are data definitions too!
        for (ParamModel paramModel : paramModels) {
            LOGGER.debug("Processing parameter of {}", paramModel.getName());
            processDataDefinition(codegenModel, paramModel.getParamDataType());
        }
    }

    private static void processResponses(CodegenModel codegenModel, EndpointResponse[] responses) {
        for (EndpointResponse response : responses) {
            LOGGER.debug("Processing response code of {}", response.responseCode());
            processResponse(codegenModel, response);
        }
    }

    private static void processResponse(CodegenModel codegenModel, EndpointResponse response) {
        if (!response.content().equals(Void.class)) {
            processDataDefinition(codegenModel, response.content());
        }
    }

    private static CodegenDataDefinition convert(Class<?> dataDefinition) {
        CodegenDataDefinition codegenDataDefinition = new CodegenDataDefinition();
        return codegenDataDefinition;
    }

    private static void processDataDefinition(CodegenModel codegenModel, Class<?> clazz) {
        if (isDataDefinition(clazz)) {
            LOGGER.debug("Processing data definition for class name of {}", clazz.getName());
            CodegenDataDefinition codegenDataDefinition = convert(clazz);
            if (!codegenModel.containsDataDefinition(codegenDataDefinition)) {
                codegenModel.addDataDefinition(codegenDataDefinition);
                if (clazz.isAnnotationPresent(DataDefinition.class)) {
                    for (Class<?> subClass : clazz.getAnnotation(DataDefinition.class).allOf()) {
                        processDataDefinition(codegenModel, subClass);
                    }
                }
                if (clazz.getSuperclass() != null) {
                    processDataDefinition(codegenModel, clazz.getSuperclass());
                }
                for (Field field : clazz.getDeclaredFields()) {
                    if (isDataDefinition(field.getType())) {
                        processDataDefinition(codegenModel, field.getType());
                    } else if (ReflectionUtil.isSetOrList(field.getType()) || field.getType().isArray()) {
                        Class<?> itemType = ReflectionUtil.getFieldItemType(field);
                        processDataDefinition(codegenModel, itemType);
                    }
                }
            }
        }
    }

    private static boolean isDataDefinition(Class<?> clazz) {
        return clazz.isAnnotationPresent(DataDefinition.class) || clazz.getName().startsWith(ModelBuilder.BASE_PACKAGE);
    }

    private static Set<Class<?>> getBaseTypes() {
        Set<Class<?>> ret = new LinkedHashSet<>();
        ret.add(Boolean.class);
        ret.add(Character.class);
        ret.add(Byte.class);
        ret.add(Short.class);
        ret.add(Integer.class);
        ret.add(Long.class);
        ret.add(Float.class);
        ret.add(Double.class);
        ret.add(Void.class);
        ret.add(String.class);
        ret.add(Enum.class);
        ret.add(Object.class);
        return ret;
    }
}
