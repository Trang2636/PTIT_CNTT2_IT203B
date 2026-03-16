package ex5.discount;

// giam gia dip le
public class HolidayDiscount implements DiscountStrategy {
    public double applyDiscount(double total) {
        return total * 0.85;
    }
}