package au.org.consumerdatastandards.holder.repository.energy;

import au.org.consumerdatastandards.holder.model.energy.EnergyBillingTransaction;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyBillingTransactionRepository
        extends PagingAndSortingRepository<EnergyBillingTransaction, String>, JpaSpecificationExecutor<EnergyBillingTransaction> { }
