package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class BankingAccountProductFeature {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    @JsonIgnore
    @ManyToOne
    private BankingAccountDetail bankingAccountDetail;

    @ManyToOne
    private BankingProductFeature bankingProductFeature;

    private Boolean isActivated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingAccountDetail getBankingAccountDetail() {
        return bankingAccountDetail;
    }

    public void setBankingAccountDetail(BankingAccountDetail bankingAccountDetail) {
        this.bankingAccountDetail = bankingAccountDetail;
    }

    public BankingProductFeature getBankingProductFeature() {
        return bankingProductFeature;
    }

    public void setBankingProductFeature(BankingProductFeature bankingProductFeature) {
        this.bankingProductFeature = bankingProductFeature;
    }

    public Boolean getActivated() {
        return isActivated;
    }

    public void setActivated(Boolean activated) {
        isActivated = activated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankingAccountProductFeature)) return false;
        BankingAccountProductFeature that = (BankingAccountProductFeature) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(bankingAccountDetail, that.bankingAccountDetail) &&
            Objects.equals(bankingProductFeature, that.bankingProductFeature) &&
            Objects.equals(isActivated, that.isActivated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            bankingAccountDetail,
            bankingProductFeature,
            isActivated);
    }

    @Override
    public String toString() {
        return "class BankingAccountProductFeature {" +
            "   id: " + toIndentedString(id) + '\'' +
            "   bankingAccountDetail: " + toIndentedString(bankingAccountDetail) +
            "   bankingProductFeature: " + toIndentedString(bankingProductFeature) +
            "   isActivated: " + toIndentedString(isActivated) +
            '}';
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
