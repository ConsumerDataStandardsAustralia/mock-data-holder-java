package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.*;
import au.org.consumerdatastandards.holder.service.BankingProductService;
import au.org.consumerdatastandards.holder.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.Min;
import java.time.OffsetDateTime;
import java.util.Optional;

@Validated
@Controller
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class BankingProductsApiController extends ApiControllerBase implements BankingProductsApi {

    private final BankingProductService service;
    private final NativeWebRequest request;

    @Autowired
    public BankingProductsApiController(NativeWebRequest request, BankingProductService service) {
        this.request = request;
        this.service = service;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<ResponseBankingProductById> getProductDetail(String productId, @Min(1) Integer xMinV, @Min(1) Integer xV) {
        if (!hasSupportedVersion(xMinV, xV)) {
            logger.error(
                "Unsupported version requested, minimum version specified is {}, maximum version specified is {}, current version is {}",
                xMinV, xV, getCurrentVersion());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        HttpHeaders headers = generateResponseHeaders(request);
        BankingProductDetail productDetail = service.getProductDetail(productId);
        if (productDetail == null) {
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }

        ResponseBankingProductById responseProductById = new ResponseBankingProductById();
        responseProductById.setData(productDetail);
        responseProductById.setLinks(new Links());
        responseProductById.getLinks().setSelf(WebUtil.getOriginalUrl(request));
        responseProductById.setMeta(new Meta());


        logger.info("Found product id of {} and returning formatted response", productId);
        logger.debug("Detail product response is: {}", responseProductById);
        return new ResponseEntity<>(responseProductById, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBankingProductList> listProducts(ParamEffective effective,
                                                                   OffsetDateTime updatedSince,
                                                                   String brand,
                                                                   BankingProductCategory productCategory,
                                                                   Integer page,
                                                                   Integer pageSize, 
                                                                   @Min(1) Integer xMinV,
                                                                   @Min(1) Integer xV) {

        logger.info(
            "Initiating product list call with supplied input of effective from {}, updated since {}, brand of {}, product category of {} for page {} with page size of {}",
            effective, updatedSince, brand, productCategory, page, pageSize);

        if (!hasSupportedVersion(xMinV, xV)) {
            logger.error(
                "Unsupported version requested, minimum version specified is {}, maximum version specified is {}, current version is {}",
                xMinV, xV, getCurrentVersion());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        HttpHeaders headers = generateResponseHeaders(request);
        if (!validatePageInputs(page, pageSize)) {
            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }

        BankingProduct bankingProduct = new BankingProduct();
        bankingProduct.setLastUpdated(updatedSince);
        bankingProduct.setBrand(brand);
        if (productCategory != null) {
            bankingProduct.setProductCategory(BankingProductCategory.valueOf(productCategory.name()));
        }

        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<BankingProduct> productsPage = service.findProductsLike(effective, bankingProduct,
            PageRequest.of(actualPage - 1, actualPageSize));

        logger.info(
            "Returning basic product listing page {} of {} (page size of {}) using filters of effective {}, updated since {}, brand {}, product category of {}",
            actualPage, productsPage.getTotalPages(), actualPageSize, effective, updatedSince, brand,
            productCategory);

        ResponseBankingProductListData listData = new ResponseBankingProductListData();
        listData.setProducts(productsPage.getContent());

        logger.info("Products Page data set to isFirst: {}, isLast: {}", productsPage.isFirst(), productsPage.isLast());

        LinksPaginated linkData = new LinksPaginated();
        // Baselines
        linkData.setSelf(WebUtil.getOriginalUrl(request));

        if (productsPage.getTotalPages() == 0) {
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

        logger.debug("Product listing raw response payload is: {}", responseProductList);
        return new ResponseEntity<>(responseProductList, headers, HttpStatus.OK);
    }
}
