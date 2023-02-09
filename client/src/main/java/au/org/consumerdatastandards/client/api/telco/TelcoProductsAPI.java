package au.org.consumerdatastandards.client.api.telco;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResult;
import au.org.consumerdatastandards.client.Pair;
import au.org.consumerdatastandards.client.api.UnprotectedAPI;
import au.org.consumerdatastandards.client.model.telco.BillingTypeEnum;
import au.org.consumerdatastandards.client.model.telco.TelcoProductListResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoProductResponse;
import au.org.consumerdatastandards.client.model.telco.TypeEnum;
import com.google.gson.reflect.TypeToken;
import okhttp3.Call;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TelcoProductsAPI extends UnprotectedAPI {

    public enum ParamEffective {
        CURRENT,
        FUTURE,
        ALL
    }

    public ApiResult<TelcoProductListResponse> listProducts(TypeEnum type, BillingTypeEnum billingType,
            String brand, ParamEffective effective, Integer page, Integer pageSize, OffsetDateTime updatedSince) throws ApiException {

        String path = "/telco/products";

        logger.trace("Building Call for listProducts with path: {}, type: {}, billingType: {}, brand: {}, effective: {}, page: {}, page-size: {}, updatedSince: {}",
                path,
                type, billingType, brand, effective, page, pageSize, updatedSince);

        List<Pair> queryParams = new ArrayList<>();
        addQueryParam(queryParams, "type", type);
        addQueryParam(queryParams, "billingType", billingType);
        addQueryParam(queryParams, "brand", brand);
        addQueryParam(queryParams, "effective", effective);
        addQueryParam(queryParams, "updated-since", updatedSince);
        addQueryParam(queryParams, "page", page);
        addQueryParam(queryParams, "page-size", pageSize);
        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, queryParams, null, null, new HashMap<String, String>(), authNames, null);

        Type returnType = new TypeToken<TelcoProductListResponse>(){}.getType();
        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }

    public ApiResult<TelcoProductResponse> getProductDetail(String productId) throws ApiException {

        String path = "/telco/products/" + apiClient.escapeString(productId);

        if (productId == null) {
            throw new ApiException("Missing the required parameter 'productId' when calling getGenericPlanDetail()");
        }

        logger.trace("Building Call for getProductDetail with path: {}, productId: {}",
                path,
                productId);

        String[] authNames = new String[] {  };
        Call call = apiClient.buildCall(path, METHOD_GET, null, null, null, new HashMap<String, String>(), authNames, null);

        Type returnType = new TypeToken<TelcoProductResponse>(){}.getType();
        return new ApiResult<>(call.request().url().toString(), apiClient.execute(call, returnType));
    }
}
