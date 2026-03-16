package ex6;

import ex6.discount.DiscountStrategy;
import ex6.factory.MobileFactory;
import ex6.factory.POSFactory;
import ex6.factory.SalesChannelFactory;
import ex6.factory.WebsiteFactory;
import ex6.notification.NotificationService;
import ex6.payment.PaymentMethod;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chon kenh ban:");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. Store POS");
        int choice = sc.nextInt();

        SalesChannelFactory factory = null;

        switch (choice) {
            case 1:
                factory = new WebsiteFactory();
                System.out.println("Ban da chon kenh Website");
                break;
            case 2:
                factory = new MobileFactory();
                System.out.println("Ban da chon kenh Mobile");
                break;
            case 3:
                factory = new POSFactory();
                System.out.println("Ban da chon kenh POS");
                break;
        }

        double total = 1000000;
        DiscountStrategy discount = factory.createDiscount();
        PaymentMethod payment = factory.createPayment();
        NotificationService notify = factory.createNotification();
        double finalAmount = discount.applyDiscount(total);
        payment.pay(finalAmount);
        notify.send("Don hang thanh cong");
    }
}
