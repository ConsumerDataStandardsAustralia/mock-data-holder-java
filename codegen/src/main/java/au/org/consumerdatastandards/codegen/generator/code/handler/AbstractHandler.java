package au.org.consumerdatastandards.codegen.generator.code.handler;

import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.generator.code.CodegenOptions;
import au.org.consumerdatastandards.codegen.generator.code.CodegenConfig;
import au.org.consumerdatastandards.codegen.generator.code.VelocityHelper;
import au.org.consumerdatastandards.codegen.generator.code.handler.datadefinition.DataDefinitionHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.velocity.script.VelocityScriptEngineFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public abstract class AbstractHandler<O extends AbstractHandlerConfig> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataDefinitionHandler.class);

    protected O config;
    protected CodegenModel codegenModel;
    protected CodegenConfig codegenConfig;
    protected CodegenOptions options;

    abstract public boolean matchConfig(AbstractHandlerConfig inputConfig);

    abstract public void populateVelocityFiles(VelocityHelper velocityHelper) throws IOException;

    abstract public void setConfig(AbstractHandlerConfig inputConfig);

    public void setCodegenModel(CodegenModel inputCodegen) {
        codegenModel = inputCodegen;
    }

    public void setCodegenOptions(CodegenOptions inputOptions) {
        options = inputOptions;
    }

    public void setCodegenConfig(CodegenConfig inputConfig) {
        codegenConfig = inputConfig;
    }

    private ObjectNode jsonThroughVelocity(ScriptEngine inputEngine, ScriptContext inputContext, ObjectNode rootNode) {
        Iterator<Map.Entry<String, JsonNode>> fields = rootNode.fields();

        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            StringWriter instanceConfigString = new StringWriter();
            inputContext.setWriter(instanceConfigString);

            try {
                if (field.getValue().isValueNode()) {
                    inputEngine.eval(field.getValue().asText());
                    rootNode.put(field.getKey(), instanceConfigString.toString());
                    instanceConfigString.flush();
                } else {
                    rootNode.replace(field.getKey(), jsonThroughVelocity(inputEngine, inputContext, (ObjectNode) field.getValue()));
                }
            } catch (ScriptException e) {
                LOGGER.error("Encountered a script rendering error while doing per model config on: {}", field.getValue().asText());
            }
        }

        return rootNode;
    }

    public Class<?> getAbstractHandlerConfigClass() {
        return config.getClass();
    }

    protected <C extends AbstractHandlerConfig> C perModelConfig(Object inputObject) throws IOException {

        ScriptEngineManager manager = new ScriptEngineManager();
        manager.registerEngineName("velocity", new VelocityScriptEngineFactory());
        ScriptEngine scriptEngine = manager.getEngineByName("velocity");
        ScriptContext thisContext = scriptEngine.getContext();
        thisContext.setAttribute("cds", inputObject, ScriptContext.GLOBAL_SCOPE);
        scriptEngine.setContext(thisContext);


        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(objectMapper.writeValueAsString(config));

        for (Entry<String, String> oneEntry : codegenConfig.getGlobalVariables().entrySet()) {
            thisContext.setAttribute(oneEntry.getKey(), oneEntry.getValue(), ScriptContext.GLOBAL_SCOPE);
        }

        ObjectNode parentObjectNode = jsonThroughVelocity(scriptEngine, thisContext, (ObjectNode) rootNode);

        @SuppressWarnings("unchecked")
        C myConfig = (C) objectMapper.readValue(objectMapper.writeValueAsString(parentObjectNode), getAbstractHandlerConfigClass());

        /*
          Stuff Global config into additionalAttributes for direct access,
          VelocityHelper transfers this to be directly available
         */
        for (Entry<String, String> oneEntry : codegenConfig.getGlobalVariables().entrySet()) {
            myConfig.additionalAttributes.put(oneEntry.getKey(), oneEntry.getValue());
        }

        /*
          Stuff field's into additional values field for direct access
         */
        for (Field declaredField : inputObject.getClass().getDeclaredFields()) {
            declaredField.setAccessible(true);
            try {
                if (!myConfig.additionalAttributes.containsKey(declaredField.getName())) {
                    myConfig.additionalAttributes.put(declaredField.getName(), declaredField.get(inputObject));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                LOGGER.warn("Silently ignoring inability to read {}", declaredField.getName());
            }
        }

        return myConfig;
    }

}