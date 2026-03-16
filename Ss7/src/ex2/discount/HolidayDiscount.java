package ex2.discount;

// them loai giam gia moi
public class HolidayDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount*0.85; // giam 15%
    }
}
