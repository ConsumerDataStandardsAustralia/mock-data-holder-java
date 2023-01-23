package au.org.consumerdatastandards.client.cli.telco;

import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ApiResult;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.telco.TelcoProductsAPI;
import au.org.consumerdatastandards.client.cli.ApiCliBase;
import au.org.consumerdatastandards.client.cli.support.JsonPrinter;
import au.org.consumerdatastandards.client.model.telco.BillingTypeEnum;
import au.org.consumerdatastandards.client.model.telco.TelcoProductListResponse;
import au.org.consumerdatastandards.client.model.telco.TelcoProductResponse;
import au.org.consumerdatastandards.client.model.telco.TypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.time.OffsetDateTime;
import java.util.List;

@ShellComponent
@ShellCommandGroup("TelcoProducts")
public class TelcoProducts extends ApiCliBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TelcoProducts.class);

    private final TelcoProductsAPI api = new TelcoProductsAPI();

    @ShellMethod("List Telco products")
    public String listTelcoProducts(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) TypeEnum type,
            @ShellOption(defaultValue = ShellOption.NULL) BillingTypeEnum billingType,
            @ShellOption(defaultValue = ShellOption.NULL) String brand,
            @ShellOption(defaultValue = ShellOption.NULL) TelcoProductsAPI.ParamEffective effective,
            @ShellOption(defaultValue = ShellOption.NULL) Integer page,
            @ShellOption(defaultValue = ShellOption.NULL) Integer pageSize,
            @ShellOption(defaultValue = ShellOption.NULL) OffsetDateTime updatedSince) throws Exception {

        LOGGER.info("List Telco Products CLI initiated with type: {}, billingType: {}, brand: {}, effective: {}, page: {}, page-size: {}, updatedSince: {}",
                type, billingType, brand, effective, page, pageSize, updatedSince);

        api.setApiClient(clientFactory.create(false, check));
        ApiResult<TelcoProductListResponse> result = api.listProducts(type, billingType, brand, effective, page, pageSize, updatedSince);
        ApiResponse<TelcoProductListResponse> response = result.getResponse();

        if (clientFactory.isValidationEnabled() || check) {
            LOGGER.info("Payload validation is enabled");
            List<ConformanceError> conformanceErrors = validateMetadata(result.getRequestUrl(), response);
            if (!conformanceErrors.isEmpty()) {
                throwConformanceErrors(conformanceErrors);
            }
        }

        return JsonPrinter.toJson(response);
    }

    @ShellMethod("Get Telco product detail")
    public String getTelcoProductDetail(@ShellOption(defaultValue = "false") boolean check,
            @ShellOption(defaultValue = ShellOption.NULL) String productId) throws Exception {

        LOGGER.info("Get Telco product detail CLI initiated with productId: {}", productId);

        api.setApiClient(clientFactory.create(false, check));
        ApiResult<TelcoProductResponse> result = api.getProductDetail(productId);
        ApiResponse<TelcoProductResponse> response = result.getResponse();

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
