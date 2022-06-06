/*
 * Consumer Data Standards
 * Sample CLI tool to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 */
package au.org.consumerdatastandards.client.cli.banking;

import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.banking.BankingScheduledPaymentsAPI;
import au.org.consumerdatastandards.client.cli.ApiCliBase;
import au.org.consumerdatastandards.client.cli.support.JsonPrinter;
import au.org.consumerdatastandards.client.model.banking.RequestAccountIds;
import au.org.consumerdatastandards.client.model.banking.ResponseBankingScheduledPaymentsList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
@ShellCommandGroup("BankingScheduledPayments")
public class BankingScheduledPayments extends ApiCliBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankingScheduledPayments.class);

    private final BankingScheduledPaymentsAPI api = new BankingScheduledPaymentsAPI();

    @ShellMethod("List scheduled payments")
    public String listScheduledPayments(@ShellOption(defaultValue = "false") boolean check,
        @ShellOption(defaultValue = ShellOption.NULL) String accountId,
        @ShellOption(defaultValue = ShellOption.NULL) Integer page,
        @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("List scheduled payments CLI initiated with accountId: {}, page: {}, page-size: {}",
            accountId,
            page,
            pageSize);

        api.setApiClient(clientFactory.create(true, check));
        ApiResponse<ResponseBankingScheduledPaymentsList> response = api.listScheduledPaymentsWithHttpInfo(accountId, page, pageSize);
        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            okhttp3.Call call = api.listScheduledPaymentsCall(accountId, page, pageSize, null);
            String requestUrl = call.request().url().toString();
            List<ConformanceError> conformanceErrors = validateMetadata(requestUrl, response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }
        return JsonPrinter.toJson(response);
    }

    @ShellMethod("List scheduled payments specific accounts")
    public String listScheduledPaymentsSpecificAccounts(@ShellOption(defaultValue = "false") boolean check,
        @ShellOption(defaultValue = ShellOption.NULL) RequestAccountIds accountIds,
        @ShellOption(defaultValue = ShellOption.NULL) Integer page,
        @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("List scheduled payments specific accounts CLI initiated with accountIds: {}, page: {}, page-size: {}",
            accountIds,
            page,
            pageSize);

        api.setApiClient(clientFactory.create(true, check));
        ApiResponse<ResponseBankingScheduledPaymentsList> response = api.listScheduledPaymentsSpecificAccountsWithHttpInfo(accountIds, page, pageSize);
        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            okhttp3.Call call = api.listScheduledPaymentsSpecificAccountsCall(accountIds, page, pageSize, null);
            String requestUrl = call.request().url().toString();
            List<ConformanceError> conformanceErrors = validateMetadata(requestUrl, response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }
        return JsonPrinter.toJson(response);
    }
}