package ex2.discount;

public class NoDiscount implements DiscountStrategy{
    // ko giam gia
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount;
    }
}
