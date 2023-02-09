package au.org.consumerdatastandards.client.cli.energy;

import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ApiResult;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.energy.EnergyPlansAPI;
import au.org.consumerdatastandards.client.cli.ApiCliBase;
import au.org.consumerdatastandards.client.cli.support.JsonPrinter;
import au.org.consumerdatastandards.client.model.energy.EnergyPlanListResponse;
import au.org.consumerdatastandards.client.model.energy.EnergyPlanResponse;
import au.org.consumerdatastandards.client.model.energy.ParamEffective;
import au.org.consumerdatastandards.client.model.energy.ParamFuelTypeEnum;
import au.org.consumerdatastandards.client.model.energy.ParamTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.OffsetDateTime;
import java.util.List;

@ShellComponent
@ShellCommandGroup("EnergyPlans")
public class EnergyPlans extends ApiCliBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnergyPlans.class);

    private final EnergyPlansAPI api = new EnergyPlansAPI();

    @ShellMethod("List generic Energy plans")
    public String listGenericEnergyPlans(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) ParamTypeEnum type,
            @ShellOption(defaultValue = ShellOption.NULL) ParamFuelTypeEnum fuelType,
            @ShellOption(defaultValue = ShellOption.NULL) String brand,
            @ShellOption(defaultValue = ShellOption.NULL) ParamEffective effective,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime updatedSince) throws Exception {

        LOGGER.info("List generic Energy plans CLI initiated with type: {}, fuelType: {}, brand: {}, effective: {}, page: {}, page-size: {}, updatedSince: {}",
                type, fuelType, brand, effective, page, pageSize, updatedSince);

        api.setApiClient(clientFactory.create(false, check));
        ApiResult<EnergyPlanListResponse> result = api.listEnergyPlans(type, fuelType, brand, effective, page, pageSize, updatedSince);
        ApiResponse<EnergyPlanListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get generic Energy plan detail")
    public String getGenericEnergyPlanDetail(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String planId) throws Exception {

        LOGGER.info("Get generic Energy plan detail CLI initiated with planId: {}", planId);

        api.setApiClient(clientFactory.create(false, check));
        ApiResult<EnergyPlanResponse> result = api.getGenericPlanDetail(planId);
        ApiResponse<EnergyPlanResponse> response = result.getResponse();

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
