Java+Spring Stubs Quick Start
---------------------------------
.. start-content

Requirements
^^^^^^^^^^^^^^^^^^^^^^^

The Stubs provide a starting point for anyone wishing to develop a :term:`Data Holder`.

The Stubs are based on the following stack:

    1. Java 1.8+
    2. Maven
    3. Spring Boot >= 2.1.4-RELEASE
    4. Springfox Swagger Integration >= 2.9.2

Starting a Project
^^^^^^^^^^^^^^^^^^^^^

As outlined the Stubs are a starting point for a project only. They intentionally do not attempt to provide responses other than null padded objects.

Because the Stubs are intended to be a starter project we recommend cloning then deleting the .git directory before proceeding with your own modifications.

.. code-block:: bash

   user@cds:~/git$ git clone https://github.com/ConsumerDataStandardsAustralia/cds-stubs-java
   user@cds:~/git$ cd cds-stubs-java
   user@cds:~/git/cds-stubs-java$ rm -fr .git
   user@cds:~/git/cds-stubs-java$ mvn clean spring-boot
   user@cds:~/git/cds-stubs-java$ mvn clean spring-boot:run
    [INFO] Scanning for projects...
    [INFO] 
    [INFO] ------------< au.org.consumerdatastandards:cds-stubs-java >-------------
    [INFO] Building cds-stubs-java $mavenJavaStubsVersion
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO] 
    [INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ cds-stubs-java ---
    [INFO] Deleting /tmp/testit/target
    [INFO] 
    [INFO] >>> spring-boot-maven-plugin:2.1.4.RELEASE:run (default-cli) > test-compile @ cds-stubs-java >>>
    [INFO] 
    [INFO] --- build-helper-maven-plugin:3.0.0:add-source (default) @ cds-stubs-java ---
    [INFO] Source directory: /tmp/testit/src/gen/java added.
    [INFO] Source directory: /tmp/testit/src/main/java added.
    [INFO] 
    [INFO] --- maven-resources-plugin:3.1.0:resources (default-resources) @ cds-stubs-java ---
    [INFO] Using 'UTF-8' encoding to copy filtered resources.
    [INFO] Copying 0 resource
    [INFO] Copying 1 resource
    [INFO] 
    [INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ cds-stubs-java ---
    [INFO] Changes detected - recompiling the module!
    [INFO] Compiling 44 source files to /tmp/testit/target/classes
    [INFO] 
    [INFO] --- maven-resources-plugin:3.1.0:testResources (default-testResources) @ cds-stubs-java ---
    [INFO] Using 'UTF-8' encoding to copy filtered resources.
    [INFO] skip non existing resourceDirectory /tmp/testit/src/test/resources
    [INFO] 
    [INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ cds-stubs-java ---
    [INFO] No sources to compile
    [INFO] 
    [INFO] <<< spring-boot-maven-plugin:2.1.4.RELEASE:run (default-cli) < test-compile @ cds-stubs-java <<<
    [INFO] 
    [INFO] 
    [INFO] --- spring-boot-maven-plugin:2.1.4.RELEASE:run (default-cli) @ cds-stubs-java ---
    
    #     ___     ___     ___
    #    / __|   |   \   / __|
    #   | (__    | |) |  \__ \
    #    \___|   |___/   |___/
    #  _|"""""|_|"""""|_|"""""|
    #  "`-0-0-'"`-0-0-'"`-0-0-'
    
    2019-05-12 11:24:01.861  INFO 14910 --- [           main] a.o.c.stubs.HolderApplication            : Starting HolderApplication on cds with PID 14910 (~/git/cds-stubs-java started by stuart in ~/git/cds-stubs-java)
    2019-05-12 11:24:01.865  INFO 14910 --- [           main] a.o.c.stubs.HolderApplication            : No active profile set, falling back to default profiles: default
    2019-05-12 11:24:02.733  INFO 14910 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data repositories in DEFAULT mode.
    2019-05-12 11:24:02.760  INFO 14910 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 21ms. Found 0 repository interfaces.
    2019-05-12 11:24:03.041  INFO 14910 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$9a622311] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
    2019-05-12 11:24:03.386  INFO 14910 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
    2019-05-12 11:24:03.411  INFO 14910 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
    2019-05-12 11:24:03.411  INFO 14910 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.17]
    2019-05-12 11:24:03.493  INFO 14910 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
    2019-05-12 11:24:03.493  INFO 14910 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1583 ms
    2019-05-12 11:24:03.626  INFO 14910 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
    2019-05-12 11:24:03.763  INFO 14910 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
    2019-05-12 11:24:03.816  INFO 14910 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [
        name: default
        ...]
    2019-05-12 11:24:03.863  INFO 14910 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.3.9.Final}
    2019-05-12 11:24:03.864  INFO 14910 --- [           main] org.hibernate.cfg.Environment            : HHH000206: hibernate.properties not found
    2019-05-12 11:24:03.973  INFO 14910 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.0.4.Final}
    2019-05-12 11:24:04.081  INFO 14910 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
    2019-05-12 11:24:04.253  INFO 14910 --- [           main] o.h.t.schema.internal.SchemaCreatorImpl  : HHH000476: Executing import script 'org.hibernate.tool.schema.internal.exec.ScriptSourceInputNonExistentImpl@329227ed'
    2019-05-12 11:24:04.256  INFO 14910 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
    2019-05-12 11:24:04.480  WARN 14910 --- [           main] aWebConfiguration$JpaWebMvcConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
    2019-05-12 11:24:04.587  INFO 14910 --- [           main] pertySourcedRequestMappingHandlerMapping : Mapped URL path [/v2/api-docs] onto method [public org.springframework.http.ResponseEntity<springfox.documentation.spring.web.json.Json> springfox.documentation.swagger2.web.Swagger2Controller.getDocumentation(java.lang.String,javax.servlet.http.HttpServletRequest)]
    2019-05-12 11:24:04.716  INFO 14910 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
    2019-05-12 11:24:04.885  INFO 14910 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed
    2019-05-12 11:24:04.905  INFO 14910 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found 1 custom documentation plugin(s)
    2019-05-12 11:24:04.932  INFO 14910 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
    2019-05-12 11:24:05.216  INFO 14910 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
    2019-05-12 11:24:05.220  INFO 14910 --- [           main] a.o.c.stubs.HolderApplication            : Started HolderApplication in 3.62 seconds (JVM running for 6.906)

