package au.org.consumerdatastandards.support.model;

import java.util.Set;
import java.util.TreeSet;

public class APIModel extends ModelBase {

    final private String version = "1.0.0";

    private Set<SectionModel> sectionModels = new TreeSet<>();

    public Set<SectionModel> getSectionModels() {
        return sectionModels;
    }

    public void add(SectionModel sectionModel) {

        sectionModels.add(sectionModel);
    }

    public String getVersion() {
        return version;
    }
}
