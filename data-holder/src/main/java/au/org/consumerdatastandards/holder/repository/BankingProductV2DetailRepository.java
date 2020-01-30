package au.org.consumerdatastandards.holder.repository;

import au.org.consumerdatastandards.holder.model.BankingProductV2Detail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingProductV2DetailRepository extends CrudRepository<BankingProductV2Detail, String> { }
