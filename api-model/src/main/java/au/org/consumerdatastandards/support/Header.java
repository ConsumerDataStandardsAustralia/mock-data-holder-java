package au.org.consumerdatastandards.support;

import au.org.consumerdatastandards.support.data.CustomDataType;

public enum Header {

    VERSION("x-v", CustomDataType.PositiveInteger),

    MIN_VERSION("x-min-v", CustomDataType.PositiveInteger),

    FAPI_INTERACTION_ID("x-fapi-interaction-id", CustomDataType.UUID),

    FAPI_AUTH_DATE("x-fapi-auth-date", CustomDataType.DateTime),

    FAPI_CUSTOMER_IP_ADDRESS("x-fapi-customer-ip-address", CustomDataType.IPAddress),

    CDS_USER_AGENT("x-cds-User-Agent", CustomDataType.Base64),

    CDS_SUBJECT("x-cds-subject", CustomDataType.ASCII);

    private String name;

    private CustomDataType customDataType;

    Header(String name, CustomDataType customDataType) {
        this.name = name;
        this.customDataType = customDataType;
    }

    public String getName() {
        return name;
    }

    public CustomDataType getCustomDataType() {
        return customDataType;
    }

    public Header fromName(String name) {
        for (Header header: values()) {
            if (header.name.equals(name)) {
                return header;
            }
        }
        return null;
    }
}
