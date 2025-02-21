package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyBillingDemandTransactionV3
 */
@Entity
@Table(name = "e_billing_demand_trans")
public class EnergyBillingDemandTransactionV3 implements EnergyBillingDemandTransaction {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String servicePointId;

    private String invoiceNumber;

    private TimeOfUseTypeEnum timeOfUseType;

    private String description;

    private Boolean isEstimate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime startDate;   // "x-cds-type" : DateTimeString

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime endDate;     // "x-cds-type" : DateTimeString

    private RateMeasureUnitEnum measureUnit;

    private BigDecimal rate;

    private String amount;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_billing_demand_trans_calc_factors",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "calc_id"))
    @Valid
    private List<EnergyBillingUsageTransactionCalculationFactors> calculationFactors = null;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_billing_demand_trans_adjustments",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "calc_id"))
    @Valid
    private List<EnergyBillingUsageTransactionAdjustments> adjustments = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyBillingDemandTransactionV3 servicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
        return this;
    }

    /**
     * The ID of the service point to which this transaction applies if any.
     *
     * @return servicePointId
     */
    @Override
    @ApiModelProperty(value = "The ID of the service point to which this transaction applies if any.")
    public String getServicePointId() {
        return servicePointId;
    }

    public void setServicePointId(String servicePointId) {
        this.servicePointId = servicePointId;
    }

    public EnergyBillingDemandTransactionV3 invoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    /**
     * The number of the invoice in which this transaction is included if it has been issued.
     *
     * @return invoiceNumber
     */
    @Override
    @ApiModelProperty(value = "The number of the invoice in which this transaction is included if it has been issued.")
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public EnergyBillingDemandTransactionV3 timeOfUseType(TimeOfUseTypeEnum timeOfUseType) {
        this.timeOfUseType = timeOfUseType;
        return this;
    }

    /**
     * The time of use type that the transaction applies to.
     *
     * @return timeOfUseType
     */
    @Override
    @ApiModelProperty(required = true, value = "The time of use type that the transaction applies to.")
    @NotNull
    public TimeOfUseTypeEnum getTimeOfUseType() {
        return timeOfUseType;
    }

    public void setTimeOfUseType(TimeOfUseTypeEnum timeOfUseType) {
        this.timeOfUseType = timeOfUseType;
    }

    public EnergyBillingDemandTransactionV3 description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Optional description of the transaction that can be used for display purposes.
     *
     * @return description
     */
    @Override
    @ApiModelProperty(value = "Optional description of the transaction that can be used for display purposes.")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnergyBillingDemandTransactionV3 isEstimate(Boolean isEstimate) {
        this.isEstimate = isEstimate;
        return this;
    }

    /**
     * Flag indicating if the usage is estimated or actual. `true` indicates estimate. `false` or absent indicates actual.
     *
     * @return isEstimate
     */
    @Override
    @ApiModelProperty(value = "Flag indicating if the usage is estimated or actual. `true` indicates estimate. `false` or absent indicates actual.")
    public Boolean getIsEstimate() {
        return isEstimate;
    }

    public void setIsEstimate(Boolean isEstimate) {
        this.isEstimate = isEstimate;
    }

    public EnergyBillingDemandTransactionV3 startDate(OffsetDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Date and time when the demand period starts.
     *
     * @return startDate
     */
    @Override
    @ApiModelProperty(required = true, value = "Date and time when the demand period starts.")
    @NotNull
    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public EnergyBillingDemandTransactionV3 endDate(OffsetDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Date and time when the demand period ends.
     *
     * @return endDate
     */
    @Override
    @ApiModelProperty(required = true, value = "Date and time when the demand period ends.")
    @NotNull
    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public EnergyBillingDemandTransactionV3 rate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }

    /**
     * The measurement unit of rate. Assumed to be `KVA` if absent.
     *
     * @return measureUnit
     */
    @ApiModelProperty(value = "The measurement unit of rate. Assumed to be `KVA` if absent.")
    public RateMeasureUnitEnum getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(RateMeasureUnitEnum measureUnit) {
        this.measureUnit = measureUnit;
    }

    /**
     * The rate for the demand charge in _measureUnit_. Assumed to be `KVA` if _measureUnit_ not provided. A negative value indicates power generated.
     *
     * @return rate
     */
    @Override
    @ApiModelProperty(required = true,
            value = "The rate for the demand charge in _measureUnit_. Assumed to be `KVA` if _measureUnit_ not provided. A negative value indicates power generated.")
    @NotNull
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public EnergyBillingDemandTransactionV3 amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount charged or credited for this transaction prior to any adjustments being applied. A negative value indicates a credit.
     *
     * @return amount
     */
    @Override
    @ApiModelProperty(required = true,
            value = "The amount charged or credited for this transaction prior to any adjustments being applied. A negative value indicates a credit.")
    @NotNull
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public EnergyBillingDemandTransactionV3 calculationFactors(List<EnergyBillingUsageTransactionCalculationFactors> calculationFactors) {
        this.calculationFactors = calculationFactors;
        return this;
    }

    public EnergyBillingDemandTransactionV3 addCalculationFactorsItem(EnergyBillingUsageTransactionCalculationFactors calculationFactorsItem) {
        if (this.calculationFactors == null) {
            this.calculationFactors = new ArrayList<>();
        }
        this.calculationFactors.add(calculationFactorsItem);
        return this;
    }

    /**
     * Additional calculation factors that inform the transaction.
     *
     * @return calculationFactors
     */
    @Override
    @ApiModelProperty(value = "Additional calculation factors that inform the transaction.")
    public List<EnergyBillingUsageTransactionCalculationFactors> getCalculationFactors() {
        return calculationFactors;
    }

    public void setCalculationFactors(List<EnergyBillingUsageTransactionCalculationFactors> calculationFactors) {
        this.calculationFactors = calculationFactors;
    }

    public EnergyBillingDemandTransactionV3 adjustments(List<EnergyBillingUsageTransactionAdjustments> adjustments) {
        this.adjustments = adjustments;
        return this;
    }

    public EnergyBillingDemandTransactionV3 addAdjustmentsItem(EnergyBillingUsageTransactionAdjustments adjustmentsItem) {
        if (this.adjustments == null) {
            this.adjustments = new ArrayList<>();
        }
        this.adjustments.add(adjustmentsItem);
        return this;
    }

    /**
     * Optional array of adjustments arising for this transaction.
     *
     * @return adjustments
     */
    @Override
    @ApiModelProperty(value = "Optional array of adjustments arising for this transaction.")
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
        EnergyBillingDemandTransactionV3 energyBillingDemandTransaction = (EnergyBillingDemandTransactionV3) o;
        return Objects.equals(this.servicePointId, energyBillingDemandTransaction.servicePointId) &&
                Objects.equals(this.invoiceNumber, energyBillingDemandTransaction.invoiceNumber) &&
                Objects.equals(this.timeOfUseType, energyBillingDemandTransaction.timeOfUseType) &&
                Objects.equals(this.description, energyBillingDemandTransaction.description) &&
                Objects.equals(this.isEstimate, energyBillingDemandTransaction.isEstimate) &&
                Objects.equals(this.startDate, energyBillingDemandTransaction.startDate) &&
                Objects.equals(this.endDate, energyBillingDemandTransaction.endDate) &&
                Objects.equals(this.measureUnit, energyBillingDemandTransaction.measureUnit) &&
                Objects.equals(this.rate, energyBillingDemandTransaction.rate) &&
                Objects.equals(this.amount, energyBillingDemandTransaction.amount) &&
                Objects.equals(this.calculationFactors, energyBillingDemandTransaction.calculationFactors) &&
                Objects.equals(this.adjustments, energyBillingDemandTransaction.adjustments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicePointId, invoiceNumber, timeOfUseType, description, isEstimate, startDate, endDate, measureUnit, rate, amount, calculationFactors, adjustments);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyBillingDemandTransactionV3 {\n");
        sb.append("    servicePointId: ").append(toIndentedString(servicePointId)).append("\n");
        sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
        sb.append("    timeOfUseType: ").append(toIndentedString(timeOfUseType)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    isEstimate: ").append(toIndentedString(isEstimate)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    measureUnit: ").append(toIndentedString(measureUnit)).append("\n");
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
