package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    referenced = false
)
public class BankingInternationalPayeeBankDetails {

    @Property(
        description = "Country of the recipient institution. A valid [ISO 3166 Alpha-3](https://www.iso.org/iso-3166-country-codes.html) country code",
        required = true
    )
    @CDSDataType(CustomDataType.ExternalRef)
    String country;

    @Property(
        description = "Account Targeted for payment",
        required = true
    )
    String accountNumber;

    @Property
    BankingInternationalPayeeBankDetailsBankAddress bankAddress;

    @Property(
        description = "Swift bank code.  Aligns with standard [ISO 9362](https://www.iso.org/standard/60390.html)"
    )
    @CDSDataType(CustomDataType.ExternalRef)
    String beneficiaryBankBIC;

    @Property(
        description = "Number for Fedwire payment (Federal Reserve Wire Network)"
    )
    String fedWireNumber;

    @Property(
        description = "Sort code used for account identification in some jurisdictions"
    )
    String sortCode;

    @Property(
        description = "Number for the Clearing House Interbank Payments System"
    )
    String chipNumber;

    @Property(
        description = "International bank routing number"
    )
    String routingNumber;

    @Property(
        description = "The legal entity identifier (LEI) for the beneficiary.  Aligns with [ISO 17442](https://www.iso.org/standard/59771.html)"
    )
    @CDSDataType(CustomDataType.ExternalRef)
    String legalEntityIdentifier;
}
