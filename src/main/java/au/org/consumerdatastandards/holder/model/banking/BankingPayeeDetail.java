package au.org.consumerdatastandards.holder.model.banking;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public interface BankingPayeeDetail {
    String getPayeeId();

    void setPayeeId(String payeeId);

    LocalDate getCreationDate();

    void setCreationDate(LocalDate creationDate);

    String getDescription();

    void setDescription(String description);

    String getNickname();

    void setNickname(String nickname);

    BankingPayee.Type getType();

    void setType(BankingPayee.Type type);

    @ApiModelProperty
    BankingBillerPayee getBiller();

    void setBiller(BankingBillerPayee biller);

    @ApiModelProperty
    BankingDomesticPayee getDomestic();

    void setDomestic(BankingDomesticPayee domestic);

    @ApiModelProperty
    BankingInternationalPayee getInternational();

    void setInternational(BankingInternationalPayee international);

    @ApiModelProperty(required = true, value = "Type of object included that describes the payee in detail.")
    PayeeUType getPayeeUType();

    void setPayeeUType(PayeeUType payeeUType);

    public enum PayeeUType {
        biller,
        digitalWallet,
        domestic,
        international
    }
}
