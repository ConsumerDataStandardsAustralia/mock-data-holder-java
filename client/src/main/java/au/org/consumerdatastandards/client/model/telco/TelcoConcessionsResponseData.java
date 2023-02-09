package au.org.consumerdatastandards.client.model.telco;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoConcessionsResponseData
 */
public class TelcoConcessionsResponseData {
    private List<TelcoConcession> concessions = new ArrayList<>();

    public TelcoConcessionsResponseData concessions(List<TelcoConcession> concessions) {
        this.concessions = concessions;
        return this;
    }

    public TelcoConcessionsResponseData addConcessionsItem(TelcoConcession concessionsItem) {
        this.concessions.add(concessionsItem);
        return this;
    }

    /**
     * Array may be empty if no concessions exist
     *
     * @return concessions
     */
    public List<TelcoConcession> getConcessions() {
        return concessions;
    }

    public void setConcessions(List<TelcoConcession> concessions) {
        this.concessions = concessions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoConcessionsResponseData telcoConcessionsResponseData = (TelcoConcessionsResponseData) o;
        return Objects.equals(this.concessions, telcoConcessionsResponseData.concessions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concessions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoConcessionsResponseData {\n");
        sb.append("    concessions: ").append(toIndentedString(concessions)).append("\n");
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
