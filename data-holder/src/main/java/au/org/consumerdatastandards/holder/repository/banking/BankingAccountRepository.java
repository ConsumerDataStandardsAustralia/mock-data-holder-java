package au.org.consumerdatastandards.holder.repository.banking;

import au.org.consumerdatastandards.holder.model.banking.BankingAccount;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankingAccountRepository
    extends PagingAndSortingRepository<BankingAccount, String>, JpaSpecificationExecutor<BankingAccount> { }
