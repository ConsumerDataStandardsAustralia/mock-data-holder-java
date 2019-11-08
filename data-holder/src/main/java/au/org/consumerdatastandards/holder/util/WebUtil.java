package au.org.consumerdatastandards.holder.util;

import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class WebUtil {

    private final static String V = "x-v";
    private final static Integer CURRENT_VERSION = 1;
    private final static String CORRELATION_ID = "x-Correlation-Id";
    private final static String FAPI_INTERACTION_ID = "x-fapi-interaction-id";

    public static String getPaginatedLink(NativeWebRequest request, Integer page, Integer pageSize) {
        HttpServletRequest servletRequest = request.getNativeRequest(HttpServletRequest.class);
        String paginatedLink = getOriginalUrl(servletRequest);
        String originalPage = servletRequest.getParameter("page");
        if (StringUtils.isEmpty(originalPage)) {
            String pageParam = servletRequest.getParameterMap().isEmpty() ? "?page=" : "&page=";
            paginatedLink = paginatedLink + pageParam + page;
        } else {
            paginatedLink = paginatedLink.replace("page=" + originalPage, "page=" + page);
        }
        String originalPageSize = servletRequest.getParameter("page-size");
        if (StringUtils.isEmpty(originalPageSize)) {
            paginatedLink = paginatedLink + "&page-size=" + pageSize;
        } else {
            paginatedLink = paginatedLink.replace("page-size=" + originalPageSize, "page-size=" + pageSize);
        }
        return paginatedLink;
    }

    public static String getOriginalUrl(NativeWebRequest request) {
        return getOriginalUrl(request.getNativeRequest(HttpServletRequest.class));
    }

    public static HttpHeaders processHeaders(NativeWebRequest request) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("content-type", "application/json");
        responseHeaders.set(V, getCurrentVersion().toString());
        String correlationId = request.getHeader(CORRELATION_ID);
        if (!StringUtils.isEmpty(correlationId)) {
            responseHeaders.set(CORRELATION_ID, correlationId);
        }
        String fapiInteractionId = request.getHeader(FAPI_INTERACTION_ID);
        if (!StringUtils.isEmpty(fapiInteractionId)) {
            responseHeaders.set(FAPI_INTERACTION_ID, fapiInteractionId);
        } else {
            responseHeaders.set(FAPI_INTERACTION_ID, UUID.randomUUID().toString());
        }
        return responseHeaders;
    }

    private static String getOriginalUrl(HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();

        if (queryString == null) {
            return requestURL.toString();
        } else {
            return requestURL.append("?").append(queryString).toString();
        }
    }

    private static Integer getVersionNumber(String version) {
        Integer versionValue = null;
        if (!StringUtils.isEmpty(version)) {
            try {
                versionValue = Integer.parseInt(version);
            } catch (NumberFormatException e) {
                // ignore it
            }
        }
        return versionValue;
    }

    public static Integer getCurrentVersion() {
        return CURRENT_VERSION;
    }

    public static boolean hasSupportedVersion(String xMinV, String xV) {
        Integer maxVersion = getVersionNumber(xV);
        Integer minVersion = getVersionNumber(xMinV);
        if (maxVersion != null && getCurrentVersion() > maxVersion) {
            return false;
        }
        return minVersion == null || getCurrentVersion() >= minVersion;
    }
}
