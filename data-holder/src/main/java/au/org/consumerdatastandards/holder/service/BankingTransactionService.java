package au.org.consumerdatastandards.holder.service;

import au.org.consumerdatastandards.holder.model.BankingTransaction;
import au.org.consumerdatastandards.holder.model.BankingTransactionDetail;
import au.org.consumerdatastandards.holder.repository.BankingTransactionDetailRepository;
import au.org.consumerdatastandards.holder.repository.BankingTransactionRepository;
import org.apache.commons.lang3.StringUtils;
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

    public Page<BankingTransaction> findTransactionsLike(BankingTransaction bankingTransaction, Pageable pageable) {
        LOGGER.debug("Retrieve transactions like BankingTransaction specified as {} with Paging content specified as {}" ,  bankingTransaction,  pageable);
        return bankingTransactionRepository.findAll((Specification<BankingTransaction>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotBlank(bankingTransaction.getAccountId())) {
                predicates.add(criteriaBuilder.equal(root.get("accountId"), bankingTransaction.getAccountId()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }
}
