package ex3;

public class PaymentProcessor {
//    private PaymentMethod paymentMethod;
//
//    public PaymentProcessor(PaymentMethod paymentMethod) {
//        this.paymentMethod = paymentMethod;
//    }

    public void process(PaymentMethod paymentMethod, int amount) {
        paymentMethod.paymentProcess(amount);
    }
}
