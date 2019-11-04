package au.org.consumerdatastandards.conformance;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;

public abstract class APITestBase {

    @Before
    public void setApiBasePath() {
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String apiBasePath = variables.getProperty("apiBase");
        if (!StringUtils.isBlank(apiBasePath)) {
            getSteps().setupApiBasePath(apiBasePath);
        }
    }

    protected abstract APIStepsBase getSteps();
}
