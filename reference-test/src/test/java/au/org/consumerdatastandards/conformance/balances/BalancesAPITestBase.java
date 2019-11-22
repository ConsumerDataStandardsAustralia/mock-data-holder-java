package au.org.consumerdatastandards.conformance.balances;

import au.org.consumerdatastandards.conformance.AccountsAPITestBase;
import net.thucydides.core.annotations.Steps;

public class BalancesAPITestBase extends AccountsAPITestBase {

    @Steps
    BalancesAPISteps steps;

    @Override
    protected BalancesAPISteps getSteps() {
        return steps;
    }
}
