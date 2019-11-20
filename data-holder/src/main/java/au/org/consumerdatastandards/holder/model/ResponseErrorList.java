package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import java.util.List;

@ApiModel
public class ResponseErrorList  {

    /**
     * Get errors
     */
    
    private List<Error> errors;

    public ResponseErrorList errors(List<Error> errors) {
        this.errors = errors;
        return this;
    }

    public ResponseErrorList addItem(Error errorsItem) {
        this.errors.add(errorsItem);
        return this;
    }

    @ApiModelProperty(required = true)
    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
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
        ResponseErrorList responseErrorList = (ResponseErrorList) o;
        return Objects.equals(this.errors, responseErrorList.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            errors);
    }

    @Override
    public String toString() {
        return "class ResponseErrorList {\n" +
            "   errors: " + toIndentedString(errors) + "\n" + 
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

