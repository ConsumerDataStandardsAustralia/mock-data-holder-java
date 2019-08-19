package au.org.consumerdatastandards.support.security;


import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface EndpointAuth {

    EndpointAuthType type();

    Scope[] scopes();

    EndpointAuthAccess access();
}
