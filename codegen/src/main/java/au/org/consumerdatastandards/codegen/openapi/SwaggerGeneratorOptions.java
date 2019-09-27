package au.org.consumerdatastandards.codegen.openapi;

import au.org.consumerdatastandards.codegen.Options;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "Generate swagger json file out of api model")
public class SwaggerGeneratorOptions extends Options {

    @Parameter(names = {"--output-file", "-o"}, description = "Output file to place generated swagger")
    private String outputFile;
    
    public String getOutputFile() {
        return outputFile;
    }
}
