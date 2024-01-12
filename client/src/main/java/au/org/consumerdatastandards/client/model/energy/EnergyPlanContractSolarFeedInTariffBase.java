package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

public class EnergyPlanContractSolarFeedInTariffBase implements EnergyPlanContractSolarFeedInTariff {
    private String displayName;
    private String description;
    private SchemeEnum scheme;
    private PayerTypeEnum payerType;
    private TariffUTypeEnum tariffUType;

    public EnergyPlanContractSolarFeedInTariffBase displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The name of the tariff
     *
     * @return displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public EnergyPlanContractSolarFeedInTariffBase description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the tariff
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnergyPlanContractSolarFeedInTariffBase scheme(SchemeEnum scheme) {
        this.scheme = scheme;
        return this;
    }

    /**
     * The applicable scheme
     *
     * @return scheme
     */
    public SchemeEnum getScheme() {
        return scheme;
    }

    public void setScheme(SchemeEnum scheme) {
        this.scheme = scheme;
    }

    public EnergyPlanContractSolarFeedInTariffBase payerType(PayerTypeEnum payerType) {
        this.payerType = payerType;
        return this;
    }

    /**
     * The type of the payer
     *
     * @return payerType
     */
    public PayerTypeEnum getPayerType() {
        return payerType;
    }

    public void setPayerType(PayerTypeEnum payerType) {
        this.payerType = payerType;
    }

    public EnergyPlanContractSolarFeedInTariffBase tariffUType(TariffUTypeEnum tariffUType) {
        this.tariffUType = tariffUType;
        return this;
    }

    /**
     * The type of the payer
     *
     * @return tariffUType
     */
    public TariffUTypeEnum getTariffUType() {
        return tariffUType;
    }

    public void setTariffUType(TariffUTypeEnum tariffUType) {
        this.tariffUType = tariffUType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractSolarFeedInTariffBase energyPlanContractSolarFeedInTariff = (EnergyPlanContractSolarFeedInTariffBase) o;
        return Objects.equals(this.displayName, energyPlanContractSolarFeedInTariff.displayName) &&
                Objects.equals(this.description, energyPlanContractSolarFeedInTariff.description) &&
                Objects.equals(this.scheme, energyPlanContractSolarFeedInTariff.scheme) &&
                Objects.equals(this.payerType, energyPlanContractSolarFeedInTariff.payerType) &&
                Objects.equals(this.tariffUType, energyPlanContractSolarFeedInTariff.tariffUType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, description, scheme, payerType, tariffUType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ").append(getClass().getSimpleName()).append(" {");
        writeProperties(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void writeProperties(StringBuilder sb) {
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    scheme: ").append(toIndentedString(scheme)).append("\n");
        sb.append("    payerType: ").append(toIndentedString(payerType)).append("\n");
        sb.append("    tariffUType: ").append(toIndentedString(tariffUType)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o Object
     * @return Indented string representation of <code>o</code>
     */
    protected String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
