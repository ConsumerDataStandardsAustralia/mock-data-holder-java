package au.org.consumerdatastandards.codegen.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CodegenDataDefinition {

    public String definitionName;
    public List<CodegenDataDefinitionField> fieldList = new ArrayList<>();
    public String packageName;
    public String definitionDescription;
    public List<CodegenDataDefinition> nestedModelList = new ArrayList<>();

    public boolean isEnum;
    public String renderedNestedModels;
    public String extendsOn;

    public String getDefinitionName() {
        return definitionName;
    }
    public List<CodegenDataDefinitionField> getFieldList() {
        return fieldList;
    }
    public String getPackageName() {
        return packageName;
    }

    public String getDefinitionDescription() {
        return definitionDescription;
    }

    public List<CodegenDataDefinition> getNestedDefinitions() {
        return nestedModelList;
    }
    public void addNestedDefinition(CodegenDataDefinition nestedDefinition) {
        this.nestedModelList.add(nestedDefinition);
    }
    public String getRenderedNestedModels() {
        return renderedNestedModels;
    }
    public void setRenderedNestedModels(String renderedNestedModels) {
        this.renderedNestedModels = renderedNestedModels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodegenDataDefinition that = (CodegenDataDefinition) o;
        return Objects.equals(definitionName, that.definitionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(definitionName);
    }
}
