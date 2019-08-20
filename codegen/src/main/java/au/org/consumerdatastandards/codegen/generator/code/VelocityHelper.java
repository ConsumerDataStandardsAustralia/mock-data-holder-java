package au.org.consumerdatastandards.codegen.generator.code;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.ToolContext;
import org.apache.velocity.tools.ToolManager;
import org.apache.velocity.tools.generic.MathTool;

import com.google.common.base.CaseFormat;
import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import com.google.googlejavaformat.java.JavaFormatterOptions;
import com.google.googlejavaformat.java.JavaFormatterOptions.Style;

import au.org.consumerdatastandards.codegen.generator.velocity.model.VelocityFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VelocityHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(VelocityHelper.class);

    private Set<VelocityFile> velocityFiles = new LinkedHashSet<>();
    public String basePath;

    public void addFile(VelocityFile inputVelocityFile) {
        LOGGER.debug("Adding velocity file {} with output path of {}", inputVelocityFile.getVelocityTemplate(),
            inputVelocityFile.getFullPath());
        velocityFiles.add(inputVelocityFile);
    }

    VelocityHelper(String inputPath) {
        basePath = inputPath;
    }

    public String renderTemplate(VelocityFile velocityFile) {
        LOGGER.debug("Initiating file rendering of {}", velocityFile.getVelocityTemplate());
        StringWriter resultWriter = new StringWriter();

        VelocityEngine ve = new VelocityEngine();
        ve.setProperty("resource.loader.file.class", ClasspathResourceLoader.class.getName());
        ve.init();

        Template t = ve.getTemplate(velocityFile.getVelocityTemplate());
        ToolManager manager = new ToolManager(true, true);
        manager.setVelocityEngine(ve);

        ToolContext context = manager.createContext();
        context.put("cg", velocityFile.getConfig());
        context.put("cds", velocityFile.getContext());
        context.put("StringUtils", StringUtils.class);
        context.put("WordUtils", WordUtils.class);
        context.put("MathTool", new MathTool());
        context.put("CaseFormat", CaseFormat.class);

        for (Entry<String, Object> oneEntry : velocityFile.getConfig().getAdditionalAttributes().entrySet()) {
            context.put(oneEntry.getKey(), oneEntry.getValue());
        }

        t.merge(context, resultWriter);

        if (velocityFile.getFullPath().endsWith("java")) {
            try {
                return new Formatter(JavaFormatterOptions.builder().style(Style.GOOGLE).build())
                    .formatSource(resultWriter.toString());
            } catch (FormatterException e) {
                LOGGER.warn("Attempted to perform Java formatting on {} and didn't succeed", velocityFile.getFullPath());
                StringWriter myWriter = new StringWriter();
                e.printStackTrace(new PrintWriter(myWriter));
                LOGGER.warn(myWriter.toString());
                return resultWriter.toString();
            }
        }

        return resultWriter.toString();
    }

    void writeFiles() {

        for (VelocityFile oneFile : velocityFiles) {
            LOGGER.debug("Initiating VelocityFile writer for {}", oneFile.getFullPath());
            try {
                Files.createDirectories(Paths.get(oneFile.getPath()));
                FileWriter outputFileWriter = new FileWriter(oneFile.getFullPath());

                outputFileWriter.write(renderTemplate(oneFile));
                outputFileWriter.close();

                LOGGER.info("Wrote file: " + oneFile.getFullPath());

            } catch (IOException e) {
                LOGGER.error("Error occurred while attempting to write file {}", oneFile.getFullPath());
                LOGGER.error(e.getMessage(), e);
            }
        }
    }
}
