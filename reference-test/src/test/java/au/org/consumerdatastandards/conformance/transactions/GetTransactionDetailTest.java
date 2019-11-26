package au.org.consumerdatastandards.conformance.transactions;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(SerenityRunner.class)
@UseTestDataFrom("testdata/banking-transaction-detail-api-params.csv")
public class GetTransactionDetailTest extends TransactionsAPITestBase {

    private String accountId;

    @Test
    public void getTransactionDetail() {
        if (StringUtils.isBlank(steps.getApiBasePath())) {
            return;
        }
        steps.getTransactions(accountId, null, null, null, null, null, null, 50);
        List<String> transactionIds = steps.getTransactionIds();
        if (transactionIds != null) {
            for (String transactionId : transactionIds) {
                steps.getTransactionDetail(accountId, transactionId);
                steps.validateGetTransactionDetailResponse(accountId, transactionId);
            }
        }
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
