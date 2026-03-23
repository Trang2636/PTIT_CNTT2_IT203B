package com.re.business;

/*
Phân tích
Khi bạn sử dụng Statement và cộng chuỗi SQL bên trong vòng lặp 1.000 lần, Database Server phải thực hiện quy trình sau 1.000 lần riêng biệt:
Sử dụng CPU để Parse: Database phải phân tích cú pháp của từng câu lệnh vì mỗi câu lệnh là một chuỗi khác nhau
Lập kế hoạch thực thi (Execution Plan): Database phải tính toán xem nên chèn dữ liệu vào đâu, cập nhật index thế nào cho từng câu lệnh một
 Việc này cực kỳ tốn tài nguyên vì cấu trúc câu lệnh thực tế là giống hệt nhau
Tốn bộ nhớ (Buffer Cache): Database thường lưu trữ các câu lệnh đã thực thi vào bộ nhớ đệm. Với 1.000 câu lệnh "rác"
, bộ nhớ đệm sẽ bị tràn ngập bởi các truy vấn chỉ dùng một lần, đẩy các truy vấn quan trọng khác ra ngoài.


String sql = "INSERT INTO Results(data) VALUES(?)";

try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
    conn.setAutoCommit(false);

    for (TestResult tr : list) {
        pstmt.setString(1, tr.getData());
        pstmt.executeUpdate();
    }

    conn.commit();

} catch (SQLException e) {
    if (conn != null) conn.rollback();
    e.printStackTrace();
}
 */