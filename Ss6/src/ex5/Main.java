package ex5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TicketPool roomA = new TicketPool("A", 10);
        TicketPool roomB = new TicketPool("B", 8);
        TicketPool roomC = new TicketPool("C", 12);

        List<TicketPool> pools = new ArrayList<>();
        pools.add(roomA);
        pools.add(roomB);
        pools.add(roomC);

        // tao 5 quay ban ve
        for (int i = 1; i <= 5; i++) {
            Thread t = new Thread(
                    new BookingCounter("Quay " + i, pools)
            );
            t.start();
        }
        // thread quan ly timeout
        Thread timeoutThread = new Thread(
                new TimeoutManager(pools)
        );
        timeoutThread.start();
    }
}
