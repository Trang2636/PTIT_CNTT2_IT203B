import java.util.ArrayList;
import java.util.List;

public class Bai1 {
    record User(String name, String email, String status){};

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("alice", "alice@gmail.com", "ACTIVE"));
        users.add(new User("bob", "bob@gmail.com", "INACTIVE"));
        users.add(new User("charlie", "charlie@gmail.com", "ACTIVE"));
        users.forEach(user -> {
            System.out.println(user.name() + " - " + user.status());
        });

        }
    }


