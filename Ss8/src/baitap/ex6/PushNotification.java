package baitap.ex6;

public class PushNotification implements NotificationService {
    public void notifyUser(String message) {
        System.out.println("Gui push notification: " + message);
    }
}
