package ex6;

public class Ticket {
    private String roomName;
    private int price;

    public Ticket(String roomName, int price) {
        this.roomName = roomName;
        this.price = price;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getPrice() {
        return price;
    }
}
