package au.org.consumerdatastandards.holder.repository.banking;

import au.org.consumerdatastandards.holder.model.banking.BankingProductDetailV4;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingProductDetailV4Repository extends CrudRepository<BankingProductDetailV4, String> { }
