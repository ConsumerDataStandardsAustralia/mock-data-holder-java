package au.org.consumerdatastandards.holder.model.telco;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Plan type for this feature. METERED: A plan is charged by usage for the feature. UNMETERED: A plan with no limits for a feature. LIMITED: Where plan limit inclusions apply. UNSUPPORTED: Feature is not supported
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

