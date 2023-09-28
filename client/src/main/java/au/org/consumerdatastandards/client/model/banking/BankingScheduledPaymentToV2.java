/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 */
package au.org.consumerdatastandards.client.model.banking;

import java.util.Objects;

/**
 * Object containing details of the destination of the payment. Used to specify a variety of payment destination types
 */
public class BankingScheduledPaymentToV2 extends BankingScheduledPaymentToV1 {

    private BankingDigitalWalletPayee digitalWallet;

    public BankingDigitalWalletPayee getDigitalWallet() {
        return digitalWallet;
    }

    public void setDigitalWallet(BankingDigitalWalletPayee digitalWallet) {
        this.digitalWallet = digitalWallet;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) &&
            Objects.equals(this.digitalWallet, ((BankingScheduledPaymentToV2)o).digitalWallet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), digitalWallet);
    }

    @Override
    protected void writeProperties(StringBuilder sb) {
        super.writeProperties(sb);
        sb.append("    digitalWallet: ").append(toIndentedString(digitalWallet)).append("\n");
    }
}
