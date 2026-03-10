import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            int age = sc.nextInt();
            if(age<0){
                throw new IllegalArgumentException("Tuổi k thể âm");
            }
            System.out.println("Tuổi "+age);
        }catch(IllegalArgumentException e){
            System.out.println("lỗi "+ e.getMessage());
        }
    }
}
