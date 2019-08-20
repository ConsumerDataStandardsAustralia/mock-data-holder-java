
.. _cds-client-java:

CDS Java Client Library (cds-client-java)
================================================

+---------------------+---------------------------------------------------------------------------------------+
| Summary             | The Java Client Library is intended for integration into :term:`Data Recipient`\'s    |
|                     | software deployments as part of delivering their product or service. It is intended as|
|                     | a :term:`Reference Implementation` of the :term:`Consumer Data Standards` from a      |
|                     | :term:`Data Recipient` ("client") perspective.                                        |
+---------------------+---------------------------------------------------------------------------------------+
| Repositories        | `GitHub`_                                                                             |
|                     |                                                                                       |
+---------------------+---------------------------------------------------------------------------------------+
| Release Status      | Beta                                                                                  |
+---------------------+---------------------------------------------------------------------------------------+
| Generation Status   | Automatic from :ref:`cds-codegen`                                                     |
+---------------------+---------------------------------------------------------------------------------------+
| Verified Snapshot   | $StringUtils.rightPad($mavenJavaClientVersion,49)                                     |
| Snapshot            |                                                                                       |
+---------------------+---------------------------------------------------------------------------------------+
| Technologies Used   | * Java                                                                                |
|                     | * Maven                                                                               |
+---------------------+---------------------------------------------------------------------------------------+

.. _GitHub: https://github.com/ConsumerDataStandardsAustralia/cds-client-java

Quick Start
-----------------

.. include:: quickstart.rst
   :start-after: start-content

Endpoints
------------------------------

All URIs are relative to `$baseUri <$baseUri>`__

.. list-table::
    :widths: 10 5 50 10
    :header-rows: 1

    * - Class
      - Method
      - HTTP Request
      - Description
#foreach($section in $cds.getSectionModels())
    #foreach($endpoint in $section.getEndpointModels())
    #parse("common/endpointdefinition.vm")
    * - $section.getName()
      - `$endpointOperationId <sections/${section.getInterfaceName()}.html#$StringUtils.lowerCase($endpointOperationId)>`__
      - **$endpointMethod** $endpointPath
      - $endpointSummary
    #end
#end

.. toctree::
   :hidden:
   :glob:
  
#foreach($section in $cds.getSectionModels())
   sections/${section.getInterfaceName()}    
#end   

Models
-------------------------------

.. toctree::
   :glob:
   :titlesonly:
   
#foreach($oneDataDefinition in $cds.getDataDefinitions())
   model/${oneDataDefinition.getSimpleName()}
#end

