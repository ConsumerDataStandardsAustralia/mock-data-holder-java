package au.org.consumerdatastandards.holder.repository;

import au.org.consumerdatastandards.holder.model.BankingTransaction;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankingTransactionRepository
    extends PagingAndSortingRepository<BankingTransaction, String>, JpaSpecificationExecutor<BankingTransaction> { }
