FROM openjdk:8-jre
MAINTAINER Data61 <cdr-data61@csiro.au>

ARG CONSUL_URL=https://releases.hashicorp.com/consul/1.5.1/consul_1.5.1_linux_amd64.zip

ENTRYPOINT ["/opt/cds-holder/docker-init.sh"]
EXPOSE 8080/tcp

ADD payloads           /opt/payloads
RUN apt-get update
RUN apt-get install -y apt-utils dumb-init dnsmasq

WORKDIR /opt
RUN wget -nv -O consul.zip $CONSUL_URL
RUN unzip consul.zip
RUN mv consul /usr/bin/consul

ARG JAR_FILE
ADD target/${JAR_FILE} /opt/cds-holder/holder.jar
ADD support/docker-init.sh /opt/cds-holder/docker-init.sh

