# client-cli

CDS Client (Data Recipient) CLI

### Software requirements

* java 8
* maven 3

### Get started

Open a terminal, cd to the `java-artefacts/client-cli` directory and execute command

    mvn spring-boot:run

or

    mvn spring-boot:run -Dserver=http://data.holder/cds-au/v1

When you see `cds-shell:>`, type `help` (see the Command Reference below)

### Docker

Run the image from DockerHub:

    docker run -p 8686:8686 -it consumerdatastandardsaustralia/client-cli:x.x.x

or, if you want to point to your own keystore:

    docker run -p 8686:8686 -it -v /your/local/path/to/java-artefacts/client-cli/keystore:/keystore consumerdatastandardsaustralia/client-cli:x.x.x
    
Where `x.x.x` is the version, say, `2.1.0`

Run locally-built image:

    docker run -p 8383:8383 consumerdatastandardsaustralia/data-holder:2.1.1-SNAPSHOT

### Command Reference

The following is the output of the `help` command.
For more information execute

    help <command>
    
For instance:

    help list-products

<pre>
AVAILABLE COMMANDS

Auth- and security-related Functions
        access-token: Set access token to send as the Authorization: Bearer header (Property: access.token)
        auth-server: Set the base URL of the OIDC Server (Property: auth.server)
        client-id: Set client ID registered on the Auth Server (Property: client.id)
        disable-mtls: Disable MTLS
        enable-mtls: Enable MTLS
        get-access-token: Get currently set access token. The refresh token flow can update access token.
        get-auth-server: Get configured OIDC Server base URL
        get-client-id: Get client ID
        get-jwks-path: Get JWKS keystore file path
        get-refresh-token: Get refresh token
        jwks-path: Set JWKS keystore file path (Property: jwks.path)
        refresh-token: Set refresh token. The access token, if set and valid, takes precedence. (Property: refresh.token)
        setup-mtls: Setup client certificate and CA to enable MTLS connection to the server
        unset-access-token: Unset access token
        unset-refresh-token: Unset refresh token
        verifying-ssl: Set verifyingSsl, e.g. true, false

BankingAccounts
        get-account-detail: Get account detail
        get-balance: Get balance
        get-transaction-detail: Get transaction detail
        get-transactions: Get transactions
        list-accounts: List accounts
        list-balances-bulk: Obtain balances for multiple, filtered accounts
        list-balances-specific-accounts: List balances specific accounts

BankingDirectDebits
        list-direct-debits: List direct debits
        list-direct-debits-bulk: Obtain balances for multiple, filtered accounts
        list-direct-debits-specific-accounts: List direct debits specific accounts

BankingPayees
        get-payee-detail: Get payee detail
        list-payees: List payees

BankingProducts
        get-product-detail: Get product detail
        list-products: List products

BankingScheduledPayments
        list-scheduled-payments: List scheduled payments
        list-scheduled-payments-specific-accounts: List scheduled payments specific accounts

Built-In Commands
        clear: Clear the shell screen.
        help: Display help about available commands.
        history: Display or save the history of previously run commands
        script: Read and execute commands from a file.
        stacktrace: Display the full stacktrace of the last error.

Common Functions
        enable-client-debug: Enable client debug
        get-client-debug: Client debug enabled
        get-log-level: Retrieve current minimum log level
        get-user-agent: Get browser user-agent
        proxy: Set proxy, e.g. http://http-proxy:8080, https://https-proxy:8443, socks://socks-proxy:5050, none (Property: proxy)
        server: Set CDS server URL, e.g. http://data.holder/cds-au/v1 (Property: server)
        set-log-level: Setup minimum log level, default is INFO
        set-user-agent: Set browser user-agent. Sent in User-Agent and x-cds-client-headers HTTP headers. Default is Client CLI (Property: user.agent)

CommonCustomer
        get-customer: Get customer
        get-customer-detail: Get customer detail

CommonDiscovery
        get-outages: Get outages
        get-status: Get status

EnergyAccounts
        get-balance-for-energy-account: Get balance for Energy account
        get-billing-for-energy-account: Get billing for Energy account
        get-energy-account-detail: Get Energy account detail
        get-energy-concessions: Get Energy concessions
        get-energy-payment-schedule: Get agreed Energy payment schedule
        get-invoices-for-energy-account: Get invoices for Energy account
        list-balances-for-energy-accounts: Get balances for specific Energy accounts
        list-billing-for-energy-accounts: Get billing for specific Energy accounts
        list-energy-accounts: List Energy accounts
        list-energy-balances-bulk: Get bulk balances for Energy
        list-energy-billing-bulk: Get Energy bulk billing
        list-energy-invoices-bulk: Get bulk Energy invoices
        list-invoices-for-energy-accounts: Get invoices for specific Energy accounts

EnergyPlans
        get-generic-energy-plan-detail: Get generic Energy plan detail
        list-generic-energy-plans: List generic Energy plans

EnergyServicePoints
        get-energy-service-point-detail: Get Energy service point detail
        get-energy-usage-for-service-point: Get Energy usage for service point
        list-der-for-energy-service-point: Get DER for Energy service point
        list-der-for-energy-service-points: Get DER for specific Energy service points
        list-energy-der-bulk: Get bulk Energy DER
        list-energy-service-points: List Energy service points
        list-energy-usage-bulk: Get bulk Energy usage
        list-usage-for-energy-service-points: Get usage for specific Energy service points

Exit Command
        exit, quit: Exit Client CLI.

Reference Testing
        auto-validate: Validate all Payloads Automatically
        list-payload-models: List top-level payload models
        payload-validation-status: Retrieve current conformance check status
        validate-path: Validate json payload(s) against CDS

TelcoAccounts
        get-balance-for-telco-account: Get balance for Telco account
        get-invoices-for-telco-account: Get invoices for Telco account
        get-telco-account-detail: Get Telco account detail
        get-telco-concessions: Get Telco concessions
        get-telco-payment-schedule: Get Telco agreed payment schedule
        list-balances-for-telco-accounts: Get balances for specific Telco accounts
        list-invoices-for-telco-accounts: Get invoices for specific Telco accounts
        list-telco-accounts: List Telco accounts
        list-telco-balances-bulk: Get bulk Telco balances
        list-telco-invoices-bulk: Get bulk Telco invoices

TelcoProducts
        get-telco-product-detail: Get Telco product detail
        list-telco-products: List Telco products

TelcoUsage
        get-usage-for-telco-service: Get usage for Telco service
        list-telco-usage: List Telco usage
        list-usage-for-telco-service: Get usage for specific Telco service
</pre>

The properties associated with select commands can be set in the command line, e.g. -Dproperty.name=property_value
or in the application.properties file before launching the application with `mvn spring-boot:run` or with `java`.

Example:

    java -Dserver=http://localhost:8383/cds-au/v1 -jar target/client-cli-2.1.0.jar

or

    java -Dserver=http://localhost:8383/cds-au/v1 -jar target/client-cli-2.1.1-SNAPSHOT.jar