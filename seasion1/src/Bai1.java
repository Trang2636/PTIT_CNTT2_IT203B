import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Nhập vào năm sinh : ");
            String input = sc.nextLine();
            int year = Integer.parseInt(input);
            int age = 2026-year;
            System.out.println("Tuổi của bạn là" +age );
        }catch(NumberFormatException e){
            System.out.println("lỗi : bạn phải nhập vào năm sinh bằng số");
        }finally {
            sc.close();
            System.out.println("okela");
        }
    }
}
