package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public interface EnergyPlanContractSolarFeedInTariff {
    /**
     * The name of the tariff.
     *
     * @return displayName
     */
    @ApiModelProperty(required = true, value = "The name of the tariff.")
    @NotNull
    String getDisplayName();

    void setDisplayName(String displayName);

    /**
     * A description of the tariff.
     *
     * @return description
     */
    @ApiModelProperty(value = "A description of the tariff.")
    String getDescription();

    void setDescription(String description);

    /**
     * The applicable scheme.
     *
     * @return scheme
     */
    @ApiModelProperty(required = true, value = "The applicable scheme.")
    @NotNull
    SchemeEnum getScheme();

    void setScheme(SchemeEnum scheme);

    /**
     * The type of the payer.
     *
     * @return payerType
     */
    @ApiModelProperty(required = true, value = "The type of the payer.")
    @NotNull
    PayerTypeEnum getPayerType();

    void setPayerType(PayerTypeEnum payerType);

    /**
     * Reference to the applicable tariff structure.
     *
     * @return tariffUType
     */
    @ApiModelProperty(required = true, value = "Reference to the applicable tariff structure.")
    @NotNull
    TariffUTypeEnum getTariffUType();

    void setTariffUType(TariffUTypeEnum tariffUType);

    /**
     * The applicable scheme.
     */
    public enum SchemeEnum {
        PREMIUM,
        OTHER
    }

    /**
     * The type of the payer.
     */
    public enum PayerTypeEnum {
        GOVERNMENT,
        RETAILER
    }

    /**
     * Reference to the applicable tariff structure.
     */
    public enum TariffUTypeEnum {
        SINGLETARIFF("singleTariff"),

        TIMEVARYINGTARIFFS("timeVaryingTariffs");

        private final String value;

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
}
