package baitap.ex3;

public class AirConditioner {
    private int temperature = 25;
    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Dieu hoa: Nhiet do = " + temp);
    }
    public int getTemperature() {
        return temperature;
    }
}
