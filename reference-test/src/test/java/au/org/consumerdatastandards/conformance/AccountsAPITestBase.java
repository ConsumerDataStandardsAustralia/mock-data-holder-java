package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.api.banking.models.BankingAccountDetail;

import java.util.HashMap;
import java.util.Map;

public abstract class AccountsAPITestBase extends APITestBase {

    private static Map<String, BankingAccountDetail> accountCache = new HashMap<>();

    protected BankingAccountDetail getAccountDetail(String accountId) {
        BankingAccountDetail accountDetail = accountCache.get(accountId);
        if (accountDetail == null) {
            AccountsAPIStepsBase steps = (AccountsAPIStepsBase) getSteps();
            steps.getAccountDetail(accountId);
            accountDetail = steps.validateGetAccountDetailResponse(accountId);
            accountCache.put(accountId, accountDetail);
        }
        return accountDetail;
    }
}
