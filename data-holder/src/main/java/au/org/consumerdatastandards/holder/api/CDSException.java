package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.ErrorListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;

public class CDSException extends RuntimeException {
	private final ErrorListResponse errors;
	private final HttpStatus status;
	private final MultiValueMap<String, String> headers;

	public CDSException(ErrorListResponse errors, MultiValueMap<String, String> headers, HttpStatus status) {
		super();
		this.errors = errors;
		this.status = status;
		this.headers = headers;
	}

	public ErrorListResponse getErrors() {
		return errors;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public MultiValueMap<String, String> getHeaders() {
		return headers;
	}
}
