package ex4.notification;

public class EmailService implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Gui email: " + message);
    }
}