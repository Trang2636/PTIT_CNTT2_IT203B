package Bai3;

public interface Authenticatable {
    String getPassword();

    default boolean isAuthenticated() {
        String password = getPassword();
        return password != null && !password.isEmpty();
    }

    static String encrypt(String rawPassword) {
        return rawPassword;
    }

}