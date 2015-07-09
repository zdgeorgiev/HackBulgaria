import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BandwidthManager {

    public static class Packet {

        private int priority;
        private int enterAsIndex;
        private String content;

        public Packet(int priority) {
            this.setPriority(priority);
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getEnterAsIndex() {
            return enterAsIndex;
        }

        public void setEnterAsIndex(int enterAsIndex) {
            this.enterAsIndex = enterAsIndex;
        }
    }

    private final String EMPTY_QUEUE = "Nothing to send!";

    private Queue<BandwidthManager.Packet> pq;

    public BandwidthManager() {

        this.pq = new PriorityQueue<BandwidthManager.Packet>(new Comparator<BandwidthManager.Packet>() {

            @Override
            public int compare(BandwidthManager.Packet o1, BandwidthManager.Packet o2) {

                if (o1.priority != o2.priority) {
                    return Integer.compare(o2.priority, o1.priority);
                }

                return Integer.compare(o1.enterAsIndex, o2.enterAsIndex);
            }

        });
    }

    // returns the payload of the packet which should be sent
    public void send() {
        BandwidthManager.Packet recievedPacket = this.pq.poll();
        String outputMessage = "";

        if (recievedPacket == null) {
            outputMessage = this.EMPTY_QUEUE;
        } else {
            outputMessage = recievedPacket.getContent();
        }

        System.out.println(outputMessage);
    }

    // receives a packet with specified protocol and payload
    public void rcv(String protocol, String payload, int index) {
        BandwidthManager.Packet p = null;

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
        p.setEnterAsIndex(index);

        this.pq.add(p);
    }
}