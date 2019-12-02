package au.org.consumerdatastandards.conformance;

import java.util.HashMap;
import java.util.Map;

public abstract class AccountsAPITestBase extends APITestBase {

    private static Map<String, Object> accountCache = new HashMap<>();

    protected Object getAccountDetail(String accountId) {
        Object accountDetail = accountCache.get(accountId);
        if (accountDetail == null) {
            AccountsAPIStepsBase steps = (AccountsAPIStepsBase) getSteps();
            steps.getAccountDetail(accountId);
            accountDetail = steps.validateGetAccountDetailResponse(accountId);
            accountCache.put(accountId, accountDetail);
        }
        return accountDetail;
    }
}
