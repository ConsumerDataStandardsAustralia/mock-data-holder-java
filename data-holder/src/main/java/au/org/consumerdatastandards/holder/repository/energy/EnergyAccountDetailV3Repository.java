package au.org.consumerdatastandards.holder.repository.energy;

import au.org.consumerdatastandards.holder.model.energy.EnergyAccountDetailV3;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyAccountDetailV3Repository extends CrudRepository<EnergyAccountDetailV3, String> { }
