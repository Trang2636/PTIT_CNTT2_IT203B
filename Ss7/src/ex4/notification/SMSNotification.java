package ex4.notification;

public class SMSNotification implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Gui SMS: " + message);
    }
}
