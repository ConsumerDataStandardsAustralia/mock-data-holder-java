package au.org.consumerdatastandards.holder.service.banking;

import au.org.consumerdatastandards.holder.model.banking.BankingProductCategory;
import au.org.consumerdatastandards.holder.model.banking.BankingScheduledPayment;
import au.org.consumerdatastandards.holder.model.banking.BankingScheduledPaymentFrom;
import au.org.consumerdatastandards.holder.model.banking.ParamAccountOpenStatus;
import au.org.consumerdatastandards.holder.repository.banking.BankingScheduledPaymentRepositoryV1;
import au.org.consumerdatastandards.holder.repository.banking.BankingScheduledPaymentRepositoryV2;
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
public class BankingScheduledPaymentService {

    private final static Logger LOGGER = LoggerFactory.getLogger(BankingScheduledPaymentService.class);

    private final BankingScheduledPaymentRepositoryV1 bankingScheduledPaymentRepositoryV1;
    private final BankingScheduledPaymentRepositoryV2 bankingScheduledPaymentRepositoryV2;

    @Autowired
    public BankingScheduledPaymentService(BankingScheduledPaymentRepositoryV1 bankingScheduledPaymentRepositoryV1,
            BankingScheduledPaymentRepositoryV2 bankingScheduledPaymentRepositoryV2) {
        this.bankingScheduledPaymentRepositoryV1 = bankingScheduledPaymentRepositoryV1;
        this.bankingScheduledPaymentRepositoryV2 = bankingScheduledPaymentRepositoryV2;
    }

    public Page<BankingScheduledPayment> getBankingScheduledPayments(String accountId, Pageable pageable, int version) {
        LOGGER.debug("Retrieving banking scheduled payments by account id {}", accountId);
        BankingScheduledPaymentFrom from = new BankingScheduledPaymentFrom().accountId(accountId);
        switch (version) {
            case 1:
                return bankingScheduledPaymentRepositoryV1.findByFrom(from, pageable).map(payment -> payment);
            case 2:
            default:
                return bankingScheduledPaymentRepositoryV2.findByFrom(from, pageable).map(payment -> payment);
        }
    }

    public Page<BankingScheduledPayment> getBankingScheduledPayments(List<String> accountIds, Pageable pageable, int version) {
        LOGGER.debug("Retrieving banking scheduled payments by account ids {}", accountIds);
        switch (version) {
            case 1:
                return bankingScheduledPaymentRepositoryV1.findAll(
                        new BankingScheduledPaymentSpecification<>(accountIds), pageable).map(payment -> payment);
            case 2:
            default:
                return bankingScheduledPaymentRepositoryV2.findAll(
                        new BankingScheduledPaymentSpecification<>(accountIds), pageable).map(payment -> payment);
        }
    }

    public Page<BankingScheduledPayment> getBankingScheduledPayments(
        BankingProductCategory productCategory,
        ParamAccountOpenStatus openStatus,
        Boolean isOwned,
        Pageable pageable,
        int version
    ) {
        LOGGER.debug("Retrieving {} banking scheduled payments by product category {}, open status {}",
            isOwned != null && isOwned ? "owned" : "all", productCategory, openStatus);
        switch (version) {
            case 1:
                return bankingScheduledPaymentRepositoryV1.findAll(
                        new BankingScheduledPaymentSpecification<>(productCategory, openStatus, isOwned), pageable).map(payment -> payment);
            case 2:
            default:
                return bankingScheduledPaymentRepositoryV2.findAll(
                        new BankingScheduledPaymentSpecification<>(productCategory, openStatus, isOwned), pageable).map(payment -> payment);
        }
    }
}

class BankingScheduledPaymentSpecification<T> implements Specification<T> {
    private List<String> accountIds;
    private BankingProductCategory productCategory;
    private ParamAccountOpenStatus openStatus;
    private Boolean isOwned;

    BankingScheduledPaymentSpecification(List<String> accountIds) {
        this.accountIds = accountIds;
    }

    BankingScheduledPaymentSpecification(BankingProductCategory productCategory, ParamAccountOpenStatus openStatus, Boolean isOwned) {
        this.productCategory = productCategory;
        this.openStatus = openStatus;
        this.isOwned = isOwned;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (accountIds != null) {
            predicates.add(root.get("from").get("accountId").in(accountIds));
        }
        if (openStatus != null) {
            if (productCategory != null) {
                predicates.add(criteriaBuilder.equal(root.get("from").get("bankingAccount").get("productCategory"), productCategory));
            }
            if (!ParamAccountOpenStatus.ALL.equals(openStatus)) {
                predicates.add(criteriaBuilder.equal(root.get("from").get("bankingAccount").get("openStatus"), openStatus));
            }
            //TODO process isOwned when security context is set
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
