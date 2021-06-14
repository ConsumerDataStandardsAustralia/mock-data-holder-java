package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.BankingProduct;
import au.org.consumerdatastandards.holder.model.BankingProductCategory;
import au.org.consumerdatastandards.holder.model.BankingProductDetail;
import au.org.consumerdatastandards.holder.model.BankingProductV2;
import au.org.consumerdatastandards.holder.model.Links;
import au.org.consumerdatastandards.holder.model.ParamEffective;
import au.org.consumerdatastandards.holder.model.ResponseBankingProductById;
import au.org.consumerdatastandards.holder.model.ResponseBankingProductList;
import au.org.consumerdatastandards.holder.model.ResponseBankingProductListData;
import au.org.consumerdatastandards.holder.service.BankingProductService;
import au.org.consumerdatastandards.holder.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.Optional;

@Validated
@Controller
@CrossOrigin
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
    public ResponseEntity<ResponseBankingProductById> getProductDetail(String productId,
                                                                       Integer xMinV,
                                                                       Integer xV) {
        validateSupportedVersion(xMinV, xV);
        HttpHeaders headers = generateResponseHeaders(request);
        BankingProductDetail productDetail = service.getProductDetail(productId, getSupportedVersion(xMinV, xV));
        if (productDetail == null) {
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }

        ResponseBankingProductById responseProductById = new ResponseBankingProductById();
        responseProductById.setData(productDetail);
        responseProductById.setLinks(new Links());
        responseProductById.getLinks().setSelf(WebUtil.getOriginalUrl(request));
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
                                                                   Integer xMinV,
                                                                   Integer xV) {

        logger.info(
            "Initiating product list call with supplied input of effective from {}, updated since {}, brand of {}, product category of {} for page {} with page size of {}",
            effective, updatedSince, brand, productCategory, page, pageSize);
        validateSupportedVersion(xMinV, xV);
        validatePageSize(pageSize);
        HttpHeaders headers = generateResponseHeaders(request);
        BankingProduct bankingProduct = new BankingProductV2();
        bankingProduct.setLastUpdated(updatedSince);
        bankingProduct.setBrand(brand);
        if (productCategory != null) {
            bankingProduct.setProductCategory(BankingProductCategory.valueOf(productCategory.name()));
        }

        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<BankingProduct> productsPage = service.findProductsLike(effective, bankingProduct,
            PageRequest.of(actualPage - 1, actualPageSize, Sort.by(Sort.Direction.DESC, "lastUpdated")), getSupportedVersion(xMinV, xV));

        logger.info(
            "Returning basic product listing page {} of {} (page size of {}) using filters of effective {}, updated since {}, brand {}, product category of {}",
            actualPage, productsPage.getTotalPages(), actualPageSize, effective, updatedSince, brand,
            productCategory);

        validatePageRange(page, productsPage.getTotalPages());

        ResponseBankingProductListData listData = new ResponseBankingProductListData();
        listData.setProducts(productsPage.getContent());

        logger.info("Products Page data set to isFirst: {}, isLast: {}", productsPage.isFirst(), productsPage.isLast());

        ResponseBankingProductList responseProductList = new ResponseBankingProductList();
        responseProductList.setData(listData);
        responseProductList.setLinks(getLinkData(request, productsPage, actualPage, actualPageSize));
        responseProductList.setMeta(getMetaData(productsPage));

        logger.debug("Product listing raw response payload is: {}", responseProductList);
        return new ResponseEntity<>(responseProductList, headers, HttpStatus.OK);
    }

    @Override
    protected Integer getCurrentVersion() {
        return 3;
    }
}
