package au.org.consumerdatastandards.conformance;


import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(SerenityRunner.class)
public class GetProductDetailTest extends BankingProductsAPITestBase {

    @Test
    public void getProductDetail() {
        steps.listProducts("ALL", null, null, null, null, 50);
        List<String> productIds = steps.getProductIds();
        if (productIds != null && !productIds.isEmpty()) {
            for (String productId : productIds) {
                steps.getProductDetail(productId);
                steps.validateGetProductDetailResponse(productId);
            }
        }
    }
}
