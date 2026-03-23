package rco.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bai1 {

    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASS = "12345";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

/*
phân tích
Việc tạo kết nối liên tục mà không đóng gây rò rỉ tài nguyên, làm cạn kiệt connection pool, dẫn đến lỗi
 “Communications link failure”. Điều này đặc biệt nguy hiểm với hệ thống yêu cầu hoạt động liên tục như bệnh viện.
 */