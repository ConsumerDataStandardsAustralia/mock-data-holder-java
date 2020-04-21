# integration-test
 
#### Summary

Calls data holder. The data holder base URL is configured in `src/test/resources/it.properties`.

#### Configuration

The endpoints requiring authenticated context (protected endpoints) need the access token
set in `src/test/resources/it.properties`. Alternatively, a refresh token can be configured there. If both
`access.token` and `refresh.token` are configured, then the access token is ignored and the refresh token is used to
acquire a new access token from the configured `auth.server`. If either `auth.server` or `refresh.token` are not
configured then the refresh token flow is not enabled and the configured access token is always used.

Also the MTLS keystore/truststore can be configured in `src/test/resources/it.properties` for the MTLS-enabled connection.
The keystore format is the standard Java JKS key store file containing the MTLS private key and certificate.

#### Running tests

Make sure the [data-holder](../data-holder/README.md) is started and is available at the URL configured in `src/test/resources/it.properties` ("server")

Use Maven to run the tests - in the `integration-test` directory:

    mvn verify

The tests are provided under the MIT license.