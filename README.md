# java-artefacts
[![Build Status](https://travis-ci.org/ConsumerDataStandardsAustralia/java-artefacts.svg?branch=master)](https://travis-ci.org/ConsumerDataStandardsAustralia/java-artefacts)
[![license](https://img.shields.io/github/license/ConsumerDataStandardsAustralia/java-artefacts)](https://github.com/ConsumerDataStandardsAustralia/java-artefacts/blob/master/LICENSE)
[![version](https://img.shields.io/github/v/tag/ConsumerDataStandardsAustralia/java-artefacts.svg)](https://github.com/ConsumerDataStandardsAustralia/java-artefacts/releases/latest)
[![issues](https://img.shields.io/github/issues/ConsumerDataStandardsAustralia/java-artefacts)](https://github.com/ConsumerDataStandardsAustralia/java-artefacts/issues)

## Disclaimer
This collection of Australian Consumer Data Right (CDR) software artefacts includes code written in Java.

The artefacts in this repo are offered without warranty or liability, in accordance with the [MIT licence.](https://github.com/ConsumerDataStandardsAustralia/java-artefacts/blob/master/LICENSE)

[The Data Standards Body](https://www.csiro.au/en/News/News-releases/2018/Data61-appointed-to-Data-Standards-Body-role)
(DSB) develops these artefacts in the course of its work, in order to perform quality assurance on the Australian Consumer Data Right Standards (Data Standards).

The DSB makes this repo, and its artefacts, public [on a non-commercial basis](https://github.com/ConsumerDataStandardsAustralia/java-artefacts/blob/master/LICENSE)
in the interest of supporting the participants in the CDR eco-system.

The resources of the DSB are primarily directed towards assisting the [Data Standards Chair](https://consumerdatastandards.gov.au/about/)
for [developing the Data Standards](https://github.com/ConsumerDataStandardsAustralia/standards).

Consequently, the development work provided on the artefacts in this repo is on a best-effort basis,
and the DSB acknowledges the use of these tools alone is not sufficient for, nor should they be relied upon
with respect to [accreditation](https://www.accc.gov.au/focus-areas/consumer-data-right-cdr-0/cdr-draft-accreditation-guidelines),
conformance, or compliance purposes.

## Software requirements

To run the artefacts, you need to install

* Java 8
* Maven 3

## How to Build

Navigate to the project folder and execute

    mvn install --projects !integration-test

or, if you want to skip the Docker image build step:

    mvn install -Ddockerfile.skip=true --projects !integration-test

The `--projects !integration-test` parameter skips running of the integration tests.
You can ommit this parameter if you've built the current version of the project once before and
the `data-holder` is running, so the tests can be run agains it.

## Unit tests

The Maven `install` command runs unit tests as a part of the build.
You can re-run the tests any time with:

    mvn test

## Included Modules

- [client](client/README.md) - Java library, reference Implementation of CDS client (Accredited Data Recipient - ADR). Used by client-cli and integration-test
- [client-cli](client-cli/README.md) - Command Line Interface tool to access Data Holder endpoints.
- [integration-test](integration-test/README.md) - Integration tests to run against Data Holder endpoints.
- [data-holder](data-holder/README.md) - Reference Implementation of CDS server (Data Holder).

## Rules of engagement

Contributions to this [open source project](https://github.com/ConsumerDataStandardsAustralia/java-artefacts/blob/master/LICENSE)
are made by raising issues and contributing code through pull requests.

We ask that all contributors to the Australian Consumer Data Standards repositories comply with the
[GitHub Community Forum Code of Conduct](https://help.github.com/articles/github-community-forum-code-of-conduct/).
