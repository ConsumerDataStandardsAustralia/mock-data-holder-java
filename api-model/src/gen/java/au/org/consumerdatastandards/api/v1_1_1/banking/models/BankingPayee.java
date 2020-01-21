package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.CustomDataType;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

import java.time.LocalDate;

@DataDefinition
public class BankingPayee {

    public enum Type {
        DOMESTIC,
        INTERNATIONAL,
        BILLER
    }

    @Property(
        description = "ID of the payee adhering to the rules of ID permanence",
        required = true
    )
    @CDSDataType(CustomDataType.ASCII)
    String payeeId;

    @Property(
        description = "The short display name of the payee as provided by the customer",
        required = true
    )
    String nickname;

    @Property(
        description = "A description of the payee provided by the customer"
    )
    String description;

    @Property(
        description = "The type of payee. DOMESTIC means a registered payee for domestic payments including NPP. INTERNATIONAL means a registered payee for international payments. BILLER means a registered payee for BPAY",
        required = true
    )
    Type type;

    @Property(
        description = "The date the payee was created by the customer"
    )
    @CDSDataType(CustomDataType.Date)
    LocalDate creationDate;
}
