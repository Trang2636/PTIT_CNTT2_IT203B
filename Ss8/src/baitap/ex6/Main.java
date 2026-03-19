package baitap.ex6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Chon kenh ban hang:");
        System.out.println("1. Website");
        System.out.println("2. Mobile");
        System.out.println("3. POS");

        int choice = sc.nextInt();

        SalesChannelFactory factory = null;

        if (choice == 1) {
            factory = new WebsiteFactory();
            System.out.println("Ban da chon Website");
        } else if (choice == 2) {
            factory = new MobileAppFactory();
            System.out.println("Ban da chon Mobile");
        } else if (choice == 3) {
            factory = new POSFactory();
            System.out.println("Ban da chon POS");
        }

        OrderService service = new OrderService(factory);

        System.out.println("Nhap gia san pham:");
        double price = sc.nextDouble();

        System.out.println("Nhap so luong:");
        int qty = sc.nextInt();

        service.processOrder(price, qty);
    }
}