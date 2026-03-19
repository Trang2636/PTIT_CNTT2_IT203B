package baitap.ex1;

public class AirConditioner implements Device{
    @Override
    public void turnOn() {
        System.out.println("Dieu hoa: Bat.");
    }

    @Override
    public void turnOff() {
        System.out.println("Dieu hoa: Tat.");
    }
}
