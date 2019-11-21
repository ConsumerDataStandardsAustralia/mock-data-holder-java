package au.org.consumerdatastandards.suport.data;

import au.org.consumerdatastandards.support.data.CustomDataType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomDataTypeTests {

    @ParameterizedTest(name = "{0} should be valid duration string")
    @ValueSource(strings = {"P4Y", "PT0S", "P0.5Y", "P0,5Y", "P0D", "P3Y6M4DT12H30M5S", "P1Y2M10DT2H30M", "P23DT23H"})
    void validDurations(String durationString) {
        assertTrue(durationString.matches(CustomDataType.Duration.getPattern()));
    }

    @ParameterizedTest(name = "{0} should be invalid duration string")
    @ValueSource(strings = {"P0S", "23DT23H", "ABC", "P-1D"})
    void invalidDurations(String durationString) {
        assertFalse(durationString.matches(CustomDataType.Duration.getPattern()));
    }

    @ParameterizedTest(name = "{0} should be valid rate string")
    @ValueSource(strings = {"1", "-1", "0", "0.1", "0.1234567890123456", "-0.1234567890123456"})
    void validRates(String rateString) {
        assertTrue(rateString.matches(CustomDataType.Rate.getPattern()));
        BigDecimal max = new BigDecimal(CustomDataType.Rate.getMax().toString());
        BigDecimal min = new BigDecimal(CustomDataType.Rate.getMin().toString());
        BigDecimal rate = new BigDecimal(rateString);
        assertTrue(rate.compareTo(max) <= 0 && rate.compareTo(min) >= 0);
    }

    @ParameterizedTest(name = "{0} should be invalid rate string")
    @ValueSource(strings = {"82", ".1", "-2", "-1.01", "1.00001", "0.12345678901234567", "-0.12345678901234567", "a", "a1"})
    void invalidRates(String rateString) {
        boolean valid = rateString.matches(CustomDataType.Rate.getPattern());
        if (valid) {
            BigDecimal max = new BigDecimal(CustomDataType.Rate.getMax().toString());
            BigDecimal min = new BigDecimal(CustomDataType.Rate.getMin().toString());
            BigDecimal rate = new BigDecimal(rateString);
            valid = rate.compareTo(max) <= 0 && rate.compareTo(min) >= 0;
        }
        assertFalse(valid);
    }

    @ParameterizedTest(name = "{0} should be valid ASCII String")
    @ValueSource(strings = {"", " ", "abc", " 1 2", "@$&&%(*"})
    void validASCIIString(String asciiString) {
        assertTrue(asciiString.matches(CustomDataType.ASCII.getPattern()));
    }

    @ParameterizedTest(name = "{0} should be invalid ASCII String")
    @ValueSource(strings = {"لْعَرَبِيَّة\u200E", "ひらがな", "ㄱ ㄴ ㄷ ㄹ", "漢字abc"})
    void invalidASCIIString(String asciiString) {
        assertFalse(asciiString.matches(CustomDataType.ASCII.getPattern()));
    }

    @ParameterizedTest(name = "{0} should be valid Amount String")
    @ValueSource(strings = {"0.01", "10.00", "1234567.89", "-1001.23", "1.999"})
    void validAmountString(String amountString) {
        assertTrue(amountString.matches(CustomDataType.Amount.getPattern()));
    }

    @ParameterizedTest(name = "{0} should be invalid Amount String")
    @ValueSource(strings = {"abc", "+10.00", "1234567.8", "-1001.2", "00.12", "12345678901234567.00"})
    void invalidAmountString(String amountString) {
        assertFalse(amountString.matches(CustomDataType.Amount.getPattern()));
    }

    @ParameterizedTest(name = "{0} should be valid Unicode String")
    @ValueSource(strings = {"", "ひらがな", "ㄱㄴㄷㄹ", "漢字abc", "abc "})
    void validUnicodeString(String unicodeString) {
        assertTrue(unicodeString.matches(CustomDataType.Unicode.getPattern()));
    }

    @ParameterizedTest(name = "{0} should be invalid Unicode String")
    @ValueSource(strings = {"insurance�covers"})
    void invalidUnicodeString(String unicodeString) {
        assertFalse(unicodeString.matches(CustomDataType.Unicode.getPattern()));
    }
}
