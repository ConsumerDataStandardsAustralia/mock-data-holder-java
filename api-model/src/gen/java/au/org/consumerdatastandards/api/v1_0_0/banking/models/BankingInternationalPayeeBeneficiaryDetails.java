package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class BankingInternationalPayeeBeneficiaryDetails {

    @Property(
        description = "Name of the beneficiary"
    )
    String name;

    @Property(
        description = "Country where the beneficiary resides. A valid [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country code",
        required = true
    )
    @CDSDataType(CustomDataType.ExternalRef)
    String country;

    @Property(
        description = "Response message for the payment"
    )
    String message;
}
