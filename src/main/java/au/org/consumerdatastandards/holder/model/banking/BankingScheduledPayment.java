package au.org.consumerdatastandards.holder.model.banking;

import io.swagger.annotations.ApiModelProperty;

public interface BankingScheduledPayment {
    @ApiModelProperty(required = true)
    BankingScheduledPaymentFrom getFrom();

    @ApiModelProperty(value = "The short display name of the scheduled payment as provided by the customer if provided. Where a customer has not provided a nickname, a display name derived by the bank for the scheduled payment should be provided that is consistent with existing digital banking channels")
    String getNickname();

    @ApiModelProperty(required = true,
            value = "The reference for the transaction, if applicable, that will be provided by the originating institution for all payments in the payment set. Empty string if no data provided")
    String getPayeeReference();

    @ApiModelProperty(required = true,
            value = "The reference for the transaction that will be used by the originating institution for the purposes of constructing a statement narrative on the payer’s account. Empty string if no data provided")
    String getPayerReference();

    @ApiModelProperty(required = true)
    BankingScheduledPaymentRecurrence getRecurrence();

    @ApiModelProperty(required = true,
            value = "A unique ID of the scheduled payment adhering to the standards for ID permanence")
    String getScheduledPaymentId();
}
