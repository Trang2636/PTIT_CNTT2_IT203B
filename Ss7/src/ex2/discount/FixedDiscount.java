package ex2.discount;

public class FixedDiscount implements DiscountStrategy {
    private double amount;

    public FixedDiscount(double amount) {
        this.amount = amount;
    }

    // giam so tien co dinh
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount-amount;
    }
}
