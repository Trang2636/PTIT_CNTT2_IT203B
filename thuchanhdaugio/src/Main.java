import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProductManager manager= new ProductManager();
       while(true){
           System.out.println("""
                   1. Thêm sản phẩm mới
                   2. Hiển thị danh sách sản phẩm
                   3. Cập nhật số lượng theo ID
                   4. Xóa sản phẩm đã hết hàng
                   5. Thoát chương trình
                   Mời nhập vào lựa chọn 
                   """);
           int choose = sc.nextInt();
           switch (choose){
               case 1:
                   try{
                       System.out.println("ID");
                       int id = sc.nextInt();
                       sc.nextLine();

                       System.out.println("Tên");
                       String name = sc.nextLine();

                       System.out.println("Giá");
                       double price = sc.nextDouble();

                       System.out.println("Số lượng ");
                       int quantity = sc.nextInt();
                       System.out.println("Thể loại");
                       String category = sc.nextLine();
                       Product product = new Product(id,name,price,quantity,category);
                       manager.addProduct(product);
                       System.out.println("Done");
                   }catch (InvalidProductException e) {
                       System.out.println(e.getMessage());
                   }
                   break;

               case 2:
                   manager.displayProducts();
                   break;

               case 3:
                   try{
                       System.out.println("ID");
                       int id = sc.nextInt();
                       sc.nextLine();

                       System.out.println("Nhập số lượng mới ");
                       int quantity = sc.nextInt();
                       manager.updateQuantity(id,quantity);
                       System.out.println("Done");
                   }catch (InvalidProductException e){
                       System.out.println(e.getMessage());
                   }
                   break;

               case 4 :
                   manager.deleteOutOfStock();
                   break;

               case 5:
                   System.out.println("Thoát");
                   return;
               default:
                   System.out.println("Chọn lại");
           }
       }
    }
}