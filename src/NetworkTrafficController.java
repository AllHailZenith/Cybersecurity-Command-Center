public class NetworkTrafficController {
    public void blockPort(int port) {
        System.out.println("Network: Blocking port " + port);
    }

    public void unblockPort(int port) {
        System.out.println("Network: Unblocking port " + port);
    }

    public void divertTraffic() {
        System.out.println("Network: Diverting traffic to the honeypot.");
    }

    public void monitorPacketLoss() {
        System.out.println("Network: Monitoring packet loss.");
    }
}