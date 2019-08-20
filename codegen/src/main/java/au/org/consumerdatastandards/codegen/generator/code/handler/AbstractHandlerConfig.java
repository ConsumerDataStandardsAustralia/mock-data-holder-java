package au.org.consumerdatastandards.codegen.generator.code.handler;

import au.org.consumerdatastandards.codegen.generator.code.handler.datadefinition.DataDefinitionHandlerConfig;
import au.org.consumerdatastandards.codegen.generator.code.handler.generic.GenericHandlerConfig;
import au.org.consumerdatastandards.codegen.generator.code.handler.section.SectionHandlerConfig;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Map;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({ 
    @Type(name = "DataDefinitionHandler", value = DataDefinitionHandlerConfig.class),
    @Type(name = "GenericHandler", value = GenericHandlerConfig.class),
    @Type(name = "SectionHandler", value = SectionHandlerConfig.class)
})
public abstract class AbstractHandlerConfig {

    protected String baseDirectory;

    protected Map<String, Object> additionalAttributes;

    public String getBaseDirectory() {
        return baseDirectory;
    }

    public Map<String, Object> getAdditionalAttributes() {
        return additionalAttributes;
    }
}
