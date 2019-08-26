# cds-client-java-cli [![Build Status](https://travis-ci.com/ConsumerDataStandardsAustralia/cds-client-java-cli.svg?branch=master)](https://travis-ci.com/ConsumerDataStandardsAustralia/cds-client-java-cli)

CDS Client (Data Recipient) CLI

### Software requirements

* java 8
* maven 3.x

### Get started

Open a terminal and execute command
`mvn spring-boot:run` 

When you see `cds-shell:>`, type `help` and you'll see something like this 

<pre>
AVAILABLE COMMANDS

Built-In Commands
        clear: Clear the shell screen.
        exit, quit: Exit the shell.
        help: Display help about available commands.
        history: Display or save the history of previously run commands
        script: Read and execute commands from a file.
        stacktrace: Display the full stacktrace of the last error.

Common Functions
        client-debug-enable: Enable client debugging
        get-client-debug: Client debug enabled
        get-log-level: Retrieve current minimum log level
        get-user-agent: Get browser user-agent
        server: Set CDS server URL, e.g. http://data.holder/cds-au/v1
        set-log-level: Setup minimum log level, default is INFO
        set-user-agent: Set browser user-agent

Conformance Testing
        auto-validate: Validate all Payloads Automatically
        conformance-status: Retrieve current conformance check status
        validate-path: Validate json payload(s) against cds-models

Discovery Functions
        get-holder: Discover Holder Information
        get-register-endpoint: Get Register Endpoint URI
        list-holders: List Holders in Registry
        set-register-endpoint: Set Register Endpoint URI
        setup-holder: Setup Holder as Endpoint to Query

Products API
        get-product-detail: Get Product Detail
        list-products: List Products
</pre>