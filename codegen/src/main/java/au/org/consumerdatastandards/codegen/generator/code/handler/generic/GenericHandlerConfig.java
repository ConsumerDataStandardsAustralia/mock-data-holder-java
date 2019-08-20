package au.org.consumerdatastandards.codegen.generator.code.handler.generic;

import java.util.Map;

import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;

public class GenericHandlerConfig extends AbstractHandlerConfig {
    
    private Map<String,String> fileMapping;

    public Map<String, String> getFileMapping() {
        return fileMapping;
    }
}
