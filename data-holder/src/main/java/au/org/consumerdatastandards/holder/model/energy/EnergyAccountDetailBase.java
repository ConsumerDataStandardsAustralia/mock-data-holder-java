package au.org.consumerdatastandards.holder.model.energy;

import java.util.List;

public interface EnergyAccountDetailBase extends EnergyAccountBase {

    EnergyAccountBase plans(List<EnergyAccountDetailPlans> plans);

    EnergyAccountBase addPlansItem(EnergyAccountDetailPlans plansItem);

    List<EnergyAccountDetailPlans> getPlans();

    void setPlans(List<EnergyAccountDetailPlans> plans);
}
