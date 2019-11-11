package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class Error  {

    /**
     * Must be one of the following: 0001 – Account not able to be found
     */
    private String code;

    /**
     * ID of the account not found
     */
    private String detail;

    /**
     * Get meta
     */
    private Object meta;

    /**
     * Must be one of the following: Invalid account
     */
    private String title;

    public Error code(String code) {
        this.code = code;
        return this;
    }

    @ApiModelProperty(required = true, value = "Must be one of the following: 0001 – Account not able to be found")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public Error detail(String detail) {
        this.detail = detail;
        return this;
    }

    @ApiModelProperty(required = true, value = "ID of the account not found")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    public Error meta(Object meta) {
        this.meta = meta;
        return this;
    }

    @ApiModelProperty
    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }
    public Error title(String title) {
        this.title = title;
        return this;
    }

    @ApiModelProperty(required = true, value = "Must be one of the following: Invalid account")
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
        Error responseErrorListErrors = (Error) o;
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

