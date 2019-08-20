package au.org.consumerdatastandards.codegen.generator.code;

import au.org.consumerdatastandards.codegen.generator.AbstractGenerator;
import au.org.consumerdatastandards.codegen.generator.CodegenModel;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandler;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;
import au.org.consumerdatastandards.codegen.util.ModelCodegenConverter;
import au.org.consumerdatastandards.support.model.APIModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Set;

public class CodeGenerator extends AbstractGenerator<CodegenOptions> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CodeGenerator.class);
    private final static String BASE_PACKAGE = "au.org.consumerdatastandards";
    
    public CodeGenerator(APIModel apiModel) {
        super(apiModel);
    }

    @Override
    public void generate() throws Exception {
        CodegenModel codegenModel = ModelCodegenConverter.convert(apiModel);
        generate(codegenModel);
    }

    public void generate(CodegenModel codegenModel) throws Exception {
        
        LOGGER.debug("Using config file of {} for CodegenModel generation", options.getConfigFilePath());
        
        File configFile = new File(options.getConfigFilePath());
        InputStream configFileStream;
        
        if(configFile.isFile()) {
            configFileStream = new FileInputStream(configFile);
        } else {
            LOGGER.debug("Attempting to retrieve config file {} from resource path", options.getConfigFilePath());
            configFileStream = getClass().getClassLoader().getResourceAsStream(options.getConfigFilePath());
        }
        
        if(configFileStream == null) {
            LOGGER.error("Unable to locate target JSON configuration: {}", configFile.getPath());
            throw new Exception("Unable to open target JSON configuration file.");
        }

        LOGGER.debug("Starting velocity rendering to output path of {}",  options.getOutputPath());
        VelocityHelper velocityHelper = new VelocityHelper(options.getOutputPath());
        ObjectMapper objectMapper = new ObjectMapper();
        CodegenConfig targetConfig = objectMapper.readValue(configFileStream, CodegenConfig.class);
        
        for(AbstractHandlerConfig handlerConfig : targetConfig.getHandlerConfigs()) {
            Reflections reflections = new Reflections(BASE_PACKAGE);
            Set<Class<? extends AbstractHandler>> handlerClasses = reflections.getSubTypesOf(AbstractHandler.class);
            
            for(Class<? extends AbstractHandler> oneHandler : handlerClasses) {
                if(oneHandler.newInstance().matchConfig(handlerConfig)) {
                    LOGGER.debug("Processing models using handler {}", oneHandler.getSimpleName());
                    AbstractHandler<?> myHandler = oneHandler.newInstance();
                    myHandler.setConfig(handlerConfig);
                    myHandler.setCodegenConfig(targetConfig);
                    myHandler.setCodegenModel(codegenModel);
                    myHandler.setCodegenOptions(options);
                    myHandler.populateVelocityFiles(velocityHelper);
                }
            }
        }
        
        /*
          We now have all velocity files ready for writing

          TODO: Add postProcessing hook to allow further modifications
         */
        LOGGER.debug("Initiating velocity file writer to {}",  velocityHelper.basePath);
        velocityHelper.writeFiles();
    }

    @Override
    protected CodegenOptions createOptions() {
        return new CodegenOptions();
    }
}
