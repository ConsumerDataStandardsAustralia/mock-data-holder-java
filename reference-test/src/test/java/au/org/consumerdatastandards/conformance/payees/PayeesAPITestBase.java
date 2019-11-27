package au.org.consumerdatastandards.conformance.payees;

import au.org.consumerdatastandards.conformance.APITestBase;
import net.thucydides.core.annotations.Steps;

public class PayeesAPITestBase extends APITestBase {

    @Steps
    PayeesAPISteps steps;

    @Override
    protected PayeesAPISteps getSteps() {
        return steps;
    }
}
