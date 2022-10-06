package au.org.consumerdatastandards.holder.repository.energy;

import au.org.consumerdatastandards.holder.model.energy.EnergyAccountV1;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EnergyAccountV1Repository extends PagingAndSortingRepository<EnergyAccountV1, String>, JpaSpecificationExecutor<EnergyAccountV1> {
}
