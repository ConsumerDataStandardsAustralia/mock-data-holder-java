package au.org.consumerdatastandards.support;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Section {

    String name();

    String[] tags();
}
