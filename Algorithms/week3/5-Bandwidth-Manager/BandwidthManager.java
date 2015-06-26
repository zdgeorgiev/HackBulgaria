public class BandwidthManager {

    private final String EMPTY_QUEUE = "Nothing to send!";

    private PriorityQueue pq;

    public BandwidthManager() {
        this.pq = new PriorityQueue();
    }

    // receives a packet with specified protocol and payload
    public void rcv(String protocol, String payload) {
        Packet p = null;

        switch (protocol) {
            case "ICMP":
                p = new Packet(6);
                break;
            case "UDP":
                p = new Packet(5);
                break;
            case "RTM":
                p = new Packet(4);
                break;
            case "IGMP":
                p = new Packet(3);
                break;
            case "DNS":
                p = new Packet(2);
                break;
            case "TCP":
                p = new Packet(1);
                break;

            default:
                throw new IllegalArgumentException("Invalid protocol");
        }

        p.setContent(payload);

        this.pq.push(p);
    }

    // returns the payload of the packet which should be sent
    public String send() {
        Packet recievedPacket = this.pq.pop();
        String outputMessage = "";

        if (recievedPacket == null) {
            outputMessage = this.EMPTY_QUEUE;
        } else {
            outputMessage = recievedPacket.getContent();
        }

        return outputMessage;
    }
}