package ex6.factory;

import ex6.discount.DiscountStrategy;
import ex6.discount.POSDiscount;
import ex6.notification.NotificationService;
import ex6.notification.PrintNotification;
import ex6.payment.CashPayment;
import ex6.payment.PaymentMethod;

public class POSFactory implements SalesChannelFactory {
    public DiscountStrategy createDiscount() {
        return new POSDiscount();
    }

    public PaymentMethod createPayment() {
        return new CashPayment();
    }

    public NotificationService createNotification() {
        return new PrintNotification();
    }
}
