package au.org.consumerdatastandards.holder.model.banking;

import io.swagger.annotations.ApiModelProperty;

public interface BankingScheduledPaymentSet {
    @ApiModelProperty(value = "Flag indicating whether the amount of the payment is calculated based on the context of the event. For instance a payment to reduce the balance of a credit card to zero. If absent then false is assumed")
    String getAmount();

    @ApiModelProperty(value = "The currency for the payment. AUD assumed if not present")
    String getCurrency();

    @ApiModelProperty(value = "Flag indicating whether the amount of the payment is calculated based on the context of the event. For instance a payment to reduce the balance of a credit card to zero. If absent then false is assumed")
    Boolean getIsAmountCalculated();
}
