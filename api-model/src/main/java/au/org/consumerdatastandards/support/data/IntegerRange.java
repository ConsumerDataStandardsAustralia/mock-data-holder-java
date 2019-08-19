package au.org.consumerdatastandards.support.data;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface IntegerRange {

    int max() default Integer.MAX_VALUE;

    int min() default Integer.MIN_VALUE;
}
