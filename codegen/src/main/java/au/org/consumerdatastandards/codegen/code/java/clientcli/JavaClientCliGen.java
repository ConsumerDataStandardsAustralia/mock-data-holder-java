package au.org.consumerdatastandards.codegen.code.java.clientcli;

import au.org.consumerdatastandards.codegen.code.java.JavaCodegenBase;
import io.swagger.codegen.CodegenType;
import io.swagger.codegen.SupportingFile;

import java.io.File;

public class JavaClientCliGen extends JavaCodegenBase {
    private static final String DEFAULT_BASE_PACKAGE = "au.org.consumerdatastandards.client.cli";

    public JavaClientCliGen() {
        super();
        outputFolder = "generated-code" + File.separator + "client-cli";
        embeddedTemplateDir = templateDir = "JavaClientCli";
        invokerPackage = DEFAULT_BASE_PACKAGE;
        apiPackage = invokerPackage;
        artifactId = "client-cli";
    }

    @Override
    public CodegenType getTag() {
        return CodegenType.CLIENT;
    }

    @Override
    public String getName() {
        return "java-client-cli";
    }

    @Override
    public String getHelp() {
        return "Generates a Java client cli.";
    }

    @Override
    public void processOpts() {
        super.processOpts();

        final String invokerFolder = (sourceFolder + '/' + invokerPackage).replace(".", "/");
        final String supportFolder = invokerFolder + "/support";
        final String resourcesFolder = (projectFolder + "/resources");

        //Common files
        writeOptional(outputFolder, new SupportingFile("pom.mustache", "", "pom.xml"));
        writeOptional(outputFolder, new SupportingFile("README.mustache", "", "README.md"));
        writeOptional(outputFolder, new SupportingFile("Dockerfile.mustache", "", "Dockerfile"));

        supportingFiles.add(new SupportingFile("ApiCliBase.mustache", invokerFolder, "ApiCliBase.java"));
        supportingFiles.add(new SupportingFile("ApiClientOptions.mustache", supportFolder, "ApiClientOptions.java"));
        supportingFiles.add(new SupportingFile("ApiUtil.mustache", supportFolder, "ApiUtil.java"));
        supportingFiles.add(new SupportingFile("CdsClientShell.mustache", invokerFolder, "CdsClientShell.java"));
        supportingFiles.add(new SupportingFile("Common.mustache", invokerFolder, "Common.java"));
        supportingFiles.add(new SupportingFile("JsonPrinter.mustache", supportFolder, "JsonPrinter.java"));
        supportingFiles.add(new SupportingFile("ReferenceTest.mustache", invokerFolder, "ReferenceTest.java"));
        supportingFiles.add(new SupportingFile("logback.mustache", resourcesFolder, "logback.xml"));
        supportingFiles.add(new SupportingFile("application.mustache", resourcesFolder, "application.properties"));
        supportingFiles.add(new SupportingFile("banner.mustache", resourcesFolder, "banner.txt"));
        additionalProperties.put("gson", "true");
    }
}
