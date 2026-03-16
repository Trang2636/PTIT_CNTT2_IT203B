package ex6.discount;

public class POSDiscount implements DiscountStrategy {
    public double applyDiscount(double total) {
        System.out.println("Giam gia thanh vien tai cua hang");
        return total * 0.95;
    }
}
