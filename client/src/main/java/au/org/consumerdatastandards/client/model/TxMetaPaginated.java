package au.org.consumerdatastandards.client.model;

import java.util.Objects;

public class TxMetaPaginated extends MetaPaginated {

    private boolean isQueryParamUnsupported;

    public boolean isQueryParamUnsupported() {
        return isQueryParamUnsupported;
    }

    public void setQueryParamUnsupported(boolean queryParamUnsupported) {
        isQueryParamUnsupported = queryParamUnsupported;
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
