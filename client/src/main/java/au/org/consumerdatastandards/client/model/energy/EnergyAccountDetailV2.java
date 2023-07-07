package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyAccountDetailV2
 */
public class EnergyAccountDetailV2 extends EnergyAccountDetailV1 {

    private OpenStatus openStatus;

    public OpenStatus getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(OpenStatus openStatus) {
        this.openStatus = openStatus;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) &&
                Objects.equals(this.openStatus, ((EnergyAccountDetailV2)o).openStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(openStatus, super.hashCode());
    }

    @Override
    protected void writeProperties(StringBuilder sb) {
        super.writeProperties(sb);
        sb.append("    openStatus: ").append(toIndentedString(openStatus)).append("\n");
    }
}
