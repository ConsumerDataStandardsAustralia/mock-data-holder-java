package au.org.consumerdatastandards.conformance.balances;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("testdata/banking-balance-accounts-api-params.csv")
public class ListBalancesSpecificAccountsTest extends BalancesAPITestBase {

    private String accountIds;
    private Integer page;
    private Integer pageSize;

    @Test
    public void listBalance() throws JsonProcessingException {
        if (StringUtils.isBlank(steps.getApiBasePath())) {
            return;
        }
        String[] ids = (accountIds == null ? null : accountIds.split(" "));
        steps.listBalancesSpecificAccounts(ids, page, pageSize);
        steps.validateListBalancesSpecificAccountsResponse(ids, page, pageSize);
    }

    public void setAccountIds(String accountIds) {
        this.accountIds = accountIds;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
