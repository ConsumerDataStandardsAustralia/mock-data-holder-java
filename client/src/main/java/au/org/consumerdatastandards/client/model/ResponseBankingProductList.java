/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 */
package au.org.consumerdatastandards.client.model;

import java.util.Objects;

public class ResponseBankingProductList {

  private ResponseBankingProductListData data = null;

  private LinksPaginated links = null;

  private MetaPaginated meta = null;

  /**
   * Get data
   * @return data
   */
  public ResponseBankingProductListData getData() {
    return data;
  }

  public void setData(ResponseBankingProductListData data) {
    this.data = data;
  }

  /**
   * Get links
   * @return links
   */
  public LinksPaginated getLinks() {
    return links;
  }

  public void setLinks(LinksPaginated links) {
    this.links = links;
  }

  /**
   * Get meta
   * @return meta
   */
  public MetaPaginated getMeta() {
    return meta;
  }

  public void setMeta(MetaPaginated meta) {
    this.meta = meta;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseBankingProductList responseBankingProductList = (ResponseBankingProductList) o;
    return Objects.equals(this.data, responseBankingProductList.data) &&
        Objects.equals(this.links, responseBankingProductList.links) &&
        Objects.equals(this.meta, responseBankingProductList.meta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        data,
        links,
        meta);
  }

  @Override
  public String toString() {
    return "class ResponseBankingProductList {\n" +
        "    data: " + toIndentedString(data) + "\n" +
        "    links: " + toIndentedString(links) + "\n" +
        "    meta: " + toIndentedString(meta) + "\n" +
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
