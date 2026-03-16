package ex6.factory;

import ex6.discount.DiscountStrategy;
import ex6.discount.MobileDiscount;
import ex6.notification.NotificationService;
import ex6.notification.PushNotification;
import ex6.payment.MomoPayment;
import ex6.payment.PaymentMethod;

public class MobileFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscount() {
        return new MobileDiscount();
    }

    public PaymentMethod createPayment() {
        return new MomoPayment();
    }

    public NotificationService createNotification() {
        return new PushNotification();
    }
}
