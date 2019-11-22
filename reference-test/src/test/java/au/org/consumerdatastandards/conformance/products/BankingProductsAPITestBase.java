package au.org.consumerdatastandards.conformance.products;

import au.org.consumerdatastandards.conformance.APIStepsBase;
import au.org.consumerdatastandards.conformance.APITestBase;
import net.thucydides.core.annotations.Steps;

public class BankingProductsAPITestBase extends APITestBase {

    @Steps
    BankingProductsAPISteps steps;

    @Override
    protected APIStepsBase getSteps() {
        return steps;
    }
}
