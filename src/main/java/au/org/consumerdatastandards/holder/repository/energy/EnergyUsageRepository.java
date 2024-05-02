package au.org.consumerdatastandards.holder.repository.energy;

import au.org.consumerdatastandards.holder.model.energy.EnergyUsageRead;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyUsageRepository
        extends PagingAndSortingRepository<EnergyUsageRead, String>, JpaSpecificationExecutor<EnergyUsageRead> { }
