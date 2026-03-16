package ex3;

public class CreditCardPayment implements CardPayable {
    @Override
    public void paymentProcess(int amount) {
        System.out.println("Xu ly thanh toan the tin dung: " + amount + " - Thanh cong");

    }
}