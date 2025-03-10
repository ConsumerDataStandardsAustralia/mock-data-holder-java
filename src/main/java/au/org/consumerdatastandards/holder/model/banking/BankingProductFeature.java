/*
 * Consumer Data Standards
 * Sample Data Holder to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
 * https:github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 * Do not edit the class manually.
 */
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
public class BankingProductFeature {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String featureId;

    /**
     * The type of feature described. For further details, refer to [Product Feature Types](#tocSproductfeaturetypedoc).
     */
    private FeatureType featureType;

    /**
     * Generic field containing additional information relevant to the [_featureType_](#tocSproductfeaturetypedoc) specified. Whether mandatory or not is dependent on the value of the [_featureType_](#tocSproductfeaturetypedoc).
     */
    @Column(length = 2048)
    private String additionalValue;

    /**
     * Display text providing more information on the feature. Mandatory if [_featureType_](#tocSproductfeaturetypedoc) is set to `OTHER`.
     */
    @Column(length = 2048)
    private String additionalInfo;

    /**
     * Link to a web page with more information on this feature
     */
    private URI additionalInfoUri;

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public FeatureType getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FeatureType featureType) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingProductFeature that = (BankingProductFeature) o;
        return Objects.equals(featureId, that.featureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(featureId);
    }

    @Override
    public String toString() {
        return "BankingProductFeature{" +
            "featureId='" + featureId + '\'' +
            ", featureType=" + featureType +
            ", additionalValue='" + additionalValue + '\'' +
            ", additionalInfo='" + additionalInfo + '\'' +
            ", additionalInfoUri=" + additionalInfoUri +
            '}';
    }

    public enum FeatureType {
        ADDITIONAL_CARDS,
        BALANCE_TRANSFERS,
        BILL_PAYMENT,
        BONUS_REWARDS,
        CARD_ACCESS,
        CASHBACK_OFFER,
        COMPLEMENTARY_PRODUCT_DISCOUNTS,
        DIGITAL_BANKING,
        DIGITAL_WALLET,
        DONATE_INTEREST,
        EXTRA_REPAYMENTS,
        FRAUD_PROTECTION,
        FREE_TXNS,
        FREE_TXNS_ALLOWANCE,
        GUARANTOR,
        INSURANCE,
        INSTALMENT_PLAN,
        INTEREST_FREE,
        INTEREST_FREE_TRANSFERS,
        LOYALTY_PROGRAM,
        NOTIFICATIONS,
        NPP_ENABLED,
        NPP_PAYID,
        OFFSET,
        OTHER,
        OVERDRAFT,
        REDRAW,
        RELATIONSHIP_MANAGEMENT,
        UNLIMITED_TXNS
    }
}
