package au.org.consumerdatastandards.codegen.openapi;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import au.org.consumerdatastandards.support.model.APIModel;

import au.org.consumerdatastandards.codegen.AbstractGenerator;
import io.swagger.models.Swagger;
import io.swagger.util.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwaggerGenerator extends AbstractGenerator<SwaggerGeneratorOptions> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerGenerator.class);

    public SwaggerGenerator(APIModel newModel) {
        super(newModel);
    }

    @Override
    public void generate() {
        Swagger swagger = generateSwagger();
        if (options.getOutputFile() == null) {
            Json.prettyPrint(swagger);
        } else {
            writeSwaggerFile(swagger, options.getOutputFile());
        }
    }

    private Swagger generateSwagger() {
        return ModelSwaggerConverter.convert(apiModel);
    }

    private void writeSwaggerFile(Swagger swagger, String outputFile) {
        LOGGER.debug("Attempting swagger output file writing to {}", outputFile);
        FileWriter outputFileWriter = null;
        try {
            Files.createDirectories(Paths.get(outputFile));
            outputFileWriter = new FileWriter(outputFile);
            outputFileWriter.write(Json.pretty(swagger));
            outputFileWriter.flush();
        } catch (IOException e) {
            LOGGER.error("Error occurred while attempting to write swagger file {}", outputFile);
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (outputFileWriter != null) {
                try {
                    outputFileWriter.close();
                    LOGGER.info("Successfully wrote swagger to {}", outputFile);
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }

    @Override
    protected SwaggerGeneratorOptions createOptions() {
        return new SwaggerGeneratorOptions();
    }
}
