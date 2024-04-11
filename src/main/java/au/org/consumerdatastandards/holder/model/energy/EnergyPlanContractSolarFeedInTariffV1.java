package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyPlanContractSolarFeedInTariffV1
 */
@Entity
@Table(name = "e_solar_fit")
public class EnergyPlanContractSolarFeedInTariffV1 implements EnergyPlanContractSolarFeedInTariff {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String displayName;

    private String description;

    private SchemeEnum scheme;

    private PayerTypeEnum payerType;

    private TariffUTypeEnum tariffUType;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyPlanContractSingleTariffV1 singleTariff;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyPlanContractTimeVaryingTariffsV1 timeVaryingTariffs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanContractSolarFeedInTariff displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The name of the tariff
     *
     * @return displayName
     */
    @Override
    @ApiModelProperty(required = true, value = "The name of the tariff")
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
     * A description of the tariff
     *
     * @return description
     */
    @Override
    @ApiModelProperty(value = "A description of the tariff")
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
     * The applicable scheme
     *
     * @return scheme
     */
    @Override
    @ApiModelProperty(required = true, value = "The applicable scheme")
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
     * The type of the payer
     *
     * @return payerType
     */
    @Override
    @ApiModelProperty(required = true, value = "The type of the payer")
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
     * The type of the payer
     *
     * @return tariffUType
     */
    @Override
    @ApiModelProperty(required = true, value = "The type of the payer")
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
        this.timeVaryingTariffs = timeVaryingTariffs;
        return this;
    }

    /**
     * Get timeVaryingTariffs
     *
     * @return timeVaryingTariffs
     */
    @ApiModelProperty(value = "")
    @Valid
    public EnergyPlanContractTimeVaryingTariffs getTimeVaryingTariffs() {
        return timeVaryingTariffs;
    }

    public void setTimeVaryingTariffs(EnergyPlanContractTimeVaryingTariffsV1 timeVaryingTariffs) {
        this.timeVaryingTariffs = timeVaryingTariffs;
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
