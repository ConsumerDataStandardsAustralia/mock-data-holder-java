package au.org.consumerdatastandards.codegen.generator.code;

import au.org.consumerdatastandards.codegen.generator.Options;

import java.util.List;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "Generate code based on templates")
public class CodegenOptions extends Options {

    @Parameter(
        names = {"--template-path", "-t"},
        description = "path to templates (can be absolute or classpath reference)",
        required = true
    )
    private String templatePath;
    
    @Parameter(names = {"--output-path", "-o"}, description = "output path")
    private String outputPath = "./cds-generated";

    public String getConfigFilePath() {
        return templatePath + "/config.json";
    }

    public String getOutputPath() {
        return outputPath;
    }

    public CodegenOptions templatePath(String templatePath) {
        this.templatePath = templatePath;
        return this;
    }

    public CodegenOptions outputPath(String outputPath) {
        this.outputPath = outputPath;
        return this;
    }
}
