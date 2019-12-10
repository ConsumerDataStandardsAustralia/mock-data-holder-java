package au.org.consumerdatastandards.holder.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .and().authorizeRequests()
            .antMatchers("/**/banking/products/**").permitAll()
            .antMatchers("/**/banking/accounts/**").access("hasAuthority('SCOPE_accounts.read')")
            .antMatchers("/**/banking/payees/**").access("hasAuthority('SCOPE_payees.read')")
            .antMatchers("/**/banking/**/direct-debits/**").access("hasAuthority('SCOPE_direct-debits,read')")
            .antMatchers("/**/common/customer/**").access("hasAuthority('SCOPE_customer.read')")
            .and().oauth2ResourceServer().jwt();
    }
}
