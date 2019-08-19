package au.org.consumerdatastandards.support;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface Param {

    String name();

    ParamLocation in();

    boolean required() default false;

    String description() default "";

    String defaultValue() default "";

    String reference() default "";
        
}
