package ex5.service;

import ex5.discount.DiscountStrategy;
import ex5.model.Order;
import ex5.notification.NotificationService;
import ex5.payment.PaymentMethod;
import ex5.repository.OrderRepository;

// xu ly tao don hang
public class OrderService {
    private OrderRepository repository;
    private NotificationService notification;

    public OrderService(OrderRepository repository, NotificationService notification) {
        this.repository = repository;
        this.notification = notification;
    }

    public void createOrder(Order order, DiscountStrategy discount, PaymentMethod payment) {
        double total = order.getTotal();
        double finalAmount = discount.applyDiscount(total);
        payment.pay(finalAmount);
        repository.save(order);
        notification.send("Don hang " + order.getId() + " da duoc tao", order.getCustomer().getEmail());
    }
}
