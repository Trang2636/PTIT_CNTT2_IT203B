package ex3;

public class CODPayment implements CODPayable {
    @Override
    public void paymentProcess(int amount) {
        System.out.println("Xu ly thanh toan COD: " + amount + " - Thanh cong");

    }
}