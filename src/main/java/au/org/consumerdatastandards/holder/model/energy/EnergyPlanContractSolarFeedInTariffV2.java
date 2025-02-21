package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractSolarFeedInTariffV2
 */
@Entity
@Table(name = "e_solar_fit")
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.NONE,
        getterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY,
        setterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY
)
public class EnergyPlanContractSolarFeedInTariffV2 implements EnergyPlanContractSolarFeedInTariff {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
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
    private EnergyPlanContractSingleTariffV2 singleTariff;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "e_s_fit_tv_tariffs",
            joinColumns = @JoinColumn(name = "fit_tariff_id"),
            inverseJoinColumns = @JoinColumn(name = "tv_tariff_id"))
    private List<EnergyPlanContractTimeVaryingTariffsV2> timeVaryingTariffs;

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonIgnore
    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanContractSolarFeedInTariffV2 displayName(String displayName) {
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

    public EnergyPlanContractSolarFeedInTariffV2 description(String description) {
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

    public EnergyPlanContractSolarFeedInTariffV2 scheme(SchemeEnum scheme) {
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

    public EnergyPlanContractSolarFeedInTariffV2 payerType(PayerTypeEnum payerType) {
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

    public EnergyPlanContractSolarFeedInTariffV2 tariffUType(TariffUTypeEnum tariffUType) {
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

    public EnergyPlanContractSolarFeedInTariffV2 singleTariff(EnergyPlanContractSingleTariffV2 singleTariff) {
        this.singleTariff = singleTariff;
        return this;
    }

    /**
     * Get singleTariff
     *
     * @return singleTariff
     */
    @ApiModelProperty(value = "")
    public EnergyPlanContractSingleTariffV2 getSingleTariff() {
        return singleTariff;
    }

    public void setSingleTariff(EnergyPlanContractSingleTariffV2 singleTariff) {
        this.singleTariff = singleTariff;
    }

    public EnergyPlanContractSolarFeedInTariffV2 timeVaryingTariffs(EnergyPlanContractTimeVaryingTariffsV2 timeVaryingTariffs) {
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
    public List<EnergyPlanContractTimeVaryingTariffsV2> getTimeVaryingTariffs() {
        return timeVaryingTariffs;
    }

    @JsonIgnore
    public void setTimeVaryingTariffs(List<EnergyPlanContractTimeVaryingTariffsV2> timeVaryingTariffs) {
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
    public EnergyPlanContractTimeVaryingTariffsV2 getSingleTimeVaryingTariffs() {
        return (timeVaryingTariffs == null || timeVaryingTariffs.isEmpty() ? null : timeVaryingTariffs.get(0));
    }

    @JsonProperty("timeVaryingTariffs")
    public void setSingleTimeVaryingTariffs(EnergyPlanContractTimeVaryingTariffsV2 timeVaryingTariffs) {
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
        EnergyPlanContractSolarFeedInTariffV2 energyPlanContractSolarFeedInTariff = (EnergyPlanContractSolarFeedInTariffV2) o;
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
        sb.append("class EnergyPlanContractSolarFeedInTariffV2 {\n");
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
