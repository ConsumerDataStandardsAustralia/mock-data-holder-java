package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
* Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned.
*/
public enum ParamProductCategory {

    BUSINESS_LOANS,
    
    CRED_AND_CHRG_CARDS,
    
    LEASES,
    
    MARGIN_LOANS,
    
    OVERDRAFTS,
    
    PERS_LOANS,
    
    REGULATED_TRUST_ACCOUNTS,
    
    RESIDENTIAL_MORTGAGES,
    
    TERM_DEPOSITS,
    
    TRADE_FINANCE,
    
    TRANS_AND_SAVINGS_ACCOUNTS,
    
    TRAVEL_CARDS
}
