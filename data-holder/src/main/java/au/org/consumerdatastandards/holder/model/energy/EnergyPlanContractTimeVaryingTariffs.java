package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
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
    @ApiModelProperty(value = "The type of the charging time period. If absent applies to all periods")
    TypeEnum getType();

    void setType(TypeEnum type);

    /**
     * Array of time periods for which this tariff is applicable
     *
     * @return timeVariations
     */
    @ApiModelProperty(required = true, value = "Array of time periods for which this tariff is applicable")
    @NotNull
    List<EnergyPlanContractTimeVaryingTariffsTimeVariations> getTimeVariations();

    void setTimeVariations(List<EnergyPlanContractTimeVaryingTariffsTimeVariations> timeVariations);
}
