package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * The address of the service point.  Mandatory if addressUType is set to simple
 */
@ApiModel(description = "The address of the service point.  Mandatory if addressUType is set to simple")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyServicePointDetailLocationSimple {
    @JsonProperty("mailingName")
    private String mailingName;

    @JsonProperty("addressLine1")
    private String addressLine1;

    @JsonProperty("addressLine2")
    private String addressLine2;

    @JsonProperty("addressLine3")
    private String addressLine3;

    @JsonProperty("postcode")
    private String postcode;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("country")
    private String country = "AUS";

    public EnergyServicePointDetailLocationSimple mailingName(String mailingName) {
        this.mailingName = mailingName;
        return this;
    }

    /**
     * Name of the individual or business formatted for inclusion in an address used for physical mail
     *
     * @return mailingName
     */
    @ApiModelProperty(value = "Name of the individual or business formatted for inclusion in an address used for physical mail")


    public String getMailingName() {
        return mailingName;
    }

    public void setMailingName(String mailingName) {
        this.mailingName = mailingName;
    }

    public EnergyServicePointDetailLocationSimple addressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    /**
     * First line of the standard address object
     *
     * @return addressLine1
     */
    @ApiModelProperty(required = true,
            value = "First line of the standard address object")
    @NotNull


    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public EnergyServicePointDetailLocationSimple addressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    /**
     * Second line of the standard address object
     *
     * @return addressLine2
     */
    @ApiModelProperty(value = "Second line of the standard address object")


    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public EnergyServicePointDetailLocationSimple addressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
        return this;
    }

    /**
     * Third line of the standard address object
     *
     * @return addressLine3
     */
    @ApiModelProperty(value = "Third line of the standard address object")


    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public EnergyServicePointDetailLocationSimple postcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    /**
     * Mandatory for Australian addresses
     *
     * @return postcode
     */
    @ApiModelProperty(value = "Mandatory for Australian addresses")


    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public EnergyServicePointDetailLocationSimple city(String city) {
        this.city = city;
        return this;
    }

    /**
     * Name of the city or locality
     *
     * @return city
     */
    @ApiModelProperty(required = true,
            value = "Name of the city or locality")
    @NotNull


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public EnergyServicePointDetailLocationSimple state(String state) {
        this.state = state;
        return this;
    }

    /**
     * Free text if the country is not Australia. If country is Australia then must be one of the values defined by the [State Type Abbreviation](https://auspost.com.au/content/dam/auspost_corp/media/documents/australia-post-data-guide.pdf) in the PAF file format. NSW, QLD, VIC, NT, WA, SA, TAS, ACT, AAT
     *
     * @return state
     */
    @ApiModelProperty(required = true,
            value = "Free text if the country is not Australia. If country is Australia then must be one of the values defined by the [State Type Abbreviation](https://auspost.com.au/content/dam/auspost_corp/media/documents/australia-post-data-guide.pdf) in the PAF file format. NSW, QLD, VIC, NT, WA, SA, TAS, ACT, AAT")
    @NotNull


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public EnergyServicePointDetailLocationSimple country(String country) {
        this.country = country;
        return this;
    }

    /**
     * A valid [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country code. Australia (AUS) is assumed if country is not present.
     *
     * @return country
     */
    @ApiModelProperty(value = "A valid [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country code. Australia (AUS) is assumed if country is not present.")


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyServicePointDetailLocationSimple energyServicePointDetailLocationSimple = (EnergyServicePointDetailLocationSimple) o;
        return Objects.equals(this.mailingName, energyServicePointDetailLocationSimple.mailingName) &&
                Objects.equals(this.addressLine1, energyServicePointDetailLocationSimple.addressLine1) &&
                Objects.equals(this.addressLine2, energyServicePointDetailLocationSimple.addressLine2) &&
                Objects.equals(this.addressLine3, energyServicePointDetailLocationSimple.addressLine3) &&
                Objects.equals(this.postcode, energyServicePointDetailLocationSimple.postcode) &&
                Objects.equals(this.city, energyServicePointDetailLocationSimple.city) &&
                Objects.equals(this.state, energyServicePointDetailLocationSimple.state) &&
                Objects.equals(this.country, energyServicePointDetailLocationSimple.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mailingName, addressLine1, addressLine2, addressLine3, postcode, city, state, country);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyServicePointDetailLocationSimple {\n");

        sb.append("    mailingName: ").append(toIndentedString(mailingName)).append("\n");
        sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
        sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
        sb.append("    addressLine3: ").append(toIndentedString(addressLine3)).append("\n");
        sb.append("    postcode: ").append(toIndentedString(postcode)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
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

