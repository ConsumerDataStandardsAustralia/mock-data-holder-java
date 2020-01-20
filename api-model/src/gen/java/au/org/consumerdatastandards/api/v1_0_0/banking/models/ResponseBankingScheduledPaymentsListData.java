package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class ResponseBankingScheduledPaymentsListData {

    @Property(
        description = "The list of scheduled payments to return",
        required = true
    )
    List<BankingScheduledPayment> scheduledPayments;
}
