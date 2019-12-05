package au.org.consumerdatastandards.conformance;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Before;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public abstract class APITestBase {

    @Before
    public void setApiBasePath() throws IOException, UnrecoverableKeyException, CertificateException,
        NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String apiBasePath = variables.getProperty("apiBase");
        if (!StringUtils.isBlank(apiBasePath)) {
            Security.addProvider(new BouncyCastleProvider());
            getSteps().setupApiBasePath(apiBasePath);
            getSteps().setupPttProperties();
        }
    }

    protected abstract APIStepsBase getSteps();
}
