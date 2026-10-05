public class Main {
    public static void main(String[] args) {
        LegacyFirewall legacyFirewall = new LegacyFirewall();
        SecurityLog securityLog = new FirewallAdapter(legacyFirewall);

        securityLog.logEvent("Suspicious network activity detected.");
        securityLog.setSeverity(3);
    }
}