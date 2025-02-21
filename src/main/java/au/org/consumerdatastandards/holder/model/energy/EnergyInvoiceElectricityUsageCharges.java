package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyInvoiceElectricityUsageCharges
 */
@Entity
public class EnergyInvoiceElectricityUsageCharges {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String totalUsageCharges;

    private String totalGenerationCredits;

    private String totalOnceOffCharges;

    private String totalOnceOffDiscounts;

    @OneToMany(cascade = CascadeType.ALL)
    @Valid
    private List<EnergyInvoiceUsageChargesOtherCharges> otherCharges = null;

    private String totalGst;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyInvoiceElectricityUsageCharges totalUsageCharges(String totalUsageCharges) {
        this.totalUsageCharges = totalUsageCharges;
        return this;
    }

    /**
     * The aggregate total of usage charges for the period covered by the invoice (exclusive of GST).
     *
     * @return totalUsageCharges
     */
    @ApiModelProperty(required = true,
            value = "The aggregate total of usage charges for the period covered by the invoice (exclusive of GST).")
    @NotNull
    public String getTotalUsageCharges() {
        return totalUsageCharges;
    }

    public void setTotalUsageCharges(String totalUsageCharges) {
        this.totalUsageCharges = totalUsageCharges;
    }

    public EnergyInvoiceElectricityUsageCharges totalGenerationCredits(String totalGenerationCredits) {
        this.totalGenerationCredits = totalGenerationCredits;
        return this;
    }

    /**
     * The aggregate total of generation credits for the period covered by the invoice (exclusive of GST).
     *
     * @return totalGenerationCredits
     */
    @ApiModelProperty(required = true,
            value = "The aggregate total of generation credits for the period covered by the invoice (exclusive of GST).")
    @NotNull
    public String getTotalGenerationCredits() {
        return totalGenerationCredits;
    }

    public void setTotalGenerationCredits(String totalGenerationCredits) {
        this.totalGenerationCredits = totalGenerationCredits;
    }

    public EnergyInvoiceElectricityUsageCharges totalOnceOffCharges(String totalOnceOffCharges) {
        this.totalOnceOffCharges = totalOnceOffCharges;
        return this;
    }

    /**
     * The aggregate total of any once off charges arising from electricity usage for the period covered by the invoice (exclusive of GST).
     *
     * @return totalOnceOffCharges
     */
    @ApiModelProperty(required = true,
            value = "The aggregate total of any once off charges arising from electricity usage for the period covered by the invoice (exclusive of GST).")
    @NotNull
    public String getTotalOnceOffCharges() {
        return totalOnceOffCharges;
    }

    public void setTotalOnceOffCharges(String totalOnceOffCharges) {
        this.totalOnceOffCharges = totalOnceOffCharges;
    }

    public EnergyInvoiceElectricityUsageCharges totalOnceOffDiscounts(String totalOnceOffDiscounts) {
        this.totalOnceOffDiscounts = totalOnceOffDiscounts;
        return this;
    }

    /**
     * The aggregate total of any once off discounts or credits arising from electricity usage for the period covered by the invoice (exclusive of GST).
     *
     * @return totalOnceOffDiscounts
     */
    @ApiModelProperty(required = true,
            value = "The aggregate total of any once off discounts or credits arising from electricity usage for the period covered by the invoice (exclusive of GST).")
    @NotNull
    public String getTotalOnceOffDiscounts() {
        return totalOnceOffDiscounts;
    }

    public void setTotalOnceOffDiscounts(String totalOnceOffDiscounts) {
        this.totalOnceOffDiscounts = totalOnceOffDiscounts;
    }

    public EnergyInvoiceElectricityUsageCharges otherCharges(List<EnergyInvoiceUsageChargesOtherCharges> otherCharges) {
        this.otherCharges = otherCharges;
        return this;
    }

    public EnergyInvoiceElectricityUsageCharges addOtherChargesItem(EnergyInvoiceUsageChargesOtherCharges otherChargesItem) {
        if (this.otherCharges == null) {
            this.otherCharges = new ArrayList<>();
        }
        this.otherCharges.add(otherChargesItem);
        return this;
    }

    /**
     * Optional array of charges that may be part of the invoice (for e.g. environmental charges for C&amp;I consumers) (exclusive of GST)
     *
     * @return otherCharges
     */
    @ApiModelProperty(value = "Optional array of charges that may be part of the invoice (for e.g., environmental charges for C&I consumers) (exclusive of GST).")
    @Valid
    public List<EnergyInvoiceUsageChargesOtherCharges> getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(List<EnergyInvoiceUsageChargesOtherCharges> otherCharges) {
        this.otherCharges = otherCharges;
    }

    public EnergyInvoiceElectricityUsageCharges totalGst(String totalGst) {
        this.totalGst = totalGst;
        return this;
    }

    /**
     * The total GST for all electricity usage charges. If absent then zero is assumed.
     *
     * @return totalGst
     */
    @ApiModelProperty(value = "The total GST for all electricity usage charges. If absent then zero is assumed.")
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
        EnergyInvoiceElectricityUsageCharges energyInvoiceElectricityUsageCharges = (EnergyInvoiceElectricityUsageCharges) o;
        return Objects.equals(this.totalUsageCharges, energyInvoiceElectricityUsageCharges.totalUsageCharges) &&
                Objects.equals(this.totalGenerationCredits, energyInvoiceElectricityUsageCharges.totalGenerationCredits) &&
                Objects.equals(this.totalOnceOffCharges, energyInvoiceElectricityUsageCharges.totalOnceOffCharges) &&
                Objects.equals(this.totalOnceOffDiscounts, energyInvoiceElectricityUsageCharges.totalOnceOffDiscounts) &&
                Objects.equals(this.otherCharges, energyInvoiceElectricityUsageCharges.otherCharges) &&
                Objects.equals(this.totalGst, energyInvoiceElectricityUsageCharges.totalGst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalUsageCharges, totalGenerationCredits, totalOnceOffCharges, totalOnceOffDiscounts, otherCharges, totalGst);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyInvoiceElectricityUsageCharges {\n");
        sb.append("    totalUsageCharges: ").append(toIndentedString(totalUsageCharges)).append("\n");
        sb.append("    totalGenerationCredits: ").append(toIndentedString(totalGenerationCredits)).append("\n");
        sb.append("    totalOnceOffCharges: ").append(toIndentedString(totalOnceOffCharges)).append("\n");
        sb.append("    totalOnceOffDiscounts: ").append(toIndentedString(totalOnceOffDiscounts)).append("\n");
        sb.append("    otherCharges: ").append(toIndentedString(otherCharges)).append("\n");
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
