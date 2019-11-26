package au.org.consumerdatastandards.conformance.customer;

import au.org.consumerdatastandards.conformance.APITestBase;
import au.org.consumerdatastandards.conformance.payees.PayeesAPISteps;
import net.thucydides.core.annotations.Steps;

public class CustomerAPITestBase extends APITestBase {

    @Steps
    CustomerAPISteps steps;

    @Override
    protected CustomerAPISteps getSteps() {
        return steps;
    }
}
