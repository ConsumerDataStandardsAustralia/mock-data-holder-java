package au.org.consumerdatastandards.holder;

import au.org.consumerdatastandards.holder.configuration.CustomParamNamesDiscoverer;
import au.org.consumerdatastandards.holder.util.SwaggerJacksonModuleRegistrar;
import com.fasterxml.jackson.databind.Module;
import org.apache.catalina.connector.Connector;
import org.h2.server.web.WebServlet;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;

/**
 * We are excluding {@link SecurityAutoConfiguration} and {@link UserDetailsServiceAutoConfiguration}
 * to disable spring default basic authentication.
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
@ComponentScan(basePackages = {
    "au.org.consumerdatastandards.holder.api",
    "au.org.consumerdatastandards.holder.repository",
    "au.org.consumerdatastandards.holder.configuration",
    "au.org.consumerdatastandards.holder.service",
    "au.org.consumerdatastandards.holder.util",
})
public class HolderApplication implements CommandLineRunner {

    @Value("${server.http.port:0}")
    private int httpPort;

    public static void main(String[] args) {
        new SpringApplication(HolderApplication.class).run(args);
    }

    @Override
    public void run(String... arg0) {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
    
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON); 
    }

    @Bean
    public Module jsonNullableModule() {
        return new JsonNullableModule();
    }

    @Bean
    public ServletRegistrationBean<WebServlet> h2servletRegistration() {
        ServletRegistrationBean<WebServlet> registration = new ServletRegistrationBean<>(new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }
    
    @Bean
    public SwaggerJacksonModuleRegistrar swaggerJacksonModuleRegistrar() {
        return new SwaggerJacksonModuleRegistrar();
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> containerCustomizer() {
        if (httpPort == 0) {
            return null;
        }
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setPort(httpPort);
        return containerFactory -> containerFactory.addAdditionalTomcatConnectors(connector);
    }
    @Bean
    public static LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setParameterNameDiscoverer(new CustomParamNamesDiscoverer());
        MessageInterpolatorFactory interpolatorFactory = new MessageInterpolatorFactory();
        factoryBean.setMessageInterpolator(interpolatorFactory.getObject());
        return factoryBean;
    }
}
