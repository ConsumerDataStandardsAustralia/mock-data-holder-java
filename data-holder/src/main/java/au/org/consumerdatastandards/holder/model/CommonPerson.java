package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.time.OffsetDateTime;
import java.util.List;

@ApiModel
@Entity
@Table(name = "CommonPerson")
public class CommonPerson  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * For people with single names this field need not be present.  The single name should be in the lastName field
     */
    private String firstName;

    /**
     * For people with single names the single name should be in this field
     */
    private String lastName;

    /**
     * The date and time that this record was last updated by the customer.  If no update has occurred then this date should reflect the initial creation date for the data
     */
    private OffsetDateTime lastUpdateTime;

    /**
     * Field is mandatory but array may be empty
     */
    @ElementCollection
    private List<String> middleNames;

    /**
     * Value is a valid [ANZCO v1.2](http://www.abs.gov.au/ANZSCO) Standard Occupation classification.
     */
    private String occupationCode;

    /**
     * Also known as title or salutation.  The prefix to the name (e.g. Mr, Mrs, Ms, Miss, Sir, etc)
     */
    private String prefix;

    /**
     * Used for a trailing suffix to the name (e.g. Jr)
     */
    private String suffix;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CommonPerson firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @ApiModelProperty(value = "For people with single names this field need not be present.  The single name should be in the lastName field")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public CommonPerson lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @ApiModelProperty(required = true, value = "For people with single names the single name should be in this field")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CommonPerson lastUpdateTime(OffsetDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    @ApiModelProperty(value = "The date and time that this record was last updated by the customer.  If no update has occurred then this date should reflect the initial creation date for the data")
    public OffsetDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(OffsetDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public CommonPerson middleNames(List<String> middleNames) {
        this.middleNames = middleNames;
        return this;
    }

    public CommonPerson addItem(String middleNamesItem) {
        this.middleNames.add(middleNamesItem);
        return this;
    }

    @ApiModelProperty(required = true, value = "Field is mandatory but array may be empty")
    public List<String> getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(List<String> middleNames) {
        this.middleNames = middleNames;
    }

    public CommonPerson occupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
        return this;
    }

    @ApiModelProperty(value = "Value is a valid [ANZCO v1.2](http://www.abs.gov.au/ANZSCO) Standard Occupation classification.")
    public String getOccupationCode() {
        return occupationCode;
    }

    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    public CommonPerson prefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    @ApiModelProperty(value = "Also known as title or salutation.  The prefix to the name (e.g. Mr, Mrs, Ms, Miss, Sir, etc)")
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public CommonPerson suffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    @ApiModelProperty(value = "Used for a trailing suffix to the name (e.g. Jr)")
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
        CommonPerson commonPerson = (CommonPerson) o;
        return Objects.equals(this.id, commonPerson.id) &&
            Objects.equals(this.firstName, commonPerson.firstName) &&
            Objects.equals(this.lastName, commonPerson.lastName) &&
            Objects.equals(this.lastUpdateTime, commonPerson.lastUpdateTime) &&
            Objects.equals(this.middleNames, commonPerson.middleNames) &&
            Objects.equals(this.occupationCode, commonPerson.occupationCode) &&
            Objects.equals(this.prefix, commonPerson.prefix) &&
            Objects.equals(this.suffix, commonPerson.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            firstName,
            lastName,
            lastUpdateTime,
            middleNames,
            occupationCode,
            prefix,
            suffix);
    }

    @Override
    public String toString() {
        return "class CommonPerson {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   firstName: " + toIndentedString(firstName) + "\n" +
            "   lastName: " + toIndentedString(lastName) + "\n" +
            "   lastUpdateTime: " + toIndentedString(lastUpdateTime) + "\n" + 
            "   middleNames: " + toIndentedString(middleNames) + "\n" + 
            "   occupationCode: " + toIndentedString(occupationCode) + "\n" + 
            "   prefix: " + toIndentedString(prefix) + "\n" + 
            "   suffix: " + toIndentedString(suffix) + "\n" + 
            "}";
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

