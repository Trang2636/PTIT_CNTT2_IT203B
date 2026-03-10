package Bai4;

class SuperAdmin implements UserActions, AdminActions {

    @Override
    public void logActivity(String activity) {
        System.out.println("SuperAdmin log: " + activity);
    }
}
