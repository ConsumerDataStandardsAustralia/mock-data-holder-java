package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.CommonPerson;
import au.org.consumerdatastandards.holder.model.CommonPersonDetail;
import au.org.consumerdatastandards.holder.model.CommonPhysicalAddress;
import au.org.consumerdatastandards.holder.model.CommonPhysicalAddressWithPurpose;
import au.org.consumerdatastandards.holder.model.CommonSimpleAddress;
import au.org.consumerdatastandards.holder.model.Links;
import au.org.consumerdatastandards.holder.model.ResponseCommonCustomer;
import au.org.consumerdatastandards.holder.model.ResponseCommonCustomerData;
import au.org.consumerdatastandards.holder.model.ResponseCommonCustomerDetail;
import au.org.consumerdatastandards.holder.model.ResponseCommonCustomerDetailData;
import au.org.consumerdatastandards.holder.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Validated
@Controller
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class CommonCustomerApiController extends ApiControllerBase implements CommonCustomerApi {

    private final NativeWebRequest request;

    @Autowired
    public CommonCustomerApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public ResponseEntity<ResponseCommonCustomer> getCustomer(Jwt jwt,
                                                              String xCdsClientHeaders,
                                                              OffsetDateTime xFapiAuthDate,
                                                              String xFapiCustomerIpAddress,
                                                              UUID xFapiInteractionId,
                                                              Integer xMinV,
                                                              Integer xV) {
        validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xMinV, xV);
        HttpHeaders headers = generateResponseHeaders(request);
        String sub = jwt.getClaim("sub");
        ResponseCommonCustomer responseCommonCustomer = new ResponseCommonCustomer();
        ResponseCommonCustomerData data = new ResponseCommonCustomerData();
        data.setCustomerUType(ResponseCommonCustomerData.CustomerUType.person);
        CommonPerson person = new CommonPerson();
        person.setId(sub);
        person.setFirstName("Alice");
        person.setLastName("Smith");
        person.setMiddleNames(Collections.singletonList(""));
        person.setPrefix("Ms.");
        data.setPerson(person);
        responseCommonCustomer.setData(data);
        responseCommonCustomer.setLinks(new Links());
        responseCommonCustomer.getLinks().setSelf(WebUtil.getOriginalUrl(request));
        logger.debug("Common customer response is: {}", responseCommonCustomer);
        return new ResponseEntity<>(responseCommonCustomer, headers, HttpStatus.OK);
    }

    public ResponseEntity<ResponseCommonCustomerDetail> getCustomerDetail(Jwt jwt,
                                                                          String xCdsClientHeaders,
                                                                          OffsetDateTime xFapiAuthDate,
                                                                          String xFapiCustomerIpAddress,
                                                                          UUID xFapiInteractionId,
                                                                          Integer xMinV,
                                                                          Integer xV) {
        validateHeaders(xCdsClientHeaders, xFapiCustomerIpAddress, xMinV, xV);
        HttpHeaders headers = generateResponseHeaders(request);
        String sub = jwt.getClaim("sub");
        ResponseCommonCustomerDetail responseCommonCustomerDetail = new ResponseCommonCustomerDetail();
        ResponseCommonCustomerDetailData data = new ResponseCommonCustomerDetailData();
        data.setCustomerUType(ResponseCommonCustomerDetailData.CustomerUType.person);
        CommonPersonDetail person = new CommonPersonDetail();
        person.setId(sub);
        person.setFirstName("Alice");
        person.setLastName("Smith");
        person.setMiddleNames(Collections.singletonList(""));
        person.setPrefix("Ms.");
        person.setPhoneNumbers(Collections.emptyList());
        person.setEmailAddresses(Collections.emptyList());
        person.setPhysicalAddresses(Collections.singletonList(new CommonPhysicalAddressWithPurpose()
                .addressUType(CommonPhysicalAddress.AddressUType.simple)
                .simple(new CommonSimpleAddress().addressLine1("1 One St").city("Sydney").state("NSW").postcode("2000"))
                .purpose(CommonPhysicalAddressWithPurpose.Purpose.PHYSICAL)));
        data.setPerson(person);
        responseCommonCustomerDetail.setData(data);
        responseCommonCustomerDetail.setLinks(new Links());
        responseCommonCustomerDetail.getLinks().setSelf(WebUtil.getOriginalUrl(request));
        logger.debug("Common customer detail response is: {}", responseCommonCustomerDetail);
        return new ResponseEntity<>(responseCommonCustomerDetail, headers, HttpStatus.OK);
    }
}
