package au.org.consumerdatastandards.holder.repository.banking;

import au.org.consumerdatastandards.holder.model.banking.BankingAccountV1;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankingAccountRepositoryV1
    extends PagingAndSortingRepository<BankingAccountV1, String>, JpaSpecificationExecutor<BankingAccountV1> { }
