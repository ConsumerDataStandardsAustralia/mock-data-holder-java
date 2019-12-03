# reference-test
 
#### Software requirements

1. Java 8
2. Maven 3

This test suite is provided by the CDS engineering team and serves two purposes:

1. It provides basic reference tests against Open Banking API endpoints to the best of CDS engineering team's knowledge. The tests can be run with
```mvn verify -DapiBase=http://localhost/cds-au/v1``` You can replace `http://localhost/cds-au/v1` 
with any open banking API endpoint.

2. It is a library which does payload verification. [client-cli](https://github.com/ConsumerDataStandardsAustralia/java-artefacts/blob/master/client-cli)
is an example of that.

The endpoints requiring authenticated context (protected endpoints) need the JWT access token
set in `src/test/resources/ptt.properties`. Also the MTLS keystore/truststore can be configured there for the MTLS-enabled connection.
The keystore format is the standard Java JKS key store file containing the MTLS private key and certificate.

The tests are provided under the MIT license.
