package au.org.consumerdatastandards.conformance.accounts;

import au.org.consumerdatastandards.conformance.APIStepsBase;
import au.org.consumerdatastandards.conformance.AccountsAPITestBase;
import net.thucydides.core.annotations.Steps;

public class BankingAccountsAPITestBase extends AccountsAPITestBase {

    @Steps
    AccountsAPISteps steps;

    @Override
    protected APIStepsBase getSteps() {
        return steps;
    }
}
