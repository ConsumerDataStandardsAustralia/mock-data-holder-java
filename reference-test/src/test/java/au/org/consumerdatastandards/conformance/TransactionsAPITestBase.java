package au.org.consumerdatastandards.conformance;

import net.thucydides.core.annotations.Steps;

public class TransactionsAPITestBase extends APITestBase {

    @Steps
    TransactionsAPISteps steps;

    @Override
    protected TransactionsAPISteps getSteps() {
        return steps;
    }
}
