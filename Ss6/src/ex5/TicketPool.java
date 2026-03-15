package ex5;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    private String roomName;
    private List<Ticket> tickets;
    public TicketPool(String roomName, int capacity) {
        this.roomName = roomName;
        tickets = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            boolean vip = i <= 2; // 2 ve VIP dau tien
            String id = roomName + "-" + String.format("%03d", i);
            tickets.add(new Ticket(id, roomName, vip));
        }
    }

    // giu mot ve cho khach
    public synchronized Ticket holdTicket(String counterName, boolean vipRequest) {
        for (Ticket t : tickets) {
            if (!t.isSold() && !t.isHeld()) {
                if (!vipRequest || t.isVIP()) {
                    t.hold(counterName);
                    System.out.println(counterName + ": Da giu ve " + t.getTicketId() + (t.isVIP() ? " (VIP)" : "") + ". Thanh toan trong 5s");
                    return t;
                }
            }
        }
        return null;
    }

    // thanh toan ve dang giu
    public synchronized void sellHeldTicket(Ticket t, String counterName) {
        if (t != null && t.isHeld() && counterName.equals(t.getHeldBy())) {
            t.sell();
            System.out.println(counterName + ": Thanh toan thanh cong ve " + t.getTicketId());
        }
    }

    // tra lai ve het han giu
    public synchronized void releaseExpiredTickets() {
        long now = System.currentTimeMillis();
        for (Ticket t : tickets) {
            if (t.isHeld() && now > t.getHoldExpiryTime()) {
                System.out.println("TimeoutManager: Ve " + t.getTicketId() + " het han giu, da tra lai kho");
                t.release();
            }
        }
    }
    public String getRoomName() {
        return roomName;
    }
}
