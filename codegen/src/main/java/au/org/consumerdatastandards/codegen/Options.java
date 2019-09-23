package au.org.consumerdatastandards.codegen;

import au.org.consumerdatastandards.support.model.ModelBuilderOptions;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import java.util.ArrayList;
import java.util.List;

@Parameters(commandDescription = "Perform Code Generation Tasks")
public class Options implements ModelBuilderOptions {

    @Parameter(names= {"--generator", "-g"}, description = "Name of the generator", order = 1)
    private String generatorName = "SwaggerGenerator";

    @Parameter(names = {"--included", "-i"}, description = "Included Sections (comma separated)", order = 2)
    private List<String> includedSections = new ArrayList<>();

    @Parameter(names = {"--excluded", "-e"}, description = "Excluded Sections (comma separated)", order = 3)
    private List<String> excludedSections = new ArrayList<>();

    @Parameter(names = {"--listSections", "-ls"}, description = "List API Sections", order = 4)
    private boolean listSections;

    @Parameter(names = {"--listGenerators", "-lg"}, description = "List Available Generators", order = 5)
    private boolean listGenerators;

    @Parameter(names = {"--listCodegenTypes", "-lct"}, description = "List Available Code Generator Types", order = 6)
    private boolean listCodegenTypes;

    @Parameter(names = {"--help", "-?", "-h" }, help = true)
    private boolean help;

    public Options include(List<String> includedSections) {
        this.includedSections = includedSections;
        return this;
    }

    public Options exclude(List<String> excludedSections) {
        this.excludedSections = excludedSections;
        return this;
    }

    public void setIncludedSections(List<String> includedSections) {
        this.includedSections = includedSections;
    }

    public void setExcludedSections(List<String> excludedSections) {
        this.excludedSections = excludedSections;
    }

    public String getGeneratorName() {
        return generatorName;
    }

    public boolean isSectionIncluded(String sectionName) {
        return includedSections.isEmpty() && excludedSections.isEmpty()
            || includedSections.contains(sectionName)
            || !excludedSections.isEmpty() && !excludedSections.contains(sectionName);
    }

    public boolean isHelp() {
        return help;
    }

    public boolean isListSections() {
        return listSections;
    }

    public boolean isListGenerators() {
        return listGenerators;
    }

    public boolean isListCodegenTypes() {
        return listCodegenTypes;
    }
}
