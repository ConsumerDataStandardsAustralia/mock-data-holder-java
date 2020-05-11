package au.org.consumerdatastandards.client.model;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.OffsetDateTime;
import java.util.Objects;

public class BankingProductV1 implements BankingProduct {

    private BankingProductAdditionalInformation additionalInformation;

    private String applicationUri;

    private String brand;

    private String brandName;

    private String description;

    private OffsetDateTime effectiveFrom;

    private OffsetDateTime effectiveTo;

    private Boolean isTailored;

    private OffsetDateTime lastUpdated;

    private String name;

    private BankingProductCategory productCategory;

    private String productId;

    /**
     * Get additionalInformation
     * @return additionalInformation
     */
    @Override
    public BankingProductAdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    @Override
    public void setAdditionalInformation(BankingProductAdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    /**
     * A link to an application web page where this product can be applied for.
     * @return applicationUri
     */
    @Override
    public String getApplicationUri() {
        return applicationUri;
    }

    @Override
    public void setApplicationUri(String applicationUri) {
        this.applicationUri = applicationUri;
    }

    /**
     * A label of the brand for the product. Able to be used for filtering. For data holders with single brands this value is still required
     * @return brand
     */
    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * An optional display name of the brand
     * @return brandName
     */
    @Override
    public String getBrandName() {
        return brandName;
    }

    @Override
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * A description of the product
     * @return description
     */
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * The date and time from which this product is effective (ie. is available for origination).  Used to enable the articulation of products to the regime before they are available for customers to originate
     * @return effectiveFrom
     */
    @Override
    public OffsetDateTime getEffectiveFrom() {
        return effectiveFrom;
    }

    @Override
    public void setEffectiveFrom(OffsetDateTime effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    /**
     * The date and time at which this product will be retired and will no longer be offered.  Used to enable the managed deprecation of products
     * @return effectiveTo
     */
    @Override
    public OffsetDateTime getEffectiveTo() {
        return effectiveTo;
    }

    @Override
    public void setEffectiveTo(OffsetDateTime effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    /**
     * Indicates whether the product is specifically tailored to a circumstance.  In this case fees and prices are significantly negotiated depending on context. While all products are open to a degree of tailoring this flag indicates that tailoring is expected and thus that the provision of specific fees and rates is not applicable
     * @return isTailored
     */
    @Override
    public Boolean getIsTailored() {
        return isTailored;
    }

    @Override
    public void setIsTailored(Boolean isTailored) {
        this.isTailored = isTailored;
    }

    /**
     * The last date and time that the information for this product was changed (or the creation date for the product if it has never been altered)
     * @return lastUpdated
     */
    @Override
    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public void setLastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * The display name of the product
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get productCategory
     * @return productCategory
     */
    @Override
    public BankingProductCategory getProductCategory() {
        return productCategory;
    }

    @Override
    public void setProductCategory(BankingProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    /**
     * A data holder specific unique identifier for this product. This identifier must be unique to a product but does not otherwise need to adhere to ID permanence guidelines.
     * @return productId
     */
    @Override
    public String getProductId() {
        return productId;
    }

    @Override
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingProductV1 bankingProductV1 = (BankingProductV1) o;
        return Objects.equals(this.additionalInformation, bankingProductV1.additionalInformation) &&
            Objects.equals(this.applicationUri, bankingProductV1.applicationUri) &&
            Objects.equals(this.brand, bankingProductV1.brand) &&
            Objects.equals(this.brandName, bankingProductV1.brandName) &&
            Objects.equals(this.description, bankingProductV1.description) &&
            Objects.equals(this.effectiveFrom, bankingProductV1.effectiveFrom) &&
            Objects.equals(this.effectiveTo, bankingProductV1.effectiveTo) &&
            Objects.equals(this.isTailored, bankingProductV1.isTailored) &&
            Objects.equals(this.lastUpdated, bankingProductV1.lastUpdated) &&
            Objects.equals(this.name, bankingProductV1.name) &&
            Objects.equals(this.productCategory, bankingProductV1.productCategory) &&
            Objects.equals(this.productId, bankingProductV1.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            additionalInformation,
            applicationUri,
            brand,
            brandName,
            description,
            effectiveFrom,
            effectiveTo,
            isTailored,
            lastUpdated,
            name,
            productCategory,
            productId);
    }

    @Override
    public String toString() {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.print("class "); pw.print(getClass().getSimpleName()); pw.println(" {");
        writeProperties(pw);
        pw.print("}");
        return sw.toString();
    }

    protected void writeProperties(PrintWriter pw) {
        pw.print("   additionalInformation: "); pw.println(toIndentedString(additionalInformation));
        pw.print("   applicationUri: "); pw.println(toIndentedString(applicationUri));
        pw.print("   brand: "); pw.println(toIndentedString(brand));
        pw.print("   brandName: "); pw.println(toIndentedString(brandName));
        pw.print("   description: "); pw.println(toIndentedString(description));
        pw.print("   effectiveFrom: "); pw.println(toIndentedString(effectiveFrom));
        pw.print("   effectiveTo: "); pw.println(toIndentedString(effectiveTo));
        pw.print("   isTailored: "); pw.println(toIndentedString(isTailored));
        pw.print("   lastUpdated: "); pw.println(toIndentedString(lastUpdated));
        pw.print("   name: "); pw.println(toIndentedString(name));
        pw.print("   productCategory: "); pw.println(toIndentedString(productCategory));
        pw.print("   productId: "); pw.println(toIndentedString(productId));
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
