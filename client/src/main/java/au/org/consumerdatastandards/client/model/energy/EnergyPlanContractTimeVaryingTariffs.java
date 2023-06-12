package au.org.consumerdatastandards.client.model.energy;

import java.util.List;

public interface EnergyPlanContractTimeVaryingTariffs {

    /**
     * The type of the charging time period. If absent applies to all periods
     */
    public enum TypeEnum {
        PEAK,
        OFF_PEAK,
        SHOULDER
    }

    /**
     * The type of the charging time period. If absent applies to all periods
     *
     * @return type
     */
    TypeEnum getType();

    void setType(TypeEnum type);

    /**
     * Array of time periods for which this tariff is applicable
     *
     * @return timeVariations
     */
    List<EnergyPlanContractTimeVaryingTariffsTimeVariations> getTimeVariations();

    void setTimeVariations(List<EnergyPlanContractTimeVaryingTariffsTimeVariations> timeVariations);
}
