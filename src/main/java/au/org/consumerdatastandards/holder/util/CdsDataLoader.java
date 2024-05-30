package au.org.consumerdatastandards.holder.util;

import au.org.consumerdatastandards.holder.model.CommonEmailAddress;
import au.org.consumerdatastandards.holder.model.CommonOrganisationDetail;
import au.org.consumerdatastandards.holder.model.CommonPersonDetail;
import au.org.consumerdatastandards.holder.model.OrganisationUser;
import au.org.consumerdatastandards.holder.model.PersonUser;
import au.org.consumerdatastandards.holder.model.User;
import au.org.consumerdatastandards.holder.model.banking.BankingAccountDetailV3;
import au.org.consumerdatastandards.holder.model.banking.BankingAccountV2;
import au.org.consumerdatastandards.holder.model.banking.BankingAuthorisedEntity;
import au.org.consumerdatastandards.holder.model.banking.BankingBalance;
import au.org.consumerdatastandards.holder.model.banking.BankingDirectDebit;
import au.org.consumerdatastandards.holder.model.banking.BankingPayeeDetailV2;
import au.org.consumerdatastandards.holder.model.banking.BankingProductDetailV4;
import au.org.consumerdatastandards.holder.model.banking.BankingScheduledPaymentV2;
import au.org.consumerdatastandards.holder.model.banking.BankingTransactionDetail;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountDetailV3;
import au.org.consumerdatastandards.holder.model.energy.EnergyAccountV2;
import au.org.consumerdatastandards.holder.model.energy.EnergyBalanceListResponseDataBalances;
import au.org.consumerdatastandards.holder.model.energy.EnergyBillingTransactionV3;
import au.org.consumerdatastandards.holder.model.energy.EnergyConcession;
import au.org.consumerdatastandards.holder.model.energy.EnergyDerRecord;
import au.org.consumerdatastandards.holder.model.energy.EnergyInvoice;
import au.org.consumerdatastandards.holder.model.energy.EnergyPaymentSchedule;
import au.org.consumerdatastandards.holder.model.energy.EnergyPlanDetailV2;
import au.org.consumerdatastandards.holder.model.energy.EnergyServicePointDetail;
import au.org.consumerdatastandards.holder.model.energy.EnergyUsageRead;
import au.org.consumerdatastandards.holder.repository.CommonOrganisationRepository;
import au.org.consumerdatastandards.holder.repository.CommonPersonDetailRepository;
import au.org.consumerdatastandards.holder.repository.CommonPersonRepository;
import au.org.consumerdatastandards.holder.repository.UserRepository;
import au.org.consumerdatastandards.holder.repository.banking.BankingAccountDetailRepositoryV3;
import au.org.consumerdatastandards.holder.repository.banking.BankingAccountRepositoryV2;
import au.org.consumerdatastandards.holder.repository.banking.BankingAuthorisedEntityRepository;
import au.org.consumerdatastandards.holder.repository.banking.BankingBalanceRepository;
import au.org.consumerdatastandards.holder.repository.banking.BankingDirectDebitRepository;
import au.org.consumerdatastandards.holder.repository.banking.BankingPayeeDetailRepositoryV2;
import au.org.consumerdatastandards.holder.repository.banking.BankingProductDetailV4Repository;
import au.org.consumerdatastandards.holder.repository.banking.BankingScheduledPaymentRepositoryV2;
import au.org.consumerdatastandards.holder.repository.banking.BankingTransactionDetailRepository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyAccountBalanceRepository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyAccountDetailV3Repository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyAccountV2Repository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyBillingTransactionV3Repository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyDerRecordRepository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyInvoiceRepository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyPlanDetailV2Repository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyServicePointDetailRepository;
import au.org.consumerdatastandards.holder.repository.energy.EnergyUsageRepository;
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
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CdsDataLoader implements ApplicationRunner {

    private static final Logger LOGGER = LogManager.getLogger(CdsDataLoader.class);
    private static final String DEFAULT_PASSWORD = "password";

    // Banking repositories
    private final BankingProductDetailV4Repository productDetailRepository;
    private final BankingAccountDetailRepositoryV3 accountDetailRepository;
    private final BankingAccountRepositoryV2 accountRepository;
    private final BankingBalanceRepository balanceRepository;
    private final CommonPersonDetailRepository commonPersonDetailRepository;
    private final BankingTransactionDetailRepository transactionDetailRepository;
    private final BankingDirectDebitRepository directDebitRepository;
    private final BankingAuthorisedEntityRepository authorisedEntityRepository;
    private final BankingPayeeDetailRepositoryV2 payeeDetailRepository;
    private final BankingScheduledPaymentRepositoryV2 scheduledPaymentRepository;

    private final UserRepository userRepository;
    private final CommonPersonRepository commonPersonRepository;
    private final CommonOrganisationRepository commonOrganisationRepository;

    // Energy repositories
    private final EnergyAccountV2Repository energyAccountV2Repository;
    private final EnergyAccountDetailV3Repository energyAccountDetailV3Repository;
    private final EnergyAccountBalanceRepository energyAccountBalanceRepository;
    private final EnergyInvoiceRepository energyInvoiceRepository;
    private final EnergyBillingTransactionV3Repository energyBillingTransactionRepository;
    private final EnergyPlanDetailV2Repository energyPlanDetailV2Repository;
    private final EnergyServicePointDetailRepository energyServicePointRepository;
    private final EnergyUsageRepository energyUsageRepository;
    private final EnergyDerRecordRepository energyDerRecordRepository;

    private final ObjectMapper objectMapper;
    private int personUserIdSeq = 0;
    private int organisationUserIdSeq = 0;

    @Autowired
    public CdsDataLoader(BankingProductDetailV4Repository productDetailRepository,
                         BankingAccountDetailRepositoryV3 accountDetailRepository,
                         BankingAccountRepositoryV2 accountRepository,
                         BankingBalanceRepository balanceRepository,
                         CommonPersonDetailRepository commonPersonDetailRepository,
                         BankingTransactionDetailRepository transactionDetailRepository,
                         BankingDirectDebitRepository directDebitRepository,
                         BankingAuthorisedEntityRepository authorisedEntityRepository,
                         BankingPayeeDetailRepositoryV2 payeeDetailRepository,
                         BankingScheduledPaymentRepositoryV2 scheduledPaymentRepository,
                         EnergyAccountV2Repository energyAccountV2Repository,
                         EnergyAccountDetailV3Repository energyAccountDetailV3Repository,
                         EnergyAccountBalanceRepository energyAccountBalanceRepository,
                         EnergyInvoiceRepository energyInvoiceRepository,
                         EnergyBillingTransactionV3Repository energyBillingTransactionRepository,
                         EnergyPlanDetailV2Repository energyPlanDetailV2Repository,
                         EnergyServicePointDetailRepository energyServicePointRepository,
                         EnergyUsageRepository energyUsageRepository,
                         EnergyDerRecordRepository energyDerRecordRepository,
                         UserRepository userRepository,
                         CommonPersonRepository commonPersonRepository,
                         CommonOrganisationRepository commonOrganisationRepository) {
        this.productDetailRepository = productDetailRepository;
        this.accountDetailRepository = accountDetailRepository;
        this.accountRepository = accountRepository;
        this.balanceRepository = balanceRepository;
        this.commonPersonDetailRepository = commonPersonDetailRepository;
        this.transactionDetailRepository = transactionDetailRepository;
        this.directDebitRepository = directDebitRepository;
        this.authorisedEntityRepository = authorisedEntityRepository;
        this.payeeDetailRepository = payeeDetailRepository;
        this.scheduledPaymentRepository = scheduledPaymentRepository;
        this.energyAccountV2Repository = energyAccountV2Repository;
        this.energyAccountDetailV3Repository = energyAccountDetailV3Repository;
        this.energyAccountBalanceRepository = energyAccountBalanceRepository;
        this.energyInvoiceRepository = energyInvoiceRepository;
        this.energyBillingTransactionRepository = energyBillingTransactionRepository;
        this.energyPlanDetailV2Repository = energyPlanDetailV2Repository;
        this.energyServicePointRepository = energyServicePointRepository;
        this.energyUsageRepository = energyUsageRepository;
        this.energyDerRecordRepository = energyDerRecordRepository;
        this.userRepository = userRepository;
        this.commonPersonRepository = commonPersonRepository;
        this.commonOrganisationRepository = commonOrganisationRepository;
        this.objectMapper = new ObjectMapper()
            .registerModule(new ParameterNamesModule())
            .registerModule(new Jdk8Module())
            .registerModule(new JavaTimeModule());
    }

    private void loadAll(List<String> testdata) throws IOException {
        if (testdata.isEmpty()) {
            // Banking
            load("payloads/banking/accounts", accountDetailRepository, BankingAccountDetailV3.class);
            load("payloads/banking/balances", balanceRepository, BankingBalance.class);
            load("payloads/banking/persons", commonPersonDetailRepository, CommonPersonDetail.class);
            load("payloads/banking/products", productDetailRepository, BankingProductDetailV4.class);
            load("payloads/banking/transactions", transactionDetailRepository, BankingTransactionDetail.class);

            // Energy
            load("payloads/energy/plans", energyPlanDetailV2Repository, EnergyPlanDetailV2.class);
            load("payloads/energy/accounts", energyAccountV2Repository, EnergyAccountV2.class);
        } else {
            String url = testdata.get(0);
            LOGGER.info("Loading from test data url: {}", url);
            JsonNode tree = objectMapper.readTree(new URL(url));
            JsonNode holders = tree.path("holders");
            for (JsonNode holder : holders) {
                LOGGER.info("Holder id: {}", holder.get("holderId"));
                loadBankingTestData(holder);
                loadEnergyTestData(holder);
            }
        }
        LOGGER.info("Data loaded.");
    }

    private void loadBankingTestData(JsonNode holder) throws JsonProcessingException {
        LOGGER.info("Loading Banking data...");
        for (JsonNode planJson : holder.at("/holder/unauthenticated/banking/products")) {
            BankingProductDetailV4 product = objectMapper.treeToValue(planJson, BankingProductDetailV4.class);
            LOGGER.info("Loading product: {}", product.getProductId());
            productDetailRepository.save(product);
        }

        for (JsonNode customer : holder.at("/holder/authenticated/customers")) {
            LOGGER.info("Customer id: {}", customer.get("customerId"));

            // Load accounts
            for (JsonNode accountEl : customer.at("/banking/accounts")) {
                BankingAccountDetailV3 account = objectMapper.treeToValue(accountEl.path("account"), BankingAccountDetailV3.class);
                LOGGER.info("Loading account: {}", account.getAccountId());

                // Load transactions
                LOGGER.info("Loading transaction of account: {}", account.getAccountId());
                for (JsonNode invoiceEl : accountEl.path("transactions")) {
                    BankingTransactionDetail transaction = objectMapper.treeToValue(invoiceEl, BankingTransactionDetail.class);
                    transaction.setAccountId(account.getAccountId());
                    transactionDetailRepository.save(transaction);
                }

                // Load invoices
                accountDetailRepository.save(account);

                // Load balance
                BankingBalance balance = objectMapper.treeToValue(accountEl.path("balance"), BankingBalance.class);
                balance.setAccountId(account.getAccountId());
                assignAccountToBalance(balance);
                balanceRepository.save(balance);
            }

            // Load direct debits
            for (JsonNode directDebitEl : customer.at("/banking/directDebits")) {
                BankingDirectDebit directDebit = objectMapper.treeToValue(directDebitEl, BankingDirectDebit.class);
                LOGGER.info("Loading direct debit for account: {}", directDebit.getAccountId());
                directDebit.setAuthorisedEntity(findOrCreateAuthEntity(directDebit.getAuthorisedEntity()));
                directDebitRepository.save(directDebit);
            }

            // Load payees
            for (JsonNode payeeEl : customer.at("/banking/payees")) {
                BankingPayeeDetailV2 payee = objectMapper.treeToValue(payeeEl, BankingPayeeDetailV2.class);
                LOGGER.info("Loading payee: {}", payee.getPayeeId());
                payeeDetailRepository.save(payee);
            }

            // Load payments
            for (JsonNode paymentsEl : customer.at("/banking/payments")) {
                BankingScheduledPaymentV2 payee = objectMapper.treeToValue(paymentsEl, BankingScheduledPaymentV2.class);
                LOGGER.info("Loading scheduled payment: {}", payee.getScheduledPaymentId());
                scheduledPaymentRepository.save(payee);
            }
        }
    }

    private BankingAuthorisedEntity findOrCreateAuthEntity(BankingAuthorisedEntity ae) {
        return authorisedEntityRepository.findOne((root, criteriaQuery, cb) -> cb.and(
                (ae.getDescription() == null ? cb.isNull(root.get("description")) : cb.equal(root.get("description"), ae.getDescription())),
                (ae.getFinancialInstitution() == null ? cb.isNull(root.get("financialInstitution")) : cb.equal(root.get("financialInstitution"), ae.getFinancialInstitution())),
                (ae.getAbn() == null ? cb.isNull(root.get("abn")) : cb.equal(root.get("abn"), ae.getAbn())),
                (ae.getAcn() == null ? cb.isNull(root.get("acn")) : cb.equal(root.get("acn"), ae.getAcn())),
                (ae.getArbn() == null ? cb.isNull(root.get("arbn")) : cb.equal(root.get("arbn"), ae.getArbn()))
        )).orElseGet(() -> authorisedEntityRepository.save(ae));
    }

    private void loadEnergyTestData(JsonNode holder) throws JsonProcessingException {
        LOGGER.info("Loading Energy data...");

        // Load plans
        for (JsonNode planJson : holder.at("/holder/unauthenticated/energy/plans")) {
            EnergyPlanDetailV2 plan = objectMapper.treeToValue(planJson, EnergyPlanDetailV2.class);
            LOGGER.info("Loading plan: {}", plan.getPlanId());
            energyPlanDetailV2Repository.save(plan);
        }

        for (JsonNode customer : holder.at("/holder/authenticated/customers")) {
            LOGGER.info("Customer id: {}", customer.get("customerId"));

            // Load accounts
            for (JsonNode accountEl : customer.at("/energy/accounts")) {
                EnergyAccountDetailV3 account = objectMapper.treeToValue(accountEl.path("account"), EnergyAccountDetailV3.class);
                LOGGER.info("Loading account: {}", account.getAccountId());

                // Load invoices
                for (JsonNode invoiceEl : accountEl.path("invoices")) {
                    EnergyInvoice invoice = objectMapper.treeToValue(invoiceEl, EnergyInvoice.class);
                    LOGGER.info("Loading invoice number {} of account: {}", invoice.getInvoiceNumber(), invoice.getAccountId());
                    energyInvoiceRepository.save(invoice);
                }

                // Load billing
                LOGGER.info("Loading billing transaction of account: {}", account.getAccountId());
                for (JsonNode invoiceEl : accountEl.path("transactions")) {
                    EnergyBillingTransactionV3 invoice = objectMapper.treeToValue(invoiceEl, EnergyBillingTransactionV3.class);
                    energyBillingTransactionRepository.save(invoice);
                }

                // Load concessions
                JsonNode concessionsEl = accountEl.path("concessions");
                if (concessionsEl.isArray()) {
                    LOGGER.info("Loading concessions of account: {}", account.getAccountId());
                    EnergyConcession[] concessions = objectMapper.treeToValue(concessionsEl, EnergyConcession[].class);
                    account.setConcessions(Arrays.asList(concessions));
                }

                // Load payment schedules
                JsonNode paymentScheduleEl = accountEl.path("paymentSchedule");
                if (paymentScheduleEl.isArray()) {
                    LOGGER.info("Loading payment schedules of account: {}", account.getAccountId());
                    EnergyPaymentSchedule[] paymentSchedules = objectMapper.treeToValue(paymentScheduleEl, EnergyPaymentSchedule[].class);
                    account.setPaymentSchedules(Arrays.asList(paymentSchedules));
                }

                energyAccountDetailV3Repository.save(account);

                // Load account balance
                LOGGER.info("Loading balance of account: {}", account.getAccountId());
                EnergyBalanceListResponseDataBalances balance = new EnergyBalanceListResponseDataBalances();
                balance.setBalance(accountEl.path("balance").asText());
                balance.setAccountId(account.getAccountId());
                energyAccountBalanceRepository.save(balance);
            }

            // Load service points
            for (JsonNode servicePointEl : customer.at("/energy/servicePoints")) {
                EnergyServicePointDetail servicePoint = objectMapper.treeToValue(servicePointEl.path("servicePoint"), EnergyServicePointDetail.class);
                LOGGER.info("Loading service point: {}", servicePoint.getServicePointId());
                energyServicePointRepository.save(servicePoint);

                // Load service point usage
                LOGGER.info("Loading usage of service point: {}", servicePoint.getServicePointId());
                for (JsonNode usageEl : servicePointEl.path("usage")) {
                    EnergyUsageRead usage = objectMapper.treeToValue(usageEl, EnergyUsageRead.class);
                    energyUsageRepository.save(usage);
                }

                // Load service point DER
                JsonNode derEl = servicePointEl.path("der");
                if (derEl.isObject()) {
                    LOGGER.info("Loading DER of service point: {}", servicePoint.getServicePointId());
                    EnergyDerRecord der = objectMapper.treeToValue(derEl, EnergyDerRecord.class);
                    energyDerRecordRepository.save(der);
                }
            }
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
