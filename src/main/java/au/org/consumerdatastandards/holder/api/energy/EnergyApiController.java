package au.org.consumerdatastandards.holder.api.energy;

import au.org.consumerdatastandards.holder.api.ApiControllerBase;
import au.org.consumerdatastandards.holder.model.Error;
import au.org.consumerdatastandards.holder.model.Links;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccount;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountDetail;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountDetailResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountListResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyBalanceListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyBalanceListResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyBalanceListResponseDataBalances;
import au.org.consumerdatastandards.holder.model.energy.EnergyBalanceResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyBalanceResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyBillingListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyBillingListResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyBillingTransaction;
import au.org.consumerdatastandards.holder.model.energy.EnergyConcession;
import au.org.consumerdatastandards.holder.model.energy.EnergyConcessionsResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyConcessionsResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyDerDetailResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyDerListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyDerListResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyDerRecord;
import au.org.consumerdatastandards.holder.model.energy.EnergyInvoice;
import au.org.consumerdatastandards.holder.model.energy.EnergyInvoiceListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyInvoiceListResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyPaymentSchedule;
import au.org.consumerdatastandards.holder.model.energy.EnergyPaymentScheduleResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyPaymentScheduleResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanDetail;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanEntity;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanListResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePoint;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointDetail;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointDetailResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointListResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyUsageListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyUsageListResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyUsageRead;
import au.org.consumerdatastandards.holder.model.energy.ParamAccountOpenStatus;
import au.org.consumerdatastandards.holder.model.energy.ParamEffective;
import au.org.consumerdatastandards.holder.model.energy.ParamFuelTypeEnum;
import au.org.consumerdatastandards.holder.model.energy.ParamIntervalReadsEnum;
import au.org.consumerdatastandards.holder.model.energy.ParamTypeEnum;
import au.org.consumerdatastandards.holder.model.energy.RequestAccountIds;
import au.org.consumerdatastandards.holder.model.energy.RequestServicePointIds;
import au.org.consumerdatastandards.holder.service.energy.EnergyService;
import au.org.consumerdatastandards.holder.util.WebUtil;
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

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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
    public ResponseEntity<EnergyAccountDetailResponse> getAccount(String accountId, Integer xV, Integer xMinV, UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV, 4);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        EnergyAccountDetailResponse response = new EnergyAccountDetailResponse();
        EnergyAccountDetail energyAccountDetail = service.getAccountDetail(accountId, supportedVersion);
        if (energyAccountDetail == null) {
            throwInvalidAccount(accountId, xFapiInteractionId);
        }
        response.setData(energyAccountDetail);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    private void throwInvalidAccount(String accountId, UUID xFapiInteractionId) {
        throwCDSErrors(xFapiInteractionId, Collections.singletonList(
                new Error("Invalid Energy Account", "urn:au-cds:error:cds-energy:Authorisation/InvalidEnergyAccount", accountId)), HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<EnergyBalanceResponse> getBalanceForAccount(String accountId, Integer xV, Integer xMinV, UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        if (!service.checkAccountExistence(accountId)) {
            throwInvalidAccount(accountId, xFapiInteractionId);
        }
        EnergyBalanceListResponseDataBalances accountBalance = service.getBalance(accountId);

        logger.info("Returning balance for account: {}", accountId);

        EnergyBalanceResponse response = new EnergyBalanceResponse();
        EnergyBalanceResponseData data = new EnergyBalanceResponseData();
        data.setBalance(accountBalance.getBalance());
        response.setData(data);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyBillingListResponse> getBillingForAccount(String accountId, Integer xV, Integer xMinV,
            OffsetDateTime newestTime, OffsetDateTime oldestTime, Integer page, Integer pageSize, UUID xFapiInteractionId,
            Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 3);
        validateOldestNewestOffsetDateTime(oldestTime, newestTime, xFapiInteractionId);
        validatePageSize(pageSize, xFapiInteractionId);
        if (!service.checkAccountExistence(accountId)) {
            throwInvalidAccount(accountId, xFapiInteractionId);
        }
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyBillingTransaction> transactions = service.findBillingTransactions(Collections.singletonList(accountId), oldestTime, newestTime,
                PageRequest.of(actualPage - 1, actualPageSize), supportedVersion);

        logger.info(
                "Returning billing transactions for account: {}, oldest time: {}, newest time: {} listing page {} of {} (page size of {})",
                accountId, oldestTime, newestTime, actualPage, transactions.getTotalPages(), actualPageSize);

        EnergyBillingListResponse response = new EnergyBillingListResponse();
        EnergyBillingListResponseData data = new EnergyBillingListResponseData();
        data.setTransactions(transactions.getContent());
        response.setData(data);
        response.setLinks(getLinkData(request, transactions, actualPage, actualPageSize));
        response.setMeta(getMetaData(transactions));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyConcessionsResponse> getConcessions(String accountId, Integer xV, Integer xMinV,
            UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        List<EnergyConcession> concessions = service.findConcessions(accountId);
        if (concessions == null) {
            throwInvalidAccount(accountId, xFapiInteractionId);
        }

        logger.info("Returning concessions for account: {}", accountId);

        EnergyConcessionsResponse response = new EnergyConcessionsResponse();
        EnergyConcessionsResponseData data = new EnergyConcessionsResponseData();
        data.setConcessions(concessions);
        response.setData(data);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyDerDetailResponse> getDERForServicePoint(String servicePointId, Integer xV, Integer xMinV,
            UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {

        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        if (!service.checkServicePointExistence(servicePointId)) {
            throwInvalidServicePoint(servicePointId, xFapiInteractionId);
        }
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        EnergyDerRecord data = service.getDERForServicePoint(servicePointId);

        logger.info("Returning DER for service point: {}", servicePointId);

        EnergyDerDetailResponse response = new EnergyDerDetailResponse();
        response.setData(data);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyInvoiceListResponse> getInvoicesForAccount(String accountId, Integer xV, Integer xMinV,
            LocalDate newestDate, LocalDate oldestDate, Integer page, Integer pageSize, UUID xFapiInteractionId,
            Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validateOldestNewestLocalDate(oldestDate, newestDate, xFapiInteractionId);
        validatePageSize(pageSize, xFapiInteractionId);
        if (!service.checkAccountExistence(accountId)) {
            throwInvalidAccount(accountId, xFapiInteractionId);
        }
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyInvoice> invoices = service.findInvoices(Collections.singletonList(accountId), oldestDate, newestDate,
                PageRequest.of(actualPage - 1, actualPageSize));

        logger.info(
                "Returning invoices for account: {}, oldest date: {}, newest date: {} listing page {} of {} (page size of {})",
                accountId, oldestDate, newestDate, actualPage, invoices.getTotalPages(), actualPageSize);

        EnergyInvoiceListResponse response = new EnergyInvoiceListResponse();
        EnergyInvoiceListResponseData data = new EnergyInvoiceListResponseData();
        data.setInvoices(invoices.getContent());
        response.setData(data);
        response.setLinks(getLinkData(request, invoices, actualPage, actualPageSize));
        response.setMeta(getMetaData(invoices));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyPaymentScheduleResponse> getPaymentSchedule(String accountId, Integer xV, Integer xMinV,
            UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        List<EnergyPaymentSchedule> schedules = service.findPaymentSchedules(accountId);
        if (schedules == null) {
            throwInvalidAccount(accountId, xFapiInteractionId);
        }

        logger.info("Returning payment schedules for account: {}", accountId);

        EnergyPaymentScheduleResponse response = new EnergyPaymentScheduleResponse();
        EnergyPaymentScheduleResponseData data = new EnergyPaymentScheduleResponseData();
        data.setPaymentSchedules(schedules);
        response.setData(data);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyPlanResponse> getPlan(String planId, Integer xV, Integer xMinV) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, WebUtil.NO_INTERACTION_ID, 3);
        HttpHeaders headers = generateResponseHeaders(null, supportedVersion);
        EnergyPlanDetail planDetail = service.getPlanDetail(planId, supportedVersion);
        if (planDetail == null) {
            throwInvalidResource(planId);
        }
        EnergyPlanResponse response = new EnergyPlanResponse();
        response.setData(planDetail);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyServicePointDetailResponse> getServicePoint(String servicePointId, Integer xV, Integer xMinV,
            UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV, 1);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        EnergyServicePointDetailResponse response = new EnergyServicePointDetailResponse();
        EnergyServicePointDetail servicePointDetail = service.getServicePoint(servicePointId);
        if (servicePointDetail == null) {
            throwInvalidServicePoint(servicePointId, xFapiInteractionId);
        }

        response.setData(servicePointDetail);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    private void throwInvalidServicePoint(String servicePointId, UUID xFapiInteractionId) {
        throwCDSErrors(xFapiInteractionId, Collections.singletonList(
                new Error("Invalid Service Point", "urn:au-cds:error:cds-energy:Authorisation/InvalidServicePoint", servicePointId)), HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<EnergyUsageListResponse> getUsageForServicePoint(String servicePointId, Integer xV, Integer xMinV,
            LocalDate oldestDate, LocalDate newestDate, ParamIntervalReadsEnum intervalReads, Integer page, Integer pageSize,
            UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {

        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        if (!service.checkServicePointExistence(servicePointId)) {
            throwInvalidServicePoint(servicePointId, xFapiInteractionId);
        }
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyUsageRead> usage = service.findUsageForServicePoints(Collections.singletonList(servicePointId),
                oldestDate, newestDate, intervalReads, PageRequest.of(actualPage - 1, actualPageSize));

        logger.info(
                "Returning usage for service point {} listing page {} of {} (page size of {})",
                servicePointId, actualPage, usage.getTotalPages(), actualPageSize);

        validatePageRange(page, usage.getTotalPages(), xFapiInteractionId);
        EnergyUsageListResponseData data = new EnergyUsageListResponseData();
        data.setReads(usage.getContent());
        EnergyUsageListResponse response = new EnergyUsageListResponse();
        response.setData(data);
        response.setLinks(getLinkData(request, usage, actualPage, actualPageSize));
        response.setMeta(getMetaData(usage));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyAccountListResponse> listAccounts(ParamAccountOpenStatus openStatus, Integer xV, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV, 2);
        validatePageSize(pageSize, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);

        EnergyAccountListResponse response = new EnergyAccountListResponse();
        EnergyAccountListResponseData data = new EnergyAccountListResponseData();

        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);

        PageRequest pageRequest = PageRequest.of(actualPage - 1, actualPageSize, Sort.by(Sort.Direction.DESC, "creationDate"));
        Page<EnergyAccount> energyAccountPage = service.findAccounts(openStatus, pageRequest, supportedVersion);
        validatePageRange(actualPage, energyAccountPage.getTotalPages(), xFapiInteractionId);

        data.setAccounts(energyAccountPage.getContent());
        response.setData(data);
        response.setLinks(getLinkData(request, energyAccountPage, actualPage, actualPageSize));
        response.setMeta(getMetaData(energyAccountPage));
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyBalanceListResponse> listBalancesBulk(Integer xV, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyBalanceListResponseDataBalances> balances = service.findBalances(PageRequest.of(actualPage - 1, actualPageSize));

        logger.info(
                "Returning balances bulk listing page {} of {} (page size of {})",
                actualPage, balances.getTotalPages(), actualPageSize);

        EnergyBalanceListResponse response = new EnergyBalanceListResponse();
        EnergyBalanceListResponseData data = new EnergyBalanceListResponseData();
        data.setBalances(balances.getContent());
        response.setData(data);
        response.setLinks(getLinkData(request, balances, actualPage, actualPageSize));
        response.setMeta(getMetaData(balances));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyBalanceListResponse> listBalancesForAccounts(Integer xV, Integer xMinV, RequestAccountIds accountIdList,
            Integer page, Integer pageSize, UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {

        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        List<String> accountIds = accountIdList.getData().getAccountIds();
        validateAccountIds(accountIds, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyBalanceListResponseDataBalances> balances = service.findBalances(accountIds, PageRequest.of(actualPage - 1, actualPageSize));

        logger.info(
                "Returning balances for accounts: {} listing page {} of {} (page size of {})",
                accountIdList, actualPage, balances.getTotalPages(), actualPageSize);

        EnergyBalanceListResponse response = new EnergyBalanceListResponse();
        EnergyBalanceListResponseData data = new EnergyBalanceListResponseData();
        data.setBalances(balances.getContent());
        response.setData(data);
        response.setLinks(getLinkData(request, balances, actualPage, actualPageSize));
        response.setMeta(getMetaData(balances));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyBillingListResponse> listBillingBulk(Integer xV, Integer xMinV, OffsetDateTime newestTime,
            OffsetDateTime oldestTime, Integer page, Integer pageSize, UUID xFapiInteractionId, Date xFapiAuthDate,
            String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 3);
        validateOldestNewestOffsetDateTime(oldestTime, newestTime, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyBillingTransaction> transactions = service.findBillingTransactions(null, oldestTime, newestTime,
                PageRequest.of(actualPage - 1, actualPageSize), supportedVersion);

        logger.info(
                "Returning billing transactions bulk for oldest time: {}, newest time: {} listing page {} of {} (page size of {})",
                oldestTime, newestTime, actualPage, transactions.getTotalPages(), actualPageSize);

        EnergyBillingListResponse response = new EnergyBillingListResponse();
        EnergyBillingListResponseData data = new EnergyBillingListResponseData();
        data.setTransactions(transactions.getContent());
        response.setData(data);
        response.setLinks(getLinkData(request, transactions, actualPage, actualPageSize));
        response.setMeta(getMetaData(transactions));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyBillingListResponse> listBillingForAccounts(Integer xV, Integer xMinV,
            RequestAccountIds accountIdList, OffsetDateTime newestTime, OffsetDateTime oldestTime, Integer page, Integer pageSize,
            UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders,
            ParamIntervalReadsEnum intervalReads) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 3);
        validateOldestNewestOffsetDateTime(oldestTime, newestTime, xFapiInteractionId);
        validatePageSize(pageSize, xFapiInteractionId);
        List<String> accountIds = accountIdList.getData().getAccountIds();
        validateAccountIds(accountIds, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyBillingTransaction> transactions = service.findBillingTransactions(accountIds, oldestTime, newestTime,
                PageRequest.of(actualPage - 1, actualPageSize), supportedVersion);

        logger.info(
                "Returning billing transactions for accounts: {}, oldest time: {}, newest time: {} listing page {} of {} (page size of {})",
                accountIdList, oldestTime, newestTime, actualPage, transactions.getTotalPages(), actualPageSize);

        EnergyBillingListResponse response = new EnergyBillingListResponse();
        EnergyBillingListResponseData data = new EnergyBillingListResponseData();
        data.setTransactions(transactions.getContent());
        response.setData(data);
        response.setLinks(getLinkData(request, transactions, actualPage, actualPageSize));
        response.setMeta(getMetaData(transactions));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyDerListResponse> listDERBulk(Integer xV, Integer xMinV, Integer page, Integer pageSize,
            UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {

        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyDerRecord> derRecords = service.findAllDER(PageRequest.of(actualPage - 1, actualPageSize));

        logger.info(
                "Returning DER bulk listing page {} of {} (page size of {})",
                actualPage, derRecords.getTotalPages(), actualPageSize);

        validatePageRange(page, derRecords.getTotalPages(), xFapiInteractionId);
        EnergyDerListResponse response = new EnergyDerListResponse();
        EnergyDerListResponseData data = new EnergyDerListResponseData();
        data.setDerRecords(derRecords.getContent());
        response.setData(data);
        response.setLinks(getLinkData(request, derRecords, actualPage, actualPageSize));
        response.setMeta(getMetaData(derRecords));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyDerListResponse> listDERForServicePoints(Integer xV, Integer xMinV,
            RequestServicePointIds servicePointIdList, Integer page, Integer pageSize, UUID xFapiInteractionId,
            Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        List<String> servicePointIds = servicePointIdList.getData().getServicePointIds();
        validateServicePointIds(servicePointIds, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyDerRecord> derRecords = service.findDERForServicePoints(servicePointIds,
                PageRequest.of(actualPage - 1, actualPageSize));

        logger.info(
                "Returning DER for service points: {} listing page {} of {} (page size of {})",
                servicePointIds, actualPage, derRecords.getTotalPages(), actualPageSize);

        validatePageRange(page, derRecords.getTotalPages(), xFapiInteractionId);
        EnergyDerListResponse response = new EnergyDerListResponse();
        EnergyDerListResponseData data = new EnergyDerListResponseData();
        data.setDerRecords(derRecords.getContent());
        response.setData(data);
        response.setLinks(getLinkData(request, derRecords, actualPage, actualPageSize));
        response.setMeta(getMetaData(derRecords));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyInvoiceListResponse> listInvoicesBulk(Integer xV, Integer xMinV, LocalDate newestDate,
            LocalDate oldestDate, Integer page, Integer pageSize, UUID xFapiInteractionId, Date xFapiAuthDate,
            String xFapiCustomerIpAddress, String xCdsClientHeaders) {

        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validateOldestNewestLocalDate(oldestDate, newestDate, xFapiInteractionId);
        validatePageSize(pageSize, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyInvoice> invoices = service.findInvoices(null, oldestDate, newestDate,
                PageRequest.of(actualPage - 1, actualPageSize));

        logger.info(
                "Returning invoices bulk for oldest date: {}, newest date: {} listing page {} of {} (page size of {})",
                oldestDate, newestDate, actualPage, invoices.getTotalPages(), actualPageSize);

        EnergyInvoiceListResponse response = new EnergyInvoiceListResponse();
        EnergyInvoiceListResponseData data = new EnergyInvoiceListResponseData();
        data.setInvoices(invoices.getContent());
        response.setData(data);
        response.setLinks(getLinkData(request, invoices, actualPage, actualPageSize));
        response.setMeta(getMetaData(invoices));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyInvoiceListResponse> listInvoicesForAccounts(Integer xV, Integer xMinV,
            RequestAccountIds accountIdList, LocalDate newestDate, LocalDate oldestDate, Integer page, Integer pageSize,
            UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {

        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validateOldestNewestLocalDate(oldestDate, newestDate, xFapiInteractionId);
        validatePageSize(pageSize, xFapiInteractionId);
        List<String> accountIds = accountIdList.getData().getAccountIds();
        validateAccountIds(accountIds, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyInvoice> invoices = service.findInvoices(accountIds, oldestDate, newestDate,
                PageRequest.of(actualPage - 1, actualPageSize));

        logger.info(
                "Returning invoices for accounts: {}, oldest date: {}, newest date: {} listing page {} of {} (page size of {})",
                accountIdList, oldestDate, newestDate, actualPage, invoices.getTotalPages(), actualPageSize);

        EnergyInvoiceListResponse response = new EnergyInvoiceListResponse();
        EnergyInvoiceListResponseData data = new EnergyInvoiceListResponseData();
        data.setInvoices(invoices.getContent());
        response.setData(data);
        response.setLinks(getLinkData(request, invoices, actualPage, actualPageSize));
        response.setMeta(getMetaData(invoices));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    private void validateAccountIds(List<String> accountIds, UUID interactionId) {
        ArrayList<Error> errorList = new ArrayList<>();
        for (String accountId : accountIds) {
            if (!service.checkAccountExistence(accountId)) {
                errorList.add(new Error("Invalid Energy Account", "urn:au-cds:error:cds-energy:Authorisation/InvalidEnergyAccount", accountId));
            }
        }
        if (!errorList.isEmpty()) {
            throwCDSUnprocessableErrors(interactionId, errorList);
        }
    }

    @Override
    public ResponseEntity<EnergyPlanListResponse> listPlans(Integer xV, Integer xMinV, ParamTypeEnum type,
            ParamFuelTypeEnum fuelType, ParamEffective effective, OffsetDateTime updatedSince, String brand,
            Integer page, Integer pageSize) {

        int supportedVersion = validateSupportedVersion(xMinV, xV, WebUtil.NO_INTERACTION_ID, 1);
        validateUpdatedSince(updatedSince, WebUtil.NO_INTERACTION_ID);
        validatePageSize(pageSize, WebUtil.NO_INTERACTION_ID);
        HttpHeaders headers = generateResponseHeaders(null, supportedVersion);
        EnergyPlanListResponse response = new EnergyPlanListResponse();
        EnergyPlanListResponseData data = new EnergyPlanListResponseData();
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyPlanEntity> plansPage = service.findPlans(type, fuelType, effective, updatedSince, brand, PageRequest.of(actualPage - 1, actualPageSize, Sort.by(Sort.Direction.DESC, "lastUpdated")));

        logger.info(
                "Returning basic plan listing page {} of {} (page size of {}) using filters of type {} effective {}, updated since {}, brand {}, fuel type {}",
                actualPage, plansPage.getTotalPages(), actualPageSize, type, effective, updatedSince, brand, fuelType);

        validatePageRange(page, plansPage.getTotalPages(), WebUtil.NO_INTERACTION_ID);
        data.setPlans(plansPage.getContent());
        response.setData(data);
        response.setLinks(getLinkData(request, plansPage, actualPage, actualPageSize));
        response.setMeta(getMetaData(plansPage));

        logger.debug("Plan listing raw response payload is: {}", data);

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyServicePointListResponse> listServicePoints(Integer xV, Integer xMinV, Integer page,
            Integer pageSize, UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress,
            String xCdsClientHeaders) {

        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        EnergyServicePointListResponse response = new EnergyServicePointListResponse();
        EnergyServicePointListResponseData data = new EnergyServicePointListResponseData();
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyServicePoint> servicePoints = service.findServicePoints(PageRequest.of(actualPage - 1, actualPageSize));

        logger.info(
                "Returning service points listing page {} of {} (page size of {})",
                actualPage, servicePoints.getTotalPages(), actualPageSize);

        validatePageRange(page, servicePoints.getTotalPages(), xFapiInteractionId);
        data.setServicePoints(servicePoints.getContent());
        response.setData(data);
        response.setLinks(getLinkData(request, servicePoints, actualPage, actualPageSize));
        response.setMeta(getMetaData(servicePoints));

        logger.debug("Plan listing raw response payload is: {}", data);

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyUsageListResponse> listUsageBulk(Integer xV, Integer xMinV, LocalDate oldestDate,
            LocalDate newestDate, Integer page, Integer pageSize, UUID xFapiInteractionId, Date xFapiAuthDate,
            String xFapiCustomerIpAddress, String xCdsClientHeaders, ParamIntervalReadsEnum intervalReads) {

        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validateOldestNewestLocalDate(oldestDate, newestDate, xFapiInteractionId);
        validatePageSize(pageSize, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyUsageRead> usage = service.findUsageForServicePoints(null, oldestDate, newestDate,
                intervalReads, PageRequest.of(actualPage - 1, actualPageSize));

        logger.info(
                "Returning usage bulk for oldest date: {}, newest date: {} listing page {} of {} (page size of {})",
                oldestDate, newestDate, actualPage, usage.getTotalPages(), actualPageSize);

        validatePageRange(page, usage.getTotalPages(), xFapiInteractionId);
        EnergyUsageListResponse response = new EnergyUsageListResponse();
        EnergyUsageListResponseData data = new EnergyUsageListResponseData();
        data.setReads(usage.getContent());
        response.setData(data);
        response.setLinks(getLinkData(request, usage, actualPage, actualPageSize));
        response.setMeta(getMetaData(usage));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyUsageListResponse> listUsageForServicePoints(Integer xV, Integer xMinV,
            RequestServicePointIds servicePointIdList, LocalDate oldestDate, LocalDate newestDate, Integer page,
            Integer pageSize,UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress,
            String xCdsClientHeaders, ParamIntervalReadsEnum intervalReads) {

        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validateOldestNewestLocalDate(oldestDate, newestDate, xFapiInteractionId);
        validatePageSize(pageSize, xFapiInteractionId);
        List<String> servicePointIds = servicePointIdList.getData().getServicePointIds();
        validateServicePointIds(servicePointIds, xFapiInteractionId);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyUsageRead> usage = service.findUsageForServicePoints(servicePointIds, oldestDate, newestDate, intervalReads,
                PageRequest.of(actualPage - 1, actualPageSize));

        logger.info(
                "Returning usage for service points: {}, oldest date: {}, newest date: {}, interval reads: {} listing page {} of {} (page size of {})",
                servicePointIds, oldestDate, newestDate, intervalReads, actualPage, usage.getTotalPages(), actualPageSize);

        validatePageRange(page, usage.getTotalPages(), xFapiInteractionId);
        EnergyUsageListResponseData data = new EnergyUsageListResponseData();
        data.setReads(usage.getContent());
        EnergyUsageListResponse response = new EnergyUsageListResponse();
        response.setData(data);
        response.setLinks(getLinkData(request, usage, actualPage, actualPageSize));
        response.setMeta(getMetaData(usage));

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    private void validateServicePointIds(List<String> servicePointIds, UUID interactionId) {
        ArrayList<Error> errorList = new ArrayList<>();
        for (String servicePointId : servicePointIds) {
            if (!service.checkServicePointExistence(servicePointId)) {
                errorList.add(new Error("Invalid Service Point", "urn:au-cds:error:cds-energy:Authorisation/InvalidServicePoint", servicePointId));
            }
        }
        if (!errorList.isEmpty()) {
            throwCDSUnprocessableErrors(interactionId, errorList);
        }
    }
}
