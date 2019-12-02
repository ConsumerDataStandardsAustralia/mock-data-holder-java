package au.org.consumerdatastandards.conformance.scheduled.payments;

import au.org.consumerdatastandards.api.banking.models.BankingScheduledPayment;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("testdata/banking-direct-debits-api-params.csv")
public class ListScheduledPaymentsTest extends ScheduledPaymentsAPITestBase {

    private String productCategory;
    private String openStatus;
    private Boolean isOwned;
    private Integer page;
    private Integer pageSize;

    @Test
    public void listScheduledPaymentsBulk() {
        if (StringUtils.isBlank(steps.getApiBasePath())) {
            return;
        }
        steps.listScheduledPaymentsBulk(productCategory, openStatus, isOwned, page, pageSize);
        List<BankingScheduledPayment> scheduledPayments = steps.validateListScheduledPaymentsBulkResponse(productCategory, openStatus, isOwned, page, pageSize);
        if (scheduledPayments != null) {
            for (BankingScheduledPayment scheduledPayment : scheduledPayments) {
                String accountId = ScheduledPaymentsAPISteps.getScheduledPaymentAccountId(scheduledPayment);
                Object accountDetail = getAccountDetail(accountId);
                if (accountDetail != null) {
                    steps.validateReferencedByIdAccount(accountDetail, productCategory, openStatus, isOwned);
                }
            }
        }
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setOpenStatus(String openStatus) {
        this.openStatus = openStatus;
    }

    public void setOwned(Boolean owned) {
        isOwned = owned;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
