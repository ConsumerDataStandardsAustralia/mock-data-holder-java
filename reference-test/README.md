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

The endpoints requiring authenticated context (protected endpoints) need the access token
set in `src/test/resources/ptt.properties`. Alternatively, a refresh token can be configured there. If both
`access.token` and `refresh.token` are configured, the configured access token will first be attempted to use in
the tests - its validity is checked against the introspection endpoint of the configured `auth.server`.
If either `auth.server` or `refresh.token` are not configured then the access token validity is not checked and
the refresh token flow is not enabled.

Also the MTLS keystore/truststore can be configured in `src/test/resources/ptt.properties` for the MTLS-enabled connection.
The keystore format is the standard Java JKS key store file containing the MTLS private key and certificate.

The tests are provided under the MIT license.
