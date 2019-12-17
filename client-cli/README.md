# client-cli

CDS Client (Data Recipient) CLI

### Software requirements

* java 8
* maven 3

### Get started

Open a terminal and execute command
`mvn spring-boot:run` 

When you see `cds-shell:>`, type `help` and you'll see something like this 

<pre>
AVAILABLE COMMANDS

BankingAccounts
        get-account-detail: Get account detail
        get-transaction-detail: Get transaction detail
        get-transactions: Get transactions
        list-accounts: List accounts
        list-balance: List balance
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
        exit, quit: Exit the shell.
        help: Display help about available commands.
        history: Display or save the history of previously run commands
        script: Read and execute commands from a file.
        stacktrace: Display the full stacktrace of the last error.

Common Functions
        access-token: Set access token to send as the Authorization: Bearer header
        client-id: Set client ID registered on the Auth Server
        disable-mtls: Disable MTLS
        enable-client-debug: Enable client debug
        enable-mtls: Enable MTLS
        get-access-token: Get currently set access token. The refresh token flow can update access token.
        get-auth-server: Get configured OIDC Server base URL
        get-client-debug: Client debug enabled
        get-client-id: Get client ID
        get-jwks-path: Get JWKS keystore file path
        get-log-level: Retrieve current minimum log level
        get-refresh-token: Get refresh token
        get-user-agent: Get browser user-agent
        jwks-path: Set JWKS keystore file path
        proxy: Set proxy, e.g. http://http-proxy:8080, https://https-proxy:8443, socks://socks-proxy:5050, none
        refresh-token: Set refresh token. The access token, if set and valid, takes precedence.
        server: Set CDS server URL, e.g. http://data.holder/cds-au/v1
        set-auth-server: Set the base URL of the OIDC Server
        set-log-level: Setup minimum log level, default is INFO
        set-user-agent: Set browser user-agent
        setup-mtls: Setup client certificate and CA to enable MTLS connection to the server
        verifying-ssl: Set verifyingSsl, e.g. true, false

CommonCustomer
        get-customer: Get customer
        get-customer-detail: Get customer detail

CommonDiscovery
        get-outages: Get outages
        get-status: Get status

Reference Testing
        auto-validate: Validate all Payloads Automatically
        list-payload-models: List top-level payload models
        payload-validation-status: Retrieve current conformance check status
        validate-path: Validate json payload(s) against CDS
</pre>
