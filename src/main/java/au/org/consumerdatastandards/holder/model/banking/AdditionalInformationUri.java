package au.org.consumerdatastandards.holder.model.banking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URI;
import java.util.Objects;

@Entity
public class AdditionalInformationUri {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    private String description;

    /**
     * The URI describing the additional information.
     */
    private URI additionalInfoUri;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URI getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(URI additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdditionalInformationUri additionalInformationUri = (AdditionalInformationUri) o;
        return Objects.equals(this.description, additionalInformationUri.description) &&
                Objects.equals(this.additionalInfoUri, additionalInformationUri.additionalInfoUri) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                description,
                additionalInfoUri,
                super.hashCode());
    }

    @Override
    public String toString() {
        return "class AdditionalInformationUri {\n" +
                "   id: " + toIndentedString(id) + "\n" +
                "   description: " + toIndentedString(description) + "\n" +
                "   additionalInfoUri: " + toIndentedString(additionalInfoUri) + "\n" +
                "}";
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
