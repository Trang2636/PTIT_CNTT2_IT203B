import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== MENU TEST =====");
            System.out.println("1. Bai K1 - Ban ve co ban");
            System.out.println("2. Bai K2 - Nha cung cap ve");
            System.out.println("3. Bai G1 - Ban ve combo");
            System.out.println("4. Bai G2 - Wait / Notify");
            System.out.println("0. Thoat");
            System.out.print("Chon bai: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    testK1();
                    break;
                case 2:
                    testK2();
                    break;
                case 3:
                    testG1();
                    break;
                case 4:
                    testG2();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    public static void testK1() {

        System.out.println("\n===== BAI K1 =====");
        TicketPool roomA = new TicketPool("A", 10);
        TicketPool roomB = new TicketPool("B", 10);
        BookingCounter counter1 = new BookingCounter("Quay 1", roomA, roomB);
        BookingCounter counter2 = new BookingCounter("Quay 2", roomA, roomB);
        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);
        t1.start();
        t2.start();
    }

    public static void testK2() {
        System.out.println("\n===== BAI K2 =====");
        TicketPool roomA = new TicketPool("A", 5);
        TicketPool roomB = new TicketPool("B", 5);
        BookingCounter counter1 = new BookingCounter("Quay 1", roomA, roomB);
        BookingCounter counter2 = new BookingCounter("Quay 2", roomA, roomB);
        TicketSupplier supplier = new TicketSupplier(roomA, roomB, 3, 3000, 3);

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);
        Thread t3 = new Thread(supplier);
        t1.start();
        t2.start();
        t3.start();
    }


    public static void testG1() {
        System.out.println("\n===== BAI G1 =====");
        TicketPool roomA = new TicketPool("A", 5);
        TicketPool roomB = new TicketPool("B", 5);
        BookingCounter counter1 = new BookingCounter("Quay 1", roomA, roomB);
        BookingCounter counter2 = new BookingCounter("Quay 2", roomA, roomB);

        Thread t1 = new Thread(() -> {
            while (true) {
                counter1.sellComboTicket();
                try { Thread.sleep(300); } catch (Exception e) {}
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                counter2.sellComboTicket();
                try { Thread.sleep(300); } catch (Exception e) {}
            }
        });
        t1.start();
        t2.start();
    }

    public static void testG2() {
        System.out.println("\n===== BAI G2 =====");
        TicketPool roomA = new TicketPool("A", 3);
        TicketPool roomB = new TicketPool("B", 3);
        BookingCounter counter1 = new BookingCounter("Quay 1", roomA, roomB);
        BookingCounter counter2 = new BookingCounter("Quay 2", roomA, roomB);
        TicketSupplier supplier = new TicketSupplier(roomA, roomB, 2, 4000, 5);
        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);
        Thread t3 = new Thread(supplier);

        t1.start();
        t2.start();
        t3.start();
    }
}