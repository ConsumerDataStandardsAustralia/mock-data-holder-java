package au.org.consumerdatastandards.client.model.banking;

import java.util.Objects;

public class BankingDigitalWalletPayee {
    private String name;
    private String identifier;
    private Type type;
    private Provider provider;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

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
                Objects.equals(this.provider, digitalWalletPayee.provider) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name,
                identifier,
                type,
                provider,
                super.hashCode());
    }

    @Override
    public String toString() {
        return "class BankingDigitalWalletPayee {\n" +
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

    enum Type {
        EMAIL,
        CONTACT_NAME,
        TELEPHONE
    }

    enum Provider {
        PAYPAL_AU,
        OTHER
    }
}
