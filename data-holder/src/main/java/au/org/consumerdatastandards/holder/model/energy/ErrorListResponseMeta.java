package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Additional data for customised error codes
 */
@ApiModel(description = "Additional data for customised error codes")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class ErrorListResponseMeta {
    @JsonProperty("urn")
    private String urn;

    public ErrorListResponseMeta urn(String urn) {
        this.urn = urn;
        return this;
    }

    /**
     * The CDR error code URN which the application-specific error code extends. Mandatory if the error `code` is an application-specific error rather than a standardised error code.
     *
     * @return urn
     */
    @ApiModelProperty(value = "The CDR error code URN which the application-specific error code extends. Mandatory if the error `code` is an application-specific error rather than a standardised error code.")


    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorListResponseMeta errorListResponseMeta = (ErrorListResponseMeta) o;
        return Objects.equals(this.urn, errorListResponseMeta.urn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(urn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorListResponseMeta {\n");

        sb.append("    urn: ").append(toIndentedString(urn)).append("\n");
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

