package au.org.consumerdatastandards.holder.util;

import au.org.consumerdatastandards.holder.model.CommonEmailAddress;
import au.org.consumerdatastandards.holder.model.CommonOrganisationDetail;
import au.org.consumerdatastandards.holder.model.CommonPersonDetail;
import au.org.consumerdatastandards.holder.model.OrganisationUser;
import au.org.consumerdatastandards.holder.model.PersonUser;
import au.org.consumerdatastandards.holder.model.User;
import au.org.consumerdatastandards.holder.model.banking.BankingAccountDetailV3;
import au.org.consumerdatastandards.holder.model.banking.BankingAccountV2;
import au.org.consumerdatastandards.holder.model.banking.BankingBalance;
import au.org.consumerdatastandards.holder.model.banking.BankingProductV2Detail;
import au.org.consumerdatastandards.holder.model.banking.BankingTransactionDetail;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountV2;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanDetailV2;
import au.org.consumerdatastandards.holder.repository.CommonOrganisationRepository;
import au.org.consumerdatastandards.holder.repository.CommonPersonDetailRepository;
import au.org.consumerdatastandards.holder.repository.CommonPersonRepository;
import au.org.consumerdatastandards.holder.repository.UserRepository;
import au.org.consumerdatastandards.holder.repository.banking.BankingAccountDetailRepositoryV3;
import au.org.consumerdatastandards.holder.repository.banking.BankingAccountRepositoryV2;
import au.org.consumerdatastandards.holder.repository.banking.BankingBalanceRepository;
import au.org.consumerdatastandards.holder.repository.banking.BankingProductDetailV2Repository;
import au.org.consumerdatastandards.holder.repository.banking.BankingTransactionDetailRepository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyAccountV2Repository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyPlanDetailV2Repository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CdsDataLoader implements ApplicationRunner {

    private static final Logger LOGGER = LogManager.getLogger(CdsDataLoader.class);
    private static final String DEFAULT_PASSWORD = "password";

    // Banking repositories
    private BankingProductDetailV2Repository productDetailRepository;
    private BankingAccountDetailRepositoryV3 accountDetailRepository;
    private BankingAccountRepositoryV2 accountRepository;
    private BankingBalanceRepository balanceRepository;
    private CommonPersonDetailRepository commonPersonDetailRepository;
    private BankingTransactionDetailRepository transactionDetailRepository;
    private UserRepository userRepository;
    private CommonPersonRepository commonPersonRepository;
    private CommonOrganisationRepository commonOrganisationRepository;

    // Energy repositories
    private final EnergyAccountV2Repository energyAccountV2Repository;
    private final EnergyPlanDetailV2Repository energyPlanDetailV2Repository;

    private ObjectMapper objectMapper;
    private int personUserIdSeq = 0;
    private int organisationUserIdSeq = 0;

    @Autowired
    public CdsDataLoader(BankingProductDetailV2Repository productDetailRepository,
                         BankingAccountDetailRepositoryV3 accountDetailRepository,
                         BankingAccountRepositoryV2 accountRepository,
                         BankingBalanceRepository balanceRepository,
                         CommonPersonDetailRepository commonPersonDetailRepository,
                         BankingTransactionDetailRepository transactionDetailRepository,
                         EnergyAccountV2Repository energyAccountV2Repository,
                         EnergyPlanDetailV2Repository energyPlanDetailV2Repository,
                         UserRepository userRepository,
                         CommonPersonRepository commonPersonRepository,
                         CommonOrganisationRepository commonOrganisationRepository) {
        this.productDetailRepository = productDetailRepository;
        this.accountDetailRepository = accountDetailRepository;
        this.accountRepository = accountRepository;
        this.balanceRepository = balanceRepository;
        this.commonPersonDetailRepository = commonPersonDetailRepository;
        this.transactionDetailRepository = transactionDetailRepository;
        this.energyAccountV2Repository = energyAccountV2Repository;
        this.energyPlanDetailV2Repository = energyPlanDetailV2Repository;
        this.userRepository = userRepository;
        this.commonPersonRepository = commonPersonRepository;
        this.commonOrganisationRepository = commonOrganisationRepository;
        this.objectMapper = new ObjectMapper()
            .registerModule(new ParameterNamesModule())
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());
    }

    private void loadAll(List<String> testdata) throws IOException {
        // Banking
        load("payloads/banking/accounts", accountDetailRepository, BankingAccountDetailV3.class);
        load("payloads/banking/balances", balanceRepository, BankingBalance.class);
        load("payloads/banking/persons", commonPersonDetailRepository, CommonPersonDetail.class);
        load("payloads/banking/products", productDetailRepository, BankingProductV2Detail.class);
        load("payloads/banking/transactions", transactionDetailRepository, BankingTransactionDetail.class);

        // Energy
        if (!testdata.isEmpty()) {
            String path = testdata.get(0);
            LOGGER.info("Loading from test data file: {}", path);
            JsonNode tree = objectMapper.readTree(new File(path));
            JsonNode holders = tree.path("holders");
            for (JsonNode holder : holders) {
                LOGGER.info("Holder: {}", holder.get("holderId"));
                loadEnergyTestData(holder);
            }
        } else {
            load("payloads/energy/plans", energyPlanDetailV2Repository, EnergyPlanDetailV2.class);
        }
        load("payloads/energy/accounts", energyAccountV2Repository, EnergyAccountV2.class);
    }

    private void loadEnergyTestData(JsonNode holder) throws JsonProcessingException {
        for (JsonNode planJson : holder.at("/holder/unauthenticated/energy/plans")) {
            EnergyPlanDetailV2 plan = objectMapper.treeToValue(planJson, EnergyPlanDetailV2.class);
            LOGGER.info("Loading plan: {}", plan.getPlanId());
            energyPlanDetailV2Repository.save(plan);
        }
    }

    private <T, U> void load(String fileOrFolder, CrudRepository<T, U> repository, Class<T> dataType) throws IOException {
        File file = new File(fileOrFolder);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File oneFile : files) {
                load(oneFile.getAbsolutePath(), repository, dataType);
            }
        } else {
            LOGGER.info("Loading data from {}", file.getAbsolutePath());
            T obj = objectMapper.readValue(file, dataType);

            if (dataType.isAssignableFrom(BankingBalance.class)) {
                assignAccountToBalance((BankingBalance) obj);
            }

            Object savedEntity = repository.save(obj);
            if (CommonPersonDetail.class.equals(dataType)) {
                CommonPersonDetail commonPersonDetail = (CommonPersonDetail)savedEntity;
                createPersonUser(commonPersonDetail);
            } else if (CommonOrganisationDetail.class.equals(dataType)) {
                CommonOrganisationDetail commonOrganisationDetail = (CommonOrganisationDetail)savedEntity;
                createOrganisationUser(commonOrganisationDetail);
            }
        }
    }

    private void assignAccountToBalance(BankingBalance balance) {
        Optional<BankingAccountV2> account = accountRepository.findById(balance.getAccountId());
        if (account.isPresent()) {
            balance.setBankingAccount(account.get());
        } else {
            LOGGER.info("Unresolved account ID in balance {}", balance.getAccountId());
        }
    }

    private void createOrganisationUser(CommonOrganisationDetail commonOrganisationDetail) {
        OrganisationUser user = new OrganisationUser();
        user.setGivenName(commonOrganisationDetail.getAgentFirstName());
        user.setFamilyName(commonOrganisationDetail.getAgentLastName());
        user.setEmail(user.getGivenName() + "." + user.getFamilyName() + "@test.org");
        user.setEmailVerified(true);
        user.setGender(User.Gender.female);
        user.setPasswordHash(generateDefaultPasswordHash());
        user.setOrganisation(commonOrganisationRepository.findById(commonOrganisationDetail.getId()).orElse(null));
        user.setId("org" + organisationUserIdSeq++);
        userRepository.save(user);
    }

    private void createPersonUser(CommonPersonDetail commonPersonDetail) {
        PersonUser user = new PersonUser();
        user.setGivenName(commonPersonDetail.getFirstName());
        user.setFamilyName(commonPersonDetail.getLastName());
        List<CommonEmailAddress> emailAddresses = commonPersonDetail.getEmailAddresses();
        if(emailAddresses != null && !emailAddresses.isEmpty()) {
            user.setEmail(emailAddresses.get(0).getAddress());
        } else {
            user.setEmail(user.getGivenName() + "." + user.getFamilyName() + "@test.com");
        }
        user.setEmailVerified(true);
        user.setUpdatedAt(new Date().getTime());
        user.setGender(User.Gender.female);
        user.setPasswordHash(generateDefaultPasswordHash());
        user.setPerson(commonPersonRepository.findById(commonPersonDetail.getId()).orElse(null));
        user.setId("person" + personUserIdSeq++);
        userRepository.save(user);
    }

    private String generateDefaultPasswordHash() {
        return DigestUtils.sha256Hex(DEFAULT_PASSWORD);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("Service setup in progress, performing boot time operations");
        loadAll(args.getNonOptionArgs());
    }
}
