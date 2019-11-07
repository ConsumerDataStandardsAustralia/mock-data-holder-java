package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class CommonPhysicalAddressWithPurpose extends CommonPhysicalAddress {

    public enum CommonPhysicalAddress.AddressUType {
        PAF,
        SIMPLE
    }
    /**
     * Get addressUType
     */
    private CommonPhysicalAddress.AddressUType addressUType;

    /**
     * Get paf
     */
    private CommonPAFAddress paf;

    /**
     * Get simple
     */
    private CommonSimpleAddress simple;

    public enum Purpose {
        MAIL,
        OTHER,
        PHYSICAL,
        REGISTERED,
        WORK
    }
    /**
     * Get purpose
     */
    private Purpose purpose;

    public CommonPhysicalAddressWithPurpose addressUType(CommonPhysicalAddress.AddressUType addressUType) {
        this.addressUType = addressUType;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public CommonPhysicalAddress.AddressUType getAddressUType() {
        return addressUType;
    }

    public void setAddressUType(CommonPhysicalAddress.AddressUType addressUType) {
        this.addressUType = addressUType;
    }
    public CommonPhysicalAddressWithPurpose paf(CommonPAFAddress paf) {
        this.paf = paf;
        return this;
    }

    @ApiModelProperty(value = "")
    public CommonPAFAddress getPaf() {
        return paf;
    }

    public void setPaf(CommonPAFAddress paf) {
        this.paf = paf;
    }
    public CommonPhysicalAddressWithPurpose simple(CommonSimpleAddress simple) {
        this.simple = simple;
        return this;
    }

    @ApiModelProperty(value = "")
    public CommonSimpleAddress getSimple() {
        return simple;
    }

    public void setSimple(CommonSimpleAddress simple) {
        this.simple = simple;
    }
    public CommonPhysicalAddressWithPurpose purpose(Purpose purpose) {
        this.purpose = purpose;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
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
        CommonPhysicalAddressWithPurpose commonPhysicalAddressWithPurpose = (CommonPhysicalAddressWithPurpose) o;
        return Objects.equals(this.purpose, commonPhysicalAddressWithPurpose.purpose) &&
            super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            purpose,
            super.hashCode());
    }

    @Override
    public String toString() {
        return "class CommonPhysicalAddressWithPurpose {\n" +
            "   addressUType: " + toIndentedString(getAddressUType()) + "\n" + 
            "   paf: " + toIndentedString(getPaf()) + "\n" + 
            "   simple: " + toIndentedString(getSimple()) + "\n" + 
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
}

