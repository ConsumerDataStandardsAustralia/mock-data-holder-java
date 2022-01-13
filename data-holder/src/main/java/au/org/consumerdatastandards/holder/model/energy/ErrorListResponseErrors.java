package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * ErrorListResponseErrors
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class ErrorListResponseErrors {
    @JsonProperty("code")
    private String code;

    @JsonProperty("title")
    private String title;

    @JsonProperty("detail")
    private String detail;

    @JsonProperty("meta")
    private ErrorListResponseMeta meta;

    public ErrorListResponseErrors code(String code) {
        this.code = code;
        return this;
    }

    /**
     * The code of the error encountered. Where the error is specific to the respondent, an application-specific error code, expressed as a string value. If the error is application-specific, the URN code that the specific error extends must be provided in the meta object. Otherwise, the value is the error code URN.
     *
     * @return code
     */
    @ApiModelProperty(required = true,
            value = "The code of the error encountered. Where the error is specific to the respondent, an application-specific error code, expressed as a string value. If the error is application-specific, the URN code that the specific error extends must be provided in the meta object. Otherwise, the value is the error code URN.")
    @NotNull


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ErrorListResponseErrors title(String title) {
        this.title = title;
        return this;
    }

    /**
     * A short, human-readable summary of the problem that MUST NOT change from occurrence to occurrence of the problem represented by the error code.
     *
     * @return title
     */
    @ApiModelProperty(required = true,
            value = "A short, human-readable summary of the problem that MUST NOT change from occurrence to occurrence of the problem represented by the error code.")
    @NotNull


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ErrorListResponseErrors detail(String detail) {
        this.detail = detail;
        return this;
    }

    /**
     * A human-readable explanation specific to this occurrence of the problem.
     *
     * @return detail
     */
    @ApiModelProperty(required = true,
            value = "A human-readable explanation specific to this occurrence of the problem.")
    @NotNull


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ErrorListResponseErrors meta(ErrorListResponseMeta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     */
    @ApiModelProperty(value = "")

    @Valid

    public ErrorListResponseMeta getMeta() {
        return meta;
    }

    public void setMeta(ErrorListResponseMeta meta) {
        this.meta = meta;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorListResponseErrors errorListResponseErrors = (ErrorListResponseErrors) o;
        return Objects.equals(this.code, errorListResponseErrors.code) &&
                Objects.equals(this.title, errorListResponseErrors.title) &&
                Objects.equals(this.detail, errorListResponseErrors.detail) &&
                Objects.equals(this.meta, errorListResponseErrors.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, title, detail, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorListResponseErrors {\n");

        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
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

