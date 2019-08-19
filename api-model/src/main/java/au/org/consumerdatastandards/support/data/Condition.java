package au.org.consumerdatastandards.support.data;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Condition {

    String propertyName();

    String[] values();

    ConditionalCDSDataType[] conditionalCDSDataTypes() default {};
}
