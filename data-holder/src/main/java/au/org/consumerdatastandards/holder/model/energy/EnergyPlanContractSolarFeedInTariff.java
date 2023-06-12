package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public interface EnergyPlanContractSolarFeedInTariff {
    /**
     * The name of the tariff
     *
     * @return displayName
     */
    @ApiModelProperty(required = true, value = "The name of the tariff")
    @NotNull
    String getDisplayName();

    void setDisplayName(String displayName);

    /**
     * A description of the tariff
     *
     * @return description
     */
    @ApiModelProperty(value = "A description of the tariff")
    String getDescription();

    void setDescription(String description);

    /**
     * The applicable scheme
     *
     * @return scheme
     */
    @ApiModelProperty(required = true, value = "The applicable scheme")
    @NotNull
    SchemeEnum getScheme();

    void setScheme(SchemeEnum scheme);

    /**
     * The type of the payer
     *
     * @return payerType
     */
    @ApiModelProperty(required = true, value = "The type of the payer")
    @NotNull
    PayerTypeEnum getPayerType();

    void setPayerType(PayerTypeEnum payerType);

    /**
     * The type of the payer
     *
     * @return tariffUType
     */
    @ApiModelProperty(required = true, value = "The type of the payer")
    @NotNull
    TariffUTypeEnum getTariffUType();

    void setTariffUType(TariffUTypeEnum tariffUType);

    /**
     * The applicable scheme
     */
    public enum SchemeEnum {
        PREMIUM,
        OTHER
    }

    /**
     * The type of the payer
     */
    public enum PayerTypeEnum {
        GOVERNMENT,
        RETAILER
    }

    /**
     * The type of the payer
     */
    public enum TariffUTypeEnum {
        SINGLETARIFF,
        TIMEVARYINGTARIFFS
    }
}
