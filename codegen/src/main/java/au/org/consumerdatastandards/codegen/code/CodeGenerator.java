package au.org.consumerdatastandards.codegen.code;

import au.org.consumerdatastandards.codegen.AbstractGenerator;
import au.org.consumerdatastandards.support.model.APIModel;

public class CodeGenerator extends AbstractGenerator<CodeGeneratorOptions> {

    public CodeGenerator(APIModel apiModel) {
        super(apiModel);
    }

    @Override
    public void generate() throws Exception {

    }

    @Override
    protected CodeGeneratorOptions createOptions() {
        return new CodeGeneratorOptions();
    }
}
