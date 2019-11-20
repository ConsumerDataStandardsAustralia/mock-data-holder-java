package au.org.consumerdatastandards.holder.service;

import au.org.consumerdatastandards.holder.model.BankingPayee;
import au.org.consumerdatastandards.holder.model.BankingPayeeDetail;
import au.org.consumerdatastandards.holder.repository.BankingPayeeDetailRepository;
import au.org.consumerdatastandards.holder.repository.BankingPayeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankingPayeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BankingPayeeService.class);

    private final BankingPayeeRepository bankingPayeeRepository;

    private final BankingPayeeDetailRepository bankingPayeeDetailRepository;

    @Autowired
    public BankingPayeeService(
        BankingPayeeRepository bankingPayeeRepository,
        BankingPayeeDetailRepository bankingPayeeDetailRepository) {
        this.bankingPayeeRepository = bankingPayeeRepository;
        this.bankingPayeeDetailRepository = bankingPayeeDetailRepository;
    }

    public BankingPayeeDetail getBankingPayeeDetail(String payeeId) {
        LOGGER.debug("Retrieving banking payee detail by payee id {}", payeeId);
        Optional<BankingPayeeDetail> byId = bankingPayeeDetailRepository.findById(payeeId);
        return byId.orElse(null);
    }

    public Page<BankingPayee> getBankingPayees(BankingPayee.Type type, Pageable pageable) {
        LOGGER.debug("Retrieving banking payees by type {}", type);
        if (type == null) {
            return bankingPayeeRepository.findAll(pageable);
        }
        return bankingPayeeRepository.findByType(type, pageable);
    }
}
