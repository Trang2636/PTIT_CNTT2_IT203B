import java.util.*;
import java.util.stream.*;

class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

public class Main {
    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("alexander"),
                new User("charlotte"),
                new User("Ben"),
                new User("Benjamin"),
                new User("Tom"),
                new User("Christopher")
        );

        users.stream()
                .sorted(Comparator.comparingInt(u -> u.getUsername().length()).reversed())
                .limit(3)
                .forEach(u -> System.out.println(u.getUsername()));
    }
}