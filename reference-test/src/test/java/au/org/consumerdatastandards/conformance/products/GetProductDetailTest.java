package au.org.consumerdatastandards.conformance.products;


import net.serenitybdd.junit.runners.SerenityRunner;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(SerenityRunner.class)
public class GetProductDetailTest extends BankingProductsAPITestBase {

    @Test
    public void getProductDetail() {
        if (StringUtils.isBlank(steps.getApiBasePath())) return;
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
