package au.org.consumerdatastandards.codegen.code.java.server;

import au.org.consumerdatastandards.codegen.code.java.JavaCodegenBase;
import io.swagger.codegen.CodegenType;
import io.swagger.codegen.SupportingFile;
import io.swagger.codegen.languages.SpringCodegen;

import java.io.File;

public class JavaServerGen extends JavaCodegenBase {

    private static final String DEFAULT_BASE_PACKAGE = "au.org.consumerdatastandards.holder";

    private String configPackage = DEFAULT_BASE_PACKAGE + ".configuration";

    public JavaServerGen() {
        super();
        outputFolder = "generated-code" + File.separator + "client";
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
    public void processOpts() {
        setJava8Mode(true);
        super.processOpts();
        modelDocTemplateFiles.clear();
        typeMapping.put("file", "Resource");
        importMapping.put("Resource", "org.springframework.core.io.Resource");
        supportingFiles.add(new SupportingFile("pom.mustache", "", "pom.xml"));
        supportingFiles.add(new SupportingFile("README.mustache", "", "README.md"));
        supportingFiles.add(new SupportingFile("homeController.mustache",
            (sourceFolder + File.separator + configPackage).replace(".", java.io.File.separator), "HomeController.java"));
        supportingFiles.add(new SupportingFile("application.mustache",
            ("src.main.resources").replace(".", java.io.File.separator), "application.properties"));
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
