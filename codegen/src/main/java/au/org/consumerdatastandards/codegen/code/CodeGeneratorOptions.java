package au.org.consumerdatastandards.codegen.code;

import au.org.consumerdatastandards.codegen.Options;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import java.util.ArrayList;
import java.util.List;

@Parameters(commandDescription = "Generate java client out of api model")
public class CodeGeneratorOptions extends Options {

    @Parameter(names = {"--output-dir", "-o"}, description = "Output directory")
    private String outputDir = "";

    @Parameter(names = {"--template-dir", "-t"}, description = "Template directory")
    private String templateDir;

    @Parameter(names = {"--input-spec", "-is"}, description = "location of the swagger spec, as URL or file")
    private String spec;

    @Parameter(
        names = {"--skip-overwrite", "-s"},
        description = "specifies if the existing files should be overwritten during generation"
    )
    private boolean skipOverwrite;

    @Parameter(
        names = {"--codegen-type", "-cgt"},
        description = "specifies codegen type, e.g., java-client, spring-data-holder, nodejs-client, etc."
    )
    private String codegenType;

    @Parameter(
        names = {"--codegen-config", "-cgc"},
        description = "specifies codegen type specific config file"
    )
    private String codegenConfigFile;

    @Parameter(names = {"--base-package", "-bp"}, description = "Base package for generated code")
    private String basePackage;

    @Parameter(names = {"--api-package", "-ap"}, description = "API package")
    private String apiPackage;

    @Parameter(names = {"--model-package", "-mp"}, description = "Model package")
    private String modelPackage;

    @Parameter(
        names = {"--reserved-words-mappings", "-rwm"},
        description = "specifies how a reserved name should be escaped to. " +
            "Otherwise, the default _<name> is used. For example id=identifier. " +
            "You can also have multiple occurrences of this option.")
    private List<String> reservedWordsMappings = new ArrayList<>();

    @Parameter(
        names = {"--instantiation-types"},
        description = "sets instantiation type mappings in the format of type=instantiatedType,type=instantiatedType." +
            "For example (in Java): array=ArrayList,map=HashMap. " +
            "In other words array types will get instantiated as ArrayList in generated code. " +
            "You can also have multiple occurrences of this option.")
    private List<String> instantiationTypes = new ArrayList<>();

    @Parameter(
        names = {"--type-mappings"},
        description = "sets mappings between swagger spec types and generated code types " +
            "in the format of swaggerType=generatedType,swaggerType=generatedType. " +
            "For example: array=List,map=Map,string=String. " +
            "You can also have multiple occurrences of this option.")
    private List<String> typeMappings = new ArrayList<>();

    @Parameter(
        names = {"--additional-properties"},
        description = "sets additional properties that can be referenced by the mustache templates " +
            "in the format of name=value,name=value. " +
            "You can also have multiple occurrences of this option."
    )
    private List<String> additionalProperties = new ArrayList<>();

    @Parameter(
        names = {"--language-specific-primitives"},
        description = "specifies additional language specific primitive types in the format of type1,type2,type3,type3. " +
            "For example: String,boolean,Boolean,Double. " +
            "You can also have multiple occurrences of this option."
    )
    private List<String> languageSpecificPrimitives = new ArrayList<>();

    @Parameter(
        names = {"--import-mappings"},
        description = "specifies mappings between a given class and the import that should be used for that class in the format of type=import,type=import."
            + " You can also have multiple occurrences of this option."
    )
    private List<String> importMappings = new ArrayList<>();

    @Parameter(
        names = {"-D"},
        description = "sets specified system properties in the format of name=value,name=value (or multiple options, each with name=value)"
    )
    private List<String> systemProperties = new ArrayList<>();

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public void setTemplateDir(String templateDir) {
        this.templateDir = templateDir;
    }

    public void setSkipOverwrite(boolean skipOverwrite) {
        this.skipOverwrite = skipOverwrite;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public void setApiPackage(String apiPackage) {
        this.apiPackage = apiPackage;
    }

    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public String getTemplateDir() {
        return templateDir;
    }

    public boolean isSkipOverwrite() {
        return skipOverwrite;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public String getApiPackage() {
        return apiPackage;
    }

    public String getModelPackage() {
        return modelPackage;
    }

    public String getCodegenType() {
        return codegenType;
    }

    public void setCodegenType(String codegenType) {
        this.codegenType = codegenType;
    }

    public String getCodegenConfigFile() {
        return codegenConfigFile;
    }

    public void setCodegenConfigFile(String codegenConfigFile) {
        this.codegenConfigFile = codegenConfigFile;
    }

    public List<String> getReservedWordsMappings() {
        return reservedWordsMappings;
    }

    public void setReservedWordsMappings(List<String> reservedWordsMappings) {
        this.reservedWordsMappings = reservedWordsMappings;
    }

    public List<String> getInstantiationTypes() {
        return instantiationTypes;
    }

    public void setInstantiationTypes(List<String> instantiationTypes) {
        this.instantiationTypes = instantiationTypes;
    }

    public List<String> getTypeMappings() {
        return typeMappings;
    }

    public void setTypeMappings(List<String> typeMappings) {
        this.typeMappings = typeMappings;
    }

    public List<String> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(List<String> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public List<String> getLanguageSpecificPrimitives() {
        return languageSpecificPrimitives;
    }

    public void setLanguageSpecificPrimitives(List<String> languageSpecificPrimitives) {
        this.languageSpecificPrimitives = languageSpecificPrimitives;
    }

    public List<String> getImportMappings() {
        return importMappings;
    }

    public void setImportMappings(List<String> importMappings) {
        this.importMappings = importMappings;
    }

    public List<String> getSystemProperties() {
        return systemProperties;
    }

    public void setSystemProperties(List<String> systemProperties) {
        this.systemProperties = systemProperties;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
}
