package au.org.consumerdatastandards.client.api.telco;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResult;
import au.org.consumerdatastandards.client.Pair;
import au.org.consumerdatastandards.client.api.ProtectedAPI;
import au.org.consumerdatastandards.client.model.telco.RequestServiceIds;
import au.org.consumerdatastandards.client.model.telco.TelcoServiceUsageListResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoServiceUsageResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoUsageListResponse;
import com.google.gson.reflect.TypeToken;
import okhttp3.Call;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelcoUsageAPI extends ProtectedAPI {

    public ApiResult<TelcoUsageListResponse> listUsage(OffsetDateTime oldestDate, OffsetDateTime newestDate,
            Integer page, Integer pageSize) throws ApiException {

        String path = "/telco/accounts/usage";

        logger.trace("Building Call for listUsage with path: {}, oldest-date: {}, newest-date: {}, page: {}, page-size: {}",
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

        Type returnType = new TypeToken<TelcoUsageListResponse>(){}.getType();
        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<TelcoServiceUsageResponse> getUsageForService(String serviceId, OffsetDateTime oldestDate, OffsetDateTime newestDate) throws ApiException {

        if (serviceId == null) {
            throw new ApiException("Missing the required parameter 'serviceId' when calling getUsageForService()");
        }

        // create path and map variables
        String path = "/telco/accounts/" + apiClient.escapeString(serviceId) + "/usage";

        logger.trace("Building Call for getUsageForService with path: {}, serviceId: {}",
                path,
                serviceId);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "oldest-date", oldestDate);
        addQueryParam(queryParams, "newest-date", newestDate);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, headerParams, authNames, null);

        Type returnType = new TypeToken<TelcoServiceUsageResponse>(){}.getType();
        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<TelcoServiceUsageListResponse> listUsageForService(RequestServiceIds serviceIds,
            OffsetDateTime oldestDate, OffsetDateTime newestDate, Integer page, Integer pageSize) throws ApiException {

        String path = "/telco/accounts/usage";

        logger.trace("Building Call for listUsageForService with path: {}, serviceIds: {}, oldest-date: {}, newest-date: {}, page: {}, page-size: {}",
                path,
                serviceIds,
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
        Call call = apiClient.buildCall(path, METHOD_POST, queryParams, null, serviceIds, headerParams, authNames, null);

        Type returnType = new TypeToken<TelcoServiceUsageListResponse>(){}.getType();
        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }
}
