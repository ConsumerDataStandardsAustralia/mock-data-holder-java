Client CLI Quick Start
---------------------------------

.. start-content

Requirements
^^^^^^^^^^^^^^^^^^^^^^^

If you wish to simply run the CDS Java Client CLI you only require Docker.

If you wish to build CDS Java Client CLI this requires:

    1. Java 1.8+
    2. Maven

Execution
^^^^^^^^^^^^^^^^^^^^^

To start the CDS Client CLI execute the Docker command as below:

.. code-block:: bash

    docker run -it $dockerJavaCliVersion
    
    #     ___     ___     ___
    #    / __|   |   \   / __|
    #   | (__    | |) |  \__ \
    #    \___|   |___/   |___/
    #  _|"""""|_|"""""|_|"""""|
    #  "`-0-0-'"`-0-0-'"`-0-0-'
    
    2019-05-10 04:59:15.066  INFO 1 --- [           main] a.o.c.client.cli.CdsClientShell          : Starting CdsClientShell v${mavenJavaClientVersion} on b78c5f91f96d with PID 1 (/opt/cds-client-java-cli/cli.jar started by root in /)
    2019-05-10 04:59:15.068  INFO 1 --- [           main] a.o.c.client.cli.CdsClientShell          : No active profile set, falling back to default profiles: default
    2019-05-10 04:59:15.913  INFO 1 --- [           main] a.o.c.client.cli.CdsClientShell          : Started CdsClientShell in 1.061 seconds (JVM running for 1.314)
    cds-shell:>


Manual Build & Run
^^^^^^^^^^^^^^^^^^^^^^^

To manually build the CLI using Maven, run:

.. code-block:: bash

   user@cds:~/git$ git clone https://github.com/ConsumerDataStandardsAustralia/cds-client-java-cli
   user@cds:~/git$ cd cds-client-java-cli
   user@cds:~/git/cds-client-java$ mvn clean spring-boot


