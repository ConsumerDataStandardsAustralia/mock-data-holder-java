package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoAccountDetailAuthorisedContacts
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoAccountDetailAuthorisedContacts {
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("middleNames")
    @Valid
    private List<String> middleNames = null;

    @JsonProperty("prefix")
    private String prefix;

    @JsonProperty("suffix")
    private String suffix;

    public TelcoAccountDetailAuthorisedContacts firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * For people with single names this field need not be present. The single name should be in the _lastName_ field.
     *
     * @return firstName
     */
    @ApiModelProperty(value = "For people with single names this field need not be present. The single name should be in the _lastName_ field.")


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public TelcoAccountDetailAuthorisedContacts lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * For people with single names the single name should be in this field.
     *
     * @return lastName
     */
    @ApiModelProperty(required = true,
            value = "For people with single names the single name should be in this field.")
    @NotNull


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public TelcoAccountDetailAuthorisedContacts middleNames(List<String> middleNames) {
        this.middleNames = middleNames;
        return this;
    }

    public TelcoAccountDetailAuthorisedContacts addMiddleNamesItem(String middleNamesItem) {
        if (this.middleNames == null) {
            this.middleNames = new ArrayList<>();
        }
        this.middleNames.add(middleNamesItem);
        return this;
    }

    /**
     * Field is mandatory but array may be empty.
     *
     * @return middleNames
     */
    @ApiModelProperty(value = "Field is mandatory but array may be empty.")


    public List<String> getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(List<String> middleNames) {
        this.middleNames = middleNames;
    }

    public TelcoAccountDetailAuthorisedContacts prefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    /**
     * Also known as title or salutation. The prefix to the name (e.g., Mr, Mrs, Ms, Miss, Sir, etc.)
     *
     * @return prefix
     */
    @ApiModelProperty(value = "Also known as title or salutation. The prefix to the name (e.g., Mr, Mrs, Ms, Miss, Sir, etc.)")


    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public TelcoAccountDetailAuthorisedContacts suffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    /**
     * Used for a trailing suffix to the name (e.g., Jr.)
     *
     * @return suffix
     */
    @ApiModelProperty(value = "Used for a trailing suffix to the name (e.g., Jr.)")


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
        TelcoAccountDetailAuthorisedContacts telcoAccountDetailAuthorisedContacts = (TelcoAccountDetailAuthorisedContacts) o;
        return Objects.equals(this.firstName, telcoAccountDetailAuthorisedContacts.firstName) &&
                Objects.equals(this.lastName, telcoAccountDetailAuthorisedContacts.lastName) &&
                Objects.equals(this.middleNames, telcoAccountDetailAuthorisedContacts.middleNames) &&
                Objects.equals(this.prefix, telcoAccountDetailAuthorisedContacts.prefix) &&
                Objects.equals(this.suffix, telcoAccountDetailAuthorisedContacts.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleNames, prefix, suffix);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoAccountDetailAuthorisedContacts {\n");

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

