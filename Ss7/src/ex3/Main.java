package ex3;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        // Thanh toan COD
        PaymentMethod cod = new CODPayment();
        processor.process(cod, 500000);

        // Thanh toan the tin dung
        PaymentMethod credit = new CreditCardPayment();
        processor.process(credit, 1000000);

        // Thanh toan Momo
        PaymentMethod momo = new MomoPayment();
        processor.process(momo, 750000);

        System.out.println("Kiem tra LSP");

        // thay the implementation
        PaymentMethod method;

        method = new CreditCardPayment();
        processor.process(method, 200000);

        method = new MomoPayment();
        processor.process(method, 200000);

    }
}