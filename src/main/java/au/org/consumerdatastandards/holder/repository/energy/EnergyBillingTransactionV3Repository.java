package au.org.consumerdatastandards.holder.repository.energy;

import au.org.consumerdatastandards.holder.model.energy.EnergyBillingTransactionV3;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyBillingTransactionV3Repository
        extends PagingAndSortingRepository<EnergyBillingTransactionV3, String>, JpaSpecificationExecutor<EnergyBillingTransactionV3> { }
