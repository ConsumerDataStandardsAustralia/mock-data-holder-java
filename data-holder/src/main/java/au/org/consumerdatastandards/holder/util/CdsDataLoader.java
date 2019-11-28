package au.org.consumerdatastandards.holder.util;

import au.org.consumerdatastandards.holder.model.BankingAccountDetail;
import au.org.consumerdatastandards.holder.model.BankingBalance;
import au.org.consumerdatastandards.holder.model.BankingProductDetail;
import au.org.consumerdatastandards.holder.model.BankingTransactionDetail;
import au.org.consumerdatastandards.holder.model.CommonEmailAddress;
import au.org.consumerdatastandards.holder.model.CommonOrganisationDetail;
import au.org.consumerdatastandards.holder.model.CommonPersonDetail;
import au.org.consumerdatastandards.holder.model.OrganisationUser;
import au.org.consumerdatastandards.holder.model.PersonUser;
import au.org.consumerdatastandards.holder.model.User;
import au.org.consumerdatastandards.holder.repository.BankingAccountDetailRepository;
import au.org.consumerdatastandards.holder.repository.BankingBalanceRepository;
import au.org.consumerdatastandards.holder.repository.BankingProductDetailRepository;
import au.org.consumerdatastandards.holder.repository.BankingTransactionDetailRepository;
import au.org.consumerdatastandards.holder.repository.CommonOrganisationRepository;
import au.org.consumerdatastandards.holder.repository.CommonPersonDetailRepository;
import au.org.consumerdatastandards.holder.repository.CommonPersonRepository;
import au.org.consumerdatastandards.holder.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Component
public class CdsDataLoader {

    private static final Logger LOGGER = LogManager.getLogger(CdsDataLoader.class);
    private static final String DEFAULT_PASSWORD = "password";

    private BankingProductDetailRepository productDetailRepository;
    private BankingAccountDetailRepository accountDetailRepository;
    private BankingBalanceRepository balanceRepository;
    private CommonPersonDetailRepository commonPersonDetailRepository;
    private BankingTransactionDetailRepository transactionDetailRepository;
    private UserRepository userRepository;
    private CommonPersonRepository commonPersonRepository;
    private CommonOrganisationRepository commonOrganisationRepository;

    private ObjectMapper objectMapper;
    private int personUserIdSeq = 0;
    private int organisationUserIdSeq = 0;

    @Autowired
    public CdsDataLoader(BankingProductDetailRepository productDetailRepository,
                         BankingAccountDetailRepository accountDetailRepository,
                         BankingBalanceRepository balanceRepository,
                         CommonPersonDetailRepository commonPersonDetailRepository,
                         BankingTransactionDetailRepository transactionDetailRepository,
                         UserRepository userRepository,
                         CommonPersonRepository commonPersonRepository,
                         CommonOrganisationRepository commonOrganisationRepository) {
        this.productDetailRepository = productDetailRepository;
        this.accountDetailRepository = accountDetailRepository;
        this.balanceRepository = balanceRepository;
        this.commonPersonDetailRepository = commonPersonDetailRepository;
        this.transactionDetailRepository = transactionDetailRepository;
        this.userRepository = userRepository;
        this.commonPersonRepository = commonPersonRepository;
        this.commonOrganisationRepository = commonOrganisationRepository;
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
            Object savedEntity = repository.save(objectMapper.readValue(file, dataType));
            if(CommonPersonDetail.class.equals(dataType)) {
                CommonPersonDetail commonPersonDetail = (CommonPersonDetail)savedEntity;
                createPersonUser(commonPersonDetail);
            } else if (CommonOrganisationDetail.class.equals(dataType)) {
                CommonOrganisationDetail commonOrganisationDetail = (CommonOrganisationDetail)savedEntity;
                createOrganisationUser(commonOrganisationDetail);
            }
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
}
