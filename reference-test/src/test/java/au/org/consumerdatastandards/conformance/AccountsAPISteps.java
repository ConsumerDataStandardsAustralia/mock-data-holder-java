package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.api.banking.models.BankingAccount;
import au.org.consumerdatastandards.api.banking.models.BankingProductCategory;
import au.org.consumerdatastandards.api.banking.models.ParamProductCategory;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountById;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountList;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingAccountListData;
import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.support.Header;
import au.org.consumerdatastandards.support.ResponseCode;
import au.org.consumerdatastandards.support.data.CustomDataType;
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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AccountsAPISteps extends APIStepsBase {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private PayloadValidator payloadValidator = new PayloadValidator();
    private Response listAccountsResponse;
    private String requestUrl;
    private ResponseBankingAccountList responseBankingAccountList;
    private Response getAccountDetailResponse;

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
                ResponseBankingAccountListData data = (ResponseBankingAccountListData) getAccountListData(responseBankingAccountList);
                List<BankingAccount> accounts = getAccounts(data);
                if (accounts != null) {
                    for (BankingAccount account : accounts) {
                        checkProductCategory(account, productCategory, conformanceErrors);
                        checkOpenStatus(account, openStatus, conformanceErrors);
                        checkOwned(account, isOwned, conformanceErrors);
                    }
                }
                for (ConformanceError error : conformanceErrors) {
                    logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    logger.error(error.getDescription());
                }

                assertTrue("Conformance errors found in response payload"
                        + buildConformanceErrorsDescription(conformanceErrors), conformanceErrors.isEmpty());
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

    private static Object getField(Object obj, String fieldName) {
        Field dataField = FieldUtils.getField(obj.getClass(), fieldName, true);
        return ReflectionUtils.getField(dataField, obj);
    }

    @SuppressWarnings("unchecked")
    private static List<BankingAccount> getAccounts(Object accountListData) {
        return (List<BankingAccount>) getField(accountListData, "accounts");
    }

    private static boolean validateListAccountsParams(String productCategory, String openStatus, Boolean isOwned, Integer page, Integer pageSize) {
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

    @Step("Request /banking/accounts/{accountId}")
    void getAccountDetail(String accountId) {
        String url = getApiBasePath() + "/banking/accounts/" + accountId;
        requestUrl = url;
        getAccountDetailResponse = given().relaxedHTTPSValidation()
                .header("Accept", "application/json")
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("getAccountDetail"))
                .when().get(url).then().log().body().extract().response();
    }

    @Step("Validate /banking/accounts/{accountId} response")
    void validateGetAccountDetailResponse(String accountId) {
        int statusCode = getAccountDetailResponse.statusCode();
        if (accountId.matches(CustomDataType.ASCII.getPattern())) {
            assertEquals(ResponseCode.OK.getCode(), statusCode);
            List<ConformanceError> conformanceErrors = new ArrayList<>();
            checkResponseHeaders(getAccountDetailResponse, conformanceErrors);
            checkJsonContentType(getAccountDetailResponse.contentType(), conformanceErrors);
            String json = getAccountDetailResponse.getBody().asString();
            ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
            try {
                Class<?> expandedResponseClass = ConformanceUtil.expandModel(ResponseBankingAccountById.class);
                Object responseBankingAccountById = objectMapper.readValue(json, expandedResponseClass);
                conformanceErrors.addAll(payloadValidator.validateResponse(this.requestUrl, responseBankingAccountById,
                        "getAccountDetail", statusCode));
                Object data = getAccountListData(responseBankingAccountById);
                String id = getAccountId(data);
                if (!id.equals(accountId)) {
                    conformanceErrors.add(new ConformanceError().errorType(DATA_NOT_MATCHING_CRITERIA)
                            .dataJson(ConformanceUtil.toJson(responseBankingAccountById)).errorMessage(String.format(
                                    "Response accountId %s does not match request accountId %s", id, accountId)));
                }
                for (ConformanceError error : conformanceErrors) {
                    logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    logger.error(error.getDescription());
                }
                String message = "Conformance errors found in response payload: "
                        + buildConformanceErrorsDescription(conformanceErrors);
                assertTrue(message, conformanceErrors.isEmpty());
            } catch (IOException e) {
                fail(e.getMessage());
            }
        } else {
            assertEquals(ResponseCode.BAD_REQUEST.getCode(), statusCode);
        }
    }

    private static String getAccountId(Object data) {
        return (String) getField(data, "accountId");
    }

    private static Object getAccountListData(Object responseBankingAccountById) {
        return getField(responseBankingAccountById, "data");
    }

    List<String> getAccountIds() {
        String json = listAccountsResponse.getBody().asString();
        ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
        try {
            responseBankingAccountList = objectMapper.readValue(json, ResponseBankingAccountList.class);
            if (responseBankingAccountList != null) {
                List<BankingAccount> accounts = getAccounts(getAccountListData(responseBankingAccountList));
                if (accounts == null || accounts.isEmpty()) {
                    return null;
                }
                List<String> productIds = new ArrayList<>();
                for (BankingAccount account : accounts) {
                    productIds.add(getAccountId(account));
                }
                return productIds;
            }
        } catch (IOException e) {
            fail(e.getMessage());
        }
        return null;
    }
}
