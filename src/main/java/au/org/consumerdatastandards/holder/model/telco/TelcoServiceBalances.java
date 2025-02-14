package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.Objects;

/**
 * A summary of Service balances.
 */
@ApiModel(description = "A summary of Service balances.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoServiceBalances {
    @JsonProperty("data")
    private TelcoServiceBalanceData data;

    @JsonProperty("voice")
    private TelcoServiceBalanceVoice voice;

    @JsonProperty("messaging")
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
    @ApiModelProperty(value = "")

    @Valid

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
    @ApiModelProperty(value = "")

    @Valid

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
    @ApiModelProperty(value = "")

    @Valid

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

