package au.org.consumerdatastandards.client.cli;

import au.org.consumerdatastandards.client.cli.support.ApiClientOptions;
import au.org.consumerdatastandards.conformance.ConformanceError;
import au.org.consumerdatastandards.conformance.ConformanceModel;
import au.org.consumerdatastandards.conformance.Payload;
import au.org.consumerdatastandards.conformance.PayloadValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@ShellComponent
@ShellCommandGroup("Reference Testing")
public class ReferenceTest {
    
    private PayloadValidator payloadValidator = new PayloadValidator();
    
    @Autowired
    ApiClientOptions apiClientOptions;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ReferenceTest.class);
    
    @ShellMethod("Retrieve current conformance check status")
    public void payloadValidationStatus() {
        LOGGER.info("Automatic payload validation setting: {}", apiClientOptions.isValidationEnabled());
    }
    
    
    @ShellMethod("Validate all Payloads Automatically")
    public void autoValidate(@ShellOption(help = "enable or disable") String enableValidation) throws IOException {
        Boolean validateEnable = Boolean.parseBoolean(enableValidation);
        apiClientOptions.setValidationEnabled(validateEnable);
        payloadValidationStatus();
    }

    @ShellMethod("Validate json payload(s) against CDS")
    public void validatePath(@ShellOption(value = "-f", help = "payload file or folder") String fileOrFolder) throws IOException {
        
        File file = new File(fileOrFolder);
        if (!file.exists()) {
            LOGGER.error("Unable to find the specified file for validation: {}", fileOrFolder);
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File oneFile : files) {
                payloadValidator.validateFile(new File(oneFile.getAbsolutePath()));
            }
        } else {
            List<ConformanceError> payloadErrors = payloadValidator.validateFile(file);
            if(!payloadErrors.isEmpty()) {
                LOGGER.error("Encountered errors while validating: {}",file.getAbsolutePath());
                payloadErrors.forEach(e -> LOGGER.error("\n" + e.getDescription()));
            } else {
                LOGGER.info("Validation of {} successful", file.getAbsolutePath());
            }
        }
    }

    @ShellMethod("List top-level payload models")
    public void listPayloadModels() {
        Set<String> topLevelModels = new TreeSet<>();
        ConformanceModel conformanceModel = payloadValidator.getConformanceModel();
        for (Class<?> payloadModel : conformanceModel.getPayloadModels()) {
            Payload.Type payloadType = conformanceModel.getPayload(payloadModel).getPayloadType();
            if (Payload.Type.RESPONSE_BODY.equals(payloadType)) {
                topLevelModels.add(payloadModel.getSimpleName());
            }
        }
        for (String topLevelModel : topLevelModels) {
            LOGGER.info(topLevelModel);
        }
    }
}
