Code Generator
---------------------------------

.. start-content

Requirements
^^^^^^^^^^^^^^^^^^^^^^^

If you wish to simply run the CDS Code Generator you only require Docker.

If you wish to build CDS Codegen this requires:

    1. Java 1.8+
    2. Maven

Execution with Docker
^^^^^^^^^^^^^^^^^^^^^^^^^

To start the CDS Codegen execute the Docker command as below:

.. code-block:: bash

    user@cds:~$ docker run -it $dockerCodegenVersion -h
    Usage: <main class> [options]
      Options:
        --generator, -g
          Class name of cds-codegen generator
          Default: au.org.consumerdatastandards.codegen.generator.openapi.SwaggerGenerator
        --included, -i
          Include Section (comma separated)
        --excluded, -e
          Exclude Section (comma separated)
        --help, -?, -h
    
        --output-file, -o
          Output file to place generated swagger


Manual Build & Run
^^^^^^^^^^^^^^^^^^^^^^^

To manually build and run the CDS Code Generator using Maven, run:

.. code-block:: bash

   user@cds:~/git$ git clone https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
   user@cds:~/git$ cd cds-codegen/modules/cds-codegen-core
   user@cds:~/git/cds-codegen/modules/cds-codegen-core$ mvn clean package
   user@cds:~/git/cds-codegen/modules/cds-codegen-core$ java -jar target/cds-codegen-core-${mavenCodegenVersion}.jar  -h
   


