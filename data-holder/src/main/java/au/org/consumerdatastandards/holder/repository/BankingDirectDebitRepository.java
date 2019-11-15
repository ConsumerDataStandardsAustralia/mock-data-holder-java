package au.org.consumerdatastandards.holder.repository;

import au.org.consumerdatastandards.holder.model.BankingDirectDebit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankingDirectDebitRepository
    extends PagingAndSortingRepository<BankingDirectDebit, String>, JpaSpecificationExecutor<BankingDirectDebit> {

    Page<BankingDirectDebit> findByAccountId(String accountId, Pageable pageable);
}
