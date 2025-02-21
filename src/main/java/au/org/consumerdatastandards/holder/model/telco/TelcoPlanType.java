package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Plan type for this feature.<ul><li>`METERED`: A plan is charged by usage for the feature<li>`UNMETERED`: A plan with no limits for a feature<li>`LIMITED`: Where plan limit inclusions apply<li>`UNSUPPORTED`: Feature is not supported.</ul>
 */
public enum TelcoPlanType {

    METERED("METERED"),

    UNMETERED("UNMETERED"),

    LIMITED("LIMITED"),

    UNSUPPORTED("UNSUPPORTED");

    private String value;

    TelcoPlanType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static TelcoPlanType fromValue(String value) {
        for (TelcoPlanType b : TelcoPlanType.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

