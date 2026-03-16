package ex6;

import java.util.List;

public class Statistics {
    private int revenue=0;
    public synchronized void addRevenue(int price){
        revenue+=price;
    }

    public void printStatistics(List<Room> rooms) {
        System.out.println("\n=== Thong Ke Hien Tai ===");
        for(Room room : rooms){
            System.out.println(
                    "Phong " + room.getName() + ": Da ban " + room.getSoldTickets() + "/" + room.getTotalTickets() + " ve"
            );
        }
        System.out.println("Tong doanh thu: " + revenue + " VND");
    }
}
