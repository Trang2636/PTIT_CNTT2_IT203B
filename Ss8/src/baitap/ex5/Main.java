package baitap.ex5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        TemperatureSensor sensor = new TemperatureSensor();

        // dang ky observer
        sensor.attach(fan);
        sensor.attach(ac);

        SleepModeCommand sleepCommand = new SleepModeCommand(light, fan, ac);

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Che do ngu");
            System.out.println("2. Set nhiet do");
            System.out.println("3. Thoat");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sleepCommand.execute();
                    break;

                case 2:
                    System.out.println("Nhap nhiet do:");
                    int temp = sc.nextInt();
                    sensor.setTemperature(temp);
                    break;

                case 3:
                    System.out.println("Thoat");
                    return;
            }
        }
    }
}
