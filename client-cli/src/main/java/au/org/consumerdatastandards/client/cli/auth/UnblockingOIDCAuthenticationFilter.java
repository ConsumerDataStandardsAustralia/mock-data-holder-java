package au.org.consumerdatastandards.client.cli.auth;

import au.org.consumerdatastandards.client.cli.support.ClientCLIFactory;
import org.mitre.openid.connect.client.OIDCAuthenticationFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UnblockingOIDCAuthenticationFilter extends OIDCAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        try {
            return super.attemptAuthentication(request, response);
        } catch (Exception e) {
            try {
                ClientCLIFactory.browserMutex.put(e);
            } catch (InterruptedException ex) {
                // Safe to ignore
            }
            throw e;
        }
    }
}
