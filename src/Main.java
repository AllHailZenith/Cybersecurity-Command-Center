import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LegacyFirewall legacyFirewall = new LegacyFirewall();
        SecurityLog securityLog = new FirewallAdapter(legacyFirewall);

        NetworkTrafficController network = new NetworkTrafficController();
        UserAccessManager access = new UserAccessManager();
        EncryptionService encryption = new EncryptionService();

        CommandCenterFacade commandCenter = new CommandCenterFacade(
                network, access, encryption
        );

        System.out.println("=== Cybersecurity Command Center ===");

        System.out.print("Enter security event message: ");
        String message = scanner.nextLine();

        System.out.print("Enter severity level (1-5): ");
        int severity = scanner.nextInt();
        scanner.nextLine();

        securityLog.logEvent(message);
        securityLog.setSeverity(severity);

        boolean running = true;

        while (running) {
            System.out.println("\nChoose a security operation:");
            System.out.println("1. Lockdown");
            System.out.println("2. Lift Lockdown");
            System.out.println("3. Maintenance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    commandCenter.initiateEmergencyLockdown();
                    break;
                case "2":
                    commandCenter.liftEmergencyLockdown();
                    break;
                case "3":
                    commandCenter.enableMaintenanceMode();
                    break;
                case "4":
                    running = false;
                    System.out.println("Exiting Command Center.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}