package au.org.consumerdatastandards.holder.model.banking;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@ApiModel
@Entity
@Table(name = "b_transaction")
public class BankingTransactionDetailV2 extends BankingTransactionDetail {

    @Embedded @NotNull
    private BankingTransactionDetailV2ExtendedData extendedData;

    public BankingTransactionDetailV2 extendedData(BankingTransactionDetailV2ExtendedData extendedData) {
        this.extendedData = extendedData;
        return this;
    }

    @ApiModelProperty(required = true)
    public BankingTransactionDetailV2ExtendedData getExtendedData() {
        return extendedData;
    }

    public void setExtendedData(BankingTransactionDetailV2ExtendedData extendedData) {
        this.extendedData = extendedData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingTransactionDetailV2 bankingTransactionDetail = (BankingTransactionDetailV2) o;
        return Objects.equals(this.extendedData, bankingTransactionDetail.extendedData) &&
            super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            extendedData,
            super.hashCode());
    }

    protected void stringProperties(StringBuilder sb) {
        super.stringProperties(sb);
        sb.append("\n   extendedData: ").append(toIndentedString(extendedData));
    }
}