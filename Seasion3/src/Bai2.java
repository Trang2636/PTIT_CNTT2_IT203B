import java.util.ArrayList;
public class Bai2 {
    record User(String username, String email) {}

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();

        users.add(new User("alice", "alice@gmail.com"));
        users.add(new User("bob", "bob@yahoo.com"));
        users.add(new User("charlie", "charlie@gmail.com"));

        // Stream filter gmail
        users.stream()
                .filter(user -> user.email().endsWith("@gmail.com"))
                .forEach(user -> System.out.println(user.username()));
    }
}