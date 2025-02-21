package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyServicePointDetailDistributionLossFactor
 */
@Entity
public class EnergyServicePointDetailDistributionLossFactor {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String code;

    private String description;

    private String lossValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyServicePointDetailDistributionLossFactor code(String code) {
        this.code = code;
        return this;
    }

    /**
     * A code used to identify data loss factor for the service point values. Refer to AEMO distribution loss factor documents for each financial year to interpret.
     *
     * @return code
     */
    @ApiModelProperty(required = true,
            value = "A code used to identify data loss factor for the service point values. Refer to AEMO distribution loss factor documents for each financial year to interpret.")
    @NotNull
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public EnergyServicePointDetailDistributionLossFactor description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description of the data loss factor code and value.
     *
     * @return description
     */
    @ApiModelProperty(required = true, value = "Description of the data loss factor code and value.")
    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnergyServicePointDetailDistributionLossFactor lossValue(String lossValue) {
        this.lossValue = lossValue;
        return this;
    }

    /**
     * The value associated with the loss factor code.
     *
     * @return lossValue
     */
    @ApiModelProperty(required = true, value = "The value associated with the loss factor code.")
    @NotNull
    public String getLossValue() {
        return lossValue;
    }

    public void setLossValue(String lossValue) {
        this.lossValue = lossValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyServicePointDetailDistributionLossFactor energyServicePointDetailDistributionLossFactor = (EnergyServicePointDetailDistributionLossFactor) o;
        return Objects.equals(this.code, energyServicePointDetailDistributionLossFactor.code) &&
                Objects.equals(this.description, energyServicePointDetailDistributionLossFactor.description) &&
                Objects.equals(this.lossValue, energyServicePointDetailDistributionLossFactor.lossValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description, lossValue);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyServicePointDetailDistributionLossFactor {\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    lossValue: ").append(toIndentedString(lossValue)).append("\n");
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
