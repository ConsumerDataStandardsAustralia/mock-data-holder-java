FROM openjdk:8-jre
MAINTAINER Data61 <cdr-data61@csiro.au>

EXPOSE 8080/tcp

ARG JAR_FILE
ADD target/${JAR_FILE} /opt/cds-java-artefacts/data-holder.jar
ADD payloads /opt/payloads

ENTRYPOINT ["/usr/local/openjdk-8/bin/java", "-jar", "/opt/cds-java-artefacts/data-holder.jar"]

