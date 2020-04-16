package au.org.consumerdatastandards.integration;

import au.org.consumerdatastandards.client.ApiException;
import au.org.consumerdatastandards.client.ApiResponse;
import au.org.consumerdatastandards.client.ConformanceError;
import au.org.consumerdatastandards.client.api.CommonCustomerAPI;
import au.org.consumerdatastandards.client.model.CommonOrganisationDetail;
import au.org.consumerdatastandards.client.model.CommonPersonDetail;
import au.org.consumerdatastandards.client.model.ResponseCommonCustomer;
import au.org.consumerdatastandards.client.model.ResponseCommonCustomerDetail;
import au.org.consumerdatastandards.client.model.ResponseCommonCustomerDetailData;
import au.org.consumerdatastandards.integration.utils.ResponseCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static au.org.consumerdatastandards.client.ConformanceError.Type.BROKEN_CONSTRAINT;
import static au.org.consumerdatastandards.client.ConformanceError.Type.MISSING_PROPERTY;
import static au.org.consumerdatastandards.client.model.ResponseCommonCustomerDetailData.CustomerUType.organisation;
import static au.org.consumerdatastandards.client.model.ResponseCommonCustomerDetailData.CustomerUType.person;

public class CommonCustomerIT extends ProtectedITBase {
    public CommonCustomerIT() throws IOException, ApiException {
        super(new CommonCustomerAPI());
    }

    @Test
    public void getCustomer() throws ApiException {
        ApiResponse<ResponseCommonCustomer> resp = ((CommonCustomerAPI) getAPI()).getCustomerWithHttpInfo();
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);

        checkCustomerUType(resp.getData().getData().getCustomerUType(), conformanceErrors);

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }

    private void checkCustomerUType(Object customerUType, List<ConformanceError> errors) {
        if (customerUType == null) {
            errors.add(new ConformanceError().errorType(MISSING_PROPERTY)
                    .errorField("customerUType"));
        }
    }

    @Test
    public void getCustomerDetail() throws ApiException {
        ApiResponse<ResponseCommonCustomerDetail> resp = ((CommonCustomerAPI) getAPI()).getCustomerDetailWithHttpInfo();
        Assertions.assertEquals(ResponseCode.OK.getCode(), resp.getStatusCode());
        List<ConformanceError> conformanceErrors = new ArrayList<>();
        checkResponseHeaders(resp.getHeaders(), conformanceErrors);

        ResponseCommonCustomerDetailData data = resp.getData().getData();
        ResponseCommonCustomerDetailData.CustomerUType customerUType = data.getCustomerUType();
        checkCustomerUType(customerUType, conformanceErrors);
        if (customerUType == person) {
            CommonPersonDetail person = data.getPerson();
            if (person.getPhoneNumbers() == null) {
                conformanceErrors.add(new ConformanceError().errorType(MISSING_PROPERTY)
                        .errorField("person.phoneNumbers"));
            }
            if (person.getEmailAddresses() == null) {
                conformanceErrors.add(new ConformanceError().errorType(MISSING_PROPERTY)
                        .errorField("person.emailAdresses"));
            }
            if (person.getPhysicalAddresses() == null) {
                conformanceErrors.add(new ConformanceError().errorType(MISSING_PROPERTY)
                        .errorField("person.physicalAddresses"));
            } else if (person.getPhysicalAddresses().isEmpty()) {
                conformanceErrors.add(new ConformanceError().errorType(BROKEN_CONSTRAINT)
                        .errorMessage("At least one person.physicalAddress in required"));
            }
        } else if (customerUType == organisation) {
            CommonOrganisationDetail organisation = data.getOrganisation();
            if (organisation.getPhysicalAddresses() == null) {
                conformanceErrors.add(new ConformanceError().errorType(MISSING_PROPERTY)
                        .errorField("organisation.phoneNumbers"));
            } else if (organisation.getPhysicalAddresses().isEmpty()) {
                conformanceErrors.add(new ConformanceError().errorType(BROKEN_CONSTRAINT)
                        .errorMessage("At least one organisation.physicalAddress in required"));
            }
        }

        dumpConformanceErrors(conformanceErrors);

        Assertions.assertTrue(conformanceErrors.isEmpty(),
                CONFORMANCE_ERRORS_FOUND + buildConformanceErrorsDescription(conformanceErrors));
    }
}
