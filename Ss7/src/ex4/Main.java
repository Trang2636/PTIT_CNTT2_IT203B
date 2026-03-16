package ex4;

import ex4.model.Order;
import ex4.notification.EmailService;
import ex4.notification.NotificationService;
import ex4.notification.SMSNotification;
import ex4.repository.DatabaseOrderRepository;
import ex4.repository.FileOrderRepository;
import ex4.repository.OrderRepository;
import ex4.service.OrderService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dung FileOrderRepository va EmailService");
        OrderRepository repo1 = new FileOrderRepository();
        NotificationService notify1 = new EmailService();
        OrderService orderService1 = new OrderService(repo1, notify1);
        Order order1 = new Order("ORD001");
        orderService1.createOrder(order1);

        System.out.println();
        System.out.println("Doi sang DatabaseOrderRepository va SMSNotification");

        OrderRepository repo2 = new DatabaseOrderRepository();
        NotificationService notify2 = new SMSNotification();
        OrderService orderService2 = new OrderService(repo2, notify2);
        Order order2 = new Order("ORD002");
        orderService2.createOrder(order2);

    }
}
