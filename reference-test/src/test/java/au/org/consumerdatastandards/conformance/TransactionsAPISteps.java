package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.api.banking.models.BankingTransaction;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingTransactionList;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingTransactionListData;
import au.org.consumerdatastandards.conformance.util.ConformanceUtil;
import au.org.consumerdatastandards.support.Header;
import au.org.consumerdatastandards.support.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.util.DateTime;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TransactionsAPISteps extends APIStepsBase {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private PayloadValidator payloadValidator = new PayloadValidator();
    private Response getTransactionsResponse;
    private String requestUrl;
    private ResponseBankingTransactionList responseBankingTransactionList;

    @Step("Request /banking/accounts/{accountId}/transactions")
    void getTransactions(String accountId, String oldestTime, String newestTime, String minAmount, String maxAmount,
                      String text, Integer page, Integer pageSize) {
        String url = getApiBasePath() + "/banking/accounts/{accountId}/transactions/" + accountId;
        requestUrl = url;
        boolean paramAdded = false;
        RequestSpecification given = given()
                .header("Accept", "application/json")
                .header(Header.VERSION.getKey(), payloadValidator.getEndpointVersion("getTransactions"));
        if (!StringUtils.isBlank(oldestTime)) {
            given.queryParam("oldest-time", oldestTime);
            requestUrl += "?oldest-time=" + oldestTime;
            paramAdded = true;
        }
        if (!StringUtils.isBlank(newestTime)) {
            given.queryParam("newest-time", newestTime);
            requestUrl += "?newest-time=" + newestTime;
            paramAdded = true;
        }
        if (!StringUtils.isBlank(minAmount)) {
            given.queryParam("min-amount", minAmount);
            requestUrl += "?min-amount=" + minAmount;
            paramAdded = true;
        }
        if (!StringUtils.isBlank(maxAmount)) {
            given.queryParam("max-amount", maxAmount);
            requestUrl += "?max-amount=" + maxAmount;
            paramAdded = true;
        }
        if (!StringUtils.isBlank(text)) {
            given.queryParam("text", text);
            requestUrl += "?text=" + text;
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

        getTransactionsResponse = given.relaxedHTTPSValidation().when().get(url).then().log().all().extract().response();
    }

    @Step("Validate /banking/accounts/{accountId}/transactions response")
    void validateGetTransactionsResponse(String accountId, String oldestTime, String newestTime, String minAmount, String maxAmount,
                                         String text, Integer page, Integer pageSize) {
        boolean paramsValid = validateGetTransactionsParams(accountId, oldestTime, newestTime, minAmount, maxAmount, text, page, pageSize);
        int statusCode = getTransactionsResponse.statusCode();
        if (paramsValid) {
            assertEquals(ResponseCode.OK.getCode(), statusCode);
            List<ConformanceError> conformanceErrors = new ArrayList<>();
            checkResponseHeaders(getTransactionsResponse, conformanceErrors);
            checkProtectedEndpointResponseHeaders(getTransactionsResponse, conformanceErrors);
            checkJsonContentType(getTransactionsResponse.contentType(), conformanceErrors);
            String json = getTransactionsResponse.getBody().asString();
            ObjectMapper objectMapper = ConformanceUtil.createObjectMapper();
            try {
                responseBankingTransactionList = objectMapper.readValue(json, ResponseBankingTransactionList.class);
                payloadValidator.validateResponse(this.requestUrl, responseBankingTransactionList, "getTransactions", statusCode);
                ResponseBankingTransactionListData data = (ResponseBankingTransactionListData) getResponseData(responseBankingTransactionList);
                List<BankingTransaction> transactions = getTransactions(data);
                if (transactions != null) {
                    for (BankingTransaction transaction : transactions) {
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

    private static Object getField(Object obj, String fieldName) {
        Field dataField = FieldUtils.getField(obj.getClass(), fieldName, true);
        return ReflectionUtils.getField(dataField, obj);
    }

    @SuppressWarnings("unchecked")
    private static List<BankingTransaction> getTransactions(Object obj) {
        return (List<BankingTransaction>) getField(obj, "transactions");
    }

    private static boolean validateGetTransactionsParams(String accountId, String oldestTime, String newestTime, String minAmount, String maxAmount,
                                                         String text, Integer page, Integer pageSize) {
        if (StringUtils.isBlank(accountId)) {
            return false;
        }
        if (!StringUtils.isBlank(oldestTime)) {
            try {
                DateTime.parseRfc3339(oldestTime);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        if (!StringUtils.isBlank(newestTime)) {
            try {
                DateTime.parseRfc3339(newestTime);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        if (!StringUtils.isBlank(minAmount)) {
            try {
                new BigDecimal(minAmount);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        if (!StringUtils.isBlank(maxAmount)) {
            try {
                new BigDecimal(maxAmount);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return (page == null || page >= 1) && (pageSize == null || pageSize >= 1);
    }

    private static Object getResponseData(Object response) {
        return getField(response, "data");
    }
}
