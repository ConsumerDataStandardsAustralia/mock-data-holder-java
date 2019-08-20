package au.org.consumerdatastandards.codegen.generator.velocity.model;

import java.util.Arrays;

import org.apache.velocity.shaded.commons.io.FilenameUtils;

import au.org.consumerdatastandards.codegen.generator.code.handler.AbstractHandlerConfig;

public class VelocityFile {

    String name;
    String path;
    String velocityTemplate;
    AbstractHandlerConfig config;
    Object context;

    public VelocityFile(String inputFilename, String inputPath, String inputVelocityTemplate, AbstractHandlerConfig modelConfig, Object renderingContext) {
        this.name = inputFilename;
        this.path = inputPath;
        this.velocityTemplate = inputVelocityTemplate;
        this.config = modelConfig;
        this.context = renderingContext;
    }

    public String getFullPath() {
        return FilenameUtils.normalize(String.join("/", Arrays.asList(getPath(), getName())));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getVelocityTemplate() {
        return velocityTemplate;
    }

    public void setVelocityTemplate(String velocityTemplate) {
        this.velocityTemplate = velocityTemplate;
    }

    public AbstractHandlerConfig getConfig() {
        return config;
    }

    public Object getContext() {
        return context;
    }

}
