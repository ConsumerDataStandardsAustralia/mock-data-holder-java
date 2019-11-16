package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.*;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class BankingAccountsApiController implements BankingAccountsApi {

    private final NativeWebRequest request;

    @Autowired
    public BankingAccountsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    public ResponseEntity<ResponseBankingAccountById> getAccountDetail(String accountId,
                                                                       String xCdsUserAgent,
                                                                       String xCdsSubject,
                                                                       String xFapiAuthDate,
                                                                       String xFapiCustomerIpAddress,
                                                                       String xFapiInteractionId,
                                                                       String xMinV,
                                                                       String xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseBankingTransactionById> getTransactionDetail(String accountId,
                                                                               String transactionId,
                                                                               String xCdsUserAgent,
                                                                               String xCdsSubject,
                                                                               String xFapiAuthDate,
                                                                               String xFapiCustomerIpAddress,
                                                                               String xFapiInteractionId,
                                                                               String xMinV,
                                                                               String xV) {
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
                                                                          String xFapiAuthDate,
                                                                          String xFapiCustomerIpAddress,
                                                                          String xFapiInteractionId,
                                                                          String xMinV,
                                                                          String xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseBankingAccountList> listAccounts(Boolean isOwned,
                                                                   String openStatus,
                                                                   Integer page,
                                                                   Integer pageSize,
                                                                   String productCategory,
                                                                   String xCdsUserAgent,
                                                                   String xCdsSubject,
                                                                   String xFapiAuthDate,
                                                                   String xFapiCustomerIpAddress,
                                                                   String xFapiInteractionId,
                                                                   String xMinV,
                                                                   String xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseBankingAccountsBalanceById> listBalance(String accountId,
                                                                          String xCdsUserAgent,
                                                                          String xCdsSubject,
                                                                          String xFapiAuthDate,
                                                                          String xFapiCustomerIpAddress,
                                                                          String xFapiInteractionId,
                                                                          String xMinV,
                                                                          String xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ResponseBankingAccountsBalanceList> listBalancesSpecificAccounts(RequestAccountIds accountIds,
                                                                                           Integer page,
                                                                                           Integer pageSize,
                                                                                           String xCdsUserAgent,
                                                                                           String xCdsSubject,
                                                                                           String xFapiAuthDate,
                                                                                           String xFapiCustomerIpAddress,
                                                                                           String xFapiInteractionId,
                                                                                           String xMinV,
                                                                                           String xV) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
