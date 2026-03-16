package ex5.discount;

// giam theo phan tram
public class PercentageDiscount implements DiscountStrategy {
    private double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    public double applyDiscount(double total) {
        return total-total*percent/100;
    }
}
