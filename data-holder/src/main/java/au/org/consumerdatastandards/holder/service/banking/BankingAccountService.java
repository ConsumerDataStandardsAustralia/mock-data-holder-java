package au.org.consumerdatastandards.holder.service.banking;

import au.org.consumerdatastandards.holder.model.banking.BankingAccount;
import au.org.consumerdatastandards.holder.model.banking.BankingAccountDetail;
import au.org.consumerdatastandards.holder.model.banking.BankingBalance;
import au.org.consumerdatastandards.holder.model.banking.BankingProductCategory;
import au.org.consumerdatastandards.holder.repository.banking.BankingAccountDetailRepositoryV1;
import au.org.consumerdatastandards.holder.repository.banking.BankingAccountDetailRepositoryV3;
import au.org.consumerdatastandards.holder.repository.banking.BankingAccountRepositoryV1;
import au.org.consumerdatastandards.holder.repository.banking.BankingAccountRepositoryV2;
import au.org.consumerdatastandards.holder.repository.banking.BankingBalanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Service
public class BankingAccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankingAccountService.class);

    private final BankingAccountRepositoryV1 bankingAccountRepositoryV1;

    private final BankingAccountRepositoryV2 bankingAccountRepositoryV2;

    private final BankingAccountDetailRepositoryV1 bankingAccountDetailRepositoryV1;

    private final BankingAccountDetailRepositoryV3 bankingAccountDetailRepositoryV3;

    private final BankingBalanceRepository bankingBalanceRepository;

    @Autowired
    public BankingAccountService(
        BankingAccountRepositoryV1 bankingAccountRepositoryV1,
        BankingAccountRepositoryV2 bankingAccountRepositoryV2,
        BankingAccountDetailRepositoryV1 bankingAccountDetailRepositoryV1,
        BankingAccountDetailRepositoryV3 bankingAccountDetailRepositoryV3,
        BankingBalanceRepository bankingBalanceRepository)
    {
        this.bankingAccountRepositoryV1 = bankingAccountRepositoryV1;
        this.bankingAccountRepositoryV2 = bankingAccountRepositoryV2;
        this.bankingAccountDetailRepositoryV1 = bankingAccountDetailRepositoryV1;
        this.bankingAccountDetailRepositoryV3 = bankingAccountDetailRepositoryV3;
        this.bankingBalanceRepository = bankingBalanceRepository;
    }

    public BankingAccountDetail getBankingAccountDetail(String accountId, int version) {
        LOGGER.debug("Retrieving account detail by id {}",  accountId);
        switch (version) {
            case 3:
                return bankingAccountDetailRepositoryV3.findById(accountId).orElse(null);
            default:
                return bankingAccountDetailRepositoryV1.findById(accountId).orElse(null);
        }
    }

    public Page<BankingAccount> findBankingAccountsLike(Boolean isOwned, BankingAccount bankingAccount, Pageable pageable, int version) {
        LOGGER.debug("Retrieve {} accounts like BankingAccount specified as {} with Paging content specified as {}" ,
            isOwned != null && isOwned ? "owned" : "all", bankingAccount,  pageable);
        switch (version) {
            case 2:
                return bankingAccountRepositoryV2.findAll(new BankingAccountSpecification<>(bankingAccount), pageable).map(account -> account);
            default:
                return bankingAccountRepositoryV1.findAll(new BankingAccountSpecification<>(bankingAccount), pageable).map(account -> account);
        }
    }

    public BankingBalance getBankingBalance(String accountId) {
        LOGGER.debug("Retrieving banking balance for account id {}",  accountId);
        return bankingBalanceRepository.findByAccountId(accountId);
    }

    public Page<BankingBalance> getBankingBalances(Boolean isOwned,
                                                   BankingProductCategory category,
                                                   BankingAccount.OpenStatus openStatus,
                                                   Pageable pageable) {
        LOGGER.debug("Retrieving {} banking balance matching product category {} and open status {} with Paging content specified as {}",
            isOwned != null && isOwned ? "owned" : "all", category, openStatus, pageable);
        return bankingBalanceRepository.findAll((Specification<BankingBalance>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (category != null) {
                predicates.add(criteriaBuilder.equal(root.get("bankingAccount").get("productCategory"), category));
            }
            if (openStatus != null) {
                predicates.add(criteriaBuilder.equal(root.get("bankingAccount").get("openStatus"), openStatus));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    public Page<BankingBalance> getBankingBalances(List<String> accountIds, Pageable pageable) {
        LOGGER.debug("Retrieving banking balance for account ids {}",  accountIds);
        return bankingBalanceRepository.findAll((Specification<BankingBalance>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(root.get("accountId").in(accountIds));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    public boolean checkAccountExistence(String accountId) {
        return bankingAccountRepositoryV1.findById(accountId).isPresent();
    }
}

class BankingAccountSpecification<T> implements Specification<T> {
    private final BankingAccount bankingAccount;

    public BankingAccountSpecification(BankingAccount bankingAccount) {
        this.bankingAccount = bankingAccount;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        //TODO handle isOwned when we have security context implemented
        if (bankingAccount.getProductCategory() != null) {
            predicates.add(criteriaBuilder.equal(root.get("productCategory"), bankingAccount.getProductCategory()));
        }
        if (bankingAccount.getOpenStatus() != null) {
            predicates.add(criteriaBuilder.equal(root.get("openStatus"), bankingAccount.getOpenStatus()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
