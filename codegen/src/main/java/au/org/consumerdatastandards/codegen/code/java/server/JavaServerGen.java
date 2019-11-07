package au.org.consumerdatastandards.codegen.code.java.server;

import au.org.consumerdatastandards.codegen.code.java.JavaCodegenBase;
import io.swagger.codegen.CodegenType;
import io.swagger.codegen.SupportingFile;
import io.swagger.codegen.languages.SpringCodegen;

import java.io.File;

public class JavaServerGen extends JavaCodegenBase {

    private static final String DEFAULT_BASE_PACKAGE = "au.org.consumerdatastandards.holder";

    private String configPackage = DEFAULT_BASE_PACKAGE + ".configuration";

    private String utilPackage = DEFAULT_BASE_PACKAGE + ".util";

    public JavaServerGen() {
        super();
        outputFolder = "generated-code" + File.separator + "holder";
        embeddedTemplateDir = templateDir = "JavaServer";
        invokerPackage = DEFAULT_BASE_PACKAGE;
        apiPackage = DEFAULT_BASE_PACKAGE + ".api";
        modelPackage = DEFAULT_BASE_PACKAGE + ".model";
        artifactId = "data-holder";

        additionalProperties.put(SpringCodegen.CONFIG_PACKAGE, configPackage);
        additionalProperties.put(SpringCodegen.BASE_PACKAGE, invokerPackage);
        additionalProperties.put("jackson", "true");
    }

    @Override
    public String toApiName(String name) {
        return name + "Api";
    }

    @Override
    public void processOpts() {
        final String resourcesFolder = (projectFolder + "/resources");
        final String configFolder = (sourceFolder + File.separator + configPackage).replace(".", File.separator);
        final String utilFolder = (sourceFolder + File.separator + utilPackage).replace(".", File.separator);
        setJava8Mode(true);
        super.processOpts();
        typeMapping.put("file", "Resource");
        importMapping.put("Resource", "org.springframework.core.io.Resource");
        supportingFiles.add(new SupportingFile("pom.mustache", "", "pom.xml"));
        supportingFiles.add(new SupportingFile("README.mustache", "", "README.md"));
        supportingFiles.add(new SupportingFile("HomeController.mustache", configFolder, "HomeController.java"));
        supportingFiles.add(new SupportingFile("OpenAPIDocumentationConfig.mustache", configFolder, "OpenAPIDocumentationConfig.java"));
        supportingFiles.add(new SupportingFile("application.mustache", resourcesFolder, "application.properties"));
        supportingFiles.add(new SupportingFile("banner.mustache", resourcesFolder, "banner.txt"));
        supportingFiles.add(new SupportingFile("CdsDataLoader.mustache", utilFolder, "CdsDataLoader.java"));
        supportingFiles.add(new SupportingFile("ContextEventListener.mustache", utilFolder, "ContextEventListener.java"));
        supportingFiles.add(new SupportingFile("SwaggerJacksonModuleRegistrar.mustache", utilFolder, "SwaggerJacksonModuleRegistrar.java"));
        supportingFiles.add(new SupportingFile("WebUtil.mustache", utilFolder, "WebUtil.java"));
        apiTemplateFiles.put("apiController.mustache", "Controller.java");
    }

    @Override
    public CodegenType getTag() {
        return CodegenType.SERVER;
    }

    @Override
    public String getName() {
        return "data-holder";
    }

    @Override
    public String getHelp() {
        return "Generate a sample data holder";
    }
}
