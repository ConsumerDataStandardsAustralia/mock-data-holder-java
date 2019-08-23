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
                --baseUri=*)
                    TARGET_URI=`echo $i | sed 's/[-a-zA-Z0-9\.]*=//'`
                ;;
                -b=*)
                    TARGET_URI=`echo $i | sed 's/[-a-zA-Z0-9\.]*=//'`
                ;;
                -s)
                    SERVE_CONTENT=true
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


cd /opt/cds-java-artefacts/reference-test

if [ -z "$TARGET_URI" ]
then
    mvn verify -Ddockerfile.skip=true
else
    mvn verify -Ddockerfile.skip=true -DapiBase=$TARGET_URI
fi

cd target/site/serenity
if [ -z "$SERVE_CONTENT" ]
then
    echo "Content written to `pwd`"
else
    python -m SimpleHTTPServer
fi

