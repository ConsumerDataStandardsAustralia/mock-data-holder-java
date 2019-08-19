package au.org.consumerdatastandards.support.model;

import au.org.consumerdatastandards.support.data.CustomAttribute;
import au.org.consumerdatastandards.support.util.CustomAttributesUtil;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ModelBase {

    protected Set<CustomAttribute> attributes = new TreeSet<>(Comparator.comparing(attribute -> (attribute.name() + attribute.value())));

    public void add(CustomAttribute customAttribute) {

        attributes.add(customAttribute);
    }

    public void addAll(CustomAttribute[] customAttributes) {

        for (CustomAttribute customAttribute : customAttributes) {
            add(customAttribute);
        }
    }

    public Map<String, Object> getGroupedAttributes() {

        return CustomAttributesUtil.getGroupedAttributes(attributes);
    }
}
