package au.org.consumerdatastandards.client.model.energy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyAccountDetailAuthorisedContacts
 */
public class EnergyAccountDetailAuthorisedContacts {
    private String firstName;

    private String lastName;

    private List<String> middleNames = null;

    private String prefix;

    private String suffix;

    public EnergyAccountDetailAuthorisedContacts firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * For people with single names this field need not be present. The single name should be in the lastName field
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public EnergyAccountDetailAuthorisedContacts lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * For people with single names the single name should be in this field
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EnergyAccountDetailAuthorisedContacts middleNames(List<String> middleNames) {
        this.middleNames = middleNames;
        return this;
    }

    public EnergyAccountDetailAuthorisedContacts addMiddleNamesItem(String middleNamesItem) {
        if (this.middleNames == null) {
            this.middleNames = new ArrayList<>();
        }
        this.middleNames.add(middleNamesItem);
        return this;
    }

    /**
     * Field is mandatory but array may be empty
     *
     * @return middleNames
     */
    public List<String> getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(List<String> middleNames) {
        this.middleNames = middleNames;
    }

    public EnergyAccountDetailAuthorisedContacts prefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    /**
     * Also known as title or salutation. The prefix to the name (e.g. Mr, Mrs, Ms, Miss, Sir, etc)
     *
     * @return prefix
     */
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public EnergyAccountDetailAuthorisedContacts suffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    /**
     * Used for a trailing suffix to the name (e.g. Jr)
     *
     * @return suffix
     */
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyAccountDetailAuthorisedContacts energyAccountDetailAuthorisedContacts = (EnergyAccountDetailAuthorisedContacts) o;
        return Objects.equals(this.firstName, energyAccountDetailAuthorisedContacts.firstName) &&
                Objects.equals(this.lastName, energyAccountDetailAuthorisedContacts.lastName) &&
                Objects.equals(this.middleNames, energyAccountDetailAuthorisedContacts.middleNames) &&
                Objects.equals(this.prefix, energyAccountDetailAuthorisedContacts.prefix) &&
                Objects.equals(this.suffix, energyAccountDetailAuthorisedContacts.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleNames, prefix, suffix);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyAccountDetailAuthorisedContacts {\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    middleNames: ").append(toIndentedString(middleNames)).append("\n");
        sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
        sb.append("    suffix: ").append(toIndentedString(suffix)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
