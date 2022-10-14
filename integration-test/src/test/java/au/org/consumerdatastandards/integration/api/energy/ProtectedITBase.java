package au.org.consumerdatastandards.integration.api.energy;

import au.org.consumerdatastandards.client.model.energy.EnergyAccountBaseV2;
import au.org.consumerdatastandards.client.model.energy.ParamAccountOpenStatus;
import au.org.consumerdatastandards.integration.ITBase;
import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.Header;
import au.org.consumerdatastandards.client.api.ProtectedAPI;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static au.org.consumerdatastandards.client.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;
import static au.org.consumerdatastandards.client.ConformanceError.Type.MISSING_HEADER;

public abstract class ProtectedITBase extends ITBase {

    private final ProtectedAPI api;

    public ProtectedITBase(ProtectedAPI api) throws IOException, ApiException {
        super();
        api.setApiClient(clientFactory.create(true, false));
        this.api = api;
    }

    protected ProtectedAPI getAPI() {
        return api;
    }

    protected void checkResponseHeaders(Map<String, List<String>> headers, List<ConformanceError> conformanceErrors) {
        super.checkResponseHeaders(headers, conformanceErrors);
        String fapiInteractionId = retrieveHeader(headers.get(Header.FAPI_INTERACTION_ID.getKey()));
        if (StringUtils.isBlank(fapiInteractionId)) {
            conformanceErrors.add(new ConformanceError().errorType(MISSING_HEADER)
                    .errorMessage("missing '" + Header.FAPI_INTERACTION_ID.getKey() + "' in response header"));
        } else {
            checkHeaderValue(fapiInteractionId, Header.FAPI_INTERACTION_ID, conformanceErrors);
        }
    }

    protected void checkAccountId(String accountId, String reqAccountId, List<ConformanceError> conformanceErrors) {
        if (!accountId.equals(reqAccountId)) {
            conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "Response accountId %s does not match request accountId %s", accountId, reqAccountId)));
        }
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
