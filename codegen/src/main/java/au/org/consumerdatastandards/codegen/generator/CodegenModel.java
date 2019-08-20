package au.org.consumerdatastandards.codegen.generator;

import java.util.LinkedHashSet;
import java.util.Set;

public class CodegenModel {

    private Set<CodegenSection> codegenSections = new LinkedHashSet<>();
    private Set<CodegenDataDefinition> dataDefinitions = new LinkedHashSet<>();

    public void addCodegenSection(CodegenSection codegenSection) {
        codegenSections.add(codegenSection);
    }

    public void addDataDefinition(CodegenDataDefinition dataDefinition) {
        dataDefinitions.add(dataDefinition);
    }

    public boolean containsDataDefinition(CodegenDataDefinition dataDefinition) {
        return dataDefinitions.contains(dataDefinition);
    }

    public Set<CodegenSection> getCodegenSections() {
        return codegenSections;
    }

    public Set<CodegenDataDefinition> getDataDefinitions() {
        return dataDefinitions;
    }
}
