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
public class BankingTransactionDetailV1 extends BankingTransactionDetail {

    @Embedded @NotNull
    private BankingTransactionDetailExtendedData extendedData;

    public BankingTransactionDetailV1 extendedData(BankingTransactionDetailExtendedData extendedData) {
        this.extendedData = extendedData;
        return this;
    }

    @ApiModelProperty(required = true)
    public BankingTransactionDetailExtendedData getExtendedData() {
        return extendedData;
    }

    public void setExtendedData(BankingTransactionDetailExtendedData extendedData) {
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
        BankingTransactionDetailV1 bankingTransactionDetail = (BankingTransactionDetailV1) o;
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