package au.org.consumerdatastandards.support;

public class ValidationError {

    private String description;

    public ValidationError(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
