package au.org.consumerdatastandards.codegen;

import au.org.consumerdatastandards.codegen.generator.AbstractGenerator;
import au.org.consumerdatastandards.codegen.generator.Options;
import au.org.consumerdatastandards.support.model.APIModel;
import au.org.consumerdatastandards.support.model.ModelBuilder;
import au.org.consumerdatastandards.support.model.SectionModel;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class CodegenCLI {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodegenCLI.class);
    private static final String BASE_PACKAGE = "au.org.consumerdatastandards.codegen.generator";

    public static void main(String[] args) {
        Options options = new Options();
        JCommander commander = JCommander.newBuilder().addObject(options).build();
        commander.setProgramName(CodegenCLI.class.getSimpleName());
        commander.setAcceptUnknownOptions(true);
        commander.parse(args);

        ModelBuilder modelBuilder = new ModelBuilder(options);
        APIModel apiModel = modelBuilder.build();
        boolean listing = false;
        if (options.isListSections()) {
            listing = true;
            JCommander.getConsole().println("Sections:");
            for (SectionModel sectionModel : apiModel.getSectionModels()) {
                JCommander.getConsole().println(" - " + sectionModel.getName());
            }
        }
        if (options.isListGenerators()) {
            listing = true;
            JCommander.getConsole().println("Generators:");
            Reflections reflections = new Reflections(BASE_PACKAGE);
            Set<Class<? extends AbstractGenerator>> generators = reflections.getSubTypesOf(AbstractGenerator.class);
            for (Class<? extends AbstractGenerator> generator: generators) {
                JCommander.getConsole().println(" - " + generator.getName());
            }
        }
        if (!listing) {
            AbstractGenerator<?> generator = getGenerator(options.getGeneratorClassName(), apiModel);

            try {
                generator.populateOptions(args);
                if (options.isHelp()) {
                    printHelp(commander, generator);
                } else {
                    generator.generate();
                }
            } catch (ParameterException | IllegalAccessException | InstantiationException e) {
                LOGGER.error("Invalid parameter exception: {}", e.getMessage());
                printHelp(commander, generator);
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
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
