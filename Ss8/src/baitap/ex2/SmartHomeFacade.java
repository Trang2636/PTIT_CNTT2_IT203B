package baitap.ex2;

public class SmartHomeFacade {
    private Light light;
    private Fan fan;
    private AirConditioner airConditioner;
    private TemperatureSensor sensor;

    public SmartHomeFacade() {
        light = new Light();
        fan = new Fan();
        airConditioner = new AirConditioner();
        OldThermometer oldThermometer = new OldThermometer();
        sensor = new ThermometerAdapter(oldThermometer);
    }

    public void leaveHome() {
        light.turnOff();
        fan.turnOff();
        airConditioner.turnOff();
    }

    public void sleepMode() {
        light.turnOff();
        airConditioner.setTemperature(28);
        fan.lowSpeed();

    }

    public void getCurrentTemperature() {
        double temp = sensor.getTemperatureCelsius();
        System.out.printf("Nhiet do hien tai: %.1fC\n", temp);
    }

}
