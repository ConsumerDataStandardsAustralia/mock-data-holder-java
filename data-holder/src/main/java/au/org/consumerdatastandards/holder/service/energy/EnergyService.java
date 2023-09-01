package au.org.consumerdatastandards.holder.service.energy;

import au.org.consumerdatastandards.holder.model.energy.EnergyAccount;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountDetail;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountDetailV1;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountV2;
import au.org.consumerdatastandards.holder.model.energy.EnergyBillingTransaction;
import au.org.consumerdatastandards.holder.model.energy.EnergyConcession;
import au.org.consumerdatastandards.holder.model.energy.EnergyInvoice;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlan;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanDetail;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanEntity;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePoint;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointDetail;
import au.org.consumerdatastandards.holder.model.energy.EnergyUsageRead;
import au.org.consumerdatastandards.holder.model.energy.FuelTypeEnum;
import au.org.consumerdatastandards.holder.model.energy.ParamAccountOpenStatus;
import au.org.consumerdatastandards.holder.model.energy.ParamEffective;
import au.org.consumerdatastandards.holder.model.energy.ParamFuelTypeEnum;
import au.org.consumerdatastandards.holder.model.energy.ParamIntervalReadsEnum;
import au.org.consumerdatastandards.holder.model.energy.ParamTypeEnum;
import au.org.consumerdatastandards.holder.repository.energy.EnergyAccountDetailV1Repository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyAccountDetailV2Repository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyAccountDetailV3Repository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyAccountV1Repository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyAccountV2Repository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyBillingTransactionRepository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyInvoiceRepository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyPlanDetailV1Repository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyPlanDetailV2Repository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyPlanRepository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyServicePointDetailRepository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyServicePointRepository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyUsageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnergyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnergyService.class);

    private final EnergyAccountV1Repository energyAccountV1Repository;
    private final EnergyAccountV2Repository energyAccountV2Repository;
    private final EnergyAccountDetailV1Repository energyAccountDetailV1Repository;
    private final EnergyAccountDetailV2Repository energyAccountDetailV2Repository;
    private final EnergyAccountDetailV3Repository energyAccountDetailV3Repository;
    private final EnergyInvoiceRepository energyInvoiceRepository;
    private final EnergyBillingTransactionRepository energyBillingTransactionRepository;
    private final EnergyPlanRepository energyPlanRepository;
    private final EnergyPlanDetailV1Repository energyPlanDetailV1Repository;
    private final EnergyPlanDetailV2Repository energyPlanDetailV2Repository;
    private final EnergyServicePointRepository energyServicePointRepository;
    private final EnergyServicePointDetailRepository energyServicePointDetailRepository;
    private final EnergyUsageRepository energyUsageRepository;

    @Autowired
    public EnergyService(
            EnergyAccountV1Repository energyAccountV1Repository,
            EnergyAccountV2Repository energyAccountV2Repository,
            EnergyAccountDetailV1Repository energyAccountDetailV1Repository,
            EnergyAccountDetailV2Repository energyAccountDetailV2Repository,
            EnergyAccountDetailV3Repository energyAccountDetailV3Repository,
            EnergyInvoiceRepository energyInvoiceRepository,
            EnergyBillingTransactionRepository energyBillingTransactionRepository,
            EnergyServicePointRepository energyServicePointRepository,
            EnergyServicePointDetailRepository energyServicePointDetailRepository,
            EnergyUsageRepository energyUsageRepository,
            EnergyPlanRepository energyPlanRepository,
            EnergyPlanDetailV1Repository energyPlanDetailV1Repository,
            EnergyPlanDetailV2Repository energyPlanDetailV2Repository) {

        this.energyAccountV1Repository = energyAccountV1Repository;
        this.energyAccountV2Repository = energyAccountV2Repository;
        this.energyAccountDetailV1Repository = energyAccountDetailV1Repository;
        this.energyAccountDetailV2Repository = energyAccountDetailV2Repository;
        this.energyAccountDetailV3Repository = energyAccountDetailV3Repository;
        this.energyInvoiceRepository = energyInvoiceRepository;
        this.energyBillingTransactionRepository = energyBillingTransactionRepository;
        this.energyServicePointRepository = energyServicePointRepository;
        this.energyServicePointDetailRepository = energyServicePointDetailRepository;
        this.energyUsageRepository = energyUsageRepository;
        this.energyPlanRepository = energyPlanRepository;
        this.energyPlanDetailV1Repository = energyPlanDetailV1Repository;
        this.energyPlanDetailV2Repository = energyPlanDetailV2Repository;
    }

    public Page<EnergyPlanEntity> findPlans(ParamTypeEnum type, ParamFuelTypeEnum fuelType, ParamEffective effective, OffsetDateTime updatedSince, String brand, PageRequest pageable) {
        LOGGER.debug(
                "Retrieving basic plan listing using filters of type {} effective {}, updated since {}, brand {}, fuel type {} with Paging content specified as {}",
                type, effective, updatedSince, brand, fuelType, pageable);

        return energyPlanRepository.findAll((Specification<EnergyPlanEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (type != null && type != ParamTypeEnum.ALL) {
                predicates.add(criteriaBuilder.equal(root.get("type"), EnergyPlan.TypeEnum.valueOf(type.name())));
            }
            if (fuelType != null && fuelType != ParamFuelTypeEnum.ALL) {
                predicates.add(criteriaBuilder.equal(root.get("fuelType"), FuelTypeEnum.valueOf(fuelType.name())));
            }
            if (effective == null || effective == ParamEffective.CURRENT) {
                OffsetDateTime now = OffsetDateTime.now();
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("effectiveFrom"), now));
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("effectiveTo"), now));
            } else if (effective == ParamEffective.FUTURE) {
                OffsetDateTime now = OffsetDateTime.now();
                predicates.add(criteriaBuilder.greaterThan(root.get("effectiveFrom"), now));
            }
            if (updatedSince != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("lastUpdated"), updatedSince));
            }
            if (StringUtils.hasText(brand)) {
                predicates.add(criteriaBuilder.equal(root.get("brand"), brand.trim()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    public EnergyPlanDetail getPlanDetail(String planId, Integer version) {
        LOGGER.debug("Retrieving plan detail by id {}", planId);

        switch (version) {
            case 1:
                return energyPlanDetailV1Repository.findById(planId).orElse(null);
            case 2:
            default:
                return energyPlanDetailV2Repository.findById(planId).orElse(null);
        }
    }

    public Page<EnergyAccount> findAccounts(ParamAccountOpenStatus openStatus, PageRequest pageable, Integer version) {

        LOGGER.debug("Retrieving energy accounts using filters of openStatus {} with Paging content specified as {}",
                openStatus, pageable);

        switch (version) {
            case 1:
                return energyAccountV1Repository.findAll(pageable).map(account -> account);
            case 2:
            default:
                return energyAccountV2Repository.findAll((Specification<EnergyAccountV2>) (root, criteriaQuery, criteriaBuilder) -> {
                    List<Predicate> predicates = new ArrayList<>();
                    if (openStatus != null && openStatus != ParamAccountOpenStatus.ALL) {
                        predicates.add(criteriaBuilder.equal(root.get("openStatus"), EnergyAccount.OpenStatus.valueOf(openStatus.name())));
                    }
                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                }, pageable).map(account -> account);
        }
    }

    public EnergyAccountDetail getAccountDetail(String accountId, int version) {

        LOGGER.debug("Retrieving energy account detail by id {}", accountId);

        switch (version) {
            case 1:
                return energyAccountDetailV1Repository.findById(accountId).orElse(null);
            case 2:
                return energyAccountDetailV2Repository.findById(accountId).orElse(null);
            case 3:
            default:
                return energyAccountDetailV3Repository.findById(accountId).orElse(null);
        }
    }

    public Page<EnergyInvoice> findInvoices(List<String> accountIds, LocalDate oldestDate, LocalDate newestDate, Pageable pageable) {
        LOGGER.debug("Retrieve Energy invoices for accounts {}, oldest date: {}, newest date: {} with Paging content specified as {}",
                accountIds, oldestDate, newestDate, pageable);

        return energyInvoiceRepository.findAll((Root<EnergyInvoice> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (accountIds != null) {
                predicates.add(root.get("accountId").in(accountIds));
                // TODO: Otherwise the current user accounts need to be used from security context
            }
            if (oldestDate != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("readStartDate"), oldestDate));
            }
            if (newestDate != null) {
                predicates.add(criteriaBuilder.or(
                        criteriaBuilder.and(criteriaBuilder.isNull(root.get("readEndDate")), criteriaBuilder.lessThanOrEqualTo(root.get("readStartDate"), oldestDate)),
                        criteriaBuilder.and(criteriaBuilder.isNotNull(root.get("readEndDate")), criteriaBuilder.lessThanOrEqualTo(root.get("readEndDate"), oldestDate))
               ));
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("readEndDate"), oldestDate));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    public Page<EnergyBillingTransaction> findBillingTransactions(List<String> accountIds, OffsetDateTime oldestTime, OffsetDateTime newestTime, Pageable pageable) {
        LOGGER.debug("Retrieve Energy billing transactions for accounts {}, oldest time: {}, newest time: {} with Paging content specified as {}",
                accountIds, oldestTime, newestTime, pageable);

        return energyBillingTransactionRepository.findAll((Root<EnergyBillingTransaction> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (accountIds != null) {
                predicates.add(root.get("accountId").in(accountIds));
                // TODO: Otherwise the current user accounts need to be used from security context
            }
            if (newestTime != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("executionDateTime"), newestTime));
            }
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("executionDateTime"), (oldestTime == null
                    ? (newestTime == null ? OffsetDateTime.now() : newestTime).minusMonths(12)
                    : oldestTime
            )));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    public boolean checkAccountExistence(String accountId) {
        return energyAccountV2Repository.existsById(accountId);
    }

    public List<EnergyConcession> findConcessions(String accountId) {
        Optional<EnergyAccountDetailV1> account = energyAccountDetailV1Repository.findById(accountId);
        return account.map(EnergyAccountDetailV1::getConcessions).orElse(null);
    }

    public Page<EnergyServicePoint> findServicePoints(Pageable pageable) {
        LOGGER.debug("Retrieve Energy Service Points with Paging content specified as {}", pageable);

        // TODO: Only current customer's service points need to be returned
        return energyServicePointRepository.findAll(pageable);
    }

    public EnergyServicePointDetail getServicePoint(String servicePointId) {
        LOGGER.debug("Retrieve Energy Service Point with id {}", servicePointId);

        return energyServicePointDetailRepository.findById(servicePointId).orElse(null);
    }

    public Page<EnergyUsageRead> findUsageForServicePoints(List<String> servicePointIds, LocalDate oldestDate, LocalDate newestDate,
            ParamIntervalReadsEnum intervalReads, Pageable pageable) {
        LOGGER.debug("Retrieve Energy usage for Service Points {}, oldest date: {}, newest date: {}, interval reads: {} with Paging content specified as {}",
                servicePointIds, oldestDate, newestDate, intervalReads, pageable);

        return energyUsageRepository.findAll((Root<EnergyUsageRead> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (servicePointIds != null) {
                predicates.add(root.get("servicePointId").in(servicePointIds));
                // TODO: Otherwise the current user service points need to be used from security context
            }
            if (oldestDate != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("readStartDate"), oldestDate));
            }
            if (newestDate != null) {
                predicates.add(criteriaBuilder.or(
                        criteriaBuilder.and(criteriaBuilder.isNull(root.get("readEndDate")), criteriaBuilder.lessThanOrEqualTo(root.get("readStartDate"), oldestDate)),
                        criteriaBuilder.and(criteriaBuilder.isNotNull(root.get("readEndDate")), criteriaBuilder.lessThanOrEqualTo(root.get("readEndDate"), oldestDate))
                ));
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("readEndDate"), oldestDate));
            }
            if (intervalReads != ParamIntervalReadsEnum.NONE) {
                if (intervalReads == ParamIntervalReadsEnum.MIN_30) {
                    predicates.add(criteriaBuilder.ge(root.get("intervalRead").get("readIntervalLength"), 30));
                } else {
                    predicates.add(criteriaBuilder.gt(root.get("intervalRead").get("readIntervalLength"), 0));
                }
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    public boolean checkServicePointExistence(String servicePointId) {
        return energyServicePointDetailRepository.existsById(servicePointId);
    }
}
