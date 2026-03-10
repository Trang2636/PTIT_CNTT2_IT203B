import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bai3 {

    record User(String username, String email) {}

    static class UserRepository {

        List<User> users = new ArrayList<>();

        public UserRepository() {
            users.add(new User("alice", "alice@gmail.com"));
            users.add(new User("bob", "bob@yahoo.com"));
            users.add(new User("charlie", "charlie@gmail.com"));
        }

        public Optional<User> findUserByUsername(String username) {
            return users.stream()
                    .filter(user -> user.username().equals(username))
                    .findFirst();
        }
    }

    public static void main(String[] args) {

        UserRepository repo = new UserRepository();

        Optional<User> result = repo.findUserByUsername("alice");

        result.ifPresent(user -> System.out.println("Welcome " + user.username()));

        System.out.println(result.map(u -> "").orElse("Guest login"));
    }
}