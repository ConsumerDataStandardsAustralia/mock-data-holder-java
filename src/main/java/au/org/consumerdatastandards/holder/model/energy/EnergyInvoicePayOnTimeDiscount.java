package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A discount for on time payment.
 */
@ApiModel(description = "A discount for on time payment.")
@Entity
public class EnergyInvoicePayOnTimeDiscount {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String discountAmount;

    private String gstAmount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate date;     // "x-cds-type" : "DateString"

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyInvoicePayOnTimeDiscount discountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
        return this;
    }

    /**
     * The amount that will be discounted if the invoice is paid by the date specified.
     *
     * @return discountAmount
     */
    @ApiModelProperty(required = true,
            value = "The amount that will be discounted if the invoice is paid by the date specified.")
    @NotNull
    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public EnergyInvoicePayOnTimeDiscount gstAmount(String gstAmount) {
        this.gstAmount = gstAmount;
        return this;
    }

    /**
     * The GST amount that will be discounted if the invoice is paid by the date specified. If absent then zero is assumed.
     *
     * @return gstAmount
     */
    @ApiModelProperty(value = "The GST amount that will be discounted if the invoice is paid by the date specified. If absent then zero is assumed.")
    public String getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(String gstAmount) {
        this.gstAmount = gstAmount;
    }

    public EnergyInvoicePayOnTimeDiscount date(LocalDate date) {
        this.date = date;
        return this;
    }

    /**
     * The date by which the invoice must be paid to receive the pay on time discount.
     *
     * @return date
     */
    @ApiModelProperty(required = true,
            value = "The date by which the invoice must be paid to receive the pay on time discount.")
    @NotNull
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyInvoicePayOnTimeDiscount energyInvoicePayOnTimeDiscount = (EnergyInvoicePayOnTimeDiscount) o;
        return Objects.equals(this.discountAmount, energyInvoicePayOnTimeDiscount.discountAmount) &&
                Objects.equals(this.gstAmount, energyInvoicePayOnTimeDiscount.gstAmount) &&
                Objects.equals(this.date, energyInvoicePayOnTimeDiscount.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountAmount, gstAmount, date);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyInvoicePayOnTimeDiscount {\n");
        sb.append("    discountAmount: ").append(toIndentedString(discountAmount)).append("\n");
        sb.append("    gstAmount: ").append(toIndentedString(gstAmount)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
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
