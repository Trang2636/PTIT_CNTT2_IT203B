package ex5.payment;

public class MomoPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toan MoMo: " + amount);
    }
}
