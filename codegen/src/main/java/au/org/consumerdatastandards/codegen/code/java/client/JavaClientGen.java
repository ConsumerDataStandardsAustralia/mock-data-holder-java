package au.org.consumerdatastandards.codegen.code.java.client;

import au.org.consumerdatastandards.codegen.code.java.JavaCodegenBase;
import io.swagger.codegen.CodegenModel;
import io.swagger.codegen.CodegenProperty;
import io.swagger.codegen.CodegenType;
import io.swagger.codegen.SupportingFile;

import java.io.File;

public class JavaClientGen extends JavaCodegenBase {

    private static final String DEFAULT_BASE_PACKAGE = "au.org.consumerdatastandards.client";

    public JavaClientGen() {
        super();
        outputFolder = "generated-code" + File.separator + "client";
        embeddedTemplateDir = templateDir = "JavaClient";
        invokerPackage = DEFAULT_BASE_PACKAGE;
        apiPackage = DEFAULT_BASE_PACKAGE + ".api";
        modelPackage = DEFAULT_BASE_PACKAGE + ".model";
        artifactId = "client";
    }

    @Override
    public CodegenType getTag() {
        return CodegenType.CLIENT;
    }

    @Override
    public String getName() {
        return "java-client";
    }

    @Override
    public String getHelp() {
        return "Generates a Java client library.";
    }

    @Override
    public void processOpts() {
        super.processOpts();

        final String invokerFolder = (sourceFolder + '/' + invokerPackage).replace(".", "/");

        //Common files
        writeOptional(outputFolder, new SupportingFile("pom.mustache", "", "pom.xml"));
        writeOptional(outputFolder, new SupportingFile("README.mustache", "", "README.md"));

        supportingFiles.add(new SupportingFile("ApiClient.mustache", invokerFolder, "ApiClient.java"));
        supportingFiles.add(new SupportingFile("ApiException.mustache", invokerFolder, "ApiException.java"));
        supportingFiles.add(new SupportingFile("Pair.mustache", invokerFolder, "Pair.java"));
        supportingFiles.add(new SupportingFile("ApiCallback.mustache", invokerFolder, "ApiCallback.java"));
        supportingFiles.add(new SupportingFile("ApiResponse.mustache", invokerFolder, "ApiResponse.java"));
        supportingFiles.add(new SupportingFile("JSON.mustache", invokerFolder, "JSON.java"));
        supportingFiles.add(new SupportingFile("ProgressRequestBody.mustache", invokerFolder, "ProgressRequestBody.java"));
        supportingFiles.add(new SupportingFile("ProgressResponseBody.mustache", invokerFolder, "ProgressResponseBody.java"));
        additionalProperties.put("gson", "true");
    }

    @Override
    public void postProcessModelProperty(CodegenModel model, CodegenProperty property) {
        if (!fullJavaUtil) {
            if ("array".equals(property.containerType)) {
                model.imports.add("ArrayList");
            } else if ("map".equals(property.containerType)) {
                model.imports.add("HashMap");
            }
        }
    }
}