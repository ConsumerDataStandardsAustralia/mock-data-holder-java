package au.org.consumerdatastandards.reflection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionUtilTests {

    @DisplayName("Set or List impl classes should be detected correctly")
    @Test
    void isSetOrList() {
        assertTrue(ReflectionUtil.isSetOrList(List.class));
        assertTrue(ReflectionUtil.isSetOrList(ArrayList.class));
        assertTrue(ReflectionUtil.isSetOrList(Set.class));
        assertTrue(ReflectionUtil.isSetOrList(LinkedHashSet.class));
    }

    @DisplayName("Non Set or List classes should be detected correctly")
    @Test
    void isNotSetOrList() {
        assertFalse(ReflectionUtil.isSetOrList(String[].class));
        assertFalse(ReflectionUtil.isSetOrList(Map.class));
    }

    @DisplayName("Correct item type should be returned")
    @ParameterizedTest
    @MethodSource("provideFieldItemArguments")
    void getFieldItemType(Field field, Class<?> expectedType) {
        assertEquals(ReflectionUtil.getFieldItemType(field), expectedType);
    }


    private static Stream<Arguments> provideFieldItemArguments() {
        Field[] fields = FieldItems.class.getDeclaredFields();
        List<Field> validFields = new ArrayList<>();
        for (Field field : fields) {
            if (FieldItems.fieldNames.contains(field.getName())) { // filter out fields injected by jacoco
                validFields.add(field);
            }
        }
        Arguments[] arguments = new Arguments[validFields.size()];
        int i = 0;
        for (Field field : validFields) {
            if (FieldItems.fieldNames.contains(field.getName())) { // filter out fields injected by jacoco
                arguments[i++] = Arguments.of(field, FieldItems.getItemType(field.getName()));
            }
        }
        return Stream.of(arguments);
    }


    static class FieldItems {

        static Set<String> fieldNames = new HashSet<>();
        static {
            fieldNames.add("strings");
            fieldNames.add("bigDecimalList");
            fieldNames.add("integerSet");
            fieldNames.add("longs");
            fieldNames.add("shorts");
            fieldNames.add("bytes");
            fieldNames.add("characters");
            fieldNames.add("doubles");
            fieldNames.add("date");
        }

        public String[] strings;
        public List<BigDecimal> bigDecimalList;
        public Set<Integer> integerSet;
        public Long[][] longs;
        public List<List<Short>> shorts;
        public Set<List<Byte>> bytes;
        public List<Character[]> characters;
        public Set<Double>[] doubles;
        public Date date;

        static Class<?> getItemType(String fieldName) {
            if (fieldName.equals("strings")) {
                return String.class;
            }
            if (fieldName.equals("bigDecimalList")) {
                return BigDecimal.class;
            }
            if (fieldName.equals("integerSet")) {
                return Integer.class;
            }
            if (fieldName.equals("longs")) {
                return Long.class;
            }
            if (fieldName.equals("shorts")) {
                return Short.class;
            }
            if (fieldName.equals("bytes")) {
                return Byte.class;
            }
            if (fieldName.equals("characters")) {
                return Character.class;
            }
            if (fieldName.equals("date")) {
                return Object.class;
            }
            if (fieldName.equals("doubles")) {
                return Double.class;
            }
            return null;
        }
    }

    @ParameterizedTest(name = "{0} is type default value")
    @MethodSource("provideTypeDefaultValues")
    void isTypeDefaultValue(Object value) {
        assertTrue(ReflectionUtil.isTypeDefaultValue(value));
    }

    private static Stream<Arguments> provideTypeDefaultValues() {
        return Stream.of(
            Arguments.of(false),
            Arguments.of(0),
            Arguments.of(0L),
            Arguments.of((short) 0),
            Arguments.of((byte) 0),
            Arguments.of(0f),
            Arguments.of(0d),
            Arguments.of(BigDecimal.ZERO)
        );
    }

    @ParameterizedTest(name = "{0} is not type default value")
    @MethodSource("provideTypeNonDefaultValues")
    void isNotTypeDefaultValue(Object value) {
        assertFalse(ReflectionUtil.isTypeDefaultValue(value));
    }

    private static Stream<Arguments> provideTypeNonDefaultValues() {
        return Stream.of(
            Arguments.of(true),
            Arguments.of(1),
            Arguments.of(1L),
            Arguments.of((short) 1),
            Arguments.of((byte) 1),
            Arguments.of(0.1f),
            Arguments.of(0.2d)
        );
    }

    @DisplayName("Unpack array object")
    @Test
    void unpack() {
        Object obj = new Object();
        Object[] unpackedObj = ReflectionUtil.unpack(obj);
        assertEquals(1, unpackedObj.length, "unpacked array length for single object should 1");
        assertEquals(obj, unpackedObj[0], "unpacked object should be the same as original");
        int length = 3;
        Object[] objects = new Object[length];
        for (int i = 0; i < length; i++) {
            objects[i] = new Object();
        }
        Object[] unpackedObjects = ReflectionUtil.unpack(objects);
        assertEquals(objects.length, unpackedObjects.length, "unpacked array length should be the same as original");
        for (int i = 0; i < length; i++) {
            assertEquals(objects[i], unpackedObjects[i], "unpacked object at " + i + " should be the same as original");
        }
    }
}
