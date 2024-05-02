package au.org.consumerdatastandards.holder.repository.energy;

import au.org.consumerdatastandards.holder.model.energy.EnergyDerRecord;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyDerRecordRepository
        extends PagingAndSortingRepository<EnergyDerRecord, String>, JpaSpecificationExecutor<EnergyDerRecord> {
    EnergyDerRecord findByServicePointId(String servicePointId);
}
