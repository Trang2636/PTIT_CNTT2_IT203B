package baitap.ex4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TemperatureSensor sensor = new TemperatureSensor();
        Fan fan = new Fan();
        Humidifier humidifier = new Humidifier();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Dang ky quat");
            System.out.println("2. Dang ky may tao am");
            System.out.println("3. Set nhiet do");
            System.out.println("4. Thoat");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sensor.attach(fan);
                    System.out.println("Quat: Da dang ky nhan thong bao");
                    break;
                case 2:
                    sensor.attach(humidifier);
                    System.out.println("May tao am: Da dang ky");
                    break;
                case 3:
                    System.out.println("Nhap nhiet do:");
                    int temp = sc.nextInt();
                    sensor.setTemperature(temp);
                    break;
                case 4:
                    System.out.println("Thoat");
                    return;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        }
    }
}