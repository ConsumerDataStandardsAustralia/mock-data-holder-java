#!/usr/bin/dumb-init /bin/bash

for i in "$@"
do
	case $i in
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

