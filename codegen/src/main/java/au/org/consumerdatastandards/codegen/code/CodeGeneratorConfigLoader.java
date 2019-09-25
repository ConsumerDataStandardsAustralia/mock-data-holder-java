package au.org.consumerdatastandards.codegen.code;

import java.util.ServiceLoader;

import static java.util.ServiceLoader.load;

public class CodeGeneratorConfigLoader {

    public static CodeGeneratorConfig forName(String name) {

        ServiceLoader<CodeGeneratorConfig> loader = load(CodeGeneratorConfig.class);

        StringBuilder availableTypes = new StringBuilder();

        for (CodeGeneratorConfig type : loader) {
            if (type.getName().equals(name)) {
                return type;
            }
            availableTypes.append(type.getName()).append("\n");
        }
        // else try to load directly
        try {
            return (CodeGeneratorConfig) Class.forName(name).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Can't load type class with name ".concat(name) + " Available: " + availableTypes.toString(), e);
        }
    }
}
