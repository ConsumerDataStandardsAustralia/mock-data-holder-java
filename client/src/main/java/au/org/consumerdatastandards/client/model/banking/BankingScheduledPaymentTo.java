package au.org.consumerdatastandards.client.model.banking;

public interface BankingScheduledPaymentTo {
    /**
     * The type of object provided that specifies the destination of the funds for the payment.
     *
     * @return toUType
     */
    ToUType getToUType();

    /**
     * Present if toUType is set to accountId. Indicates that the payment is to another account that is accessible under the current consent
     *
     * @return accountId
     */
    String getAccountId();

    /**
     * Present if toUType is set to payeeId. Indicates that the payment is to registered payee that can be accessed using the payee end point. If the Bank Payees scope has not been consented to then a payeeId should not be provided and the full payee details should be provided instead
     *
     * @return payeeId
     */
    String getPayeeId();

    /**
     * Get domestic
     *
     * @return domestic
     */
    BankingDomesticPayee getDomestic();

    /**
     * Get biller
     *
     * @return biller
     */
    BankingBillerPayee getBiller();

    /**
     * Get international
     *
     * @return international
     */
    BankingInternationalPayee getInternational();

    /**
     * The short display name of the payee as provided by the customer unless toUType is set to payeeId. Where a customer has not provided a nickname, a display name derived by the bank for payee should be provided that is consistent with existing digital banking channels
     *
     * @return nickname
     */
    String getNickname();

    /**
     * The reference for the transaction, if applicable, that will be provided by the originating institution for the specific payment. If not empty, it overrides the value provided at the BankingScheduledPayment level.
     *
     * @return payeeReference
     */
    String getPayeeReference();
}
