package au.org.consumerdatastandards.conformance.transactions;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("testdata/banking-transactions-api-params.csv")
public class ListTransactionsTest extends TransactionsAPITestBase {

    private String accountId;
    private String oldestTime;
    private String newestTime;
    private String minAmount;
    private String maxAmount;
    private String text;
    private Integer page;
    private Integer pageSize;

    @Test
    public void listTransactions() {
        if (StringUtils.isBlank(steps.getApiBasePath())) {
            return;
        }
        steps.getTransactions(accountId, oldestTime, newestTime, minAmount, maxAmount, text, page, pageSize);
        steps.validateGetTransactionsResponse(accountId, oldestTime, newestTime, minAmount, maxAmount, text, page, pageSize);
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setOldestTime(String oldestTime) {
        this.oldestTime = oldestTime;
    }

    public void setNewestTime(String newestTime) {
        this.newestTime = newestTime;
    }

    public void setMinAmount(String minAmount) {
        this.minAmount = minAmount;
    }

    public void setMaxAmount(String maxAmount) {
        this.maxAmount = maxAmount;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
