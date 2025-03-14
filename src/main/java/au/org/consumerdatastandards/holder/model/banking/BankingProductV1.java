/*
 * Consumer Data Standards
 * Sample Data Holder to Demonstrate the Consumer Data Right APIs
 */
package au.org.consumerdatastandards.holder.model.banking;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "b_prod")
public class BankingProductV1 implements BankingProduct {

    /**
     * A provider specific unique identifier for this product. This
     * identifier must be unique to a product but does not
     * otherwise need to adhere to ID permanence guidelines.
     */
    @Id
    private String productId;

    /**
     * The date and time from which this product is effective (ie.
     * is available for origination).  Used to enable the
     * articulation of products to the regime before they are
     * available for customers to originate
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime effectiveFrom;

    /**
     * The date and time at which this product will be retired and
     * will no longer be offered.  Used to enable the managed
     * deprecation of products
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime effectiveTo;

    /**
     * The last date and time that the information for this The last date and time that the information for this product was changed (or the creation date for the product if it has never been altered).
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime lastUpdated;

    private BankingProductCategory productCategory;

    /**
     * The display name of the product.
     */
    private String name;

    /**
     * A description of the product.
     */
    @Column(length = 2048)
    private String description;

    /**
     * A label of the brand for the product. A label of the brand for the product. Able to be used for filtering. For data holders with single brands this value is still required.
     */
    private String brand;

    /**
     * An optional display name of the brand.
     */
    private String brandName;

    /**
     * A link to an application web page where this product can be
     * applied for.
     */
    private String applicationUri;

    /**
     * Indicates whether the product is specifically tailored to Indicates whether the product is specifically tailored to a circumstance. In this case fees and prices are significantly negotiated depending on context. While all products are open to a degree of tailoring this flag indicates that tailoring is expected and thus that the provision of specific fees and rates is not applicable.
     */
    private Boolean isTailored;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "b_prod_add_infos",
            joinColumns = @JoinColumn(name = "prod_id"),
            inverseJoinColumns = @JoinColumn(name = "info_id"))
    private BankingProductAdditionalInformationV1 additionalInformation;

    @Override
    public String getProductId() {
        return productId;
    }

    @Override
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public OffsetDateTime getEffectiveFrom() {
        return effectiveFrom;
    }

    @Override
    public void setEffectiveFrom(OffsetDateTime effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    @Override
    public OffsetDateTime getEffectiveTo() {
        return effectiveTo;
    }

    @Override
    public void setEffectiveTo(OffsetDateTime effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    @Override
    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public void setLastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public BankingProductCategory getProductCategory() {
        return productCategory;
    }

    @Override
    public void setProductCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrandName() {
        return brandName;
    }

    @Override
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String getApplicationUri() {
        return applicationUri;
    }

    @Override
    public void setApplicationUri(String applicationUri) {
        this.applicationUri = applicationUri;
    }

    @Override
    public Boolean getIsTailored() {
        return isTailored;
    }

    @Override
    public void setIsTailored(Boolean isTailored) {
        this.isTailored = isTailored;
    }

    public BankingProductAdditionalInformationV1 getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(BankingProductAdditionalInformationV1 additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingProductV1 that = (BankingProductV1) o;
        return productId.equals(that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "BankingProduct{" +
            "productId='" + productId + '\'' +
            ", effectiveFrom=" + effectiveFrom +
            ", effectiveTo=" + effectiveTo +
            ", lastUpdated=" + lastUpdated +
            ", productCategory=" + productCategory +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", brand='" + brand + '\'' +
            ", brandName='" + brandName + '\'' +
            ", applicationUri='" + applicationUri + '\'' +
            ", isTailored=" + isTailored +
            ", additionalInformation=" + additionalInformation +
            '}';
    }
}
