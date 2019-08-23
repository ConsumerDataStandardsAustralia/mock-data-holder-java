package au.org.consumerdatastandards.conformance;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;

public class BankingProductsAPITestBase {

    static String DEFAULT_API_BASE = "http://localhost:8080/cds-au/v1";

    @Before
    public void setApiBasePath() {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String apiBasePath = variables.getProperty("apiBase");
        if (!StringUtils.isBlank(apiBasePath)) {
            steps.setupApiBasePath(apiBasePath);
        } else {
            steps.setupApiBasePath(DEFAULT_API_BASE);
        }
    }

    @Steps
    BankingProductsAPISteps steps;
}
