package au.org.consumerdatastandards.support.util;

import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.CustomAttribute;
import au.org.consumerdatastandards.support.data.CustomAttributes;
import au.org.consumerdatastandards.support.model.ModelBase;

import java.lang.reflect.AnnotatedElement;
import java.util.*;

public class CustomAttributesUtil {

    public static void addCustomAttributes(AnnotatedElement annotatedElement, ModelBase model) {

        CustomAttribute customAttribute = annotatedElement.getAnnotation(CustomAttribute.class);
        if (customAttribute != null) {
            model.add(customAttribute);
        }
        CustomAttributes customAttributes = annotatedElement.getAnnotation(CustomAttributes.class);
        if (customAttributes != null) {
            model.addAll(customAttributes.value());
        }
    }

    public static Map<String, Object> getGroupedAttributes(AnnotatedElement annotatedElement) {

        Set<CustomAttribute> attributes = new TreeSet<>(Comparator.comparing(attribute -> (attribute.name() + attribute.value())));
        CustomAttribute customAttribute = annotatedElement.getAnnotation(CustomAttribute.class);
        if (customAttribute != null) {
            attributes.add(customAttribute);
        }
        CustomAttributes customAttributes = annotatedElement.getAnnotation(CustomAttributes.class);
        if (customAttributes != null) {
            Collections.addAll(attributes, customAttributes.value());
        }
        
        Map<String,Object> groupedAttributes = getGroupedAttributes(attributes);
        
        /**
         * Now inject cds-type
         */
        
        CDSDataType cdsDataType = annotatedElement.getAnnotation(CDSDataType.class);
        if(cdsDataType != null) {
            groupedAttributes.put("x-cds-type", cdsDataType.value().getName());
        }
        
        return groupedAttributes;
        
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> getGroupedAttributes(Set<CustomAttribute> attributes) {
        Map<String, Object> map = new LinkedHashMap<>();
        for (CustomAttribute attribute : attributes) {
            if (attribute.multiple()) {
                Set<String> values = new TreeSet<>();
                if (map.get(attribute.name()) != null) {
                    values = (Set<String>)map.get(attribute.name());
                }
                values.add(attribute.value());
                map.put(attribute.name(), values);
            } else {
                map.put(attribute.name(), attribute.value());
            }
        }
        return map;
    }

}
