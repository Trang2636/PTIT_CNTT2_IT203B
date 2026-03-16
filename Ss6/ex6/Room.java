package ex6;

import java.util.concurrent.atomic.AtomicInteger;

public class Room {
    private String name;
    private int totalTickets;
    private AtomicInteger soldTickets = new AtomicInteger(0);

    public Room(int totalTickets, String name) {
        this.totalTickets = totalTickets;
        this.name = name;
    }

    // ban 1 ve
    public synchronized boolean sellTicket(){
        if(soldTickets.get()< totalTickets){
            soldTickets.incrementAndGet();
            return true;
        }
        return false;
    }

    public int getSoldTickets(){
        return soldTickets.get();
    }
    public int getTotalTickets() {
        return totalTickets;
    }
    public String getName() {
        return name;
    }
}
