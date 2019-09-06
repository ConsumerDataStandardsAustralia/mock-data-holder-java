package au.org.consumerdatastandards.conformance;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;

public class BankingProductsAPITestBase {

    @Before
    public void setApiBasePath() {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String apiBasePath = variables.getProperty("apiBase");
        if (!StringUtils.isBlank(apiBasePath)) {
            steps.setupApiBasePath(apiBasePath);
        }
    }

    @Steps
    BankingProductsAPISteps steps;
}
