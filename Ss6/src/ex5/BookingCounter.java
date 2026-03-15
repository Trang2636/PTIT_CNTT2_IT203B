package ex5;

import java.util.List;
import java.util.Random;

public class BookingCounter implements Runnable {
    private String counterName;
    private List<TicketPool> pools;
    private Random random = new Random();
    public BookingCounter(String counterName, List<TicketPool> pools) {
        this.counterName = counterName;
        this.pools = pools;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // chon phong ngau nhien
                TicketPool pool = pools.get(random.nextInt(pools.size()));
                // xac dinh dat ve VIP hay thuong
                boolean vip = random.nextInt(5) == 0;
                Ticket ticket = pool.holdTicket(counterName, vip);
                if (ticket != null) {
                    Thread.sleep(3000);
                    // 50% khach se thanh toan
                    if (random.nextBoolean()) {
                        pool.sellHeldTicket(ticket, counterName);
                    } else {
                        System.out.println(counterName + ": Khach bo di, khong thanh toan ve "+ ticket.getTicketId());
                    }
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
