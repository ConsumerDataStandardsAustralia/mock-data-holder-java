package au.org.consumerdatastandards.holder.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("organisation")
public class OrganisationUser extends User {

    @ManyToOne
    private CommonOrganisation organisation;

    public CommonOrganisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(CommonOrganisation organisation) {
        this.organisation = organisation;
    }
}
