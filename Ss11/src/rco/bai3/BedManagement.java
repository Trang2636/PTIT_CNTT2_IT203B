package rco.bai3;

import java.sql.Statement;
public class BedManagement {
    // Phan 1: Phan tich
/*
Phương thức executeUpdate() trả về số lượng bản ghi bị tác động bởi câu lệnh SQL. Nếu giá trị trả về lớn hơn 0,
điều đó cho thấy thao tác cập nhật đã được thực hiện thành công trên ít nhất một dòng dữ liệu
 Ngược lại, nếu giá trị bằng 0 thì không có bản ghi nào thỏa mãn điều kiện, có thể do mã giường không tồn tại trong hệ thống
 Vì vậy, việc kiểm tra giá trị này là cần thiết để đưa ra thông báo phù hợp cho người dùng
 */
    public void updateBedStatus(Statement stmt, String inputId) {
        try {
            String sql = "UPDATE Beds SET bed_status = 'Dang su dung' WHERE bed_id = '" + inputId + "'";
            int result = stmt.executeUpdate(sql);

            if (result != 0) {
                System.out.println("Cap nhat trang thai giuong thanh cong!");
            } else {
                System.out.println("Khong tim thay ma giuong can cap nhat.");
            }

        } catch (Exception ex) {
            System.out.println("Da xay ra loi khi cap nhat du lieu!");
            ex.printStackTrace();
        }
    }
}

