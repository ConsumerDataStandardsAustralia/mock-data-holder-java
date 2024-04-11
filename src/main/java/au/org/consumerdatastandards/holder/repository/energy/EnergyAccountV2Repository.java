package au.org.consumerdatastandards.holder.repository.energy;

import au.org.consumerdatastandards.holder.model.energy.EnergyAccountV2;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EnergyAccountV2Repository extends PagingAndSortingRepository<EnergyAccountV2, String>, JpaSpecificationExecutor<EnergyAccountV2> {
}
