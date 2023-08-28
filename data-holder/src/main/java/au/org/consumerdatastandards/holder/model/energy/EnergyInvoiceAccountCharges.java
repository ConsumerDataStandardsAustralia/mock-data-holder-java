package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Object contains account level charges and credits related to electricity usage
 */
@ApiModel(description = "Object contains account level charges and credits related to electricity usage")
@Entity
public class EnergyInvoiceAccountCharges {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String totalCharges;

    private String totalDiscounts;

    private String totalGst;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyInvoiceAccountCharges totalCharges(String totalCharges) {
        this.totalCharges = totalCharges;
        return this;
    }

    /**
     * The aggregate total of account level charges for the period covered by the invoice
     *
     * @return totalCharges
     */
    @ApiModelProperty(required = true,
            value = "The aggregate total of account level charges for the period covered by the invoice")
    @NotNull
    public String getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(String totalCharges) {
        this.totalCharges = totalCharges;
    }

    public EnergyInvoiceAccountCharges totalDiscounts(String totalDiscounts) {
        this.totalDiscounts = totalDiscounts;
        return this;
    }

    /**
     * The aggregate total of account level discounts or credits for the period covered by the invoice
     *
     * @return totalDiscounts
     */
    @ApiModelProperty(required = true,
            value = "The aggregate total of account level discounts or credits for the period covered by the invoice")
    @NotNull
    public String getTotalDiscounts() {
        return totalDiscounts;
    }

    public void setTotalDiscounts(String totalDiscounts) {
        this.totalDiscounts = totalDiscounts;
    }

    public EnergyInvoiceAccountCharges totalGst(String totalGst) {
        this.totalGst = totalGst;
        return this;
    }

    /**
     * The total GST for all account level charges.  If absent then zero is assumed
     *
     * @return totalGst
     */
    @ApiModelProperty(value = "The total GST for all account level charges.  If absent then zero is assumed")
    public String getTotalGst() {
        return totalGst;
    }

    public void setTotalGst(String totalGst) {
        this.totalGst = totalGst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyInvoiceAccountCharges energyInvoiceAccountCharges = (EnergyInvoiceAccountCharges) o;
        return Objects.equals(this.totalCharges, energyInvoiceAccountCharges.totalCharges) &&
                Objects.equals(this.totalDiscounts, energyInvoiceAccountCharges.totalDiscounts) &&
                Objects.equals(this.totalGst, energyInvoiceAccountCharges.totalGst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalCharges, totalDiscounts, totalGst);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyInvoiceAccountCharges {\n");
        sb.append("    totalCharges: ").append(toIndentedString(totalCharges)).append("\n");
        sb.append("    totalDiscounts: ").append(toIndentedString(totalDiscounts)).append("\n");
        sb.append("    totalGst: ").append(toIndentedString(totalGst)).append("\n");
        sb.append("}");
        return sb.toString();
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
