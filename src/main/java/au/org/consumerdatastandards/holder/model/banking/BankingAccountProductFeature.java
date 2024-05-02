package au.org.consumerdatastandards.holder.model.banking;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.URI;
import java.util.Objects;

@Entity
public class BankingAccountProductFeature {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * The type of feature described
     */
    private BankingProductFeature.FeatureType featureType;

    /**
     * Generic field containing additional information relevant to
     * the featureType specified. Whether mandatory or not is
     * dependent on the value of featureType
     */
    @Column(length = 2048)
    private String additionalValue;

    /**
     * Display text providing more information on the feature.
     * Mandatory if the feature type is set to OTHER
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this feature
     */
    private URI additionalInfoUri;

//    @JsonIgnore
//    @ManyToOne
//    private BankingAccountDetail bankingAccountDetail;

    private Boolean isActivated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public BankingAccountDetail getBankingAccountDetail() {
//        return bankingAccountDetail;
//    }

//    public void setBankingAccountDetail(BankingAccountDetail bankingAccountDetail) {
//        this.bankingAccountDetail = bankingAccountDetail;
//    }

    public BankingProductFeature.FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(BankingProductFeature.FeatureType featureType) {
        this.featureType = featureType;
    }

    public String getAdditionalValue() {
        return additionalValue;
    }

    public void setAdditionalValue(String additionalValue) {
        this.additionalValue = additionalValue;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public URI getAdditionalInfoUri() {
        return additionalInfoUri;
    }

    public void setAdditionalInfoUri(URI additionalInfoUri) {
        this.additionalInfoUri = additionalInfoUri;
    }

    public Boolean getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(Boolean activated) {
        isActivated = activated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankingAccountProductFeature)) return false;
        BankingAccountProductFeature that = (BankingAccountProductFeature) o;
        return Objects.equals(featureType, that.featureType) &&
//            Objects.equals(bankingAccountDetail, that.bankingAccountDetail) &&
            Objects.equals(additionalInfo, that.additionalInfo) &&
            Objects.equals(additionalInfoUri, that.additionalInfoUri) &&
            Objects.equals(additionalValue, that.additionalValue) &&
            Objects.equals(isActivated, that.isActivated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            featureType,
//            bankingAccountDetail,
            additionalInfo,
            additionalInfoUri,
            additionalValue,
            isActivated);
    }

    @Override
    public String toString() {
        return "class BankingAccountProductFeature {" +
            "   featureType: " + toIndentedString(featureType) + '\'' +
//            "   bankingAccountDetail: " + toIndentedString(bankingAccountDetail) +
            "   additionalInfo: " + toIndentedString(additionalInfo) +
            "   additionalInfoUri: " + toIndentedString(additionalInfoUri) +
            "   additionalValue: " + toIndentedString(additionalValue) +
            "   isActivated: " + toIndentedString(isActivated) +
            '}';
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
