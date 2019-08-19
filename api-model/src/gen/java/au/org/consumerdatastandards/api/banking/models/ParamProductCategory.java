package au.org.consumerdatastandards.api.banking.models;

import au.org.consumerdatastandards.support.data.*;

@DataDefinition(
    description = "Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned."
)
public enum ParamProductCategory {
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
