package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public interface EnergyBillingDemandTransaction {
    /**
     * The ID of the service point to which this transaction applies if any..
     *
     * @return servicePointId
     */
    @ApiModelProperty(value = "The ID of the service point to which this transaction applies if any..")
    String getServicePointId();

    /**
     * The number of the invoice in which this transaction is included if it has been issued.
     *
     * @return invoiceNumber
     */
    @ApiModelProperty(value = "The number of the invoice in which this transaction is included if it has been issued.")
    String getInvoiceNumber();

    /**
     * The time of use type that the transaction applies to.
     *
     * @return timeOfUseType
     */
    @ApiModelProperty(required = true, value = "The time of use type that the transaction applies to.")
    @NotNull
    TimeOfUseTypeEnum getTimeOfUseType();

    /**
     * Optional description of the transaction that can be used for display purposes.
     *
     * @return description
     */
    @ApiModelProperty(value = "Optional description of the transaction that can be used for display purposes.")
    String getDescription();

    /**
     * Flag indicating if the usage is estimated or actual. `true` indicates estimate. `false` or absent indicates actual.
     *
     * @return isEstimate
     */
    @ApiModelProperty(value = "Flag indicating if the usage is estimated or actual. `true` indicates estimate. `false` or absent indicates actual.")
    Boolean getIsEstimate();

    /**
     * Date and time when the demand period starts.
     *
     * @return startDate
     */
    @ApiModelProperty(required = true, value = "Date and time when the demand period starts.")
    @NotNull
    OffsetDateTime getStartDate();

    /**
     * Date and time when the demand period ends.
     *
     * @return endDate
     */
    @ApiModelProperty(required = true, value = "Date and time when the demand period ends.")
    @NotNull
    OffsetDateTime getEndDate();

    /**
     * The rate for the demand charge in _measureUnit_. Assumed to be `KVA` if _measureUnit_ not provided. A negative value indicates power generated.
     *
     * @return rate
     */
    @ApiModelProperty(required = true,
            value = "The rate for the demand charge in _measureUnit_. Assumed to be `KVA` if _measureUnit_ not provided. A negative value indicates power generated.")
    @NotNull
    @Valid
    BigDecimal getRate();

    /**
     * The amount charged or credited for this transaction prior to any adjustments being applied. A negative value indicates a credit.
     *
     * @return amount
     */
    @ApiModelProperty(required = true,
            value = "The amount charged or credited for this transaction prior to any adjustments being applied. A negative value indicates a credit.")
    @NotNull
    String getAmount();

    /**
     * Additional calculation factors that inform the transaction.
     *
     * @return calculationFactors
     */
    @ApiModelProperty(value = "Additional calculation factors that inform the transaction.")
    @Valid
    List<EnergyBillingUsageTransactionCalculationFactors> getCalculationFactors();

    /**
     * Optional array of adjustments arising for this transaction.
     *
     * @return adjustments
     */
    @ApiModelProperty(value = "Optional array of adjustments arising for this transaction.")
    @Valid
    List<EnergyBillingUsageTransactionAdjustments> getAdjustments();

    /**
     * The time of use type that the transaction applies to.
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
}
