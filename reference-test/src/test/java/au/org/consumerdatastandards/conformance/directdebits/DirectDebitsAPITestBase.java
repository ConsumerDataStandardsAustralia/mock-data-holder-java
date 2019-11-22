package au.org.consumerdatastandards.conformance.directdebits;

import au.org.consumerdatastandards.conformance.AccountsAPITestBase;
import net.thucydides.core.annotations.Steps;

public class DirectDebitsAPITestBase extends AccountsAPITestBase {

    @Steps
    DirectDebitsAPISteps steps;

    @Override
    protected DirectDebitsAPISteps getSteps() {
        return steps;
    }
}
