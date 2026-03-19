package baitap.ex1;

public class Fan implements Device {
    @Override
    public void turnOn() {
        System.out.println("Quat: Bat.");
    }

    @Override
    public void turnOff() {
        System.out.println("Quat: Tat.");
    }
}
