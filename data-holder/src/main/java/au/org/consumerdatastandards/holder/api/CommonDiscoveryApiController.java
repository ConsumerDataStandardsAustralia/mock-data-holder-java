package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.DiscoveryOutage;
import au.org.consumerdatastandards.holder.model.Links;
import au.org.consumerdatastandards.holder.model.ResponseCommonDiscoveryStatus;
import au.org.consumerdatastandards.holder.model.ResponseCommonDiscoveryStatusData;
import au.org.consumerdatastandards.holder.model.ResponseDiscoveryOutagesList;
import au.org.consumerdatastandards.holder.model.ResponseDiscoveryOutagesListData;
import au.org.consumerdatastandards.holder.service.DiscoveryOutageService;
import au.org.consumerdatastandards.holder.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Validated
@Controller
@CrossOrigin
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class CommonDiscoveryApiController extends ApiControllerBase implements CommonDiscoveryApi {

    private final DiscoveryOutageService outageService;
    private final NativeWebRequest request;

    @Autowired
    public CommonDiscoveryApiController(NativeWebRequest request, DiscoveryOutageService outageService) {
        this.request = request;
        this.outageService = outageService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public ResponseEntity<ResponseDiscoveryOutagesList> getOutages(Integer xMinV, Integer xV) {
        validateSupportedVersion(xMinV, xV);
        ResponseDiscoveryOutagesListData listData = new ResponseDiscoveryOutagesListData();
        List<DiscoveryOutage> outages = new ArrayList<>();
        Iterable<DiscoveryOutage> outageIter = outageService.getOutages();
        outageIter.forEach(outages::add);
        listData.setOutages(outages);
        ResponseDiscoveryOutagesList responseDiscoveryOutagesList = new ResponseDiscoveryOutagesList();
        responseDiscoveryOutagesList.setData(listData);
        responseDiscoveryOutagesList.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(responseDiscoveryOutagesList, generateResponseHeaders(request), HttpStatus.OK);
    }

      public ResponseEntity<ResponseCommonDiscoveryStatus> getStatus(Integer xMinV, Integer xV) {
        validateSupportedVersion(xMinV, xV);
        ResponseCommonDiscoveryStatusData data = new ResponseCommonDiscoveryStatusData();
        data.setStatus(ResponseCommonDiscoveryStatusData.Status.OK);
        data.setUpdateTime(OffsetDateTime.now());
        ResponseCommonDiscoveryStatus responseCommonDiscoveryStatus = new ResponseCommonDiscoveryStatus();
        responseCommonDiscoveryStatus.setData(data);
        responseCommonDiscoveryStatus.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        return new ResponseEntity<>(responseCommonDiscoveryStatus, generateResponseHeaders(request), HttpStatus.OK);
    }
}
