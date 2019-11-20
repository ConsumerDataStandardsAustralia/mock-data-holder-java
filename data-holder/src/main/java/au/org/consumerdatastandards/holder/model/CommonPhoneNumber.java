package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@ApiModel
@Entity
public class CommonPhoneNumber  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * Required for non Mobile Phones, if field is present and refers to Australian code - the leading 0 should be omitted.
     */
    private String areaCode;

    /**
     * If absent, assumed to be Australia (+61). The + should be included
     */
    private String countryCode;

    /**
     * An extension number (if applicable)
     */
    private String extension;

    /**
     * Fully formatted phone number with country code, area code, number and extension incorporated. Formatted according to section 5.1.4. of [RFC 3966](https://www.ietf.org/rfc/rfc3966.txt)
     */
    private String fullNumber;

    /**
     * May be true for one and only one entry to indicate the preferred phone number. Assumed to be 'false' if not present
     */
    private Boolean isPreferred;

    /**
     * The actual phone number, with leading zeros as appropriate
     */
    private String number;

    private Purpose purpose;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CommonPhoneNumber areaCode(String areaCode) {
        this.areaCode = areaCode;
        return this;
    }

    @ApiModelProperty(value = "Required for non Mobile Phones, if field is present and refers to Australian code - the leading 0 should be omitted.")
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public CommonPhoneNumber countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    @ApiModelProperty(value = "If absent, assumed to be Australia (+61). The + should be included")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public CommonPhoneNumber extension(String extension) {
        this.extension = extension;
        return this;
    }

    @ApiModelProperty(value = "An extension number (if applicable)")
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public CommonPhoneNumber fullNumber(String fullNumber) {
        this.fullNumber = fullNumber;
        return this;
    }

    @ApiModelProperty(required = true, value = "Fully formatted phone number with country code, area code, number and extension incorporated. Formatted according to section 5.1.4. of [RFC 3966](https://www.ietf.org/rfc/rfc3966.txt)")
    public String getFullNumber() {
        return fullNumber;
    }

    public void setFullNumber(String fullNumber) {
        this.fullNumber = fullNumber;
    }

    public CommonPhoneNumber isPreferred(Boolean isPreferred) {
        this.isPreferred = isPreferred;
        return this;
    }

    @ApiModelProperty(value = "May be true for one and only one entry to indicate the preferred phone number. Assumed to be 'false' if not present")
    public Boolean getIsPreferred() {
        return isPreferred;
    }

    public void setIsPreferred(Boolean isPreferred) {
        this.isPreferred = isPreferred;
    }

    public CommonPhoneNumber number(String number) {
        this.number = number;
        return this;
    }

    @ApiModelProperty(required = true, value = "The actual phone number, with leading zeros as appropriate")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CommonPhoneNumber purpose(Purpose purpose) {
        this.purpose = purpose;
        return this;
    }

    @ApiModelProperty(required = true)
    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommonPhoneNumber commonPhoneNumber = (CommonPhoneNumber) o;
        return Objects.equals(this.id, commonPhoneNumber.id) &&
            Objects.equals(this.areaCode, commonPhoneNumber.areaCode) &&
            Objects.equals(this.countryCode, commonPhoneNumber.countryCode) &&
            Objects.equals(this.extension, commonPhoneNumber.extension) &&
            Objects.equals(this.fullNumber, commonPhoneNumber.fullNumber) &&
            Objects.equals(this.isPreferred, commonPhoneNumber.isPreferred) &&
            Objects.equals(this.number, commonPhoneNumber.number) &&
            Objects.equals(this.purpose, commonPhoneNumber.purpose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            areaCode,
            countryCode,
            extension,
            fullNumber,
            isPreferred,
            number,
            purpose);
    }

    @Override
    public String toString() {
        return "class CommonPhoneNumber {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   areaCode: " + toIndentedString(areaCode) + "\n" +
            "   countryCode: " + toIndentedString(countryCode) + "\n" +
            "   extension: " + toIndentedString(extension) + "\n" + 
            "   fullNumber: " + toIndentedString(fullNumber) + "\n" + 
            "   isPreferred: " + toIndentedString(isPreferred) + "\n" + 
            "   number: " + toIndentedString(number) + "\n" + 
            "   purpose: " + toIndentedString(purpose) + "\n" + 
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

    public enum Purpose {
        HOME,
        INTERNATIONAL,
        MOBILE,
        OTHER,
        UNSPECIFIED,
        WORK
    }
}

