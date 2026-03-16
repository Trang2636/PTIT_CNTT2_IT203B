package ex6.discount;

// giam gia cho website
public class WebDiscount implements DiscountStrategy {
    public double applyDiscount(double total) {
        System.out.println("Ap dung giam gia 10% cho don hang website");
        return total * 0.9;
    }
}
