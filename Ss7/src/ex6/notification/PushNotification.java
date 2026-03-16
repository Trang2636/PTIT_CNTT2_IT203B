package ex6.notification;

public class PushNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Gui push notification: Don hang thanh cong");
    }
}
