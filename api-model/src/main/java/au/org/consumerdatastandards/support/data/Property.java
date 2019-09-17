package au.org.consumerdatastandards.support.data;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Property {

	String description() default "";

	boolean required() default false;

	Condition[] requiredIf() default {};

	Condition[] nullIf() default {};
}
