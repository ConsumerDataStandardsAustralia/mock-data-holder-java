package au.org.consumerdatastandards.client.api.energy;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResult;
import au.org.consumerdatastandards.client.Pair;
import au.org.consumerdatastandards.client.api.UnprotectedAPI;
import au.org.consumerdatastandards.client.model.energy.EnergyPlanListResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyPlanResponse;
import au.org.consumerdatastandards.client.model.energy.ParamEffective;
import au.org.consumerdatastandards.client.model.energy.ParamFuelTypeEnum;
import au.org.consumerdatastandards.client.model.energy.ParamTypeEnum;
import com.google.gson.reflect.TypeToken;
import okhttp3.Call;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EnergyPlansAPI extends UnprotectedAPI {

    public ApiResult<EnergyPlanListResponse> listEnergyPlans(ParamTypeEnum type, ParamFuelTypeEnum fuelType,
            String brand, ParamEffective effective, Integer page, Integer pageSize, OffsetDateTime updatedSince) throws ApiException {

        String path = "/energy/plans";

        logger.trace("Building Call for listEnergyPlans with path: {}, type: {}, fuelType: {}, brand: {}, effective: {}, page: {}, page-size: {}, updatedSince: {}",
                path,
                type, fuelType, brand, effective, page, pageSize, updatedSince);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "type", type);
        addQueryParam(queryParams, "fuelType", fuelType);
        addQueryParam(queryParams, "brand", brand);
        addQueryParam(queryParams, "effective", effective);
        addQueryParam(queryParams, "updated-since", updatedSince);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, new HashMap<String, String>(), authNames, null);
        Type returnType = new TypeToken<EnergyPlanListResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<EnergyPlanResponse> getGenericPlanDetail(String planId) throws ApiException {

        String path = "/energy/plans/" + apiClient.escapeString(planId);

        if (planId == null) {
            throw new ApiException("Missing the required parameter 'planId' when calling getGenericPlanDetail()");
        }

        logger.trace("Building Call for getGenericPlanDetail with path: {}, planId: {}",
                path,
                planId);

        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, null, null, null, new HashMap<String, String>(), authNames, null);
        Type returnType = new TypeToken<EnergyPlanResponse>(){}.getType();

        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }
}
