package au.org.consumerdatastandards.holder.repository.banking;

import au.org.consumerdatastandards.holder.model.banking.BankingScheduledPaymentFrom;
import au.org.consumerdatastandards.holder.model.banking.BankingScheduledPaymentV1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankingScheduledPaymentRepositoryV1
    extends PagingAndSortingRepository<BankingScheduledPaymentV1, String>, JpaSpecificationExecutor<BankingScheduledPaymentV1> {

    Page<BankingScheduledPaymentV1> findByFrom(BankingScheduledPaymentFrom from, Pageable pageable);
}
