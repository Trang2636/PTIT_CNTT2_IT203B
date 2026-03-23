package com.re.business;

import java.sql.PreparedStatement;


    /*
    // Phần 1: Phân tích

/*
Trong đoạn mã ban đầu, việc sử dụng Statement kết hợp với phép nối chuỗi để xây dựng câu lệnh SQL
có thể dẫn đến lỗi liên quan đến định dạng dữ liệu, đặc biệt là với kiểu số thực (double).

Cụ thể, giá trị nhiệt độ (temperature) được nối trực tiếp vào câu lệnh SQL.
Tuy nhiên, định dạng số thực phụ thuộc vào thiết lập vùng miền (Locale) của hệ điều hành:
    - Một số hệ thống sử dụng dấu chấm (.) làm dấu phân cách thập phân (ví dụ: 37.5)
    - Trong khi đó, một số vùng miền như Pháp hoặc Việt Nam có thể sử dụng dấu phẩy (,) (ví dụ: 37,5)

Khi giá trị sử dụng dấu phẩy được nối trực tiếp vào câu SQL, hệ quản trị cơ sở dữ liệu sẽ không hiểu đúng cú pháp,
dẫn đến lỗi ngay khi thực thi câu lệnh.

PreparedStatement giải quyết vấn đề này bằng cách cung cấp các phương thức như setDouble() và setInt(),
giúp truyền dữ liệu dưới dạng tham số thay vì nối chuỗi.

Cơ chế hoạt động:
    - Câu lệnh SQL được định nghĩa trước với các dấu ? (placeholder)
    - Dữ liệu được truyền riêng biệt thông qua các phương thức setXXX()
    - Driver JDBC sẽ tự động chuyển đổi dữ liệu sang định dạng chuẩn phù hợp với cơ sở dữ liệu

Nhờ đó:
    - Lập trình viên không cần quan tâm đến sự khác biệt về định dạng số giữa các vùng miền
    - Tránh được lỗi cú pháp SQL do sai định dạng
    - Đồng thời tăng tính an toàn và ổn định của chương trình

Kết luận: Việc sử dụng PreparedStatement với các phương thức setDouble(), setInt() giúp đảm bảo dữ liệu
được xử lý đúng định dạng, không phụ thuộc vào Locale của hệ thống, từ đó tránh lỗi khi thực thi SQL.
*/


    // Phần 2: Thực thi (code chuẩn)

//    String sql = "UPDATE Vitals SET temperature = ?, heart_rate = ? WHERE p_id = ?";
//
//    PreparedStatement ps = conn.prepareStatement(sql);
//
//ps.setDouble(1, temp);      // Nhiệt độ
//ps.setInt(2, heartRate);   // Nhịp tim
//ps.setInt(3, patientId);   // ID bệnh nhân
//
//ps.executeUpdate();
//}
