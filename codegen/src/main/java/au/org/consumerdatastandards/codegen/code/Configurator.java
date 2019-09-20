package au.org.consumerdatastandards.codegen.code;

import io.swagger.codegen.*;
import io.swagger.codegen.config.CodegenConfigurator;
import io.swagger.models.Swagger;

import java.nio.file.Paths;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class Configurator extends CodegenConfigurator {

    private Swagger swagger;

    public void setSwagger(Swagger swagger) {
        this.swagger = swagger;
    }

    @Override
    public ClientOptInput toClientOptInput() {
        CodeGeneratorConfig codeGeneratorConfig = CodeGeneratorConfigLoader.forName(getLang());

        codeGeneratorConfig.setOutputDir(getOutputDir());
        codeGeneratorConfig.setSkipOverwrite(isSkipOverwrite());
        codeGeneratorConfig.setIgnoreFilePathOverride(getIgnoreFileOverride());
        codeGeneratorConfig.setRemoveOperationIdPrefix(getRemoveOperationIdPrefix());

        codeGeneratorConfig.instantiationTypes().putAll(getInstantiationTypes());
        codeGeneratorConfig.typeMapping().putAll(getTypeMappings());
        codeGeneratorConfig.importMapping().putAll(getImportMappings());
        codeGeneratorConfig.languageSpecificPrimitives().addAll(getLanguageSpecificPrimitives());
        codeGeneratorConfig.reservedWordsMappings().putAll(getReservedWordsMappings());

        setAdditionalProperty(getApiPackage(), CodegenConstants.API_PACKAGE);
        setAdditionalProperty(getModelPackage(), CodegenConstants.MODEL_PACKAGE);
        setAdditionalProperty(getInvokerPackage(), CodegenConstants.INVOKER_PACKAGE);
        setAdditionalProperty(getGroupId(), CodegenConstants.GROUP_ID);
        setAdditionalProperty(getArtifactId(), CodegenConstants.ARTIFACT_ID);
        setAdditionalProperty(getArtifactId(), CodegenConstants.ARTIFACT_VERSION);
        setAdditionalProperty(toAbsolutePathStr(getTemplateDir()), CodegenConstants.TEMPLATE_DIR);
        setAdditionalProperty(getModelNamePrefix(), CodegenConstants.MODEL_NAME_PREFIX);
        setAdditionalProperty(getModelNameSuffix(), CodegenConstants.MODEL_NAME_SUFFIX);
        setAdditionalProperty(getGitUserId(), CodegenConstants.GIT_USER_ID);
        setAdditionalProperty(getGitRepoId(), CodegenConstants.GIT_REPO_ID);
        setAdditionalProperty(getReleaseNote(), CodegenConstants.RELEASE_NOTE);
        setAdditionalProperty(getHttpUserAgent(), CodegenConstants.HTTP_USER_AGENT);

        handleDynamicProperties(codeGeneratorConfig);

        if (isNotEmpty(getLibrary())) {
            codeGeneratorConfig.setLibrary(getLibrary());
        }

        codeGeneratorConfig.additionalProperties().putAll(getAdditionalProperties());

        ClientOptInput input = new ClientOptInput().config(codeGeneratorConfig);

        input.opts(new ClientOpts()).swagger(swagger);

        return input;
    }

    private void handleDynamicProperties(CodegenConfig codegenConfig) {
        Map<String, Object> dynamicProperties = getDynamicProperties();
        Map<String, String> systemProperties = getSystemProperties();
        for (CliOption langCliOption : codegenConfig.cliOptions()) {
            String opt = langCliOption.getOpt();
            if (dynamicProperties.containsKey(opt)) {
                codegenConfig.additionalProperties().put(opt, dynamicProperties.get(opt));
            }
            else if(systemProperties.containsKey(opt)) {
                codegenConfig.additionalProperties().put(opt, systemProperties.get(opt));
            }
        }
    }

    private void setAdditionalProperty(String property, String propertyKey) {
        if (isNotEmpty(property)) {
            getAdditionalProperties().put(propertyKey, property);
        }
    }

    private static String toAbsolutePathStr(String path) {
        if (isNotEmpty(path)) {
            return Paths.get(path).toAbsolutePath().toString();
        }
        return path;
    }
}
