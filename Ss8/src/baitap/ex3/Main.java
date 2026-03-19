package baitap.ex3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();
        RemoteControl remote = new RemoteControl();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Gan nut");
            System.out.println("2. Nhan nut");
            System.out.println("3. Undo");
            System.out.println("4. Thoat");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Nhap so nut:");
                    int btn = sc.nextInt();
                    System.out.println("Chon lenh:");
                    System.out.println("1. Bat den");
                    System.out.println("2. Tat den");
                    System.out.println("3. Bat quat");
                    System.out.println("4. Tat quat");
                    System.out.println("5. Set dieu hoa");

                    int type = sc.nextInt();

                    Command command = null;

                    if (type == 1) {
                        command = new LightOnCommand(light);
                    }
                    else if (type == 2) {
                        command = new LightOffCommand(light);
                    }
                    else if (type == 3) {
                        command = new FanOnCommand(fan);
                    }
                    else if (type == 4) {
                        command = new FanOffCommand(fan);
                    }
                    else if (type == 5) {
                        System.out.print("Nhap nhiet do: ");
                        int temp = sc.nextInt();
                        command = new ACSetTemperatureCommand(ac, temp);
                    }
                    if (command != null) {
                        remote.setCommand(btn, command);
                    }
                    break;
                case 2:
                    System.out.print("Nhap nut: ");
                    int press = sc.nextInt();
                    remote.pressButton(press);
                    break;
                case 3:
                    remote.undo();
                    break;
                case 4:
                    System.out.println("Thoat");
                    return;
            }
        }
    }
}
