package baitap.ex6;

public class EmailNotification implements NotificationService {
    public void notifyUser(String message) {
        System.out.println("Gui email: " + message);
    }
}
