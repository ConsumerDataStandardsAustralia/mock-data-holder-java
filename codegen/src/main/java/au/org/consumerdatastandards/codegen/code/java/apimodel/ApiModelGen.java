package au.org.consumerdatastandards.codegen.code.java.apimodel;

import au.org.consumerdatastandards.codegen.code.java.JavaCodegenBase;
import io.swagger.codegen.CodegenType;
import io.swagger.codegen.mustache.UppercaseLambda;

import java.io.File;

public class ApiModelGen extends JavaCodegenBase {

    public ApiModelGen() {
        super();
        sourceFolder = "src/gen/java";
        embeddedTemplateDir = templateDir = "ApiModel";
        artifactId = "api-model";
        apiPackage = "au.org.consumerdatastandards.api";
        modelPackage = "au.org.consumerdatastandards.api.models";
        modelDocTemplateFiles.clear();
        apiDocTemplateFiles.clear();
        apiTestTemplateFiles.clear();
        additionalProperties.put("uppercase", new UppercaseLambda());
    }

    @Override
    public CodegenType getTag() {
        return CodegenType.OTHER;
    }

    @Override
    public String getName() {
        return artifactId;
    }

    @Override
    public String getHelp() {
        return "Generate Consumer Data Standards API Models.";
    }

    @Override
    public String apiFilename(String templateName, String tag) {
        String suffix = apiTemplateFiles().get(templateName);
        return apiFileFolder() + File.separator + getApiSubPackage(tag) + File.separator + toApiFilename(tag) + suffix;
    }

    private String getApiSubPackage(String tag) {
        StringBuilder sb = new StringBuilder();
        int capitalCharOccurrence = 0;
        for (char c : tag.toCharArray()) {
            if (Character.isUpperCase(c)) {
                capitalCharOccurrence += 1;
            }
            if (capitalCharOccurrence < 2) {
                sb.append(Character.toLowerCase(c));
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
