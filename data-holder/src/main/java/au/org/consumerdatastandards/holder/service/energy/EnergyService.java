package au.org.consumerdatastandards.holder.service.energy;

import au.org.consumerdatastandards.holder.model.energy.*;
import au.org.consumerdatastandards.holder.repository.energy.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnergyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnergyService.class);

    private final EnergyAccountV1Repository energyAccountV1Repository;
    private final EnergyAccountV2Repository energyAccountV2Repository;
    private final EnergyAccountDetailV1Repository energyAccountDetailV1Repository;
    private final EnergyAccountDetailV2Repository energyAccountDetailV2Repository;
    private final EnergyPlanRepository energyPlanRepository;
    private final EnergyPlanDetailRepository energyPlanDetailRepository;

    @Autowired
    public EnergyService(EnergyAccountV1Repository energyAccountV1Repository, EnergyAccountV2Repository energyAccountV2Repository, EnergyAccountDetailV1Repository energyAccountDetailV1Repository, EnergyAccountDetailV2Repository energyAccountDetailV2Repository, EnergyPlanRepository energyPlanRepository, EnergyPlanDetailRepository energyPlanDetailRepository) {

        this.energyAccountV1Repository = energyAccountV1Repository;
        this.energyAccountV2Repository = energyAccountV2Repository;
        this.energyAccountDetailV1Repository =energyAccountDetailV1Repository;
        this.energyAccountDetailV2Repository =energyAccountDetailV2Repository;
        this.energyPlanRepository = energyPlanRepository;
        this.energyPlanDetailRepository = energyPlanDetailRepository;
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
                predicates.add(criteriaBuilder.equal(root.get("fuelType"), EnergyPlan.FuelTypeEnum.valueOf(fuelType.name())));
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

    public EnergyPlanDetailEntity getPlanDetail(String planId) {
        LOGGER.debug("Retrieving plan detail by id {}",  planId);
        return energyPlanDetailRepository.findById(planId).orElse(null);
    }

    public Page<EnergyAccountBase> findAccounts(ParamAccountOpenStatus openStatus, PageRequest pageable, Integer version) {

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
                        predicates.add(criteriaBuilder.equal(root.get("openStatus"), EnergyAccountBaseV2.OpenStatus.valueOf(openStatus.name())));
                    }
                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                }, pageable).map(account -> account);
        }
    }

    public EnergyAccountDetailBase getAccountDetail(String accountId, int version) {

        LOGGER.debug("Retrieving energy account detail by id {}",  accountId);

        switch (version) {
            case 1:
                return energyAccountDetailV1Repository.findById(accountId).orElse(null);
            case 2:
            default:
                return energyAccountDetailV2Repository.findById(accountId).orElse(null);
        }
    }
}
