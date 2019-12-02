package au.org.consumerdatastandards.holder.service;

import au.org.consumerdatastandards.holder.model.BankingAccount;
import au.org.consumerdatastandards.holder.model.BankingAccountDetail;
import au.org.consumerdatastandards.holder.model.BankingBalance;
import au.org.consumerdatastandards.holder.model.BankingProductCategory;
import au.org.consumerdatastandards.holder.repository.BankingAccountDetailRepository;
import au.org.consumerdatastandards.holder.repository.BankingAccountRepository;
import au.org.consumerdatastandards.holder.repository.BankingBalanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BankingAccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankingAccountService.class);

    private final BankingAccountRepository bankingAccountRepository;

    private final BankingAccountDetailRepository bankingAccountDetailRepository;

    private final BankingBalanceRepository bankingBalanceRepository;

    @Autowired
    public BankingAccountService(
        BankingAccountRepository bankingAccountRepository,
        BankingAccountDetailRepository bankingAccountDetailRepository,
        BankingBalanceRepository bankingBalanceRepository)
    {
        this.bankingAccountRepository = bankingAccountRepository;
        this.bankingAccountDetailRepository = bankingAccountDetailRepository;
        this.bankingBalanceRepository = bankingBalanceRepository;
    }

    public BankingAccountDetail getBankingAccountDetail(String accountId) {
        LOGGER.debug("Retrieving account detail by id {}",  accountId);
        Optional<BankingAccountDetail> byId = bankingAccountDetailRepository.findById(accountId);
        return byId.orElse(null);
    }

    public Page<BankingAccount> findBankingAccountsLike(Boolean isOwned, BankingAccount bankingAccount, Pageable pageable) {
        LOGGER.debug("Retrieve {} accounts like BankingAccount specified as {} with Paging content specified as {}" ,
            isOwned != null && isOwned ? "owned" : "all", bankingAccount,  pageable);
        return bankingAccountRepository.findAll((Specification<BankingAccount>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            //TODO handle isOwned when we have security context implemented
            if (bankingAccount.getProductCategory() != null) {
                predicates.add(criteriaBuilder.equal(root.get("productCategory"), bankingAccount.getProductCategory()));
            }
            if (bankingAccount.getOpenStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("openStatus"), bankingAccount.getOpenStatus()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
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
}
