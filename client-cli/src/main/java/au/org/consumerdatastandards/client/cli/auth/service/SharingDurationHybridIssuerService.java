package au.org.consumerdatastandards.client.cli.auth.service;

import org.mitre.openid.connect.client.model.IssuerServiceResponse;
import org.mitre.openid.connect.client.service.impl.HybridIssuerService;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class SharingDurationHybridIssuerService extends HybridIssuerService {

    public static final String SHARING_DURATION = "sharduration";

    @Override
    public IssuerServiceResponse getIssuer(HttpServletRequest request) {
        IssuerServiceResponse issuer = super.getIssuer(request);
        String duration = request.getParameter(SHARING_DURATION);
        if (issuer != null && StringUtils.hasText(duration)) {
            request.getSession().setAttribute(SHARING_DURATION, duration);
        }
        return issuer;
    }
}
