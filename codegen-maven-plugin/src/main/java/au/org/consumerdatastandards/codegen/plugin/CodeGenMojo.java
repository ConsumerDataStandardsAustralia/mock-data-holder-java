package au.org.consumerdatastandards.codegen.plugin;

import au.org.consumerdatastandards.codegen.generator.Options;
import au.org.consumerdatastandards.codegen.generator.code.CodeGenerator;
import au.org.consumerdatastandards.codegen.generator.code.CodegenOptions;
import au.org.consumerdatastandards.codegen.util.ModelSwaggerConverter;
import au.org.consumerdatastandards.support.model.APIModel;
import au.org.consumerdatastandards.support.model.ModelBuilder;
import io.swagger.util.Json;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Mojo(name = "generate-sources", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class CodeGenMojo extends AbstractMojo {

    @Parameter(name = "verbose", defaultValue = "false")
    private boolean verbose;

    @Parameter(name = "language", required = true)
    private String language;

    @Parameter(
            name = "generatedSwaggerFile",
            defaultValue = "cds-codegen-generated-swagger.json"
    )
    private String generatedSwaggerFile;

    @Parameter(
            name = "outputDirectory",
            required = true,
            property = "au.org.consumerdatastandards.codegen.maven.plugin.outputDirectory"
    )
    private File outputDirectory;

    @Parameter(
            name = "includedSections",
            property = "au.org.consumerdatastandards.codegen.maven.plugin.includedSections"
    )
    private List<String> includedSections;

    @Parameter(
            name = "excludedSections",
            property = "au.org.consumerdatastandards.codegen.maven.plugin.excludedSections"
    )
    private List<String> excludedSections;

    @Override
    public void execute() throws MojoExecutionException {

        Options options = new Options().include(includedSections).exclude(excludedSections);
        ModelBuilder modelBuilder = new ModelBuilder(options);
        APIModel apiModel = modelBuilder.build();

        String generatedSwagger = Json.pretty(ModelSwaggerConverter.convert(apiModel));

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(generatedSwaggerFile));
            System.out.println(generatedSwagger);
            bufferedWriter.write(generatedSwagger);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new MojoExecutionException(e.getMessage(), e);
        }

        try {
            CodeGenerator generator = new CodeGenerator(apiModel);
            CodegenOptions codegenOptions = new CodegenOptions().templatePath(language)
                    .outputPath(outputDirectory.getAbsolutePath());
            generator.setOptions(codegenOptions);
            generator.generate();
        } catch (Exception e) {
            throw new MojoExecutionException(e.toString());
        }
    }
}
