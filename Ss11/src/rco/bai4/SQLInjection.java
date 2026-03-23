package rco.bai4;
import java.sql.ResultSet;
import java.sql.Statement;
// Phan 2
public class SQLInjection {
    // Phan 1: Phan tich
/*
Khi dữ liệu đầu vào từ người dùng được nối trực tiếp vào câu lệnh SQL, hệ thống sẽ dễ bị tấn công SQL Injection
Kẻ tấn công có thể chèn thêm các điều kiện luôn đúng (ví dụ ' OR '1'='1) để thay đổi logic truy vấn. Khi đó, câu lệnh SQL không
còn lọc đúng dữ liệu mong muốn mà có thể trả về toàn bộ bản ghi trong bảng, dẫn đến rò rỉ thông tin nhạy cảm
 Vì vậy, cần kiểm soát hoặc xử lý dữ liệu đầu vào trước khi đưa vào câu lệnh SQL.
 */
    public void searchPatient(Statement stmt, String nameInput) {
        try {
            String safeName = nameInput.trim();

            safeName = safeName.replace("'", "");
            safeName = safeName.replace("--", "");
            safeName = safeName.replace(";", "");

            String query = "SELECT * FROM Patients WHERE full_name = '" + safeName + "'";
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                System.out.println("Ma BN: " + result.getString("patient_id"));
                System.out.println("Ho ten: " + result.getString("full_name"));
            }

        } catch (Exception ex) {
            System.out.println("Loi khi truy van du lieu!");
            ex.printStackTrace();
        }
    }
}

