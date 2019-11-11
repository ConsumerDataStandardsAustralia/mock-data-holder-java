package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import java.time.OffsetDateTime;

@ApiModel
public class BankingDirectDebit  {

    /**
     * A unique ID of the account adhering to the standards for ID permanence.
     */
    private String accountId;

    /**
     * Get authorisedEntity
     */
    private BankingAuthorisedEntity authorisedEntity;

    /**
     * The amount of the last debit executed under this authorisation
     */
    private String lastDebitAmount;

    /**
     * The date and time of the last debit executed under this authorisation
     */
    private OffsetDateTime lastDebitDateTime;

    public BankingDirectDebit accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    @ApiModelProperty(required = true, value = "A unique ID of the account adhering to the standards for ID permanence.")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public BankingDirectDebit authorisedEntity(BankingAuthorisedEntity authorisedEntity) {
        this.authorisedEntity = authorisedEntity;
        return this;
    }

    @ApiModelProperty(required = true)
    public BankingAuthorisedEntity getAuthorisedEntity() {
        return authorisedEntity;
    }

    public void setAuthorisedEntity(BankingAuthorisedEntity authorisedEntity) {
        this.authorisedEntity = authorisedEntity;
    }
    public BankingDirectDebit lastDebitAmount(String lastDebitAmount) {
        this.lastDebitAmount = lastDebitAmount;
        return this;
    }

    @ApiModelProperty(value = "The amount of the last debit executed under this authorisation")
    public String getLastDebitAmount() {
        return lastDebitAmount;
    }

    public void setLastDebitAmount(String lastDebitAmount) {
        this.lastDebitAmount = lastDebitAmount;
    }
    public BankingDirectDebit lastDebitDateTime(OffsetDateTime lastDebitDateTime) {
        this.lastDebitDateTime = lastDebitDateTime;
        return this;
    }

    @ApiModelProperty(value = "The date and time of the last debit executed under this authorisation")
    public OffsetDateTime getLastDebitDateTime() {
        return lastDebitDateTime;
    }

    public void setLastDebitDateTime(OffsetDateTime lastDebitDateTime) {
        this.lastDebitDateTime = lastDebitDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingDirectDebit bankingDirectDebit = (BankingDirectDebit) o;
        return Objects.equals(this.accountId, bankingDirectDebit.accountId) &&
            Objects.equals(this.authorisedEntity, bankingDirectDebit.authorisedEntity) &&
            Objects.equals(this.lastDebitAmount, bankingDirectDebit.lastDebitAmount) &&
            Objects.equals(this.lastDebitDateTime, bankingDirectDebit.lastDebitDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            accountId,
            authorisedEntity,
            lastDebitAmount,
            lastDebitDateTime);
    }

    @Override
    public String toString() {
        return "class BankingDirectDebit {\n" +
            "   accountId: " + toIndentedString(accountId) + "\n" + 
            "   authorisedEntity: " + toIndentedString(authorisedEntity) + "\n" + 
            "   lastDebitAmount: " + toIndentedString(lastDebitAmount) + "\n" + 
            "   lastDebitDateTime: " + toIndentedString(lastDebitDateTime) + "\n" + 
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

