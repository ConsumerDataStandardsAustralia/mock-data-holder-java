package au.org.consumerdatastandards.client.cli.auth.service;

import org.mitre.oauth2.model.RegisteredClient;
import org.mitre.openid.connect.client.service.AuthRequestOptionsService;
import org.mitre.openid.connect.config.ServerConfiguration;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CDSDynamicOptionsService implements AuthRequestOptionsService {
    @Override
    public Map<String, String> getOptions(ServerConfiguration server, RegisteredClient client, HttpServletRequest request) {
        HashMap<String, String> options = new HashMap<>();
        options.put(SharingDurationHybridIssuerService.SHARING_DURATION,
                (String)request.getSession().getAttribute(SharingDurationHybridIssuerService.SHARING_DURATION));
        return options;
    }

    @Override
    public Map<String, String> getTokenOptions(ServerConfiguration server, RegisteredClient client, HttpServletRequest request) {
        return Collections.emptyMap();
    }
}
