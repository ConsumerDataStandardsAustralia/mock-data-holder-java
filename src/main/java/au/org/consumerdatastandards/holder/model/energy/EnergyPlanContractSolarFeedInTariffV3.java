package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

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
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractSolarFeedInTariffV3
 */
@Entity
@Table(name = "e_solar_fit")
public class EnergyPlanContractSolarFeedInTariffV3 implements EnergyPlanContractSolarFeedInTariff {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String displayName;

    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate endDate;

    private SchemeEnum scheme;

    private PayerTypeEnum payerType;

    private TariffUTypeEnum tariffUType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_s_fit_s_tariff",
            joinColumns = @JoinColumn(name = "fit_tariff_id"),
            inverseJoinColumns = @JoinColumn(name = "s_tariff_id"))
    private EnergyPlanContractSingleTariffV3 singleTariff;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_s_fit_tv_tariffs",
            joinColumns = @JoinColumn(name = "fit_tariff_id"),
            inverseJoinColumns = @JoinColumn(name = "tv_tariff_id"))
    private List<EnergyPlanContractTimeVaryingTariffsV3> timeVaryingTariffs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanContractSolarFeedInTariffV3 displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The name of the tariff.
     *
     * @return displayName
     */
    @ApiModelProperty(required = true, value = "The name of the tariff.")
    @NotNull
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyPlanContractSolarFeedInTariffV3 description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the tariff.
     *
     * @return description
     */
    @ApiModelProperty(value = "A description of the tariff.")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * The start date of the application of the feed in tariff.
     *
     * @return startDate
     */
    @ApiModelProperty("The start date of the application of the feed in tariff.")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * The end date of the application of the feed in tariff.
     *
     * @return endDate
     */
    @ApiModelProperty("The end date of the application of the feed in tariff.")
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public EnergyPlanContractSolarFeedInTariffV3 scheme(SchemeEnum scheme) {
        this.scheme = scheme;
        return this;
    }

    /**
     * The applicable scheme.
     *
     * @return scheme
     */
    @ApiModelProperty(required = true, value = "The applicable scheme.")
    @NotNull
    public SchemeEnum getScheme() {
        return scheme;
    }

    public void setScheme(SchemeEnum scheme) {
        this.scheme = scheme;
    }

    public EnergyPlanContractSolarFeedInTariffV3 payerType(PayerTypeEnum payerType) {
        this.payerType = payerType;
        return this;
    }

    /**
     * The type of the payer.
     *
     * @return payerType
     */
    @ApiModelProperty(required = true, value = "The type of the payer.")
    @NotNull
    public PayerTypeEnum getPayerType() {
        return payerType;
    }

    public void setPayerType(PayerTypeEnum payerType) {
        this.payerType = payerType;
    }

    public EnergyPlanContractSolarFeedInTariffV3 tariffUType(TariffUTypeEnum tariffUType) {
        this.tariffUType = tariffUType;
        return this;
    }

    /**
     * Reference to the applicable tariff structure.
     *
     * @return tariffUType
     */
    @ApiModelProperty(required = true, value = "Reference to the applicable tariff structure.")
    @NotNull
    public TariffUTypeEnum getTariffUType() {
        return tariffUType;
    }

    public void setTariffUType(TariffUTypeEnum tariffUType) {
        this.tariffUType = tariffUType;
    }

    public EnergyPlanContractSolarFeedInTariffV3 singleTariff(EnergyPlanContractSingleTariffV3 singleTariff) {
        this.singleTariff = singleTariff;
        return this;
    }

    /**
     * Get singleTariff
     *
     * @return singleTariff
     */
    @ApiModelProperty(value = "")
    public EnergyPlanContractSingleTariffV3 getSingleTariff() {
        return singleTariff;
    }

    public void setSingleTariff(EnergyPlanContractSingleTariffV3 singleTariff) {
        this.singleTariff = singleTariff;
    }

    public EnergyPlanContractSolarFeedInTariffV3 timeVaryingTariffs(List<EnergyPlanContractTimeVaryingTariffsV3> timeVaryingTariffs) {
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
    public List<EnergyPlanContractTimeVaryingTariffsV3> getTimeVaryingTariffs() {
        return timeVaryingTariffs;
    }

    public void setTimeVaryingTariffs(List<EnergyPlanContractTimeVaryingTariffsV3> timeVaryingTariffs) {
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
        EnergyPlanContractSolarFeedInTariffV3 energyPlanContractSolarFeedInTariff = (EnergyPlanContractSolarFeedInTariffV3) o;
        return Objects.equals(this.displayName, energyPlanContractSolarFeedInTariff.displayName) &&
                Objects.equals(this.description, energyPlanContractSolarFeedInTariff.description) &&
                Objects.equals(this.startDate, energyPlanContractSolarFeedInTariff.startDate) &&
                Objects.equals(this.endDate, energyPlanContractSolarFeedInTariff.endDate) &&
                Objects.equals(this.scheme, energyPlanContractSolarFeedInTariff.scheme) &&
                Objects.equals(this.payerType, energyPlanContractSolarFeedInTariff.payerType) &&
                Objects.equals(this.tariffUType, energyPlanContractSolarFeedInTariff.tariffUType) &&
                Objects.equals(this.singleTariff, energyPlanContractSolarFeedInTariff.singleTariff) &&
                Objects.equals(this.timeVaryingTariffs, energyPlanContractSolarFeedInTariff.timeVaryingTariffs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, startDate, endDate, scheme, payerType, tariffUType, singleTariff, timeVaryingTariffs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractSolarFeedInTariffV3 {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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
