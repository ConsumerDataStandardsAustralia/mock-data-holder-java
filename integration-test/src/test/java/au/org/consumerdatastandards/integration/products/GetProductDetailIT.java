package au.org.consumerdatastandards.integration.products;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.BankingProductsAPI;
import au.org.consumerdatastandards.client.model.BankingProduct;
import au.org.consumerdatastandards.client.model.ResponseBankingProductById;
import au.org.consumerdatastandards.client.model.ResponseBankingProductList;
import au.org.consumerdatastandards.integration.utils.ResponseCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GetProductDetailIT extends ITBase {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final BankingProductsAPI api = new BankingProductsAPI();

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    public void getProductsDetail(Integer version) throws ApiException {
        api.setApiClient(clientFactory.create(false, false));

        List<ConformanceError> conformanceErrors = new ArrayList<>();

        ResponseBankingProductList<BankingProduct> prods = api.listProducts(null, null, null, null, version, null, null);
        for (BankingProduct prod : prods.getData().getProducts()) {
            ApiResponse<ResponseBankingProductById> resp = api.getProductDetailWithHttpInfo(prod.getProductId(), version);
            Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
            checkResponseHeaders(resp.getHeaders(), conformanceErrors);
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                "Conformance errors found in response payload: " + buildConformanceErrorsDescription(conformanceErrors));
    }
}
