package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyPlanContractSolarFeedInTariff
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyPlanContractSolarFeedInTariff {
    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("description")
    private String description;

    /**
     * The applicable scheme
     */
    public enum SchemeEnum {
        PREMIUM("PREMIUM"),

        OTHER("OTHER");

        private String value;

        SchemeEnum(String value) {
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
        public static SchemeEnum fromValue(String value) {
            for (SchemeEnum b : SchemeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("scheme")
    private SchemeEnum scheme;

    /**
     * The type of the payer
     */
    public enum PayerTypeEnum {
        GOVERNMENT("GOVERNMENT"),

        RETAILER("RETAILER");

        private String value;

        PayerTypeEnum(String value) {
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
        public static PayerTypeEnum fromValue(String value) {
            for (PayerTypeEnum b : PayerTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("payerType")
    private PayerTypeEnum payerType;

    /**
     * The type of the payer
     */
    public enum TariffUTypeEnum {
        SINGLETARIFF("singleTariff"),

        TIMEVARYINGTARIFFS("timeVaryingTariffs");

        private String value;

        TariffUTypeEnum(String value) {
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
        public static TariffUTypeEnum fromValue(String value) {
            for (TariffUTypeEnum b : TariffUTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("tariffUType")
    private TariffUTypeEnum tariffUType;

    @JsonProperty("singleTariff")
    private EnergyPlanContractSingleTariff singleTariff;

    @JsonProperty("timeVaryingTariffs")
    private EnergyPlanContractTimeVaryingTariffs timeVaryingTariffs;

    public EnergyPlanContractSolarFeedInTariff displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The name of the tariff
     *
     * @return displayName
     */
    @ApiModelProperty(required = true,
            value = "The name of the tariff")
    @NotNull


    public String getDisplayName() {
        return displayName;
    }

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
    @ApiModelProperty(value = "A description of the tariff")


    public String getDescription() {
        return description;
    }

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
    @ApiModelProperty(required = true,
            value = "The applicable scheme")
    @NotNull


    public SchemeEnum getScheme() {
        return scheme;
    }

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
    @ApiModelProperty(required = true,
            value = "The type of the payer")
    @NotNull


    public PayerTypeEnum getPayerType() {
        return payerType;
    }

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
    @ApiModelProperty(required = true,
            value = "The type of the payer")
    @NotNull


    public TariffUTypeEnum getTariffUType() {
        return tariffUType;
    }

    public void setTariffUType(TariffUTypeEnum tariffUType) {
        this.tariffUType = tariffUType;
    }

    public EnergyPlanContractSolarFeedInTariff singleTariff(EnergyPlanContractSingleTariff singleTariff) {
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

    public EnergyPlanContractSingleTariff getSingleTariff() {
        return singleTariff;
    }

    public void setSingleTariff(EnergyPlanContractSingleTariff singleTariff) {
        this.singleTariff = singleTariff;
    }

    public EnergyPlanContractSolarFeedInTariff timeVaryingTariffs(EnergyPlanContractTimeVaryingTariffs timeVaryingTariffs) {
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

    public void setTimeVaryingTariffs(EnergyPlanContractTimeVaryingTariffs timeVaryingTariffs) {
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
        EnergyPlanContractSolarFeedInTariff energyPlanContractSolarFeedInTariff = (EnergyPlanContractSolarFeedInTariff) o;
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
        sb.append("class EnergyPlanContractSolarFeedInTariff {\n");

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

