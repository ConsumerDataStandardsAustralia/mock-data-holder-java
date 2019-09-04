package au.org.consumerdatastandards.codegen.generator.code.handler.datadefinition;

import au.org.consumerdatastandards.codegen.generator.CodegenDataDefinition;
import au.org.consumerdatastandards.codegen.generator.CodegenDataDefinitionField;
import au.org.consumerdatastandards.codegen.generator.code.VelocityHelper;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandler;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;
import au.org.consumerdatastandards.codegen.generator.velocity.model.VelocityFile;
import au.org.consumerdatastandards.codegen.util.ModelCodegenConverter;
import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Id;
import au.org.consumerdatastandards.support.data.Property;
import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class DataDefinitionHandler extends AbstractHandler<DataDefinitionHandlerConfig> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataDefinitionHandler.class);

    @Override
    public boolean matchConfig(AbstractHandlerConfig inputConfig) {
        return inputConfig instanceof DataDefinitionHandlerConfig;
    }

    @Override
    public void setConfig(AbstractHandlerConfig handlerConfig) {
        this.config = (DataDefinitionHandlerConfig) handlerConfig;
    }

    private CodegenDataDefinition getDataDefinition(Class<?> definitionClass) {
        CodegenDataDefinition dataDefinition = new CodegenDataDefinition(definitionClass);
        dataDefinition.definitionName = definitionClass.getSimpleName();
        dataDefinition.packageName = definitionClass.getPackage().getName();
        dataDefinition.isEnum = definitionClass.isEnum();

        for (Annotation oneAnnotation : definitionClass.getAnnotations()) {
            if (oneAnnotation.annotationType().equals(DataDefinition.class)) {
                DataDefinition thisDefinition = (DataDefinition) oneAnnotation;
                dataDefinition.definitionDescription = thisDefinition.description().replaceAll("\n", " ");
                for (Class<?> allOfClass : thisDefinition.allOf()) {
                    populateFields(allOfClass, dataDefinition);
                }
            }
        }

        /*
          Process nested classes
         */
        for (Class<?> declaredClass : definitionClass.getDeclaredClasses()) {
            dataDefinition.addNestedDefinition(getDataDefinition(declaredClass));
        }

        populateFields(definitionClass, dataDefinition);
        
        /*
          Use extended model as long as it isn't a base type and populate it's fields into this object
         */
        if (definitionClass.getSuperclass() != null
                && !ModelCodegenConverter.BASE_TYPES.contains(definitionClass.getSuperclass())) {
            dataDefinition.extendsOn = definitionClass.getSuperclass().getSimpleName();
        }

        return dataDefinition;
    }

    private void populateFields(Class<?> definitionClass, CodegenDataDefinition dataDefinition) {
        Field[] definitionFields = definitionClass.getDeclaredFields();
        for (Field oneField : definitionFields) {
            oneField.setAccessible(true);
            CodegenDataDefinitionField oneModelField = new CodegenDataDefinitionField();

            if (dataDefinition.isEnum) {
                if (oneField.isEnumConstant()) {
                    oneModelField.name = oneField.getName();
                    dataDefinition.fieldList.add(oneModelField);
                }

            } else {
                oneModelField.name = oneField.getName();
                if (oneField.getType().isAssignableFrom(List.class)) {
                    Class<?> innerType = (Class<?>) ((ParameterizedType) oneField.getGenericType())
                            .getActualTypeArguments()[0];
                    oneModelField.type = codegenConfig.getTypeMapping("List", innerType.getSimpleName());
                } else {
                    if (codegenConfig.hasTypeMapping(oneField.getType().getSimpleName())) {
                        oneModelField.type = codegenConfig.getTypeMapping(oneField.getType().getSimpleName());
                    } else {
                        oneModelField.type = oneField.getType().getSimpleName();
                    }
                }

                for (Annotation oneAnnotation : oneField.getAnnotations()) {
                    if (oneAnnotation.annotationType().equals(Property.class)) {
                        Property thisProperty = (Property) oneAnnotation;
                        oneModelField.description = thisProperty.description().replaceAll("\n", " ");
                        oneModelField.isRequired = thisProperty.required();
                    }

                    if (oneAnnotation.annotationType().equals(Id.class)) {
                        oneModelField.isId = true;
                    }

                    if (oneAnnotation.annotationType().equals(CDSDataType.class)) {
                        CDSDataType thisDataType = (CDSDataType) oneAnnotation;
                        oneModelField.type = codegenConfig.getTypeMapping(thisDataType.value().name());

                        if (thisDataType.value().getPattern() != null) {
                            oneModelField.validationPattern = thisDataType.value().getPattern();
                        }

                        if (thisDataType.value().getMin() != null) {
                            oneModelField.minValue = thisDataType.value().getMin();
                        }

                        if (thisDataType.value().getMax() != null) {
                            oneModelField.maxValue = thisDataType.value().getMax();
                        }
                    }

                }
                dataDefinition.fieldList.add(oneModelField);
            }
        }
    }

    @Override
    public void populateVelocityFiles(VelocityHelper velocityHelper) throws IOException {
        for (CodegenDataDefinition dataDefinition : codegenModel.getDataDefinitions()) {
            // We reparse the supplied handler config in the context of this particular data
            // definition model
            DataDefinitionHandlerConfig modelConfig = perModelConfig(dataDefinition);

            /*
              Nested class population
             */
            String renderedInlineClasses = "";

            for (CodegenDataDefinition nestedModel : dataDefinition.getNestedDefinitions()) {
                DataDefinitionHandlerConfig nestedModelConfig = perModelConfig(nestedModel);

                LOGGER.debug("Processing nested model of {} for {}", nestedModel.getDefinitionName(),
                        dataDefinition.getDefinitionName());

                String templateName = nestedModel.isEnum ? nestedModelConfig.getInlineEnumTemplate()
                        : nestedModelConfig.getInlineModelTemplate();
                if (nestedModel.isEnum && templateName.equals("null")) {
                    LOGGER.debug(
                            "Skipping inline production of {} on basis that target is Enum and no Nested Enum template supplied",
                            nestedModel.definitionName);
                } else if (!nestedModel.isEnum && templateName.equals("null")) {
                    LOGGER.debug(
                            "Skipping inline production of {} on basis that target is Model and no Nested Model template supplied",
                            nestedModel.definitionName);
                } else {
                    VelocityFile velocityFile = new VelocityFile(nestedModelConfig.getFileName(),
                            FilenameUtils.normalize(String.format("%s/%s/%s", options.getOutputPath(),
                                    nestedModelConfig.getBaseDirectory(), nestedModelConfig.getFilePath())),
                            templateName, nestedModelConfig, nestedModel);
                    renderedInlineClasses = renderedInlineClasses.concat(velocityHelper.renderTemplate(velocityFile));
                    renderedInlineClasses = renderedInlineClasses.concat("\n\n");
                }
            }

            /*
              Inject rendered content into parent model
             */
            if (!renderedInlineClasses.isEmpty()) {
                dataDefinition.setRenderedNestedModels(renderedInlineClasses);
            }

            /*
              Parent class population
             */
            String templateName = dataDefinition.isEnum ? modelConfig.getEnumTemplate() : modelConfig.getModelTemplate();
            if (dataDefinition.isEnum && templateName.equals("null")) {
                LOGGER.debug(
                        "Skipping writing of file {}/{}/{}/{} on basis that target is Enum and no Enum template supplied",
                        options.getOutputPath(), modelConfig.getBaseDirectory(), modelConfig.getFilePath(), modelConfig.getFileName());
            } else {
                LOGGER.debug("Writing file to {}/{}/{}/{} with template {}", options.getOutputPath(),
                        modelConfig.getBaseDirectory(), modelConfig.getFilePath(), modelConfig.getFileName(), templateName);
                VelocityFile oneFile = new VelocityFile(modelConfig.getFileName(),
                        FilenameUtils.normalize(String.format("%s/%s/%s", options.getOutputPath(),
                                modelConfig.getBaseDirectory(), modelConfig.getFilePath())),
                        templateName, modelConfig, dataDefinition);
                velocityHelper.addFile(oneFile);
            }
        }

    }

}
