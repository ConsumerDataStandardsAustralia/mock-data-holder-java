package au.org.consumerdatastandards.holder.repository.banking;

import au.org.consumerdatastandards.holder.model.banking.BankingPayeeDetail;
import org.springframework.data.repository.CrudRepository;

public interface BankingPayeeDetailRepository extends CrudRepository<BankingPayeeDetail, String> { }