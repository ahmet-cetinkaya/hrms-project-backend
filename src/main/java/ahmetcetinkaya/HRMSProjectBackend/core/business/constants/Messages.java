package ahmetcetinkaya.HRMSProjectBackend.core.business.constants;

public class Messages {
    public final String entityAdded;
    public final String entityUpdated;
    public final String entityDeleted;
    public final String entityNotFound;

    public Messages(String entityName) {
        entityAdded = entityName + " has added.";
        entityUpdated = entityName + " has updated.";
        entityDeleted = entityName + " has deleted.";
        entityNotFound = entityName + " not found.";
    }
}
