package au.org.consumerdatastandards.reflection;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class ReflectionUtil {

    public static boolean isSetOrList(Class<?> type) {

        return Set.class.isAssignableFrom(type) || List.class.isAssignableFrom(type);
    }

    public static Class<?> getFieldItemType(Field field) {
        Class<?> type = field.getType();
        Type genericType = field.getGenericType();
        return getItemType(type, genericType);
    }

    public static Class<?> getItemType(Class<?> type, Type genericType) {
        if (type.isArray()) {
            Class<?> componentType = type.getComponentType();
            if (!componentType.isArray() && !isSetOrList(componentType)) {
                return componentType;
            }
            return getItemType(componentType, genericType);
        }
        if (genericType instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) genericType;
            return getItemType(type, genericArrayType.getGenericComponentType());
        } else if (genericType instanceof ParameterizedType) {
            ParameterizedType aType = (ParameterizedType) genericType;
            Type[] fieldArgTypes = aType.getActualTypeArguments();
            Type fieldArgType = fieldArgTypes[0];
            if (fieldArgType instanceof ParameterizedType
                || fieldArgType instanceof GenericArrayType) {
                return getItemType(type, fieldArgType);
            }
            Class<?> fieldArgClass = (Class<?>) fieldArgType;
            if (fieldArgClass.isArray()) {
                return getItemType(fieldArgClass, fieldArgType);
            }
            return fieldArgClass;
        }
        return Object.class;
    }

    public static boolean isTypeDefaultValue(Object defaultValue) {
        if (defaultValue == null) return false;
        return defaultValue.getClass().equals(Boolean.class) && defaultValue.equals(Boolean.FALSE) ||
            Number.class.isAssignableFrom(defaultValue.getClass()) &&
                new BigDecimal(defaultValue.toString()).equals(BigDecimal.ZERO) ||
            defaultValue.getClass().equals(Float.class) && Float.compare(0, (Float)defaultValue) == 0 ||
            defaultValue.getClass().equals(Double.class) && Double.compare(0, (Double)defaultValue) == 0;
    }

    public static Object[] unpack(Object array) {
        if (!array.getClass().isArray()) {
            return new Object[]{array};
        }
        Object[] values = new Object[Array.getLength(array)];
        for (int i = 0; i < values.length; i++)
            values[i] = Array.get(array, i);
        return values;
    }

    public static boolean isCDSModel(Class<?> modelClass) {
        return modelClass.getName().startsWith("au.org.consumerdatastandards");
    }
}
