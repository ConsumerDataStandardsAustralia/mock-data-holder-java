package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@ApiModel
public class MetaError {

	/**
	 * The CDR error code URN which the application-specific error code extends. Mandatory if the error `code` is an application-specific error rather than a standardised error code.
	 */
	private String urn;

	@ApiModelProperty(value = "The CDR error code URN which the application-specific error code extends. Mandatory if the error `code` is an application-specific error rather than a standardised error code")
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
		MetaError metaError = (MetaError) o;
		return Objects.equals(urn, metaError.urn);
	}

	@Override
	public int hashCode() {
		return Objects.hash(urn);
	}

	@Override
	public String toString() {
		return "class Error {\n" +
				"   urn: " + toIndentedString(urn) + "\n" +
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
