package au.org.consumerdatastandards.client.api.telco;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResult;
import au.org.consumerdatastandards.client.Pair;
import au.org.consumerdatastandards.client.api.ProtectedAPI;
import au.org.consumerdatastandards.client.model.telco.RequestAccountIds;
import au.org.consumerdatastandards.client.model.telco.TelcoAccountDetailResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoAccountListResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoBalanceListResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoBalanceResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoConcessionsResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoInvoiceListResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoPaymentScheduleResponse;
import com.google.gson.reflect.TypeToken;
import okhttp3.Call;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelcoAccountsAPI extends ProtectedAPI {

    /**
     * Open or closed status for the account. If not present then OPEN is assumed
     */
    public enum ParamOpenStatusEnum {
        CLOSED,
        OPEN,
        ALL
    }

    public ApiResult<TelcoAccountListResponse> listAccounts(ParamOpenStatusEnum openStatus,
            Integer page, Integer pageSize) throws ApiException {

        String path = "/telco/accounts";

        logger.trace("Building Call for listAccounts with path: {}, open-status: {}, page: {}, page-size: {}",
                path,
                openStatus,
                page,
                pageSize);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "open-status", openStatus);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);

        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, headerParams, authNames, null);

        Type returnType = new TypeToken<TelcoAccountListResponse>(){}.getType();
        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<TelcoAccountDetailResponse> getAccountDetail(String accountId) throws ApiException {

        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling getAccountDetail()");
        }

        // create path and map variables
        String path = "/telco/accounts/" + apiClient.escapeString(accountId);

        logger.trace("Building Call for getAccountDetail with path: {}, accountId: {}",
                path,
                accountId);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);

        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, null, null, null, headerParams, authNames, null);

        Type returnType = new TypeToken<TelcoAccountDetailResponse>(){}.getType();
        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<TelcoPaymentScheduleResponse> getPaymentSchedule(String accountId) throws ApiException {

        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling getPaymentSchedule()");
        }

        // create path and map variables
        String path = "/telco/accounts/" + apiClient.escapeString(accountId) + "/payment-schedule";

        logger.trace("Building Call for getPaymentSchedule with path: {}, accountId: {}",
                path,
                accountId);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, null, null, null, headerParams, authNames, null);

        Type returnType = new TypeToken<TelcoPaymentScheduleResponse>(){}.getType();
        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<TelcoConcessionsResponse> getConcessions(String accountId) throws ApiException {

        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling getConcessions()");
        }

        // create path and map variables
        String path = "/telco/accounts/" + apiClient.escapeString(accountId) + "/concessions";

        logger.trace("Building Call for getConcessions with path: {}, accountId: {}",
                path,
                accountId);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, null, null, null, headerParams, authNames, null);
        Type returnType = new TypeToken<TelcoConcessionsResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<TelcoBalanceResponse> getBalanceForAccount(String accountId) throws ApiException {

        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling getBalanceForAccount()");
        }

        // create path and map variables
        String path = "/telco/accounts/" + apiClient.escapeString(accountId) + "/balance";

        logger.trace("Building Call for getBalanceForAccount with path: {}, accountId: {}",
                path,
                accountId);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, null, null, null, headerParams, authNames, null);

        Type returnType = new TypeToken<TelcoBalanceResponse>(){}.getType();
        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<TelcoBalanceListResponse> listBalancesBulk(Integer page, Integer pageSize) throws ApiException {

        String path = "/telco/accounts/balances";

        logger.trace("Building Call for listBalancesBulk with path: {}, page: {}, page-size: {}",
                path,
                page,
                pageSize);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, headerParams, authNames, null);
        Type returnType = new TypeToken<TelcoBalanceListResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<TelcoBalanceListResponse> listBalancesForAccounts(RequestAccountIds accountIds, Integer page, Integer pageSize) throws ApiException {

        String path = "/telco/accounts/balances";

        logger.trace("Building Call for listBalancesForAccounts with path: {}, accountIds: {}, page: {}, page-size: {}",
                path,
                accountIds,
                page,
                pageSize);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_POST, queryParams, null, accountIds, headerParams, authNames, null);

        Type returnType = new TypeToken<TelcoBalanceListResponse>(){}.getType();
        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<TelcoInvoiceListResponse> getInvoicesForAccount(String accountId, OffsetDateTime oldestDate, OffsetDateTime newestDate, Integer page, Integer pageSize) throws ApiException {

        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling getInvoicesForAccount()");
        }

        String path = "/telco/accounts/" + apiClient.escapeString(accountId) + "/invoices";

        logger.trace("Building Call for getInvoicesForAccount with path: {}, oldest-date: {}, newest-date: {}, page: {}, page-size: {}",
                path,
                oldestDate,
                newestDate,
                page,
                pageSize);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "oldest-date", oldestDate);
        addQueryParam(queryParams, "newest-date", newestDate);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, headerParams, authNames, null);

        Type returnType = new TypeToken<TelcoInvoiceListResponse>(){}.getType();
        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<TelcoInvoiceListResponse> listInvoicesBulk(OffsetDateTime oldestDate, OffsetDateTime newestDate, Integer page, Integer pageSize) throws ApiException {

        String path = "/telco/accounts/invoices";

        logger.trace("Building Call for listInvoicesBulk with path: {}, oldest-date: {}, newest-date: {}, page: {}, page-size: {}",
                path,
                oldestDate,
                newestDate,
                page,
                pageSize);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "oldest-date", oldestDate);
        addQueryParam(queryParams, "newest-date", newestDate);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, headerParams, authNames, null);

        Type returnType = new TypeToken<TelcoInvoiceListResponse>(){}.getType();
        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<TelcoInvoiceListResponse> listInvoicesForAccounts(RequestAccountIds accountIds,
            OffsetDateTime oldestDate, OffsetDateTime newestDate, Integer page, Integer pageSize) throws ApiException {

        String path = "/telco/accounts/invoices";

        logger.trace("Building Call for listInvoicesForAccounts with path: {}, accountIds: {}, oldest-date: {}, newest-date: {}, page: {}, page-size: {}",
                path,
                accountIds,
                oldestDate,
                newestDate,
                page,
                pageSize);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "oldest-date", oldestDate);
        addQueryParam(queryParams, "newest-date", newestDate);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_POST, queryParams, null, accountIds, headerParams, authNames, null);

        Type returnType = new TypeToken<TelcoInvoiceListResponse>(){}.getType();
        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }
}
