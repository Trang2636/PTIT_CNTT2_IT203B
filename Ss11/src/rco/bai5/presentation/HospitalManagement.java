package rco.bai5.presentation;

import rco.bai5.business.DoctorBusiness;
import rco.bai5.model.Doctor;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class HospitalManagement {

    /*
   Trong quá trình vận hành hệ thống, có thể phát sinh một số lỗi phổ biến như sau:

-Người dùng nhập trùng mã bác sĩ, vi phạm ràng buộc khóa chính trong cơ sở dữ liệu.
-Dữ liệu chuyên khoa vượt quá độ dài cho phép của cột trong bảng, gây lỗi khi lưu.
-Ngày trực nhập sai định dạng, không thể chuyển đổi sang kiểu Date.
-Thiếu thông tin bắt buộc như mã bác sĩ, họ tên hoặc chuyên khoa.
-Kết nối cơ sở dữ liệu gặp sự cố do sai cấu hình hoặc server chưa hoạt động.
-Lựa chọn menu không hợp lệ, không nằm trong các chức năng cho phép.
-Bảng dữ liệu chưa được tạo trong database, khiến các thao tác truy vấn hoặc thêm mới thất bại.
     */
    private static final Scanner scanner = new Scanner(System.in);
    private static final DoctorBusiness doctorBusiness = new DoctorBusiness();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nHE THONG QUAN LY BENH VIEN RIKKEI-CARE");
            System.out.println("1. Xem danh sach bac si");
            System.out.println("2. Them bac si moi");
            System.out.println("3. Thong ke chuyen khoa");
            System.out.println("4. Thoat");
            System.out.print("Chon chuc nang: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    displayDoctors();
                    break;
                case "2":
                    addDoctor();
                    break;
                case "3":
                    statisticSpecialization();
                    break;
                case "4":
                    System.out.println("Thoat chuong trinh.");
                    System.exit(0);
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap tu 1 den 4.");
            }
        }
    }

    public static void displayDoctors() {
        List<Doctor> list = doctorBusiness.getAllDoctors();
        if (list == null || list.isEmpty()) {
            System.out.println("Chua co du lieu bac si.");
            return;
        }

        System.out.println("===== DANH SACH BAC SI =====");
        System.out.printf("%-15s %-25s %-20s%n", "Ma so", "Ho ten", "Chuyen khoa");

        for (Doctor d : list) {
            System.out.printf("%-15s %-25s %-20s%n",
                    d.getDoctorId(),
                    d.getFullName(),
                    d.getSpecialization());
        }
    }

    public static void addDoctor() {
        try {
            Doctor d = new Doctor();

            System.out.print("Nhap ma bac si: ");
            d.setDoctorId(scanner.nextLine().trim());

            System.out.print("Nhap ho ten: ");
            d.setFullName(scanner.nextLine().trim());

            System.out.print("Nhap chuyen khoa: ");
            d.setSpecialization(scanner.nextLine().trim());

            System.out.print("Nhap ngay truc (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine().trim();

            d.setDutyDate(Date.valueOf(dateStr));

            boolean success = doctorBusiness.addDoctor(d);

            System.out.println(success
                    ? "Them bac si thanh cong."
                    : "Khong the them bac si.");

        } catch (IllegalArgumentException e) {
            System.out.println("Dinh dang ngay khong hop le (yyyy-MM-dd).");
        } catch (Exception e) {
            System.out.println("Loi he thong: " + e.getMessage());
        }
    }

    public static void statisticSpecialization() {
        doctorBusiness.statisticDoctorsBySpecialization();
    }
}
