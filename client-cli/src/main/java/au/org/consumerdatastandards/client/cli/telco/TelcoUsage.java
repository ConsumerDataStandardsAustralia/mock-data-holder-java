package au.org.consumerdatastandards.client.cli.telco;

import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ApiResult;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.telco.TelcoUsageAPI;
import au.org.consumerdatastandards.client.cli.ApiCliBase;
import au.org.consumerdatastandards.client.cli.support.JsonPrinter;
import au.org.consumerdatastandards.client.model.telco.RequestServiceIds;
import au.org.consumerdatastandards.client.model.telco.RequestServiceIdsData;
import au.org.consumerdatastandards.client.model.telco.TelcoServiceUsageListResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoServiceUsageResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoUsageListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.OffsetDateTime;
import java.util.List;

@ShellComponent
@ShellCommandGroup("TelcoUsage")
public class TelcoUsage extends ApiCliBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TelcoUsage.class);

    private final TelcoUsageAPI api = new TelcoUsageAPI();

    @ShellMethod("List Telco usage")
    public String listTelcoUsage(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime oldestDate,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime newestDate,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("List Telco usage CLI initiated with oldest-date: {}, newest-date: {}, page: {}, page-size: {}",
                oldestDate, newestDate, page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<TelcoUsageListResponse> result = api.listUsage(oldestDate, newestDate, page, pageSize);
        ApiResponse<TelcoUsageListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get usage for specific Telco service")
    public String listUsageForTelcoService(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) List<String> serviceIds,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime oldestDate,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime newestDate,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("Get usage for specific Telco service CLI initiated with serviceIds: {}, oldest-date: {}, newest-date: {}, page: {}, page-size: {}",
                serviceIds, oldestDate, newestDate, page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        RequestServiceIds requestServiceIds = new RequestServiceIds();
        RequestServiceIdsData data = new RequestServiceIdsData();
        data.setServicePointIds(serviceIds);
        requestServiceIds.setData(data);
        ApiResult<TelcoServiceUsageListResponse> result = api.listUsageForService(requestServiceIds, oldestDate,newestDate, page, pageSize);
        ApiResponse<TelcoServiceUsageListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get usage for Telco service")
    public String getUsageForTelcoService(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String serviceId,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime oldestDate,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime newestDate) throws Exception {

        LOGGER.info("Get usage for Telco service CLI initiated with serviceId: {}, oldest-date: {}, newest-date: {}",
                serviceId, oldestDate, newestDate);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<TelcoServiceUsageResponse> result = api.getUsageForService(serviceId, oldestDate, newestDate);
        ApiResponse<TelcoServiceUsageResponse> response = result.getResponse();

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
