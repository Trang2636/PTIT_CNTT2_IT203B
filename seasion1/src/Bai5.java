public class Main {

    // Custom Exception
    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String msg) {
            super(msg);
        }
    }

    // Lớp User
    static class User {
        private int age;

        public void setAge(int age) throws InvalidAgeException {
            if (age < 0 || age > 120) {
                throw new InvalidAgeException("Tuổi không hợp lệ! Tuổi phải từ 0 đến 120.");
            }
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

    // Hàm main
    public static void main(String[] args) {

        User user = new User();

        try {
            user.setAge(-5);   // thử nhập tuổi sai
            System.out.println("Tuổi hợp lệ: " + user.getAge());

        } catch (InvalidAgeException e) {

            System.out.println("Lỗi: " + e.getMessage());
            e.printStackTrace();

        }
    }
}