/*
 * Consumer Data Standards
 * Sample CLI tool to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 */
package au.org.consumerdatastandards.client.cli;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@ShellCommandGroup("Common Functions")
public class Common extends ApiCliBase {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Common.class);

    @ShellMethod("Set CDS server URL, e.g. http://data.holder/cds-au/v1")
    public void server(@ShellOption String url) {
        apiClientOptions.setServerUrl(url);
        LOGGER.info("Server URL is set to {}", apiClientOptions.getServerUrl());
    }

    @ShellMethod("Set proxy, e.g. http://http-proxy:8080, https://https-proxy:8443, socks://socks-proxy:5050, none")
    public void proxy(@ShellOption String proxy) {
        apiClientOptions.setProxy(proxy);
        LOGGER.info("Proxy is set to {}", apiClientOptions.getProxy());
    }

    @ShellMethod("Set verifyingSsl, e.g. true, false")
    public void verifyingSsl(@ShellOption String verifyingSsl) {
        apiClientOptions.setVerifyingSsl(Boolean.getBoolean(verifyingSsl));
        LOGGER.info("VerifyingSsl is set to {}", verifyingSsl);
    }

    @ShellMethod("Setup minimum log level, default is INFO")
    public void setLogLevel(@ShellOption Level targetLevel) {
        Logger root = (Logger)LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        root.setLevel(targetLevel);
    }

    @ShellMethod("Setup client certificate to enable MTLS connection to the server")
    public void setClientCert(@ShellOption("cert file path") String certFilePath,
                                     @ShellOption("key file path") String keyFilePath,
                                     @ShellOption(value = "enable MTLS or not", defaultValue = "true") boolean mtlsEnabled) {
        apiClientOptions.setCertFilePath(certFilePath);
        LOGGER.info("Client certificate file path is set to {}", certFilePath);
        apiClientOptions.setKeyFilePath(keyFilePath);
        LOGGER.info("Client key file path is set to {}", keyFilePath);
        if (mtlsEnabled) {
            enableMTLS();
        } else {
            disableMTLS();
        }
    }

    @ShellMethod("Enable MTLS")
    public void enableMTLS() {
        apiClientOptions.setMtlsEnabled(true);
        LOGGER.info("MTLS enabled");
    }

    @ShellMethod("Disable MTLS")
    public void disableMTLS() {
        apiClientOptions.setMtlsEnabled(false);
        LOGGER.info("MTLS disabled");
    }
    
    @ShellMethod("Retrieve current minimum log level")
    public void getLogLevel() {
        Logger root = (Logger)LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        Level currentLevel = root.getLevel();
        root.setLevel(Level.INFO);
        // Need to make sure we are at least at info or the message won't print
        LOGGER.info("Log level currently set to: {}", currentLevel);
        root.setLevel(currentLevel);
    }
    
    @ShellMethod("Set browser user-agent")
    public void setUserAgent(@ShellOption String userAgent) {
        apiClientOptions.setUserAgent(userAgent);
    }
    
    @ShellMethod("Get browser user-agent")
    public void getUserAgent() {
        Logger root = (Logger)LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        root.setLevel(Level.INFO);
        LOGGER.info("User Agent currently set to: {}", apiClientOptions.getUserAgent());
    }
    
    @ShellMethod("Enable client debug")
    public void enableClientDebug(@ShellOption(help = "true / false") String debugEnabled) {
        apiClientOptions.setDebugEnabled(Boolean.parseBoolean(debugEnabled));
    }
    
    @ShellMethod("Client debug enabled")
    public void getClientDebug() {
        Logger root = (Logger)LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        root.setLevel(Level.INFO);
        LOGGER.info("Client debug is currently set to: {}", apiClientOptions.isDebugEnabled());
    }

    @ShellMethod("Set access token to send as the Authorization: Bearer header")
    public void accessToken(@ShellOption String jwt) {
        apiClientOptions.setAccessToken(jwt);
    }
}
