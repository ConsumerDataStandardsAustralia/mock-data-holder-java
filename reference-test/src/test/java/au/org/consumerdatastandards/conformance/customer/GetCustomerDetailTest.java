package au.org.consumerdatastandards.conformance.customer;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
public class GetCustomerDetailTest extends CustomerAPITestBase {

    @Test
    public void getCustomerDetail() {
        if (StringUtils.isBlank(steps.getApiBasePath())) {
            return;
        }
        steps.getCustomerDetail();
        steps.validateGetCustomerDetailResponse();
    }
}
