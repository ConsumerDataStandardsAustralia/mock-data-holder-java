package au.org.consumerdatastandards.client.cli.telco;

import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ApiResult;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.telco.TelcoAccountsAPI;
import au.org.consumerdatastandards.client.cli.ApiCliBase;
import au.org.consumerdatastandards.client.cli.support.JsonPrinter;
import au.org.consumerdatastandards.client.model.telco.RequestAccountIds;
import au.org.consumerdatastandards.client.model.telco.RequestAccountIdsData;
import au.org.consumerdatastandards.client.model.telco.TelcoAccountDetailResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoAccountListResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoBalanceListResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoBalanceResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoConcessionsResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoInvoiceListResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoInvoiceResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoPaymentScheduleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.OffsetDateTime;
import java.util.List;

@ShellComponent
@ShellCommandGroup("TelcoAccounts")
public class TelcoAccounts extends ApiCliBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TelcoAccounts.class);

    private final TelcoAccountsAPI api = new TelcoAccountsAPI();

    @ShellMethod("List Telco accounts")
    public String listTelcoAccounts(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) TelcoAccountsAPI.ParamOpenStatusEnum openStatus,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("List Telco accounts CLI initiated with openStatus: {}, page: {}, page-size: {}", openStatus, page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<TelcoAccountListResponse> result = api.listAccounts(openStatus, page, pageSize);
        ApiResponse<TelcoAccountListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get Telco account detail")
    public String getTelcoAccountDetail(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String accountId) throws Exception {

        LOGGER.info("Get Energy account detail CLI initiated with accountId: {}", accountId);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<TelcoAccountDetailResponse> result = api.getAccountDetail(accountId);
        ApiResponse<TelcoAccountDetailResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get Telco agreed payment schedule")
    public String getTelcoPaymentSchedule(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String accountId) throws Exception {

        LOGGER.info("Get Telco agreed payment schedule CLI initiated with accountId: {}", accountId);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<TelcoPaymentScheduleResponse> result = api.getPaymentSchedule(accountId);
        ApiResponse<TelcoPaymentScheduleResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get Telco concessions")
    public String getTelcoConcessions(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String accountId) throws Exception {

        LOGGER.info("Get Telco concessions CLI initiated with accountId: {}", accountId);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<TelcoConcessionsResponse> result = api.getConcessions(accountId);
        ApiResponse<TelcoConcessionsResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get balance for Telco account")
    public String getBalanceForTelcoAccount(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String accountId) throws Exception {

        LOGGER.info("Get balance for Telco account CLI initiated with accountId: {}", accountId);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<TelcoBalanceResponse> result = api.getBalanceForAccount(accountId);
        ApiResponse<TelcoBalanceResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get bulk Telco balances")
    public String listTelcoBalancesBulk(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("Get bulk Telco balances CLI initiated with page: {}, page-size: {}", page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<TelcoBalanceListResponse> result = api.listBalancesBulk(page, pageSize);
        ApiResponse<TelcoBalanceListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get balances for specific Telco accounts")
    public String listBalancesForTelcoAccounts(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) List<String> accountIds,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("Get balances for specific Telco accounts CLI initiated with accountIds: {}, page: {}, page-size: {}",
                accountIds, page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        RequestAccountIds requestAccountIds = new RequestAccountIds();
        RequestAccountIdsData data = new RequestAccountIdsData();
        data.setAccountIds(accountIds);
        requestAccountIds.setData(data);
        ApiResult<TelcoBalanceListResponse> result = api.listBalancesForAccounts(requestAccountIds, page, pageSize);
        ApiResponse<TelcoBalanceListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get invoices for Telco account")
    public String getInvoicesForTelcoAccount(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String accountId,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime oldestDate,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime newestDate,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("Get invoices for Telco account CLI initiated with accountId: {}, oldest-date: {}, newest-date: {}, page: {}, page-size: {}",
                accountId, oldestDate, newestDate, page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<TelcoInvoiceResponse> result = api.getInvoicesForAccount(accountId, oldestDate, newestDate, page, pageSize);
        ApiResponse<TelcoInvoiceResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get bulk Telco invoices")
    public String listTelcoInvoicesBulk(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime oldestDate,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime newestDate,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("Get bulk Telco invoices CLI initiated with oldest-date: {}, newest-date: {}, page: {}, page-size: {}",
                oldestDate, newestDate, page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<TelcoInvoiceListResponse> result = api.listInvoicesBulk(oldestDate, newestDate, page, pageSize);
        ApiResponse<TelcoInvoiceListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get invoices for specific Telco accounts")
    public String listInvoicesForTelcoAccounts(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) List<String> accountIds,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime oldestDate,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime newestDate,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("Get invoices for specific Telco accounts CLI initiated with accountIds: {}, oldest-date: {}, newest-date: {}, page: {}, page-size: {}",
                accountIds, oldestDate, newestDate, page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        RequestAccountIds requestAccountIds = new RequestAccountIds();
        RequestAccountIdsData data = new RequestAccountIdsData();
        data.setAccountIds(accountIds);
        requestAccountIds.setData(data);
        ApiResult<TelcoInvoiceListResponse> result = api.listInvoicesForAccounts(requestAccountIds, oldestDate, newestDate, page, pageSize);
        ApiResponse<TelcoInvoiceListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }
}
