package au.org.consumerdatastandards.codegen.generator;

import au.org.consumerdatastandards.support.model.SectionModel;

public class CodegenSection {

    public CodegenSection(SectionModel sectionModel) {

    }

    private String interfaceName;

    private String packageName;


    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
