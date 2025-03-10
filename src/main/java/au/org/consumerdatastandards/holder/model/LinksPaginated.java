/*
 * Consumer Data Standards
 * Sample Data Holder to Demonstrate the Consumer Data Right APIs
 *
 * NOTE: This class is auto generated
  * Do not edit the class manually.
 */
package au.org.consumerdatastandards.holder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel
public class LinksPaginated  {

    /**
     * URI to the first page of this set. Mandatory if this response is not the first page.
     */
    private String first;

    /**
     * URI to the last page of this set. Mandatory if this response is not the last page.
     */
    private String last;

    /**
     * URI to the next page of this set. Mandatory if this response is not the last page.
     */
    private String next;

    /**
     * URI to the previous page of this set. Mandatory if this response is not the first page.
     */
    private String prev;

    /**
     * Fully qualified link that generated the current response document.
     */
    private String self;

    public LinksPaginated first(String first) {
        this.first = first;
        return this;
    }

    @ApiModelProperty(value = "URI to the first page of this set. Mandatory if this response is not the first page.")
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }
    public LinksPaginated last(String last) {
        this.last = last;
        return this;
    }

    @ApiModelProperty(value = "URI to the last page of this set. Mandatory if this response is not the last page.")
    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
    public LinksPaginated next(String next) {
        this.next = next;
        return this;
    }

    @ApiModelProperty(value = "URI to the next page of this set. Mandatory if this response is not the last page.")
    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
    public LinksPaginated prev(String prev) {
        this.prev = prev;
        return this;
    }

    @ApiModelProperty(value = "URI to the previous page of this set. Mandatory if this response is not the first page.")
    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }
    public LinksPaginated self(String self) {
        this.self = self;
        return this;
    }

    @ApiModelProperty(required = true, value = "Fully qualified link that generated the current response document.")
    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinksPaginated linksPaginated = (LinksPaginated) o;
        return Objects.equals(this.first, linksPaginated.first) &&
            Objects.equals(this.last, linksPaginated.last) &&
            Objects.equals(this.next, linksPaginated.next) &&
            Objects.equals(this.prev, linksPaginated.prev) &&
            Objects.equals(this.self, linksPaginated.self);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            first,
            last,
            next,
            prev,
            self);
    }

    @Override
    public String toString() {
        return "class LinksPaginated {\n" +
            "   first: " + toIndentedString(first) + "\n" + 
            "   last: " + toIndentedString(last) + "\n" + 
            "   next: " + toIndentedString(next) + "\n" + 
            "   prev: " + toIndentedString(prev) + "\n" + 
            "   self: " + toIndentedString(self) + "\n" + 
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

