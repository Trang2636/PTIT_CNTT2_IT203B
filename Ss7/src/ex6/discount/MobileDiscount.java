package ex6.discount;

public class MobileDiscount implements DiscountStrategy {
    public double applyDiscount(double total) {
        System.out.println("Ap dung giam gia 15% cho lan dau");
        return total * 0.85;
    }
}
