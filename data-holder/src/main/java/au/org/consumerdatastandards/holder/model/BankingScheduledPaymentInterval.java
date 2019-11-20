package au.org.consumerdatastandards.holder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@ApiModel
@Entity
public class BankingScheduledPaymentInterval  {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    /**
     * Uses an interval to define the ordinal day within the interval defined by the interval field on which the payment occurs. If the resulting duration is 0 days in length or larger than the number of days in the interval then the payment will occur on the last day of the interval. A duration of 1 day indicates the first day of the interval. If absent the assumed value is P1D. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) with components less than a day in length ignored. The first day of a week is considered to be Monday.
     */
    private String dayInInterval;

    /**
     * An interval for the payment. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) with components less than a day in length ignored. This duration defines the period between payments starting with nextPaymentDate
     */
    @Column(name = "interv")
    private String interval;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BankingScheduledPaymentInterval dayInInterval(String dayInInterval) {
        this.dayInInterval = dayInInterval;
        return this;
    }

    @ApiModelProperty(value = "Uses an interval to define the ordinal day within the interval defined by the interval field on which the payment occurs. If the resulting duration is 0 days in length or larger than the number of days in the interval then the payment will occur on the last day of the interval. A duration of 1 day indicates the first day of the interval. If absent the assumed value is P1D. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) with components less than a day in length ignored. The first day of a week is considered to be Monday.")
    public String getDayInInterval() {
        return dayInInterval;
    }

    public void setDayInInterval(String dayInInterval) {
        this.dayInInterval = dayInInterval;
    }

    public BankingScheduledPaymentInterval interval(String interval) {
        this.interval = interval;
        return this;
    }

    @ApiModelProperty(required = true, value = "An interval for the payment. Formatted according to [ISO 8601 Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations) with components less than a day in length ignored. This duration defines the period between payments starting with nextPaymentDate")
    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankingScheduledPaymentInterval bankingScheduledPaymentInterval = (BankingScheduledPaymentInterval) o;
        return Objects.equals(this.id, bankingScheduledPaymentInterval.id) &&
            Objects.equals(this.dayInInterval, bankingScheduledPaymentInterval.dayInInterval) &&
            Objects.equals(this.interval, bankingScheduledPaymentInterval.interval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            dayInInterval,
            interval);
    }

    @Override
    public String toString() {
        return "class BankingScheduledPaymentInterval {\n" +
            "   id: " + toIndentedString(id) + "\n" +
            "   dayInInterval: " + toIndentedString(dayInInterval) + "\n" +
            "   interval: " + toIndentedString(interval) + "\n" +
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

