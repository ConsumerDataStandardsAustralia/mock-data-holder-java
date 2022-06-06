package au.org.consumerdatastandards.holder.model.energy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Mandatory if readUType is set to intervalRead
 */
@ApiModel(description = "Mandatory if readUType is set to intervalRead")
public class EnergyUsageReadIntervalRead {
    private Integer readIntervalLength;

    private BigDecimal aggregateValue;

    @Valid
    private List<EnergyUsageReadIntervalReadIntervalReads> intervalReads = new ArrayList<>();

    public EnergyUsageReadIntervalRead readIntervalLength(Integer readIntervalLength) {
        this.readIntervalLength = readIntervalLength;
        return this;
    }

    /**
     * Read interval length in minutes
     *
     * @return readIntervalLength
     */
    @ApiModelProperty(required = true, value = "Read interval length in minutes")
    public Integer getReadIntervalLength() {
        return readIntervalLength;
    }

    public void setReadIntervalLength(Integer readIntervalLength) {
        this.readIntervalLength = readIntervalLength;
    }

    public EnergyUsageReadIntervalRead aggregateValue(BigDecimal aggregateValue) {
        this.aggregateValue = aggregateValue;
        return this;
    }

    /**
     * The aggregate sum of the interval read values. If positive then it means net consumption, if negative it means net export
     *
     * @return aggregateValue
     */
    @ApiModelProperty(required = true,
            value = "The aggregate sum of the interval read values. If positive then it means net consumption, if negative it means net export")
    @NotNull
    @Valid
    public BigDecimal getAggregateValue() {
        return aggregateValue;
    }

    public void setAggregateValue(BigDecimal aggregateValue) {
        this.aggregateValue = aggregateValue;
    }

    public EnergyUsageReadIntervalRead intervalReads(List<EnergyUsageReadIntervalReadIntervalReads> intervalReads) {
        this.intervalReads = intervalReads;
        return this;
    }

    public EnergyUsageReadIntervalRead addIntervalReadsItem(EnergyUsageReadIntervalReadIntervalReads intervalReadsItem) {
        this.intervalReads.add(intervalReadsItem);
        return this;
    }

    /**
     * Array of reads with each element indicating the read for the interval specified by readIntervalLength beginning at midnight of readStartDate (for example 00:00 to 00:30 would be the first reading in a 30 minute Interval)
     *
     * @return intervalReads
     */
    @ApiModelProperty(required = true,
            value = "Array of reads with each element indicating the read for the interval specified by readIntervalLength beginning at midnight of readStartDate (for example 00:00 to 00:30 would be the first reading in a 30 minute Interval)")
    @NotNull
    @Valid
    public List<EnergyUsageReadIntervalReadIntervalReads> getIntervalReads() {
        return intervalReads;
    }

    public void setIntervalReads(List<EnergyUsageReadIntervalReadIntervalReads> intervalReads) {
        this.intervalReads = intervalReads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyUsageReadIntervalRead energyUsageReadIntervalRead = (EnergyUsageReadIntervalRead) o;
        return Objects.equals(this.readIntervalLength, energyUsageReadIntervalRead.readIntervalLength) &&
                Objects.equals(this.aggregateValue, energyUsageReadIntervalRead.aggregateValue) &&
                Objects.equals(this.intervalReads, energyUsageReadIntervalRead.intervalReads);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readIntervalLength, aggregateValue, intervalReads);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyUsageReadIntervalRead {\n");
        sb.append("    readIntervalLength: ").append(toIndentedString(readIntervalLength)).append("\n");
        sb.append("    aggregateValue: ").append(toIndentedString(aggregateValue)).append("\n");
        sb.append("    intervalReads: ").append(toIndentedString(intervalReads)).append("\n");
        sb.append("}");
        return sb.toString();
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
