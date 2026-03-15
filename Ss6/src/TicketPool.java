import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    private String roomName;
    private List<Ticket> tickets;
    public TicketPool(String roomName, int totalTickets) {
        this.roomName = roomName;
        tickets = new ArrayList<>();
        for (int i = 1; i <= totalTickets; i++) {
            String id = roomName + "-" + String.format("%03d", i);
            tickets.add(new Ticket(id, roomName));
        }
    }

    // ban mot ve
    // neu het ve thi thread se cho bang wait()
    public synchronized Ticket sellTicket() {
        while (true) {
            for (Ticket t : tickets) {
                if (!t.isSold()) {
                    t.setSold(true);
                    return t;
                }
            }

            try {
                System.out.println("Het ve phong " + roomName + ", dang cho...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // lay mot ve chua ban (dung cho ban combo)
    public Ticket getAvailableTicket() {
        for (Ticket t : tickets) {
            if (!t.isSold()) {
                return t;
            }
        }

        return null;
    }

    // nha cung cap them ve moi
    // sau khi them ve se danh thuc cac thread dang cho
    public synchronized void addTickets(int count) {
        int start = tickets.size() + 1;
        for (int i = 0; i < count; i++) {
            String id = roomName + "-" + String.format("%03d", start + i);
            tickets.add(new Ticket(id, roomName));
        }

        System.out.println("Nha cung cap: da them " + count + " ve vao phong " + roomName);
        notifyAll();
    }

    // kiem tra phong con ve hay khong
    public boolean hasTickets() {
        for (Ticket t : tickets) {
            if (!t.isSold()) {
                return true;
            }
        }
        return false;
    }

    // dem so ve con lai
    public int remainingTickets() {
        int count = 0;
        for (Ticket t : tickets) {
            if (!t.isSold()) {
                count++;
            }
        }
        return count;
    }

    public String getRoomName() {
        return roomName;
    }
}