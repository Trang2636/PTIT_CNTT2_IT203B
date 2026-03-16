package ex6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CinemaSystem {
    private List<Room> rooms = new ArrayList<>();
    private List<TicketBooth> booths = new ArrayList<>();
    private ExecutorService executor;

    private Statistics statistics = new Statistics();
    public void startSimulation(int roomCount, int ticketsPerRoom, int boothCount) {
        executor = Executors.newFixedThreadPool(boothCount);
        for (int i = 0; i < roomCount; i++) {
            char name = (char) ('A' + i);
            rooms.add(new Room(ticketsPerRoom, String.valueOf(name)));
        }

        for (int i = 1; i <= boothCount; i++) {
            TicketBooth booth = new TicketBooth(i, rooms, statistics);
            booths.add(booth);
            executor.submit(booth);
        }

        System.out.println("Da khoi tao he thong voi "
                + roomCount + " phong, "
                + (roomCount * ticketsPerRoom)
                + " ve, "
                + boothCount + " quay.");
    }

    public void pauseSimulation() {
        for (TicketBooth booth : booths) {
            booth.pauseBooth();
        }
        System.out.println("Da tam dung tat ca quay ban ve.");
    }

    public void resumeSimulation() {
        for (TicketBooth booth : booths) {
            booth.resumeBooth();
        }
        System.out.println("Da tiep tuc hoat dong.");
    }

    public void showStatistics() {
        statistics.printStatistics(rooms);
    }

    public void detectDeadlock() {
        new DeadlockDetector().run();
    }

    public void shutdown() {
        for (TicketBooth booth : booths) {
            booth.stopBooth();
        }
        executor.shutdown();
        System.out.println("Dang dung he thong...");
    }
}
