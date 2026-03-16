package ex6.notification;

public class EmailNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Gui email xac nhan");
    }
}
