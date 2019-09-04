package au.org.consumerdatastandards.codegen.generator.code.handler.section;

import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;

public class SectionHandlerConfig extends AbstractHandlerConfig {

    private String templateFile;
    private String fileName;
    private String filePath;

    public String getTemplateFile() {
        return templateFile;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }
}
