package au.org.consumerdatastandards.conformance;

import net.thucydides.core.annotations.Steps;

public class BankingAccountsAPITestBase extends APITestBase {

    @Steps
    AccountsAPISteps steps;

    @Override
    protected APIStepsBase getSteps() {
        return steps;
    }
}
