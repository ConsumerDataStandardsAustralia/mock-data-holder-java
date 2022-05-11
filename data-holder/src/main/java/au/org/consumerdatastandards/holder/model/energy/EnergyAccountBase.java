package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public interface EnergyAccountBase {
    /**
     * The ID of the account.  To be created in accordance with CDR ID permanence requirements
     *
     * @return accountId
     */
    @ApiModelProperty(required = true,
            value = "The ID of the account.  To be created in accordance with CDR ID permanence requirements")
    @NotNull String getAccountId();

    void setAccountId(String accountId);

    /**
     * Optional identifier of the account as defined by the data holder.  This must be the value presented on physical statements (if it exists) and must not be used for the value of accountId
     *
     * @return accountNumber
     */
    @ApiModelProperty(value = "Optional identifier of the account as defined by the data holder.  This must be the value presented on physical statements (if it exists) and must not be used for the value of accountId")
    String getAccountNumber();

    void setAccountNumber(String accountNumber);

    /**
     * An optional display name for the account if one exists or can be derived.  The content of this field is at the discretion of the data holder
     *
     * @return displayName
     */
    @ApiModelProperty(value = "An optional display name for the account if one exists or can be derived.  The content of this field is at the discretion of the data holder")
    String getDisplayName();

    void setDisplayName(String displayName);

    /**
     * The date that the account was created or opened
     *
     * @return creationDate
     */
    @ApiModelProperty(required = true,
            value = "The date that the account was created or opened")
    @NotNull LocalDate getCreationDate();

    void setCreationDate(LocalDate creationDate);
}
