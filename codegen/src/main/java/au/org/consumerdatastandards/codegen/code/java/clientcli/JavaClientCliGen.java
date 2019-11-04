package au.org.consumerdatastandards.codegen.code.java.clientcli;

import au.org.consumerdatastandards.codegen.code.java.client.JavaClientGen;
import io.swagger.codegen.CodegenParameter;
import io.swagger.codegen.SupportingFile;

import java.io.File;
import java.util.*;

public class JavaClientCliGen extends JavaClientGen {
    private static final String DEFAULT_BASE_PACKAGE = "au.org.consumerdatastandards.client.cli";

    public JavaClientCliGen() {
        super();
        outputFolder = "generated-code" + File.separator + "client-cli";
        embeddedTemplateDir = templateDir = "JavaClientCli";
        invokerPackage = DEFAULT_BASE_PACKAGE;
        apiPackage = invokerPackage;
        modelPackage = invokerPackage.replace("client.cli", "client.model");
        artifactId = "client-cli";
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
    public String toApiName(String name) {
        return name;
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

        supportingFiles.clear();
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

    @Override
    public Map<String, Object> postProcessAllModels(Map<String, Object> objs) {
        return new HashMap<>(); // no models needed for client-cli
    }

    @Override
    public Map<String, Object> postProcessOperations(Map<String, Object> objs) {
        super.postProcessOperations(objs);
        Map<String, Object> obj = (Map<String, Object>) objs.get("operations");
        List<CdsCodegenOperation> operations = (List<CdsCodegenOperation>) obj.get("operation");
        Set<String> addedImports = new HashSet<>();
        List imports = (List) objs.get("imports");
        for (CdsCodegenOperation co : operations) {
            for (CodegenParameter cp : co.allParams) {
                CdsCodegenParameter ccp = (CdsCodegenParameter) cp;
                if (ccp.isEnum && !ccp.isReference && !addedImports.contains(ccp.datatypeWithEnum)) {
                    imports.add(new HashMap<String, String>() {{
                        String clientApiPackage = apiPackage.replace("client.cli", "client.api");
                        String clientApiName = obj.get("classname") + "API";
                        put("import", clientApiPackage + "." + clientApiName + "." + ccp.datatypeWithEnum);
                    }});
                    addedImports.add(ccp.datatypeWithEnum);
                }
            }
        }
        return objs;
    }
}
