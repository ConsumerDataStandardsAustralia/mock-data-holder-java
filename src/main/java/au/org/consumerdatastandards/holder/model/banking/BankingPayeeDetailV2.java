package au.org.consumerdatastandards.holder.model.banking;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel
@Entity
@Table(name = "b_payee")
public class BankingPayeeDetailV2 implements BankingPayeeDetail {

    /**
     * ID of the payee adhering to the rules of ID permanence.
     */
    @Id
    private String payeeId;

    /**
     * The date the payee was created by the customer.
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate creationDate;

    /**
     * A description of the payee provided by the customer.
     */
    private String description;

    /**
     * The short display name of the payee as provided by the customer. Where a customer has not provided a nickname, a display name derived by the bank for the payee consistent with existing digital banking channels.
     */
    private String nickname;

    private BankingPayee.Type type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "b_payee_billers",
            joinColumns = @JoinColumn(name = "payee_id"),
            inverseJoinColumns = @JoinColumn(name = "biller_id"))
    private BankingBillerPayee biller;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "b_payee_domestics",
            joinColumns = @JoinColumn(name = "payee_id"),
            inverseJoinColumns = @JoinColumn(name = "domestic_id"))
    private BankingDomesticPayee domestic;

    @OneToOne(cascade = CascadeType.ALL)
    private BankingDigitalWalletPayee digitalWallet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "b_payee_intnls",
            joinColumns = @JoinColumn(name = "payee_id"),
            inverseJoinColumns = @JoinColumn(name = "intnl_id"))
    private BankingInternationalPayee international;

    /**
     * Type of object included that describes the payee in detail.
     */
    private PayeeUType payeeUType;

    @Override
    public String getPayeeId() {
        return payeeId;
    }

    @Override
    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getNickname() {
        return nickname;
    }

    @Override
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public BankingPayee.Type getType() {
        return type;
    }

    @Override
    public void setType(BankingPayee.Type type) {
        this.type = type;
    }

    public BankingPayeeDetailV2 creationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public BankingPayeeDetailV2 description(String description) {
        this.description = description;
        return this;
    }

    public BankingPayeeDetailV2 nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public BankingPayeeDetailV2 payeeId(String payeeId) {
        this.payeeId = payeeId;
        return this;
    }

    public BankingPayeeDetailV2 type(BankingPayee.Type type) {
        this.type = type;
        return this;
    }

    public BankingPayeeDetailV2 biller(BankingBillerPayee biller) {
        this.biller = biller;
        return this;
    }

    @Override
    @ApiModelProperty
    public BankingBillerPayee getBiller() {
        return biller;
    }

    @Override
    public void setBiller(BankingBillerPayee biller) {
        this.biller = biller;
    }
    public BankingPayeeDetailV2 domestic(BankingDomesticPayee domestic) {
        this.domestic = domestic;
        return this;
    }

    @Override
    @ApiModelProperty
    public BankingDomesticPayee getDomestic() {
        return domestic;
    }

    @Override
    public void setDomestic(BankingDomesticPayee domestic) {
        this.domestic = domestic;
    }

    public BankingDigitalWalletPayee getDigitalWallet() {
        return digitalWallet;
    }

    public void setDigitalWallet(BankingDigitalWalletPayee digitalWallet) {
        this.digitalWallet = digitalWallet;
    }

    public BankingPayeeDetailV2 international(BankingInternationalPayee international) {
        this.international = international;
        return this;
    }

    @Override
    @ApiModelProperty
    public BankingInternationalPayee getInternational() {
        return international;
    }

    @Override
    public void setInternational(BankingInternationalPayee international) {
        this.international = international;
    }

    public BankingPayeeDetailV2 payeeUType(PayeeUType payeeUType) {
        this.payeeUType = payeeUType;
        return this;
    }

    @Override
    @ApiModelProperty(required = true, value = "Type of object included that describes the payee in detail.")
    public PayeeUType getPayeeUType() {
        return payeeUType;
    }

    @Override
    public void setPayeeUType(PayeeUType payeeUType) {
        this.payeeUType = payeeUType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingPayeeDetailV2 bankingPayeeDetail = (BankingPayeeDetailV2) o;
        return Objects.equals(this.biller, bankingPayeeDetail.biller) &&
            Objects.equals(this.domestic, bankingPayeeDetail.domestic) &&
            Objects.equals(this.digitalWallet, bankingPayeeDetail.digitalWallet) &&
            Objects.equals(this.international, bankingPayeeDetail.international) &&
            Objects.equals(this.payeeUType, bankingPayeeDetail.payeeUType) &&
            super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            biller,
            domestic,
            digitalWallet,
            international,
            payeeUType,
            super.hashCode());
    }

    @Override
    public String toString() {
        return "class BankingPayeeDetailV2 {\n" +
            "   creationDate: " + toIndentedString(getCreationDate()) + "\n" + 
            "   description: " + toIndentedString(getDescription()) + "\n" + 
            "   nickname: " + toIndentedString(getNickname()) + "\n" + 
            "   payeeId: " + toIndentedString(getPayeeId()) + "\n" + 
            "   type: " + toIndentedString(getType()) + "\n" + 
            "   biller: " + toIndentedString(biller) + "\n" + 
            "   domestic: " + toIndentedString(domestic) + "\n" + 
            "   digitalWallet: " + toIndentedString(digitalWallet) + "\n" +
            "   international: " + toIndentedString(international) + "\n" +
            "   payeeUType: " + toIndentedString(payeeUType) + "\n" + 
            "}";
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
