package au.org.consumerdatastandards.support.model;

import au.org.consumerdatastandards.support.data.DataDefinition;

public class DataDefinitionModel extends ModelBase {

    private final DataDefinition dataDefinition;

    private final Class dataType;

    public DataDefinitionModel(DataDefinition dataDefinition, Class dataType) {

        this.dataDefinition = dataDefinition;
        this.dataType = dataType;
    }

    public DataDefinition getDataDefinition() {
        return dataDefinition;
    }

    public Class getDataType() {
        return dataType;
    }
}