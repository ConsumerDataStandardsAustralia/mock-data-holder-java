package au.org.consumerdatastandards.conformance.validator;

import au.org.consumerdatastandards.api.v1_0_0.common.models.CommonOrganisationDetail;
import au.org.consumerdatastandards.api.v1_0_0.common.models.CommonPersonDetail;

import java.util.HashMap;
import java.util.Map;

public class ModelValidatorRegistry {

    private static Map<String, ModelValidator> registry = new HashMap<>();

    static {
        registry.put(CommonOrganisationDetail.class.getSimpleName(), new PhysicalAddressesFieldValidator());
        registry.put(CommonPersonDetail.class.getSimpleName(), new PhysicalAddressesFieldValidator());
    }

    public static ModelValidator getModelValidator(String modelClassName) {
        return registry.get(modelClassName);
    }
}
