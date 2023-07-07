package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyServicePointDetailRelatedParticipants
 */
public class EnergyServicePointDetailRelatedParticipants {
    private String party;

    /**
     * The role performed by this participant in relation to the service point. Note the details of enumeration values below: <ul><li>**FRMP** - Financially Responsible Market Participant</li><li>**LNSP** - Local Network Service Provider or Embedded Network Manager for child connection points</li><li>**DRSP** - wholesale Demand Response and/or market ancillary Service Provider and note that where it is not relevant for a NMI it will not be included</li></ul>
     */
    public enum RoleEnum {
        FRMP,
        LNSP,
        DRSP
    }

    private RoleEnum role;

    public EnergyServicePointDetailRelatedParticipants party(String party) {
        this.party = party;
        return this;
    }

    /**
     * The name of the party/organisation related to this service point
     *
     * @return party
     */
    @ApiModelProperty(required = true,
            value = "The name of the party/organisation related to this service point")
    @NotNull
    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public EnergyServicePointDetailRelatedParticipants role(RoleEnum role) {
        this.role = role;
        return this;
    }

    /**
     * The role performed by this participant in relation to the service point. Note the details of enumeration values below: <ul><li>**FRMP** - Financially Responsible Market Participant</li><li>**LNSP** - Local Network Service Provider or Embedded Network Manager for child connection points</li><li>**DRSP** - wholesale Demand Response and/or market ancillary Service Provider and note that where it is not relevant for a NMI it will not be included</li></ul>
     *
     * @return role
     */
    @ApiModelProperty(required = true,
            value = "The role performed by this participant in relation to the service point. Note the details of enumeration values below: <ul><li>**FRMP** - Financially Responsible Market Participant</li><li>**LNSP** - Local Network Service Provider or Embedded Network Manager for child connection points</li><li>**DRSP** - wholesale Demand Response and/or market ancillary Service Provider and note that where it is not relevant for a NMI it will not be included</li></ul>")
    @NotNull
    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyServicePointDetailRelatedParticipants energyServicePointDetailRelatedParticipants = (EnergyServicePointDetailRelatedParticipants) o;
        return Objects.equals(this.party, energyServicePointDetailRelatedParticipants.party) &&
                Objects.equals(this.role, energyServicePointDetailRelatedParticipants.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(party, role);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyServicePointDetailRelatedParticipants {\n");
        sb.append("    party: ").append(toIndentedString(party)).append("\n");
        sb.append("    role: ").append(toIndentedString(role)).append("\n");
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
