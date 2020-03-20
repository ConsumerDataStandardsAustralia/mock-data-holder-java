package au.org.consumerdatastandards.integration.accounts;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.BankingAccountsAPI;
import au.org.consumerdatastandards.client.model.BankingAccount;
import au.org.consumerdatastandards.client.model.BankingProductCategory;
import au.org.consumerdatastandards.client.model.ParamAccountOpenStatus;
import au.org.consumerdatastandards.client.model.ResponseBankingAccountList;
import au.org.consumerdatastandards.integration.ITBase;
import au.org.consumerdatastandards.integration.utils.ResponseCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static au.org.consumerdatastandards.client.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;

public class ListAccountsIT extends ITBase {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final BankingAccountsAPI api = new BankingAccountsAPI();

    @ParameterizedTest
    @CsvSource({
            // productCategory, openStatus, isOwned, page, pageSize
            "BUSINESS_LOANS,ALL,,,"
    })
    public void listAccounts(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned, Integer page, Integer pageSize) throws ApiException {
        api.setApiClient(clientFactory.create(false, false));

        ApiResponse<ResponseBankingAccountList> resp = api.listAccountsWithHttpInfo(productCategory, openStatus, isOwned, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        for (BankingAccount account : resp.getData().getData().getAccounts()) {
            checkProductCategory(account.getProductCategory(), productCategory, conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                "Conformance errors found in response payload: " + buildConformanceErrorsDescription(conformanceErrors));
    }

    private void checkProductCategory(BankingProductCategory respProductCategory, BankingProductCategory productCategory, List<ConformanceError> errors) {
        if (productCategory != null) {
            if (respProductCategory == null || respProductCategory != productCategory) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format(
                                "BankingAccount productCategory %s does not match productCategory query %s",
                                respProductCategory, productCategory)));
            }
        }
    }
}
