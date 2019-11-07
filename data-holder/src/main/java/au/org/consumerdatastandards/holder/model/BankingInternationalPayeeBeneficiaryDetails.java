package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class BankingInternationalPayeeBeneficiaryDetails  {

    /**
     * Country where the beneficiary resides. A valid [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country code
     */
    private String country;

    /**
     * Response message for the payment
     */
    private String message;

    /**
     * Name of the beneficiary
     */
    private String name;

    public BankingInternationalPayeeBeneficiaryDetails country(String country) {
        this.country = country;
        return this;
    }

    @ApiModelProperty(required = true, value = "Country where the beneficiary resides. A valid [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country code")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public BankingInternationalPayeeBeneficiaryDetails message(String message) {
        this.message = message;
        return this;
    }

    @ApiModelProperty(value = "Response message for the payment")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public BankingInternationalPayeeBeneficiaryDetails name(String name) {
        this.name = name;
        return this;
    }

    @ApiModelProperty(value = "Name of the beneficiary")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingInternationalPayeeBeneficiaryDetails bankingInternationalPayeeBeneficiaryDetails = (BankingInternationalPayeeBeneficiaryDetails) o;
        return Objects.equals(this.country, bankingInternationalPayeeBeneficiaryDetails.country) &&
            Objects.equals(this.message, bankingInternationalPayeeBeneficiaryDetails.message) &&
            Objects.equals(this.name, bankingInternationalPayeeBeneficiaryDetails.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            country,
            message,
            name);
    }

    @Override
    public String toString() {
        return "class BankingInternationalPayeeBeneficiaryDetails {\n" +
            "   country: " + toIndentedString(country) + "\n" + 
            "   message: " + toIndentedString(message) + "\n" + 
            "   name: " + toIndentedString(name) + "\n" + 
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

