package au.org.consumerdatastandards.conformance;

import net.thucydides.core.annotations.Steps;

public class BalancesAPITestBase extends APITestBase {

    @Steps
    BalancesAPISteps steps;

    @Override
    protected BalancesAPISteps getSteps() {
        return steps;
    }
}
