package au.org.consumerdatastandards.holder.repository.banking;

import au.org.consumerdatastandards.holder.model.banking.BankingAccountV2;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankingAccountRepositoryV2
    extends PagingAndSortingRepository<BankingAccountV2, String>, JpaSpecificationExecutor<BankingAccountV2> { }
