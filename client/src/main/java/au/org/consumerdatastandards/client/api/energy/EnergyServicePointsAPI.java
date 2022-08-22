package au.org.consumerdatastandards.client.api.energy;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResult;
import au.org.consumerdatastandards.client.Pair;
import au.org.consumerdatastandards.client.api.ProtectedAPI;
import au.org.consumerdatastandards.client.model.energy.EnergyDerDetailResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyDerListResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyServicePointDetailResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyServicePointListResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyUsageListResponse;
import au.org.consumerdatastandards.client.model.energy.RequestServicePointIds;
import com.google.gson.reflect.TypeToken;
import okhttp3.Call;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnergyServicePointsAPI extends ProtectedAPI {

    public ApiResult<EnergyServicePointListResponse> listServicePoints(Integer page, Integer pageSize) throws ApiException {

        String path = "/energy/electricity/servicepoints";

        logger.trace("Building Call for listServicePoints with path: {}, page: {}, page-size: {}",
                path,
                page, pageSize);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, headerParams, authNames, null);
        Type returnType = new TypeToken<EnergyServicePointListResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyServicePointDetailResponse> getServicePointDetail(String servicePointId) throws ApiException {
        if (servicePointId == null) {
            throw new ApiException("Missing the required parameter 'servicePointId' when calling getServicePointDetail()");
        }

        // create path and map variables
        String path = "/energy/electricity/servicepoints/" + apiClient.escapeString(servicePointId);

        logger.trace("Building Call for getServicePointDetail with path: {}, servicePointId: {}",
                path,
                servicePointId);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, null, null, null, headerParams, authNames, null);
        Type returnType = new TypeToken<EnergyServicePointDetailResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyUsageListResponse> getUsageForServicePoint(String servicePointId,
            Integer page, Integer pageSize, OffsetDateTime oldestDate, OffsetDateTime newestDate) throws ApiException {

        if (servicePointId == null) {
            throw new ApiException("Missing the required parameter 'servicePointId' when calling getUsageForServicePoint()");
        }

        // create path and map variables
        String path = "/energy/electricity/servicepoints/" + apiClient.escapeString(servicePointId) + "/usage";

        logger.trace("Building Call for getUsageForServicePoint with path: {}, servicePointId: {}, page: {}, page-size: {}, oldest-date: {}, newest-date: {}",
                path,
                servicePointId, page, pageSize, oldestDate, newestDate);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "oldest-date", oldestDate);
        addQueryParam(queryParams, "newest-date", newestDate);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, headerParams, authNames, null);
        Type returnType = new TypeToken<EnergyUsageListResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyUsageListResponse> listUsageBulk(Integer page, Integer pageSize, OffsetDateTime oldestDate, OffsetDateTime newestDate) throws ApiException {

        // create path and map variables
        String path = "/energy/electricity/servicepoints/usage";

        logger.trace("Building Call for listUsageBulk with path: {}, page: {}, page-size: {}, oldest-date: {}, newest-date: {}",
                path,
                page, pageSize, oldestDate, newestDate);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "oldest-date", oldestDate);
        addQueryParam(queryParams, "newest-date", newestDate);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, headerParams, authNames, null);
        Type returnType = new TypeToken<EnergyUsageListResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyUsageListResponse> listUsageForServicePoints(RequestServicePointIds requestServicePointIds, Integer page, Integer pageSize,
            OffsetDateTime oldestDate, OffsetDateTime newestDate) throws ApiException {

        // create path and map variables
        String path = "/energy/electricity/servicepoints/usage";

        logger.trace("Building Call for listUsageBulk with path: {}, requestServicePointIds: {}, page: {}, page-size: {}, oldest-date: {}, newest-date: {}",
                path,
                requestServicePointIds, page, pageSize, oldestDate, newestDate);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "oldest-date", oldestDate);
        addQueryParam(queryParams, "newest-date", newestDate);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_POST, queryParams, null, requestServicePointIds, headerParams, authNames, null);
        Type returnType = new TypeToken<EnergyUsageListResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyDerDetailResponse> listDERForServicePoints(String servicePointId) throws ApiException {
        if (servicePointId == null) {
            throw new ApiException("Missing the required parameter 'servicePointId' when calling listDERForServicePoints()");
        }

        // create path and map variables
        String path = "/energy/electricity/servicepoints/" + apiClient.escapeString(servicePointId) + "/der";

        logger.trace("Building Call for listDERForServicePoints with path: {}, servicePointId: {}",
                path,
                servicePointId);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, null, null, null, headerParams, authNames, null);
        Type returnType = new TypeToken<EnergyDerDetailResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyDerListResponse> listDERBulk(Integer page, Integer pageSize) throws ApiException {

        // create path and map variables
        String path = "/energy/electricity/servicepoints/der";

        logger.trace("Building Call for listDERBulk with path: {}, page: {}, page-size: {}",
                path,
                page, pageSize);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, headerParams, authNames, null);
        Type returnType = new TypeToken<EnergyDerListResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyDerListResponse> listDERForServicePoints(RequestServicePointIds requestServicePointIds, Integer page, Integer pageSize) throws ApiException {

        // create path and map variables
        String path = "/energy/electricity/servicepoints/der";

        logger.trace("Building Call for listDERForServicePoints with path: {}, requestServicePointIds: {}, page: {}, page-size: {}",
                path,
                requestServicePointIds, page, pageSize);

        Map<String, String> headerParams = new HashMap<>();
        addCdsProtectedApiHeaders(headerParams);
        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_POST, queryParams, null, requestServicePointIds, headerParams, authNames, null);
        Type returnType = new TypeToken<EnergyDerListResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }
}
