package au.org.consumerdatastandards.holder.repository.energy;

import au.org.consumerdatastandards.holder.model.energy.EnergyAccountDetailV1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyAccountDetailV1Repository extends CrudRepository<EnergyAccountDetailV1, String> { }
