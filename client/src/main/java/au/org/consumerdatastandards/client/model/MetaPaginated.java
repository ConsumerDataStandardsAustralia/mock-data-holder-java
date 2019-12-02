/*
 * Consumer Data Standards
 * Sample client library to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 */
package au.org.consumerdatastandards.client.model;

import java.util.Objects;

public class MetaPaginated {

    protected Integer totalPages;

    protected Integer totalRecords;

    /**
     * The total number of pages in the full set. See [pagination](#pagination).
     * @return totalPages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * The total number of records in the full set. See [pagination](#pagination).
     * @return totalRecords
     */
    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MetaPaginated metaPaginated = (MetaPaginated) o;
        return Objects.equals(this.totalPages, metaPaginated.totalPages) &&
            Objects.equals(this.totalRecords, metaPaginated.totalRecords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            totalPages,
            totalRecords);
    }

    @Override
    public String toString() {
        return "class MetaPaginated {\n" +
            "   totalPages: " + toIndentedString(totalPages) + "\n" + 
            "   totalRecords: " + toIndentedString(totalRecords) + "\n" + 
            "}";
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
