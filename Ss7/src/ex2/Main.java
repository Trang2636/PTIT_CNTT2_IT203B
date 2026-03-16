package ex2;

import ex2.discount.*;
import ex2.service.OrderCalculator;

public class Main {
    public static void main(String[] args) {
        double total = 1000000;
        // Percentage Discount
        DiscountStrategy percent = new PercentageDiscount(10);
        OrderCalculator calculator1 = new OrderCalculator(percent);
        double result1 = calculator1.calculate(total);
        System.out.println("Don hang: tong tien 1.000.000, ap dung PercentageDiscount 10%");
        System.out.println("So tien sau giam: " + (long) result1);
        System.out.println();


        // Fixed Discount
        DiscountStrategy fixed = new FixedDiscount(50000);
        OrderCalculator calculator2 = new OrderCalculator(fixed);
        double result2 = calculator2.calculate(total);
        System.out.println("Don hang: tong tien 1.000.000, ap dung FixedDiscount 50.000");
        System.out.println("So tien sau giam: " + (long) result2);
        System.out.println();


        // No Discount
        DiscountStrategy no = new NoDiscount();
        OrderCalculator calculator3 = new OrderCalculator(no);
        double result3 = calculator3.calculate(total);
        System.out.println("Don hang: tong tien 1.000.000, ap dung NoDiscount");
        System.out.println("So tien sau giam: " + (long) result3);
        System.out.println();


        // Holiday Discount
        DiscountStrategy holiday = new HolidayDiscount();
        OrderCalculator calculator4 = new OrderCalculator(holiday);
        double result4 = calculator4.calculate(total);
        System.out.println("Them HolidayDiscount 15%");
        System.out.println("So tien sau giam: " + (long) result4);

    }
}
