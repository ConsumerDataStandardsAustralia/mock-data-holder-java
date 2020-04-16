package au.org.consumerdatastandards.client.cli.support;

import au.org.consumerdatastandards.client.ApiClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.SynchronousQueue;

public class ClientCLIFactory extends ApiClientFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientCLIFactory.class);

    public static final SynchronousQueue<Object> browserMutex = new SynchronousQueue<>();

    public ClientCLIFactory(ClientCLIOptions clientOptions) {
        super(clientOptions);
    }

    @Override
    protected void acquireNewTokens() {
        try {
            launchBrowser("http://localhost:" + ((ClientCLIOptions)clientOptions).getWebPort() + "/auth");
            browserMutex.take(); // Wait for the user to login and acquire the tokens
        } catch (IOException | URISyntaxException e) {
            LOGGER.error("Could not launch a web browser: " + e.getMessage());
        } catch (InterruptedException e) {
            LOGGER.warn("Auth sequence interrupted.");
        }
    }

    private static void launchBrowser(String url) throws IOException, URISyntaxException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI(url));
        } else {
            Runtime rt = Runtime.getRuntime();
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (os.contains("nix") || os.contains("nux")) {
                rt.exec("xdg-open " + url);
            } else if (os.contains("mac")) {
                rt.exec("open " + url);
            } else {
                IOException ex = new IOException("Unsupported OS");
                try {
                    browserMutex.put(ex);
                } catch (InterruptedException e) {
                    // Safe to ignore
                }
                throw ex;
            }
        }
    }

    public boolean isValidationEnabled() {
        return clientOptions.isValidationEnabled();
    }
}
