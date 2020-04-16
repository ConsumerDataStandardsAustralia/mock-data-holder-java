package au.org.consumerdatastandards.integration;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.Header;
import au.org.consumerdatastandards.client.api.ProtectedAPI;
import au.org.consumerdatastandards.client.model.BankingAccount;
import au.org.consumerdatastandards.client.model.BankingProductCategory;
import au.org.consumerdatastandards.client.model.ParamAccountOpenStatus;
import au.org.consumerdatastandards.client.model.RequestAccountIds;
import au.org.consumerdatastandards.client.model.RequestAccountIdsData;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Arrays;
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

    protected void checkProductCategory(BankingProductCategory respProductCategory, BankingProductCategory productCategory, List<ConformanceError> errors) {
        if (productCategory != null && (respProductCategory == null || respProductCategory != productCategory)) {
            errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "BankingAccount productCategory %s does not match productCategory query %s",
                            respProductCategory, productCategory)));
        }
    }

    protected void checkOwned(Boolean accountOwned, Boolean isOwned, List<ConformanceError> errors) {
        if (isOwned != null && !isOwned.equals(accountOwned)) {
            errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "BankingAccount isOwned %b does not match isOwned query %b",
                            accountOwned, isOwned)));
        }
    }

    protected void checkOpenStatus(BankingAccount.OpenStatus accountOpenStatus, ParamAccountOpenStatus openStatus, List<ConformanceError> errors) {
        if (openStatus != null && openStatus != ParamAccountOpenStatus.ALL &&
                (accountOpenStatus == null || !accountOpenStatus.name().equals(openStatus.name()))) {
            errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "BankingAccount openStatus %s does not match openStatus query %s",
                            (accountOpenStatus == null ? null : accountOpenStatus.name()), openStatus)));
        }
    }

    protected RequestAccountIds getRequestAccountIds(String accountIds) {
        RequestAccountIds accIds = new RequestAccountIds();
        RequestAccountIdsData data = new RequestAccountIdsData();
        List<String> idList = Arrays.asList(accountIds.split(" "));
        data.setAccountIds(idList);
        accIds.setData(data);
        return accIds;
    }

    protected void checkAccountInList(String accountId, List<String> idList, List<ConformanceError> conformanceErrors) {
        if (!idList.contains(accountId)) {
            conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                    .errorMessage(String.format(
                            "Unexpected accountId %s in response", accountId)));
        }
    }
}
