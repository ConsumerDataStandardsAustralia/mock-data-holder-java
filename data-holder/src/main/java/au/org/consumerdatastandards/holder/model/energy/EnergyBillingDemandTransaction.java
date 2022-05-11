package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyBillingDemandTransaction
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyBillingDemandTransaction {
    @JsonProperty("servicePointId")
    private String servicePointId;

    @JsonProperty("invoiceNumber")
    private String invoiceNumber;

    /**
     * The time of use type that the transaction applies to
     */
    public enum TimeOfUseTypeEnum {
        PEAK("PEAK"),

        OFF_PEAK("OFF_PEAK"),

        OFF_PEAK_DEMAND_CHARGE("OFF_PEAK_DEMAND_CHARGE"),

        SHOULDER("SHOULDER"),

        SHOULDER1("SHOULDER1"),

        SHOULDER2("SHOULDER2"),

        CONTROLLED_LOAD("CONTROLLED_LOAD"),

        SOLAR("SOLAR"),

        AGGREGATE("AGGREGATE");

        private String value;

        TimeOfUseTypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TimeOfUseTypeEnum fromValue(String value) {
            for (TimeOfUseTypeEnum b : TimeOfUseTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("timeOfUseType")
    private TimeOfUseTypeEnum timeOfUseType;

    @JsonProperty("description")
    private String description;

    @JsonProperty("isEstimate")
    private Boolean isEstimate;

    @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("endDate")
    private String endDate;

    @JsonProperty("rate")
    private BigDecimal rate;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("calculationFactors")
    @Valid
    private List<EnergyBillingUsageTransactionCalculationFactors> calculationFactors = null;

    @JsonProperty("adjustments")
    @Valid
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
    @ApiModelProperty(value = "The ID of the service point to which this transaction applies if any")


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
    @ApiModelProperty(value = "The number of the invoice in which this transaction is included if it has been issued")


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
    @ApiModelProperty(required = true,
            value = "The time of use type that the transaction applies to")
    @NotNull


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
    @ApiModelProperty(value = "Optional description of the transaction that can be used for display purposes")


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
    @ApiModelProperty(value = "Flag indicating if the usage is estimated or actual.  True indicates estimate.  False or absent indicates actual")


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
    @ApiModelProperty(required = true,
            value = "Date and time when the demand period starts")
    @NotNull


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
    @ApiModelProperty(required = true,
            value = "Date and time when the demand period ends")
    @NotNull


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
    @ApiModelProperty(required = true,
            value = "The rate for the demand charge in kVA.  A negative value indicates power generated")
    @NotNull

    @Valid

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
    @ApiModelProperty(required = true,
            value = "The amount charged or credited for this transaction prior to any adjustments being applied.  A negative value indicates a credit")
    @NotNull


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
    @ApiModelProperty(value = "Additional calculation factors that inform the transaction")

    @Valid

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

