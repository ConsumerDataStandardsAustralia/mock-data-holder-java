package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractTariffPeriodV2
 */
@Entity
@Table(name="e_tariff_period")
public class EnergyPlanContractTariffPeriodV2 extends EnergyPlanContractTariffPeriod {

    public enum DailySupplyChargeType {
        SINGLE,
        BAND
    }

    /**
     * Specifies if daily supply charge is single or banded.
     */
    private DailySupplyChargeType dailySupplyChargeType;

    @Column(name = "dailySupplyCharge")
    private String dailySupplyCharge;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EnergyBandedDailySupplyCharges> bandedDailySupplyCharges;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_tariff_period_tou_rates",
            joinColumns = @JoinColumn(name = "t_period_id"),
            inverseJoinColumns = @JoinColumn(name = "tou_rates_id"))
    private List<EnergyPlanContractTimeOfUseRatesV2> timeOfUseRates;

    /**
     * The amount of access charge for the tariff period, in dollars per day exclusive of GST. Mandatory if _dailySupplyChargeType_ is `SINGLE`.
     *
     * @return dailySupplyCharge
     */
    @ApiModelProperty(value = "The amount of access charge for the tariff period, in dollars per day exclusive of GST. Mandatory if _dailySupplyChargeType_ is `SINGLE`.")
    public String getDailySupplyCharge() {
        return dailySupplyCharge;
    }

    public void setDailySupplyCharge(String dailySupplyCharge) {
        this.dailySupplyCharge = dailySupplyCharge;
    }

    public EnergyPlanContractTariffPeriodV2 timeOfUseRates(List<EnergyPlanContractTimeOfUseRatesV2> timeOfUseRates) {
        this.timeOfUseRates = timeOfUseRates;
        return this;
    }

    public EnergyPlanContractTariffPeriodV2 addTimeOfUseRatesItem(EnergyPlanContractTimeOfUseRatesV2 timeOfUseRatesItem) {
        if (this.timeOfUseRates == null) {
            this.timeOfUseRates = new ArrayList<>();
        }
        this.timeOfUseRates.add(timeOfUseRatesItem);
        return this;
    }

    /**
     * Array of objects representing time of use rates. Required if _rateBlockUType_ is `timeOfUseRates`.
     *
     * @return timeOfUseRates
     */
    @ApiModelProperty(value = "Array of objects representing time of use rates. Required if _rateBlockUType_ is `timeOfUseRates`.")
    @Valid
    public List<EnergyPlanContractTimeOfUseRatesV2> getTimeOfUseRates() {
        return timeOfUseRates;
    }

    public void setTimeOfUseRates(List<EnergyPlanContractTimeOfUseRatesV2> timeOfUseRates) {
        this.timeOfUseRates = timeOfUseRates;
    }

    /**
     * Array representing banded daily supply charge rates. Mandatory if _dailySupplyChargeType_ is `BAND`.
     *
     * @return bandedDailySupplyCharges
     */
    @ApiModelProperty(value = "Array representing banded daily supply charge rates. Mandatory if _dailySupplyChargeType_ is `BAND`.")
    @Valid
    public List<EnergyBandedDailySupplyCharges> getBandedDailySupplyCharges() {
        return bandedDailySupplyCharges;
    }

    public void setBandedDailySupplyCharges(List<EnergyBandedDailySupplyCharges> bandedDailySupplyCharges) {
        this.bandedDailySupplyCharges = bandedDailySupplyCharges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractTariffPeriodV2 energyPlanContractTariffPeriod = (EnergyPlanContractTariffPeriodV2) o;
        return super.equals(o) &&
                Objects.equals(this.dailySupplyChargeType, energyPlanContractTariffPeriod.dailySupplyChargeType) &&
                Objects.equals(this.dailySupplyCharge, energyPlanContractTariffPeriod.dailySupplyCharge) &&
                Objects.equals(this.timeOfUseRates, energyPlanContractTariffPeriod.timeOfUseRates) &&
                Objects.equals(this.bandedDailySupplyCharges, energyPlanContractTariffPeriod.bandedDailySupplyCharges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dailySupplyChargeType, dailySupplyCharge, timeOfUseRates, bandedDailySupplyCharges, super.hashCode());
    }

    @Override
    protected void stringProperties(StringBuilder sb) {
        super.stringProperties(sb);
        sb.append("    dailySupplyChargeType: ").append(toIndentedString(dailySupplyChargeType)).append("\n");
        sb.append("    dailySupplyCharge: ").append(toIndentedString(dailySupplyCharge)).append("\n");
        sb.append("    timeOfUseRates: ").append(toIndentedString(timeOfUseRates)).append("\n");
        sb.append("    bandedDailySupplyCharges: ").append(toIndentedString(bandedDailySupplyCharges)).append("\n");
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
