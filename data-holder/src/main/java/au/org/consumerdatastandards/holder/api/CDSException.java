package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.ResponseErrorListV2;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;

public class CDSException extends RuntimeException {
	private final ResponseErrorListV2 errors;
	private final HttpStatus status;
	private final MultiValueMap<String, String> headers;

	public CDSException(ResponseErrorListV2 errors, MultiValueMap<String, String> headers, HttpStatus status) {
		super();
		this.errors = errors;
		this.status = status;
		this.headers = headers;
	}

	public ResponseErrorListV2 getErrors() {
		return errors;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public MultiValueMap<String, String> getHeaders() {
		return headers;
	}
}
