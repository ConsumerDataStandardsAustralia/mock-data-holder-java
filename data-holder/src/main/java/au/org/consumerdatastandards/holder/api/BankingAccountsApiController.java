package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.*;
import au.org.consumerdatastandards.holder.service.BankingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Validated
@Controller
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class BankingAccountsApiController extends ApiControllerBase implements BankingAccountsApi {

    private final BankingAccountService service;
    private final NativeWebRequest request;

    @Autowired
    public BankingAccountsApiController(NativeWebRequest request, BankingAccountService service) {
        this.request = request;
        this.service = service;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public ResponseEntity<ResponseBankingAccountById> getAccountDetail(String accountId,
                                                                       String xCdsUserAgent,
                                                                       String xCdsSubject,
                                                                       @NotNull OffsetDateTime xFapiAuthDate,
                                                                       String xFapiCustomerIpAddress,
                                                                       UUID xFapiInteractionId,
                                                                       @Min(1) Integer xMinV,
                                                                       @Min(1) Integer xV) {
        if (!hasSupportedVersion(xMinV, xV)) {
            logger.error(
                "Unsupported version requested, minimum version specified is {}, maximum version specified is {}, current version is {}",
                xMinV, xV, getCurrentVersion());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseBankingTransactionById> getTransactionDetail(String accountId,
                                                                               String transactionId,
                                                                               String xCdsUserAgent,
                                                                               String xCdsSubject,
                                                                               @NotNull OffsetDateTime xFapiAuthDate,
                                                                               String xFapiCustomerIpAddress,
                                                                               UUID xFapiInteractionId,
                                                                               Integer xMinV,
                                                                               Integer xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseBankingTransactionList> getTransactions(String accountId,
                                                                          String maxAmount,
                                                                          String minAmount,
                                                                          OffsetDateTime newestTime,
                                                                          OffsetDateTime oldestTime,
                                                                          Integer page,
                                                                          Integer pageSize,
                                                                          String text,
                                                                          String xCdsUserAgent,
                                                                          String xCdsSubject,
                                                                          @NotNull OffsetDateTime xFapiAuthDate,
                                                                          String xFapiCustomerIpAddress,
                                                                          UUID xFapiInteractionId,
                                                                          @Min(1) Integer xMinV,
                                                                          @Min(1) Integer xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseBankingAccountList> listAccounts(Boolean isOwned,
                                                                   String openStatus,
                                                                   Integer page,
                                                                   Integer pageSize,
                                                                   String productCategory,
                                                                   String xCdsUserAgent,
                                                                   String xCdsSubject,
                                                                   @NotNull OffsetDateTime xFapiAuthDate,
                                                                   String xFapiCustomerIpAddress,
                                                                   UUID xFapiInteractionId,
                                                                   @Min(1) Integer xMinV,
                                                                   @Min(1) Integer xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseBankingAccountsBalanceById> listBalance(String accountId,
                                                                          String xCdsUserAgent,
                                                                          String xCdsSubject,
                                                                          @NotNull OffsetDateTime xFapiAuthDate,
                                                                          String xFapiCustomerIpAddress,
                                                                          UUID xFapiInteractionId,
                                                                          @Min(1) Integer xMinV,
                                                                          @Min(1) Integer xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseBankingAccountsBalanceList> listBalancesSpecificAccounts(RequestAccountIds accountIds,
                                                                                           Integer page,
                                                                                           Integer pageSize,
                                                                                           String xCdsUserAgent,
                                                                                           String xCdsSubject,
                                                                                           @NotNull OffsetDateTime xFapiAuthDate,
                                                                                           String xFapiCustomerIpAddress,
                                                                                           UUID xFapiInteractionId,
                                                                                           @Min(1) Integer xMinV,
                                                                                           @Min(1) Integer xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
