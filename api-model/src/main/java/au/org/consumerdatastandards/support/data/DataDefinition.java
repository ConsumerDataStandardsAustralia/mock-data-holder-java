package au.org.consumerdatastandards.support.data;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface DataDefinition {
    boolean referenced() default true;
    String description() default "";
    Class<?>[] allOf() default {};
    String[] anyOf() default {};
}
