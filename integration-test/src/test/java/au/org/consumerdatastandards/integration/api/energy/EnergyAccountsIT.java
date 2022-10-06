package au.org.consumerdatastandards.integration.api.energy;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ApiResult;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.energy.EnergyAccountsAPI;
import au.org.consumerdatastandards.client.model.energy.*;

import au.org.consumerdatastandards.integration.utils.ResponseCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnergyAccountsIT extends ProtectedITBase {
    public EnergyAccountsIT() throws ApiException, IOException {
        super(new EnergyAccountsAPI());
    }

    @Test
    public void listAccounts() throws ApiException {

        ApiResult<EnergyAccountListResponse<EnergyAccountV1>> result =
                ((EnergyAccountsAPI)getAPI()).listEnergyAccounts(null, 1, null, null);

        ApiResponse<EnergyAccountListResponse<EnergyAccountV1>> resp = result.getResponse();

        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(resp.getBody().getData().getAccounts().toArray().length == 2);


        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @CsvSource({
            "ALL",
            "OPEN",
            "CLOSED"
    })
    public void listAccountsV2(ParamAccountOpenStatus openStatus) throws ApiException {

        ApiResult<EnergyAccountListResponse<EnergyAccountV2>> result =
                ((EnergyAccountsAPI)getAPI()).listEnergyAccounts( openStatus, 2, null, null);

        ApiResponse<EnergyAccountListResponse<EnergyAccountV2>> resp = result.getResponse();

        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);

        for (EnergyAccountV2 account : resp.getBody().getData().getAccounts()) {
            checkOpenStatus(account.getOpenStatus(), openStatus, conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @Test
    public void getAccountDetail() throws ApiException {

        // Gets accounts list.
        ApiResult<EnergyAccountListResponse<EnergyAccountV1>> result =
                ((EnergyAccountsAPI)getAPI()).listEnergyAccounts(null, 1, null, null);

        ApiResponse<EnergyAccountListResponse<EnergyAccountV1>> resp = result.getResponse();

        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);

        Assertions.assertTrue(resp.getBody().getData().getAccounts().toArray().length == 2);

        // Gets accounts details.
        for (EnergyAccountBase account : resp.getBody().getData().getAccounts()) {

            ApiResult<EnergyAccountDetailResponse<EnergyAccountDetailV1>> accountDetailResult =
                    ((EnergyAccountsAPI)getAPI()).getEnergyAccountDetail(account.getAccountId(), 1);
            ApiResponse<EnergyAccountDetailResponse<EnergyAccountDetailV1>> accountDetailResponse = accountDetailResult.getResponse();

            Assertions.assertEquals(ResponseCode.OK.getCode(), accountDetailResponse.getStatusCode());
            checkResponseHeaders(accountDetailResponse.getHeaders(), conformanceErrors);
            checkAccountId(accountDetailResponse.getBody().getData().getAccountId(), account.getAccountId(), conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    @ParameterizedTest
    @CsvSource({
            "ALL",
            "OPEN",
            "CLOSED"
    })
    public void getAccountDetailV2(ParamAccountOpenStatus openStatus) throws ApiException {

        // Gets accounts list.
        ApiResult<EnergyAccountListResponse<EnergyAccountV2>> result =
                ((EnergyAccountsAPI)getAPI()).listEnergyAccounts(openStatus, 2, null, null);

        ApiResponse<EnergyAccountListResponse<EnergyAccountV2>> resp = result.getResponse();

        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);

        // Gets accounts details.
        for (EnergyAccountV2 account : resp.getBody().getData().getAccounts()) {

            checkOpenStatus(account.getOpenStatus(), openStatus, conformanceErrors);

            ApiResult<EnergyAccountDetailResponse<EnergyAccountDetailV2>> accountDetailResult =
                    ((EnergyAccountsAPI)getAPI()).getEnergyAccountDetail(account.getAccountId(), 2);
            ApiResponse<EnergyAccountDetailResponse<EnergyAccountDetailV2>> accountDetailResponse = accountDetailResult.getResponse();

            Assertions.assertEquals(ResponseCode.OK.getCode(), accountDetailResponse.getStatusCode());
            checkResponseHeaders(accountDetailResponse.getHeaders(), conformanceErrors);
            checkAccountId(accountDetailResponse.getBody().getData().getAccountId(), account.getAccountId(), conformanceErrors);
            checkOpenStatus(accountDetailResponse.getBody().getData().getOpenStatus(), openStatus, conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }
}
