package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

public interface EnergyBillingTransaction {
    /**
     * The ID of the account for which transaction applies.
     *
     * @return accountId
     */
    @ApiModelProperty(required = true, value = "The ID of the account for which transaction applies.")
    @NotNull
    String getAccountId();

    /**
     * The date and time that the transaction occurred.
     *
     * @return executionDateTime
     */
    @ApiModelProperty(required = true, value = "The date and time that the transaction occurred.")
    @NotNull
    OffsetDateTime getExecutionDateTime();

    /**
     * The GST incurred in the transaction. Should not be included for credits or payments. If absent zero is assumed.
     *
     * @return gst
     */
    @ApiModelProperty(value = "The GST incurred in the transaction. Should not be included for credits or payments. If absent zero is assumed.")
    String getGst();

    /**
     * Indicator of the type of transaction object present in this record.
     *
     * @return transactionUType
     */
    @ApiModelProperty(required = true, value = "Indicator of the type of transaction object present in this record.")
    @NotNull
    TransactionUTypeEnum getTransactionUType();

    /**
     * Get usage
     *
     * @return usage
     */
    @ApiModelProperty(value = "")
    @Valid
    EnergyBillingUsageTransaction getUsage();

    /**
     * Get onceOff
     *
     * @return onceOff
     */
    @ApiModelProperty(value = "")
    @Valid
    EnergyBillingOnceOffTransaction getOnceOff();

    /**
     * Get otherCharges
     *
     * @return otherCharges
     */
    @ApiModelProperty(value = "")
    @Valid
    EnergyBillingOtherTransaction getOtherCharges();

    /**
     * Get payment
     *
     * @return payment
     */
    @ApiModelProperty(value = "")
    @Valid
    EnergyBillingPaymentTransaction getPayment();

    /**
     * Indicator of the type of transaction object present in this record.
     */
    public enum TransactionUTypeEnum {
        USAGE("usage"),

        DEMAND("demand"),

        ONCEOFF("onceOff"),

        OTHERCHARGES("otherCharges"),

        PAYMENT("payment");

        private final String value;

        TransactionUTypeEnum(String value) {
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
        public static TransactionUTypeEnum fromValue(String value) {
            for (TransactionUTypeEnum b : EnergyBillingTransaction.TransactionUTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }
}
