package baitap.ex2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SmartHomeFacade facade = new SmartHomeFacade();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem nhiet do");
            System.out.println("2. Che do roi nha");
            System.out.println("3. Che do ngu");
            System.out.println("4. Thoat");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    facade.getCurrentTemperature();
                    break;
                case 2:
                    facade.leaveHome();
                    break;
                case 3:
                    facade.sleepMode();
                    break;
                case 4:
                    System.out.println("Thoat chuong trinh");
                    return;
                default:
                    System.out.println("Lua chon khong hop le");
            }

        }

    }
}
