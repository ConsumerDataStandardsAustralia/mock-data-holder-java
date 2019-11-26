package au.org.consumerdatastandards.conformance.scheduled.payments;

import au.org.consumerdatastandards.conformance.AccountsAPITestBase;
import net.thucydides.core.annotations.Steps;

public class ScheduledPaymentsAPITestBase extends AccountsAPITestBase {

    @Steps
    ScheduledPaymentsAPISteps steps;

    @Override
    protected ScheduledPaymentsAPISteps getSteps() {
        return steps;
    }
}
