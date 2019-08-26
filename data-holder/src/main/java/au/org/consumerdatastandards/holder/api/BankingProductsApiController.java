package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.*;
import au.org.consumerdatastandards.holder.service.BankingProductsService;
import au.org.consumerdatastandards.holder.util.WebUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class BankingProductsApiController implements BankingProductsApi {

    private final BankingProductsService service;
    private static final Logger LOG = LogManager.getLogger(BankingProductsApiController.class);

    private final NativeWebRequest request;

    @Autowired
    public BankingProductsApiController(NativeWebRequest request, BankingProductsService service) {
        this.request = request;
        this.service = service;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<ResponseBankingProductById> getProductDetail(String productId) {
        LOG.info("Retrieving Detailed Product Information for {}", productId);

        if (!WebUtil.hasSupportedVersion(request)) {
            LOG.error(
                    "Unsupported version requested, minimum version specified is {}, maximum version specified is {}, current version is {}",
                    WebUtil.getMinimumVersion(request), WebUtil.getMaximumVersion(request),
                    WebUtil.getCurrentVersion());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        HttpHeaders headers = WebUtil.processHeaders(request);

        ResponseBankingProductById responseProductById = new ResponseBankingProductById();
        responseProductById.setData(service.getProductDetail(productId));
        responseProductById.setLinks(new Links());
        responseProductById.getLinks().setSelf(WebUtil.getOriginalUrl(request));
        responseProductById.setMeta(new Meta());

        if (responseProductById.getData() == null) {
            LOG.error("Unable to located product id {} in repository", productId);
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }

        LOG.info("Found product id of {} and returning formatted response", productId);
        LOG.info("Retrieved Product id {} with effectiveFrom: {}, effectiveTo: {}, lastUpdated: {}",
                productId, responseProductById.getData().getEffectiveFrom(), responseProductById.getData().getEffectiveTo(),
                responseProductById.getData().getLastUpdated());
        LOG.debug("Detail product response is: {}", responseProductById);
        return new ResponseEntity<>(responseProductById, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBankingProductList> listProducts(@Valid ParamEffective effective,
            @Valid OffsetDateTime updatedSince, @Valid String brand, @Valid ParamProductCategory productCategory,
            @Valid Integer page, @Valid Integer pageSize) {

        LOG.info(
                "Initiating product list call with supplied input of effective from {}, updated since {}, brand of {}, product category of {} for page {} with page size of {}",
                effective, updatedSince, brand, productCategory, page, pageSize);

        if (!WebUtil.hasSupportedVersion(request)) {
            LOG.error(
                    "Unsupported version requested, minimum version specified is {}, maximum version specified is {}, current version is {}",
                    WebUtil.getMinimumVersion(request), WebUtil.getMaximumVersion(request),
                    WebUtil.getCurrentVersion());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        HttpHeaders headers = WebUtil.processHeaders(request);
        if (!validatePageInputs(page, pageSize)) {
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }

        BankingProduct bankingProduct = new BankingProduct();
        bankingProduct.setLastUpdated(updatedSince);
        bankingProduct.setBrand(brand);
        if (productCategory != null) {
            bankingProduct.setProductCategory(BankingEnumProductCategory.fromValue(productCategory.name()));
        }

        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<BankingProduct> productsPage = service.findProductsLike(effective, bankingProduct,
                PageRequest.of(actualPage - 1, actualPageSize));

        LOG.info(
                "Returning basic product listing page {} of {} (page size of {}) using filters of effective {}, updated since {}, brand {}, product category of {}",
                actualPage, productsPage.getTotalPages(), actualPageSize, effective, updatedSince, brand,
                productCategory);

        ResponseBankingProductListData listData = new ResponseBankingProductListData();
        listData.setProducts(productsPage.getContent());

        LOG.info("Products Page data set to isFirst: {}, isLast: {}", productsPage.isFirst(), productsPage.isLast());

        LinksPaginated linkData = new LinksPaginated();
        // Baselines
        linkData.setSelf(WebUtil.getOriginalUrl(request));

        if(productsPage.getTotalPages() == 0) {
            linkData.setFirst(null);
            linkData.setLast(null);
        } else {
            linkData.setFirst(WebUtil.getPaginatedLink(request, 1, actualPageSize));
            linkData.setLast(WebUtil.getPaginatedLink(request, productsPage.getTotalPages(), actualPageSize));
        }

        if (productsPage.hasPrevious()) {
            linkData.setPrev(WebUtil.getPaginatedLink(request, actualPage - 1, actualPageSize));
        }

        if (productsPage.hasNext()) {
            linkData.setPrev(WebUtil.getPaginatedLink(request, actualPage + 1, actualPageSize));
        }

        MetaPaginated metaData = new MetaPaginated();
        metaData.setTotalPages(productsPage.getTotalPages());
        metaData.setTotalRecords((int) productsPage.getTotalElements());

        ResponseBankingProductList responseProductList = new ResponseBankingProductList();
        responseProductList.setData(listData);
        responseProductList.setLinks(linkData);
        responseProductList.setMeta(metaData);

        LOG.debug("Product listing raw response payload is: {}", responseProductList);

        return new ResponseEntity<>(responseProductList, headers, HttpStatus.OK);
    }

    private Integer getPagingValue(@Valid Integer page, int defaultValue) {
        LOG.debug("Loading page {} with default value of {}", page, defaultValue);

        return page != null && page > 0 ? page : defaultValue;
    }

    private boolean validatePageInputs(Integer page, Integer pageSize) {
        return (page == null || page >= 1) && (pageSize == null || pageSize >= 1);
    }
}
