package au.org.consumerdatastandards.conformance.directdebits;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("testdata/banking-direct-debits-account-api-params.csv")
public class GetDirectDebitsTest extends DirectDebitsAPITestBase {

    private String accountId;
    private Integer page;
    private Integer pageSize;

    @Test
    public void listDirectDebitsBulk() {
        if (StringUtils.isBlank(steps.getApiBasePath())) {
            return;
        }
        steps.listDirectDebits(accountId, page, pageSize);
        steps.validateListDirectDebitsResponse(accountId, page, pageSize);
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
