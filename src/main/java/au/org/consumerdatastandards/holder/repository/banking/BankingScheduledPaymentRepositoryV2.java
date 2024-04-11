package au.org.consumerdatastandards.holder.repository.banking;

import au.org.consumerdatastandards.holder.model.banking.BankingScheduledPaymentV2;
import au.org.consumerdatastandards.holder.model.banking.BankingScheduledPaymentFrom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankingScheduledPaymentRepositoryV2
    extends PagingAndSortingRepository<BankingScheduledPaymentV2, String>, JpaSpecificationExecutor<BankingScheduledPaymentV2> {

    Page<BankingScheduledPaymentV2> findByFrom(BankingScheduledPaymentFrom from, Pageable pageable);
}
