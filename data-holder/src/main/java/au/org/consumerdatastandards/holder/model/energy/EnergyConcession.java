package au.org.consumerdatastandards.holder.model.energy;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnergyConcession
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-01-11T14:03:27.755+11:00[Australia/Sydney]")
public class EnergyConcession {
    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("additionalInfo")
    private String additionalInfo;

    @JsonProperty("additionalInfoUri")
    private String additionalInfoUri;

    @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("endDate")
    private String endDate;

    @JsonProperty("dailyDiscount")
    private String dailyDiscount;

    @JsonProperty("monthlyDiscount")
    private String monthlyDiscount;

    @JsonProperty("yearlyDiscount")
    private String yearlyDiscount;

    @JsonProperty("percentageDiscount")
    private String percentageDiscount;

    public EnergyConcession displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The display name of the concession
     *
     * @return displayName
     */
    @ApiModelProperty(required = true,
            value = "The display name of the concession")
    @NotNull


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
     * Display text providing more information on the concession
     *
     * @return additionalInfo
     */
    @ApiModelProperty(value = "Display text providing more information on the concession")


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
    @ApiModelProperty(value = "Optional link to additional information regarding the concession")


    public String getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(String additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    public EnergyConcession startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Optional start date for the application of the concession
     *
     * @return startDate
     */
    @ApiModelProperty(value = "Optional start date for the application of the concession")


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public EnergyConcession endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Optional end date for the application of the concession
     *
     * @return endDate
     */
    @ApiModelProperty(value = "Optional end date for the application of the concession")


    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public EnergyConcession dailyDiscount(String dailyDiscount) {
        this.dailyDiscount = dailyDiscount;
        return this;
    }

    /**
     * Daily discount value due to the concession.  At least one dailyDiscount, monthlyDiscount, yearlyDiscount and percentageDiscount must be provided
     *
     * @return dailyDiscount
     */
    @ApiModelProperty(value = "Daily discount value due to the concession.  At least one dailyDiscount, monthlyDiscount, yearlyDiscount and percentageDiscount must be provided")


    public String getDailyDiscount() {
        return dailyDiscount;
    }

    public void setDailyDiscount(String dailyDiscount) {
        this.dailyDiscount = dailyDiscount;
    }

    public EnergyConcession monthlyDiscount(String monthlyDiscount) {
        this.monthlyDiscount = monthlyDiscount;
        return this;
    }

    /**
     * Monthly discount value due to the concession.  At least one dailyDiscount, monthlyDiscount, yearlyDiscount and percentageDiscount must be provided
     *
     * @return monthlyDiscount
     */
    @ApiModelProperty(value = "Monthly discount value due to the concession.  At least one dailyDiscount, monthlyDiscount, yearlyDiscount and percentageDiscount must be provided")


    public String getMonthlyDiscount() {
        return monthlyDiscount;
    }

    public void setMonthlyDiscount(String monthlyDiscount) {
        this.monthlyDiscount = monthlyDiscount;
    }

    public EnergyConcession yearlyDiscount(String yearlyDiscount) {
        this.yearlyDiscount = yearlyDiscount;
        return this;
    }

    /**
     * Annual discount value due to the concession.  At least one dailyDiscount, monthlyDiscount, yearlyDiscount and percentageDiscount must be provided
     *
     * @return yearlyDiscount
     */
    @ApiModelProperty(value = "Annual discount value due to the concession.  At least one dailyDiscount, monthlyDiscount, yearlyDiscount and percentageDiscount must be provided")


    public String getYearlyDiscount() {
        return yearlyDiscount;
    }

    public void setYearlyDiscount(String yearlyDiscount) {
        this.yearlyDiscount = yearlyDiscount;
    }

    public EnergyConcession percentageDiscount(String percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
        return this;
    }

    /**
     * Percentage of each invoice to be discounted due to the concession.  At least one dailyDiscount, monthlyDiscount, yearlyDiscount and percentageDiscount must be provided
     *
     * @return percentageDiscount
     */
    @ApiModelProperty(value = "Percentage of each invoice to be discounted due to the concession.  At least one dailyDiscount, monthlyDiscount, yearlyDiscount and percentageDiscount must be provided")


    public String getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(String percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
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
                Objects.equals(this.dailyDiscount, energyConcession.dailyDiscount) &&
                Objects.equals(this.monthlyDiscount, energyConcession.monthlyDiscount) &&
                Objects.equals(this.yearlyDiscount, energyConcession.yearlyDiscount) &&
                Objects.equals(this.percentageDiscount, energyConcession.percentageDiscount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, additionalInfo, additionalInfoUri, startDate, endDate, dailyDiscount, monthlyDiscount, yearlyDiscount, percentageDiscount);
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
        sb.append("    dailyDiscount: ").append(toIndentedString(dailyDiscount)).append("\n");
        sb.append("    monthlyDiscount: ").append(toIndentedString(monthlyDiscount)).append("\n");
        sb.append("    yearlyDiscount: ").append(toIndentedString(yearlyDiscount)).append("\n");
        sb.append("    percentageDiscount: ").append(toIndentedString(percentageDiscount)).append("\n");
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

