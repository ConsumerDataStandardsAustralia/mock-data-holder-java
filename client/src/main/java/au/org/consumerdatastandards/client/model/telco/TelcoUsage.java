package au.org.consumerdatastandards.client.model.telco;

import java.util.Objects;

/**
 * Object containing usage summary
 */
public class TelcoUsage {
    private TelcoUsageData data;

    private TelcoUsageVoice voice;

    private TelcoUsageMessaging messaging;

    public TelcoUsage data(TelcoUsageData data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     */
    public TelcoUsageData getData() {
        return data;
    }

    public void setData(TelcoUsageData data) {
        this.data = data;
    }

    public TelcoUsage voice(TelcoUsageVoice voice) {
        this.voice = voice;
        return this;
    }

    /**
     * Get voice
     *
     * @return voice
     */
    public TelcoUsageVoice getVoice() {
        return voice;
    }

    public void setVoice(TelcoUsageVoice voice) {
        this.voice = voice;
    }

    public TelcoUsage messaging(TelcoUsageMessaging messaging) {
        this.messaging = messaging;
        return this;
    }

    /**
     * Get messaging
     *
     * @return messaging
     */
    public TelcoUsageMessaging getMessaging() {
        return messaging;
    }

    public void setMessaging(TelcoUsageMessaging messaging) {
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
        TelcoUsage telcoUsage = (TelcoUsage) o;
        return Objects.equals(this.data, telcoUsage.data) &&
                Objects.equals(this.voice, telcoUsage.voice) &&
                Objects.equals(this.messaging, telcoUsage.messaging);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, voice, messaging);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoUsage {\n");
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
