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
public class CommonEmailAddress  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * A correctly formatted email address, as defined by the addr_spec format in [RFC 5322](https://www.ietf.org/rfc/rfc5322.txt)
     */
    private String address;

    /**
     * May be true for one and only one email record in the collection. Denotes the default email address
     */
    private Boolean isPreferred;

    private Purpose purpose;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        CommonEmailAddress commonEmailAddress = (CommonEmailAddress) o;
        return Objects.equals(this.id, commonEmailAddress.id) &&
            Objects.equals(this.address, commonEmailAddress.address) &&
            Objects.equals(this.isPreferred, commonEmailAddress.isPreferred) &&
            Objects.equals(this.purpose, commonEmailAddress.purpose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            address,
            isPreferred,
            purpose);
    }

    @Override
    public String toString() {
        return "class CommonEmailAddress {\n" +
            "   id: " + toIndentedString(id) + "\n" +
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

    public enum Purpose {
        HOME,
        OTHER,
        UNSPECIFIED,
        WORK
    }
}

