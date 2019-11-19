package au.org.consumerdatastandards.holder.api;

public class VersionNotSupportedException extends RuntimeException {

    public VersionNotSupportedException(String message) {
        super(message);
    }
}
