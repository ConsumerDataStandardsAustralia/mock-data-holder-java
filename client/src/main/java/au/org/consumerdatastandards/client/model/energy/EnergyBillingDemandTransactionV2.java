package au.org.consumerdatastandards.client.model.energy;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyBillingDemandTransactionV2
 */
public class EnergyBillingDemandTransactionV2 {
    private String servicePointId;

    private String invoiceNumber;

    /**
     * The time of use type that the transaction applies to
     */
    public enum TimeOfUseTypeEnum {
        PEAK,
        OFF_PEAK,
        OFF_PEAK_DEMAND_CHARGE,
        SHOULDER,
        SHOULDER1,
        SHOULDER2,
        CONTROLLED_LOAD,
        SOLAR,
        AGGREGATE,
        ALL_DAY,
        EXCESS
    }

    private TimeOfUseTypeEnum timeOfUseType;

    private String description;

    private Boolean isEstimate;

    private OffsetDateTime startDate;   // "x-cds-type" : DateTimeString

    private OffsetDateTime endDate;     // "x-cds-type" : DateTimeString

    private BigDecimal rate;

    private String amount;

    private List<EnergyBillingUsageTransactionCalculationFactors> calculationFactors = null;

    private List<EnergyBillingUsageTransactionAdjustments> adjustments = null;

    public EnergyBillingDemandTransactionV2 servicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
        return this;
    }

    /**
     * The ID of the service point to which this transaction applies if any
     *
     * @return servicePointId
     */
    public String getServicePointId() {
        return servicePointId;
    }

    public void setServicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
    }

    public EnergyBillingDemandTransactionV2 invoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    /**
     * The number of the invoice in which this transaction is included if it has been issued
     *
     * @return invoiceNumber
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public EnergyBillingDemandTransactionV2 timeOfUseType(TimeOfUseTypeEnum timeOfUseType) {
        this.timeOfUseType = timeOfUseType;
        return this;
    }

    /**
     * The time of use type that the transaction applies to
     *
     * @return timeOfUseType
     */
    public TimeOfUseTypeEnum getTimeOfUseType() {
        return timeOfUseType;
    }

    public void setTimeOfUseType(TimeOfUseTypeEnum timeOfUseType) {
        this.timeOfUseType = timeOfUseType;
    }

    public EnergyBillingDemandTransactionV2 description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Optional description of the transaction that can be used for display purposes
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnergyBillingDemandTransactionV2 isEstimate(Boolean isEstimate) {
        this.isEstimate = isEstimate;
        return this;
    }

    /**
     * Flag indicating if the usage is estimated or actual.  True indicates estimate.  False or absent indicates actual
     *
     * @return isEstimate
     */
    public Boolean getIsEstimate() {
        return isEstimate;
    }

    public void setIsEstimate(Boolean isEstimate) {
        this.isEstimate = isEstimate;
    }

    public EnergyBillingDemandTransactionV2 startDate(OffsetDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Date and time when the demand period starts
     *
     * @return startDate
     */
    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public EnergyBillingDemandTransactionV2 endDate(OffsetDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Date and time when the demand period ends
     *
     * @return endDate
     */
    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public EnergyBillingDemandTransactionV2 rate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }

    /**
     * The rate for the demand charge in measureUnit. Assumed to be KVA if measureUnit not provided. A negative value indicates power generated
     *
     * @return rate
     */
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public EnergyBillingDemandTransactionV2 amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount charged or credited for this transaction prior to any adjustments being applied.  A negative value indicates a credit
     *
     * @return amount
     */
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public EnergyBillingDemandTransactionV2 calculationFactors(List<EnergyBillingUsageTransactionCalculationFactors> calculationFactors) {
        this.calculationFactors = calculationFactors;
        return this;
    }

    public EnergyBillingDemandTransactionV2 addCalculationFactorsItem(EnergyBillingUsageTransactionCalculationFactors calculationFactorsItem) {
        if (this.calculationFactors == null) {
            this.calculationFactors = new ArrayList<>();
        }
        this.calculationFactors.add(calculationFactorsItem);
        return this;
    }

    /**
     * Additional calculation factors that inform the transaction
     *
     * @return calculationFactors
     */
    public List<EnergyBillingUsageTransactionCalculationFactors> getCalculationFactors() {
        return calculationFactors;
    }

    public void setCalculationFactors(List<EnergyBillingUsageTransactionCalculationFactors> calculationFactors) {
        this.calculationFactors = calculationFactors;
    }

    public EnergyBillingDemandTransactionV2 adjustments(List<EnergyBillingUsageTransactionAdjustments> adjustments) {
        this.adjustments = adjustments;
        return this;
    }

    public EnergyBillingDemandTransactionV2 addAdjustmentsItem(EnergyBillingUsageTransactionAdjustments adjustmentsItem) {
        if (this.adjustments == null) {
            this.adjustments = new ArrayList<>();
        }
        this.adjustments.add(adjustmentsItem);
        return this;
    }

    /**
     * Optional array of adjustments arising for this transaction
     *
     * @return adjustments
     */
    public List<EnergyBillingUsageTransactionAdjustments> getAdjustments() {
        return adjustments;
    }

    public void setAdjustments(List<EnergyBillingUsageTransactionAdjustments> adjustments) {
        this.adjustments = adjustments;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyBillingDemandTransactionV2 energyBillingDemandTransaction = (EnergyBillingDemandTransactionV2) o;
        return Objects.equals(this.servicePointId, energyBillingDemandTransaction.servicePointId) &&
                Objects.equals(this.invoiceNumber, energyBillingDemandTransaction.invoiceNumber) &&
                Objects.equals(this.timeOfUseType, energyBillingDemandTransaction.timeOfUseType) &&
                Objects.equals(this.description, energyBillingDemandTransaction.description) &&
                Objects.equals(this.isEstimate, energyBillingDemandTransaction.isEstimate) &&
                Objects.equals(this.startDate, energyBillingDemandTransaction.startDate) &&
                Objects.equals(this.endDate, energyBillingDemandTransaction.endDate) &&
                Objects.equals(this.rate, energyBillingDemandTransaction.rate) &&
                Objects.equals(this.amount, energyBillingDemandTransaction.amount) &&
                Objects.equals(this.calculationFactors, energyBillingDemandTransaction.calculationFactors) &&
                Objects.equals(this.adjustments, energyBillingDemandTransaction.adjustments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicePointId, invoiceNumber, timeOfUseType, description, isEstimate, startDate, endDate, rate, amount, calculationFactors, adjustments);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ").append(getClass().getSimpleName()).append(" {");
        writeProperties(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void writeProperties(StringBuilder sb) {
        sb.append("    servicePointId: ").append(toIndentedString(servicePointId)).append("\n");
        sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
        sb.append("    timeOfUseType: ").append(toIndentedString(timeOfUseType)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    isEstimate: ").append(toIndentedString(isEstimate)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    calculationFactors: ").append(toIndentedString(calculationFactors)).append("\n");
        sb.append("    adjustments: ").append(toIndentedString(adjustments)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
