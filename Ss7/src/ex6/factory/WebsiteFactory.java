package ex6.factory;

import ex6.discount.DiscountStrategy;
import ex6.discount.WebDiscount;
import ex6.notification.EmailNotification;
import ex6.notification.NotificationService;
import ex6.payment.CreditCardPayment;
import ex6.payment.PaymentMethod;

public class WebsiteFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscount() {
        return new WebDiscount();
    }

    public PaymentMethod createPayment() {
        return new CreditCardPayment();
    }

    public NotificationService createNotification() {
        return new EmailNotification();
    }
}
