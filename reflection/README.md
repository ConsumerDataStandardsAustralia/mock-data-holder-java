# reflection
Java reflection is key to artefacts such as codegen and reference-test , as they need to get meta data from 
api-model to achieve their goals (generate code out of api-model and do reference test against cds data holders API implementation)

Even though there are various open source reflection libs on the market, none of them provide all 
the functions codegen and reference-test require. E.g., codegen needs to get the element type of a collection.
Hence we create reflection to provide a utility class whose functions are complimentary to existing reflection libs.

## Unit tests

To run unit tests of reflection, navigate to reflection folder and execute

```mvn test``` 
