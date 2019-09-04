package au.org.consumerdatastandards.codegen.generator.code.handler.datadefinition;

import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;

public class DataDefinitionHandlerConfig extends AbstractHandlerConfig {

    private String modelTemplate;
    private String enumTemplate;
    private String fileName;
    private String filePath;
    private String inlineEnumTemplate;
    private String inlineModelTemplate;

    public String getModelTemplate() {
        return modelTemplate;
    }

    public String getEnumTemplate() {
        return enumTemplate;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getInlineEnumTemplate() {
        return inlineEnumTemplate;
    }

    public String getInlineModelTemplate() {
        return inlineModelTemplate;
    }
}
