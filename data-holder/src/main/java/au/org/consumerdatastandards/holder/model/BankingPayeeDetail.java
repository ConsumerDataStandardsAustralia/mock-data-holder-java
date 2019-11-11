package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.Objects;

@ApiModel
public class BankingPayeeDetail extends BankingPayee {

    /**
     * The date the payee was created by the customer
     */
    private LocalDate creationDate;

    /**
     * A description of the payee provided by the customer
     */
    private String description;

    /**
     * The short display name of the payee as provided by the customer
     */
    private String nickname;

    /**
     * ID of the payee adhering to the rules of ID permanence
     */
    private String payeeId;

    /**
     * Get type
     */
    private BankingPayee.Type type;

    /**
     * Get biller
     */
    private BankingBillerPayee biller;

    /**
     * Get domestic
     */
    private BankingDomesticPayee domestic;

    /**
     * Get international
     */
    private BankingInternationalPayee international;

    public enum PayeeUType {
        BILLER,
        DOMESTIC,
        INTERNATIONAL
    }
    /**
     * Get payeeUType
     */
    private PayeeUType payeeUType;

    public BankingPayeeDetail creationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    @ApiModelProperty(value = "The date the payee was created by the customer")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public BankingPayeeDetail description(String description) {
        this.description = description;
        return this;
    }

    @ApiModelProperty(value = "A description of the payee provided by the customer")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public BankingPayeeDetail nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    @ApiModelProperty(required = true, value = "The short display name of the payee as provided by the customer")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public BankingPayeeDetail payeeId(String payeeId) {
        this.payeeId = payeeId;
        return this;
    }

    @ApiModelProperty(required = true, value = "ID of the payee adhering to the rules of ID permanence")
    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }
    public BankingPayeeDetail type(BankingPayee.Type type) {
        this.type = type;
        return this;
    }

    @ApiModelProperty(required = true)
    public BankingPayee.Type getType() {
        return type;
    }

    public void setType(BankingPayee.Type type) {
        this.type = type;
    }
    public BankingPayeeDetail biller(BankingBillerPayee biller) {
        this.biller = biller;
        return this;
    }

    @ApiModelProperty
    public BankingBillerPayee getBiller() {
        return biller;
    }

    public void setBiller(BankingBillerPayee biller) {
        this.biller = biller;
    }
    public BankingPayeeDetail domestic(BankingDomesticPayee domestic) {
        this.domestic = domestic;
        return this;
    }

    @ApiModelProperty
    public BankingDomesticPayee getDomestic() {
        return domestic;
    }

    public void setDomestic(BankingDomesticPayee domestic) {
        this.domestic = domestic;
    }

    public BankingPayeeDetail international(BankingInternationalPayee international) {
        this.international = international;
        return this;
    }

    @ApiModelProperty
    public BankingInternationalPayee getInternational() {
        return international;
    }

    public void setInternational(BankingInternationalPayee international) {
        this.international = international;
    }

    public BankingPayeeDetail payeeUType(PayeeUType payeeUType) {
        this.payeeUType = payeeUType;
        return this;
    }

    @ApiModelProperty(required = true)
    public PayeeUType getPayeeUType() {
        return payeeUType;
    }

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
        BankingPayeeDetail bankingPayeeDetail = (BankingPayeeDetail) o;
        return Objects.equals(this.biller, bankingPayeeDetail.biller) &&
            Objects.equals(this.domestic, bankingPayeeDetail.domestic) &&
            Objects.equals(this.international, bankingPayeeDetail.international) &&
            Objects.equals(this.payeeUType, bankingPayeeDetail.payeeUType) &&
            super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            biller,
            domestic,
            international,
            payeeUType,
            super.hashCode());
    }

    @Override
    public String toString() {
        return "class BankingPayeeDetail {\n" +
            "   creationDate: " + toIndentedString(getCreationDate()) + "\n" + 
            "   description: " + toIndentedString(getDescription()) + "\n" + 
            "   nickname: " + toIndentedString(getNickname()) + "\n" + 
            "   payeeId: " + toIndentedString(getPayeeId()) + "\n" + 
            "   type: " + toIndentedString(getType()) + "\n" + 
            "   biller: " + toIndentedString(biller) + "\n" + 
            "   domestic: " + toIndentedString(domestic) + "\n" + 
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

