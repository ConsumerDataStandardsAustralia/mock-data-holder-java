package au.org.consumerdatastandards.holder.service;

import au.org.consumerdatastandards.holder.model.BankingAccount;
import au.org.consumerdatastandards.holder.model.BankingDirectDebit;
import au.org.consumerdatastandards.holder.model.BankingProductCategory;
import au.org.consumerdatastandards.holder.repository.BankingDirectDebitRepository;
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

@Service
public class BankingDirectDebitService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankingDirectDebitService.class);

    private final BankingDirectDebitRepository bankingDirectDebitRepository;

    @Autowired
    public BankingDirectDebitService(BankingDirectDebitRepository bankingDirectDebitRepository) {
        this.bankingDirectDebitRepository = bankingDirectDebitRepository;
    }

    public Page<BankingDirectDebit> getBankingDirectDebits(String accountId, Pageable pageable) {
        LOGGER.debug("Retrieving banking direct debits by account id {}", accountId);
        return bankingDirectDebitRepository.findByAccountId(accountId, pageable);
    }

    public Page<BankingDirectDebit> getBankingDirectDebits(Boolean isOwned,
                                                           BankingProductCategory category,
                                                           BankingAccount.OpenStatus openStatus,
                                                           Pageable pageable) {
        LOGGER.debug("Retrieving {} banking direct-debits matching product category {} and open status {} with Paging content specified as {}",
            isOwned != null && isOwned ? "owned" : "all", category, openStatus, pageable);
        return bankingDirectDebitRepository.findAll((Specification<BankingDirectDebit>) (root, criteriaQuery, criteriaBuilder) -> {
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

    public Page<BankingDirectDebit> getBankingDirectDebits(List<String> accountIds, Pageable pageable) {
        LOGGER.debug("Retrieving banking direct debits by account ids {}", accountIds);
        return bankingDirectDebitRepository.findAll((Specification<BankingDirectDebit>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(root.get("accountId").in(accountIds));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }
}
