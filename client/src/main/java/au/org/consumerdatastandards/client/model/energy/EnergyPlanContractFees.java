package au.org.consumerdatastandards.client.model.energy;

import java.util.Objects;

/**
 * EnergyPlanContractFees
 */
public class EnergyPlanContractFees {
    /**
     * The type of the fee
     */
    public enum TypeEnum {
        EXIT,
        ESTABLISHMENT,
        LATE_PAYMENT,
        DISCONNECTION,
        DISCONNECT_MOVE_OUT,
        DISCONNECT_NON_PAY,
        RECONNECTION,
        CONNECTION,
        PAYMENT_PROCESSING,
        CC_PROCESSING,
        CHEQUE_DISHONOUR,
        DD_DISHONOUR,
        MEMBERSHIP,
        CONTRIBUTION,
        PAPER_BILL,
        OTHER
    }

    private TypeEnum type;

    /**
     * The term of the fee
     */
    public enum TermEnum {
        FIXED("FIXED"),
        _1_YEAR("1_YEAR"),
        _2_YEAR("2_YEAR"),
        _3_YEAR("3_YEAR"),
        _4_YEAR("4_YEAR"),
        _5_YEAR("5_YEAR"),
        PERCENT_OF_BILL("PERCENT_OF_BILL"),
        ANNUAL("ANNUAL"),
        DAILY("DAILY"),
        WEEKLY("WEEKLY"),
        MONTHLY("MONTHLY"),
        BIANNUAL("BIANNUAL"),
        VARIABLE("VARIABLE");

        private final String value;

        TermEnum(String value) {
            this.value = value;
        }

//        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

//        @JsonCreator
        public static TermEnum fromValue(String value) {
            for (TermEnum b : TermEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    private TermEnum term;

    private String amount;

    private String rate;

    private String description;

    public EnergyPlanContractFees type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the fee
     *
     * @return type
     */
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public EnergyPlanContractFees term(TermEnum term) {
        this.term = term;
        return this;
    }

    /**
     * The term of the fee
     *
     * @return term
     */
    public TermEnum getTerm() {
        return term;
    }

    public void setTerm(TermEnum term) {
        this.term = term;
    }

    public EnergyPlanContractFees amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The fee amount. Required if term is not PERCENT_OF_BILL
     *
     * @return amount
     */
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public EnergyPlanContractFees rate(String rate) {
        this.rate = rate;
        return this;
    }

    /**
     * The fee rate. Required if term is PERCENT_OF_BILL
     *
     * @return rate
     */
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public EnergyPlanContractFees description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the fee
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyPlanContractFees energyPlanContractFees = (EnergyPlanContractFees) o;
        return Objects.equals(this.type, energyPlanContractFees.type) &&
                Objects.equals(this.term, energyPlanContractFees.term) &&
                Objects.equals(this.amount, energyPlanContractFees.amount) &&
                Objects.equals(this.rate, energyPlanContractFees.rate) &&
                Objects.equals(this.description, energyPlanContractFees.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, term, amount, rate, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnergyPlanContractFees {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    term: ").append(toIndentedString(term)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
