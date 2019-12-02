package au.org.consumerdatastandards.conformance.scheduled.payments;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("testdata/banking-scheduled-payments-account-api-params.csv")
public class GetScheduledPaymentsTest extends ScheduledPaymentsAPITestBase {

    private String accountId;
    private Integer page;
    private Integer pageSize;

    @Test
    public void listScheduledPayments() {
        if (StringUtils.isBlank(steps.getApiBasePath())) {
            return;
        }
        steps.listScheduledPayments(accountId, page, pageSize);
        steps.validateListScheduledPaymentsResponse(accountId, page, pageSize);
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
