package au.org.consumerdatastandards.holder.model;

import java.time.OffsetDateTime;

public interface BankingProduct {
    String getProductId();

    void setProductId(String productId);

    OffsetDateTime getEffectiveFrom();

    void setEffectiveFrom(OffsetDateTime effectiveFrom);

    OffsetDateTime getEffectiveTo();

    void setEffectiveTo(OffsetDateTime effectiveTo);

    OffsetDateTime getLastUpdated();

    void setLastUpdated(OffsetDateTime lastUpdated);

    BankingProductCategory getProductCategory();

    void setProductCategory(BankingProductCategory productCategory);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    String getBrand();

    void setBrand(String brand);

    String getBrandName();

    void setBrandName(String brandName);

    String getApplicationUri();

    void setApplicationUri(String applicationUri);

    Boolean getIsTailored();

    void setIsTailored(Boolean isTailored);

    BankingProductAdditionalInformation getAdditionalInformation();

    void setAdditionalInformation(BankingProductAdditionalInformation additionalInformation);
}
