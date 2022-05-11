package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyServicePointDetailMeters
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyServicePointDetailMeters {
    @JsonProperty("meterId")
    private String meterId;

    @JsonProperty("specifications")
    private EnergyServicePointDetailMetersSpecifications specifications;

    @JsonProperty("registers")
    private EnergyServicePointDetailMetersRegisters registers;

    public EnergyServicePointDetailMeters meterId(String meterId) {
        this.meterId = meterId;
        return this;
    }

    /**
     * The meter ID uniquely identifies a meter for a given service point.  It is unique in the context of the service point.  It is not globally unique
     *
     * @return meterId
     */
    @ApiModelProperty(required = true,
            value = "The meter ID uniquely identifies a meter for a given service point.  It is unique in the context of the service point.  It is not globally unique")
    @NotNull


    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }

    public EnergyServicePointDetailMeters specifications(EnergyServicePointDetailMetersSpecifications specifications) {
        this.specifications = specifications;
        return this;
    }

    /**
     * Get specifications
     *
     * @return specifications
     */
    @ApiModelProperty(required = true,
            value = "")
    @NotNull

    @Valid

    public EnergyServicePointDetailMetersSpecifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(EnergyServicePointDetailMetersSpecifications specifications) {
        this.specifications = specifications;
    }

    public EnergyServicePointDetailMeters registers(EnergyServicePointDetailMetersRegisters registers) {
        this.registers = registers;
        return this;
    }

    /**
     * Get registers
     *
     * @return registers
     */
    @ApiModelProperty(required = true,
            value = "")
    @NotNull

    @Valid

    public EnergyServicePointDetailMetersRegisters getRegisters() {
        return registers;
    }

    public void setRegisters(EnergyServicePointDetailMetersRegisters registers) {
        this.registers = registers;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyServicePointDetailMeters energyServicePointDetailMeters = (EnergyServicePointDetailMeters) o;
        return Objects.equals(this.meterId, energyServicePointDetailMeters.meterId) &&
                Objects.equals(this.specifications, energyServicePointDetailMeters.specifications) &&
                Objects.equals(this.registers, energyServicePointDetailMeters.registers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meterId, specifications, registers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyServicePointDetailMeters {\n");

        sb.append("    meterId: ").append(toIndentedString(meterId)).append("\n");
        sb.append("    specifications: ").append(toIndentedString(specifications)).append("\n");
        sb.append("    registers: ").append(toIndentedString(registers)).append("\n");
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

