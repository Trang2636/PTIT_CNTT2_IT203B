package ex2.discount;

public class PercentageDiscount  implements DiscountStrategy {
    private double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    // giam theo %
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount-(totalAmount*percent/100);
    }
}
