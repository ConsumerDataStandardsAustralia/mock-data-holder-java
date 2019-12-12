package au.org.consumerdatastandards.holder.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

@EnableWebSecurity
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}") String jwkSetUri;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .and().authorizeRequests()
            .antMatchers("/**/banking/products/**").permitAll()
            .antMatchers("/**/banking/accounts").access("hasAuthority('SCOPE_bank:accounts.basic:read')")
            .antMatchers("/**/banking/accounts/balances").access("hasAuthority('SCOPE_bank:accounts.basic:read')")
            .antMatchers("/**/banking/accounts/**/balance").access("hasAuthority('SCOPE_bank:accounts.basic:read')")
            .antMatchers("/**/banking/accounts/**").access("hasAuthority('SCOPE_bank:accounts.detail:read')")
            .antMatchers("/**/banking/accounts/**/transactions/**").access("hasAuthority('SCOPE_bank:transactions:read')")
            .antMatchers("/**/banking/payees/**").access("hasAuthority('SCOPE_bank:payees:read')")
            .antMatchers("/**/banking/**/direct-debits/**").access("hasAuthority('SCOPE_bank:regular_payments:read')")
            .antMatchers("/**/common/customer").access("hasAuthority('SCOPE_common:customer.basic:read')")
            .antMatchers("/**/common/customer/detail").access("hasAuthority('SCOPE_common:customer.detail:read')")
            .and().oauth2ResourceServer().jwt();
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build();
    }
}
