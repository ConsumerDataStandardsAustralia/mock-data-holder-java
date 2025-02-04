package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Mandatory if _readUType_ is set to `basicRead`.
 */
@ApiModel(description = "Mandatory if _readUType_ is set to `basicRead`.")
@Entity
public class EnergyUsageReadBasicRead {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * The quality of the read taken. If absent then assumed to be `ACTUAL`.
     */
    public enum QualityEnum {
        ACTUAL,
        SUBSTITUTE,
        FINAL_SUBSTITUTE
    }

    private QualityEnum quality = QualityEnum.ACTUAL;

    @Column(name = "read_value")
    private BigDecimal value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyUsageReadBasicRead quality(QualityEnum quality) {
        this.quality = quality;
        return this;
    }

    /**
     * The quality of the read taken. If absent then assumed to be `ACTUAL`.
     *
     * @return quality
     */
    @ApiModelProperty(value = "The quality of the read taken. If absent then assumed to be `ACTUAL`.")
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
     * Meter read value. If positive then it means consumption, if negative it means export.
     *
     * @return value
     */
    @ApiModelProperty(required = true,
            value = "Meter read value. If positive then it means consumption, if negative it means export.")
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
