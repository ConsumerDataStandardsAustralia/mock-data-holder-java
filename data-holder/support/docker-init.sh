#!/usr/bin/dumb-init /bin/bash

for i in "$@"
do
	case $i in
		--consulmaster=*)
		    CONSUL_MASTER=`echo $i | sed 's/[-a-zA-Z0-9\.]*=//'`
		;;
        --consul.enabled=*)
            CONSUL_ENABLED=`echo $i | sed 's/[-a-zA-Z0-9\.]*=//'`
        ;;		
		*)
		;;
	esac
done

if [ "$CONSUL_ENABLED" == true ]
    then
        # Configure dns
        cp /etc/resolv.conf /etc/resolv.conf.dnsmasq
        echo "search service.dc1.consul." > /etc/resolv.conf
        echo "nameserver 127.0.0.1" >> /etc/resolv.conf
        /usr/sbin/dnsmasq --server=/consul/127.0.0.1#8600 -r /etc/resolv.conf.dnsmasq -u root        
        mkdir -p /opt/consul
        /usr/bin/consul agent -join=$CONSUL_MASTER -data-dir=/opt/consul &
        sleep 5
        /usr/bin/consul info
    fi

/usr/local/openjdk-8/bin/java -jar /opt/cds-holder/holder.jar $@

