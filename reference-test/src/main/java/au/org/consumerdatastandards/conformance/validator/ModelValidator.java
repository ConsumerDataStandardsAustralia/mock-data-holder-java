package au.org.consumerdatastandards.conformance.validator;

import au.org.consumerdatastandards.conformance.ConformanceError;

import java.util.List;

public interface ModelValidator<T> {

    List<ConformanceError> validate(T object);
}
