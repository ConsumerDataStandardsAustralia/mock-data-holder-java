# java-artefacts
[![Build Status](https://travis-ci.org/ConsumerDataStandardsAustralia/java-artefacts.svg?branch=master)](https://travis-ci.org/ConsumerDataStandardsAustralia/java-artefacts)
[![license](https://img.shields.io/github/license/ConsumerDataStandardsAustralia/java-artefacts)](https://github.com/ConsumerDataStandardsAustralia/java-artefacts/blob/master/LICENSE)
[![version](https://img.shields.io/github/v/tag/ConsumerDataStandardsAustralia/java-artefacts.svg)](https://github.com/ConsumerDataStandardsAustralia/java-artefacts/releases/latest)
[![issues](https://img.shields.io/github/issues/ConsumerDataStandardsAustralia/java-artefacts)](https://github.com/ConsumerDataStandardsAustralia/java-artefacts/issues)

This is collection of CDS software artefacts in Java programming language.

## Software requirements

To run the artefacts, you need to install

* Java 8
* Maven 3

## How to Build

Navigate to the project folder and execute

    mvn install

or, if you want to skip the Docker image build step:

    mvn install -Ddockerfile.skip=true

## Unit tests

The Maven `install` command runs unit tests as a part of the build.
You can re-run the tests any time with:

    mvn test

## Rules of engagement

CDS Engineering team welcome everyone contribute to the open source project by raising issues and contributing code through pull requests.

We ask that all contributors to the Consumer Data Standards repositories comply with the [GitHub Community Forum Code of Conduct](https://help.github.com/articles/github-community-forum-code-of-conduct/).
