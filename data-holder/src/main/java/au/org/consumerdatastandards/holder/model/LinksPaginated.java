/*
 * Consumer Data Standards
 * Sample Data Holder to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated by the codegen artefact
 * https:*github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen
 * Do not edit the class manually.
 */
package au.org.consumerdatastandards.holder.model;

import java.util.Objects;

public class LinksPaginated {

    /**
     * Fully qualified link to this API call
     */
    private String self;

    /**
     * String to the first page of this set. Mandatory if this
     * response is not the first page
     */
    private String first;

    /**
     * String to the previous page of this set. Mandatory if this
     * response is not the first page
     */
    private String prev;

    /**
     * String to the next page of this set. Mandatory if this response
     * is not the last page
     */
    private String next;

    /**
     * String to the last page of this set. Mandatory if this response
     * is not the last page
     */
    private String last;


    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinksPaginated that = (LinksPaginated) o;
        return Objects.equals(self, that.self) &&
            Objects.equals(first, that.first) &&
            Objects.equals(prev, that.prev) &&
            Objects.equals(next, that.next) &&
            Objects.equals(last, that.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            self,
            first,
            prev,
            next,
            last);
    }

    @Override
    public String toString() {
        return "LinksPaginated{" +
            "self=" + self +
            ", first=" + first +
            ", prev=" + prev +
            ", next=" + next +
            ", last=" + last +
            '}';
    }
}
