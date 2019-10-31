# Engineering Testing Tools - Contributor's Guide - Quick Start

All Engineering artefacts can be found here in the Engineering [Repo](https://github.com/ConsumerDataStandardsAustralia/java-artefacts).

# Reference Client
The reference client ([client-cli](https://github.com/ConsumerDataStandardsAustralia/java-artefacts/tree/master/client-cli) is intended as a working model of a Data Recipient. It can be used by DHs as a test client or by DRs as a reference implementation. Future releases of this tool will be extended to incorporate support for the InfoSec profile.

# Parameterized Test Tool (PTT)

The Parameterized Test Tool is a testing framework built to assist DHs and DRs validate their implementations. It is built upon the JUnit and [Serenity](http://thucydides.info/docs/serenity-staging/#first-steps) testing frameworks, and has been designed to be easily extended and customised.

The tool takes input from parameter files, makes requests to the Standards API endpoints using parameters from these files, and then validates responses. (Currently only Product endpoints are supported).

The PTT validates the structure of payloads returned from a DH, confirming that they meet the schema as defined by the Standards.

The source code for the tool can be found [here](https://github.com/ConsumerDataStandardsAustralia/java-artefacts/tree/master/reference-test).

## Sample Implementations
The PTT has sample tests included, which demonstrate how more complex testing could be implemented.

### Get Product Detail Test
This [test](https://github.com/ConsumerDataStandardsAustralia/java-artefacts/blob/master/reference-test/src/test/java/au/org/consumerdatastandards/conformance/GetProductDetailTest.java) lists all products and validates response payloads.

### List Products Test
This [test](https://github.com/ConsumerDataStandardsAustralia/java-artefacts/blob/master/reference-test/src/test/java/au/org/consumerdatastandards/conformance/ListProductsTest.java) utilises a Serenity Parameterized Runner to read input parameters from the file `testdata/banking-products-api-params.csv` (found [here](https://github.com/ConsumerDataStandardsAustralia/java-artefacts/tree/master/reference-test/src/test/resources/testdata) and iterates through each row in the file, making a request with the given parameters and validating the response.
