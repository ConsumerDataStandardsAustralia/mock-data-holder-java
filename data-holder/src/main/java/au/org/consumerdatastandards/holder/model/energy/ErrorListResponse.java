package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ErrorListResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class ErrorListResponse {
    @JsonProperty("errors")
    @Valid
    private List<ErrorListResponseErrors> errors = new ArrayList<>();

    public ErrorListResponse errors(List<ErrorListResponseErrors> errors) {
        this.errors = errors;
        return this;
    }

    public ErrorListResponse addErrorsItem(ErrorListResponseErrors errorsItem) {
        this.errors.add(errorsItem);
        return this;
    }

    /**
     * Get errors
     *
     * @return errors
     */
    @ApiModelProperty(required = true,
            value = "")
    @NotNull

    @Valid

    public List<ErrorListResponseErrors> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorListResponseErrors> errors) {
        this.errors = errors;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorListResponse errorListResponse = (ErrorListResponse) o;
        return Objects.equals(this.errors, errorListResponse.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorListResponse {\n");

        sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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

