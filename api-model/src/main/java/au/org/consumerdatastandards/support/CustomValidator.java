package au.org.consumerdatastandards.support;

public interface CustomValidator<T> {

    ValidationError validate(T object);
}
