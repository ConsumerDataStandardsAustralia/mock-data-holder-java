package au.org.consumerdatastandards.holder.service;

import au.org.consumerdatastandards.holder.model.BankingAccount;
import au.org.consumerdatastandards.holder.model.BankingAccountDetail;
import au.org.consumerdatastandards.holder.repository.BankingAccountDetailRepository;
import au.org.consumerdatastandards.holder.repository.BankingAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankingAccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankingAccountService.class);

    private final BankingAccountRepository bankingAccountRepository;

    private final BankingAccountDetailRepository bankingAccountDetailRepository;

    @Autowired
    public BankingAccountService(
        BankingAccountRepository bankingAccountRepository,
        BankingAccountDetailRepository bankingAccountDetailRepository)
    {
        this.bankingAccountRepository = bankingAccountRepository;
        this.bankingAccountDetailRepository = bankingAccountDetailRepository;
    }

    public BankingAccountDetail getBankingAccountDetail(String accountId) {
        LOGGER.debug("Retrieving account detail by id {}",  accountId);
        Optional<BankingAccountDetail> byId = bankingAccountDetailRepository.findById(accountId);
        return byId.orElse(null);
    }
}
