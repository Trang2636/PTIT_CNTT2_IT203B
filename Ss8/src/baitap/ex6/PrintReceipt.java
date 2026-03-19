package baitap.ex6;

public class PrintReceipt implements NotificationService {
    public void notifyUser(String message) {
        System.out.println("In hoa don: " + message);
    }
}