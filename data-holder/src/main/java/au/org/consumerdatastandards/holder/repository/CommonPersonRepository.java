package au.org.consumerdatastandards.holder.repository;

import au.org.consumerdatastandards.holder.model.CommonPerson;
import org.springframework.data.repository.CrudRepository;

public interface CommonPersonRepository extends CrudRepository<CommonPerson, String> { }
