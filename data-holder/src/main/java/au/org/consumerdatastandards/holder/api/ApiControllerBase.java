package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.LinksPaginated;
import au.org.consumerdatastandards.holder.model.MetaPaginated;
import au.org.consumerdatastandards.holder.model.TxMetaPaginated;
import au.org.consumerdatastandards.holder.util.WebUtil;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.ValidationException;
import java.util.UUID;

public class ApiControllerBase {

    private final static String V = "x-v";
    private final static String CORRELATION_ID = "x-Correlation-Id";
    private final static String FAPI_INTERACTION_ID = "x-fapi-interaction-id";
    private final static String BASE64_PATTERN = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$";

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected Integer getPagingValue(Integer page, int defaultValue) {
        return page != null && page > 0 ? page : defaultValue;
    }

    protected void validatePageInputs(Integer page, Integer pageSize) {
        if (page != null && page < 1 || pageSize != null && pageSize < 1) {
            throw new ValidationException("Invalid page or page-size");
        }
    }

    private boolean hasSupportedVersion(Integer xMinV, Integer xV) {
        if (xV != null && getCurrentVersion() > xV) {
            return false;
        }
        return xMinV == null || getCurrentVersion() >= xMinV;
    }

    private Integer getCurrentVersion() {
        return 1;
    }

    protected HttpHeaders generateResponseHeaders(NativeWebRequest request) {
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


    protected void validateHeaders(Integer xMinV, Integer xV) {
        if (!hasSupportedVersion(xMinV, xV)) {
            String message = String.format(
                "Unsupported version requested, minimum version specified is %d, maximum version specified is %d, current version is %d",
                xMinV, xV, getCurrentVersion());
            throw new VersionNotSupportedException(message);
        }
    }

    protected void validateHeaders(String xCdsUserAgent,
                                   String xCdsSubject,
                                   String xFapiCustomerIpAddress,
                                   Integer xMinV, Integer xV) {
        validateHeaders(xMinV, xV);
        if (StringUtils.hasText(xFapiCustomerIpAddress)) {
            InetAddressValidator inetAddressValidator = InetAddressValidator.getInstance();
            if (!inetAddressValidator.isValid(xFapiCustomerIpAddress)) {
                throw new ValidationException("request header x-fapi-customer-ip-address is not valid IP address");
            }
            if (StringUtils.isEmpty(xCdsUserAgent)) {
                throw new ValidationException("request header x-cds-user-agent is not present");
            } else if (!xCdsUserAgent.matches(BASE64_PATTERN)) {
                throw new ValidationException("request header x-cds-user-agent is not Base64 encoded");
            }
            if (StringUtils.isEmpty(xCdsSubject)) {
                throw new ValidationException("request header x-cds-subject is not present");
            }
        }
    }

    protected LinksPaginated getLinkData(NativeWebRequest request, Page page, Integer actualPage, Integer actualPageSize) {
        LinksPaginated linkData = new LinksPaginated();
        linkData.setSelf(WebUtil.getOriginalUrl(request));

        if (page.getTotalPages() == 0) {
            linkData.setFirst(null);
            linkData.setLast(null);
        } else {
            linkData.setFirst(WebUtil.getPaginatedLink(request, 1, actualPageSize));
            linkData.setLast(WebUtil.getPaginatedLink(request, page.getTotalPages(), actualPageSize));
        }

        if (page.hasPrevious()) {
            linkData.setPrev(WebUtil.getPaginatedLink(request, actualPage - 1, actualPageSize));
        }

        if (page.hasNext()) {
            linkData.setPrev(WebUtil.getPaginatedLink(request, actualPage + 1, actualPageSize));
        }
        return linkData;
    }

    protected MetaPaginated getMetaData(Page page) {
        MetaPaginated metaData = new MetaPaginated();
        metaData.setTotalPages(page.getTotalPages());
        metaData.setTotalRecords((int)page.getTotalElements());
        return metaData;
    }

    protected TxMetaPaginated getTxMetaData(Page page, boolean isQueryParamUnsupported) {
        TxMetaPaginated metaData = new TxMetaPaginated();
        metaData.setTotalPages(page.getTotalPages());
        metaData.setTotalRecords((int)page.getTotalElements());
        return metaData;
    }
}
