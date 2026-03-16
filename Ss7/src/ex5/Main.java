package ex5;

import ex5.discount.DiscountStrategy;
import ex5.discount.FixedDiscount;
import ex5.discount.HolidayDiscount;
import ex5.discount.PercentageDiscount;
import ex5.model.Customer;
import ex5.model.Order;
import ex5.model.OrderItem;
import ex5.model.Product;
import ex5.notification.EmailNotification;
import ex5.notification.NotificationService;
import ex5.payment.*;
import ex5.repository.FileOrderRepository;
import ex5.repository.OrderRepository;
import ex5.service.OrderService;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static List<Product> products = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();

    static Map<Integer, DiscountStrategy> discountMap = new HashMap<>();

    static Map<Integer, PaymentMethod> paymentMap = new HashMap<>();

    public static void main(String[] args) {
        // repository + notification (DIP)
        OrderRepository repo = new FileOrderRepository();
        NotificationService notify = new EmailNotification();
        OrderService orderService = new OrderService(repo, notify);

        // cac giam gia mac dinh
        discountMap.put(1, new PercentageDiscount(10));
        discountMap.put(2, new FixedDiscount(50000));
        discountMap.put(3, new HolidayDiscount());
        // cac thanh toan mac dinh

        paymentMap.put(1, new CODPayment());
        paymentMap.put(2, new CreditCardPayment());
        paymentMap.put(3, new MomoPayment());
        paymentMap.put(4, new VNPayPayment());
        int choice;

        do {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Them san pham");
            System.out.println("2. Them khach hang");
            System.out.println("3. Tao don hang");
            System.out.println("4. Xem danh sach don hang");
            System.out.println("5. Tinh tong doanh thu");
            System.out.println("6. Them phuong thuc thanh toan moi");
            System.out.println("7. Them chien luoc giam gia moi");
            System.out.println("0. Thoat");

            System.out.print("Chon: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    createOrder(orderService);
                    break;
                case 4:
                    showOrders();
                    break;
                case 5:
                    calculateRevenue();
                    break;
                case 6:
                    addPaymentMethod();
                    break;
                case 7:
                    addDiscountStrategy();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (choice != 0);
    }

    // them san pham
    static void addProduct() {
        System.out.print("Ma san pham: ");
        String id = sc.nextLine();
        System.out.print("Ten san pham: ");
        String name = sc.nextLine();
        System.out.print("Gia: ");
        double price = sc.nextDouble();
        System.out.print("Danh muc: ");
        String category = sc.nextLine();
        sc.nextLine();
        products.add(new Product(id, name, price, category));
        System.out.println("Da them san pham " + id);
    }

    // them khach hang
    static void addCustomer() {
        System.out.print("Ten: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        customers.add(new Customer(name, email, phone));
        System.out.println("Da them khach hang");
    }

    // tao don hang
    static void createOrder(OrderService orderService) {
        if (products.isEmpty() || customers.isEmpty()) {
            System.out.println("Chua co san pham hoac khach hang");
            return;
        }
        Customer customer = customers.get(0);
        Order order = new Order("ORD" + (orders.size() + 1), customer);

        // chon san pham
        Product p = products.get(0);
        order.addItem(new OrderItem(p, 1));

        // chon giam gia
        System.out.println("Chon giam gia:");
        discountMap.forEach((k, v) -> System.out.println(k + ". " + v.getClass().getSimpleName()));
        int d = sc.nextInt();
        DiscountStrategy discount = discountMap.get(d);

        // chon thanh toan
        System.out.println("Chon thanh toan:");
        paymentMap.forEach((k, v) -> System.out.println(k + ". " + v.getClass().getSimpleName()));
        int pChoice = sc.nextInt();
        PaymentMethod payment = paymentMap.get(pChoice);
        orderService.createOrder(order, discount, payment);
        orders.add(order);
        System.out.println("Don hang da duoc tao");
    }

    // xem ds don hang
    static void showOrders() {
        if (orders.isEmpty()) {
            System.out.println("Chua co don hang");
            return;
        }

        for (Order o : orders) {
            System.out.println(o.getId() + " - " + o.getCustomer().getName() + " - " + o.getTotal());
        }
    }

    // tinh doanh thu
    static void calculateRevenue() {
        double sum = 0;
        for (Order o : orders) {
            sum+=o.getTotal();
        }
        System.out.println("Tong doanh thu: " + sum);
    }

    // them thanh toan moi
    static void addPaymentMethod() {
        int id = paymentMap.size()+1;
        paymentMap.put(id, new VNPayPayment());
        System.out.println("Da them phuong thuc thanh toan moi");
    }

    // them giam gia moi
    static void addDiscountStrategy() {
        int id = discountMap.size()+1;
        discountMap.put(id, new PercentageDiscount(20));
        System.out.println("Da them chien luoc giam gia VIP 20%");
    }
}