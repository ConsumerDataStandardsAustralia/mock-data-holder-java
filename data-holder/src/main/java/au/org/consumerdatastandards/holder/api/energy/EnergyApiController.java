package au.org.consumerdatastandards.holder.api.energy;

import au.org.consumerdatastandards.holder.api.ApiControllerBase;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountDetailResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyBalanceListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyBalanceResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyBillingListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyConcessionsResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyDerDetailResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyDerListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyInvoiceListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyPaymentScheduleResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlan;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanListResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointDetailResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyUsageListResponse;
import au.org.consumerdatastandards.holder.model.energy.ParamEffective;
import au.org.consumerdatastandards.holder.model.energy.ParamFuelTypeEnum;
import au.org.consumerdatastandards.holder.model.energy.ParamTypeEnum;
import au.org.consumerdatastandards.holder.model.energy.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.energy.RequestServicePointIds;
import au.org.consumerdatastandards.holder.service.energy.EnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.UUID;

@Validated
@Controller
@CrossOrigin
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class EnergyApiController extends ApiControllerBase implements EnergyApi {

    private final NativeWebRequest request;
    private final EnergyService service;

    @Autowired
    public EnergyApiController(NativeWebRequest request, EnergyService service) {
        this.request = request;
        this.service = service;
    }
    @Override
    public ResponseEntity<EnergyAccountDetailResponse> getAccount(String accountId, Integer xV, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV);
        HttpHeaders headers = generateResponseHeaders(request);
        return null;
    }

    @Override
    public ResponseEntity<EnergyBalanceResponse> getBalanceForAccount(String accountId, Integer xV, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyBillingListResponse> getBillingForAccount(String accountId, Integer xV, Integer xMinV,
            String newestTime, String oldestTime, Integer page, Integer pageSize, UUID xFapiInteractionId,
            String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyConcessionsResponse> getConcessions(String accountId, Integer xV, Integer xMinV,
            UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyDerDetailResponse> getDERForServicePoint(String servicePointId, Integer xV, Integer xMinV,
            UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyInvoiceListResponse> getInvoicesForAccount(String accountId, Integer xV, Integer xMinV,
            String newestDate, String oldestDate, Integer page, Integer pageSize, UUID xFapiInteractionId,
            String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyPaymentScheduleResponse> getPaymentSchedule(String accountId, Integer xV, Integer xMinV,
            UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyPlanResponse> getPlan(String planId, Integer xV, Integer xMinV, UUID xFapiInteractionId) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyServicePointDetailResponse> getServicePoint(String servicePointId, Integer xV, Integer xMinV,
            UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyUsageListResponse> getUsageForServicePoint(String servicePointId, Integer xV, Integer xMinV,
            String oldestDate, String newestDate, Integer page, Integer pageSize, UUID xFapiInteractionId,
            String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyAccountListResponse> listAccounts(Integer xV, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyBalanceListResponse> listBalancesBulk(Integer xV, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyBalanceListResponse> listBalancesForAccounts(Integer xV, Integer xMinV, RequestAccountIds accountIdList,
            Integer page, Integer pageSize, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyBillingListResponse> listBillingBulk(Integer xV, Integer xMinV, String newestTime,
            String oldestTime, Integer page, Integer pageSize, UUID xFapiInteractionId, String xFapiAuthDate,
            String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyBillingListResponse> listBillingForAccounts(Integer xV, Integer xMinV,
            RequestAccountIds accountIdList, String newestTime, String oldestTime, Integer page, Integer pageSize,
            UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyDerListResponse> listDERBulk(Integer xV, Integer xMinV, Integer page, Integer pageSize,
            UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyDerListResponse> listDERForServicePoints(Integer xV, Integer xMinV,
            RequestServicePointIds servicePointIdList, Integer page, Integer pageSize, UUID xFapiInteractionId,
            String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyInvoiceListResponse> listInvoicesBulk(Integer xV, Integer xMinV, String newestDate,
            String oldestDate, Integer page, Integer pageSize, UUID xFapiInteractionId, String xFapiAuthDate,
            String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyInvoiceListResponse> listInvoicesForAccounts(Integer xV, Integer xMinV,
            RequestAccountIds accountIdList, String newestDate, String oldestDate, Integer page, Integer pageSize,
            UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyPlanListResponse> listPlans(Integer xV, Integer xMinV, ParamTypeEnum type,
            ParamFuelTypeEnum fuelType, ParamEffective effective, OffsetDateTime updatedSince, String brand,
            Integer page, Integer pageSize, UUID xFapiInteractionId) {

        validateSupportedVersion(xMinV, xV, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(request);
        EnergyPlanListResponse response = new EnergyPlanListResponse();
        EnergyPlanListResponseData data = new EnergyPlanListResponseData();
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyPlan> plansPage = service.findPlans(type, fuelType, effective, updatedSince, brand, PageRequest.of(actualPage - 1, actualPageSize, Sort.by(Sort.Direction.DESC, "lastUpdated")));

        logger.info(
                "Returning basic plan listing page {} of {} (page size of {}) using filters of type {} effective {}, updated since {}, brand {}, fuel type {}",
                actualPage, plansPage.getTotalPages(), actualPageSize, type, effective, updatedSince, brand, fuelType);

        validatePageRange(page, plansPage.getTotalPages(), xFapiInteractionId);
        data.setPlans(plansPage.getContent());
        response.setData(data);
        response.setLinks(getLinkData(request, plansPage, actualPage, actualPageSize));
        response.setMeta(getMetaData(plansPage));

        logger.debug("Plan listing raw response payload is: {}", data);

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyServicePointListResponse> listServicePoints(Integer xV, Integer xMinV, Integer page,
            Integer pageSize, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress,
            String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyUsageListResponse> listUsageBulk(Integer xV, Integer xMinV, String oldestDate,
            String newestDate, Integer page, Integer pageSize, UUID xFapiInteractionId, String xFapiAuthDate,
            String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyUsageListResponse> listUsageForServicePoints(Integer xV, Integer xMinV,
            RequestServicePointIds servicePointIdList, String oldestDate, String newestDate, Integer page,
            Integer pageSize,UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress,
            String xCdsClientHeaders) {
        return null;
    }
}
