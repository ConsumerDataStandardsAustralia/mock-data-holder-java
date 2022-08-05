package au.org.consumerdatastandards.client.api;

import au.org.consumerdatastandards.client.ApiClient;
import au.org.consumerdatastandards.client.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UnprotectedAPI {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected ApiClient apiClient;

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    protected void addQueryParam(List<Pair> queryParams, String paramName, Object paramValue) {
        if (paramValue != null) {
            logger.trace("Adding query parameter of {} with value of {}", paramName, paramValue);
            queryParams.addAll(apiClient.parameterToPair(paramName, paramValue));
        }
    }
}
