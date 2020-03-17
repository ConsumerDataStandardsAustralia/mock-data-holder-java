package au.org.consumerdatastandards.client.cli.auth;

import au.org.consumerdatastandards.client.ApiClientOptions;
import au.org.consumerdatastandards.client.cli.support.ClientCLIFactory;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @Autowired
    private ApiClientOptions clientOptions;

    @GetMapping("/auth")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String auth() throws InterruptedException {
        OIDCAuthenticationToken auth = (OIDCAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        clientOptions.setAccessToken(auth.getAccessTokenValue());
        clientOptions.setRefreshToken(auth.getRefreshTokenValue());
        ClientCLIFactory.browserMutex.put(this);
        return "auth";
    }
}
