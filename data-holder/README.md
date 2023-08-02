# Data Holder


## Overview  

We have added ORM (JPA) support with H2 as database, in order to demonstrate 
an end-to-end implementation of the API endpoints.

We have also added HTTP header processing according to [the HTTP header spec](https://consumerdatastandardsaustralia.github.io/standards/#http-headers)

## Run locally-built data-holder

The server will be accessible on port 8383.

    java -jar target/data-holder-x.x.x.jar

The data will be loaded from the _payloads_ directory.

If you want to pass a [test data file](https://github.com/ConsumerDataStandardsAustralia/testdata-cli) to be loaded at start up:

    java -jar target/data-holder-x.x.x.jar /your/local/path/to/testdata-cli/samples/output/u1-output.json

Where `x.x.x` is the version, say, `1.24.0`

## Docker

Run the image from DockerHub:

    docker run -p 8383:8383 consumerdatastandardsaustralia/data-holder:x.x.x

or, if you want to point to your own keystore:

    docker run -p 8383:8383 -v /your/local/path/to/java-artefacts/data-holder/keystore:/keystore consumerdatastandardsaustralia/data-holder:x.x.x

If you want to pass a [test data file](https://github.com/ConsumerDataStandardsAustralia/testdata-cli) to be loaded at start up:

    docker run -p 8383:8383 -v /your/local/path/to/testdata-cli/samples/output/u1-output.json:/testdata/u1-output.json consumerdatastandardsaustralia/data-holder:x.x.x /testdata/u1-output.json

Where `x.x.x` is the version, say, `1.24.0`

Run locally-built image:

    docker run -p 8383:8383 consumerdatastandardsaustralia/data-holder:1.24.1-SNAPSHOT
