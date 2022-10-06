package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModelProperty;

public interface EnergyAccountBaseV2 extends EnergyAccountBase {

    enum OpenStatus {
        CLOSED,
        OPEN
    }

    /**
     * Used to filter results according to open/closed status. Values can be OPEN, CLOSED or ALL. If absent then ALL is assumed
     *
     * @return openStatus
     */
    @ApiModelProperty(required = false,
            value = "Used to filter results according to open/closed status. Values can be OPEN, CLOSED or ALL. If absent then ALL is assumed")
    OpenStatus getOpenStatus();

    void setOpenStatus(OpenStatus openStatus);
}
