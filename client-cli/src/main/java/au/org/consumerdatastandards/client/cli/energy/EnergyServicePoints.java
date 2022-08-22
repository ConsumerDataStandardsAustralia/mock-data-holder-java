package au.org.consumerdatastandards.client.cli.energy;

import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ApiResult;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.energy.EnergyServicePointsAPI;
import au.org.consumerdatastandards.client.cli.ApiCliBase;
import au.org.consumerdatastandards.client.cli.support.JsonPrinter;
import au.org.consumerdatastandards.client.model.energy.EnergyDerDetailResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyDerListResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyServicePointDetailResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyServicePointListResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyUsageListResponse;
import au.org.consumerdatastandards.client.model.energy.RequestServicePointIds;
import au.org.consumerdatastandards.client.model.energy.RequestServicePointIdsData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.OffsetDateTime;
import java.util.List;

@ShellComponent
@ShellCommandGroup("EnergyServicePoints")
public class EnergyServicePoints extends ApiCliBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnergyServicePoints.class);

    private final EnergyServicePointsAPI api = new EnergyServicePointsAPI();

    @ShellMethod("List Energy service points")
    public String listServicePoints(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("List Energy service points CLI initiated with page: {}, page-size: {}", page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<EnergyServicePointListResponse> result = api.listServicePoints(page, pageSize);
        ApiResponse<EnergyServicePointListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get service point detail")
    public String getServicePointDetail(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String servicePointId) throws Exception {

        LOGGER.info("Get service point detail CLI initiated with servicePointId: {}", servicePointId);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<EnergyServicePointDetailResponse> result = api.getServicePointDetail(servicePointId);
        ApiResponse<EnergyServicePointDetailResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get usage for service point")
    public String getUsageForServicePoint(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String servicePointId,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime oldestDate,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime newestDate) throws Exception {

        LOGGER.info("Get usage for service point CLI initiated with servicePointId: {}, page: {}, page-size: {}, oldest-date: {}, newest-date: {}",
                servicePointId, page, pageSize, oldestDate, newestDate);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<EnergyUsageListResponse> result = api.getUsageForServicePoint(servicePointId, page, pageSize, oldestDate, newestDate);
        ApiResponse<EnergyUsageListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get bulk usage")
    public String listUsageBulk(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime oldestDate,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime newestDate) throws Exception {

        LOGGER.info("Get bulk usage CLI initiated with page: {}, page-size: {}, oldest-date: {}, newest-date: {}",
                page, pageSize, oldestDate, newestDate);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<EnergyUsageListResponse> result = api.listUsageBulk(page, pageSize, oldestDate, newestDate);
        ApiResponse<EnergyUsageListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get usage for specific service points")
    public String listUsageForServicePoints(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) List<String> servicePointIds,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime oldestDate,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime newestDate) throws Exception {

        LOGGER.info("Get usage for specific service points CLI initiated with servicePointIds: {}, page: {}, page-size: {}, oldest-date: {}, newest-date: {}",
                servicePointIds, page, pageSize, oldestDate, newestDate);

        api.setApiClient(clientFactory.create(true, check));
        RequestServicePointIds requestServicePointIds = new RequestServicePointIds();
        RequestServicePointIdsData data = new RequestServicePointIdsData();
        data.setServicePointIds(servicePointIds);
        requestServicePointIds.setData(data);
        ApiResult<EnergyUsageListResponse> result = api.listUsageForServicePoints(requestServicePointIds, page, pageSize, oldestDate, newestDate);
        ApiResponse<EnergyUsageListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get DER for service point")
    public String listDERForServicePoint(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String servicePointId) throws Exception {

        LOGGER.info("Get DER for service point CLI initiated with servicePointId: {}",
                servicePointId);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<EnergyDerDetailResponse> result = api.listDERForServicePoints(servicePointId);
        ApiResponse<EnergyDerDetailResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get bulk DER")
    public String listDERBulk(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("Get bulk DER CLI initiated with page: {}, page-size: {}", page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        ApiResult<EnergyDerListResponse> result = api.listDERBulk(page, pageSize);
        ApiResponse<EnergyDerListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get DER for specific service points")
    public String listDERForServicePoints(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) List<String> servicePointIds,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize) throws Exception {

        LOGGER.info("Get DER for specific service points CLI initiated with servicePointIds: {}, page: {}, page-size: {}",
                servicePointIds, page, pageSize);

        api.setApiClient(clientFactory.create(true, check));
        RequestServicePointIds requestServicePointIds = new RequestServicePointIds();
        RequestServicePointIdsData data = new RequestServicePointIdsData();
        data.setServicePointIds(servicePointIds);
        requestServicePointIds.setData(data);
        ApiResult<EnergyDerListResponse> result = api.listDERForServicePoints(requestServicePointIds, page, pageSize);
        ApiResponse<EnergyDerListResponse> response = result.getResponse();

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
