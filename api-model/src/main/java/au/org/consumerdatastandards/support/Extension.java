package au.org.consumerdatastandards.support;

public enum Extension {

    SCOPES("x-scopes"),

    VERSION("x-version"),

    CDS_TYPE("x-cds-type");

    private String key;

    Extension(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public Extension fromKey(String key) {
        for (Extension extension: values()) {
            if (extension.key.equals(key)) {
                return extension;
            }
        }
        return null;
    }
}
