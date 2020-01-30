package au.org.consumerdatastandards.holder.service;

import au.org.consumerdatastandards.holder.api.VersionNotSupportedException;
import au.org.consumerdatastandards.holder.model.BankingProduct;
import au.org.consumerdatastandards.holder.model.BankingProductDetail;
import au.org.consumerdatastandards.holder.model.BankingProductV1Detail;
import au.org.consumerdatastandards.holder.model.BankingProductV2Detail;
import au.org.consumerdatastandards.holder.model.BankingProductV1;
import au.org.consumerdatastandards.holder.model.BankingProductV2;
import au.org.consumerdatastandards.holder.model.ParamEffective;
import au.org.consumerdatastandards.holder.repository.BankingProductV1DetailRepository;
import au.org.consumerdatastandards.holder.repository.BankingProductV2DetailRepository;
import au.org.consumerdatastandards.holder.repository.BankingProductV1Repository;
import au.org.consumerdatastandards.holder.repository.BankingProductV2Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankingProductService {

    private static final Logger LOGGER = LogManager.getLogger(BankingProductService.class);

    private final BankingProductV1Repository productsV1Repository;
    private final BankingProductV2Repository productsV2Repository;
    private final BankingProductV1DetailRepository productDetailV1Repository;
    private final BankingProductV2DetailRepository productDetailV2Repository;

    @Autowired
    public BankingProductService(BankingProductV1Repository productsV1Repository,
                                 BankingProductV2Repository productsV2Repository,
                                 BankingProductV1DetailRepository productDetailV1Repository,
                                 BankingProductV2DetailRepository productDetailV2Repository) {
        this.productsV1Repository = productsV1Repository;
        this.productsV2Repository = productsV2Repository;
        this.productDetailV1Repository = productDetailV1Repository;
        this.productDetailV2Repository = productDetailV2Repository;
    }

    private class BankingProductSpecification implements Specification {

        private ParamEffective effective;
        private BankingProduct bankingProduct;

        public BankingProductSpecification(ParamEffective effective, BankingProduct bankingProduct) {
            this.effective = effective;
            this.bankingProduct = bankingProduct;
        }

        @Override
        public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
            List<Predicate> predicates = new ArrayList<>();
            if (ParamEffective.CURRENT.equals(effective) || effective == null) {
                // If Effective is not supplied, assume CURRENT as per Standard
                // https://consumerdatastandardsaustralia.github.io/standards/#get-products
                OffsetDateTime now = OffsetDateTime.now();
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("effectiveFrom"), now));
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("effectiveTo"), now));
            } else if (ParamEffective.FUTURE.equals(effective)) {
                OffsetDateTime now = OffsetDateTime.now();
                predicates.add(criteriaBuilder.greaterThan(root.get("effectiveFrom"), now));
            }
            if (bankingProduct.getProductCategory() != null) {
                predicates.add(criteriaBuilder.equal(root.get("productCategory"), bankingProduct.getProductCategory()));
            }
            if (bankingProduct.getLastUpdated() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("lastUpdated"), bankingProduct.getLastUpdated()));
            }
            if (!StringUtils.isEmpty(bankingProduct.getBrand())) {
                predicates.add(criteriaBuilder.like(root.get("brand"), "%" + bankingProduct.getBrand() + "%"));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }
    }

    private Page<BankingProductV1> findProductsV1Like(ParamEffective effective, BankingProduct bankingProduct, Pageable pageable) {
        return productsV1Repository.findAll(new BankingProductSpecification(effective, bankingProduct), pageable);
    }

    private Page<BankingProductV2> findProductsV2Like(ParamEffective effective, BankingProduct bankingProduct, Pageable pageable) {
        return productsV2Repository.findAll(new BankingProductSpecification(effective, bankingProduct), pageable);
    }

    public Page<BankingProduct> findProductsLike(ParamEffective effective, BankingProduct bankingProduct, Pageable pageable, Integer version) {
        LOGGER.debug("Retrieve products matching inputs of effective {}, BankingProduct specified as {} with Paging content specified as {}" ,  effective,  bankingProduct,  pageable);
        switch (version) {
            case 1:
                return findProductsV1Like(effective, bankingProduct, pageable).map(productV1 -> productV1);
            case 2:
                return findProductsV2Like(effective, bankingProduct, pageable).map(productV2 -> productV2);
            default:
                throw new VersionNotSupportedException("Unsupported version " + version);
        }
    }

    private BankingProductV1Detail getProductDetailV1(String productId) {
        Optional<BankingProductV1Detail> byId = productDetailV1Repository.findById(productId);
        return byId.orElse(null);
    }

    private BankingProductV2Detail getProductDetailV2(String productId) {
        Optional<BankingProductV2Detail> byId = productDetailV2Repository.findById(productId);
        return byId.orElse(null);
    }

    public BankingProductDetail getProductDetail(String productId, Integer version) {
        LOGGER.debug("Retrieving product detail by id {}",  productId);
        switch (version) {
            case 1:
                return getProductDetailV1(productId);
            case 2:
                return getProductDetailV2(productId);
            default:
                throw new VersionNotSupportedException("Unsupported version " + version);
        }
    }
}
