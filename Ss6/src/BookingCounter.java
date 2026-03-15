import java.util.Random;

public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;

    private int soldCount = 0;

    private Random random = new Random();

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }

    // lay tong so ve da ban
    public int getSoldCount() {
        return soldCount;
    }

    // ban ve thuong
    public void sellNormalTicket() {
        Ticket ticket;
        if (random.nextBoolean()) {
            System.out.println(counterName + " ban ve phong A");
            ticket = roomA.sellTicket();
        } else {
            System.out.println(counterName + " ban ve phong B");
            ticket = roomB.sellTicket();
        }
        if (ticket != null) {
            soldCount++;
            System.out.println(counterName + " da ban ve " + ticket.getTicketId());
        }
    }

    // ban ve combo
    // can khoa ca hai phong de tranh loi tranh chap du lieu
    public void sellComboTicket() {
        synchronized (roomA) {
            synchronized (roomB) {
                Ticket ticketA = roomA.getAvailableTicket();
                Ticket ticketB = roomB.getAvailableTicket();
                if (ticketA != null && ticketB != null) {
                    ticketA.setSold(true);
                    ticketB.setSold(true);
                    soldCount++;
                    System.out.println(counterName +
                            " ban combo thanh cong: " +
                            ticketA.getTicketId() +
                            " & " +
                            ticketB.getTicketId());
                }
                else {
                    System.out.println(counterName +
                            " khong du ve de ban combo");
                }
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            // ban ve thuong (dung cho K1 K2 K4)
            sellNormalTicket();
            try {
                Thread.sleep(200);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}