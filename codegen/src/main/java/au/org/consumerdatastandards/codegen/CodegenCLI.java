package au.org.consumerdatastandards.codegen;

import au.org.consumerdatastandards.codegen.code.CodeGeneratorConfig;
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

import static java.util.ServiceLoader.load;

public class CodegenCLI {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodegenCLI.class);
    private static final String BASE_PACKAGE = "au.org.consumerdatastandards.codegen";
    private static Reflections reflections = new Reflections(BASE_PACKAGE);
    private static Set<Class<? extends AbstractGenerator>> generators = reflections.getSubTypesOf(AbstractGenerator.class);

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
            for (Class<? extends AbstractGenerator> generator: generators) {
                JCommander.getConsole().println(" - " + generator.getSimpleName());
            }
        }
        if (options.isListCodegenTypes()) {
            listing = true;
            JCommander.getConsole().println("Codegen Types:");
            for (CodeGeneratorConfig config: load(CodeGeneratorConfig.class)) {
                JCommander.getConsole().println(" - " + config.getName());
            }
        }
        if (!listing) {
            AbstractGenerator<?> generator = getGenerator(options.getGeneratorName(), apiModel);
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

    private static AbstractGenerator<?> getGenerator(String generatorName, APIModel apiModel) {

        if (StringUtils.isBlank(generatorName)) {
            throw new ParameterException("You must supply a generator name");
        }

        try {
            Class<? extends AbstractGenerator> targetGenerator = null;
            for (Class<? extends AbstractGenerator> generator : generators) {
                if (generator.getSimpleName().equals(generatorName)) {
                    targetGenerator = generator;
                    break;
                }
            }
            if (targetGenerator == null) {
                String message = String.format("The specified generator of \"%s\" is not found", generatorName);
                throw new ParameterException(message);
            }
            return (AbstractGenerator<?>) targetGenerator.getConstructor(APIModel.class).newInstance(apiModel);
        } catch (InvocationTargetException | NoSuchMethodException | ClassCastException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | SecurityException e) {
            String message = String.format("Unable to instantiate requested class %s due to: %s",
                generatorName, e.getCause());
            throw new ParameterException(message);
        }
    }
}
