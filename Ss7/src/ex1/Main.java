package ex1;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("SP01", "Laptop", 15000000);
        Product p2 = new Product("SP02", "Chuot", 300000);

        System.out.println("Tao san pham: SP01 - Laptop - 15000000, SP02 - Chuot - 300000");
        System.out.println("Da them san pham SP01, SP02");

        Customer customer = new Customer("To Tuan", "ta@gmail.com", "Ha Noi");

        System.out.println("Tao khach hang: To Tuan - ta@gmail.com");
        System.out.println("Da them khach hang");

        // Tao don hang
        Order order = new Order("ORD001", customer);
        order.addProduct(p1, 1);
        order.addProduct(p2, 2);
        System.out.println("Tao don hang: SP01 (1 cai), SP02 (2 cai)");
        System.out.println("Don hang ORD001 duoc tao");

        // Tinh tong tien
        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotal(order);
        order.setTotal(total);
        System.out.println("Tinh tong tien");
        System.out.println("Tong tien: " + (long) total);

        // Luu don hang
        OrderRepository repository = new OrderRepository();
        System.out.println("Luu don hang");
        repository.save(order);

        // Gui email xac nhan
        EmailService emailService = new EmailService();
        System.out.println("Gui email xac nhan");
        emailService.sendEmail(order);
    }
}
