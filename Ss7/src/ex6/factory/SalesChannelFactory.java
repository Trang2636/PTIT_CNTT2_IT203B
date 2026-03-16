package ex6.factory;

import ex6.discount.DiscountStrategy;
import ex6.notification.NotificationService;
import ex6.payment.PaymentMethod;

public interface SalesChannelFactory {
    DiscountStrategy createDiscount();
    PaymentMethod createPayment();
    NotificationService createNotification();
}
