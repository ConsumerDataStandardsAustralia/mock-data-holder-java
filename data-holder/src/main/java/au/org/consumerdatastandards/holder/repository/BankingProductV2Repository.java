package au.org.consumerdatastandards.holder.repository;

import au.org.consumerdatastandards.holder.model.BankingProductV2;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BankingProductV2Repository
    extends PagingAndSortingRepository<BankingProductV2, String>, JpaSpecificationExecutor<BankingProductV2> { }
