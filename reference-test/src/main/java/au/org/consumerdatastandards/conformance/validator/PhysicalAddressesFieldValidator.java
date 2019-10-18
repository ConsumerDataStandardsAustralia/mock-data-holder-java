package au.org.consumerdatastandards.conformance.validator;

import au.org.consumerdatastandards.api.common.models.CommonPhysicalAddressWithPurpose;
import au.org.consumerdatastandards.conformance.ConformanceError;
import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.reflection.ReflectionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhysicalAddressesFieldValidator implements ModelValidator {

    /**
     * physicalAddresses must contain at least one address.
     * One and only one address may have the purpose of REGISTERED.
     * Zero or one, and no more than one, record may have the purpose of MAIL.
     * If zero then the REGISTERED address is to be used for mail
     * @param object
     * @return errors
     */
    public List<ConformanceError> validate(Object object) {
        List<ConformanceError> errors = new ArrayList<>();
        Object dataFieldValue = ConformanceUtil.getDataFieldValue(object, "physicalAddresses");
        if (dataFieldValue == null || !dataFieldValue.getClass().isArray()) {
            errors.add(new ConformanceError()
                .errorType(ConformanceError.Type.MISSING_VALUE)
                .dataJson(ConformanceUtil.toJson(object))
                .errorMessage("physicalAddresses must contain at least one address"));
        } else {
            List physicalAddresses = Arrays.asList(ReflectionUtil.unpack(dataFieldValue));
            if (physicalAddresses.isEmpty()) {
                errors.add(new ConformanceError()
                    .errorType(ConformanceError.Type.MISSING_VALUE)
                    .dataJson(ConformanceUtil.toJson(object))
                    .errorMessage("physicalAddresses must contain at least one address"));
            } else {
                if (physicalAddresses.stream().filter(a -> isForPurpose(a, CommonPhysicalAddressWithPurpose.Purpose.REGISTERED)).count() != 1) {
                    errors.add(new ConformanceError()
                        .errorType(ConformanceError.Type.BROKEN_CONSTRAINT)
                        .dataJson(ConformanceUtil.toJson(object))
                        .errorMessage("One and only one address may have the purpose of REGISTERED"));
                }
                if (physicalAddresses.stream().filter(a -> isForPurpose(a, CommonPhysicalAddressWithPurpose.Purpose.MAIL)).count() > 1) {
                    errors.add(new ConformanceError()
                        .errorType(ConformanceError.Type.BROKEN_CONSTRAINT)
                        .dataJson(ConformanceUtil.toJson(object))
                        .errorMessage("Zero or one, and no more than one, record may have the purpose of MAIL"));
                }
            }
        }
        return errors;
    }

    private boolean isForPurpose(Object address, CommonPhysicalAddressWithPurpose.Purpose purpose) {
        Object dateFieldValue = ConformanceUtil.getDataFieldValue(address, "purpose");
        return purpose.equals(dateFieldValue);
    }
}
