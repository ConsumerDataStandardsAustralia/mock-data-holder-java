package au.org.consumerdatastandards.holder.model.telco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TelcoProductDetail
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2022-12-23T11:32:06.900+11:00[Australia/Sydney]")
public class TelcoProductDetail {
    @JsonProperty("meteringCharges")
    @Valid
    private List<TelcoProductDetailMeteringCharges> meteringCharges = null;

    @JsonProperty("bundles")
    @Valid
    private List<TelcoProductDetailBundles> bundles = null;

    @JsonProperty("plans")
    @Valid
    private List<TelcoProductDetailPlan> plans = null;

    @JsonProperty("discounts")
    @Valid
    private List<TelcoProductDetailDiscounts> discounts = null;

    @JsonProperty("incentives")
    @Valid
    private List<TelcoProductDetailIncentives> incentives = null;

    public TelcoProductDetail meteringCharges(List<TelcoProductDetailMeteringCharges> meteringCharges) {
        this.meteringCharges = meteringCharges;
        return this;
    }

    public TelcoProductDetail addMeteringChargesItem(TelcoProductDetailMeteringCharges meteringChargesItem) {
        if (this.meteringCharges == null) {
            this.meteringCharges = new ArrayList<>();
        }
        this.meteringCharges.add(meteringChargesItem);
        return this;
    }

    /**
     * Charges for metering included in the plan
     *
     * @return meteringCharges
     */
    @ApiModelProperty(value = "Charges for metering included in the plan")

    @Valid

    public List<TelcoProductDetailMeteringCharges> getMeteringCharges() {
        return meteringCharges;
    }

    public void setMeteringCharges(List<TelcoProductDetailMeteringCharges> meteringCharges) {
        this.meteringCharges = meteringCharges;
    }

    public TelcoProductDetail bundles(List<TelcoProductDetailBundles> bundles) {
        this.bundles = bundles;
        return this;
    }

    public TelcoProductDetail addBundlesItem(TelcoProductDetailBundles bundlesItem) {
        if (this.bundles == null) {
            this.bundles = new ArrayList<>();
        }
        this.bundles.add(bundlesItem);
        return this;
    }

    /**
     * Bundles the product can be part of
     *
     * @return bundles
     */
    @ApiModelProperty(value = "Bundles the product can be part of")

    @Valid

    public List<TelcoProductDetailBundles> getBundles() {
        return bundles;
    }

    public void setBundles(List<TelcoProductDetailBundles> bundles) {
        this.bundles = bundles;
    }

    public TelcoProductDetail plans(List<TelcoProductDetailPlan> plans) {
        this.plans = plans;
        return this;
    }

    public TelcoProductDetail addPlansItem(TelcoProductDetailPlan plansItem) {
        if (this.plans == null) {
            this.plans = new ArrayList<>();
        }
        this.plans.add(plansItem);
        return this;
    }

    /**
     * Plans associated to the product
     *
     * @return plans
     */
    @ApiModelProperty(value = "Plans associated to the product")

    @Valid

    public List<TelcoProductDetailPlan> getPlans() {
        return plans;
    }

    public void setPlans(List<TelcoProductDetailPlan> plans) {
        this.plans = plans;
    }

    public TelcoProductDetail discounts(List<TelcoProductDetailDiscounts> discounts) {
        this.discounts = discounts;
        return this;
    }

    public TelcoProductDetail addDiscountsItem(TelcoProductDetailDiscounts discountsItem) {
        if (this.discounts == null) {
            this.discounts = new ArrayList<>();
        }
        this.discounts.add(discountsItem);
        return this;
    }

    /**
     * Discounts associated to the product
     *
     * @return discounts
     */
    @ApiModelProperty(value = "Discounts associated to the product")

    @Valid

    public List<TelcoProductDetailDiscounts> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<TelcoProductDetailDiscounts> discounts) {
        this.discounts = discounts;
    }

    public TelcoProductDetail incentives(List<TelcoProductDetailIncentives> incentives) {
        this.incentives = incentives;
        return this;
    }

    public TelcoProductDetail addIncentivesItem(TelcoProductDetailIncentives incentivesItem) {
        if (this.incentives == null) {
            this.incentives = new ArrayList<>();
        }
        this.incentives.add(incentivesItem);
        return this;
    }

    /**
     * Incentives associated to the product
     *
     * @return incentives
     */
    @ApiModelProperty(value = "Incentives associated to the product")

    @Valid

    public List<TelcoProductDetailIncentives> getIncentives() {
        return incentives;
    }

    public void setIncentives(List<TelcoProductDetailIncentives> incentives) {
        this.incentives = incentives;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TelcoProductDetail telcoProductDetail = (TelcoProductDetail) o;
        return Objects.equals(this.meteringCharges, telcoProductDetail.meteringCharges) &&
                Objects.equals(this.bundles, telcoProductDetail.bundles) &&
                Objects.equals(this.plans, telcoProductDetail.plans) &&
                Objects.equals(this.discounts, telcoProductDetail.discounts) &&
                Objects.equals(this.incentives, telcoProductDetail.incentives);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meteringCharges, bundles, plans, discounts, incentives);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TelcoProductDetail {\n");

        sb.append("    meteringCharges: ").append(toIndentedString(meteringCharges)).append("\n");
        sb.append("    bundles: ").append(toIndentedString(bundles)).append("\n");
        sb.append("    plans: ").append(toIndentedString(plans)).append("\n");
        sb.append("    discounts: ").append(toIndentedString(discounts)).append("\n");
        sb.append("    incentives: ").append(toIndentedString(incentives)).append("\n");
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

