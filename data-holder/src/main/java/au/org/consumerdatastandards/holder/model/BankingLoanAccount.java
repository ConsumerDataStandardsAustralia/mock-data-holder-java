package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Objects;
import java.time.LocalDate;
import java.util.List;

@ApiModel
@Entity
public class BankingLoanAccount  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * Date that the loan is due to be repaid in full
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate loanEndDate;

    /**
     * Maximum amount of funds that can be redrawn. If not present redraw is not available even if the feature exists for the account
     */
    private String maxRedraw;

    /**
     * If absent assumes AUD
     */
    private String maxRedrawCurrency;

    /**
     * Minimum amount of next instalment
     */
    private String minInstalmentAmount;

    /**
     * If absent assumes AUD
     */
    private String minInstalmentCurrency;

    /**
     * Minimum redraw amount
     */
    private String minRedraw;

    /**
     * If absent assumes AUD
     */
    private String minRedrawCurrency;

    /**
     * Next date that an instalment is required
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate nextInstalmentDate;

    /**
     * Set to true if one or more offset accounts are configured for this loan account
     */
    private Boolean offsetAccountEnabled;

    /**
     * The accountIDs of the configured offset accounts attached to this loan. Only offset accounts that can be accessed under the current authorisation should be included. It is expected behaviour that offsetAccountEnabled is set to true but the offsetAccountIds field is absent or empty. This represents a situation where an offset account exists but details can not be accessed under the current authorisation
     */
    @ElementCollection
    private List<String> offsetAccountIds;

    /**
     * Optional original loan value
     */
    private String originalLoanAmount;

    /**
     * If absent assumes AUD
     */
    private String originalLoanCurrency;

    /**
     * Optional original start date for the loan
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate originalStartDate;

    /**
     * The expected or required repayment frequency. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)
     */
    private String repaymentFrequency;

    /**
     * Get repaymentType
     */
    private RepaymentType repaymentType;

    public BankingLoanAccount loanEndDate(LocalDate loanEndDate) {
        this.loanEndDate = loanEndDate;
        return this;
    }

    @ApiModelProperty(required = true, value = "Date that the loan is due to be repaid in full")
    public LocalDate getLoanEndDate() {
        return loanEndDate;
    }

    public void setLoanEndDate(LocalDate loanEndDate) {
        this.loanEndDate = loanEndDate;
    }
    public BankingLoanAccount maxRedraw(String maxRedraw) {
        this.maxRedraw = maxRedraw;
        return this;
    }

    @ApiModelProperty(value = "Maximum amount of funds that can be redrawn. If not present redraw is not available even if the feature exists for the account")
    public String getMaxRedraw() {
        return maxRedraw;
    }

    public void setMaxRedraw(String maxRedraw) {
        this.maxRedraw = maxRedraw;
    }
    public BankingLoanAccount maxRedrawCurrency(String maxRedrawCurrency) {
        this.maxRedrawCurrency = maxRedrawCurrency;
        return this;
    }

    @ApiModelProperty(value = "If absent assumes AUD")
    public String getMaxRedrawCurrency() {
        return maxRedrawCurrency;
    }

    public void setMaxRedrawCurrency(String maxRedrawCurrency) {
        this.maxRedrawCurrency = maxRedrawCurrency;
    }
    public BankingLoanAccount minInstalmentAmount(String minInstalmentAmount) {
        this.minInstalmentAmount = minInstalmentAmount;
        return this;
    }

    @ApiModelProperty(value = "Minimum amount of next instalment")
    public String getMinInstalmentAmount() {
        return minInstalmentAmount;
    }

    public void setMinInstalmentAmount(String minInstalmentAmount) {
        this.minInstalmentAmount = minInstalmentAmount;
    }
    public BankingLoanAccount minInstalmentCurrency(String minInstalmentCurrency) {
        this.minInstalmentCurrency = minInstalmentCurrency;
        return this;
    }

    @ApiModelProperty(value = "If absent assumes AUD")
    public String getMinInstalmentCurrency() {
        return minInstalmentCurrency;
    }

    public void setMinInstalmentCurrency(String minInstalmentCurrency) {
        this.minInstalmentCurrency = minInstalmentCurrency;
    }
    public BankingLoanAccount minRedraw(String minRedraw) {
        this.minRedraw = minRedraw;
        return this;
    }

    @ApiModelProperty(value = "Minimum redraw amount")
    public String getMinRedraw() {
        return minRedraw;
    }

    public void setMinRedraw(String minRedraw) {
        this.minRedraw = minRedraw;
    }
    public BankingLoanAccount minRedrawCurrency(String minRedrawCurrency) {
        this.minRedrawCurrency = minRedrawCurrency;
        return this;
    }

    @ApiModelProperty(value = "If absent assumes AUD")
    public String getMinRedrawCurrency() {
        return minRedrawCurrency;
    }

    public void setMinRedrawCurrency(String minRedrawCurrency) {
        this.minRedrawCurrency = minRedrawCurrency;
    }
    public BankingLoanAccount nextInstalmentDate(LocalDate nextInstalmentDate) {
        this.nextInstalmentDate = nextInstalmentDate;
        return this;
    }

    @ApiModelProperty(required = true, value = "Next date that an instalment is required")
    public LocalDate getNextInstalmentDate() {
        return nextInstalmentDate;
    }

    public void setNextInstalmentDate(LocalDate nextInstalmentDate) {
        this.nextInstalmentDate = nextInstalmentDate;
    }
    public BankingLoanAccount offsetAccountEnabled(Boolean offsetAccountEnabled) {
        this.offsetAccountEnabled = offsetAccountEnabled;
        return this;
    }

    @ApiModelProperty(value = "Set to true if one or more offset accounts are configured for this loan account")
    public Boolean getOffsetAccountEnabled() {
        return offsetAccountEnabled;
    }

    public void setOffsetAccountEnabled(Boolean offsetAccountEnabled) {
        this.offsetAccountEnabled = offsetAccountEnabled;
    }
    public BankingLoanAccount offsetAccountIds(List<String> offsetAccountIds) {
        this.offsetAccountIds = offsetAccountIds;
        return this;
    }

    public BankingLoanAccount addItem(String offsetAccountIdsItem) {
        if (this.offsetAccountIds == null) {
            this.offsetAccountIds = new ArrayList<>();
        }
        this.offsetAccountIds.add(offsetAccountIdsItem);
        return this;
    }

    @ApiModelProperty(value = "The accountIDs of the configured offset accounts attached to this loan. Only offset accounts that can be accessed under the current authorisation should be included. It is expected behaviour that offsetAccountEnabled is set to true but the offsetAccountIds field is absent or empty. This represents a situation where an offset account exists but details can not be accessed under the current authorisation")
    public List<String> getOffsetAccountIds() {
        return offsetAccountIds;
    }

    public void setOffsetAccountIds(List<String> offsetAccountIds) {
        this.offsetAccountIds = offsetAccountIds;
    }
    public BankingLoanAccount originalLoanAmount(String originalLoanAmount) {
        this.originalLoanAmount = originalLoanAmount;
        return this;
    }

    @ApiModelProperty(value = "Optional original loan value")
    public String getOriginalLoanAmount() {
        return originalLoanAmount;
    }

    public void setOriginalLoanAmount(String originalLoanAmount) {
        this.originalLoanAmount = originalLoanAmount;
    }
    public BankingLoanAccount originalLoanCurrency(String originalLoanCurrency) {
        this.originalLoanCurrency = originalLoanCurrency;
        return this;
    }

    @ApiModelProperty(value = "If absent assumes AUD")
    public String getOriginalLoanCurrency() {
        return originalLoanCurrency;
    }

    public void setOriginalLoanCurrency(String originalLoanCurrency) {
        this.originalLoanCurrency = originalLoanCurrency;
    }
    public BankingLoanAccount originalStartDate(LocalDate originalStartDate) {
        this.originalStartDate = originalStartDate;
        return this;
    }

    @ApiModelProperty(value = "Optional original start date for the loan")
    public LocalDate getOriginalStartDate() {
        return originalStartDate;
    }

    public void setOriginalStartDate(LocalDate originalStartDate) {
        this.originalStartDate = originalStartDate;
    }
    public BankingLoanAccount repaymentFrequency(String repaymentFrequency) {
        this.repaymentFrequency = repaymentFrequency;
        return this;
    }

    @ApiModelProperty(required = true, value = "The expected or required repayment frequency. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)")
    public String getRepaymentFrequency() {
        return repaymentFrequency;
    }

    public void setRepaymentFrequency(String repaymentFrequency) {
        this.repaymentFrequency = repaymentFrequency;
    }
    public BankingLoanAccount repaymentType(RepaymentType repaymentType) {
        this.repaymentType = repaymentType;
        return this;
    }

    @ApiModelProperty
    public RepaymentType getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(RepaymentType repaymentType) {
        this.repaymentType = repaymentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingLoanAccount bankingLoanAccount = (BankingLoanAccount) o;
        return Objects.equals(this.id, bankingLoanAccount.id) &&
            Objects.equals(this.loanEndDate, bankingLoanAccount.loanEndDate) &&
            Objects.equals(this.maxRedraw, bankingLoanAccount.maxRedraw) &&
            Objects.equals(this.maxRedrawCurrency, bankingLoanAccount.maxRedrawCurrency) &&
            Objects.equals(this.minInstalmentAmount, bankingLoanAccount.minInstalmentAmount) &&
            Objects.equals(this.minInstalmentCurrency, bankingLoanAccount.minInstalmentCurrency) &&
            Objects.equals(this.minRedraw, bankingLoanAccount.minRedraw) &&
            Objects.equals(this.minRedrawCurrency, bankingLoanAccount.minRedrawCurrency) &&
            Objects.equals(this.nextInstalmentDate, bankingLoanAccount.nextInstalmentDate) &&
            Objects.equals(this.offsetAccountEnabled, bankingLoanAccount.offsetAccountEnabled) &&
            Objects.equals(this.offsetAccountIds, bankingLoanAccount.offsetAccountIds) &&
            Objects.equals(this.originalLoanAmount, bankingLoanAccount.originalLoanAmount) &&
            Objects.equals(this.originalLoanCurrency, bankingLoanAccount.originalLoanCurrency) &&
            Objects.equals(this.originalStartDate, bankingLoanAccount.originalStartDate) &&
            Objects.equals(this.repaymentFrequency, bankingLoanAccount.repaymentFrequency) &&
            Objects.equals(this.repaymentType, bankingLoanAccount.repaymentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            loanEndDate,
            maxRedraw,
            maxRedrawCurrency,
            minInstalmentAmount,
            minInstalmentCurrency,
            minRedraw,
            minRedrawCurrency,
            nextInstalmentDate,
            offsetAccountEnabled,
            offsetAccountIds,
            originalLoanAmount,
            originalLoanCurrency,
            originalStartDate,
            repaymentFrequency,
            repaymentType);
    }

    @Override
    public String toString() {
        return "class BankingLoanAccount {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   loanEndDate: " + toIndentedString(loanEndDate) + "\n" +
            "   maxRedraw: " + toIndentedString(maxRedraw) + "\n" +
            "   maxRedrawCurrency: " + toIndentedString(maxRedrawCurrency) + "\n" + 
            "   minInstalmentAmount: " + toIndentedString(minInstalmentAmount) + "\n" + 
            "   minInstalmentCurrency: " + toIndentedString(minInstalmentCurrency) + "\n" + 
            "   minRedraw: " + toIndentedString(minRedraw) + "\n" + 
            "   minRedrawCurrency: " + toIndentedString(minRedrawCurrency) + "\n" + 
            "   nextInstalmentDate: " + toIndentedString(nextInstalmentDate) + "\n" + 
            "   offsetAccountEnabled: " + toIndentedString(offsetAccountEnabled) + "\n" + 
            "   offsetAccountIds: " + toIndentedString(offsetAccountIds) + "\n" + 
            "   originalLoanAmount: " + toIndentedString(originalLoanAmount) + "\n" + 
            "   originalLoanCurrency: " + toIndentedString(originalLoanCurrency) + "\n" + 
            "   originalStartDate: " + toIndentedString(originalStartDate) + "\n" + 
            "   repaymentFrequency: " + toIndentedString(repaymentFrequency) + "\n" + 
            "   repaymentType: " + toIndentedString(repaymentType) + "\n" + 
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

    public enum RepaymentType {
        INTEREST_ONLY,
        PRINCIPAL_AND_INTEREST
    }
}

