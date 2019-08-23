package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;

import java.util.ArrayList;
import java.util.List;

public class CglibBeanDeserializerModifier extends BeanDeserializerModifier {

    @Override
    public List<BeanPropertyDefinition> updateProperties(DeserializationConfig config,
                                                         BeanDescription beanDesc,
                                                         List<BeanPropertyDefinition> propDefs) {

        if (beanDesc.getBeanClass().getSimpleName().endsWith(ConformanceUtil.GENERATED_CLASS_SUFFIX)) {
            List<BeanPropertyDefinition> renamedPropDefs = new ArrayList<>();
            for(BeanPropertyDefinition propDef : propDefs) {
                renamedPropDefs.add(propDef.withSimpleName(propDef.getName().replace(ConformanceUtil.GENERATED_PROPERTY_PREFIX, "")));
            }
            return renamedPropDefs;
        }
        return super.updateProperties(config, beanDesc, propDefs);
    }
}
