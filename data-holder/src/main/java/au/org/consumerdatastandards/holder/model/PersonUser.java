package au.org.consumerdatastandards.holder.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("person")
public class PersonUser extends User {

    @ManyToOne
    private CommonPerson person;

    public CommonPerson getPerson() {
        return person;
    }

    public void setPerson(CommonPerson person) {
        this.person = person;
    }
}
