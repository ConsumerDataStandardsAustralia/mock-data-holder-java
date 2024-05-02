package au.org.consumerdatastandards.holder.model.energy;

/**
* Used to filter results according to open/closed status. Values can be OPEN, CLOSED or ALL. If absent then ALL is assumed
*/
public enum ParamAccountOpenStatus {

    ALL,
    
    CLOSED,
    
    OPEN
}
