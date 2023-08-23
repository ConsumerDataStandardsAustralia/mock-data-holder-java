package au.org.consumerdatastandards.holder.repository.energy;

import au.org.consumerdatastandards.holder.model.energy.EnergyServicePoint;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyServicePointRepository
        extends PagingAndSortingRepository<EnergyServicePoint, String>, JpaSpecificationExecutor<EnergyServicePoint> { }
