package au.org.consumerdatastandards.holder.model.banking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class BankingProductV2CardArt {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * Display label for the specific image.
     */
    private String title;

    /**
     * URI reference to a PNG, JPG or GIF image with proportions defined by ISO 7810 ID-1 and width no greater than 512 pixels. The URI reference may be a link or url-encoded data URI according to **[[RFC2397]](#nref-RFC2397)**.
     */
    private String imageUri;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankingProductV2CardArt)) return false;
        BankingProductV2CardArt that = (BankingProductV2CardArt) o;
        return id.equals(that.id) &&
            Objects.equals(title, that.title) &&
            imageUri.equals(that.imageUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, imageUri);
    }

    @Override
    public String toString() {
        return "BankingProductV2CardArt{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", imageUri='" + imageUri + '\'' +
            '}';
    }
}
