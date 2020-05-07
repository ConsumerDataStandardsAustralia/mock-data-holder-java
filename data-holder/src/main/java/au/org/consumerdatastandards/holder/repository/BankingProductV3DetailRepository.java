package au.org.consumerdatastandards.holder.repository;

import au.org.consumerdatastandards.holder.model.BankingProductV3Detail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingProductV3DetailRepository extends CrudRepository<BankingProductV3Detail, String> { }
