package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * A summary of Service balances
 */
public class TelcoServiceBalances {
    private TelcoServiceBalanceData data;

    private TelcoServiceBalanceVoice voice;

    private TelcoServiceBalanceMessaging messaging;

    public TelcoServiceBalances data(TelcoServiceBalanceData data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     */
    public TelcoServiceBalanceData getData() {
        return data;
    }

    public void setData(TelcoServiceBalanceData data) {
        this.data = data;
    }

    public TelcoServiceBalances voice(TelcoServiceBalanceVoice voice) {
        this.voice = voice;
        return this;
    }

    /**
     * Get voice
     *
     * @return voice
     */
    public TelcoServiceBalanceVoice getVoice() {
        return voice;
    }

    public void setVoice(TelcoServiceBalanceVoice voice) {
        this.voice = voice;
    }

    public TelcoServiceBalances messaging(TelcoServiceBalanceMessaging messaging) {
        this.messaging = messaging;
        return this;
    }

    /**
     * Get messaging
     *
     * @return messaging
     */
    public TelcoServiceBalanceMessaging getMessaging() {
        return messaging;
    }

    public void setMessaging(TelcoServiceBalanceMessaging messaging) {
        this.messaging = messaging;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoServiceBalances telcoServiceBalances = (TelcoServiceBalances) o;
        return Objects.equals(this.data, telcoServiceBalances.data) &&
                Objects.equals(this.voice, telcoServiceBalances.voice) &&
                Objects.equals(this.messaging, telcoServiceBalances.messaging);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, voice, messaging);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoServiceBalances {\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    voice: ").append(toIndentedString(voice)).append("\n");
        sb.append("    messaging: ").append(toIndentedString(messaging)).append("\n");
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
