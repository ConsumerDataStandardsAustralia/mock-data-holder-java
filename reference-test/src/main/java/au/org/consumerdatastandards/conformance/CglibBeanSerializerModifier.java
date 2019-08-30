package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import java.util.ArrayList;
import java.util.List;

public class CglibBeanSerializerModifier extends BeanSerializerModifier {

    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
        if (beanDesc.getBeanClass().getSimpleName().endsWith(ConformanceUtil.GENERATED_CLASS_SUFFIX)) {
            List<BeanPropertyWriter> cglibPropertyWriters = new ArrayList<>();
            for(BeanPropertyWriter propertyWriter : beanProperties) {
                cglibPropertyWriters.add(propertyWriter.rename(new CglibPropertyNameTransformer()));
            }
            return cglibPropertyWriters;
        }
        return super.changeProperties(config, beanDesc, beanProperties);
    }
}
