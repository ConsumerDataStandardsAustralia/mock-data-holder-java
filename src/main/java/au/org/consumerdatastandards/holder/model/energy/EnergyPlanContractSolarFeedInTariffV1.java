package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractSolarFeedInTariffV1
 */
@Entity
@Table(name = "e_solar_fit")
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY,
        setterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY
)
public class EnergyPlanContractSolarFeedInTariffV1 implements EnergyPlanContractSolarFeedInTariff {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String displayName;

    private String description;

    private SchemeEnum scheme;

    private PayerTypeEnum payerType;

    private TariffUTypeEnum tariffUType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_s_fit_s_tariff",
            joinColumns = @JoinColumn(name = "fit_tariff_id"),
            inverseJoinColumns = @JoinColumn(name = "s_tariff_id"))
    private EnergyPlanContractSingleTariffV1 singleTariff;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_s_fit_tv_tariffs",
            joinColumns = @JoinColumn(name = "fit_tariff_id"),
            inverseJoinColumns = @JoinColumn(name = "tv_tariff_id"))
    private List<EnergyPlanContractTimeVaryingTariffsV1> timeVaryingTariffs;

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonIgnore
    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanContractSolarFeedInTariff displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The name of the tariff.
     *
     * @return displayName
     */
    @Override
    @ApiModelProperty(required = true, value = "The name of the tariff.")
    @NotNull
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyPlanContractSolarFeedInTariff description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the tariff.
     *
     * @return description
     */
    @Override
    @ApiModelProperty(value = "A description of the tariff.")
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public EnergyPlanContractSolarFeedInTariff scheme(SchemeEnum scheme) {
        this.scheme = scheme;
        return this;
    }

    /**
     * The applicable scheme.
     *
     * @return scheme
     */
    @Override
    @ApiModelProperty(required = true, value = "The applicable scheme.")
    @NotNull
    public SchemeEnum getScheme() {
        return scheme;
    }

    @Override
    public void setScheme(SchemeEnum scheme) {
        this.scheme = scheme;
    }

    public EnergyPlanContractSolarFeedInTariff payerType(PayerTypeEnum payerType) {
        this.payerType = payerType;
        return this;
    }

    /**
     * The type of the payer.
     *
     * @return payerType
     */
    @Override
    @ApiModelProperty(required = true, value = "The type of the payer.")
    @NotNull
    public PayerTypeEnum getPayerType() {
        return payerType;
    }

    @Override
    public void setPayerType(PayerTypeEnum payerType) {
        this.payerType = payerType;
    }

    public EnergyPlanContractSolarFeedInTariff tariffUType(TariffUTypeEnum tariffUType) {
        this.tariffUType = tariffUType;
        return this;
    }

    /**
     * Reference to the applicable tariff structure.
     *
     * @return tariffUType
     */
    @Override
    @ApiModelProperty(required = true, value = "Reference to the applicable tariff structure.")
    @NotNull
    public TariffUTypeEnum getTariffUType() {
        return tariffUType;
    }

    @Override
    public void setTariffUType(TariffUTypeEnum tariffUType) {
        this.tariffUType = tariffUType;
    }

    public EnergyPlanContractSolarFeedInTariff singleTariff(EnergyPlanContractSingleTariffV1 singleTariff) {
        this.singleTariff = singleTariff;
        return this;
    }

    /**
     * Get singleTariff
     *
     * @return singleTariff
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyPlanContractSingleTariffV1 getSingleTariff() {
        return singleTariff;
    }

    public void setSingleTariff(EnergyPlanContractSingleTariffV1 singleTariff) {
        this.singleTariff = singleTariff;
    }

    public EnergyPlanContractSolarFeedInTariff timeVaryingTariffs(EnergyPlanContractTimeVaryingTariffsV1 timeVaryingTariffs) {
        setSingleTimeVaryingTariffs(timeVaryingTariffs);
        return this;
    }

    /**
     * Get timeVaryingTariffs
     *
     * @return timeVaryingTariffs
     */
    @ApiModelProperty(value = "")
    @JsonIgnore
    @Valid
    public List<EnergyPlanContractTimeVaryingTariffsV1> getTimeVaryingTariffs() {
        return timeVaryingTariffs;
    }

    @JsonIgnore
    public void setTimeVaryingTariffs(List<EnergyPlanContractTimeVaryingTariffsV1> timeVaryingTariffs) {
        this.timeVaryingTariffs = timeVaryingTariffs;
    }

    /**
     * Get timeVaryingTariffs
     *
     * @return timeVaryingTariffs
     */
    @ApiModelProperty(value = "")
    @JsonProperty("timeVaryingTariffs")
    @Valid
    public EnergyPlanContractTimeVaryingTariffsV1 getSingleTimeVaryingTariffs() {
        return (timeVaryingTariffs == null || timeVaryingTariffs.isEmpty() ? null : timeVaryingTariffs.get(0));
    }

    @JsonProperty("timeVaryingTariffs")
    public void setSingleTimeVaryingTariffs(EnergyPlanContractTimeVaryingTariffsV1 timeVaryingTariffs) {
        this.timeVaryingTariffs = Collections.singletonList(timeVaryingTariffs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractSolarFeedInTariffV1 energyPlanContractSolarFeedInTariff = (EnergyPlanContractSolarFeedInTariffV1) o;
        return Objects.equals(this.displayName, energyPlanContractSolarFeedInTariff.displayName) &&
                Objects.equals(this.description, energyPlanContractSolarFeedInTariff.description) &&
                Objects.equals(this.scheme, energyPlanContractSolarFeedInTariff.scheme) &&
                Objects.equals(this.payerType, energyPlanContractSolarFeedInTariff.payerType) &&
                Objects.equals(this.tariffUType, energyPlanContractSolarFeedInTariff.tariffUType) &&
                Objects.equals(this.singleTariff, energyPlanContractSolarFeedInTariff.singleTariff) &&
                Objects.equals(this.timeVaryingTariffs, energyPlanContractSolarFeedInTariff.timeVaryingTariffs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, scheme, payerType, tariffUType, singleTariff, timeVaryingTariffs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractSolarFeedInTariffV1 {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    scheme: ").append(toIndentedString(scheme)).append("\n");
        sb.append("    payerType: ").append(toIndentedString(payerType)).append("\n");
        sb.append("    tariffUType: ").append(toIndentedString(tariffUType)).append("\n");
        sb.append("    singleTariff: ").append(toIndentedString(singleTariff)).append("\n");
        sb.append("    timeVaryingTariffs: ").append(toIndentedString(timeVaryingTariffs)).append("\n");
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
