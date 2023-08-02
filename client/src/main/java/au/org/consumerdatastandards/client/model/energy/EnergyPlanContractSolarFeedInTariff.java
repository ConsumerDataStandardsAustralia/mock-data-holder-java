package au.org.consumerdatastandards.client.model.energy;

public interface EnergyPlanContractSolarFeedInTariff {
    /**
     * The name of the tariff
     *
     * @return displayName
     */
    String getDisplayName();

    void setDisplayName(String displayName);

    /**
     * A description of the tariff
     *
     * @return description
     */
    String getDescription();

    void setDescription(String description);

    /**
     * The applicable scheme
     *
     * @return scheme
     */
    SchemeEnum getScheme();

    void setScheme(SchemeEnum scheme);

    /**
     * The type of the payer
     *
     * @return payerType
     */
    PayerTypeEnum getPayerType();

    void setPayerType(PayerTypeEnum payerType);

    /**
     * The type of the payer
     *
     * @return tariffUType
     */
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
        SINGLETARIFF("singleTariff"),

        TIMEVARYINGTARIFFS("timeVaryingTariffs");

        private final String value;

        TariffUTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

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
