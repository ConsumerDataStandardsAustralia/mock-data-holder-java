package au.org.consumerdatastandards.holder.service;

import au.org.consumerdatastandards.holder.model.BankingProduct;
import au.org.consumerdatastandards.holder.model.BankingProductDetail;
import au.org.consumerdatastandards.holder.model.ParamEffective;
import au.org.consumerdatastandards.holder.repository.BankingProductDetailRepository;
import au.org.consumerdatastandards.holder.repository.BankingProductRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankingProductService {

    private final BankingProductRepository productsRepository;
    private final BankingProductDetailRepository productDetailsRepository;
    
    private static final Logger LOG = LogManager.getLogger(BankingProductService.class);


    @Autowired
    public BankingProductService(BankingProductRepository productsRepository, BankingProductDetailRepository productDetailsRepository) {
        this.productsRepository = productsRepository;
        this.productDetailsRepository = productDetailsRepository;
    }

    public Page<BankingProduct> findProductsLike(ParamEffective effective, BankingProduct bankingProduct, Pageable pageable) {
        
        LOG.debug("Retrieve database products matching inputs of effective {}, BankingProduct specified as {} with Paging content specified as {}" ,  effective,  bankingProduct,  pageable);
        
        return productsRepository.findAll((Specification<BankingProduct>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(ParamEffective.CURRENT.equals(effective) || effective == null) {
                // If Effective is not supplied, assume CURRENT as per Standard
                // https://consumerdatastandardsaustralia.github.io/standards/#get-products
                OffsetDateTime now = OffsetDateTime.now();
                predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("effectiveFrom"), now)));
                predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("effectiveTo"), now)));
            } else if(ParamEffective.FUTURE.equals(effective)) {
                OffsetDateTime now = OffsetDateTime.now();
                predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThan(root.get("effectiveFrom"), now)));
            }
            if (bankingProduct.getProductCategory() != null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("productCategory"), bankingProduct.getProductCategory())));
            }
            if (bankingProduct.getLastUpdated() != null) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("lastUpdated"), bankingProduct.getLastUpdated())));
            }
            if (!StringUtils.isEmpty(bankingProduct.getBrand())) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("brand"), "%" + bankingProduct.getBrand() + "%")));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, pageable);
    }

    public BankingProductDetail getProductDetail(String productId) {
        LOG.debug("Retrieving detailed product information from database for Product ID of {}",  productId);
        Optional<BankingProductDetail> byId = productDetailsRepository.findById(productId);
        return byId.orElse(null);
    }
}
