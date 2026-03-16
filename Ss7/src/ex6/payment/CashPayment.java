package ex6.payment;

public class CashPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toan tien mat tai POS");
    }
}
