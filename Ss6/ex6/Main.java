package ex6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CinemaSystem system = new CinemaSystem();
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Bat dau mo phong");
            System.out.println("2. Tam dung mo phong");
            System.out.println("3. Tiep tuc mo phong");
            System.out.println("4. Xem thong ke");
            System.out.println("5. Phat hien deadlock");
            System.out.println("6. Thoat");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhap so phong: ");
                    int rooms = sc.nextInt();
                    System.out.print("Nhap so ve moi phong: ");
                    int tickets = sc.nextInt();
                    System.out.print("Nhap so quay: ");
                    int booths = sc.nextInt();
                    system.startSimulation(rooms, tickets, booths);
                    break;

                case 2:
                    system.pauseSimulation();
                    break;

                case 3:
                    system.resumeSimulation();
                    break;

                case 4:
                    system.showStatistics();
                    break;

                case 5:
                    system.detectDeadlock();
                    break;

                case 6:
                    system.shutdown();
                    return;

                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }
}
