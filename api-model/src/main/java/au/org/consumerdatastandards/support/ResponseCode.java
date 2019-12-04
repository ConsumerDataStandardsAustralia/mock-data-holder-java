package au.org.consumerdatastandards.support;

/**
 *  This enum defines a subset of HTTP response codes specified in
 *  <a href="https://tools.ietf.org/html/rfc7231">RFC7231</a> and
 *  <a href="https://tools.ietf.org/html/rfc7235">RFC7235</a>
 *  These codes may be used in responses defined in CDS
 *
 */
public enum ResponseCode {
    OK(200),
    CREATED(201),
    ACCEPTED(202),
    NO_CONTENT(204),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    UNPROCESSABLE_ENTITY(422),
    TOO_MANY_REQUESTS(429);

    int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ResponseCode fromCode(int code) {
        for (ResponseCode responseCode : values()) {
            if (responseCode.code == code) {
                return responseCode;
            }
        }
        return null;
    }
}
