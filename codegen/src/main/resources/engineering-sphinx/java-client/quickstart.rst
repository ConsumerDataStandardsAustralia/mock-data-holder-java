Client Library Quick Start
---------------------------------

.. start-content

Requirements
^^^^^^^^^^^^^^^^^^^^^^^

Using the CDS Java based Client Library requires:

    1. Java 1.8+
    2. Maven/Gradle

Installation
^^^^^^^^^^^^^^^^^^^^^^^

To deploy the client library into your local Maven cache from source run:

.. code-block:: bash

   user@cds:~/git$ git clone https://github.com/ConsumerDataStandardsAustralia/cds-client-java
   user@cds:~/git$ cd cds-client-java
   user@cds:~/git/cds-client-java$ mvn clean install

To integrate into your Maven project add this dependency to your project's POM:

.. code-block:: xml

    <dependency>
      <groupId>au.org.consumerdatastandards</groupId>
      <artifactId>cds-client-java</artifactId>
      <version>$mavenJavaClientVersion</version>
      <scope>compile</scope>
    </dependency>

To integrate into your Gradle project, add this dependency to your project's build file:

.. code-block:: groovy

    repositories {
        mavenCentral()
    }

   compile "au.org.consumerdatastandards:cds-client-java:$mavenJavaClientVersion"

Code Example
^^^^^^^^^^^^^^^^^^^^^^^

Please follow the installation instructions then, within your Java project create your code as follows:

.. code-block:: java

    import java.util.UUID;    
    import au.org.consumerdatastandards.client.ApiClient;
    import au.org.consumerdatastandards.client.ApiException;
    import au.org.consumerdatastandards.client.api.BankingProductsAPI;
    import au.org.consumerdatastandards.client.model.ResponseBankingProductById;
    import au.org.consumerdatastandards.client.model.ResponseBankingProductList;
    
    public class ClientApiProductTest {
        public static void main(String[] args) {
            BankingProductsAPI api = new BankingProductsAPI(); 
            
            ApiClient client = new ApiClient();
            client.setBasePath("http://localhost:8080/cds-au/v1");
            client.addDefaultHeader("x-v", "1");
            client.addDefaultHeader("x-min-v", "1");
            client.addDefaultHeader("x-fapi-financial-id", "cds");
            client.addDefaultHeader("x-fapi-customer-last-logged-time", "");
            client.addDefaultHeader("x-fapi-customer-ip-address", "192.168.1.2");
            client.addDefaultHeader("x-fapi-interaction-id", UUID.randomUUID().toString());
            
            api.setApiClient(client);
            
            try {
                ResponseBankingProductList result = api.listProducts(null, null, null, null, null, null);
                
                result.getData().getProducts().forEach(oneProduct -> {
                    try {
                        ResponseBankingProductById productDetail = api.getProductDetail(oneProduct.getProductId());
                        System.out.println(productDetail);
                } catch (ApiException e) {
                    System.err.println(String.format("Exception when calling BankingProductsAPI#getProductDetail({})", oneProduct.getProductId()));
                    e.printStackTrace();
                }
                 
                });
            } catch (ApiException e) {
                System.err.println("Exception when calling BankingProductsAPI#listProducts");
                e.printStackTrace();
            }
       }
    }

