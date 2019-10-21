package au.org.consumerdatastandards.conformance;


import au.org.consumerdatastandards.support.model.EndpointModel;

public class Payload {

    private Type payloadType;

    private Class<?> dataClass;

    private EndpointModel endpointModel;

    public void setPayloadType(Type payloadType) {
        this.payloadType = payloadType;
    }

    public Class<?> getDataClass() {
        return dataClass;
    }

    public void setDataClass(Class<?> dataClass) {
        this.dataClass = dataClass;
    }

    public void setEndpointModel(EndpointModel endpointModel) {
        this.endpointModel = endpointModel;
    }

    public String getDescription() {
        return payloadType.toString() +
            " in endpoint (" + endpointModel.getEndpoint().operationId()  + ") "
            + endpointModel.getEndpoint().path();
    }

    public Type getPayloadType() {
        return payloadType;
    }

    public enum Type {

        REQUEST_BODY,

        RESPONSE_BODY,

        EMBEDDED_DATA
    }
}
