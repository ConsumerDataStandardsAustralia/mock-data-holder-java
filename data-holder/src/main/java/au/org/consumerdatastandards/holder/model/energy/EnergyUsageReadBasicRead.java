package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Mandatory if readUType is set to basicRead
 */
@ApiModel(description = "Mandatory if readUType is set to basicRead")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyUsageReadBasicRead {
    /**
     * The quality of the read taken.  If absent then assumed to be ACTUAL
     */
    public enum QualityEnum {
        ACTUAL("ACTUAL"),

        SUBSTITUTE("SUBSTITUTE"),

        FINAL_SUBSTITUTE("FINAL_SUBSTITUTE");

        private String value;

        QualityEnum(String value) {
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
        public static QualityEnum fromValue(String value) {
            for (QualityEnum b : QualityEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("quality")
    private QualityEnum quality = QualityEnum.ACTUAL;

    @JsonProperty("value")
    private BigDecimal value;

    public EnergyUsageReadBasicRead quality(QualityEnum quality) {
        this.quality = quality;
        return this;
    }

    /**
     * The quality of the read taken.  If absent then assumed to be ACTUAL
     *
     * @return quality
     */
    @ApiModelProperty(value = "The quality of the read taken.  If absent then assumed to be ACTUAL")


    public QualityEnum getQuality() {
        return quality;
    }

    public void setQuality(QualityEnum quality) {
        this.quality = quality;
    }

    public EnergyUsageReadBasicRead value(BigDecimal value) {
        this.value = value;
        return this;
    }

    /**
     * Meter read value.  If positive then it means consumption, if negative it means export
     *
     * @return value
     */
    @ApiModelProperty(required = true,
            value = "Meter read value.  If positive then it means consumption, if negative it means export")
    @NotNull

    @Valid

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyUsageReadBasicRead energyUsageReadBasicRead = (EnergyUsageReadBasicRead) o;
        return Objects.equals(this.quality, energyUsageReadBasicRead.quality) &&
                Objects.equals(this.value, energyUsageReadBasicRead.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quality, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyUsageReadBasicRead {\n");

        sb.append("    quality: ").append(toIndentedString(quality)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

