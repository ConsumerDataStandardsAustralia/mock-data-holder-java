Model Holder Quick Start
---------------------------------
.. start-content

Requirements
^^^^^^^^^^^^^^^^^^^^^^^

If you wish to simply run the Model Holder you only require Docker.

If you wish to build the CDS Model Holder from source, this requires:

    1. Java 1.8+
    2. Maven/Gradle

Execution
^^^^^^^^^^^^^^^^^^^^^

To start the CDS Client CLI execute the Docker command as below:

.. code-block:: bash

    user@cds:~$ docker run -p 8080:8080 $dockerHolderVersion
    
    #     ___     ___     ___
    #    / __|   |   \   / __|
    #   | (__    | |) |  \__ \
    #    \___|   |___/   |___/
    #  _|"""""|_|"""""|_|"""""|
    #  "`-0-0-'"`-0-0-'"`-0-0-'
    
    2019-05-12 00:20:19.228  INFO 1 --- [           main] a.o.c.holder.HolderApplication           : Starting HolderApplication v${mavenJavaHolderVersion} on 3b710824dcdc with PID 1 (/opt/cds-holder/holder.jar started by root in /)
    2019-05-12 00:20:19.231  INFO 1 --- [           main] a.o.c.holder.HolderApplication           : No active profile set, falling back to default profiles: default
    2019-05-12 00:20:20.143  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data repositories in DEFAULT mode.
    2019-05-12 00:20:20.233  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 80ms. Found 2 repository interfaces.
    2019-05-12 00:20:20.519  INFO 1 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$a2a7da07] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
    2019-05-12 00:20:20.840  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
    2019-05-12 00:20:20.878  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
    2019-05-12 00:20:20.878  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.17]
    2019-05-12 00:20:20.960  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
    2019-05-12 00:20:20.960  INFO 1 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1695 ms
    2019-05-12 00:20:21.188  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
    2019-05-12 00:20:21.356  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
    2019-05-12 00:20:21.416  INFO 1 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [
        name: default
        ...]
    2019-05-12 00:20:21.500  INFO 1 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.3.9.Final}
    2019-05-12 00:20:21.502  INFO 1 --- [           main] org.hibernate.cfg.Environment            : HHH000206: hibernate.properties not found
    2019-05-12 00:20:21.677  INFO 1 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.0.4.Final}
    2019-05-12 00:20:21.930  INFO 1 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
    2019-05-12 00:20:22.782  INFO 1 --- [           main] o.h.t.schema.internal.SchemaCreatorImpl  : HHH000476: Executing import script 'org.hibernate.tool.schema.internal.exec.ScriptSourceInputNonExistentImpl@50b8ae8d'
    2019-05-12 00:20:22.785  INFO 1 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
    2019-05-12 00:20:23.409  WARN 1 --- [           main] aWebConfiguration$JpaWebMvcConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
    2019-05-12 00:20:23.521  INFO 1 --- [           main] pertySourcedRequestMappingHandlerMapping : Mapped URL path [/swagger.json] onto method [public org.springframework.http.ResponseEntity<springfox.documentation.spring.web.json.Json> springfox.documentation.swagger2.web.Swagger2Controller.getDocumentation(java.lang.String,javax.servlet.http.HttpServletRequest)]
    2019-05-12 00:20:23.653  INFO 1 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
    2019-05-12 00:20:23.871  INFO 1 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed
    2019-05-12 00:20:23.891  INFO 1 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found 1 custom documentation plugin(s)
    2019-05-12 00:20:23.912  INFO 1 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
    2019-05-12 00:20:24.091  INFO 1 --- [           main] a.o.c.holder.util.CdsDataLoader          : Reading /payloads/products/xyzbank-deposit-account.json
    2019-05-12 00:20:24.271  INFO 1 --- [           main] a.o.c.holder.util.CdsDataLoader          : Saved the following to database: 
    {
        "productId": "51645",
        "effectiveFrom": "2018-01-12T15:43:00.121Z",
        "effectiveTo": "2020-04-12T15:43:00.121Z",
        <!--- snip ---!>
    }
    2019-05-12 00:20:24.338  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
    2019-05-12 00:20:24.340  INFO 1 --- [           main] a.o.c.holder.HolderApplication           : Started HolderApplication in 5.481 seconds (JVM running for 6.024)


Manual Build & Run
^^^^^^^^^^^^^^^^^^^^^^^

The ``holder-java-spring`` project is currently located within the ``cds-codegen`` repository. To manually build and run the Model Holder with Maven, run:

.. code-block:: bash

   user@cds:~/git$ git clone https://github.com/ConsumerDataStandardsAustralia/cds-codegen
   user@cds:~/git$ cd cds-codegen/support/samples/cds-holder-java-spring
   user@cds:~/git/cds-codegen/support/samples/cds-holder-java-spring$ mvn clean spring-boot


