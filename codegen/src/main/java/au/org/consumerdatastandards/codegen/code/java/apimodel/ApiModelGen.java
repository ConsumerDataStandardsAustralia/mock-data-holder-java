package au.org.consumerdatastandards.codegen.code.java.apimodel;

import au.org.consumerdatastandards.codegen.code.java.JavaCodegenBase;
import io.swagger.codegen.CodegenOperation;
import io.swagger.codegen.CodegenResponse;
import io.swagger.codegen.CodegenType;
import io.swagger.codegen.mustache.UppercaseLambda;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ApiModelGen extends JavaCodegenBase {

    enum ResponseCode {
        OK("200"),
        CREATED("201"),
        ACCEPTED("202"),
        NO_CONTENT("204"),
        BAD_REQUEST("400"),
        UNAUTHORIZED("401"),
        FORBIDDEN("403"),
        UNPROCESSABLE_ENTITY("422"),
        TOO_MANY_REQUESTS("429");

        String code;

        ResponseCode(String code) {
            this.code = code;
        }

        static ResponseCode of(String code) {
            for (ResponseCode value : values()) {
                if (value.code.equals(code)) {
                    return value;
                }
            }
            return null;
        }
    }

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

    @Override
    public Map<String, Object> postProcessOperations(Map<String, Object> objs) {
        Map<String, Object> processedObjs = super.postProcessOperations(objs);
        Map<String, Object> obj = (Map<String, Object>) objs.get("operations");
        List<CdsCodegenOperation> operations = (List<CdsCodegenOperation>) obj.get("operation");
        for (CdsCodegenOperation co : operations) {
            for (CodegenResponse cr : co.responses) {
                ResponseCode responseCode = ResponseCode.of(cr.code);
                cr.code = "ResponseCode." + (responseCode == null ? cr.code : responseCode);
            }
        }
        return processedObjs;
    }
}
