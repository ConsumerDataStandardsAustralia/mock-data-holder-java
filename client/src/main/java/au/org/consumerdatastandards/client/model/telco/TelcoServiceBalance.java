package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * Telco balances for a service
 */
public class TelcoServiceBalance {
    private String serviceId;

    private String displayName;

    private String phoneNumber;

    private String startDate;

    private String endDate;

    private TelcoServiceBalances balance;

    public TelcoServiceBalance serviceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    /**
     * The serviceId representing a unique service identifier such as a mobile [MSISDN](https://www.etsi.org/deliver/etsi_gts/03/0303/05.00.00_60/gsmts_0303v050000p.pdf), [FNN](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf) or internet service e.g [NBN AVC Service ID](https://www.nbnco.com.au/content/dam/nbnco2/documents/sfaa-wba2-dictionary_FTTN-launch.pdf). In accordance with [CDR ID permanence](#id-permanence) requirements
     *
     * @return serviceId
     */
    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public TelcoServiceBalance displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Optional description of the service used for display purposes
     *
     * @return displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public TelcoServiceBalance phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * Required if the service includes a phone number
     *
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TelcoServiceBalance startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Date when the balance period started
     *
     * @return startDate
     */
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public TelcoServiceBalance endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Date when the balance period ends
     *
     * @return endDate
     */
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public TelcoServiceBalance balance(TelcoServiceBalances balance) {
        this.balance = balance;
        return this;
    }

    /**
     * Get balance
     *
     * @return balance
     */
    public TelcoServiceBalances getBalance() {
        return balance;
    }

    public void setBalance(TelcoServiceBalances balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoServiceBalance telcoServiceBalance = (TelcoServiceBalance) o;
        return Objects.equals(this.serviceId, telcoServiceBalance.serviceId) &&
                Objects.equals(this.displayName, telcoServiceBalance.displayName) &&
                Objects.equals(this.phoneNumber, telcoServiceBalance.phoneNumber) &&
                Objects.equals(this.startDate, telcoServiceBalance.startDate) &&
                Objects.equals(this.endDate, telcoServiceBalance.endDate) &&
                Objects.equals(this.balance, telcoServiceBalance.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, displayName, phoneNumber, startDate, endDate, balance);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoServiceBalance {\n");
        sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
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
