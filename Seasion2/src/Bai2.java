
public class Bai2 {
    public static void main(String[] args) {
        PasswordValidator validator= password -> password.length()>=8;
        String p1= "12345678";
        String p2= "1234";

        System.out.println(p1+ " -> "+ validator.isValid(p1));
        System.out.println(p2+ " -> "+ validator.isValid(p2));
    }
}