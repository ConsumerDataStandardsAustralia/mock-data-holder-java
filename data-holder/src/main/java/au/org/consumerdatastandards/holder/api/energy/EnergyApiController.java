package au.org.consumerdatastandards.holder.api.energy;

import au.org.consumerdatastandards.holder.api.ApiControllerBase;
import au.org.consumerdatastandards.holder.model.CommonPhysicalAddress;
import au.org.consumerdatastandards.holder.model.CommonSimpleAddress;
import au.org.consumerdatastandards.holder.model.Links;
import au.org.consumerdatastandards.holder.model.LinksPaginated;
import au.org.consumerdatastandards.holder.model.MetaPaginated;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccount;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountBase;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountDetail;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountDetailResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountListResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyBalanceListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyBalanceListResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyBalanceResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyBalanceResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyBillingListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyBillingListResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyConcessionsResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyConcessionsResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyDerDetailResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyDerListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyDerListResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyDerRecord;
import au.org.consumerdatastandards.holder.model.energy.EnergyInvoiceListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyInvoiceListResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyPaymentSchedule;
import au.org.consumerdatastandards.holder.model.energy.EnergyPaymentScheduleCardDebit;
import au.org.consumerdatastandards.holder.model.energy.EnergyPaymentScheduleResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyPaymentScheduleResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanDetailEntity;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanEntity;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanListResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePoint;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointConsumerProfile;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointDetail;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointDetailDistributionLossFactor;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointDetailRelatedParticipants;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointDetailResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointListResponseData;
import au.org.consumerdatastandards.holder.model.energy.EnergyUsageListResponse;
import au.org.consumerdatastandards.holder.model.energy.EnergyUsageListResponseData;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Date;
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
        int supportedVersion = validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV, 1);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        EnergyAccountDetailResponse response = new EnergyAccountDetailResponse();
        EnergyAccountDetail data = new EnergyAccountDetail();
        populateAccount(data);
        response.setData(data);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyBalanceResponse> getBalanceForAccount(String accountId, Integer xV, Integer xMinV, UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        EnergyBalanceResponse response = new EnergyBalanceResponse();
        EnergyBalanceResponseData data = new EnergyBalanceResponseData();
        data.setBalance("12.34");
        response.setData(data);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyBillingListResponse> getBillingForAccount(String accountId, Integer xV, Integer xMinV,
            String newestTime, String oldestTime, Integer page, Integer pageSize, UUID xFapiInteractionId,
            Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        EnergyBillingListResponse response = new EnergyBillingListResponse();
        EnergyBillingListResponseData data = new EnergyBillingListResponseData();
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        response.setMeta(createSinglePageMeta());
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyConcessionsResponse> getConcessions(String accountId, Integer xV, Integer xMinV,
            UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        EnergyConcessionsResponse response = new EnergyConcessionsResponse();
        EnergyConcessionsResponseData data = new EnergyConcessionsResponseData();
        response.setData(data);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyDerDetailResponse> getDERForServicePoint(String servicePointId, Integer xV, Integer xMinV,
            UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        EnergyDerDetailResponse response = new EnergyDerDetailResponse();
        EnergyDerRecord data = new EnergyDerRecord();
        data.setServicePointId("servicePointId");
        data.setApprovedCapacity(BigDecimal.TEN);
        data.setInstalledPhasesCount(3);
        data.setAvailablePhasesCount(3);
        data.setIslandableInstallation(true);
        response.setData(data);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyInvoiceListResponse> getInvoicesForAccount(String accountId, Integer xV, Integer xMinV,
            String newestDate, String oldestDate, Integer page, Integer pageSize, UUID xFapiInteractionId,
            Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        EnergyInvoiceListResponse response = new EnergyInvoiceListResponse();
        EnergyInvoiceListResponseData data = new EnergyInvoiceListResponseData();
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        response.setMeta(createSinglePageMeta());
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyPaymentScheduleResponse> getPaymentSchedule(String accountId, Integer xV, Integer xMinV,
            UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        EnergyPaymentScheduleResponse response = new EnergyPaymentScheduleResponse();
        EnergyPaymentSchedule schedule = new EnergyPaymentSchedule();
        schedule.setAmount("12.34");
        schedule.setPaymentScheduleUType(EnergyPaymentSchedule.PaymentScheduleUTypeEnum.CARDDEBIT);
        EnergyPaymentScheduleCardDebit cardDebit = new EnergyPaymentScheduleCardDebit();
        cardDebit.setCardScheme(EnergyPaymentScheduleCardDebit.CardSchemeEnum.MASTERCARD);
        cardDebit.setPaymentFrequency("P1M");
        cardDebit.setCalculationType(EnergyPaymentScheduleCardDebit.CalculationTypeEnum.BALANCE);
        schedule.setCardDebit(cardDebit);
        EnergyPaymentScheduleResponseData data = new EnergyPaymentScheduleResponseData();
        data.setPaymentSchedules(Collections.singletonList(schedule));
        response.setData(data);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyPlanResponse> getPlan(String planId, Integer xV, Integer xMinV) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, NO_INTERACTION_ID, 1);
        HttpHeaders headers = generateResponseHeaders(null, supportedVersion);
        EnergyPlanResponse response = new EnergyPlanResponse();
        EnergyPlanDetailEntity planDetail = service.getPlanDetail(planId);
        if (planDetail == null) {
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }
        response.setData(planDetail);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyServicePointDetailResponse> getServicePoint(String servicePointId, Integer xV, Integer xMinV,
            UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        EnergyServicePointDetailResponse response = new EnergyServicePointDetailResponse();
        EnergyServicePointDetail servicePoint = new EnergyServicePointDetail();
        servicePoint.setServicePointId("SP12345");
        servicePoint.setServicePointStatus(EnergyServicePointDetail.ServicePointStatusEnum.ACTIVE);
        servicePoint.setServicePointClassification(EnergyServicePointDetail.ServicePointClassificationEnum.WHOLESALE);
        EnergyServicePointConsumerProfile consumerProfile = new EnergyServicePointConsumerProfile();
        consumerProfile.setClassification(EnergyServicePointConsumerProfile.ClassificationEnum.RESIDENTIAL);
        servicePoint.setConsumerProfile(consumerProfile);
        servicePoint.setJurisdictionCode(EnergyServicePointDetail.JurisdictionCodeEnum.NSW);
        servicePoint.setNationalMeteringId("NMI12345");
        servicePoint.setValidFromDate(LocalDate.now());
        servicePoint.setLastUpdateDateTime(OffsetDateTime.now());
        EnergyServicePointDetailDistributionLossFactor dlf = new EnergyServicePointDetailDistributionLossFactor();
        dlf.setCode("AEMO_CODE");
        dlf.setDescription("Distribution Loss Factor description");
        dlf.setLossValue("LossValue123");
        servicePoint.setDistributionLossFactor(dlf);
        EnergyServicePointDetailRelatedParticipants relatedParticipants = new EnergyServicePointDetailRelatedParticipants();
        relatedParticipants.setParty("Party/Organisation Name");
        relatedParticipants.setRole(EnergyServicePointDetailRelatedParticipants.RoleEnum.LNSP);
        servicePoint.setRelatedParticipants(Collections.singletonList(relatedParticipants));
        CommonPhysicalAddress location = new CommonPhysicalAddress();
        location.setAddressUType(CommonPhysicalAddress.AddressUType.simple);
        CommonSimpleAddress sa = new CommonSimpleAddress();
        sa.setAddressLine1("1 One St");
        sa.setCity("Sydney");
        sa.setState("NSW");
        sa.setPostcode("2000");
        location.setSimple(sa);
        servicePoint.setLocation(location);
        response.setData(servicePoint);
        response.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyUsageListResponse> getUsageForServicePoint(String servicePointId, Integer xV, Integer xMinV,
            String oldestDate, String newestDate, ParamIntervalReadsEnum intervalReads, Integer page, Integer pageSize,
            UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        EnergyUsageListResponse response = new EnergyUsageListResponse();
        EnergyUsageListResponseData data = new EnergyUsageListResponseData();
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        response.setMeta(createSinglePageMeta());
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyAccountListResponse> listAccounts(Integer xV, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xFapiInteractionId, xMinV, xV, 1);
        HttpHeaders headers = generateResponseHeaders(xFapiInteractionId, supportedVersion);
        EnergyAccountListResponse response = new EnergyAccountListResponse();
        EnergyAccountListResponseData data = new EnergyAccountListResponseData();
        EnergyAccount account = new EnergyAccount();
        populateAccount(account);
        data.setAccounts(Collections.singletonList(account));
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        response.setMeta(createSinglePageMeta());
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    private LinksPaginated createSinglePageLinksPaginated(Integer pageSize) {
        LinksPaginated linkData = new LinksPaginated();
        linkData.setSelf(WebUtil.getOriginalUrl(request));
        Integer actualPageSize = getPagingValue(pageSize, 25);
        linkData.setFirst(WebUtil.getPaginatedLink(request, 1, actualPageSize));
        linkData.setLast(WebUtil.getPaginatedLink(request, 1, actualPageSize));
        return linkData;
    }

    private MetaPaginated createSinglePageMeta() {
        MetaPaginated metaData = new MetaPaginated();
        metaData.setTotalPages(1);
        metaData.setTotalRecords(1);
        return metaData;
    }

    private void populateAccount(EnergyAccountBase account) {
        account.setAccountId("ACC12345");
        account.setAccountNumber("12345");
        account.setCreationDate(LocalDate.now());
        account.setDisplayName("The Account");
    }

    @Override
    public ResponseEntity<EnergyBalanceListResponse> listBalancesBulk(Integer xV, Integer page, Integer pageSize, Integer xMinV, UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        EnergyBalanceListResponse response = new EnergyBalanceListResponse();
        EnergyBalanceListResponseData data = new EnergyBalanceListResponseData();
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        response.setMeta(createSinglePageMeta());
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyBalanceListResponse> listBalancesForAccounts(Integer xV, Integer xMinV, RequestAccountIds accountIdList,
            Integer page, Integer pageSize, UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        EnergyBalanceListResponse response = new EnergyBalanceListResponse();
        EnergyBalanceListResponseData data = new EnergyBalanceListResponseData();
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        response.setMeta(createSinglePageMeta());
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyBillingListResponse> listBillingBulk(Integer xV, Integer xMinV, String newestTime,
            String oldestTime, Integer page, Integer pageSize, UUID xFapiInteractionId, Date xFapiAuthDate,
            String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        EnergyBillingListResponse response = new EnergyBillingListResponse();
        EnergyBillingListResponseData data = new EnergyBillingListResponseData();
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        response.setMeta(createSinglePageMeta());
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyBillingListResponse> listBillingForAccounts(Integer xV, Integer xMinV,
            RequestAccountIds accountIdList, String newestTime, String oldestTime, Integer page, Integer pageSize,
            UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders,
            ParamIntervalReadsEnum intervalReads) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        EnergyBillingListResponse response = new EnergyBillingListResponse();
        EnergyBillingListResponseData data = new EnergyBillingListResponseData();
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        response.setMeta(createSinglePageMeta());
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyDerListResponse> listDERBulk(Integer xV, Integer xMinV, Integer page, Integer pageSize,
            UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        EnergyDerListResponse response = new EnergyDerListResponse();
        EnergyDerListResponseData data = new EnergyDerListResponseData();
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        response.setMeta(createSinglePageMeta());
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyDerListResponse> listDERForServicePoints(Integer xV, Integer xMinV,
            RequestServicePointIds servicePointIdList, Integer page, Integer pageSize, UUID xFapiInteractionId,
            Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        EnergyDerListResponse response = new EnergyDerListResponse();
        EnergyDerListResponseData data = new EnergyDerListResponseData();
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        response.setMeta(createSinglePageMeta());
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyInvoiceListResponse> listInvoicesBulk(Integer xV, Integer xMinV, String newestDate,
            String oldestDate, Integer page, Integer pageSize, UUID xFapiInteractionId, Date xFapiAuthDate,
            String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        EnergyInvoiceListResponse response = new EnergyInvoiceListResponse();
        EnergyInvoiceListResponseData data = new EnergyInvoiceListResponseData();
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        response.setMeta(createSinglePageMeta());
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyInvoiceListResponse> listInvoicesForAccounts(Integer xV, Integer xMinV,
            RequestAccountIds accountIdList, String newestDate, String oldestDate, Integer page, Integer pageSize,
            UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress, String xCdsClientHeaders) {
        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        EnergyInvoiceListResponse response = new EnergyInvoiceListResponse();
        EnergyInvoiceListResponseData data = new EnergyInvoiceListResponseData();
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        response.setMeta(createSinglePageMeta());
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyPlanListResponse> listPlans(Integer xV, Integer xMinV, ParamTypeEnum type,
            ParamFuelTypeEnum fuelType, ParamEffective effective, OffsetDateTime updatedSince, String brand,
            Integer page, Integer pageSize) {

        int supportedVersion = validateSupportedVersion(xMinV, xV, NO_INTERACTION_ID, 1);
        validatePageSize(pageSize, NO_INTERACTION_ID);
        HttpHeaders headers = generateResponseHeaders(null, supportedVersion);
        EnergyPlanListResponse response = new EnergyPlanListResponse();
        EnergyPlanListResponseData data = new EnergyPlanListResponseData();
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<EnergyPlanEntity> plansPage = service.findPlans(type, fuelType, effective, updatedSince, brand, PageRequest.of(actualPage - 1, actualPageSize, Sort.by(Sort.Direction.DESC, "lastUpdated")));

        logger.info(
                "Returning basic plan listing page {} of {} (page size of {}) using filters of type {} effective {}, updated since {}, brand {}, fuel type {}",
                actualPage, plansPage.getTotalPages(), actualPageSize, type, effective, updatedSince, brand, fuelType);

        validatePageRange(page, plansPage.getTotalPages(), NO_INTERACTION_ID);
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
        EnergyServicePointListResponse response = new EnergyServicePointListResponse();
        EnergyServicePointListResponseData data = new EnergyServicePointListResponseData();
        EnergyServicePoint servicePoint = new EnergyServicePoint();
        servicePoint.setServicePointId("SP12345");
        servicePoint.setServicePointStatus(EnergyServicePoint.ServicePointStatusEnum.ACTIVE);
        servicePoint.setServicePointClassification(EnergyServicePoint.ServicePointClassificationEnum.WHOLESALE);
        EnergyServicePointConsumerProfile consumerProfile = new EnergyServicePointConsumerProfile();
        consumerProfile.setClassification(EnergyServicePointConsumerProfile.ClassificationEnum.RESIDENTIAL);
        servicePoint.setConsumerProfile(consumerProfile);
        servicePoint.setJurisdictionCode(EnergyServicePoint.JurisdictionCodeEnum.NSW);
        servicePoint.setNationalMeteringId("NMI12345");
        servicePoint.setValidFromDate(LocalDate.now());
        servicePoint.setLastUpdateDateTime(OffsetDateTime.now());
        data.setServicePoints(Collections.singletonList(servicePoint));
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        response.setMeta(createSinglePageMeta());

        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyUsageListResponse> listUsageBulk(Integer xV, Integer xMinV, String oldestDate,
            String newestDate, Integer page, Integer pageSize, UUID xFapiInteractionId, Date xFapiAuthDate,
            String xFapiCustomerIpAddress, String xCdsClientHeaders, ParamIntervalReadsEnum intervalReads) {

        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        EnergyUsageListResponse response = new EnergyUsageListResponse();
        EnergyUsageListResponseData data = new EnergyUsageListResponseData();
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        response.setMeta(createSinglePageMeta());
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EnergyUsageListResponse> listUsageForServicePoints(Integer xV, Integer xMinV,
            RequestServicePointIds servicePointIdList, String oldestDate, String newestDate, Integer page,
            Integer pageSize,UUID xFapiInteractionId, Date xFapiAuthDate, String xFapiCustomerIpAddress,
            String xCdsClientHeaders, ParamIntervalReadsEnum intervalReads) {

        int supportedVersion = validateSupportedVersion(xMinV, xV, xFapiInteractionId, 1);
        validatePageSize(pageSize, xFapiInteractionId);
        EnergyUsageListResponse response = new EnergyUsageListResponse();
        EnergyUsageListResponseData data = new EnergyUsageListResponseData();
        response.setData(data);
        response.setLinks(createSinglePageLinksPaginated(pageSize));
        response.setMeta(createSinglePageMeta());
        return new ResponseEntity<>(response, generateResponseHeaders(xFapiInteractionId, supportedVersion), HttpStatus.OK);
    }
}
