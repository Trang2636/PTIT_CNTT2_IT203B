import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Nhập vào tổng ng dùng: ");
            int n = sc.nextInt();
            System.out.println("Nhập vào số nhóm: ");
            int g = sc.nextInt();
            int calculate = n/g;
            System.out.println("kết quả"+ calculate);
        }catch (ArithmeticException e){
            System.out.println("lỗi: không thể chia cho 0");
        }

    }
}
