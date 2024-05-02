package au.org.consumerdatastandards.holder.model;

import java.util.Objects;

public class TxMetaPaginated extends MetaPaginated {

    private Boolean isQueryParamUnsupported;

    public Boolean getIsQueryParamUnsupported() {
        return isQueryParamUnsupported;
    }

    public void setIsQueryParamUnsupported(boolean isQueryParamUnsupported) {
        this.isQueryParamUnsupported = isQueryParamUnsupported;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TxMetaPaginated)) return false;
        if (!super.equals(o)) return false;
        TxMetaPaginated that = (TxMetaPaginated) o;
        return isQueryParamUnsupported == that.isQueryParamUnsupported;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isQueryParamUnsupported);
    }

    @Override
    public String toString() {
        return "class TxMetaPaginated {" +
            "   totalPages: " + toIndentedString(getTotalPages()) + "\n" +
            "   totalRecords: " + toIndentedString(getTotalPages()) + "\n" +
            "   isQueryParamUnsupported=" + isQueryParamUnsupported +
            '}';
    }
}
