package rco.pc;

import java.sql.ResultSet;
import java.sql.Statement;
// Phan 2:
public class PharmacyCatalogue {
    public void printCatalogue(Statement stmt) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy");
            boolean hasData = false;
            System.out.println("===== DANH MUC THUOC =====");
            System.out.printf("%-30s %-15s%n", "ten thuoc", "So luong toon kho");
            while (rs.next()) {
                hasData = true;
                String medicineName = rs.getString("medicine_name");
                int stock = rs.getInt("stock"); //sl ton kho
                System.out.printf("%-30s %-15d%n", medicineName, stock);
            }
            if (!hasData) {
                System.out.println("Kho thuốc hiện đang trống.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// Phần 1: Phân tích

/*
Việc sử dụng câu lệnh if (rs.next()) chỉ cho phép kiểm tra sự tồn tại của một dòng dữ liệu duy nhất.
Do đó, trong trường hợp bảng chứa nhiều bản ghi, chương trình chỉ xử lý được dòng đầu tiên và bỏ qua các dòng còn lại.

Nguyên nhân là do con trỏ của ResultSet ban đầu được đặt trước dòng dữ liệu đầu tiên.
Mỗi lần gọi phương thức next(), con trỏ sẽ di chuyển xuống dòng tiếp theo:
    - Nếu còn dữ liệu, next() trả về true
    - Nếu đã duyệt hết, next() trả về false

Vì vậy:
    - Sử dụng if (rs.next()) chỉ xử lý được một bản ghi
    - Sử dụng while (rs.next()) cho phép duyệt toàn bộ các bản ghi trong bảng

Ngoài ra, trong trường hợp bảng không có dữ liệu, phương thức next() sẽ trả về false ngay từ lần gọi đầu tiên.
Khi đó, chương trình cần có thông báo phù hợp để tránh việc không hiển thị bất kỳ thông tin nào cho người dùng.

Kết luận: Để hiển thị đầy đủ danh mục thuốc (bao gồm tên thuốc và số lượng tồn kho), cần sử dụng vòng lặp while thay vì if.
*/