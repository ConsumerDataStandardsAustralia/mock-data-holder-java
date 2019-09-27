package au.org.consumerdatastandards.support.model;

import au.org.consumerdatastandards.support.data.CustomAttribute;
import au.org.consumerdatastandards.support.util.CustomAttributesUtil;

import java.util.*;

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

    public String getCustomAttributeValue(String customAttributeName) {
        Object value = getGroupedAttributes().get(customAttributeName);
        if (value == null) return null;
        if (value instanceof String) return (String)value;
        if (value instanceof Collection) {
            Collection collection = (Collection)value;
            if (collection.size() > 1) throw new RuntimeException("Unexpected multiple values");
            if (collection.isEmpty()) return null;
            return collection.iterator().next().toString();
        }
        throw new RuntimeException("Unexpected value type");
    }

    public String[] getCustomAttributeValues(String customAttributeName) {
        Object value = getGroupedAttributes().get(customAttributeName);
        if (value == null) return new String[0];
        if (value instanceof String) return new String[]{(String)value};
        if (value instanceof Collection) {
            Collection collection = (Collection)value;
            String[] values = new String[collection.size()];
            int i = 0;
            for (Object e : collection) {
                values[i++] = e.toString();
            }
            return values;
        }
        throw new RuntimeException("Unexpected value type");
    }
}
