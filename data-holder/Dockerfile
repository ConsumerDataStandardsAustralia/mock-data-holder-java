FROM openjdk:8-jre
LABEL maintainer="Data Standards Body <technical@consumerdatastandards.gov.au>"

EXPOSE 8383/tcp

ADD payloads /payloads
ADD keystore /keystore
ARG JAR_FILE
ADD target/${JAR_FILE} /opt/cds-java-artefacts/data-holder.jar

ENTRYPOINT ["/usr/local/openjdk-8/bin/java", "-jar", "/opt/cds-java-artefacts/data-holder.jar"]

