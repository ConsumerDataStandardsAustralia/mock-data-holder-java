FROM openjdk:8-jdk-stretch
MAINTAINER Data61 <cdr-data61@csiro.au>

EXPOSE 8000/tcp

ADD . /opt/cds-java-artefacts/reference-test

WORKDIR /opt/cds-java-artefacts/reference-test

RUN apt-get update
RUN apt-get -y install maven dumb-init

RUN chmod +x /opt/cds-java-artefacts/reference-test/support/docker-init.sh

ENTRYPOINT ["/opt/cds-java-artefacts/reference-test/support/docker-init.sh"]
