package au.org.consumerdatastandards.holder.repository.banking;

import au.org.consumerdatastandards.holder.model.banking.BankingProductV4;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BankingProductV4Repository
    extends PagingAndSortingRepository<BankingProductV4, String>, JpaSpecificationExecutor<BankingProductV4> { }
