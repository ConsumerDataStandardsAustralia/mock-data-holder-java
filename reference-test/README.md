# cds-conformance [![Build Status](https://travis-ci.com/ConsumerDataStandardsAustralia/cds-conformance.svg?branch=master)](https://travis-ci.com/ConsumerDataStandardsAustralia/cds-conformance)
 
***These are not official conformance tests for the regime.*** 

#### Software requirements

1. Java 8
2. Maven 3

This test suite is provided by the CDS engineering team and serves two purposes:

1. It provides basic reference tests against Open Banking API endpoints to the best of CDS engineering team's knowledge. The tests can be run with
```mvn verify -DapiBase=http://localhost/cds-au/v1``` You can replace `http://localhost/cds-au/v1` 
with any open banking API endpoint.

2. It is a library which does payload verification. [cds-java-client-cli](https://github.com/ConsumerDataStandardsAustralia/cds-client-java-cli)
is an example of that.

The tests are provided under the MIT license.
