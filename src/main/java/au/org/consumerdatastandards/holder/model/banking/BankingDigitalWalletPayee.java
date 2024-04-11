package au.org.consumerdatastandards.holder.model.banking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class BankingDigitalWalletPayee {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String name;
    private String identifier;
    private Type type;
    private Provider provider;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * The display name of the wallet as given by the customer, else a default value defined by the data holder
     *
     * @return name
     */
    @ApiModelProperty(required = true,
            value = "The display name of the wallet as given by the customer, else a default value defined by the data holder")
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * The identifier of the digital wallet (dependent on type)
     *
     * @return identifier
     */
    @ApiModelProperty(required = true, value = "The identifier of the digital wallet (dependent on type)")
    @NotNull
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * The type of the digital wallet identifier
     *
     * @return type
     */
    @ApiModelProperty(required = true, value = "The type of the digital wallet identifier")
    @NotNull
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    /**
     * The provider of the digital wallet
     *
     * @return provider
     */
    @ApiModelProperty(required = true, value = "The provider of the digital wallet")
    @NotNull
    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingDigitalWalletPayee digitalWalletPayee = (BankingDigitalWalletPayee) o;
        return Objects.equals(this.name, digitalWalletPayee.name) &&
                Objects.equals(this.identifier, digitalWalletPayee.identifier) &&
                Objects.equals(this.type, digitalWalletPayee.type) &&
                Objects.equals(this.provider, digitalWalletPayee.provider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name,
                identifier,
                type,
                provider);
    }

    @Override
    public String toString() {
        return "class BankingDigitalWalletPayee {\n" +
                "   id: " + toIndentedString(id) + "\n" +
                "   name: " + toIndentedString(name) + "\n" +
                "   identifier: " + toIndentedString(identifier) + "\n" +
                "   type: " + toIndentedString(type) + "\n" +
                "   provider: " + toIndentedString(provider) + "\n" +
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
        EMAIL,
        CONTACT_NAME,
        TELEPHONE
    }

    public enum Provider {
        PAYPAL_AU,
        OTHER
    }
}
