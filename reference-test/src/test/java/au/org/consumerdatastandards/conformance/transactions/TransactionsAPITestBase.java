package au.org.consumerdatastandards.conformance.transactions;

import au.org.consumerdatastandards.conformance.APITestBase;
import net.thucydides.core.annotations.Steps;

public class TransactionsAPITestBase extends APITestBase {

    @Steps
    TransactionsAPISteps steps;

    @Override
    protected TransactionsAPISteps getSteps() {
        return steps;
    }
}
