package au.org.consumerdatastandards.codegen.code;

import au.org.consumerdatastandards.codegen.AbstractGenerator;
import au.org.consumerdatastandards.codegen.openapi.ModelSwaggerConverter;
import au.org.consumerdatastandards.support.model.APIModel;
import io.swagger.codegen.ClientOptInput;
import io.swagger.codegen.DefaultGenerator;

import static io.swagger.codegen.config.CodegenConfiguratorUtils.*;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class CodeGenerator extends AbstractGenerator<CodeGeneratorOptions> {

    public CodeGenerator(APIModel apiModel) {
        super(apiModel);
    }

    @Override
    public void generate() {
        Configurator configurator = new Configurator();
        configurator.setSwagger(ModelSwaggerConverter.convert(apiModel));
        if (isNotEmpty(options.getBasePackage())) {
            configurator.setInvokerPackage(options.getBasePackage());
        }
        if (!isNotEmpty(options.getModelPackage())) {
            configurator.setModelPackage(options.getModelPackage());
        }
        if (!isNotEmpty(options.getApiPackage())) {
            configurator.setApiPackage(options.getApiPackage());
        }
        if (!isNotEmpty(options.getCodegenType())) {
            configurator.setLang(options.getCodegenType());
        }

        applySystemPropertiesKvpList(options.getSystemProperties(), configurator);
        applyInstantiationTypesKvpList(options.getInstantiationTypes(), configurator);
        applyImportMappingsKvpList(options.getImportMappings(), configurator);
        applyTypeMappingsKvpList(options.getTypeMappings(), configurator);
        applyAdditionalPropertiesKvpList(options.getAdditionalProperties(), configurator);
        applyLanguageSpecificPrimitivesCsvList(options.getLanguageSpecificPrimitives(), configurator);
        applyReservedWordsMappingsKvpList(options.getReservedWordsMappings(), configurator);

        final ClientOptInput clientOptInput = configurator.toClientOptInput();
        new DefaultGenerator().opts(clientOptInput).generate();
    }

    @Override
    protected CodeGeneratorOptions createOptions() {
        return new CodeGeneratorOptions();
    }
}
