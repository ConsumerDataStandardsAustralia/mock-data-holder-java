package au.org.consumerdatastandards.conformance;

import au.org.consumerdatastandards.api.banking.models.ResponseBankingProductById;
import au.org.consumerdatastandards.api.banking.models.ResponseBankingProductList;
import au.org.consumerdatastandards.conformance.util.ConformanceUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        PayloadValidator payloadValidator = new PayloadValidator();
        Object response = ConformanceUtil.createObjectMapper().readValue(new File("/home/yan149/IdeaProjects/cds-conformance/payloads/products/51645.json"), ConformanceUtil.expandModel(ResponseBankingProductList.class));
        List<ConformanceError> erros = payloadValidator.validateResponse("http://localhost:8080/cds-au/v1/banking/products?effective=FUTURE", response, "listProducts", 200);
        for (ConformanceError error : erros) {
            System.out.println(error.getDescription());
        }
    }
}
