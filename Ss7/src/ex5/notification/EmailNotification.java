package ex5.notification;

public class EmailNotification implements NotificationService {
    public void send(String message, String to) {
        System.out.println("Da gui email: " + message);
    }
}