package au.org.consumerdatastandards.integration.api.energy;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.ProtectedAPI;
import au.org.consumerdatastandards.client.model.energy.EnergyAccountBaseV2;
import au.org.consumerdatastandards.client.model.energy.ParamAccountOpenStatus;
import au.org.consumerdatastandards.integration.ProtectedITBase;

import java.io.IOException;
import java.util.List;

import static au.org.consumerdatastandards.client.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;

public abstract class EnergyITBase extends ProtectedITBase {

    public EnergyITBase(ProtectedAPI api) throws IOException, ApiException {
        super(api);
    }

    protected void checkOpenStatus(EnergyAccountBaseV2.OpenStatus accountOpenStatus, ParamAccountOpenStatus openStatus, List<ConformanceError> errors) {
        if (openStatus != null && openStatus != ParamAccountOpenStatus.ALL &&
                (accountOpenStatus == null || !accountOpenStatus.name().equals(openStatus.name()))) {
            errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "EnergyAccount openStatus %s does not match openStatus query %s",
                            (accountOpenStatus == null ? null : accountOpenStatus.name()), openStatus)));
        }
    }
}
