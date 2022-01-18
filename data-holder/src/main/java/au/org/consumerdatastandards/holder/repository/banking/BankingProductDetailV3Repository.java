package au.org.consumerdatastandards.holder.repository.banking;

import au.org.consumerdatastandards.holder.model.banking.BankingProductDetailV3;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingProductDetailV3Repository extends CrudRepository<BankingProductDetailV3, String> { }
