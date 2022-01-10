package au.org.consumerdatastandards.holder.repository;

import au.org.consumerdatastandards.holder.model.banking.BankingBalance;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankingBalanceRepository
    extends PagingAndSortingRepository<BankingBalance, String>, JpaSpecificationExecutor<BankingBalance> {

    BankingBalance findByAccountId(String accountId);
}
