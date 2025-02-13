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
 * EnergyPlanContractTariffPeriodV1
 */
@Entity
@Table(name="e_tariff_period")
public class EnergyPlanContractTariffPeriodV1 extends EnergyPlanContractTariffPeriod {

    @Column(name = "dailySupplyCharge")
    private String dailySupplyCharges;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_tariff_period_tou_rates",
            joinColumns = @JoinColumn(name = "t_period_id"),
            inverseJoinColumns = @JoinColumn(name = "tou_rates_id"))
    private List<EnergyPlanContractTimeOfUseRatesV1> timeOfUseRates;

    /**
     * The amount of access charge for the tariff period, in dollars per day exclusive of GST.
     *
     * @return dailySupplyCharges
     */
    @ApiModelProperty(value = "The amount of access charge for the tariff period, in dollars per day exclusive of GST.")
    public String getDailySupplyCharges() {
        return dailySupplyCharges;
    }

    public void setDailySupplyCharges(String dailySupplyCharges) {
        this.dailySupplyCharges = dailySupplyCharges;
    }

    public EnergyPlanContractTariffPeriodV1 timeOfUseRates(List<EnergyPlanContractTimeOfUseRatesV1> timeOfUseRates) {
        this.timeOfUseRates = timeOfUseRates;
        return this;
    }

    public EnergyPlanContractTariffPeriodV1 addTimeOfUseRatesItem(EnergyPlanContractTimeOfUseRatesV1 timeOfUseRatesItem) {
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
    public List<EnergyPlanContractTimeOfUseRatesV1> getTimeOfUseRates() {
        return timeOfUseRates;
    }

    public void setTimeOfUseRates(List<EnergyPlanContractTimeOfUseRatesV1> timeOfUseRates) {
        this.timeOfUseRates = timeOfUseRates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractTariffPeriodV1 energyPlanContractTariffPeriod = (EnergyPlanContractTariffPeriodV1) o;
        return super.equals(o) &&
                Objects.equals(this.dailySupplyCharges, energyPlanContractTariffPeriod.dailySupplyCharges) &&
                Objects.equals(this.timeOfUseRates, energyPlanContractTariffPeriod.timeOfUseRates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dailySupplyCharges, timeOfUseRates, super.hashCode());
    }

    @Override
    protected void stringProperties(StringBuilder sb) {
        super.stringProperties(sb);
        sb.append("    dailySupplyCharges: ").append(toIndentedString(dailySupplyCharges)).append("\n");
        sb.append("    timeOfUseRates: ").append(toIndentedString(timeOfUseRates)).append("\n");
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
