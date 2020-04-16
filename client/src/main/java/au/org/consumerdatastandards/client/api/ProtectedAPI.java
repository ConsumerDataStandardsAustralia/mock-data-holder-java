package au.org.consumerdatastandards.client.api;

import au.org.consumerdatastandards.client.ApiClient;


import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.OffsetDateTime;
import java.util.Map;

public class ProtectedAPI {

    protected ApiClient apiClient;

    protected void addCdsProtectedApiHeaders(Map<String, String> headers) {
        headers.put("x-fapi-customer-ip-address", getIpAddress());
        headers.put("x-fapi-auth-date", OffsetDateTime.now().toString());
    }

    private String getIpAddress() {
        String ipAddress = "unknown";
        try {
            final DatagramSocket socket = new DatagramSocket();
            socket.connect(InetAddress.getByName("203.98.87.18"), 53); // ns1.internet.net.au.
            ipAddress = socket.getLocalAddress().getHostAddress();
            socket.disconnect();
        } catch (SocketException | UnknownHostException e) {
            // ignored
        }
        return ipAddress;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
}
