package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoConcession
 */
public class TelcoConcession {
    /**
     * The concession type
     */
    public enum TypeEnum {
        CONCESSION,
        REBATE,
        GRANT
    }

    private TypeEnum type = TypeEnum.CONCESSION;

    private String displayName;

    private String additionalInfo;

    private String additionalInfoUri;

    private String startDate;

    private String endDate;

    private String discountFrequency;

    private String amount;

    private String percentage;

    /**
     * Gets or Sets appliedTo
     */
    public enum AppliedToEnum {
        INVOICE,
        USAGE
    }

    private List<AppliedToEnum> appliedTo = null;

    public TelcoConcession type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The concession type
     *
     * @return type
     */
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public TelcoConcession displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The display name of the concession
     *
     * @return displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public TelcoConcession additionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    /**
     * Display text providing more information on the concession
     *
     * @return additionalInfo
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public TelcoConcession additionalInfoUri(String additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
        return this;
    }

    /**
     * Optional link to additional information regarding the concession
     *
     * @return additionalInfoUri
     */
    public String getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(String additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    public TelcoConcession startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Optional start date for the application of the concession
     *
     * @return startDate
     */
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public TelcoConcession endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Optional end date for the application of the concession
     *
     * @return endDate
     */
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public TelcoConcession discountFrequency(String discountFrequency) {
        this.discountFrequency = discountFrequency;
        return this;
    }

    /**
     * Conditional attribute for frequency at which a concession is applied. Required if type is FIXED_AMOUNT or FIXED_PERCENTAGE. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) (excludes recurrence syntax)
     *
     * @return discountFrequency
     */
    public String getDiscountFrequency() {
        return discountFrequency;
    }

    public void setDiscountFrequency(String discountFrequency) {
        this.discountFrequency = discountFrequency;
    }

    public TelcoConcession amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Conditional attribute for the amount of discount for the concession- required if type is FIXED_AMOUNT
     *
     * @return amount
     */
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public TelcoConcession percentage(String percentage) {
        this.percentage = percentage;
        return this;
    }

    /**
     * Conditional attribute for the percentage of discount of concession - required if type is FIXED_PERCENTAGE
     *
     * @return percentage
     */
    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public TelcoConcession appliedTo(List<AppliedToEnum> appliedTo) {
        this.appliedTo = appliedTo;
        return this;
    }

    public TelcoConcession addAppliedToItem(AppliedToEnum appliedToItem) {
        if (this.appliedTo == null) {
            this.appliedTo = new ArrayList<>();
        }
        this.appliedTo.add(appliedToItem);
        return this;
    }

    /**
     * Array of ENUM's to specify what the concession applies to. Multiple ENUM values can be provided. If absent, USAGE is assumed
     *
     * @return appliedTo
     */
    public List<AppliedToEnum> getAppliedTo() {
        return appliedTo;
    }

    public void setAppliedTo(List<AppliedToEnum> appliedTo) {
        this.appliedTo = appliedTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoConcession telcoConcession = (TelcoConcession) o;
        return Objects.equals(this.type, telcoConcession.type) &&
                Objects.equals(this.displayName, telcoConcession.displayName) &&
                Objects.equals(this.additionalInfo, telcoConcession.additionalInfo) &&
                Objects.equals(this.additionalInfoUri, telcoConcession.additionalInfoUri) &&
                Objects.equals(this.startDate, telcoConcession.startDate) &&
                Objects.equals(this.endDate, telcoConcession.endDate) &&
                Objects.equals(this.discountFrequency, telcoConcession.discountFrequency) &&
                Objects.equals(this.amount, telcoConcession.amount) &&
                Objects.equals(this.percentage, telcoConcession.percentage) &&
                Objects.equals(this.appliedTo, telcoConcession.appliedTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, displayName, additionalInfo, additionalInfoUri, startDate, endDate, discountFrequency, amount, percentage, appliedTo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoConcession {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
        sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    discountFrequency: ").append(toIndentedString(discountFrequency)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
        sb.append("    appliedTo: ").append(toIndentedString(appliedTo)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
