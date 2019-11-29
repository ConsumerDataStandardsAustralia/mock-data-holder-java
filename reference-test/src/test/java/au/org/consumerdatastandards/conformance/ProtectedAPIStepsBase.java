package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.support.Header;
import io.restassured.specification.RequestSpecification;

import java.time.OffsetDateTime;

public class ProtectedAPIStepsBase extends APIStepsBase {

    protected RequestSpecification buildHeaders(RequestSpecification given) {
        return super.buildHeaders(given)
                .header("Authorization", "Bearer " + props.getProperty("access.token"))
                .header(Header.FAPI_AUTH_DATE.getKey(), OffsetDateTime.now().toString());
    }
}
