package au.org.consumerdatastandards.holder.api.banking;

import au.org.consumerdatastandards.holder.api.ApiControllerBase;
import au.org.consumerdatastandards.holder.model.banking.BankingProduct;
import au.org.consumerdatastandards.holder.model.banking.BankingProductCategory;
import au.org.consumerdatastandards.holder.model.banking.BankingProductDetail;
import au.org.consumerdatastandards.holder.model.banking.BankingProductV2;
import au.org.consumerdatastandards.holder.model.Links;
import au.org.consumerdatastandards.holder.model.banking.ParamEffective;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingProductById;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingProductList;
import au.org.consumerdatastandards.holder.model.banking.ResponseBankingProductListData;
import au.org.consumerdatastandards.holder.service.banking.BankingProductService;
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
@CrossOrigin(allowedHeaders = "*")
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
        int supportedVersion = validateSupportedVersion(xMinV, xV, WebUtil.NO_INTERACTION_ID, 4);
        HttpHeaders headers = generateResponseHeaders(null, supportedVersion);
        BankingProductDetail productDetail = service.getProductDetail(productId, supportedVersion);
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
        int supportedVersion = validateSupportedVersion(xMinV, xV, WebUtil.NO_INTERACTION_ID, 3);
        validatePageSize(pageSize, WebUtil.NO_INTERACTION_ID);
        validateUpdatedSince(updatedSince, WebUtil.NO_INTERACTION_ID);
        HttpHeaders headers = generateResponseHeaders(null, supportedVersion);
        BankingProduct bankingProduct = new BankingProductV2();
        bankingProduct.setLastUpdated(updatedSince);
        bankingProduct.setBrand(brand);
        bankingProduct.setProductCategory(productCategory);

        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<BankingProduct> productsPage = service.findProductsLike(effective, bankingProduct,
            PageRequest.of(actualPage - 1, actualPageSize, Sort.by(Sort.Direction.DESC, "lastUpdated")), supportedVersion);

        logger.info(
            "Returning basic product listing page {} of {} (page size of {}) using filters of effective {}, updated since {}, brand {}, product category of {}",
            actualPage, productsPage.getTotalPages(), actualPageSize, effective, updatedSince, brand,
            productCategory);

        validatePageRange(page, productsPage.getTotalPages(), WebUtil.NO_INTERACTION_ID);

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
}
