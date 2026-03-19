package baitap.ex6;

public class OrderService {

    private DiscountStrategy discount;
    private PaymentMethod payment;
    private NotificationService notification;

    public OrderService(SalesChannelFactory factory) {
        this.discount = factory.createDiscountStrategy();
        this.payment = factory.createPaymentMethod();
        this.notification = factory.createNotificationService();
    }

    public void processOrder(double price, int quantity) {

        double total = price * quantity;

        System.out.println("Tong tien: " + total);

        double finalAmount = discount.applyDiscount(total);

        payment.pay(finalAmount);

        notification.notifyUser("Don hang thanh cong");
    }
}
