package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.ErrorListResponse;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class CDSException extends RuntimeException {
	private final ErrorListResponse errors;
	private final HttpStatus status;
	private final UUID interactionId;

	public CDSException(ErrorListResponse errors, UUID interactionId, HttpStatus status) {
		super();
		this.errors = errors;
		this.status = status;
		this.interactionId = interactionId;
	}

	public ErrorListResponse getErrors() {
		return errors;
	}

	public HttpStatus getStatus() {
		return status;
	}

    public UUID getInteractionId() {
        return interactionId;
    }
}
