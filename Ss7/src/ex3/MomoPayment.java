package ex3;

public class MomoPayment implements EWalletPayable {
    @Override
    public void paymentProcess(int amount) {
        System.out.println("Xu ly thanh toan MoMo: " + amount + " - Thanh cong");

    }
}