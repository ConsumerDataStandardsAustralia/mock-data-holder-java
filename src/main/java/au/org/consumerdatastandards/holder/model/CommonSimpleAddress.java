package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Embeddable;
import java.util.Objects;

@ApiModel
@Embeddable
public class CommonSimpleAddress  {

    /**
     * First line of the standard address object
     */
    private String addressLine1;

    /**
     * Second line of the standard address object
     */
    private String addressLine2;

    /**
     * Third line of the standard address object
     */
    private String addressLine3;

    /**
     * Name of the city or locality
     */
    private String city;

    /**
     * A valid [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country code. Australia (AUS) is assumed if country is not present.
     */
    private String country;

    /**
     * Name of the individual or business formatted for inclusion in an address used for physical mail
     */
    private String mailingName;

    /**
     * Mandatory for Australian addresses
     */
    private String postcode;

    /**
     * Free text if the country is not Australia. If country is Australia then must be one of the values defined by the [State Type Abbreviation](https://auspost.com.au/content/dam/auspost_corp/media/documents/australia-post-data-guide.pdf) in the PAF file format. NSW, QLD, VIC, NT, WA, SA, TAS, ACT, AAT
     */
    private String state;

    public CommonSimpleAddress addressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    @ApiModelProperty(required = true, value = "First line of the standard address object")
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    public CommonSimpleAddress addressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    @ApiModelProperty(value = "Second line of the standard address object")
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public CommonSimpleAddress addressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
        return this;
    }

    @ApiModelProperty(value = "Third line of the standard address object")
    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public CommonSimpleAddress city(String city) {
        this.city = city;
        return this;
    }

    @ApiModelProperty(required = true, value = "Name of the city or locality")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CommonSimpleAddress country(String country) {
        this.country = country;
        return this;
    }

    @ApiModelProperty(value = "A valid [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country code. Australia (AUS) is assumed if country is not present.")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CommonSimpleAddress mailingName(String mailingName) {
        this.mailingName = mailingName;
        return this;
    }

    @ApiModelProperty(value = "Name of the individual or business formatted for inclusion in an address used for physical mail")
    public String getMailingName() {
        return mailingName;
    }

    public void setMailingName(String mailingName) {
        this.mailingName = mailingName;
    }

    public CommonSimpleAddress postcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    @ApiModelProperty(value = "Mandatory for Australian addresses")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public CommonSimpleAddress state(String state) {
        this.state = state;
        return this;
    }

    @ApiModelProperty(required = true, value = "Free text if the country is not Australia. If country is Australia then must be one of the values defined by the [State Type Abbreviation](https://auspost.com.au/content/dam/auspost_corp/media/documents/australia-post-data-guide.pdf) in the PAF file format. NSW, QLD, VIC, NT, WA, SA, TAS, ACT, AAT")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommonSimpleAddress commonSimpleAddress = (CommonSimpleAddress) o;
        return Objects.equals(this.addressLine1, commonSimpleAddress.addressLine1) &&
            Objects.equals(this.addressLine2, commonSimpleAddress.addressLine2) &&
            Objects.equals(this.addressLine3, commonSimpleAddress.addressLine3) &&
            Objects.equals(this.city, commonSimpleAddress.city) &&
            Objects.equals(this.country, commonSimpleAddress.country) &&
            Objects.equals(this.mailingName, commonSimpleAddress.mailingName) &&
            Objects.equals(this.postcode, commonSimpleAddress.postcode) &&
            Objects.equals(this.state, commonSimpleAddress.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            addressLine1,
            addressLine2,
            addressLine3,
            city,
            country,
            mailingName,
            postcode,
            state);
    }

    @Override
    public String toString() {
        return "class CommonSimpleAddress {\n" +
            "   addressLine1: " + toIndentedString(addressLine1) + "\n" +
            "   addressLine2: " + toIndentedString(addressLine2) + "\n" +
            "   addressLine3: " + toIndentedString(addressLine3) + "\n" + 
            "   city: " + toIndentedString(city) + "\n" + 
            "   country: " + toIndentedString(country) + "\n" + 
            "   mailingName: " + toIndentedString(mailingName) + "\n" + 
            "   postcode: " + toIndentedString(postcode) + "\n" + 
            "   state: " + toIndentedString(state) + "\n" + 
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

