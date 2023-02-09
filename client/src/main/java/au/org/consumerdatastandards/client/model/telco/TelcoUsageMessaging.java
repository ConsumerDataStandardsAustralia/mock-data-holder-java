package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * Summary of messaging. Required if messaging services is included in the product plan
 */
public class TelcoUsageMessaging {
    private TelcoUsageMessagingSms sms;

    private TelcoUsageMessagingMms mms;

    public TelcoUsageMessaging sms(TelcoUsageMessagingSms sms) {
        this.sms = sms;
        return this;
    }

    /**
     * Get sms
     *
     * @return sms
     */
    public TelcoUsageMessagingSms getSms() {
        return sms;
    }

    public void setSms(TelcoUsageMessagingSms sms) {
        this.sms = sms;
    }

    public TelcoUsageMessaging mms(TelcoUsageMessagingMms mms) {
        this.mms = mms;
        return this;
    }

    /**
     * Get mms
     *
     * @return mms
     */
    public TelcoUsageMessagingMms getMms() {
        return mms;
    }

    public void setMms(TelcoUsageMessagingMms mms) {
        this.mms = mms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoUsageMessaging telcoUsageMessaging = (TelcoUsageMessaging) o;
        return Objects.equals(this.sms, telcoUsageMessaging.sms) &&
                Objects.equals(this.mms, telcoUsageMessaging.mms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sms, mms);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoUsageMessaging {\n");
        sb.append("    sms: ").append(toIndentedString(sms)).append("\n");
        sb.append("    mms: ").append(toIndentedString(mms)).append("\n");
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
