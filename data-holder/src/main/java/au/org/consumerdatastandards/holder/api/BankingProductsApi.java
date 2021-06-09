package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.BankingProductCategory;
import au.org.consumerdatastandards.holder.model.ParamEffective;
import au.org.consumerdatastandards.holder.model.ResponseBankingProductById;
import au.org.consumerdatastandards.holder.model.ResponseBankingProductList;
import au.org.consumerdatastandards.holder.model.ResponseErrorListV2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.Optional;

@Api(value = "BankingProducts", description = "the BankingProducts API")
public interface BankingProductsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(
        value = "Get Product Detail",
        nickname = "getProductDetail",
        notes = "Obtain detailed information on a single product offered openly to the market",
        response = ResponseBankingProductById.class,
        tags = {"Products", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Successful response for Get Product Detail",
            response = ResponseBankingProductById.class
        ),
        @ApiResponse(
            code = 400,
            message = "Invalid Version / Invalid Field",
            response = ResponseErrorListV2.class
        ),
        @ApiResponse(
            code = 404,
            message = "Invalid Resource / Unavailable Resource",
            response = ResponseErrorListV2.class
        ),
        @ApiResponse(
            code = 406,
            message = "Unsupported Version",
            response = ResponseErrorListV2.class
        )
    })
    @RequestMapping(
        value = "/banking/products/{productId}",
        method = RequestMethod.GET
    )
    ResponseEntity<ResponseBankingProductById> getProductDetail(
        @ApiParam(
            value = "ID of the specific product requested",
            required = true
        )
        @PathVariable("productId") @NotBlank String productId,
        @ApiParam(
            value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable."
        )
        @RequestHeader(value = "x-min-v", required = false) @Min(1) Integer xMinV,
        @ApiParam(
            value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)"
        )
        @RequestHeader(value = "x-v", required = false) @Min(1) Integer xV
    );

    @ApiOperation(
        value = "Get Products",
        nickname = "listProducts",
        notes = "Obtain a list of products that are currently openly offered to the market  Note that the results returned by this end point are expected to be ordered in descending order according to lastUpdated  ### Conventions In the product reference payloads there are a number of recurring conventions that are explained here, in one place.  #### Arrays Of Features  In the product detail payload there are a number of arrays articulating generic features, constraints, prices, etc. The intent of these arrays is as follows:  - Each element in an array has the same structure so that clients can reliably interpret the payloads - Each element as a type element that is an enumeration of the specific aspect of a product being described, such as types of fees. - Each element has a field name additionalValue.  This is a generic field with contents that will vary based on the type of object being described. The contents of this field for the ADDITIONAL_CARDS feature is the number of cards allowed while the contents of this field for the MAX_LIMIT constraint would be the maximum credit limit allowed for the product. - An element in these arrays of the same type may appear more than once. For instance, a product may offer two separate loyalty programs that the customer can select from. A fixed term mortgage may have different rates for different term lengths. - An element in these arrays may contain an additionalInfo and additionalInfoUri field. The additionalInfo field is used to provide displayable text clarifying the purpose of the element in some way when the product is presented to a customer. The additionalInfoUri provides a link to externally hosted information specifically relevant to that feature of the product. - Depending on the type of data being represented there may be additional specific fields.  #### URIs To More Information  As the complexities and nuances of a financial product can not easily be fully expressed in a data structure without a high degree of complexity it is necessary to provide additional reference information that a potential customer can access so that they are fully informed of the features and implications of the product. The payloads for product reference therefore contain numerous fields that are provided to allow the product holder to describe the product more fully using a web page hosted on their online channels.  These URIs do not need to all link to different pages. If desired, they can all link to a single hosted page and use difference HTML anchors to focus on a specific topic such as eligibility or fees.  #### Linkage To Accounts From the moment that a customer applies for a product and an account is created the account and the product that spawned it will diverge.  Rates and features of the product may change and a discount may be negotiated for the account.  For this reason, while productCategory is a common field between accounts and products, there is no specific ID that can be used to link an account to a product within the regime.  Similarly, many of the fields and objects in the product payload will appear in the account detail payload but the structures and semantics are not identical as one refers to a product that can potentially be originated and one refers to an account that actual has been instantiated and created along with the associated decisions inherent in that process.  #### Dates It is expected that data consumers needing this data will call relatively frequently to ensure the data they have is representative of the current offering from a bank.  To minimise the volume and frequency of these calls the ability to set a lastUpdated field with the date and time of the last update to this product is included.  A call for a list of products can then be filtered to only return products that have been updated since the last time that data was obtained using the updated-since query parameter.  In addition, the concept of effective date and time has also been included.  This allows for a product to be marked for obsolescence, or introduction, from a certain time without the need for an update to show that a product has been changed.  The inclusion of these dates also removes the need to represent deleted products in the payload.  Products that are no long offered can be marked not effective for a few weeks before they are then removed from the product set as an option entirely.",
        response = ResponseBankingProductList.class,
        tags = {"Products", "Banking"}
    )
    @ApiResponses(value = {
        @ApiResponse(
            code = 200,
            message = "Successful response for Get Products",
            response = ResponseBankingProductList.class
        ),
        @ApiResponse(
            code = 400,
            message = "Invalid Version / Invalid Page Size / Invalid Field / Invalid Date",
            response = ResponseErrorListV2.class
        ),
        @ApiResponse(
            code = 406,
            message = "Unsupported Version",
            response = ResponseErrorListV2.class
        ),
        @ApiResponse(
            code = 422,
            message = "Invalid Page",
            response = ResponseErrorListV2.class
        )
    })
    @RequestMapping(
        value = "/banking/products",
        method = RequestMethod.GET
    )
    ResponseEntity<ResponseBankingProductList> listProducts(
        @ApiParam(
            value = "Allows for the filtering of products based on whether the current time is within the period of time defined as effective by the effectiveFrom and effectiveTo fields. Valid values are ‘CURRENT’, ‘FUTURE’ and ‘ALL’. If absent defaults to &#39;CURRENT&#39;",
            allowableValues = "ALL, CURRENT, FUTURE",
            defaultValue = "CURRENT"
        )
        @RequestParam(value = "effective", required = false, defaultValue = "CURRENT") ParamEffective effective,
        @ApiParam(
            value = "Only include products that have been updated after the specified date and time. If absent defaults to include all products"
        )
        @RequestParam(value = "updated-since", required = false) OffsetDateTime updatedSince,
        @ApiParam(
            value = "Filter results based on a specific brand"
        )
        @RequestParam(value = "brand", required = false) String brand,
        @ApiParam(
            value = "Used to filter results on the productCategory field applicable to accounts. Any one of the valid values for this field can be supplied. If absent then all accounts returned.",
            allowableValues = "CRED_AND_CHRG_CARDS, LEASES, MARGIN_LOANS, PERS_LOANS, REGULATED_TRUST_ACCOUNTS, RESIDENTIAL_MORTGAGES, TERM_DEPOSITS, TRADE_FINANCE, TRANS_AND_SAVINGS_ACCOUNTS, TRAVEL_CARDS"
        )
        @RequestParam(value = "product-category", required = false) BankingProductCategory productCategory,
        @ApiParam(
            value = "Page of results to request (standard pagination)",
            defaultValue = "1"
        )
        @RequestParam(value = "page", required = false, defaultValue = "1") @Min(1) Integer page,
        @ApiParam(
            value = "Page size to request. Default is 25 (standard pagination)",
            defaultValue = "25"
        )
        @RequestParam(value = "page-size", required = false, defaultValue = "25") @Min(1) Integer pageSize,
        @ApiParam(
            value = "Minimum version of the API end point requested by the client. Must be set to a positive integer if provided. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable."
        )
        @RequestHeader(value = "x-min-v", required = false) @Min(1) Integer xMinV,
        @ApiParam(
            value = "Version of the API end point requested by the client. Must be set to a positive integer. The data holder should respond with the highest supported version between [x-min-v](#request-headers) and [x-v](#request-headers). If the value of [x-min-v](#request-headers) is equal to or higher than the value of [x-v](#request-headers) then the [x-min-v](#request-headers) header should be treated as absent. If all versions requested are not supported then the data holder must respond with a 406 Not Acceptable. See [HTTP Headers](#request-headers)"
        )
        @RequestHeader(value = "x-v", required = false) @Min(1) Integer xV
    );
}
