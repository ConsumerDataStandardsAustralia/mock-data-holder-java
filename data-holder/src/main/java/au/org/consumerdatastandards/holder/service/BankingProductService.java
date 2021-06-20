package au.org.consumerdatastandards.holder.service;

import au.org.consumerdatastandards.holder.model.BankingProduct;
import au.org.consumerdatastandards.holder.model.BankingProductDetail;
import au.org.consumerdatastandards.holder.model.ParamEffective;
import au.org.consumerdatastandards.holder.repository.BankingProductDetailV1Repository;
import au.org.consumerdatastandards.holder.repository.BankingProductDetailV2Repository;
import au.org.consumerdatastandards.holder.repository.BankingProductDetailV3Repository;
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

@Service
public class BankingProductService {

    private static final Logger LOGGER = LogManager.getLogger(BankingProductService.class);

    private final BankingProductV1Repository productsV1Repository;
    private final BankingProductV2Repository productsV2Repository;
    private final BankingProductDetailV1Repository productDetailV1Repository;
    private final BankingProductDetailV2Repository productDetailV2Repository;
    private final BankingProductDetailV3Repository productDetailV3Repository;

    @Autowired
    public BankingProductService(BankingProductV1Repository productsV1Repository,
                                 BankingProductV2Repository productsV2Repository,
                                 BankingProductDetailV1Repository productDetailV1Repository,
                                 BankingProductDetailV2Repository productDetailV2Repository,
                                 BankingProductDetailV3Repository productDetailV3Repository) {
        this.productsV1Repository = productsV1Repository;
        this.productsV2Repository = productsV2Repository;
        this.productDetailV1Repository = productDetailV1Repository;
        this.productDetailV2Repository = productDetailV2Repository;
        this.productDetailV3Repository = productDetailV3Repository;
    }

    public Page<BankingProduct> findProductsLike(ParamEffective effective, BankingProduct bankingProduct, Pageable pageable, Integer version) {
        LOGGER.debug("Retrieve products matching inputs of effective {}, BankingProduct specified as {} with Paging content specified as {}" ,  effective,  bankingProduct,  pageable);
        switch (version) {
            case 2:
            case 3:
               return productsV2Repository.findAll(new BankingProductSpecification<>(effective, bankingProduct), pageable).map(product -> product);
            default:
                return productsV1Repository.findAll(new BankingProductSpecification<>(effective, bankingProduct), pageable).map(productV1 -> productV1);
        }
    }

    public BankingProductDetail getProductDetail(String productId, Integer version) {
        LOGGER.debug("Retrieving product detail by id {}",  productId);
        switch (version) {
            case 2:
                return productDetailV2Repository.findById(productId).orElse(null);
            case 3:
                return productDetailV3Repository.findById(productId).orElse(null);
            default:
                return productDetailV1Repository.findById(productId).orElse(null);
        }
    }
}

class BankingProductSpecification<T> implements Specification<T> {

    private final ParamEffective effective;
    private final BankingProduct bankingProduct;

    public BankingProductSpecification(ParamEffective effective, BankingProduct bankingProduct) {
        this.effective = effective;
        this.bankingProduct = bankingProduct;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
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
