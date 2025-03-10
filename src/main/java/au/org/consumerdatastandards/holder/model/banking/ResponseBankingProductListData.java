/*
 * Consumer Data Standards
 * Sample Data Holder to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
  * Do not edit the class manually.
 */
package au.org.consumerdatastandards.holder.model.banking;

import java.util.List;
import java.util.Objects;

public class ResponseBankingProductListData {

    /**
     * The list of products returned. If the filter results in an empty set then this array may have no records.
     */
    private List<BankingProduct> products;

    public List<BankingProduct> getProducts() {
        return products;
    }

    public void setProducts(List<BankingProduct> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseBankingProductListData)) return false;
        ResponseBankingProductListData that = (ResponseBankingProductListData) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String toString() {
        return "ResponseBankingProductListData{" +
            "products=" + products +
            '}';
    }
}
