package Bai4;

interface AdminAction {
    default void logActivity(String activity) {
        System.out.println("Admin log: " + activity);
    }
}