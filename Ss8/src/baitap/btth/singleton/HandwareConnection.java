package baitap.btth.singleton;

public class HandwareConnection {
    private static HandwareConnection instance;
    private  HandwareConnection() {
    }
    public static HandwareConnection getInstance() {
        if (instance == null) {
            instance = new HandwareConnection();
        }
        return instance;
    }
    public void connect() {
        System.out.println("Da ket noi");
    }

}
