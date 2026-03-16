package ex6;

import java.util.List;
import java.util.Random;

// quay ban ve
public class TicketBooth implements Runnable {
    private int boothId;
    private List<Room> rooms;
    private Statistics statistics;
    private volatile boolean running = true;
    private volatile boolean paused = false;

    public TicketBooth(int boothId, List<Room> rooms, Statistics statistics) {
        this.boothId = boothId;
        this.rooms = rooms;
        this.statistics = statistics;
    }

    public void pauseBooth() {
        paused = true;
    }

    public void resumeBooth() {
        paused = false;
    }

    public void stopBooth() {
        running = false;
    }

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("Quay " + boothId + " bat dau ban ve...");
        while (running) {
            try {
                if (paused) {
                    Thread.sleep(500);
                    continue;
                }
                Room room = rooms.get(random.nextInt(rooms.size()));
                if (room.sellTicket()) {
                    statistics.addRevenue(250000);
                    System.out.println("Quay " + boothId + " ban 1 ve phong " + room.getName());
                }
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
