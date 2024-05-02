package au.org.consumerdatastandards.holder.service.banking;

import au.org.consumerdatastandards.holder.model.banking.BankingPayee;
import au.org.consumerdatastandards.holder.model.banking.BankingPayeeDetail;
import au.org.consumerdatastandards.holder.repository.banking.BankingPayeeDetailRepositoryV1;
import au.org.consumerdatastandards.holder.repository.banking.BankingPayeeDetailRepositoryV2;
import au.org.consumerdatastandards.holder.repository.banking.BankingPayeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BankingPayeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankingPayeeService.class);

    private final BankingPayeeRepository bankingPayeeRepository;

    private final BankingPayeeDetailRepositoryV1 bankingPayeeDetailRepositoryV1;
    private final BankingPayeeDetailRepositoryV2 bankingPayeeDetailRepositoryV2;

    @Autowired
    public BankingPayeeService(
            BankingPayeeRepository bankingPayeeRepository,
            BankingPayeeDetailRepositoryV1 bankingPayeeDetailRepositoryV1,
            BankingPayeeDetailRepositoryV2 bankingPayeeDetailRepositoryV2) {
        this.bankingPayeeRepository = bankingPayeeRepository;
        this.bankingPayeeDetailRepositoryV1 = bankingPayeeDetailRepositoryV1;
        this.bankingPayeeDetailRepositoryV2 = bankingPayeeDetailRepositoryV2;
    }

    public BankingPayeeDetail getBankingPayeeDetail(String payeeId, int supportedVersion) {
        LOGGER.debug("Retrieving banking payee detail by payee id {}", payeeId);
        return (supportedVersion == 2 ? bankingPayeeDetailRepositoryV2 : bankingPayeeDetailRepositoryV1)
                .findById(payeeId).orElse(null);
    }

    public Page<BankingPayee> getBankingPayees(BankingPayee.Type type, Pageable pageable) {
        LOGGER.debug("Retrieving banking payees by type {}", type);
        if (type == null) {
            return bankingPayeeRepository.findAll(pageable);
        }
        return bankingPayeeRepository.findByType(type, pageable);
    }
}
