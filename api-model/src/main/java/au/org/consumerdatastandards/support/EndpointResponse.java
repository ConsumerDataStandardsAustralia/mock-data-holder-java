package au.org.consumerdatastandards.support;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface EndpointResponse {

    String description() default "";

    ResponseCode responseCode();

    Class<?> content() default Void.class;
}
