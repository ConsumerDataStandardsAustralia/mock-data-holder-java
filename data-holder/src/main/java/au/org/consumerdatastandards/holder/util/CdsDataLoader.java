package au.org.consumerdatastandards.holder.util;

import au.org.consumerdatastandards.holder.model.*;
import au.org.consumerdatastandards.holder.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class CdsDataLoader {

    private static final Logger LOGGER = LogManager.getLogger(CdsDataLoader.class);

    private BankingProductDetailRepository productDetailRepository;
    private BankingAccountDetailRepository accountDetailRepository;
    private BankingBalanceRepository balanceRepository;
    private CommonPersonDetailRepository commonPersonDetailRepository;
    private BankingTransactionDetailRepository transactionDetailRepository;

    private ObjectMapper objectMapper;


    @Autowired
    public CdsDataLoader(BankingProductDetailRepository productDetailRepository,
                         BankingAccountDetailRepository accountDetailRepository,
                         BankingBalanceRepository balanceRepository,
                         CommonPersonDetailRepository commonPersonDetailRepository,
                         BankingTransactionDetailRepository transactionDetailRepository) {
        this.productDetailRepository = productDetailRepository;
        this.accountDetailRepository = accountDetailRepository;
        this.balanceRepository = balanceRepository;
        this.commonPersonDetailRepository = commonPersonDetailRepository;
        this.transactionDetailRepository = transactionDetailRepository;
        this.objectMapper = new ObjectMapper()
            .registerModule(new ParameterNamesModule())
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());
    }

    public void loadAll() throws IOException {
        load("payloads/accounts", accountDetailRepository, BankingAccountDetail.class);
        load("payloads/balances", balanceRepository, BankingBalance.class);
        load("payloads/persons", commonPersonDetailRepository, CommonPersonDetail.class);
        load("payloads/products", productDetailRepository, BankingProductDetail.class);
        load("payloads/transactions", transactionDetailRepository, BankingTransactionDetail.class);
    }

    private void load(String fileOrFolder, CrudRepository repository, Class<?> dataType) throws IOException {
        File file = new File(fileOrFolder);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File oneFile : files) {
                load(oneFile.getAbsolutePath(), repository, dataType);
            }
        } else {
            LOGGER.info("Loading data from {}", file.getAbsolutePath());
            repository.save(objectMapper.readValue(file, dataType));
        }
    }
}
