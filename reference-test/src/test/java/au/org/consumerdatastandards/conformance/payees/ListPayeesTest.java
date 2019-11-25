package au.org.consumerdatastandards.conformance.payees;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("testdata/banking-payees-api-params.csv")
public class ListPayeesTest extends PayeesAPITestBase {

    private String type;
    private Integer page;
    private Integer pageSize;

    @Test
    public void listPayees() {
        if (StringUtils.isBlank(steps.getApiBasePath())) {
            return;
        }
        steps.listPayees(type, page, pageSize);
        steps.validateListPayeesResponse(type, page, pageSize);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
