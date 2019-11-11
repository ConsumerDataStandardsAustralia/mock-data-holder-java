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
public class BankingAuthorisedEntity  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * Australian Business Number for the authorised entity
     */
    private String abn;

    /**
     * Australian Company Number for the authorised entity
     */
    private String acn;

    /**
     * Australian Registered Body Number for the authorised entity
     */
    private String arbn;

    /**
     * Description of the authorised entity derived from previously executed direct debits
     */
    private String description;

    /**
     * Name of the financial institution through which the direct debit will be executed. Is required unless the payment is made via a credit card scheme
     */
    private String financialInstitution;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingAuthorisedEntity abn(String abn) {
        this.abn = abn;
        return this;
    }

    @ApiModelProperty(value = "Australian Business Number for the authorised entity")
    public String getAbn() {
        return abn;
    }

    public void setAbn(String abn) {
        this.abn = abn;
    }
    public BankingAuthorisedEntity acn(String acn) {
        this.acn = acn;
        return this;
    }

    @ApiModelProperty(value = "Australian Company Number for the authorised entity")
    public String getAcn() {
        return acn;
    }

    public void setAcn(String acn) {
        this.acn = acn;
    }

    public BankingAuthorisedEntity arbn(String arbn) {
        this.arbn = arbn;
        return this;
    }

    @ApiModelProperty(value = "Australian Registered Body Number for the authorised entity")
    public String getArbn() {
        return arbn;
    }

    public void setArbn(String arbn) {
        this.arbn = arbn;
    }
    public BankingAuthorisedEntity description(String description) {
        this.description = description;
        return this;
    }

    @ApiModelProperty(value = "Description of the authorised entity derived from previously executed direct debits")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BankingAuthorisedEntity financialInstitution(String financialInstitution) {
        this.financialInstitution = financialInstitution;
        return this;
    }

    @ApiModelProperty(value = "Name of the financial institution through which the direct debit will be executed. Is required unless the payment is made via a credit card scheme")
    public String getFinancialInstitution() {
        return financialInstitution;
    }

    public void setFinancialInstitution(String financialInstitution) {
        this.financialInstitution = financialInstitution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingAuthorisedEntity bankingAuthorisedEntity = (BankingAuthorisedEntity) o;
        return Objects.equals(this.id, bankingAuthorisedEntity.id) &&
            Objects.equals(this.abn, bankingAuthorisedEntity.abn) &&
            Objects.equals(this.acn, bankingAuthorisedEntity.acn) &&
            Objects.equals(this.arbn, bankingAuthorisedEntity.arbn) &&
            Objects.equals(this.description, bankingAuthorisedEntity.description) &&
            Objects.equals(this.financialInstitution, bankingAuthorisedEntity.financialInstitution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            abn,
            acn,
            arbn,
            description,
            financialInstitution);
    }

    @Override
    public String toString() {
        return "class BankingAuthorisedEntity {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   abn: " + toIndentedString(abn) + "\n" +
            "   acn: " + toIndentedString(acn) + "\n" +
            "   arbn: " + toIndentedString(arbn) + "\n" + 
            "   description: " + toIndentedString(description) + "\n" + 
            "   financialInstitution: " + toIndentedString(financialInstitution) + "\n" + 
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

