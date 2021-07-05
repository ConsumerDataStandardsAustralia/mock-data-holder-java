# Data Holder


## Overview  

We have added ORM (JPA) support with H2 as database, in order to demonstrate 
an end-to-end implementation of the API endpoints.

We have also added HTTP header processing according to [the HTTP header spec](https://consumerdatastandardsaustralia.github.io/standards/#http-headers)

## Docker

Run the image from DockerHub:

    docker run -p 8383:8383 consumerdatastandardsaustralia/data-holder:x.x.x

or, if you want to point to your own keystore:

    docker run -p 8383:8383 -v /your/local/path/to/java-artefacts/data-holder/keystore:/keystore consumerdatastandardsaustralia/data-holder:x.x.x

Where `x.x.x` is the version, say, `1.11.0`

Run locally-built image:

    docker run -p 8383:8383 consumerdatastandardsaustralia/data-holder:1.11.1-SNAPSHOT
