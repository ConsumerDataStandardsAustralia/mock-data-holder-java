package au.org.consumerdatastandards.holder.repository;

import au.org.consumerdatastandards.holder.model.BankingPayee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankingPayeeRepository
    extends PagingAndSortingRepository<BankingPayee, String>, JpaSpecificationExecutor<BankingPayee> {

    Page<BankingPayee> findByType(BankingPayee.Type type, Pageable pageable);
}
