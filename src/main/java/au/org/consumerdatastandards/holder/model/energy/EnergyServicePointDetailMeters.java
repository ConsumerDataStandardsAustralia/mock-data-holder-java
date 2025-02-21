package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

/**
 * EnergyServicePointDetailMeters
 */
@Entity
public class EnergyServicePointDetailMeters {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String meterId;

    @OneToOne(cascade = CascadeType.ALL)
    private EnergyServicePointDetailSpecifications specifications;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EnergyServicePointDetailRegisters> registers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyServicePointDetailMeters meterId(String meterId) {
        this.meterId = meterId;
        return this;
    }

    /**
     * The meter ID uniquely identifies a meter for a given service point. It is unique in the context of the service point. It is not globally unique.
     *
     * @return meterId
     */
    @ApiModelProperty(required = true,
            value = "The meter ID uniquely identifies a meter for a given service point. It is unique in the context of the service point. It is not globally unique.")
    @NotNull
    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }

    public EnergyServicePointDetailMeters specifications(EnergyServicePointDetailSpecifications specifications) {
        this.specifications = specifications;
        return this;
    }

    /**
     * Get specifications
     *
     * @return specifications
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull
    @Valid
    public EnergyServicePointDetailSpecifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(EnergyServicePointDetailSpecifications specifications) {
        this.specifications = specifications;
    }

    /**
     * Usage data registers available from the meter. This may be empty where there are no meters physically installed at the service point.
     *
     * @return registers
     */
    @ApiModelProperty(value = "Usage data registers available from the meter. This may be empty where there are no meters physically installed at the service point.")
    @Valid
    public List<EnergyServicePointDetailRegisters> getRegisters() {
        return registers;
    }

    public void setRegisters(List<EnergyServicePointDetailRegisters> registers) {
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
