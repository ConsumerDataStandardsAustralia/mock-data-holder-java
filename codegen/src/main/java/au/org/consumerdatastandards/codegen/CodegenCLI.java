package au.org.consumerdatastandards.codegen;

import au.org.consumerdatastandards.codegen.generator.AbstractGenerator;
import au.org.consumerdatastandards.codegen.generator.Options;
import au.org.consumerdatastandards.support.model.APIModel;
import au.org.consumerdatastandards.support.model.ModelBuilder;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

public class CodegenCLI {

    private static final Logger LOG = LoggerFactory.getLogger(CodegenCLI.class);

    public static void main(String[] args) {
        Options options = new Options();
        JCommander commander = JCommander.newBuilder().addObject(options).build();
        commander.setProgramName(CodegenCLI.class.getSimpleName());
        commander.setAcceptUnknownOptions(true);
        commander.parse(args);

        ModelBuilder modelBuilder = new ModelBuilder(options);
        APIModel apiModel = modelBuilder.build();
        AbstractGenerator<?> generator = getGenerator(options.getGeneratorClassName(), apiModel);

        try {
            generator.populateOptions(args);
            if (options.isHelp()) {
                printHelp(commander, generator);
            } else {
                generator.generate();
            }
        } catch (ParameterException | IllegalAccessException | InstantiationException e) {
            LOG.error("Invalid parameter exception: {}", e.getMessage());
            printHelp(commander, generator);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private static void printHelp(JCommander commander, AbstractGenerator<?> generator) {
        if (generator.hasOptions()) generator.usage();
        else commander.usage();
    }

    private static AbstractGenerator<?> getGenerator(String generatorClassName, APIModel apiModel) {

        if (StringUtils.isBlank(generatorClassName)) {
            throw new ParameterException("You must supply a generator name");
        }

        try {
            Class<?> targetGenerator = Class.forName(generatorClassName);
            return (AbstractGenerator<?>) targetGenerator.getConstructor(APIModel.class).newInstance(apiModel);
        } catch (ClassNotFoundException e) {
            String message = String.format("The specified generator of \"%s\" is not found", generatorClassName);
            throw new ParameterException(message);
        } catch (InvocationTargetException | NoSuchMethodException | ClassCastException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | SecurityException e) {
            String message = String.format("Unable to instantiate requested class %s due to: %s",
                generatorClassName, e.getCause());
            throw new ParameterException(message);
        }
    }

}
