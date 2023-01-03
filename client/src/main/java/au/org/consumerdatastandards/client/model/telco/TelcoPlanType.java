package au.org.consumerdatastandards.client.model.telco;

/**
 * Plan type for this feature. METERED: A plan is charged by usage for the feature. UNMETERED: A plan with no limits for a feature. LIMITED: Where plan limit inclusions apply. UNSUPPORTED: Feature is not supported
 */
public enum TelcoPlanType {
    METERED,
    UNMETERED,
    LIMITED,
    UNSUPPORTED
}
