package au.org.consumerdatastandards.codegen.code;

import au.org.consumerdatastandards.codegen.Options;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "Generate java client out of api model")
public class CodeGeneratorOptions extends Options {

    @Parameter(names = {"--output-dir", "-o"}, description = "Output directory to place generated client")
    private String outputDir = "";

    @Parameter(names = {"--template-dir", "-t"}, description = "Template directory")
    private String templateDir;

    @Parameter(
        names = {"--skip-overwrite", "-s"},
        description = "specifies if the existing files should be overwritten during generation"
    )
    private boolean skipOverwrite;

    @Parameter(names = {"--base-package", "-bp"}, description = "Base package for generated code")
    private String basePackage;

    @Parameter(names = {"--api-package", "-ap"}, description = "API package")
    private String apiPackage;

    @Parameter(names = {"--model-package", "-mp"}, description = "Model package")
    private String modelPackage;

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
}
