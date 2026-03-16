package ex4.service;

import ex4.model.Order;
import ex4.notification.NotificationService;
import ex4.repository.OrderRepository;

public class OrderService {
    private OrderRepository orderRepository;
    private NotificationService notificationService;

    public OrderService(OrderRepository orderRepository, NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
        notificationService.send("Don hang " + order.getId() + " da duoc tao", "customer");
    }
}
