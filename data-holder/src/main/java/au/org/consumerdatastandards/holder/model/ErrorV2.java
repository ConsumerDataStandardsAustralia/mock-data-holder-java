package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class ErrorV2 {

    /**
     * The code of the error encountered. Where the error is specific to the respondent, an application-specific error code, expressed as a string value. If the error is application-specific, the URN code that the specific error extends must be provided in the meta object. Otherwise, the value is the error code URN.
     */
    private String code;

    /**
     * A human-readable explanation specific to this occurrence of the problem.
     */
    private String detail;

    /**
     * Additional data for customised error codes
     */
    private MetaError meta;

    /**
     * A short, human-readable summary of the problem that MUST NOT change from occurrence to occurrence of the problem represented by the error code.
     */
    private String title;

    public ErrorV2 code(String code) {
        this.code = code;
        return this;
    }

    @ApiModelProperty(required = true, value = "The code of the error encountered. Where the error is specific to the respondent, an application-specific error code, expressed as a string value. If the error is application-specific, the URN code that the specific error extends must be provided in the meta object. Otherwise, the value is the error code URN")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ErrorV2 detail(String detail) {
        this.detail = detail;
        return this;
    }

    @ApiModelProperty(required = true, value = "A human-readable explanation specific to this occurrence of the problem")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ErrorV2 meta(MetaError meta) {
        this.meta = meta;
        return this;
    }

    @ApiModelProperty(value = "Additional data for customised error codes")
    public MetaError getMeta() {
        return meta;
    }

    public void setMeta(MetaError meta) {
        this.meta = meta;
    }

    public ErrorV2 title(String title) {
        this.title = title;
        return this;
    }

    @ApiModelProperty(required = true, value = "A short, human-readable summary of the problem that MUST NOT change from occurrence to occurrence of the problem represented by the error code")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorV2 responseErrorListErrors = (ErrorV2) o;
        return Objects.equals(this.code, responseErrorListErrors.code) &&
            Objects.equals(this.detail, responseErrorListErrors.detail) &&
            Objects.equals(this.meta, responseErrorListErrors.meta) &&
            Objects.equals(this.title, responseErrorListErrors.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            code,
            detail,
            meta,
            title);
    }

    @Override
    public String toString() {
        return "class Error {\n" +
            "   code: " + toIndentedString(code) + "\n" + 
            "   detail: " + toIndentedString(detail) + "\n" + 
            "   meta: " + toIndentedString(meta) + "\n" + 
            "   title: " + toIndentedString(title) + "\n" + 
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
