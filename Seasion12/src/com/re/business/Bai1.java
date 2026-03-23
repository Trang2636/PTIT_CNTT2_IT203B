package com.re.business;

/*
code sửa
String sql = "SELECT * FROM Doctors WHERE code = ? AND pass = ?";
PreparedStatêmnt ps = conn.prepareStatement(sql);
ps.setString(1,code);
ps.setString(2pass);
ResultSet rs = ps.executeQuery();


phân tích
PreparedStatement giúp chống SQL Injection vì:

Tách biệt câu lệnh SQL và dữ liệu
Biên dịch trước (pre-compiled)
Xử lý dữ liệu đầu vào an toàn
Không cho phép dữ liệu thay đổi cấu trúc SQL
 */



