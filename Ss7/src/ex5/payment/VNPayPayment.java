package ex5.payment;

public class VNPayPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toan VNPay: " + amount);
    }
}
