package baitap.ex5;

public class AirConditioner implements Observer {
    private int temperature = 25;

    public void setTemperature(int temp) {
        temperature = temp;
        System.out.println("Dieu hoa: Nhiet do = " + temp);
    }

    @Override
    public void update(int temp) {
        if (temp > 30) {
            System.out.println("Dieu hoa: Dang giu nhiet do " + temperature);
        }
    }
}
