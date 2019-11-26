package au.org.consumerdatastandards.conformance.accounts;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(SerenityRunner.class)
public class GetAccountDetailTest extends BankingAccountsAPITestBase {

    @Test
    public void getAccountDetail() {
        if (StringUtils.isBlank(steps.getApiBasePath())) {
            return;
        }
        steps.listAccounts(null, null, null, null, 50);
        List<String> accountIds = steps.getAccountIds();
        if (accountIds != null) {
            for (String accountId : accountIds) {
                getAccountDetail(accountId);
            }
        }
    }
}
