package au.org.consumerdatastandards.conformance.payees;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(SerenityParameterizedRunner.class)
public class GetPayeeDetailTest extends PayeesAPITestBase {

    @Test
    public void listPayees() {
        if (StringUtils.isBlank(steps.getApiBasePath())) {
            return;
        }
        steps.listPayees(null, null, 50);
        List<String> payeeIds = steps.getPayeeIds();
        if (payeeIds != null) {
            for (String payeeId : payeeIds) {
                steps.getPayeeDetail(payeeId);
                steps.validateGetPayeeDetailResponse(payeeId);
            }
        }
    }
}
