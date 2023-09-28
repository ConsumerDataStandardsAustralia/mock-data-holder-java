package au.org.consumerdatastandards.holder.model.banking;

import io.swagger.annotations.ApiModelProperty;

public interface BankingScheduledPaymentTo {
    @ApiModelProperty(value = "Present if toUType is set to accountId. Indicates that the payment is to another account that is accessible under the current consent")
    String getAccountId();

    @ApiModelProperty
    BankingBillerPayee getBiller();

    @ApiModelProperty
    BankingDomesticPayee getDomestic();

    @ApiModelProperty
    BankingInternationalPayee getInternational();

    @ApiModelProperty(value = "Present if toUType is set to payeeId. Indicates that the payment is to registered payee that can be accessed using the payee end point. If the Bank Payees scope has not been consented to then a payeeId should not be provided and the full payee details should be provided instead")
    String getPayeeId();

    @ApiModelProperty(value = "The short display name of the payee as provided by the customer unless toUType is set to payeeId. Where a customer has not provided a nickname, a display name derived by the bank for payee should be provided that is consistent with existing digital banking channels")
    String getNickname();

    @ApiModelProperty(required = true,
            value = "The reference for the transaction, if applicable, that will be provided by the originating institution for the specific payment. If not empty, it overrides the value provided at the BankingScheduledPayment level.")
    String getPayeeReference();

    @ApiModelProperty(required = true)
    ToUType getToUType();
}
