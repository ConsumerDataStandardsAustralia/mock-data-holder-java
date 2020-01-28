package au.org.consumerdatastandards.client.model;

import java.time.OffsetDateTime;

public interface BankingProduct {
    BankingProductAdditionalInformation getAdditionalInformation();

    void setAdditionalInformation(BankingProductAdditionalInformation additionalInformation);

    String getApplicationUri();

    void setApplicationUri(String applicationUri);

    String getBrand();

    void setBrand(String brand);

    String getBrandName();

    void setBrandName(String brandName);

    String getDescription();

    void setDescription(String description);

    OffsetDateTime getEffectiveFrom();

    void setEffectiveFrom(OffsetDateTime effectiveFrom);

    OffsetDateTime getEffectiveTo();

    void setEffectiveTo(OffsetDateTime effectiveTo);

    Boolean getIsTailored();

    void setIsTailored(Boolean isTailored);

    OffsetDateTime getLastUpdated();

    void setLastUpdated(OffsetDateTime lastUpdated);

    String getName();

    void setName(String name);

    BankingProductCategory getProductCategory();

    void setProductCategory(BankingProductCategory productCategory);

    String getProductId();

    void setProductId(String productId);
}
