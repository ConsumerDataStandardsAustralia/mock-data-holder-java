package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.api.banking.models.BankingAccount;
import au.org.consumerdatastandards.api.banking.models.BankingProductCategory;
import au.org.consumerdatastandards.api.banking.models.ParamProductCategory;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountList;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountListData;
import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.support.Header;
import au.org.consumerdatastandards.support.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static au.org.consumerdatastandards.conformance.ConformanceError.Type.DATA_NOT_MATCHING_CRITERIA;
import static net.serenitybdd.rest.SerenityRest.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AccountsAPISteps extends APIStepsBase {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private PayloadValidator payloadValidator = new PayloadValidator();
    private Response listAccountsResponse;
    private String requestUrl;
    private ResponseBankingAccountList responseBankingAccountList;

    @Step("Request /banking/accounts")
    void listAccounts(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
        String url = getApiBasePath() + "/banking/accounts";
        requestUrl = url;
        boolean paramAdded = false;
        RequestSpecification given = given()
                .header("Accept", "application/json")
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("listAccounts"));
        if (!StringUtils.isBlank(openStatus)) {
            given.queryParam("open-status", openStatus);
            requestUrl += "?open-status=" + openStatus;
            paramAdded = true;
        }
        if (isOwned != null) {
            given.queryParam("is-owned", isOwned);
            requestUrl += (paramAdded ? "&" : "?") + "is-owned=" + isOwned;
            paramAdded = true;
        }
        if (!StringUtils.isBlank(productCategory)) {
            given.queryParam("product-category", productCategory);
            requestUrl += (paramAdded ? "&" : "?") + "product-category=" + productCategory;
            paramAdded = true;
        }
        if (page != null) {
            given.queryParam("page", page);
            requestUrl += (paramAdded ? "&" : "?") + "page=" + page;
            paramAdded = true;
        }
        if (pageSize != null) {
            given.queryParam("page-size", pageSize);
            requestUrl += (paramAdded ? "&" : "?") + "page-size=" + pageSize;
        }

        listAccountsResponse = given.relaxedHTTPSValidation().when().get(url).then().log().all().extract().response();
    }

    @Step("Validate /banking/accounts response")
    void validateListAccountsResponse(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
        boolean paramsValid = validateListAccountsParams(productCategory, openStatus, isOwned, page, pageSize);
        int statusCode = listAccountsResponse.statusCode();
        if (paramsValid) {
            assertEquals(ResponseCode.OK.getCode(), statusCode);
            List<ConformanceError> conformanceErrors = new ArrayList<>();
            checkResponseHeaders(listAccountsResponse, conformanceErrors);
            checkProtectedEndpointResponseHeaders(listAccountsResponse, conformanceErrors);
            checkJsonContentType(listAccountsResponse.contentType(), conformanceErrors);
            String json = listAccountsResponse.getBody().asString();
            ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
            try {
                responseBankingAccountList = objectMapper.readValue(json, ResponseBankingAccountList.class);
                payloadValidator.validateResponse(this.requestUrl, responseBankingAccountList, "listAccounts", statusCode);
                ResponseBankingAccountListData data = (ResponseBankingAccountListData) getField(responseBankingAccountList, "data");
                List<BankingAccount> accounts = getAccounts(data);
                if (accounts != null) {
                    for (BankingAccount account : accounts) {
                        checkProductCategory(account, productCategory, conformanceErrors);
                        checkOpenStatus(account, openStatus, conformanceErrors);
                        checkOwned(account, isOwned, conformanceErrors);
                    }
                }
            } catch (IOException e) {
                fail(e.getMessage());
            }
        } else {
            assertEquals(ResponseCode.BAD_REQUEST.getCode(), statusCode);
        }
    }

    private void checkOwned(BankingAccount account, Boolean isOwned, List<ConformanceError> errors) {
        if (isOwned != null) {
            Boolean accountOwned = (Boolean) getField(account, "isOwned");
            if (!isOwned.equals(accountOwned)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingAccount.class, "isOwned", true))
                        .dataJson(ConformanceUtil.toJson(account))
                        .errorMessage(String.format(
                                "BankingAccount isOwned %b does not match isOwned query %b",
                                accountOwned, isOwned)));
            }
        }
    }

    private void checkOpenStatus(BankingAccount account, String openStatus, List<ConformanceError> errors) {
        if (!StringUtils.isBlank(openStatus)) {
            BankingAccount.OpenStatus accountOpenStatus = (BankingAccount.OpenStatus) getField(account, "openStatus");
            if (accountOpenStatus == null || !accountOpenStatus.name().equals(openStatus)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingAccount.class, "openStatus", true))
                        .dataJson(ConformanceUtil.toJson(account))
                        .errorMessage(String.format(
                                "BankingAccount openStatus %s does not match openStatus query %s",
                                accountOpenStatus.name(), openStatus)));
            }
        }
    }

    private void checkProductCategory(BankingAccount account, String productCategory, List<ConformanceError> errors) {
        if (!StringUtils.isBlank(productCategory)) {
            BankingProductCategory bankingProductCategory = (BankingProductCategory) getField(account, "productCategory");
            if (bankingProductCategory == null || !bankingProductCategory.name().equals(productCategory)) {
                errors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                        .errorField(FieldUtils.getField(BankingAccount.class, "productCategory", true))
                        .dataJson(ConformanceUtil.toJson(account))
                        .errorMessage(String.format(
                                "BankingAccount productCategory %s does not match productCategory query %s",
                                bankingProductCategory, productCategory)));
            }
        }
    }

    private Object getField(Object obj, String fieldName) {
        Field dataField = FieldUtils.getField(obj.getClass(), fieldName, true);
        return ReflectionUtils.getField(dataField, obj);
    }

    @SuppressWarnings("unchecked")
    private List<BankingAccount> getAccounts(ResponseBankingAccountListData accountListData) {
        return (List<BankingAccount>) getField(accountListData, "accounts");
    }

    private boolean validateListAccountsParams(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
        if (!StringUtils.isBlank(productCategory)) {
            try {
                ParamProductCategory.valueOf(productCategory);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        if (!StringUtils.isBlank(openStatus)) {
            try {
                BankingAccount.OpenStatus.valueOf(openStatus);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return (page == null || page >= 1) && (pageSize == null || pageSize >= 1);
    }
}
