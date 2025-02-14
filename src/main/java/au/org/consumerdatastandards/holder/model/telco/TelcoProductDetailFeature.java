package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * TelcoProductDetailFeature
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoProductDetailFeature {
    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("description")
    private String description;

    /**
     * The type of the feature.
     */
    public enum CategoryEnum {
        DATA("DATA"),

        VOICE("VOICE"),

        MESSAGING("MESSAGING"),

        HANDSET("HANDSET"),

        DEVICE("DEVICE"),

        NETWORK("NETWORK"),

        ENTERTAINMENT("ENTERTAINMENT"),

        SUBSCRIPTION("SUBSCRIPTION"),

        SOFTWARE("SOFTWARE"),

        OTHER("OTHER");

        private String value;

        CategoryEnum(String value) {
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
        public static CategoryEnum fromValue(String value) {
            for (CategoryEnum b : CategoryEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("category")
    private CategoryEnum category;

    public TelcoProductDetailFeature displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The display name of the feature.
     *
     * @return displayName
     */
    @ApiModelProperty(required = true,
            value = "The display name of the feature.")
    @NotNull


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public TelcoProductDetailFeature description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the feature.
     *
     * @return description
     */
    @ApiModelProperty(value = "The description of the feature.")


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TelcoProductDetailFeature category(CategoryEnum category) {
        this.category = category;
        return this;
    }

    /**
     * The type of the feature.
     *
     * @return category
     */
    @ApiModelProperty(value = "The type of the feature.")


    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoProductDetailFeature telcoProductDetailFeature = (TelcoProductDetailFeature) o;
        return Objects.equals(this.displayName, telcoProductDetailFeature.displayName) &&
                Objects.equals(this.description, telcoProductDetailFeature.description) &&
                Objects.equals(this.category, telcoProductDetailFeature.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, category);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoProductDetailFeature {\n");

        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
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

