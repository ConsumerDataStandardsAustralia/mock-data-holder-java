package au.org.consumerdatastandards.support.data;

public enum CustomDataType {
    DateTime("DateTimeString", Format.DATE_TIME),
    Date("DateString", Format.DATE),
    Duration("DurationString", "P(?:(\\d+(?:[\\.,]\\d+)?W)|(\\d+(?:[\\.,]\\d+)?Y)?(\\d+(?:[\\.,]\\d+)?M)?(\\d+(?:[\\.,]\\d+)?D)?(?:T(\\d+(?:[\\.,]\\d+)?H)?(\\d+(?:[\\.,]\\d+)?M)?(\\d+(?:[\\.,]\\d+)?S)?)?)"),
    MaskedPAN("MaskedPANString", "(x{4} ){3}\\d{4}"),
    MaskedAccount("MaskedAccountString", "(xxx\\-xxx xxxxx|(xxxx ){3})?\\d{4}"),
    NaturalNumber("NaturalNumber", 0, Integer.MAX_VALUE),
    ASCII("ASCIIString", "\\p{Print}*"),
    Unicode("UnicodeString", "(\\p{L}|\\p{Print})*"),
    PositiveInteger("PositiveInteger", 1, Integer.MAX_VALUE),
    NegativeInteger("NegativeInteger", Integer.MIN_VALUE, 0),
    Rate("RateString", "^\\-?(0|1){1}(\\.(\\d){1,16}){0,1}$", -1, 1),
    Amount("AmountString", "^\\-?([1-9](\\d){0,15}|0)\\.(\\d){2,}$"),
    Currency("CurrencyString", "^(AED|AFN|ALL|AMD|ANG|AOA|ARS|AUD|AWG|AZN|BAM|BBD|BDT|BGN|BHD|BIF|BMD|BND|BOB|BOV|BRL|BSD|BTN|BWP|BYN|BZD|CAD|CDF|CHE|CHF|CHW|CLF|CLP|CNY|COP|COU|CRC|CUC|CUP|CVE|CZK|DJF|DKK|DOP|DZD|EGP|ERN|ETB|EUR|FJD|FKP|GBP|GEL|GHS|GIP|GMD|GNF|GTQ|GYD|HKD|HNL|HRK|HTG|HUF|IDR|ILS|INR|IQD|IRR|ISK|JMD|JOD|JPY|KES|KGS|KHR|KMF|KPW|KRW|KWD|KYD|KZT|LAK|LBP|LKR|LRD|LSL|LYD|MAD|MDL|MGA|MKD|MMK|MNT|MOP|MRU|MUR|MVR|MWK|MXN|MXV|MYR|MZN|NAD|NGN|NIO|NOK|NPR|NZD|OMR|PAB|PEN|PGK|PHP|PKR|PLN|PYG|QAR|RON|RSD|RUB|RWF|SAR|SBD|SCR|SDG|SEK|SGD|SHP|SLL|SOS|SRD|SSP|STN|SVC|SYP|SZL|THB|TJS|TMT|TND|TOP|TRY|TTD|TWD|TZS|UAH|UGX|USD|USN|UYI|UYU|UYW|UZS|VES|VND|VUV|WST|XAF|XAG|XAU|XBA|XBB|XBC|XBD|XCD|XDR|XOF|XPD|XPF|XPT|XSU|XTS|XUA|XXX|YER|ZAR|ZMW|ZWL)$"),
    URI("URIString", Format.URI),
    Boolean("Boolean"),
    ExternalRef("ExternalRef"),
    Base64("Base64"),
    IPAddress("IPAddress","\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b"),
    UUID("UUID");

    CustomDataType(String name) {
        this.name = name;
    }

    CustomDataType(String name, Format format) {
        this.name = name;
        this.format = format;
    }

    CustomDataType(String name, String pattern) {
        this.name = name;
        this.pattern = pattern;
    }

    CustomDataType(String name, Number min, Number max) {
        this.name = name;
        this.min = min;
        this.max = max;
    }

    private String name;

    private Format format;

    private String pattern;

    private Number min;

    private Number max;

    CustomDataType(String name, String pattern, Number min, Number max) {
        this(name, min, max);
        this.pattern = pattern;
    }

    public Format getFormat() {
        return format;
    }

    public String getPattern() {
        return pattern;
    }

    public Number getMin() {
        return min;
    }

    public Number getMax() {
        return max;
    }

    public String getName() {
        return name;
    }
}
