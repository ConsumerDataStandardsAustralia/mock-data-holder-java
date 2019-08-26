FROM openjdk:8-jre
MAINTAINER Data61 <cdr-data61@csiro.au>

ENTRYPOINT ["/usr/local/openjdk-8/bin/java", "-jar", "/opt/cds-java-artefacts/data-holder.jar"]
EXPOSE 8080/tcp

ADD payloads           /opt/payloads
RUN apt-get update
RUN apt-get install -y apt-utils dumb-init dnsmasq

ARG JAR_FILE
ADD target/${JAR_FILE} /opt/cds-holder/holder.jar

