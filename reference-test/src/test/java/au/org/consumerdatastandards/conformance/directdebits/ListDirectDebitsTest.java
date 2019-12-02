package au.org.consumerdatastandards.conformance.directdebits;

import au.org.consumerdatastandards.api.banking.models.BankingDirectDebit;
import au.org.consumerdatastandards.conformance.AccountsAPIStepsBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("testdata/banking-direct-debits-api-params.csv")
public class ListDirectDebitsTest extends DirectDebitsAPITestBase {

    private String productCategory;
    private String openStatus;
    private Boolean isOwned;
    private Integer page;
    private Integer pageSize;

    @Test
    public void listDirectDebitsBulk() {
        if (StringUtils.isBlank(steps.getApiBasePath())) {
            return;
        }
        steps.listDirectDebitsBulk(productCategory, openStatus, isOwned, page, pageSize);
        List<BankingDirectDebit> directDebits = steps.validateListDirectDebitsBulkResponse(productCategory, openStatus, isOwned, page, pageSize);
        if (directDebits != null) {
            for (BankingDirectDebit directDebit : directDebits) {
                String accountId = AccountsAPIStepsBase.getAccountId(directDebit);
                Object accountDetail = getAccountDetail(accountId);
                if (accountDetail != null) {
                    steps.validateReferencedByIdAccount(accountDetail, productCategory, openStatus, isOwned);
                }
            }
        }
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
