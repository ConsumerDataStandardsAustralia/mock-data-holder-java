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
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointDetailResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyUsageListResponse;
import au.org.consumerdatastandards.holder.model.energy.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.energy.RequestServicePointIds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.math.BigDecimal;
import java.util.UUID;

@Validated
@Controller
@CrossOrigin
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class EnergyApiController extends ApiControllerBase implements EnergyApi {

    private final NativeWebRequest request;

    @Autowired
    public EnergyApiController(NativeWebRequest request) {
        this.request = request;
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
    public ResponseEntity<EnergyBillingListResponse> getBillingForAccount(String accountId, Integer xV, String newestTime, String oldestTime, BigDecimal page, BigDecimal pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyConcessionsResponse> getConcessions(String accountId, Integer xV, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyDerDetailResponse> getDERForServicePoint(String servicePointId, Integer xV, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyInvoiceListResponse> getInvoicesForAccount(String accountId, Integer xV, String newestDate, String oldestDate, BigDecimal page, BigDecimal pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyPaymentScheduleResponse> getPaymentSchedule(String accountId, Integer xV, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyPlanResponse> getPlan(String planId, Integer xV, Integer xMinV, UUID xFapiInteractionId) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyServicePointDetailResponse> getServicePoint(String servicePointId, Integer xV, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyUsageListResponse> getUsageForServicePoint(String servicePointId, Integer xV, String oldestDate, String newestDate, BigDecimal page, BigDecimal pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyAccountListResponse> listAccounts(Integer xV, BigDecimal page, BigDecimal pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyBalanceListResponse> listBalancesBulk(Integer xV, BigDecimal page, BigDecimal pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyBalanceListResponse> listBalancesForAccounts(Integer xV, RequestAccountIds accountIdList, BigDecimal page, BigDecimal pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyBillingListResponse> listBillingBulk(Integer xV, String newestTime, String oldestTime, BigDecimal page, BigDecimal pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyBillingListResponse> listBillingForAccounts(Integer xV, RequestAccountIds accountIdList, String newestTime, String oldestTime, BigDecimal page, BigDecimal pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyDerListResponse> listDERBulk(Integer xV, BigDecimal page, BigDecimal pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyDerListResponse> listDERForServicePoints(Integer xV, RequestServicePointIds servicePointIdList, BigDecimal page, BigDecimal pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyInvoiceListResponse> listInvoicesBulk(Integer xV, String newestDate, String oldestDate, BigDecimal page, BigDecimal pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyInvoiceListResponse> listInvoicesForAccounts(Integer xV, RequestAccountIds accountIdList, String newestDate, String oldestDate, BigDecimal page, BigDecimal pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyPlanListResponse> listPlans(Integer xV, String type, String fuelType, String effective, String updatedSince, String brand, BigDecimal page, BigDecimal pageSize, Integer xMinV, UUID xFapiInteractionId) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyServicePointListResponse> listServicePoints(Integer xV, BigDecimal page, BigDecimal pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyUsageListResponse> listUsageBulk(Integer xV, String oldestDate, String newestDate, BigDecimal page, BigDecimal pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }

    @Override
    public ResponseEntity<EnergyUsageListResponse> listUsageForServicePoints(Integer xV, RequestServicePointIds servicePointIdList, String oldestDate, String newestDate, BigDecimal page, BigDecimal pageSize, Integer xMinV, UUID xFapiInteractionId, String xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        return null;
    }
}
