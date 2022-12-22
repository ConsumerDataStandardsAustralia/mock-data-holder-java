package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.Error;
import au.org.consumerdatastandards.holder.model.ErrorListResponse;
import au.org.consumerdatastandards.holder.util.WebUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.UUID;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String X_FAPI_INTERACTION_ID = "x-fapi-interaction-id";

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException ex, WebRequest request) {
        ErrorListResponse errors = new ErrorListResponse();
        errors.setErrors(new ArrayList<>());
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.addItem(createInvalidFieldError(
                    violation.getPropertyPath().toString().replaceAll(".*\\.", "") + ": " + violation.getMessage()));
        }
        return createBadRequestResponse(request, errors);
    }

    @ExceptionHandler(CDSException.class)
    @SuppressWarnings("unused")
    public final ResponseEntity<Object> handleCDSException(CDSException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getErrors(), createResponseHeaders(ex.getInteractionId()), ex.getStatus());
    }

    private static Error createInvalidHeaderError(String name, Object value) {
        return new Error("Invalid Header", "urn:au-cds:error:cds-all:Header/Invalid",
                name + " is not in a valid format: " + value);
    }

    private static Error createInvalidFieldError(String detail) {
        return new Error("Invalid Field", "urn:au-cds:error:cds-all:Field/Invalid", detail);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @SuppressWarnings("unused")
    public final ResponseEntity<Object> handleArgException(MethodArgumentTypeMismatchException ex, WebRequest request) {
        ErrorListResponse errors = new ErrorListResponse();
        errors.setErrors(new ArrayList<>());

        String name = ex.getName();
        if (ex.getParameter().hasParameterAnnotation(RequestParam.class)) {
            errors.addItem(createInvalidFieldError(name + " is not a positive integer: " + ex.getValue()));
        } else if ("x-v".equals(name) || "x-min-v".equals(name)) {
            errors.addItem(new Error("Invalid Version", "urn:au-cds:error:cds-all:Header/InvalidVersion",
                    name + " is not a positive integer: " + ex.getValue()));
        } else if (!X_FAPI_INTERACTION_ID.equals(name)) {
            errors.addItem(createInvalidHeaderError(name, ex.getValue()));
        }

        return createBadRequestResponse(request, errors);
    }

    private static ResponseEntity<Object> createBadRequestResponse(WebRequest request, ErrorListResponse errors) {
        String xFapiInteractionId = request.getHeader(X_FAPI_INTERACTION_ID);
        UUID xFapiInteractionUUID = null;
        if (xFapiInteractionId != null) {
            try {
                xFapiInteractionUUID = UUID.fromString(xFapiInteractionId);
            } catch (IllegalArgumentException e) {
                errors.addItem(createInvalidHeaderError(X_FAPI_INTERACTION_ID, xFapiInteractionId));
            }
        }
        return new ResponseEntity<>(errors, createResponseHeaders(xFapiInteractionUUID), HttpStatus.BAD_REQUEST);
    }

    private static MultiValueMap<String, String> createResponseHeaders(UUID interactionId) {
        MultiValueMap<String, String> headers;
        if (interactionId == WebUtil.NO_INTERACTION_ID) {
            headers = null;
        } else {
            headers = new HttpHeaders();
            headers.add(X_FAPI_INTERACTION_ID, (interactionId == null ? java.util.UUID.randomUUID() : interactionId).toString());
        }
        return headers;
    }
}
