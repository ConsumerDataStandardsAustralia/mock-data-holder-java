package au.org.consumerdatastandards.codegen.generator.openapi;

import au.org.consumerdatastandards.codegen.generator.Options;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "Generate swagger json file out of cds models")
public class SwaggerGeneratorOptions extends Options {

    @Parameter(names = {"--output-file", "-o"}, description = "Output file to place generated swagger")
    private String outputFile;
    
    public String getOutputFile() {
        return outputFile;
    }
}
