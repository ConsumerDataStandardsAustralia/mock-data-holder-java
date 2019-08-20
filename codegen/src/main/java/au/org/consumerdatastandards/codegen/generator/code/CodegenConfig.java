package au.org.consumerdatastandards.codegen.generator.code;

import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodegenConfig {
    
    private List<AbstractHandlerConfig> handlerConfigs = new ArrayList<AbstractHandlerConfig>();
    
    private Map<String,String> typeMappings = new HashMap<String,String>();
    
    private Map<String,String> globalVariables = new HashMap<String,String>();

    List<AbstractHandlerConfig> getHandlerConfigs() {
        return handlerConfigs;
    }
    
    public String getTypeMapping(String inputType, String inputValue) {
        return String.format(typeMappings.get(inputType), inputValue);
    }

    public String getTypeMapping(String inputType) {
        return typeMappings.get(inputType) != null ? typeMappings.get(inputType) : inputType;
    }
    
    public boolean hasTypeMapping(String simpleName) {
        return typeMappings.containsKey(simpleName);
    }

    public Map<String, String> getGlobalVariables() {
        return globalVariables;
    }
}
