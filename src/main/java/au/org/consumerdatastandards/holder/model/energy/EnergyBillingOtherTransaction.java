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
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyBillingOtherTransaction
 */
@Entity
public class EnergyBillingOtherTransaction {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String servicePointId;

    private String invoiceNumber;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate startDate;    // "x-cds-type" : "DateString"

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate endDate;      // "x-cds-type" : "DateString"

    /**
     * Type of charge. Assumed to be other if absent
     */
    public enum TypeEnum {
        ENVIRONMENTAL,
        REGULATED,
        NETWORK,
        METERING,
        RETAIL_SERVICE,
        RCTI,
        OTHER
    }

    private TypeEnum type;

    private String amount;

    private String description;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<EnergyBillingUsageTransactionCalculationFactors> calculationFactors;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<EnergyBillingUsageTransactionAdjustments> adjustments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyBillingOtherTransaction servicePointId(String servicePointId) {
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

    public EnergyBillingOtherTransaction invoiceNumber(String invoiceNumber) {
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

    public EnergyBillingOtherTransaction startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Optional start date for the application of the charge
     *
     * @return startDate
     */
    @ApiModelProperty(value = "Optional start date for the application of the charge")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public EnergyBillingOtherTransaction endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Optional end date for the application of the charge
     *
     * @return endDate
     */
    @ApiModelProperty(value = "Optional end date for the application of the charge")
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public EnergyBillingOtherTransaction type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Type of charge. Assumed to be other if absent
     *
     * @return type
     */
    @ApiModelProperty(value = "Type of charge. Assumed to be other if absent")
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public EnergyBillingOtherTransaction amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The amount of the charge
     *
     * @return amount
     */
    @ApiModelProperty(required = true, value = "The amount of the charge")
    @NotNull
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public EnergyBillingOtherTransaction description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A free text description of the item
     *
     * @return description
     */
    @ApiModelProperty(required = true, value = "A free text description of the item")
    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnergyBillingOtherTransaction addCalculationFactorsItem(EnergyBillingUsageTransactionCalculationFactors calculationFactorsItem) {
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

    public EnergyBillingOtherTransaction adjustments(List<EnergyBillingUsageTransactionAdjustments> adjustments) {
        this.adjustments = adjustments;
        return this;
    }

    public EnergyBillingOtherTransaction addAdjustmentsItem(EnergyBillingUsageTransactionAdjustments adjustmentsItem) {
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
        EnergyBillingOtherTransaction energyBillingOtherTransaction = (EnergyBillingOtherTransaction) o;
        return Objects.equals(this.servicePointId, energyBillingOtherTransaction.servicePointId) &&
                Objects.equals(this.invoiceNumber, energyBillingOtherTransaction.invoiceNumber) &&
                Objects.equals(this.startDate, energyBillingOtherTransaction.startDate) &&
                Objects.equals(this.endDate, energyBillingOtherTransaction.endDate) &&
                Objects.equals(this.type, energyBillingOtherTransaction.type) &&
                Objects.equals(this.amount, energyBillingOtherTransaction.amount) &&
                Objects.equals(this.description, energyBillingOtherTransaction.description) &&
                Objects.equals(this.calculationFactors, energyBillingOtherTransaction.calculationFactors) &&
                Objects.equals(this.adjustments, energyBillingOtherTransaction.adjustments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(servicePointId, invoiceNumber, startDate, endDate, type, amount, description, calculationFactors, adjustments);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyBillingOtherTransaction {\n");
        sb.append("    servicePointId: ").append(toIndentedString(servicePointId)).append("\n");
        sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
