package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * EnergyPlanContractGreenPowerCharges
 */
@Entity
@Table(name="e_green_power_charge")
public class EnergyPlanContractGreenPowerCharges {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String displayName;

    private String description;

    /**
     * The applicable green power scheme
     */
    public enum SchemeEnum {
        GREENPOWER,
        OTHER
    }

    private SchemeEnum scheme;

    /**
     * The type of charge
     */
    public enum TypeEnum {
        FIXED_PER_DAY,
        FIXED_PER_WEEK,
        FIXED_PER_MONTH,
        FIXED_PER_UNIT,
        PERCENT_OF_USE,
        PERCENT_OF_BILL
    }

    private TypeEnum type;

    @Valid
    @OneToMany(cascade = CascadeType.ALL)
    private List<EnergyPlanContractTiers> tiers = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyPlanContractGreenPowerCharges displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The display name of the charge
     *
     * @return displayName
     */
    @ApiModelProperty(required = true, value = "The display name of the charge")
    @NotNull
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyPlanContractGreenPowerCharges description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the charge
     *
     * @return description
     */
    @ApiModelProperty(value = "The description of the charge")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnergyPlanContractGreenPowerCharges scheme(SchemeEnum scheme) {
        this.scheme = scheme;
        return this;
    }

    /**
     * The applicable green power scheme
     *
     * @return scheme
     */
    @ApiModelProperty(required = true, value = "The applicable green power scheme")
    @NotNull
    public SchemeEnum getScheme() {
        return scheme;
    }

    public void setScheme(SchemeEnum scheme) {
        this.scheme = scheme;
    }

    public EnergyPlanContractGreenPowerCharges type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of charge
     *
     * @return type
     */
    @ApiModelProperty(required = true, value = "The type of charge")
    @NotNull
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public EnergyPlanContractGreenPowerCharges tiers(List<EnergyPlanContractTiers> tiers) {
        this.tiers = tiers;
        return this;
    }

    public EnergyPlanContractGreenPowerCharges addTiersItem(EnergyPlanContractTiers tiersItem) {
        this.tiers.add(tiersItem);
        return this;
    }

    /**
     * Array of charge tiers based on the percentage of green power used for the period implied by the type.  Array is in order of increasing percentage of green power
     *
     * @return tiers
     */
    @ApiModelProperty(required = true,
            value = "Array of charge tiers based on the percentage of green power used for the period implied by the type.  Array is in order of increasing percentage of green power")
    @NotNull
    @Valid
    public List<EnergyPlanContractTiers> getTiers() {
        return tiers;
    }

    public void setTiers(List<EnergyPlanContractTiers> tiers) {
        this.tiers = tiers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractGreenPowerCharges energyPlanContractGreenPowerCharges = (EnergyPlanContractGreenPowerCharges) o;
        return Objects.equals(this.displayName, energyPlanContractGreenPowerCharges.displayName) &&
                Objects.equals(this.description, energyPlanContractGreenPowerCharges.description) &&
                Objects.equals(this.scheme, energyPlanContractGreenPowerCharges.scheme) &&
                Objects.equals(this.type, energyPlanContractGreenPowerCharges.type) &&
                Objects.equals(this.tiers, energyPlanContractGreenPowerCharges.tiers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, scheme, type, tiers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractGreenPowerCharges {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    scheme: ").append(toIndentedString(scheme)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    tiers: ").append(toIndentedString(tiers)).append("\n");
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
