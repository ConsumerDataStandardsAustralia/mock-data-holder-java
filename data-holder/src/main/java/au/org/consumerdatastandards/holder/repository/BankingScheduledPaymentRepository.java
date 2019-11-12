package au.org.consumerdatastandards.holder.repository;

import au.org.consumerdatastandards.holder.model.BankingScheduledPayment;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankingScheduledPaymentRepository
    extends PagingAndSortingRepository<BankingScheduledPayment, String>, JpaSpecificationExecutor<BankingScheduledPayment> { }
