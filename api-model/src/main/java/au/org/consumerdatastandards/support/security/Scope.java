package au.org.consumerdatastandards.support.security;

public enum Scope {
    UNDEFINED_SCOPE("undefined"),
	COMMON_BASIC_CUSTOMER("common_basic_consumer"),
    BANK_PAYEES("bank_payees"), 
    BANK_BASIC_ACCOUNTS("bank_basic_accounts"), 
    BANK_DETAILED_ACCOUNTS("bank_detailed_accounts"),
    BANK_TRANSACTIONS("bank_transactions"), 
    COMMON_DETAILED_CUSTOMER("common_detailed_customer");
    
    String name;

    Scope(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
