package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyServicePointDetailLocation
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyServicePointDetailLocation {
    /**
     * The type of address object present
     */
    public enum AddressUTypeEnum {
        SIMPLE("simple"),

        PAF("paf");

        private String value;

        AddressUTypeEnum(String value) {
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
        public static AddressUTypeEnum fromValue(String value) {
            for (AddressUTypeEnum b : AddressUTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("addressUType")
    private AddressUTypeEnum addressUType;

    @JsonProperty("simple")
    private EnergyServicePointDetailLocationSimple simple;

    @JsonProperty("paf")
    private EnergyServicePointDetailLocationPaf paf;

    public EnergyServicePointDetailLocation addressUType(AddressUTypeEnum addressUType) {
        this.addressUType = addressUType;
        return this;
    }

    /**
     * The type of address object present
     *
     * @return addressUType
     */
    @ApiModelProperty(required = true,
            value = "The type of address object present")
    @NotNull


    public AddressUTypeEnum getAddressUType() {
        return addressUType;
    }

    public void setAddressUType(AddressUTypeEnum addressUType) {
        this.addressUType = addressUType;
    }

    public EnergyServicePointDetailLocation simple(EnergyServicePointDetailLocationSimple simple) {
        this.simple = simple;
        return this;
    }

    /**
     * Get simple
     *
     * @return simple
     */
    @ApiModelProperty(value = "")

    @Valid

    public EnergyServicePointDetailLocationSimple getSimple() {
        return simple;
    }

    public void setSimple(EnergyServicePointDetailLocationSimple simple) {
        this.simple = simple;
    }

    public EnergyServicePointDetailLocation paf(EnergyServicePointDetailLocationPaf paf) {
        this.paf = paf;
        return this;
    }

    /**
     * Get paf
     *
     * @return paf
     */
    @ApiModelProperty(value = "")

    @Valid

    public EnergyServicePointDetailLocationPaf getPaf() {
        return paf;
    }

    public void setPaf(EnergyServicePointDetailLocationPaf paf) {
        this.paf = paf;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyServicePointDetailLocation energyServicePointDetailLocation = (EnergyServicePointDetailLocation) o;
        return Objects.equals(this.addressUType, energyServicePointDetailLocation.addressUType) &&
                Objects.equals(this.simple, energyServicePointDetailLocation.simple) &&
                Objects.equals(this.paf, energyServicePointDetailLocation.paf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressUType, simple, paf);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyServicePointDetailLocation {\n");

        sb.append("    addressUType: ").append(toIndentedString(addressUType)).append("\n");
        sb.append("    simple: ").append(toIndentedString(simple)).append("\n");
        sb.append("    paf: ").append(toIndentedString(paf)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

