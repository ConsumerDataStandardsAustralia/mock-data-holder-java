package au.org.consumerdatastandards.conformance.util;

import au.org.consumerdatastandards.conformance.ConformanceModel;
import au.org.consumerdatastandards.conformance.Payload;
import au.org.consumerdatastandards.reflection.ReflectionUtil;
import au.org.consumerdatastandards.support.EndpointResponse;
import au.org.consumerdatastandards.support.Extension;
import au.org.consumerdatastandards.support.ResponseCode;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.model.APIModel;
import au.org.consumerdatastandards.support.model.EndpointModel;
import au.org.consumerdatastandards.support.model.ParamModel;
import au.org.consumerdatastandards.support.model.SectionModel;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.*;

public class ModelConformanceConverter {

    public static ConformanceModel convert(APIModel apiModel) {
        ConformanceModel conformanceModel = new ConformanceModel();
        Map<String, String> endpointVersionMap = new HashMap<>();
        Map<String, Map<ResponseCode, EndpointResponse>> responseMap = new HashMap<>();
        Map<Class<?>, Payload> payloadMap = new HashMap<>();
        Set<Class<?>> processedClasses = new HashSet<>();
        for (SectionModel sectionModel : apiModel.getSectionModels()) {
            for (EndpointModel endpointModel : sectionModel.getEndpointModels()) {
                add(endpointModel, endpointVersionMap, responseMap, payloadMap, processedClasses);
            }
        }
        conformanceModel.setEndpointVersionMap(endpointVersionMap);
        conformanceModel.setResponseMap(responseMap);
        conformanceModel.setPayloadMap(payloadMap);
        return conformanceModel;
    }

    private static void add(EndpointModel endpointModel,
                            Map<String, String> endpointVersionMap,
                            Map<String, Map<ResponseCode, EndpointResponse>> responseMap,
                            Map<Class<?>, Payload> payloadMap,
                            Set<Class<?>> processedClasses) {
        Set<ParamModel> bodyParams = endpointModel.getBodyParams();
        if (bodyParams != null && !bodyParams.isEmpty()) {
            processBodyParams(endpointModel, bodyParams, payloadMap, processedClasses);
        }
        String operationId = endpointModel.getEndpoint().operationId();
        endpointVersionMap.put(operationId, endpointModel.getCustomAttributeValue(Extension.VERSION.getKey()));
        for (EndpointResponse response : endpointModel.getEndpoint().responses()) {
            responseMap.computeIfAbsent(operationId, k -> new HashMap<>());
            responseMap.get(operationId).put(response.responseCode(), response);
            processResponseBody(endpointModel, response, payloadMap, processedClasses);
        }
    }

    private static void processBodyParams(EndpointModel endpointModel,
                                          Set<ParamModel> bodyParams,
                                          Map<Class<?>, Payload> payloadMap,
                                          Set<Class<?>> processedClasses) {
        for (ParamModel bodyParam : bodyParams) {
            Payload payload = new Payload();
            payload.setDataClass(getPayloadDataClass(bodyParam.getParamDataType()));
            payload.setPayloadType(Payload.Type.REQUEST_BODY);
            payload.setEndpointModel(endpointModel);
            payloadMap.put(bodyParam.getParamDataType(), payload);
            processDataDefinition(endpointModel, bodyParam.getParamDataType(), payloadMap, processedClasses);
        }
    }

    private static void processResponseBody(EndpointModel endpointModel,
                                            EndpointResponse response,
                                            Map<Class<?>, Payload> payloadMap,
                                            Set<Class<?>> processedClasses) {
        if (!response.content().equals(Void.class)) {
            Payload payload = new Payload();
            payload.setDataClass(getPayloadDataClass(response.content()));
            payload.setPayloadType(Payload.Type.RESPONSE_BODY);
            payload.setEndpointModel(endpointModel);
            payloadMap.put(response.content(), payload);
            processDataDefinition(endpointModel, response.content(), payloadMap, processedClasses);
        }
    }

    private static void processDataDefinition(EndpointModel endpointModel,
                                              Class<?> dataType,
                                              Map<Class<?>, Payload> payloadMap,
                                              Set<Class<?>> processedClasses) {
        if (!processedClasses.contains(dataType)) {
            for (Field field : FieldUtils.getAllFields(dataType)) {
                Class<?> fieldType = field.getType();
                if (fieldType.isAnnotationPresent(DataDefinition.class) && !fieldType.isEnum()) {
                    addPayload(endpointModel, fieldType, payloadMap);
                    processDataDefinition(endpointModel, fieldType, payloadMap, processedClasses);
                } else if (ReflectionUtil.isSetOrList(fieldType)) {
                    Class<?> itemType = ReflectionUtil.getFieldItemType(field);
                    addArrayPayload(endpointModel, itemType, payloadMap);
                    if (itemType.isAnnotationPresent(DataDefinition.class) && !itemType.isEnum()) {
                        addPayload(endpointModel, itemType, payloadMap);
                        processDataDefinition(endpointModel, itemType, payloadMap, processedClasses);
                    }
                } else if (fieldType.isArray()) {
                    addArrayPayload(endpointModel, fieldType.getComponentType(), payloadMap);
                    if(fieldType.getComponentType().isAnnotationPresent(DataDefinition.class)
                        && !fieldType.getComponentType().isEnum()) {
                        addPayload(endpointModel, fieldType.getComponentType(), payloadMap);
                        processDataDefinition(endpointModel, fieldType.getComponentType(), payloadMap, processedClasses);
                    }
                }
            }
            DataDefinition dataDefinition = dataType.getAnnotation(DataDefinition.class);
            if (dataDefinition != null && dataDefinition.allOf().length > 0) {
                for (Class<?> clazz : dataDefinition.allOf()) {
                    processDataDefinition(endpointModel, clazz, payloadMap, processedClasses);
                }
            }
            processedClasses.add(dataType);
        }
    }

    private static void addPayload(EndpointModel endpointModel, Class<?> dataType, Map<Class<?>, Payload> payloadMap) {
        if (payloadMap.get(dataType) == null) {
            Payload payload = new Payload();
            payload.setDataClass(getPayloadDataClass(dataType));
            payload.setPayloadType(Payload.Type.EMBEDDED_DATA);
            payload.setEndpointModel(endpointModel);
            payloadMap.put(dataType, payload);
        }
    }

    private static void addArrayPayload(EndpointModel endpointModel, Class<?> dataType, Map<Class<?>, Payload> payloadMap) {
        Class<?> dataClass = getPayloadDataClass(dataType);
        Class<?> generatedArrayType = Array.newInstance(dataClass, 0).getClass();
        Class<?> arrayType = Array.newInstance(dataType, 0).getClass();
        if (payloadMap.get(arrayType) == null) {
            Payload payload = new Payload();
            payload.setDataClass(generatedArrayType);
            payload.setPayloadType(Payload.Type.EMBEDDED_DATA);
            payload.setEndpointModel(endpointModel);
            payloadMap.put(arrayType, payload);
        }
    }

    private static Class<?> getPayloadDataClass(Class<?> dataType) {
        return ConformanceUtil.expandModel(dataType);
    }
}
