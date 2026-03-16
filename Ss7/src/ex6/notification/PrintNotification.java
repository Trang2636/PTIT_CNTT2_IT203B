package ex6.notification;

public class PrintNotification implements NotificationService {
    public void send(String message) {
        System.out.println("In hoa don giay tai POS");
    }
}
