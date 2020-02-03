package au.org.consumerdatastandards.api.v1_0_0.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    description = "The category to which a product or account belongs. See [here](#product-categories) for more details"
)
public enum BankingProductCategory {
    TRANS_AND_SAVINGS_ACCOUNTS,
    TERM_DEPOSITS,
    TRAVEL_CARDS,
    REGULATED_TRUST_ACCOUNTS,
    RESIDENTIAL_MORTGAGES,
    CRED_AND_CHRG_CARDS,
    PERS_LOANS,
    MARGIN_LOANS,
    LEASES,
    TRADE_FINANCE,
    OVERDRAFTS,
    BUSINESS_LOANS
}
