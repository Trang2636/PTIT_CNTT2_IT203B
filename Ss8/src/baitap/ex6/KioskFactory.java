package baitap.ex6;

public class KioskFactory implements SalesChannelFactory {
    public DiscountStrategy createDiscountStrategy() {
        return new MemberDiscount();
    }

    public PaymentMethod createPaymentMethod() {
        return new CODPayment();
    }

    public NotificationService createNotificationService() {
        return new PrintReceipt();
    }
}