package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.CDSDataType;
import au.org.consumerdatastandards.support.data.CustomDataType;
import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

@DataDefinition(
    referenced = false
)
public class BankingProductV2CardArt {

    @Property(
        description = "Display label for the specific image"
    )
    String title;

    @Property(
        description = "Link to a PNG, JPG or GIF image with proportions defined by ISO 7810 ID-1 and width no greater than 512 pixels",
        required = true
    )
    @CDSDataType(CustomDataType.URI)
    String imageUri;
}
