package au.org.consumerdatastandards.client;

public class ApiResult<T> {
    private final String requestUrl;
    private final ApiResponse<T> response;

    public ApiResult(String requestUrl, ApiResponse<T> response) {
        this.requestUrl = requestUrl;
        this.response = response;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public ApiResponse<T> getResponse() {
        return response;
    }
}
