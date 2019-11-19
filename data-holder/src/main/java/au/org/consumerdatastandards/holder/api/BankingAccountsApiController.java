package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.model.*;
import au.org.consumerdatastandards.holder.service.BankingAccountService;
import au.org.consumerdatastandards.holder.service.BankingTransactionService;
import au.org.consumerdatastandards.holder.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Validated
@Controller
@RequestMapping("${openapi.consumerDataStandards.base-path:/cds-au/v1}")
public class BankingAccountsApiController extends ApiControllerBase implements BankingAccountsApi {

    private final BankingAccountService accountService;
    private final BankingTransactionService transactionService;
    private final NativeWebRequest request;

    @Autowired
    public BankingAccountsApiController(NativeWebRequest request,
                                        BankingAccountService accountService,
                                        BankingTransactionService transactionService) {
        this.request = request;
        this.accountService = accountService;
        this.transactionService = transactionService;
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
        validateHeaders(xCdsUserAgent, xCdsSubject, xFapiCustomerIpAddress, xMinV, xV);
        HttpHeaders headers = generateResponseHeaders(request);
        BankingAccountDetail bankingAccountDetail = accountService.getBankingAccountDetail(accountId);
        if (bankingAccountDetail == null) {
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }

        ResponseBankingAccountById responseBankingAccountById = new ResponseBankingAccountById();
        responseBankingAccountById.setData(bankingAccountDetail);
        responseBankingAccountById.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        responseBankingAccountById.setMeta(new Meta());
        return new ResponseEntity<>(responseBankingAccountById, headers, HttpStatus.OK);
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
        validateHeaders(xCdsUserAgent, xCdsSubject, xFapiCustomerIpAddress, xMinV, xV);
        HttpHeaders headers = generateResponseHeaders(request);
        BankingTransactionDetail transactionDetail = transactionService.getBankingTransactionDetail(transactionId);
        if (transactionDetail == null) {
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }
        ResponseBankingTransactionById responseBankingTransactionById = new ResponseBankingTransactionById();
        responseBankingTransactionById.setData(transactionDetail);
        responseBankingTransactionById.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        responseBankingTransactionById.setMeta(new Meta());
        return new ResponseEntity<>(responseBankingTransactionById, headers, HttpStatus.OK);
    }

    public ResponseEntity<ResponseBankingTransactionList> getTransactions(String accountId,
                                                                          BigDecimal maxAmount,
                                                                          BigDecimal minAmount,
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
        validateHeaders(xCdsUserAgent, xCdsSubject, xFapiCustomerIpAddress, xMinV, xV);
        validatePageInputs(page, pageSize);
        HttpHeaders headers = generateResponseHeaders(request);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<BankingTransaction> transactionPage = transactionService.findTransactions(
            accountId, maxAmount, minAmount, newestTime, oldestTime, text, PageRequest.of(actualPage, actualPageSize));
        ResponseBankingTransactionListData listData = new ResponseBankingTransactionListData();
        listData.setTransactions(transactionPage.getContent());
        ResponseBankingTransactionList responseBankingTransactionList = new ResponseBankingTransactionList();
        responseBankingTransactionList.setData(listData);
        responseBankingTransactionList.setLinks(getLinkData(request, transactionPage, actualPage, actualPageSize));
        responseBankingTransactionList.setMeta(getMetaData(transactionPage));
        return new ResponseEntity<>(responseBankingTransactionList, headers, HttpStatus.OK);
    }

    public ResponseEntity<ResponseBankingAccountList> listAccounts(Boolean isOwned,
                                                                   ParamAccountOpenStatus openStatus,
                                                                   Integer page,
                                                                   Integer pageSize,
                                                                   ParamProductCategory productCategory,
                                                                   String xCdsUserAgent,
                                                                   String xCdsSubject,
                                                                   @NotNull OffsetDateTime xFapiAuthDate,
                                                                   String xFapiCustomerIpAddress,
                                                                   UUID xFapiInteractionId,
                                                                   @Min(1) Integer xMinV,
                                                                   @Min(1) Integer xV) {
        validateHeaders(xCdsUserAgent, xCdsSubject, xFapiCustomerIpAddress, xMinV, xV);
        validatePageInputs(page, pageSize);
        HttpHeaders headers = generateResponseHeaders(request);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        BankingAccount bankingAccount = new BankingAccount();
        if (openStatus != null && !openStatus.equals(ParamAccountOpenStatus.ALL)) {
            bankingAccount.setOpenStatus(BankingAccount.OpenStatus.valueOf(openStatus.name()));
        }
        if (productCategory != null ) {
            bankingAccount.setProductCategory(BankingProductCategory.valueOf(productCategory.name()));
        }
        Page<BankingAccount> accountPage = accountService.findBankingAccountsLike(isOwned, bankingAccount, PageRequest.of(actualPage, actualPageSize));
        ResponseBankingAccountListData listData = new ResponseBankingAccountListData();
        listData.setAccounts(accountPage.getContent());
        ResponseBankingAccountList responseBankingAccountList = new ResponseBankingAccountList();
        responseBankingAccountList.setData(listData);
        responseBankingAccountList.setLinks(getLinkData(request, accountPage, actualPage, actualPageSize));
        responseBankingAccountList.setMeta(getMetaData(accountPage));
        return new ResponseEntity<>(responseBankingAccountList, headers, HttpStatus.OK);
    }

    public ResponseEntity<ResponseBankingAccountsBalanceById> listBalance(String accountId,
                                                                          String xCdsUserAgent,
                                                                          String xCdsSubject,
                                                                          @NotNull OffsetDateTime xFapiAuthDate,
                                                                          String xFapiCustomerIpAddress,
                                                                          UUID xFapiInteractionId,
                                                                          @Min(1) Integer xMinV,
                                                                          @Min(1) Integer xV) {
        validateHeaders(xCdsUserAgent, xCdsSubject, xFapiCustomerIpAddress, xMinV, xV);
        HttpHeaders headers = generateResponseHeaders(request);
        BankingBalance balance = accountService.getBankingBalance(accountId);
        if (balance == null) {
            return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
        }
        ResponseBankingAccountsBalanceById responseBankingAccountsBalanceById = new ResponseBankingAccountsBalanceById();
        responseBankingAccountsBalanceById.setData(balance);
        responseBankingAccountsBalanceById.setLinks(new Links().self(WebUtil.getOriginalUrl(request)));
        responseBankingAccountsBalanceById.setMeta(new Meta());
        return new ResponseEntity<>(responseBankingAccountsBalanceById, headers, HttpStatus.OK);
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
        validateHeaders(xCdsUserAgent, xCdsSubject, xFapiCustomerIpAddress, xMinV, xV);
        validatePageInputs(page, pageSize);
        HttpHeaders headers = generateResponseHeaders(request);
        Integer actualPage = getPagingValue(page, 1);
        Integer actualPageSize = getPagingValue(pageSize, 25);
        Page<BankingBalance> balancePage = accountService.getBankingBalances(accountIds.getData().getAccountIds(),
            PageRequest.of(actualPage, actualPageSize));
        ResponseBankingAccountsBalanceListData listData = new ResponseBankingAccountsBalanceListData();
        listData.setBalances(balancePage.getContent());
        ResponseBankingAccountsBalanceList responseBankingAccountsBalanceList = new ResponseBankingAccountsBalanceList();
        responseBankingAccountsBalanceList.setData(listData);
        responseBankingAccountsBalanceList.setLinks(getLinkData(request, balancePage, actualPage, actualPageSize));
        responseBankingAccountsBalanceList.setMeta(getMetaData(balancePage));
        return new ResponseEntity<>(responseBankingAccountsBalanceList, headers, HttpStatus.OK);
    }
}
