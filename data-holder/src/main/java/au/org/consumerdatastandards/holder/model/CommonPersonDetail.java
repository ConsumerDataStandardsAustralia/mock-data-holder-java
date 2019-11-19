package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@ApiModel
@Entity
@Table(name = "CommonPerson")
public class CommonPersonDetail {

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

    /**
     * May be empty
     */
    @OneToMany
    @JoinTable(
        name = "person_email_addresses",
        joinColumns = @JoinColumn(name = "person_id"),
        inverseJoinColumns = @JoinColumn(name = "email_address_id"))
    private List<CommonEmailAddress> emailAddresses;

    /**
     * Array is mandatory but may be empty if no phone numbers are held
     */
    @OneToMany
    @JoinTable(
        name = "person_phone_numbers",
        joinColumns = @JoinColumn(name = "person_id"),
        inverseJoinColumns = @JoinColumn(name = "phone_number_id"))
    private List<CommonPhoneNumber> phoneNumbers;

    /**
     * Must contain at least one address. One and only one address may have the purpose of REGISTERED. Zero or one, and no more than one, record may have the purpose of MAIL. If zero then the REGISTERED address is to be used for mail
     */
    @OneToMany
    @JoinTable(
        name = "person_physical_addresses",
        joinColumns = @JoinColumn(name = "person_id"),
        inverseJoinColumns = @JoinColumn(name = "physical_address_id"))
    private List<CommonPhysicalAddressWithPurpose> physicalAddresses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public OffsetDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(OffsetDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public List<String> getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(List<String> middleNames) {
        this.middleNames = middleNames;
    }

    public String getOccupationCode() {
        return occupationCode;
    }

    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public CommonPersonDetail firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CommonPersonDetail lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CommonPersonDetail lastUpdateTime(OffsetDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    public CommonPersonDetail middleNames(List<String> middleNames) {
        this.middleNames = middleNames;
        return this;
    }

    public CommonPersonDetail addItem(String middleNamesItem) {
        this.middleNames.add(middleNamesItem);
        return this;
    }

    public CommonPersonDetail occupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
        return this;
    }

    public CommonPersonDetail prefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public CommonPersonDetail suffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    public CommonPersonDetail emailAddresses(List<CommonEmailAddress> emailAddresses) {
        this.emailAddresses = emailAddresses;
        return this;
    }

    public CommonPersonDetail addItem(CommonEmailAddress emailAddressesItem) {
        this.emailAddresses.add(emailAddressesItem);
        return this;
    }

    @ApiModelProperty(required = true, value = "May be empty")
    public List<CommonEmailAddress> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<CommonEmailAddress> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }
    public CommonPersonDetail phoneNumbers(List<CommonPhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        return this;
    }

    public CommonPersonDetail addItem(CommonPhoneNumber phoneNumbersItem) {
        this.phoneNumbers.add(phoneNumbersItem);
        return this;
    }

    @ApiModelProperty(required = true, value = "Array is mandatory but may be empty if no phone numbers are held")
    public List<CommonPhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<CommonPhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
    public CommonPersonDetail physicalAddresses(List<CommonPhysicalAddressWithPurpose> physicalAddresses) {
        this.physicalAddresses = physicalAddresses;
        return this;
    }

    public CommonPersonDetail addItem(CommonPhysicalAddressWithPurpose physicalAddressesItem) {
        this.physicalAddresses.add(physicalAddressesItem);
        return this;
    }

    @ApiModelProperty(required = true, value = "Must contain at least one address. One and only one address may have the purpose of REGISTERED. Zero or one, and no more than one, record may have the purpose of MAIL. If zero then the REGISTERED address is to be used for mail")
    public List<CommonPhysicalAddressWithPurpose> getPhysicalAddresses() {
        return physicalAddresses;
    }

    public void setPhysicalAddresses(List<CommonPhysicalAddressWithPurpose> physicalAddresses) {
        this.physicalAddresses = physicalAddresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommonPersonDetail commonPersonDetail = (CommonPersonDetail) o;
        return Objects.equals(this.emailAddresses, commonPersonDetail.emailAddresses) &&
            Objects.equals(this.phoneNumbers, commonPersonDetail.phoneNumbers) &&
            Objects.equals(this.physicalAddresses, commonPersonDetail.physicalAddresses) &&
            super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            emailAddresses,
            phoneNumbers,
            physicalAddresses,
            super.hashCode());
    }

    @Override
    public String toString() {
        return "class CommonPersonDetail {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   firstName: " + toIndentedString(getFirstName()) + "\n" +
            "   lastName: " + toIndentedString(getLastName()) + "\n" +
            "   lastUpdateTime: " + toIndentedString(getLastUpdateTime()) + "\n" + 
            "   middleNames: " + toIndentedString(getMiddleNames()) + "\n" + 
            "   occupationCode: " + toIndentedString(getOccupationCode()) + "\n" + 
            "   prefix: " + toIndentedString(getPrefix()) + "\n" + 
            "   suffix: " + toIndentedString(getSuffix()) + "\n" + 
            "   emailAddresses: " + toIndentedString(emailAddresses) + "\n" + 
            "   phoneNumbers: " + toIndentedString(phoneNumbers) + "\n" + 
            "   physicalAddresses: " + toIndentedString(physicalAddresses) + "\n" + 
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