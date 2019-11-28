package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class ResponseCommonCustomerDetailData  {

    public enum CustomerUType {
        organisation,
        person
    }
    /**
     * Get customerUType
     */
    private CustomerUType customerUType;

    /**
     * Get organisation
     */
    private CommonOrganisationDetail organisation;

    /**
     * Get person
     */
    private CommonPersonDetail person;

    public ResponseCommonCustomerDetailData customerUType(CustomerUType customerUType) {
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
    public ResponseCommonCustomerDetailData organisation(CommonOrganisationDetail organisation) {
        this.organisation = organisation;
        return this;
    }

    @ApiModelProperty
    public CommonOrganisationDetail getOrganisation() {
        return organisation;
    }

    public void setOrganisation(CommonOrganisationDetail organisation) {
        this.organisation = organisation;
    }
    public ResponseCommonCustomerDetailData person(CommonPersonDetail person) {
        this.person = person;
        return this;
    }

    @ApiModelProperty
    public CommonPersonDetail getPerson() {
        return person;
    }

    public void setPerson(CommonPersonDetail person) {
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
        ResponseCommonCustomerDetailData responseCommonCustomerDetailData = (ResponseCommonCustomerDetailData) o;
        return Objects.equals(this.customerUType, responseCommonCustomerDetailData.customerUType) &&
            Objects.equals(this.organisation, responseCommonCustomerDetailData.organisation) &&
            Objects.equals(this.person, responseCommonCustomerDetailData.person);
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
        return "class ResponseCommonCustomerDetailData {\n" +
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

