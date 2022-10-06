package au.org.consumerdatastandards.client.model.energy;

public interface EnergyAccountBaseV2 extends EnergyAccountBase {

    enum OpenStatus {
        OPEN,
        CLOSED
    }

    /**
     * Open or closed status for the account. If not present then OPEN is assumed
     * @return openStatus
     */
    OpenStatus getOpenStatus();

    void setOpenStatus(OpenStatus openStatus);
}
