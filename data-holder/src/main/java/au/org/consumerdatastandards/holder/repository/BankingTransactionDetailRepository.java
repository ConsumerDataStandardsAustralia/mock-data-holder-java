package au.org.consumerdatastandards.holder.repository;

import au.org.consumerdatastandards.holder.model.banking.BankingTransactionDetail;
import org.springframework.data.repository.CrudRepository;

public interface BankingTransactionDetailRepository extends CrudRepository<BankingTransactionDetail, String> { }
