package baitap.ex1;

public class HardwareConnection {
    private static HardwareConnection instance;
    private HardwareConnection() {}

    public static HardwareConnection getInstance() {
        if (instance == null) {
            instance = new HardwareConnection();
            System.out.println("HardwareConnection: Da ket noi phan cung.");
        }
        return instance;
    }

    public void connect() {
        // da ket noi trong getInstance
    }

    public void disconnect() {
        System.out.println("HardwareConnection: Da ngat ket noi.");
    }
}
