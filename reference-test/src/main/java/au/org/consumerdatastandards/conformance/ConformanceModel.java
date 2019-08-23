package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.support.EndpointResponse;
import au.org.consumerdatastandards.support.ResponseCode;

import java.util.Map;
import java.util.Set;

public class ConformanceModel {

    private Map<String, Map<ResponseCode, EndpointResponse>> responseMap;
    private Map<Class<?>, Payload> payloadMap;

    public void setResponseMap(Map<String, Map<ResponseCode, EndpointResponse>> responseMap) {
        this.responseMap = responseMap;
    }

    public void setPayloadMap(Map<Class<?>, Payload> payloadMap) {
        this.payloadMap = payloadMap;
    }

    public EndpointResponse getResponse(String operationId, ResponseCode responseCode) {
        return responseMap.get(operationId).get(responseCode);
    }

    public Payload getPlayload(Class<?> clazz) {
        return payloadMap.get(clazz);
    }

    public Set<Class<?>> getPayloadModels() {
        return payloadMap.keySet();
    }
}
