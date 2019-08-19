package au.org.consumerdatastandards.support;

import au.org.consumerdatastandards.support.security.EndpointAuth;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Endpoint {

    String summary();

    String description();

    RequestMethod requestMethod();

    String path();

    EndpointResponse[] responses();

    EndpointAuth[] requiredAuth() default {};

    String operationId();
}
