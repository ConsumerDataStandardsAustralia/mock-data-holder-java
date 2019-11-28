package au.org.consumerdatastandards.conformance.customer;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
public class GetCustomerTest extends CustomerAPITestBase {

    @Test
    public void getCustomer() {
        if (StringUtils.isBlank(steps.getApiBasePath())) {
            return;
        }
        steps.getCustomer();
        steps.validateGetCustomerResponse();
    }
}
