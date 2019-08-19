package au.org.consumerdatastandards.support;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface DataAttribute {

    String requestParameter();

    boolean required() default false;

    DataAttributeMatcher matchMethod() default DataAttributeMatcher.EQUAL;
}
