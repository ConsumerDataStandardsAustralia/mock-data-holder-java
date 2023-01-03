package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * Summary of messaging. Required if messaging services is included in the product plan
 */
public class TelcoServiceBalanceMessaging {
    private TelcoPlanType planType;

    private TelcoServiceBalanceMessagingSms sms;

    private TelcoServiceBalanceMessagingMms mms;

    public TelcoServiceBalanceMessaging planType(TelcoPlanType planType) {
        this.planType = planType;
        return this;
    }

    /**
     * Get planType
     *
     * @return planType
     */
    public TelcoPlanType getPlanType() {
        return planType;
    }

    public void setPlanType(TelcoPlanType planType) {
        this.planType = planType;
    }

    public TelcoServiceBalanceMessaging sms(TelcoServiceBalanceMessagingSms sms) {
        this.sms = sms;
        return this;
    }

    /**
     * Get sms
     *
     * @return sms
     */
    public TelcoServiceBalanceMessagingSms getSms() {
        return sms;
    }

    public void setSms(TelcoServiceBalanceMessagingSms sms) {
        this.sms = sms;
    }

    public TelcoServiceBalanceMessaging mms(TelcoServiceBalanceMessagingMms mms) {
        this.mms = mms;
        return this;
    }

    /**
     * Get mms
     *
     * @return mms
     */
    public TelcoServiceBalanceMessagingMms getMms() {
        return mms;
    }

    public void setMms(TelcoServiceBalanceMessagingMms mms) {
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
        TelcoServiceBalanceMessaging telcoServiceBalanceMessaging = (TelcoServiceBalanceMessaging) o;
        return Objects.equals(this.planType, telcoServiceBalanceMessaging.planType) &&
                Objects.equals(this.sms, telcoServiceBalanceMessaging.sms) &&
                Objects.equals(this.mms, telcoServiceBalanceMessaging.mms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planType, sms, mms);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoServiceBalanceMessaging {\n");
        sb.append("    planType: ").append(toIndentedString(planType)).append("\n");
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
