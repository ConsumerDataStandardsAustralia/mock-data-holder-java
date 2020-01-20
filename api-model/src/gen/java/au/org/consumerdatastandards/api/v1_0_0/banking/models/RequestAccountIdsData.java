package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import java.util.List;
import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class RequestAccountIdsData {

    @Property(
        required = true
    )
    List<String> accountIds;
}
