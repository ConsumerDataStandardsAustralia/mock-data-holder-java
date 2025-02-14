package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Object containing usage summary.
 */
@ApiModel(description = "Object containing usage summary.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoUsage {
    @JsonProperty("data")
    private TelcoUsageData data;

    @JsonProperty("voice")
    private TelcoUsageVoice voice;

    @JsonProperty("messaging")
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
    @ApiModelProperty(value = "")

    @Valid

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
    @ApiModelProperty(value = "")

    @Valid

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
    @ApiModelProperty(value = "")

    @Valid

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

