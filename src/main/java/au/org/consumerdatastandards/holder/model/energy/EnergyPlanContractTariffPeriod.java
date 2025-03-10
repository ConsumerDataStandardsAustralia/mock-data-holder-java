package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractTariffPeriod
 */
@MappedSuperclass
public class EnergyPlanContractTariffPeriod {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * Type of charge. Assumed to be other if absent.
     */
    public enum TypeEnum {
        ENVIRONMENTAL,
        REGULATED,
        NETWORK,
        METERING,
        RETAIL_SERVICE,
        RCTI,
        OTHER
    }

    /**
     * Type of charge. Assumed to be other if absent.
     */
    private TypeEnum type;

    /**
     * The name of the tariff period.
     */
    private String displayName;

    private String startDate; // mm-dd

    private String endDate; // mm-dd

    /**
     * Specifies the charge specific time zone for calculation of the time of use thresholds. If absent, timezone value in EnergyPlanContract is assumed.
     */
    public enum TimeZone {
        LOCAL,
        AEST
    }

    private TimeZone timeZone;

    /**
     * Specifies the type of rate applicable to this tariff period.
     */
    public enum RateBlockUTypeEnum {
        SINGLERATE("singleRate"),

        TIMEOFUSERATES("timeOfUseRates"),

        DEMANDCHARGES("demandCharges");

        private final String value;

        RateBlockUTypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static RateBlockUTypeEnum fromValue(String value) {
            for (RateBlockUTypeEnum b : RateBlockUTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    private RateBlockUTypeEnum rateBlockUType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_tariff_period_single_rate",
            joinColumns = @JoinColumn(name = "t_period_id"),
            inverseJoinColumns = @JoinColumn(name = "s_rate_id"))
    private EnergyPlanContractSingleRate singleRate;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_tariff_period_demand_charges",
            joinColumns = @JoinColumn(name = "t_period_id"),
            inverseJoinColumns = @JoinColumn(name = "d_charge_id"))
    private List<EnergyPlanContractDemandCharges> demandCharges = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanContractTariffPeriod type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Type of charge. Assumed to be other if absent.
     *
     * @return type
     */
    @ApiModelProperty(value = "Type of charge. Assumed to be other if absent.")
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public EnergyPlanContractTariffPeriod displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The name of the tariff period.
     *
     * @return displayName
     */
    @ApiModelProperty(required = true, value = "The name of the tariff period.")
    @NotNull
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyPlanContractTariffPeriod startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * The start date of the tariff period in a calendar year. Formatted in mm-dd format.
     *
     * @return startDate
     */
    @ApiModelProperty(required = true,
            value = "The start date of the tariff period in a calendar year. Formatted in mm-dd format.")
    @NotNull
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public EnergyPlanContractTariffPeriod endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * The end date of the tariff period in a calendar year. Formatted in mm-dd format.
     *
     * @return endDate
     */
    @ApiModelProperty(required = true,
            value = "The end date of the tariff period in a calendar year. Formatted in mm-dd format.")
    @NotNull
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * Specifies the charge specific time zone for calculation of the time of use thresholds. If absent, timezone value in EnergyPlanContract is assumed.
     *
     * @return timeZone
     */
    @ApiModelProperty(value = "Specifies the charge specific time zone for calculation of the time of use thresholds. If absent, timezone value in EnergyPlanContract is assumed.")
    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public EnergyPlanContractTariffPeriod rateBlockUType(RateBlockUTypeEnum rateBlockUType) {
        this.rateBlockUType = rateBlockUType;
        return this;
    }

    /**
     * Specifies the type of rate applicable to this tariff period.
     *
     * @return rateBlockUType
     */
    @ApiModelProperty(required = true,
            value = "Specifies the type of rate applicable to this tariff period.")
    @NotNull
    public RateBlockUTypeEnum getRateBlockUType() {
        return rateBlockUType;
    }

    public void setRateBlockUType(RateBlockUTypeEnum rateBlockUType) {
        this.rateBlockUType = rateBlockUType;
    }

    public EnergyPlanContractTariffPeriod singleRate(EnergyPlanContractSingleRate singleRate) {
        this.singleRate = singleRate;
        return this;
    }

    /**
     * Get singleRate
     *
     * @return singleRate
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyPlanContractSingleRate getSingleRate() {
        return singleRate;
    }

    public void setSingleRate(EnergyPlanContractSingleRate singleRate) {
        this.singleRate = singleRate;
    }

    public EnergyPlanContractTariffPeriod demandCharges(List<EnergyPlanContractDemandCharges> demandCharges) {
        this.demandCharges = demandCharges;
        return this;
    }

    public EnergyPlanContractTariffPeriod addDemandChargesItem(EnergyPlanContractDemandCharges demandChargesItem) {
        if (this.demandCharges == null) {
            this.demandCharges = new ArrayList<>();
        }
        this.demandCharges.add(demandChargesItem);
        return this;
    }

    /**
     * Array of demand charges. Required if _rateBlockUType_ is `demandCharges`.
     *
     * @return demandCharges
     */
    @ApiModelProperty(value = "Array of demand charges. Required if _rateBlockUType_ is `demandCharges`.")
    @Valid
    public List<EnergyPlanContractDemandCharges> getDemandCharges() {
        return demandCharges;
    }

    public void setDemandCharges(List<EnergyPlanContractDemandCharges> demandCharges) {
        this.demandCharges = demandCharges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractTariffPeriod energyPlanContractTariffPeriod = (EnergyPlanContractTariffPeriod) o;
        return Objects.equals(this.type, energyPlanContractTariffPeriod.type) &&
                Objects.equals(this.displayName, energyPlanContractTariffPeriod.displayName) &&
                Objects.equals(this.startDate, energyPlanContractTariffPeriod.startDate) &&
                Objects.equals(this.endDate, energyPlanContractTariffPeriod.endDate) &&
                Objects.equals(this.timeZone, energyPlanContractTariffPeriod.timeZone) &&
                Objects.equals(this.rateBlockUType, energyPlanContractTariffPeriod.rateBlockUType) &&
                Objects.equals(this.singleRate, energyPlanContractTariffPeriod.singleRate) &&
                Objects.equals(this.demandCharges, energyPlanContractTariffPeriod.demandCharges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, displayName, startDate, endDate, timeZone, rateBlockUType, singleRate, demandCharges);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName()).append("{\n");
        stringProperties(sb);
        return sb.append("}").toString();
    }

    protected void stringProperties(StringBuilder sb) {
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    timeZone: ").append(toIndentedString(timeZone)).append("\n");
        sb.append("    rateBlockUType: ").append(toIndentedString(rateBlockUType)).append("\n");
        sb.append("    singleRate: ").append(toIndentedString(singleRate)).append("\n");
        sb.append("    demandCharges: ").append(toIndentedString(demandCharges)).append("\n");
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
