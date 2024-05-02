package au.org.consumerdatastandards.holder.repository.energy;

import au.org.consumerdatastandards.holder.model.energy.EnergyAccountDetailV2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyAccountDetailV2Repository extends CrudRepository<EnergyAccountDetailV2, String> { }
