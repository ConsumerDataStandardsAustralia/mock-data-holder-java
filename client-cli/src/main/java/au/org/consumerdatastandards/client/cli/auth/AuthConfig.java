package au.org.consumerdatastandards.client.cli.auth;

import au.org.consumerdatastandards.client.ApiClientOptions;
import org.mitre.jose.keystore.JWKSetKeyStore;
import org.mitre.openid.connect.client.keypublisher.JwkViewResolver;
import org.mitre.openid.connect.view.JWKSetView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.FileSystemResource;

@Configuration
@ImportResource({"classpath*:servlet-context.xml"})
public class AuthConfig {
    @Autowired
    protected ApiClientOptions apiClientOptions;

    @Bean
    public JwkViewResolver jwkViewResolver() {
        JwkViewResolver res = new JwkViewResolver();
        res.setJwkViewName(JWKSetView.VIEWNAME);
        res.setJwk(jwkSetView());
        return res;
    }

    @Bean
    public JWKSetView jwkSetView() {
        return new JWKSetView();
    }

    @Bean
    public JWKSetKeyStore keyStore() {
        JWKSetKeyStore jwkSetKeyStore = new JWKSetKeyStore();
        jwkSetKeyStore.setLocation(new FileSystemResource(apiClientOptions.getJwksPath()));
        return jwkSetKeyStore;
    }
}
