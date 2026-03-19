package baitap.ex6;

public class MomoPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toan Momo: " + amount);
    }
}
