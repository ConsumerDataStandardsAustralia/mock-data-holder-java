package au.org.consumerdatastandards.api.v1_0_0.common.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition
public class ResponseErrorList {

    @Property(
        required = true
    )
    List<Error> errors;
}
