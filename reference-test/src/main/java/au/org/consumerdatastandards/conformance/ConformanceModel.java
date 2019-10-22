package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.support.EndpointResponse;
import au.org.consumerdatastandards.support.ResponseCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConformanceModel {

    private Map<String, String> endpointVersionMap;
    private Map<String, Map<ResponseCode, EndpointResponse>> responseMap;
    private Map<Class<?>, Payload> payloadMap;
    private Map<String, Class<?>> modelMap;

    public Map<String, String> getEndpointVersionMap() {
        return endpointVersionMap;
    }

    public void setEndpointVersionMap(Map<String, String> endpointVersionMap) {
        this.endpointVersionMap = endpointVersionMap;
    }

    public void setResponseMap(Map<String, Map<ResponseCode, EndpointResponse>> responseMap) {
        this.responseMap = responseMap;
    }

    public void setPayloadMap(Map<Class<?>, Payload> payloadMap) {
        this.payloadMap = payloadMap;
        this.modelMap = new HashMap<>();
        for (Class<?> model : payloadMap.keySet()) {
            this.modelMap.put(model.getSimpleName(), model);
        }
    }

    public EndpointResponse getResponse(String operationId, ResponseCode responseCode) {
        return responseMap.get(operationId).get(responseCode);
    }

    public Payload getPayload(Class<?> clazz) {
        return payloadMap.get(clazz);
    }

    public Set<Class<?>> getPayloadModels() {
        return payloadMap.keySet();
    }

    public Class<?> getPayloadModel(String modelName) {
        return modelMap.get(modelName);
    }
}
