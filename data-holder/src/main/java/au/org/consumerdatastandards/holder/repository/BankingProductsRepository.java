package au.org.consumerdatastandards.holder.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import au.org.consumerdatastandards.holder.model.BankingProduct;


@Repository
public interface BankingProductsRepository
    extends PagingAndSortingRepository<BankingProduct, String>, JpaSpecificationExecutor<BankingProduct> {

}
