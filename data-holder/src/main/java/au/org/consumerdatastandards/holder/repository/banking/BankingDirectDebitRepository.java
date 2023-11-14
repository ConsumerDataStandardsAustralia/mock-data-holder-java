package au.org.consumerdatastandards.holder.repository.banking;

import au.org.consumerdatastandards.holder.model.banking.BankingAccount;
import au.org.consumerdatastandards.holder.model.banking.BankingDirectDebit;
import au.org.consumerdatastandards.holder.model.banking.BankingProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BankingDirectDebitRepository
    extends PagingAndSortingRepository<BankingDirectDebit, String>, JpaSpecificationExecutor<BankingDirectDebit> {

    Page<BankingDirectDebit> findByAccountId(String accountId, Pageable pageable);

    @Query("SELECT d FROM BankingDirectDebit d JOIN BankingAccountV2 a ON a.accountId = d.accountId WHERE a.productCategory = ?1")
    Page<BankingDirectDebit> findByProductCategory(BankingProductCategory category, Pageable pageable);

    @Query("SELECT d FROM BankingDirectDebit d JOIN BankingAccountV2 a ON a.accountId = d.accountId WHERE a.openStatus = ?1")
    Page<BankingDirectDebit> findByOpenStatus(BankingAccount.OpenStatus openStatus, Pageable pageable);

    @Query("SELECT d FROM BankingDirectDebit d JOIN BankingAccountV2 a ON a.accountId = d.accountId WHERE a.productCategory = ?1 AND a.openStatus = ?2")
    Page<BankingDirectDebit> findByProductCategoryAndOpenStatus(BankingProductCategory category, BankingAccount.OpenStatus openStatus, Pageable pageable);
}
