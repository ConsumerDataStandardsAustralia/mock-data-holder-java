package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@ApiModel
@Entity
public class CommonPhysicalAddressWithPurpose {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private CommonPhysicalAddress.AddressUType addressUType;

    @ManyToOne
    private CommonPAFAddress paf;

    @Embedded
    private CommonSimpleAddress simple;

    private Purpose purpose;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CommonPhysicalAddressWithPurpose addressUType(CommonPhysicalAddress.AddressUType addressUType) {
        this.addressUType = addressUType;
        return this;
    }

    @ApiModelProperty(required = true)
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

    @ApiModelProperty
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

    @ApiModelProperty
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

    public enum Purpose {
        MAIL,
        PHYSICAL,
        REGISTERED,
        WORK,
        OTHER
    }
}

