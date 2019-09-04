package au.org.consumerdatastandards.codegen.generator;

import au.org.consumerdatastandards.support.model.EndpointModel;
import au.org.consumerdatastandards.support.model.SectionModel;

import java.util.Set;

public class CodegenSection {

    private SectionModel sectionModel;

    public CodegenSection(SectionModel sectionModel) {
        this.sectionModel = sectionModel;
    }

    public Set<EndpointModel> getEndpointModels() {
        return sectionModel.getEndpointModels();
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
