package au.org.consumerdatastandards.client.model.energy;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * EnergyConcession
 */
public class EnergyConcession {
    public enum Type {
        FIXED_AMOUNT,
        FIXED_PERCENTAGE,
        VARIABLE
    }

    private Type type;

    private String displayName;

    private String additionalInfo;

    private String additionalInfoUri;

    private LocalDate startDate;   // "x-cds-type" : "DateString"

    private LocalDate endDate;   // "x-cds-type" : "DateString"

    private String discountFrequency;

    private String amount;

    private String percentage;

    private List<String> appliedTo;

    /**
     * Indicator of the method of concession calculation
     *
     * @return type
     */
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public EnergyConcession displayName(String displayName) {
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

    public EnergyConcession additionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    /**
     * Display text providing more information on the concession. Mandatory if type is VARIABLE
     *
     * @return additionalInfo
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public EnergyConcession additionalInfoUri(String additionalInfoUri) {
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

    public EnergyConcession startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Optional start date for the application of the concession
     *
     * @return startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public EnergyConcession endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Optional end date for the application of the concession
     *
     * @return endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public EnergyConcession discountFrequency(String discountFrequency) {
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

    public EnergyConcession amount(String amount) {
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

    public EnergyConcession percentage(String percentage) {
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

    public EnergyConcession appliedTo(List<String> appliedTo) {
        this.appliedTo = appliedTo;
        return this;
    }

    /**
     * Array of ENUM's to specify what the concession applies to. Multiple ENUM values can be provided. If absent, USAGE is assumed
     *
     * @return appliedTo
     */
    public List<String> getAppliedTo() {
        return appliedTo;
    }

    public void setAppliedTo(List<String> appliedTo) {
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
        EnergyConcession energyConcession = (EnergyConcession) o;
        return Objects.equals(this.displayName, energyConcession.displayName) &&
                Objects.equals(this.additionalInfo, energyConcession.additionalInfo) &&
                Objects.equals(this.additionalInfoUri, energyConcession.additionalInfoUri) &&
                Objects.equals(this.startDate, energyConcession.startDate) &&
                Objects.equals(this.endDate, energyConcession.endDate) &&
                Objects.equals(this.type, energyConcession.type) &&
                Objects.equals(this.discountFrequency, energyConcession.discountFrequency) &&
                Objects.equals(this.amount, energyConcession.amount) &&
                Objects.equals(this.percentage, energyConcession.percentage) &&
                Objects.equals(this.appliedTo, energyConcession.appliedTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, additionalInfo, additionalInfoUri, startDate, endDate, type, discountFrequency, amount, percentage, appliedTo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyConcession {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
        sb.append("    additionalInfoUri: ").append(toIndentedString(additionalInfoUri)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    dailyDiscount: ").append(toIndentedString(discountFrequency)).append("\n");
        sb.append("    monthlyDiscount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    yearlyDiscount: ").append(toIndentedString(percentage)).append("\n");
        sb.append("    percentageDiscount: ").append(toIndentedString(appliedTo)).append("\n");
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
