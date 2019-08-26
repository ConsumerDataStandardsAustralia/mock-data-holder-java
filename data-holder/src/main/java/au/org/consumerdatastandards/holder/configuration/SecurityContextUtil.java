package au.org.consumerdatastandards.holder.configuration;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityContextUtil {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(SecurityContextUtil.class);

    private static final String ANONYMOUS = "anonymous";

    private SecurityContextUtil() {
    }

    public static String getUserName() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String username = ANONYMOUS;

        if (null != authentication) {
            if (authentication.getPrincipal() instanceof UserDetails) {
                UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
                username = springSecurityUser.getUsername();

            } else if (authentication.getPrincipal() instanceof String) {
                username = (String) authentication.getPrincipal();

            } else {
                LOG.debug("User details not found in Security Context");
            }
        } else {
            LOG.debug("Request not authenticated, hence no user name available");
        }

        return username;
    }
}
