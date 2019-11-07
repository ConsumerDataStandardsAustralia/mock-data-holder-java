package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class CommonPhysicalAddress  {

    public enum AddressUType {
        PAF,
        SIMPLE
    }
    /**
     * Get addressUType
     */
    private AddressUType addressUType;

    /**
     * Get paf
     */
    private CommonPAFAddress paf;

    /**
     * Get simple
     */
    private CommonSimpleAddress simple;

    public CommonPhysicalAddress addressUType(AddressUType addressUType) {
        this.addressUType = addressUType;
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    public AddressUType getAddressUType() {
        return addressUType;
    }

    public void setAddressUType(AddressUType addressUType) {
        this.addressUType = addressUType;
    }
    public CommonPhysicalAddress paf(CommonPAFAddress paf) {
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
    public CommonPhysicalAddress simple(CommonSimpleAddress simple) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommonPhysicalAddress commonPhysicalAddress = (CommonPhysicalAddress) o;
        return Objects.equals(this.addressUType, commonPhysicalAddress.addressUType) &&
            Objects.equals(this.paf, commonPhysicalAddress.paf) &&
            Objects.equals(this.simple, commonPhysicalAddress.simple);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            addressUType,
            paf,
            simple);
    }

    @Override
    public String toString() {
        return "class CommonPhysicalAddress {\n" +
            "   addressUType: " + toIndentedString(addressUType) + "\n" + 
            "   paf: " + toIndentedString(paf) + "\n" + 
            "   simple: " + toIndentedString(simple) + "\n" + 
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

