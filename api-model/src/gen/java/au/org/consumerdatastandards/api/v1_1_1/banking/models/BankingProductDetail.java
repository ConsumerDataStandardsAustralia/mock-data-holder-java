package au.org.consumerdatastandards.api.v1_1_1.banking.models;

import au.org.consumerdatastandards.support.data.DataDefinition;
import au.org.consumerdatastandards.support.data.Property;

import java.util.List;

@DataDefinition(
    allOf = { BankingProductV2.class }
)
public class BankingProductDetail {

    @Property(
        description = "An array of bundles that this product participates in.  Each bundle is described by free form information but also by a list of product IDs of the other products that are included in the bundle.  It is assumed that the current product is included in the bundle also"
    )
    List<BankingProductBundle> bundles;

    @Property(
        description = "Array of features available for the product"
    )
    List<BankingProductFeature> features;

    @Property(
        description = "Constraints on the application for or operation of the product such as minimum balances or limit thresholds"
    )
    List<BankingProductConstraint> constraints;

    @Property(
        description = "Eligibility criteria for the product"
    )
    List<BankingProductEligibility> eligibility;

    @Property(
        description = "Fees applicable for the product"
    )
    List<BankingProductFee> fees;

    @Property(
        description = "Interest rates available for deposits"
    )
    List<BankingProductDepositRate> depositRates;

    @Property(
        description = "Interest rates charged against lending balances"
    )
    List<BankingProductLendingRate> lendingRates;
}
