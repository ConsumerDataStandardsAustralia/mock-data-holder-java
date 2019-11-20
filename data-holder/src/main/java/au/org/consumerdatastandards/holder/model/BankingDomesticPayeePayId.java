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
public class BankingDomesticPayeePayId  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * The identifier of the PayID (dependent on type)
     */
    private String identifier;

    /**
     * The name assigned to the PayID by the owner of the PayID
     */
    private String name;

    private Type type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingDomesticPayeePayId identifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    @ApiModelProperty(required = true, value = "The identifier of the PayID (dependent on type)")
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public BankingDomesticPayeePayId name(String name) {
        this.name = name;
        return this;
    }

    @ApiModelProperty(value = "The name assigned to the PayID by the owner of the PayID")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public BankingDomesticPayeePayId type(Type type) {
        this.type = type;
        return this;
    }

    @ApiModelProperty(required = true)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingDomesticPayeePayId bankingDomesticPayeePayId = (BankingDomesticPayeePayId) o;
        return Objects.equals(this.id, bankingDomesticPayeePayId.id) &&
            Objects.equals(this.identifier, bankingDomesticPayeePayId.identifier) &&
            Objects.equals(this.name, bankingDomesticPayeePayId.name) &&
            Objects.equals(this.type, bankingDomesticPayeePayId.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            identifier,
            name,
            type);
    }

    @Override
    public String toString() {
        return "class BankingDomesticPayeePayId {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   identifier: " + toIndentedString(identifier) + "\n" +
            "   name: " + toIndentedString(name) + "\n" +
            "   type: " + toIndentedString(type) + "\n" + 
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

    public enum Type {
        ABN,
        EMAIL,
        ORG_IDENTIFIER,
        TELEPHONE
    }
}

