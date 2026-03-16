package ex5.payment;

public class CODPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toan COD: " + amount);
    }
}
