package au.org.consumerdatastandards.holder.service.energy;

import au.org.consumerdatastandards.holder.model.energy.EnergyPlan;
import au.org.consumerdatastandards.holder.model.energy.ParamEffective;
import au.org.consumerdatastandards.holder.model.energy.ParamFuelTypeEnum;
import au.org.consumerdatastandards.holder.model.energy.ParamTypeEnum;
import au.org.consumerdatastandards.holder.repository.energy.EnergyPlanRepository;
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

    private final EnergyPlanRepository energyPlanRepository;

    @Autowired
    public EnergyService(EnergyPlanRepository energyPlanRepository) {
        this.energyPlanRepository = energyPlanRepository;
    }

    public Page<EnergyPlan> findPlans(ParamTypeEnum type, ParamFuelTypeEnum fuelType, ParamEffective effective, OffsetDateTime updatedSince, String brand, PageRequest pageable) {
        LOGGER.debug(
                "Retrieving basic plan listing using filters of type {} effective {}, updated since {}, brand {}, fuel type {} with Paging content specified as {}",
                type, effective, updatedSince, brand, fuelType, pageable);

        return energyPlanRepository.findAll((Specification<EnergyPlan>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (type != null && type != ParamTypeEnum.ALL) {
                predicates.add(criteriaBuilder.equal(root.get("type"), type));
            }
            if (fuelType != null && fuelType != ParamFuelTypeEnum.ALL) {
                predicates.add(criteriaBuilder.equal(root.get("fuelType"), fuelType));
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
}
