package au.org.consumerdatastandards.integration.utils;

import au.org.consumerdatastandards.client.ApiClient;
import au.org.consumerdatastandards.client.ApiException;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

public class ApiUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiUtil.class);

    public static ApiClient createApiClient(String serverUrl) throws ApiException {
        return createApiClient(serverUrl, true);
    }

    public static ApiClient createApiClient(String serverUrl, boolean authRequired) throws ApiException {
        if (StringUtils.isBlank(serverUrl)) {
            LOGGER.error("Server Base URL is currently unset, cannot proceed until it is specified using `server` command");
            throw new ApiException("Server URL not set, please use `server` command to set Server URL first");
        }
        if (!isValidUrl(serverUrl)) {
            LOGGER.error("Invalid server url of {} specified, please double check", serverUrl);
            throw new ApiException("Invalid Server URL, please double check it");
        }
        ApiClient apiClient = new ApiClient();
        OkHttpClient originalHttpClient = apiClient.getHttpClient();
        apiClient.setBasePath(serverUrl);
        LOGGER.info("Server Base URL is set to {}", serverUrl);
        String userAgent = "CDS Integration Tests";
        if (!StringUtils.isBlank(userAgent)) {
            apiClient.addDefaultHeader("x-cds-client-headers", Base64.getEncoder().encodeToString(("User-Agent: " + userAgent).getBytes()));
            LOGGER.info("User Agent in x-cds-client-headers is set to {}", userAgent);
        }

        return apiClient;
    }

    private static boolean isValidUrl(String url) {
        String lowerCaseUrl = url.toLowerCase();
        if (!lowerCaseUrl.startsWith("https://") && !lowerCaseUrl.startsWith("http://")) {
            LOGGER.error("Invalid scheme specified for server url, only https:// and http:// are supported");
            return false;
        }
        try {
            new URL(url);
            LOGGER.trace("Server URL of {} passes validation", url);
            return true;
        } catch (MalformedURLException e) {
            LOGGER.error("Specified URL of {} is malformed and exception caught: {}", url, e.getMessage());
            return false;
        }
    }
}