package au.org.consumerdatastandards.holder.repository;

import au.org.consumerdatastandards.holder.model.BankingProductV1Detail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingProductV1DetailRepository extends CrudRepository<BankingProductV1Detail, String> { }
