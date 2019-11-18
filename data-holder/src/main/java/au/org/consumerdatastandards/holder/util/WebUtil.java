package au.org.consumerdatastandards.holder.util;

import org.springframework.util.StringUtils;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {

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

    private static String getOriginalUrl(HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();

        if (queryString == null) {
            return requestURL.toString();
        } else {
            return requestURL.append("?").append(queryString).toString();
        }
    }
}
