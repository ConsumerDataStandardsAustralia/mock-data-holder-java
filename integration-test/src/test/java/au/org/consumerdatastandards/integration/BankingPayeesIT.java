package au.org.consumerdatastandards.integration;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.BankingPayeesAPI;
import au.org.consumerdatastandards.client.model.BankingPayee;
import au.org.consumerdatastandards.client.model.ResponseBankingPayeeById;
import au.org.consumerdatastandards.client.model.ResponseBankingPayeeList;
import au.org.consumerdatastandards.integration.utils.ResponseCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static au.org.consumerdatastandards.client.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;

public class BankingPayeesIT extends ProtectedITBase {
    public BankingPayeesIT() throws IOException, ApiException {
        super(new BankingPayeesAPI());
    }

    @ParameterizedTest
    @CsvSource({
            "ALL,,"
    })
    public void listPayees(BankingPayeesAPI.ParamType type, Integer page, Integer pageSize) throws ApiException {
        ApiResponse<ResponseBankingPayeeList> resp = ((BankingPayeesAPI) getAPI()).listPayeesWithHttpInfo(type, page, pageSize);
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);

        for (BankingPayee payee : resp.getData().getData().getPayees()) {
            if (type != null && type != BankingPayeesAPI.ParamType.ALL && !payee.getType().name().equals(type.name())) {
                conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format(
                                "BankingPayee type %s does not match type query %s",
                                payee.getType(), type)));
            }
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @Test
    public void getPayeeDetail() throws ApiException {
        List<BankingPayee> payees = ((BankingPayeesAPI) getAPI()).listPayees(null, null, 50).getData().getPayees();
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        for (BankingPayee payee : payees) {
            ApiResponse<ResponseBankingPayeeById> resp = ((BankingPayeesAPI) getAPI()).getPayeeDetailWithHttpInfo(payee.getPayeeId());
            checkResponseHeaders(resp.getHeaders(), conformanceErrors);
            String bankingPayeeId = resp.getData().getData().getPayeeId();
            if (!payee.getPayeeId().equals(bankingPayeeId)) {
                conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorMessage(String.format(
                                "Response payeeId %s does not match request payeeId %s",
                                bankingPayeeId, payee.getPayeeId())));
            }
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }
}
