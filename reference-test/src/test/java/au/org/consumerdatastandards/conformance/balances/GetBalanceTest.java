package au.org.consumerdatastandards.conformance.balances;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("testdata/banking-balance-api-params.csv")
public class GetBalanceTest extends BalancesAPITestBase {

    private String accountId;

    @Test
    public void getBalance() {
        if (StringUtils.isBlank(steps.getApiBasePath())) {
            return;
        }
        steps.getBalance(accountId);
        steps.validateGetBalanceResponse(accountId);
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
