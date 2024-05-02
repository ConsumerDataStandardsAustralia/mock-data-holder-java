package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class ResponseCommonCustomerData  {

    public enum CustomerUType {
        organisation,
        person
    }

    private CustomerUType customerUType;

    private CommonOrganisation organisation;

    private CommonPerson person;

    public ResponseCommonCustomerData customerUType(CustomerUType customerUType) {
        this.customerUType = customerUType;
        return this;
    }

    @ApiModelProperty(required = true)
    public CustomerUType getCustomerUType() {
        return customerUType;
    }

    public void setCustomerUType(CustomerUType customerUType) {
        this.customerUType = customerUType;
    }
    public ResponseCommonCustomerData organisation(CommonOrganisation organisation) {
        this.organisation = organisation;
        return this;
    }

    @ApiModelProperty
    public CommonOrganisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(CommonOrganisation organisation) {
        this.organisation = organisation;
    }
    public ResponseCommonCustomerData person(CommonPerson person) {
        this.person = person;
        return this;
    }

    @ApiModelProperty
    public CommonPerson getPerson() {
        return person;
    }

    public void setPerson(CommonPerson person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseCommonCustomerData responseCommonCustomerData = (ResponseCommonCustomerData) o;
        return Objects.equals(this.customerUType, responseCommonCustomerData.customerUType) &&
            Objects.equals(this.organisation, responseCommonCustomerData.organisation) &&
            Objects.equals(this.person, responseCommonCustomerData.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            customerUType,
            organisation,
            person);
    }

    @Override
    public String toString() {
        return "class ResponseCommonCustomerData {\n" +
            "   customerUType: " + toIndentedString(customerUType) + "\n" + 
            "   organisation: " + toIndentedString(organisation) + "\n" + 
            "   person: " + toIndentedString(person) + "\n" + 
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

