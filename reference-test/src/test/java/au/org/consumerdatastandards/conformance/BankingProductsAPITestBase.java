package au.org.consumerdatastandards.conformance;

import net.thucydides.core.annotations.Steps;

public class BankingProductsAPITestBase extends APITestBase {

    @Steps
    BankingProductsAPISteps steps;

    @Override
    protected APIStepsBase getSteps() {
        return steps;
    }
}
