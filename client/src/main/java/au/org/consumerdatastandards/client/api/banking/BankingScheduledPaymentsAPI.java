/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 */
package au.org.consumerdatastandards.client.api.banking;

import au.org.consumerdatastandards.client.ApiCallback;
import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.Pair;
import au.org.consumerdatastandards.client.api.ProtectedAPI;
import au.org.consumerdatastandards.client.api.ReturnTypeResolver;
import au.org.consumerdatastandards.client.model.banking.BankingProductCategory;
import au.org.consumerdatastandards.client.model.banking.BankingScheduledPaymentTo;
import au.org.consumerdatastandards.client.model.banking.BankingScheduledPaymentToV1;
import au.org.consumerdatastandards.client.model.banking.BankingScheduledPaymentToV2;
import au.org.consumerdatastandards.client.model.banking.ParamAccountOpenStatus;
import au.org.consumerdatastandards.client.model.banking.RequestAccountIds;
import au.org.consumerdatastandards.client.model.banking.ResponseBankingScheduledPaymentsList;
import com.google.gson.reflect.TypeToken;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankingScheduledPaymentsAPI extends ProtectedAPI {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankingScheduledPaymentsAPI.class);

    /**
     * Build call for listScheduledPayments
     *
     * @param accountId ID of the account to get scheduled payments for. Must have previously been returned by one of the account list end points. The account specified is the source account for the payment (required)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param version endpoint version
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public okhttp3.Call listScheduledPaymentsCall(String accountId, Integer page, Integer pageSize, Integer version, final ApiCallback<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo>> _callback) throws ApiException {

        Object postBody = null;

        // create path and map variables
        String path = "/banking/accounts/{accountId}/payments/scheduled"
            .replaceAll("\\{" + "accountId" + "\\}", apiClient.escapeString(accountId));

        LOGGER.trace("Building Call for listScheduledPayments with path: {}, accountId: {}, page: {}, page-size: {}",
            path,
            accountId,
            page,
            pageSize);

        List<Pair> queryParams = new ArrayList<>();
        List<Pair> collectionQueryParams = new ArrayList<>();
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        headerParams.put("x-v", "" + version);
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        return apiClient.buildCall(path, "GET", queryParams, collectionQueryParams, postBody, headerParams, authNames, _callback);
    }

    private okhttp3.Call listScheduledPaymentsValidateBeforeCall(String accountId, Integer page, Integer pageSize, Integer version, final ApiCallback<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo>> _callback) throws ApiException {

        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new ApiException("Missing the required parameter 'accountId' when calling listScheduledPayments(Async)");
        }


        return listScheduledPaymentsCall(accountId, page, pageSize, version, _callback);
    }

    /**
     * Get Scheduled Payments for Account
     * Obtain scheduled, outgoing payments for a specific account
     * @param accountId ID of the account to get scheduled payments for. Must have previously been returned by one of the account list end points. The account specified is the source account for the payment (required)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param version endpoint version
     * @return ResponseBankingScheduledPaymentsList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo> listScheduledPayments(String accountId, Integer page, Integer pageSize, Integer version) throws ApiException {

        LOGGER.trace("listScheduledPayments with accountId: {}, page: {}, page-size: {}",
            accountId,
            page,
            pageSize);

        ApiResponse<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo>> resp = listScheduledPaymentsWithHttpInfo(accountId, page, pageSize, version);
        return resp.getBody();
    }

    /**
     * Get Scheduled Payments for Account
     * Obtain scheduled, outgoing payments for a specific account
     *
     * @param accountId ID of the account to get scheduled payments for. Must have previously been returned by one of the account list end points. The account specified is the source account for the payment (required)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param version endpoint version
     * @return ApiResponse&lt;ResponseBankingScheduledPaymentsList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public ApiResponse<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo>> listScheduledPaymentsWithHttpInfo(String accountId, Integer page, Integer pageSize, Integer version) throws ApiException {
        okhttp3.Call call = listScheduledPaymentsValidateBeforeCall(accountId, page, pageSize, version, null);
        return apiClient.execute(call, new ScheduledPaymentsReturnTypeResolver());
    }

    /**
     * Get Scheduled Payments for Account (asynchronously)
     * Obtain scheduled, outgoing payments for a specific account
     * @param accountId ID of the account to get scheduled payments for. Must have previously been returned by one of the account list end points. The account specified is the source account for the payment (required)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param version endpoint version
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public okhttp3.Call listScheduledPaymentsAsync(String accountId, Integer page, Integer pageSize, Integer version, final ApiCallback<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo>> _callback) throws ApiException {

        LOGGER.trace("Asynchronously listScheduledPayments with accountId: {}, page: {}, page-size: {}",
            accountId,
            page,
            pageSize);

        okhttp3.Call call = listScheduledPaymentsValidateBeforeCall(accountId, page, pageSize, version, _callback);
        apiClient.executeAsync(call, _callback, new ScheduledPaymentsReturnTypeResolver());
        return call;
    }
    /**
     * Build call for listScheduledPaymentsBulk
     * @param productCategory Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned. (optional)
     * @param openStatus Used to filter results according to open/closed status. Values can be OPEN, CLOSED or ALL. If absent then ALL is assumed (optional, default to ALL)
     * @param isOwned Filters accounts based on whether they are owned by the authorised customer.  True for owned accounts, false for unowned accounts and absent for all accounts (optional)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param version endpoint version
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public okhttp3.Call listScheduledPaymentsBulkCall(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned, Integer page, Integer pageSize, Integer version, final ApiCallback<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo>> _callback) throws ApiException {

        Object postBody = null;

        // create path and map variables
        String path = "/banking/payments/scheduled";

        LOGGER.trace("Building Call for listScheduledPaymentsBulk with path: {}, product-category: {}, open-status: {}, is-owned: {}, page: {}, page-size: {}",
            path,
            productCategory,
            openStatus,
            isOwned,
            page,
            pageSize);

        List<Pair> queryParams = new ArrayList<>();
        List<Pair> collectionQueryParams = new ArrayList<>();
        addQueryParam(queryParams, "product-category", productCategory);
        addQueryParam(queryParams, "open-status", openStatus);
        addQueryParam(queryParams, "is-owned", isOwned);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        headerParams.put("x-v", "" + version);
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        return apiClient.buildCall(path, "GET", queryParams, collectionQueryParams, postBody, headerParams, authNames, _callback);
    }

    private okhttp3.Call listScheduledPaymentsBulkValidateBeforeCall(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned, Integer page, Integer pageSize, final ApiCallback<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo>> _callback) throws ApiException {

        return listScheduledPaymentsBulkCall(productCategory, openStatus, isOwned, page, pageSize, 1, _callback);
    }

    /**
     * Get Scheduled Payments Bulk
     * Obtain scheduled payments for multiple, filtered accounts that are the source of funds for the payments
     * @param productCategory Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned. (optional)
     * @param openStatus Used to filter results according to open/closed status. Values can be OPEN, CLOSED or ALL. If absent then ALL is assumed (optional, default to ALL)
     * @param isOwned Filters accounts based on whether they are owned by the authorised customer.  True for owned accounts, false for unowned accounts and absent for all accounts (optional)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @return ResponseBankingScheduledPaymentsList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public <T extends BankingScheduledPaymentTo> ResponseBankingScheduledPaymentsList<T> listScheduledPaymentsBulk(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned, Integer page, Integer pageSize) throws ApiException {

        LOGGER.trace("listScheduledPaymentsBulk with product-category: {}, open-status: {}, is-owned: {}, page: {}, page-size: {}",
            productCategory,
            openStatus,
            isOwned,
            page,
            pageSize);

        ApiResponse<ResponseBankingScheduledPaymentsList<T>> resp = listScheduledPaymentsBulkWithHttpInfo(productCategory, openStatus, isOwned, page, pageSize);
        return resp.getBody();
    }

    /**
     * Get Scheduled Payments Bulk
     * Obtain scheduled payments for multiple, filtered accounts that are the source of funds for the payments
     * @param productCategory Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned. (optional)
     * @param openStatus Used to filter results according to open/closed status. Values can be OPEN, CLOSED or ALL. If absent then ALL is assumed (optional, default to ALL)
     * @param isOwned Filters accounts based on whether they are owned by the authorised customer.  True for owned accounts, false for unowned accounts and absent for all accounts (optional)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @return ApiResponse&lt;ResponseBankingScheduledPaymentsList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public <T extends BankingScheduledPaymentTo> ApiResponse<ResponseBankingScheduledPaymentsList<T>> listScheduledPaymentsBulkWithHttpInfo(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned, Integer page, Integer pageSize) throws ApiException {
        okhttp3.Call call = listScheduledPaymentsBulkValidateBeforeCall(productCategory, openStatus, isOwned, page, pageSize, null);
        return apiClient.execute(call, new ScheduledPaymentsReturnTypeResolver());
    }

    /**
     * Get Scheduled Payments Bulk (asynchronously)
     * Obtain scheduled payments for multiple, filtered accounts that are the source of funds for the payments
     * @param productCategory Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned. (optional)
     * @param openStatus Used to filter results according to open/closed status. Values can be OPEN, CLOSED or ALL. If absent then ALL is assumed (optional, default to ALL)
     * @param isOwned Filters accounts based on whether they are owned by the authorised customer.  True for owned accounts, false for unowned accounts and absent for all accounts (optional)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public okhttp3.Call listScheduledPaymentsBulkAsync(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned, Integer page, Integer pageSize, final ApiCallback<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo>> _callback) throws ApiException {

        LOGGER.trace("Asynchronously listScheduledPaymentsBulk with product-category: {}, open-status: {}, is-owned: {}, page: {}, page-size: {}",
            productCategory,
            openStatus,
            isOwned,
            page,
            pageSize);

        okhttp3.Call call = listScheduledPaymentsBulkValidateBeforeCall(productCategory, openStatus, isOwned, page, pageSize, _callback);
        apiClient.executeAsync(call, _callback, new ScheduledPaymentsReturnTypeResolver());
        return call;
    }
    /**
     * Build call for listScheduledPaymentsSpecificAccounts
     * @param accountIds Array of specific accountIds to obtain scheduled payments for.  The accounts specified are the source of funds for the payments returned (required)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param version endpoint version
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * http.response.details
     * <table summary="Response Details" border="1">
     *   <tr>
     *       <td> Status Code </td>
     *       <td> Description </td>
     *       <td> Response Headers </td>
     *   </tr>
     *   <tr>
     *       <td> 200 </td>
     *       <td> Success </td>
     *       <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *   </tr>
     *   <tr>
     *       <td> 422 </td>
     *       <td> The request was well formed but was unable to be processed due to business logic specific to the request. For this API a 422 response must be given if any of the account IDs provided are invalid for the consent context </td>
     *       <td>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *   </tr>
     * </table>
     */
    public okhttp3.Call listScheduledPaymentsSpecificAccountsCall(RequestAccountIds accountIds, Integer page, Integer pageSize, Integer version, final ApiCallback<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo>> _callback) throws ApiException {

        // create path and map variables
        String path = "/banking/payments/scheduled";

        LOGGER.trace("Building Call for listScheduledPaymentsSpecificAccounts with path: {}, accountIds: {}, page: {}, page-size: {}",
            path,
            accountIds,
            page,
            pageSize);

        List<Pair> queryParams = new ArrayList<>();
        List<Pair> collectionQueryParams = new ArrayList<>();
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        headerParams.put("x-v", "" + version);
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        return apiClient.buildCall(path, "POST", queryParams, collectionQueryParams, accountIds, headerParams, authNames, _callback);
    }

    private okhttp3.Call listScheduledPaymentsSpecificAccountsValidateBeforeCall(RequestAccountIds accountIds, Integer page, Integer pageSize, Integer version, final ApiCallback<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo>> _callback) throws ApiException {

        // verify the required parameter 'accountIds' is set
        if (accountIds == null) {
            throw new ApiException("Missing the required parameter 'accountIds' when calling listScheduledPaymentsSpecificAccounts(Async)");
        }

        return listScheduledPaymentsSpecificAccountsCall(accountIds, page, pageSize, version, _callback);
    }

    /**
     * Get Scheduled Payments For Specific Accounts
     * Obtain scheduled payments for a specified list of accounts
     * @param accountIds Array of specific accountIds to obtain scheduled payments for.  The accounts specified are the source of funds for the payments returned (required)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @return ResponseBankingScheduledPaymentsList
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * http.response.details
     * <table summary="Response Details" border="1">
     *   <tr>
     *       <td> Status Code </td>
     *       <td> Description </td>
     *       <td> Response Headers </td>
     *   </tr>
     *   <tr>
     *       <td> 200 </td>
     *       <td> Success </td>
     *       <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *   </tr>
     *   <tr>
     *       <td> 422 </td>
     *       <td> The request was well formed but was unable to be processed due to business logic specific to the request. For this API a 422 response must be given if any of the account IDs provided are invalid for the consent context </td>
     *       <td>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *   </tr>
     * </table>
     */
    public ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo> listScheduledPaymentsSpecificAccounts(RequestAccountIds accountIds, Integer page, Integer pageSize, Integer version) throws ApiException {

        LOGGER.trace("listScheduledPaymentsSpecificAccounts with accountIds: {}, page: {}, page-size: {}",
            accountIds,
            page,
            pageSize);

        ApiResponse<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo>> resp = listScheduledPaymentsSpecificAccountsWithHttpInfo(accountIds, page, pageSize, version);
        return resp.getBody();
    }

    /**
     * Get Scheduled Payments For Specific Accounts
     * Obtain scheduled payments for a specified list of accounts
     *
     * @param accountIds Array of specific accountIds to obtain scheduled payments for.  The accounts specified are the source of funds for the payments returned (required)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param version endpoint version
     * @return ApiResponse&lt;ResponseBankingScheduledPaymentsList&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * http.response.details
     * <table summary="Response Details" border="1">
     *   <tr>
     *       <td> Status Code </td>
     *       <td> Description </td>
     *       <td> Response Headers </td>
     *   </tr>
     *   <tr>
     *       <td> 200 </td>
     *       <td> Success </td>
     *       <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *   </tr>
     *   <tr>
     *       <td> 422 </td>
     *       <td> The request was well formed but was unable to be processed due to business logic specific to the request. For this API a 422 response must be given if any of the account IDs provided are invalid for the consent context </td>
     *       <td>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *   </tr>
     * </table>
     */
    public ApiResponse<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo>> listScheduledPaymentsSpecificAccountsWithHttpInfo(RequestAccountIds accountIds, Integer page, Integer pageSize, Integer version) throws ApiException {
        okhttp3.Call call = listScheduledPaymentsSpecificAccountsValidateBeforeCall(accountIds, page, pageSize, version, null);
        return apiClient.execute(call, new ScheduledPaymentsReturnTypeResolver());
    }

    /**
     * Get Scheduled Payments For Specific Accounts (asynchronously)
     * Obtain scheduled payments for a specified list of accounts
     * @param accountIds Array of specific accountIds to obtain scheduled payments for.  The accounts specified are the source of funds for the payments returned (required)
     * @param page Page of results to request (standard pagination) (optional, default to 1)
     * @param pageSize Page size to request. Default is 25 (standard pagination) (optional, default to 25)
     * @param version endpoint version
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * http.response.details
     * <table summary="Response Details" border="1">
     *    <tr>
     *        <td> Status Code </td>
     *        <td> Description </td>
     *        <td> Response Headers </td>
     *    </tr>
     *    <tr>
     *        <td> 200 </td>
     *        <td> Success </td>
     *        <td>  * x-v - The [version](#response-headers) of the API end point that the data holder has responded with. <br>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     *    <tr>
     *        <td> 422 </td>
     *        <td> The request was well formed but was unable to be processed due to business logic specific to the request. For this API a 422 response must be given if any of the account IDs provided are invalid for the consent context </td>
     *        <td>  * x-fapi-interaction-id - An [RFC4122](https://tools.ietf.org/html/rfc4122) UUID used as a correlation id. If provided, the data holder must play back this value in the x-fapi-interaction-id response header. If not provided a [RFC4122] UUID value is required to be provided in the response header to track the interaction. <br>  </td>
     *    </tr>
     * </table>
     */
    public okhttp3.Call listScheduledPaymentsSpecificAccountsAsync(RequestAccountIds accountIds, Integer page, Integer pageSize, Integer version, final ApiCallback<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentTo>> _callback) throws ApiException {

        LOGGER.trace("Asynchronously listScheduledPaymentsSpecificAccounts with accountIds: {}, page: {}, page-size: {}",
            accountIds,
            page,
            pageSize);

        okhttp3.Call call = listScheduledPaymentsSpecificAccountsValidateBeforeCall(accountIds, page, pageSize, version, _callback);
        apiClient.executeAsync(call, _callback, new ScheduledPaymentsReturnTypeResolver());
        return call;
    }

}
class ScheduledPaymentsReturnTypeResolver implements ReturnTypeResolver {
    @Override
    public Type resolve(Response response) {
        String version = response.header("x-v");
        switch (Integer.parseInt(version)) {
            case 1:
                return new TypeToken<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentToV1>>() {}.getType();
            case 2:
            default:
                return new TypeToken<ResponseBankingScheduledPaymentsList<BankingScheduledPaymentToV2>>() {}.getType();
        }
    }
}
