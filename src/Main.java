import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LegacyFirewall legacyFirewall = new LegacyFirewall();
        SecurityLog securityLog = new FirewallAdapter(legacyFirewall);

        NetworkTrafficController network = new NetworkTrafficController();
        UserAccessManager access = new UserAccessManager();
        EncryptionService encryption = new EncryptionService();

        List<String> compromisedUsers = Arrays.asList(
                "admin_temp",
                "guest_user_1",
                "service_acct"
        );

        System.out.println("=== Security Log Test ===");
        securityLog.logEvent("Suspicious network activity detected.");
        securityLog.setSeverity(3);

        System.out.println("\n=== Emergency Breach ===");
        network.blockPort(8080);
        network.blockPort(443);
        access.lockUserAccounts(compromisedUsers);
        encryption.encryptDatabase("Customer_Records");
        network.divertTraffic();

        System.out.println("\n=== All-Clear ===");
        network.unblockPort(8080);
        network.unblockPort(443);
        access.unlockUserAccounts(compromisedUsers);
        encryption.decryptDatabase("Customer_Records");

        System.out.println("\n=== Emergency Resolved ===");
    }
}