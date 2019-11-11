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
public class BankingInternationalPayeeBankDetailsBankAddress  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * Address of the recipient Bank
     */
    private String address;

    /**
     * Name of the recipient Bank
     */
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingInternationalPayeeBankDetailsBankAddress address(String address) {
        this.address = address;
        return this;
    }

    @ApiModelProperty(required = true, value = "Address of the recipient Bank")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BankingInternationalPayeeBankDetailsBankAddress name(String name) {
        this.name = name;
        return this;
    }

    @ApiModelProperty(required = true, value = "Name of the recipient Bank")
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
        BankingInternationalPayeeBankDetailsBankAddress bankingInternationalPayeeBankDetailsBankAddress = (BankingInternationalPayeeBankDetailsBankAddress) o;
        return Objects.equals(this.id, bankingInternationalPayeeBankDetailsBankAddress.id) &&
            Objects.equals(this.address, bankingInternationalPayeeBankDetailsBankAddress.address) &&
            Objects.equals(this.name, bankingInternationalPayeeBankDetailsBankAddress.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            address,
            name);
    }

    @Override
    public String toString() {
        return "class BankingInternationalPayeeBankDetailsBankAddress {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   address: " + toIndentedString(address) + "\n" +
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

