package au.org.consumerdatastandards.holder.service;

import au.org.consumerdatastandards.holder.model.BankingTransaction;
import au.org.consumerdatastandards.holder.model.BankingTransactionDetail;
import au.org.consumerdatastandards.holder.repository.BankingTransactionDetailRepository;
import au.org.consumerdatastandards.holder.repository.BankingTransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankingTransactionService {

    private final Logger LOGGER = LoggerFactory.getLogger(BankingTransactionService.class);

    private final BankingTransactionRepository bankingTransactionRepository;

    private final BankingTransactionDetailRepository bankingTransactionDetailRepository;

    @Autowired
    public BankingTransactionService(
        BankingTransactionRepository bankingTransactionRepository,
        BankingTransactionDetailRepository bankingTransactionDetailRepository)
    {
        this.bankingTransactionRepository = bankingTransactionRepository;
        this.bankingTransactionDetailRepository = bankingTransactionDetailRepository;
    }

    public BankingTransactionDetail getBankingTransactionDetail(String transactionId) {
        LOGGER.debug("Retrieving transaction detail by id {}",  transactionId);
        Optional<BankingTransactionDetail> byId = bankingTransactionDetailRepository.findById(transactionId);
        return byId.orElse(null);
    }

    public Page<BankingTransaction> findTransactions(String accountId,
                                                     BigDecimal maxAmount,
                                                     BigDecimal minAmount,
                                                     OffsetDateTime newestTime,
                                                     OffsetDateTime oldestTime,
                                                     String text,
                                                     Pageable pageable) {
        LOGGER.debug("Retrieve transactions of account id {} with Paging content specified as {}" , accountId,  pageable);
        return bankingTransactionRepository.findAll((Specification<BankingTransaction>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("accountId"), accountId));
            if (minAmount != null) {
                predicates.add(criteriaBuilder.ge(root.get("amount"), minAmount));
            }
            if (maxAmount != null) {
                predicates.add(criteriaBuilder.le(root.get("amount"), maxAmount));
            }
            if (oldestTime != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("executionDateTime"), oldestTime));
            }
            if (newestTime != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("executionDateTime"), newestTime));
            }
            if (StringUtils.hasText(text)) {
                String pattern = "%" + text + "%";
                predicates.add(
                    criteriaBuilder.or(
                        criteriaBuilder.like(root.get("reference"), pattern),
                        criteriaBuilder.like(root.get("description"), pattern)
                    )
                );
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }
}
