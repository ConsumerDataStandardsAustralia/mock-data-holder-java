package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * EnergyServicePointConsumerProfile
 */
@Entity
public class EnergyServicePointConsumerProfile {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * A code that defines the consumer class as defined in the National Energy Retail Regulations, or in overriding Jurisdictional instruments
     */
    public enum ClassificationEnum {
        BUSINESS,
        RESIDENTIAL
    }

    private ClassificationEnum classification;

    /**
     * A code that defines the consumption threshold as defined in the National Energy Retail Regulations, or in overriding Jurisdictional instruments. Note the details of enumeration values below: <ul><li>**LOW** - Consumption is less than the ‘lower consumption threshold’ as defined in the National Energy Retail Regulations</li><li>**MEDIUM** - Consumption is equal to or greater than the ‘lower consumption threshold’, but less than the ‘upper consumption threshold’, as defined in the National Energy Retail Regulations</li><li>**HIGH** - Consumption is equal to or greater than the ‘upper consumption threshold’ as defined in the National Energy Retail Regulations</li></ul>
     */
    public enum ThresholdEnum {
        LOW,
        MEDIUM,
        HIGH
    }

    private ThresholdEnum threshold;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EnergyServicePointConsumerProfile classification(ClassificationEnum classification) {
        this.classification = classification;
        return this;
    }

    /**
     * A code that defines the consumer class as defined in the National Energy Retail Regulations, or in overriding Jurisdictional instruments
     *
     * @return classification
     */
    @ApiModelProperty(value = "A code that defines the consumer class as defined in the National Energy Retail Regulations, or in overriding Jurisdictional instruments")
    public ClassificationEnum getClassification() {
        return classification;
    }

    public void setClassification(ClassificationEnum classification) {
        this.classification = classification;
    }

    public EnergyServicePointConsumerProfile threshold(ThresholdEnum threshold) {
        this.threshold = threshold;
        return this;
    }

    /**
     * A code that defines the consumption threshold as defined in the National Energy Retail Regulations, or in overriding Jurisdictional instruments. Note the details of enumeration values below: <ul><li>**LOW** - Consumption is less than the ‘lower consumption threshold’ as defined in the National Energy Retail Regulations</li><li>**MEDIUM** - Consumption is equal to or greater than the ‘lower consumption threshold’, but less than the ‘upper consumption threshold’, as defined in the National Energy Retail Regulations</li><li>**HIGH** - Consumption is equal to or greater than the ‘upper consumption threshold’ as defined in the National Energy Retail Regulations</li></ul>
     *
     * @return threshold
     */
    @ApiModelProperty(value = "A code that defines the consumption threshold as defined in the National Energy Retail Regulations, or in overriding Jurisdictional instruments. Note the details of enumeration values below: <ul><li>**LOW** - Consumption is less than the ‘lower consumption threshold’ as defined in the National Energy Retail Regulations</li><li>**MEDIUM** - Consumption is equal to or greater than the ‘lower consumption threshold’, but less than the ‘upper consumption threshold’, as defined in the National Energy Retail Regulations</li><li>**HIGH** - Consumption is equal to or greater than the ‘upper consumption threshold’ as defined in the National Energy Retail Regulations</li></ul>")
    public ThresholdEnum getThreshold() {
        return threshold;
    }

    public void setThreshold(ThresholdEnum threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyServicePointConsumerProfile energyServicePointConsumerProfile = (EnergyServicePointConsumerProfile) o;
        return Objects.equals(this.classification, energyServicePointConsumerProfile.classification) &&
                Objects.equals(this.threshold, energyServicePointConsumerProfile.threshold);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classification, threshold);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyServicePointConsumerProfile {\n");
        sb.append("    classification: ").append(toIndentedString(classification)).append("\n");
        sb.append("    threshold: ").append(toIndentedString(threshold)).append("\n");
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
