package baitap.ex5;

public class SleepModeCommand {

    private Light light;
    private Fan fan;
    private AirConditioner ac;

    public SleepModeCommand(Light light, Fan fan, AirConditioner ac) {
        this.light = light;
        this.fan = fan;
        this.ac = ac;
    }

    public void execute() {

        System.out.println("SleepMode: Tat den");
        System.out.println("SleepMode: Dieu hoa set 28C");
        System.out.println("SleepMode: Quat toc do thap");

        light.off();
        ac.setTemperature(28);
        fan.low();
    }
}
