package au.org.consumerdatastandards.codegen.generator.code.handler.section;

import au.org.consumerdatastandards.codegen.generator.CodegenSection;
import au.org.consumerdatastandards.codegen.generator.code.VelocityHelper;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandler;
import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;
import au.org.consumerdatastandards.codegen.generator.velocity.model.VelocityFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class SectionHandler extends AbstractHandler<SectionHandlerConfig> {

    private static final Logger LOG = LoggerFactory.getLogger(SectionHandler.class);

    @Override
    public boolean matchConfig(AbstractHandlerConfig inputConfig) {
        return inputConfig instanceof SectionHandlerConfig;
    }

    @Override
    public void setConfig(AbstractHandlerConfig inputConfig) {
        config = (SectionHandlerConfig) inputConfig;
    }

    @Override
    public Class<?> getAbstractHandlerConfigClass() {
        return SectionHandlerConfig.class;
    }
    
    @Override
    public void populateVelocityFiles(VelocityHelper velocityHelper) throws IOException {
       for (CodegenSection codegenSection : codegenModel.getCodegenSections()) {
            // We reparse the config with the section data
            SectionHandlerConfig modelConfig = perModelConfig(codegenSection);
            LOG.debug("Writing file to {}/{}/{} with template {}", options.getOutputPath(), modelConfig.getBaseDirectory(), modelConfig.filePath, modelConfig.templateFile);
            VelocityFile oneFile = new VelocityFile(modelConfig.fileName,
                    String.format("%s/%s/%s", options.getOutputPath(), modelConfig.getBaseDirectory(), modelConfig.filePath),
                    modelConfig.templateFile, modelConfig, codegenSection);
            velocityHelper.addFile(oneFile);
        }
    }
}
