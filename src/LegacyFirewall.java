public class LegacyFirewall {
    public void recordActivity(String msg) {
        System.out.println("Legacy Firewall Activity: " + msg);
    }

    public void setAlertLevel(int level) {
        System.out.println("Legacy Firewall Alert Level: " + level);
    }
}