package au.org.consumerdatastandards.holder.repository.energy;

import au.org.consumerdatastandards.holder.model.energy.EnergyBalanceListResponseDataBalances;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyAccountBalanceRepository
        extends PagingAndSortingRepository<EnergyBalanceListResponseDataBalances, String>, JpaSpecificationExecutor<EnergyBalanceListResponseDataBalances> {
    EnergyBalanceListResponseDataBalances findByAccountId(String accountId);
}
