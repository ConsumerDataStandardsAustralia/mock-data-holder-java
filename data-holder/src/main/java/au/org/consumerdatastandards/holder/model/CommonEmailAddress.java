package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class CommonEmailAddress  {

    /**
     * A correctly formatted email address, as defined by the addr_spec format in [RFC 5322](https://www.ietf.org/rfc/rfc5322.txt)
     */
    private String address;

    /**
     * May be true for one and only one email record in the collection. Denotes the default email address
     */
    private Boolean isPreferred;

    public enum Purpose {
        HOME,
        OTHER,
        UNSPECIFIED,
        WORK
    }
    /**
     * Get purpose
     */
    private Purpose purpose;

    public CommonEmailAddress address(String address) {
        this.address = address;
        return this;
    }

    @ApiModelProperty(required = true, value = "A correctly formatted email address, as defined by the addr_spec format in [RFC 5322](https://www.ietf.org/rfc/rfc5322.txt)")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public CommonEmailAddress isPreferred(Boolean isPreferred) {
        this.isPreferred = isPreferred;
        return this;
    }

    @ApiModelProperty(value = "May be true for one and only one email record in the collection. Denotes the default email address")
    public Boolean getIsPreferred() {
        return isPreferred;
    }

    public void setIsPreferred(Boolean isPreferred) {
        this.isPreferred = isPreferred;
    }
    public CommonEmailAddress purpose(Purpose purpose) {
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
        CommonEmailAddress commonEmailAddress = (CommonEmailAddress) o;
        return Objects.equals(this.address, commonEmailAddress.address) &&
            Objects.equals(this.isPreferred, commonEmailAddress.isPreferred) &&
            Objects.equals(this.purpose, commonEmailAddress.purpose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            address,
            isPreferred,
            purpose);
    }

    @Override
    public String toString() {
        return "class CommonEmailAddress {\n" +
            "   address: " + toIndentedString(address) + "\n" + 
            "   isPreferred: " + toIndentedString(isPreferred) + "\n" + 
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

