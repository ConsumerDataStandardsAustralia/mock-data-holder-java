package au.org.consumerdatastandards.holder.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

public class WebUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebUtil.class);

    final static String V = "x-v";
    final static String MIN_V = "x-min-v";
    final static Integer CURRENT_VERSION = 1;
    final static String CORRELATION_ID = "x-Correlation-Id";
    final static String FAPI_INTERACTION_ID = "x-fapi-interaction-id";

    public static URI getPaginatedLink(NativeWebRequest request, Integer page, Integer pageSize) {
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
        try {
            return new URI(paginatedLink);
        } catch (URISyntaxException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }

    public static URI getOriginalUrl(NativeWebRequest request) {
        String originalUrl = getOriginalUrl(request.getNativeRequest(HttpServletRequest.class));
        try {
            return new URI(originalUrl);
        } catch (URISyntaxException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
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

    public static Integer getVersionHeader(NativeWebRequest request, String header) {
        Integer versionValue = null;
        String headerValue = request.getHeader(header);
        if (!StringUtils.isEmpty(headerValue)) {
            try {
                versionValue = Integer.parseInt(headerValue);
            } catch (NumberFormatException e) {
                // ignore it
            }
        }

        return versionValue;
    }

    public static Integer getMaximumVersion(NativeWebRequest request) {
        return getVersionHeader(request, V);
    }

    public static Integer getMinimumVersion(NativeWebRequest request) {
        return getVersionHeader(request, MIN_V);
    }

    public static Integer getCurrentVersion() {
        return CURRENT_VERSION;
    }

    public static boolean hasSupportedVersion(NativeWebRequest request) {
        if (getMaximumVersion(request) != null && getCurrentVersion() > getMaximumVersion(request)) {
            return false;
        }
        return getMinimumVersion(request) == null || getCurrentVersion() >= getMinimumVersion(request);
    }
}
