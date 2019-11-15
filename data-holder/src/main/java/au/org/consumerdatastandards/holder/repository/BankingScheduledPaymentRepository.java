package au.org.consumerdatastandards.holder.repository;

import au.org.consumerdatastandards.holder.model.BankingScheduledPayment;
import au.org.consumerdatastandards.holder.model.BankingScheduledPaymentFrom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankingScheduledPaymentRepository
    extends PagingAndSortingRepository<BankingScheduledPayment, String>, JpaSpecificationExecutor<BankingScheduledPayment> {

    Page<BankingScheduledPayment> findByFrom(BankingScheduledPaymentFrom from, Pageable pageable);
}
