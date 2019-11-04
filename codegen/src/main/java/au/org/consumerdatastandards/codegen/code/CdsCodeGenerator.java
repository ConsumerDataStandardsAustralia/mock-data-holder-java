package au.org.consumerdatastandards.codegen.code;

import au.org.consumerdatastandards.codegen.code.java.JavaCodegenBase;
import io.swagger.codegen.CodegenModel;
import io.swagger.codegen.DefaultGenerator;
import io.swagger.codegen.languages.AbstractJavaCodegen;
import io.swagger.models.ComposedModel;
import io.swagger.models.Model;
import io.swagger.models.RefModel;
import io.swagger.util.Json;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.*;

import static io.swagger.codegen.CodegenConstants.*;

public class CdsCodeGenerator extends DefaultGenerator {

    public CdsCodeGenerator() {
        this.setGenerateSwaggerMetadata(false);
        this.setGeneratorPropertyDefault(MODEL_DOCS, "false");
        this.setGeneratorPropertyDefault(API_DOCS, "false");
        this.setGeneratorPropertyDefault(API_TESTS, "false");
    }

    @Override
    protected void generateModels(List<File> files, List<Object> allModels) {
        if (!isGenerateModels) {
            return;
        }

        final Map<String, Model> definitions = swagger.getDefinitions();
        if (definitions == null) {
            return;
        }

        String modelNames = System.getProperty("models");
        Set<String> modelsToGenerate = null;
        if (modelNames != null && !modelNames.isEmpty()) {
            modelsToGenerate = new HashSet<>(Arrays.asList(modelNames.split(",")));
        }

        Set<String> modelKeys = definitions.keySet();
        if (modelsToGenerate != null && !modelsToGenerate.isEmpty()) {
            Set<String> updatedKeys = new HashSet<String>();
            for (String m : modelKeys) {
                if (modelsToGenerate.contains(m)) {
                    updatedKeys.add(m);
                }
            }
            modelKeys = updatedKeys;
        }

        // store all processed models
        Map<String, Object> allProcessedModels = new TreeMap<String, Object>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Model model1 = definitions.get(o1);
                Model model2 = definitions.get(o2);

                int model1InheritanceDepth = getInheritanceDepth(model1);
                int model2InheritanceDepth = getInheritanceDepth(model2);

                if (model1InheritanceDepth == model2InheritanceDepth) {
                    return ObjectUtils.compare(config.toModelName(o1), config.toModelName(o2));
                } else if (model1InheritanceDepth > model2InheritanceDepth) {
                    return 1;
                } else {
                    return -1;
                }
            }

            private int getInheritanceDepth(Model model) {
                int inheritanceDepth = 0;
                Model parent = getParent(model);

                while (parent != null) {
                    inheritanceDepth++;
                    parent = getParent(parent);
                }

                return inheritanceDepth;
            }

            private Model getParent(Model model) {
                if (model instanceof ComposedModel) {
                    Model parent = ((ComposedModel) model).getParent();
                    if (parent == null) {
                        // check for interfaces
                        List<RefModel> interfaces = ((ComposedModel) model).getInterfaces();
                        if (interfaces.size() > 0) {
                            RefModel interf = interfaces.get(0);
                            return definitions.get(interf.getSimpleRef());
                        }
                    }
                    if (parent != null) {
                        return definitions.get(parent.getReference());
                    }
                }

                return null;
            }
        });

        // process models only
        for (String name : modelKeys) {
            try {
                //don't generate models that have an import mapping
                if (config.importMapping().containsKey(name)) {
                    LOGGER.info("Model " + name + " not imported due to import mapping");
                    continue;
                }
                Model model = definitions.get(name);
                Map<String, Model> modelMap = new HashMap<String, Model>();
                modelMap.put(name, model);
                Map<String, Object> models = processModels(config, modelMap, definitions);
                if (models != null) {
                    models.put("classname", config.toModelName(name));
                    models.putAll(config.additionalProperties());
                    allProcessedModels.put(name, models);
                }
            } catch (Exception e) {
                String message = "Could not process model '" + name + "'" + ". Please make sure that your schema is correct!";
                LOGGER.error(message, e);
                throw new RuntimeException(message, e);
            }
        }

        // post process all processed models
        allProcessedModels = config.postProcessAllModels(allProcessedModels);

        // generate files based on processed models
        for (String modelName : allProcessedModels.keySet()) {
            Map<String, Object> models = (Map<String, Object>) allProcessedModels.get(modelName);
            models.put("modelPackage", config.modelPackage());
            try {
                //don't generate models that have an import mapping
                if (config.importMapping().containsKey(modelName)) {
                    continue;
                }
                Map<String, Object> modelTemplate = (Map<String, Object>) ((List<Object>) models.get("models")).get(0);
                if (config instanceof AbstractJavaCodegen) {
                    // Special handling of aliases only applies to Java
                    if (modelTemplate != null && modelTemplate.containsKey("model")) {
                        CodegenModel m = (CodegenModel) modelTemplate.get("model");
                        if (m.isAlias) {
                            continue;  // Don't create user-defined classes for aliases
                        }
                    }
                }
                allModels.add(modelTemplate);
                for (String templateName : config.modelTemplateFiles().keySet()) {
                    String suffix = config.modelTemplateFiles().get(templateName);
                    String filename = config.modelFileFolder() + File.separator + config.toModelFilename(modelName) + suffix;
                    CodegenModel cm = (CodegenModel) modelTemplate.get("model");
                    if (cm instanceof JavaCodegenBase.CdsCodegenModel) {
                        JavaCodegenBase.CdsCodegenModel ccm = (JavaCodegenBase.CdsCodegenModel)cm;
                        filename = ccm.getModelFileFolder() + File.separator + config.toModelFilename(modelName) + suffix;
                        models.put("package", ccm.getModelPackage());
                    }
                    if (!config.shouldOverwrite(filename)) {
                        LOGGER.info("Skipped overwriting " + filename);
                        continue;
                    }
                    if (cm.hasVars || !StringUtils.isBlank(cm.parent) || cm.isEnum) {
                        File written = processTemplateToFile(models, templateName, filename);
                        if (written != null) {
                            files.add(written);
                        }
                    }
                }
                if(isGenerateModelTests) {
                    generateModelTests(files, models, modelName);
                }
                if(isGenerateModelDocumentation) {
                    // to generate model documentation files
                    generateModelDocumentation(files, models, modelName);
                }
            } catch (Exception e) {
                throw new RuntimeException("Could not generate model '" + modelName + "'", e);
            }
        }
        if (System.getProperty("debugModels") != null) {
            LOGGER.info("############ Model info ############");
            Json.prettyPrint(allModels);
        }
    }
}
