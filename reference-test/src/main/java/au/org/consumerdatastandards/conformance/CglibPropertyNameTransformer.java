package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;

public class CglibPropertyNameTransformer extends NameTransformer {

    @Override
    public String transform(String name) {
        return name.replace(ConformanceUtil.GENERATED_PROPERTY_PREFIX, "");
    }

    @Override
    public String reverse(String transformed) {
        return null;
    }
}
