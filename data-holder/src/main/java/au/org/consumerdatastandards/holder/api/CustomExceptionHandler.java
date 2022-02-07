package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.Error;
import au.org.consumerdatastandards.holder.model.ErrorListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(
            ConstraintViolationException ex, WebRequest request) {
        ErrorListResponse errors = new ErrorListResponse();
        errors.setErrors(new ArrayList<>());
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            Error error = new Error();
            error.setTitle("Invalid Field");
            error.setCode("urn:au-cds:error:cds-all:Field/Invalid");
            error.setDetail(violation.getPropertyPath().toString().replaceAll(".*\\.", "") + ": " + violation.getMessage());
            errors.addItem(error);
        }
        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CDSException.class)
    @SuppressWarnings("unused")
    public final ResponseEntity<Object> handleCDSException(CDSException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getErrors(), ex.getHeaders(), ex.getStatus());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @SuppressWarnings("unused")
    public final ResponseEntity<Object> handleArgException(MethodArgumentTypeMismatchException ex, WebRequest request) {
        return new ResponseEntity<>(ex.toString(), null, HttpStatus.BAD_REQUEST);
    }
}
