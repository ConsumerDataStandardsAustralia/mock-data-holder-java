package au.org.consumerdatastandards.holder.service;

import au.org.consumerdatastandards.holder.model.BankingProductCategory;
import au.org.consumerdatastandards.holder.model.BankingScheduledPayment;
import au.org.consumerdatastandards.holder.model.BankingScheduledPaymentFrom;
import au.org.consumerdatastandards.holder.model.ParamAccountOpenStatus;
import au.org.consumerdatastandards.holder.repository.BankingScheduledPaymentRepository;
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
public class BankingScheduledPaymentService {

    private final static Logger LOGGER = LoggerFactory.getLogger(BankingScheduledPaymentService.class);

    private final BankingScheduledPaymentRepository bankingScheduledPaymentRepository;

    @Autowired
    public BankingScheduledPaymentService(BankingScheduledPaymentRepository bankingScheduledPaymentRepository) {
        this.bankingScheduledPaymentRepository = bankingScheduledPaymentRepository;
    }

    public Page<BankingScheduledPayment> getBankingScheduledPayments(String accountId, Pageable pageable) {
        LOGGER.debug("Retrieving banking scheduled payments by account id {}", accountId);
        BankingScheduledPaymentFrom from = new BankingScheduledPaymentFrom().accountId(accountId);
        return bankingScheduledPaymentRepository.findByFrom(from, pageable);
    }

    public Page<BankingScheduledPayment> getBankingScheduledPayments(List<String> accountIds, Pageable pageable) {
        LOGGER.debug("Retrieving banking scheduled payments by account ids {}", accountIds);
        return bankingScheduledPaymentRepository.findAll((Specification<BankingScheduledPayment>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(root.get("from").get("accountId").in(accountIds));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    public Page<BankingScheduledPayment> getBankingScheduledPayments(
        BankingProductCategory productCategory,
        ParamAccountOpenStatus openStatus,
        Boolean isOwned,
        Pageable pageable
    ) {
        LOGGER.debug("Retrieving {} banking scheduled payments by product category {}, open status {}",
            isOwned != null && isOwned ? "owned" : "all", productCategory, openStatus);
        return bankingScheduledPaymentRepository.findAll((Specification<BankingScheduledPayment>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("from").get("bankingAccount").get("productCategory"), productCategory));
            if (!ParamAccountOpenStatus.ALL.equals(openStatus)) {
                predicates.add(criteriaBuilder.equal(root.get("from").get("bankingAccount").get("openStatus"), openStatus));
            }
            //TODO process isOwned when security context is set
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }
}
