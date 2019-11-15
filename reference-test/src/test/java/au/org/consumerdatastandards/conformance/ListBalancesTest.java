package au.org.consumerdatastandards.conformance;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("testdata/banking-balances-api-params.csv")
public class ListBalancesTest extends BalancesAPITestBase {

    private String productCategory;
    private String openStatus;
    private Boolean isOwned;
    private Integer page;
    private Integer pageSize;

    @Test
    public void listBalances() {
        if (StringUtils.isBlank(steps.getApiBasePath())) {
            return;
        }
        steps.listBalancesBulk(productCategory, openStatus, isOwned, page, pageSize);
        steps.validateListBalanceBulkResponse(productCategory, openStatus, isOwned, page, pageSize);
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setOpenStatus(String openStatus) {
        this.openStatus = openStatus;
    }

    public void setOwned(Boolean owned) {
        isOwned = owned;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
