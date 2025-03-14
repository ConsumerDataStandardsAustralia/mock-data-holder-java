/*
 * Consumer Data Standards
 * Sample Data Holder to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 * Do not edit the class manually.
 */
package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class Links  {

    /**
     * Fully qualified link that generated the current response document.
     */
    private String self;

    public Links self(String self) {
        this.self = self;
        return this;
    }

    @ApiModelProperty(required = true, value = "Fully qualified link that generated the current response document.")
    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Links links = (Links) o;
        return Objects.equals(this.self, links.self);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            self);
    }

    @Override
    public String toString() {
        return "class Links {\n" +
            "   self: " + toIndentedString(self) + "\n" + 
            "}";
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

