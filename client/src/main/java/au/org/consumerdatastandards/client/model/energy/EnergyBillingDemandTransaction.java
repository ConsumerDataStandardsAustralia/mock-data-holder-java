package au.org.consumerdatastandards.client.model.energy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyBillingDemandTransaction
 */
public class EnergyBillingDemandTransaction {
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
        AGGREGATE
    }

    private TimeOfUseTypeEnum timeOfUseType;

    private String description;

    private Boolean isEstimate;

    private String startDate;

    private String endDate;

    private BigDecimal rate;

    private String amount;

    private List<EnergyBillingUsageTransactionCalculationFactors> calculationFactors = null;

    private List<EnergyBillingUsageTransactionAdjustments> adjustments = null;

    public EnergyBillingDemandTransaction servicePointId(String servicePointId) {
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

    public EnergyBillingDemandTransaction invoiceNumber(String invoiceNumber) {
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

    public EnergyBillingDemandTransaction timeOfUseType(TimeOfUseTypeEnum timeOfUseType) {
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

    public EnergyBillingDemandTransaction description(String description) {
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

    public EnergyBillingDemandTransaction isEstimate(Boolean isEstimate) {
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

    public EnergyBillingDemandTransaction startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Date and time when the demand period starts
     *
     * @return startDate
     */
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public EnergyBillingDemandTransaction endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Date and time when the demand period ends
     *
     * @return endDate
     */
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public EnergyBillingDemandTransaction rate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }

    /**
     * The rate for the demand charge in kVA.  A negative value indicates power generated
     *
     * @return rate
     */
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public EnergyBillingDemandTransaction amount(String amount) {
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

    public EnergyBillingDemandTransaction calculationFactors(List<EnergyBillingUsageTransactionCalculationFactors> calculationFactors) {
        this.calculationFactors = calculationFactors;
        return this;
    }

    public EnergyBillingDemandTransaction addCalculationFactorsItem(EnergyBillingUsageTransactionCalculationFactors calculationFactorsItem) {
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

    public EnergyBillingDemandTransaction adjustments(List<EnergyBillingUsageTransactionAdjustments> adjustments) {
        this.adjustments = adjustments;
        return this;
    }

    public EnergyBillingDemandTransaction addAdjustmentsItem(EnergyBillingUsageTransactionAdjustments adjustmentsItem) {
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
        EnergyBillingDemandTransaction energyBillingDemandTransaction = (EnergyBillingDemandTransaction) o;
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
        sb.append("class EnergyBillingDemandTransaction {\n");
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
        sb.append("}");
        return sb.toString();
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
