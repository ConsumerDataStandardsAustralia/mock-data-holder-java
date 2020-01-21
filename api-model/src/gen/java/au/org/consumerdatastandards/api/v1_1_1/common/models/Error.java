package au.org.consumerdatastandards.api.v1_1_1.common.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class Error {

    @Property(
        description = "Must be one of the following: 0001 – Account not able to be found",
        required = true
    )
    String code;

    @Property(
        description = "Must be one of the following: Invalid account",
        required = true
    )
    String title;

    @Property(
        description = "ID of the account not found",
        required = true
    )
    String detail;

    @Property(
        description = "Optional additional data for specific error types"
    )
    Object meta;
}
