package com.re.business;
/*

Phần 1: Phân tích
1. Tại sao JDBC bắt buộc phải gọi registerOutParameter()?
Trong JDBC, khi bạn thực thi một Stored Procedure có tham số đầu ra (OUT), trình điều khiển (Driver) cần biết trước kiểu dữ liệu
của giá trị trả về để cấp phát bộ nhớ và thực hiện chuyển đổi kiểu dữ liệu (mapping) từ SQL sang Java một cách chính xác sau khi procedure kết thúc

Nếu không gọi registerOutParameter(), driver sẽ coi vị trí đó là một tham số chưa được định nghĩa hoàn chỉnh, dẫn đến việc không thể truy xuất giá trị hoặc báo lỗi chỉ mục (index) vì tham số OUT chưa được "đăng ký" vào danh sách các giá trị có thể đọc.

2. Đăng ký kiểu DECIMAL trong Java
Nếu tham số đầu ra trong SQL có kiểu là DECIMAL, bạn cần sử dụng hằng số sau trong lớp java.sql.Types:

Hằng số: java.sql.Types.DECIMAL
 */

import java.sql.*;

public class Bai3{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Get_Surgery";
        String user = "root";
        String password = "123456";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            String sql = "{call GET_SURGERY_FEE(?, ?)}";
            try (CallableStatement cstmt = conn.prepareCall(sql)) {

                cstmt.setInt(1, 505);
                cstmt.registerOutParameter(2, java.sql.Types.DECIMAL);

                cstmt.execute();
                double cost = cstmt.getDouble(2);

                System.out.println("Tong: " + cost);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
