import java.util.*;
import java.util.stream.Collectors;

public class Bai4 {

    record User(String username, String email) {}

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        users.add(new User("alice", "alice1@gmail.com"));
        users.add(new User("bob", "bob@gmail.com"));
        users.add(new User("alice", "alice2@gmail.com"));   // trùng username
        users.add(new User("charlie", "charlie@gmail.com"));
        users.add(new User("bob", "bob2@gmail.com"));       // trùng username

        // Loại bỏ trùng username
        Collection<User> uniqueUsers =
                users.stream()
                        .collect(Collectors.toMap(
                                User::username,      // key = username
                                u -> u,              // value = user
                                (u1, u2) -> u1       // nếu trùng giữ user đầu
                        ))
                        .values();

        // In kết quả
        uniqueUsers.forEach(u ->
                System.out.println(u.username() + " - " + u.email())
        );
    }
}