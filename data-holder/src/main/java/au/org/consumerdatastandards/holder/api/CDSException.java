package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.ResponseErrorListV2;
import org.springframework.http.HttpStatus;

public class CDSException extends RuntimeException {
	private final ResponseErrorListV2 errors;
	private final HttpStatus status;

	public CDSException(ResponseErrorListV2 errors, HttpStatus status) {
		super();
		this.errors = errors;
		this.status = status;
	}

	public ResponseErrorListV2 getErrors() {
		return errors;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
