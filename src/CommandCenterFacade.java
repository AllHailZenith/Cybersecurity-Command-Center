import java.util.Arrays;
import java.util.List;

public class CommandCenterFacade {
    private final NetworkTrafficController network;
    private final UserAccessManager access;
    private final EncryptionService encryption;

    private final List<String> compromisedUsers = Arrays.asList(
            "admin_temp",
            "guest_user_1",
            "service_acct"
    );

    private final String databaseName = "Customer_Records";

    public CommandCenterFacade(
            NetworkTrafficController network,
            UserAccessManager access,
            EncryptionService encryption) {
        this.network = network;
        this.access = access;
        this.encryption = encryption;
    }

    public void initiateEmergencyLockdown() {
        System.out.println("\n=== Initiating Emergency Lockdown ===");
        network.blockPort(8080);
        network.blockPort(443);
        access.lockUserAccounts(compromisedUsers);
        encryption.encryptDatabase(databaseName);
        network.divertTraffic();
        System.out.println("Emergency lockdown complete.");
    }

    public void liftEmergencyLockdown() {
        System.out.println("\n=== Lifting Emergency Lockdown ===");
        network.unblockPort(8080);
        network.unblockPort(443);
        access.unlockUserAccounts(compromisedUsers);
        encryption.decryptDatabase(databaseName);
        System.out.println("Emergency lockdown lifted.");
    }

    public void enableMaintenanceMode() {
        System.out.println("\n=== Enabling Maintenance Mode ===");
        network.divertTraffic();
        access.grantAdminAccess("maintenance_admin");
        encryption.verifyIntegrity();
        System.out.println("Maintenance mode enabled.");
    }
}