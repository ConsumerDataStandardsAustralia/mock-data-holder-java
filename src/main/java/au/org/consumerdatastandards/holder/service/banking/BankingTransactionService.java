package au.org.consumerdatastandards.holder.service.banking;

import au.org.consumerdatastandards.holder.model.banking.BankingTransaction;
import au.org.consumerdatastandards.holder.model.banking.BankingTransactionDetail;
import au.org.consumerdatastandards.holder.repository.banking.BankingTransactionDetailV1Repository;
import au.org.consumerdatastandards.holder.repository.banking.BankingTransactionDetailV2Repository;
import au.org.consumerdatastandards.holder.repository.banking.BankingTransactionRepository;
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

@Service
public class BankingTransactionService {

    private final Logger LOGGER = LoggerFactory.getLogger(BankingTransactionService.class);

    private final BankingTransactionRepository bankingTransactionRepository;

    private final BankingTransactionDetailV1Repository bankingTransactionDetailV1Repository;

    private final BankingTransactionDetailV2Repository bankingTransactionDetailV2Repository;

    @Autowired
    public BankingTransactionService(
        BankingTransactionRepository bankingTransactionRepository,
        BankingTransactionDetailV1Repository bankingTransactionDetailV1Repository,
        BankingTransactionDetailV2Repository bankingTransactionDetailV2Repository)
    {
        this.bankingTransactionRepository = bankingTransactionRepository;
        this.bankingTransactionDetailV1Repository = bankingTransactionDetailV1Repository;
        this.bankingTransactionDetailV2Repository = bankingTransactionDetailV2Repository;
    }

    public BankingTransactionDetail getBankingTransactionDetail(String transactionId, Integer version) {
        LOGGER.debug("Retrieving transaction detail by id {}",  transactionId);
        switch (version) {
            case 2:
                return bankingTransactionDetailV2Repository.findById(transactionId).orElse(null);
            default:
                return bankingTransactionDetailV1Repository.findById(transactionId).orElse(null);
        }
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
                predicates.add(criteriaBuilder.ge(root.get("amount").as(BigDecimal.class), minAmount));
            }
            if (maxAmount != null) {
                predicates.add(criteriaBuilder.le(root.get("amount").as(BigDecimal.class), maxAmount));
            }
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("executionDateTime"), oldestTime));
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("executionDateTime"), newestTime));
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
