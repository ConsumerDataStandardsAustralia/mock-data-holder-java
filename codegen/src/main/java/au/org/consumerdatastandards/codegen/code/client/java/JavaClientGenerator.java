package au.org.consumerdatastandards.codegen.code.client.java;

import au.org.consumerdatastandards.codegen.AbstractGenerator;
import au.org.consumerdatastandards.codegen.code.CodeGeneratorOptions;
import au.org.consumerdatastandards.support.model.APIModel;

public class JavaClientGenerator extends AbstractGenerator<CodeGeneratorOptions> {

    private static final String DEFAULT_BASE_PACKAGE = "au.org.consumerdatastandards.client";
    private static final String DEFAULT_API_PACKAGE = DEFAULT_BASE_PACKAGE + ".api";
    private static final String DEFAULT_MODEL_PACKAGE = DEFAULT_BASE_PACKAGE + ".model";

    public JavaClientGenerator(APIModel apiModel) {
        super(apiModel);
    }

    @Override
    public void generate() throws Exception {

    }

    @Override
    protected CodeGeneratorOptions createOptions() {
        CodeGeneratorOptions codeGeneratorOptions = new CodeGeneratorOptions();
        codeGeneratorOptions.setBasePackage(DEFAULT_BASE_PACKAGE);
        codeGeneratorOptions.setApiPackage(DEFAULT_API_PACKAGE);
        codeGeneratorOptions.setModelPackage(DEFAULT_MODEL_PACKAGE);
        return codeGeneratorOptions;
    }
}
