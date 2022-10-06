package au.org.consumerdatastandards.client.cli.energy;

import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ApiResult;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.energy.EnergyAccountsAPI;
import au.org.consumerdatastandards.client.cli.ApiCliBase;
import au.org.consumerdatastandards.client.cli.support.JsonPrinter;
import au.org.consumerdatastandards.client.model.energy.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.OffsetDateTime;
import java.util.List;

@ShellComponent
@ShellCommandGroup("EnergyAccounts")
public class EnergyAccounts extends ApiCliBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnergyAccounts.class);

    private final EnergyAccountsAPI api = new EnergyAccountsAPI();

    @ShellMethod("List Energy accounts")
    public String listEnergyAccounts(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) ParamAccountOpenStatus openStatus,
            @ShellOption(defaultValue = "1") Integer version,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("List Energy accounts CLI initiated with page: {}, page-size: {}", page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<EnergyAccountListResponse<EnergyAccountV1>> result = api.listEnergyAccounts(openStatus, version, page, pageSize);
        ApiResponse<EnergyAccountListResponse<EnergyAccountV1>> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get Energy account detail")
    public String getEnergyAccountDetail(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String accountId,
            @ShellOption(defaultValue = "1") Integer version) throws Exception {

        LOGGER.info("Get Energy account detail CLI initiated with accountId: {}", accountId);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<EnergyAccountDetailResponse<EnergyAccountBase>> result = api.getEnergyAccountDetail(accountId, version);
        ApiResponse<EnergyAccountDetailResponse<EnergyAccountBase>> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get agreed payment schedule")
    public String getPaymentSchedule(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String accountId) throws Exception {

        LOGGER.info("Get agreed payment schedule CLI initiated with accountId: {}", accountId);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<EnergyPaymentScheduleResponse> result = api.getPaymentSchedule(accountId);
        ApiResponse<EnergyPaymentScheduleResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get concessions")
    public String getConcessions(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String accountId) throws Exception {

        LOGGER.info("Get concessions CLI initiated with accountId: {}", accountId);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<EnergyConcessionsResponse> result = api.getConcessions(accountId);
        ApiResponse<EnergyConcessionsResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get balance for Energy account")
    public String getBalanceForAccount(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String accountId) throws Exception {

        LOGGER.info("Get balance for Energy account CLI initiated with accountId: {}", accountId);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<EnergyBalanceResponse> result = api.getBalanceForAccount(accountId);
        ApiResponse<EnergyBalanceResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get bulk balances for Energy")
    public String listEnergyBalancesBulk(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("Get bulk balances for Energy CLI initiated with page: {}, page-size: {}", page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<EnergyBalanceListResponse> result = api.listBalancesBulk(page, pageSize);
        ApiResponse<EnergyBalanceListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get balances for specific Energy accounts")
    public String listBalancesForAccounts(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) List<String> accountIds,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("Get balances for specific Energy accounts CLI initiated with accountIds: {}, page: {}, page-size: {}",
                accountIds, page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        RequestAccountIds requestAccountIds = new RequestAccountIds();
        RequestAccountIdsData data = new RequestAccountIdsData();
        data.setAccountIds(accountIds);
        requestAccountIds.setData(data);
        ApiResult<EnergyBalanceListResponse> result = api.listBalancesForAccounts(requestAccountIds, page, pageSize);
        ApiResponse<EnergyBalanceListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get invoices for account")
    public String getInvoicesForAccount(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String accountId,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime oldestDate,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime newestDate,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("Get invoices for account CLI initiated with accountId: {}, oldest-date: {}, newest-date: {}, page: {}, page-size: {}",
                accountId, oldestDate, newestDate, page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<EnergyInvoiceListResponse> result = api.getInvoicesForAccount(accountId, oldestDate, newestDate, page, pageSize);
        ApiResponse<EnergyInvoiceListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get bulk invoices")
    public String listInvoicesBulk(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime oldestDate,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime newestDate,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("Get bulk invoices CLI initiated with oldest-date: {}, newest-date: {}, page: {}, page-size: {}",
                oldestDate, newestDate, page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<EnergyInvoiceListResponse> result = api.listInvoicesBulk(oldestDate, newestDate, page, pageSize);
        ApiResponse<EnergyInvoiceListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get invoices for specific accounts")
    public String listInvoicesForAccounts(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) List<String> accountIds,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime oldestDate,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime newestDate,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("Get invoices for specific accounts CLI initiated with accountIds: {}, oldest-date: {}, newest-date: {}, page: {}, page-size: {}",
                accountIds, oldestDate, newestDate, page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        RequestAccountIds requestAccountIds = new RequestAccountIds();
        RequestAccountIdsData data = new RequestAccountIdsData();
        data.setAccountIds(accountIds);
        requestAccountIds.setData(data);
        ApiResult<EnergyInvoiceListResponse> result = api.listInvoicesForAccounts(requestAccountIds, oldestDate, newestDate, page, pageSize);
        ApiResponse<EnergyInvoiceListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get billing for account")
    public String getBillingForAccount(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String accountId,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime oldestTime,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime newestTime,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("Get billing for account CLI initiated with accountId: {}, oldest-time: {}, newest-time: {}, page: {}, page-size: {}",
                accountId, oldestTime, newestTime, page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<EnergyBillingListResponse> result = api.getBillingForAccount(accountId, oldestTime, newestTime, page, pageSize);
        ApiResponse<EnergyBillingListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get bulk billing")
    public String listBillingBulk(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime oldestTime,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime newestTime,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("Get bulk billing CLI initiated with oldest-time: {}, newest-time: {}, page: {}, page-size: {}",
                oldestTime, newestTime, page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<EnergyBillingListResponse> result = api.listBillingBulk(oldestTime, newestTime, page, pageSize);
        ApiResponse<EnergyBillingListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get billing for specific accounts")
    public String listBillingForAccounts(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) List<String> accountIds,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime oldestTime,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime newestTime,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize,
            @ShellOption(defaultValue = ShellOption.NULL) ParamIntervalReadsEnum intervalReads) throws Exception {

        LOGGER.info("Get billing for specific accounts CLI initiated with accountIds: {}, oldest-time: {}, newest-time: {}, page: {}, page-size: {}, interval-reads: {}",
                accountIds, oldestTime, newestTime, page, pageSize, intervalReads);

        api.setApiClient(clientFactory.create(true, check));
        RequestAccountIds requestAccountIds = new RequestAccountIds();
        RequestAccountIdsData data = new RequestAccountIdsData();
        data.setAccountIds(accountIds);
        requestAccountIds.setData(data);
        ApiResult<EnergyBillingListResponse> result = api.listBillingForAccounts(requestAccountIds, oldestTime, newestTime, page, pageSize, intervalReads);
        ApiResponse<EnergyBillingListResponse> response = result.getResponse();

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
