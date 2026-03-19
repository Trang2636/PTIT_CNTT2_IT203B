package baitap.ex6;

public class CODPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toan tien mat: " + amount);
    }
}
