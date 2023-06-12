package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyBillingUsageTransaction
 */
public class EnergyBillingUsageTransaction {
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

    private RateMeasureUnitEnum measureUnit;

    private BigDecimal usage;

    private String amount;

    @Valid
    private List<EnergyBillingUsageTransactionCalculationFactors> calculationFactors = null;

    @Valid
    private List<EnergyBillingUsageTransactionAdjustments> adjustments = null;

    public EnergyBillingUsageTransaction servicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
        return this;
    }

    /**
     * The ID of the service point to which this transaction applies if any
     *
     * @return servicePointId
     */
    @ApiModelProperty(value = "The ID of the service point to which this transaction applies if any")
    public String getServicePointId() {
        return servicePointId;
    }

    public void setServicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
    }

    public EnergyBillingUsageTransaction invoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    /**
     * The number of the invoice in which this transaction is included if it has been issued
     *
     * @return invoiceNumber
     */
    @ApiModelProperty(value = "The number of the invoice in which this transaction is included if it has been issued")
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public EnergyBillingUsageTransaction timeOfUseType(TimeOfUseTypeEnum timeOfUseType) {
        this.timeOfUseType = timeOfUseType;
        return this;
    }

    /**
     * The time of use type that the transaction applies to
     *
     * @return timeOfUseType
     */
    @ApiModelProperty(required = true, value = "The time of use type that the transaction applies to")
    @NotNull
    public TimeOfUseTypeEnum getTimeOfUseType() {
        return timeOfUseType;
    }

    public void setTimeOfUseType(TimeOfUseTypeEnum timeOfUseType) {
        this.timeOfUseType = timeOfUseType;
    }

    public EnergyBillingUsageTransaction description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Optional description of the transaction that can be used for display purposes
     *
     * @return description
     */
    @ApiModelProperty(value = "Optional description of the transaction that can be used for display purposes")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnergyBillingUsageTransaction isEstimate(Boolean isEstimate) {
        this.isEstimate = isEstimate;
        return this;
    }

    /**
     * Flag indicating if the usage is estimated or actual.  True indicates estimate.  False or absent indicates actual
     *
     * @return isEstimate
     */
    @ApiModelProperty(value = "Flag indicating if the usage is estimated or actual.  True indicates estimate.  False or absent indicates actual")
    public Boolean getIsEstimate() {
        return isEstimate;
    }

    public void setIsEstimate(Boolean isEstimate) {
        this.isEstimate = isEstimate;
    }

    public EnergyBillingUsageTransaction startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Date and time when the usage period starts
     *
     * @return startDate
     */
    @ApiModelProperty(required = true, value = "Date and time when the usage period starts")
    @NotNull
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public EnergyBillingUsageTransaction endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Date and time when the usage period ends
     *
     * @return endDate
     */
    @ApiModelProperty(required = true, value = "Date and time when the usage period ends")
    @NotNull
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public EnergyBillingUsageTransaction measureUnit(RateMeasureUnitEnum measureUnit) {
        this.measureUnit = measureUnit;
        return this;
    }

    /**
     * The measurement unit of rate. Assumed to be KWH if absent
     *
     * @return measureUnit
     */
    @ApiModelProperty(value = "The measurement unit of rate. Assumed to be KWH if absent")
    public RateMeasureUnitEnum getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(RateMeasureUnitEnum measureUnit) {
        this.measureUnit = measureUnit;
    }

    public EnergyBillingUsageTransaction usage(BigDecimal usage) {
        this.usage = usage;
        return this;
    }

    /**
     * The usage for the period in measure unit.  A negative value indicates power generated
     *
     * @return usage
     */
    @ApiModelProperty(required = true,
            value = "The usage for the period in measure unit.  A negative value indicates power generated")
    @NotNull
    @Valid
    public BigDecimal getUsage() {
        return usage;
    }

    public void setUsage(BigDecimal usage) {
        this.usage = usage;
    }

    public EnergyBillingUsageTransaction amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount charged or credited for this transaction prior to any adjustments being applied.  A negative value indicates a credit
     *
     * @return amount
     */
    @ApiModelProperty(required = true,
            value = "The amount charged or credited for this transaction prior to any adjustments being applied.  A negative value indicates a credit")
    @NotNull
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public EnergyBillingUsageTransaction calculationFactors(List<EnergyBillingUsageTransactionCalculationFactors> calculationFactors) {
        this.calculationFactors = calculationFactors;
        return this;
    }

    public EnergyBillingUsageTransaction addCalculationFactorsItem(EnergyBillingUsageTransactionCalculationFactors calculationFactorsItem) {
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
    @ApiModelProperty(value = "Additional calculation factors that inform the transaction")
    @Valid
    public List<EnergyBillingUsageTransactionCalculationFactors> getCalculationFactors() {
        return calculationFactors;
    }

    public void setCalculationFactors(List<EnergyBillingUsageTransactionCalculationFactors> calculationFactors) {
        this.calculationFactors = calculationFactors;
    }

    public EnergyBillingUsageTransaction adjustments(List<EnergyBillingUsageTransactionAdjustments> adjustments) {
        this.adjustments = adjustments;
        return this;
    }

    public EnergyBillingUsageTransaction addAdjustmentsItem(EnergyBillingUsageTransactionAdjustments adjustmentsItem) {
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
    @ApiModelProperty(value = "Optional array of adjustments arising for this transaction")
    @Valid
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
        EnergyBillingUsageTransaction energyBillingUsageTransaction = (EnergyBillingUsageTransaction) o;
        return Objects.equals(this.servicePointId, energyBillingUsageTransaction.servicePointId) &&
                Objects.equals(this.invoiceNumber, energyBillingUsageTransaction.invoiceNumber) &&
                Objects.equals(this.timeOfUseType, energyBillingUsageTransaction.timeOfUseType) &&
                Objects.equals(this.description, energyBillingUsageTransaction.description) &&
                Objects.equals(this.isEstimate, energyBillingUsageTransaction.isEstimate) &&
                Objects.equals(this.startDate, energyBillingUsageTransaction.startDate) &&
                Objects.equals(this.endDate, energyBillingUsageTransaction.endDate) &&
                Objects.equals(this.measureUnit, energyBillingUsageTransaction.measureUnit) &&
                Objects.equals(this.usage, energyBillingUsageTransaction.usage) &&
                Objects.equals(this.amount, energyBillingUsageTransaction.amount) &&
                Objects.equals(this.calculationFactors, energyBillingUsageTransaction.calculationFactors) &&
                Objects.equals(this.adjustments, energyBillingUsageTransaction.adjustments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicePointId, invoiceNumber, timeOfUseType, description, isEstimate, startDate, endDate, measureUnit, usage, amount, calculationFactors, adjustments);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyBillingUsageTransaction {\n");
        sb.append("    servicePointId: ").append(toIndentedString(servicePointId)).append("\n");
        sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
        sb.append("    timeOfUseType: ").append(toIndentedString(timeOfUseType)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    isEstimate: ").append(toIndentedString(isEstimate)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    measureUnit: ").append(toIndentedString(measureUnit)).append("\n");
        sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
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
