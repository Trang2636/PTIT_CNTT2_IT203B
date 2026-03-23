package com.re.business.bai5;


import com.re.business.bai5.Connection.DBConnection;
import com.re.business.bai5.Entity.Patient;
import com.re.business.bai5.Service.PatientService;

import java.util.Scanner;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = DBConnection.getConnection()) {

            System.out.println("===== HE THONG RHMS =====");
            System.out.println("\n>>> Them benh nhan:");
            String insertSQL = "INSERT INTO Patients(name, age, department, disease) VALUES (?, ?, ?, ?)";

            PreparedStatement psInsert = conn.prepareStatement(insertSQL);
            psInsert.setString(1, "L'Oréal Test"); // test dấu '
            psInsert.setInt(2, 28);
            psInsert.setString(3, "Hồi sức");
            psInsert.setString(4, "Sốt cao");

            psInsert.executeUpdate();
            System.out.println("-> Them thanh cong!");

            System.out.println("\n>>> Danh sach benh nhan:");
            String selectSQL = "SELECT id, name, age, department FROM Patients";

            PreparedStatement psSelect = conn.prepareStatement(selectSQL);
            ResultSet rs = psSelect.executeQuery();

            System.out.printf("%-5s %-20s %-5s %-15s%n", "ID", "Ten", "Tuoi", "Khoa");

            while (rs.next()) {
                System.out.printf("%-5d %-20s %-5d %-15s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"));
            }
            System.out.println("\n>>> Cap nhat benh an (ID = 1):");
            String updateSQL = "UPDATE Patients SET disease = ? WHERE id = ?";

            PreparedStatement psUpdate = conn.prepareStatement(updateSQL);
            psUpdate.setString(1, "Viêm phổi");
            psUpdate.setInt(2, 1);

            psUpdate.executeUpdate();
            System.out.println("-> Cap nhat thanh cong!");

            System.out.println("\n>>> Xuat vien & tinh phi (ID = 1):");
            String callSQL = "{CALL CALCULATE_DISCHARGE_FEE(?, ?)}";

            CallableStatement cs = conn.prepareCall(callSQL);
            cs.setInt(1, 1);
            cs.registerOutParameter(2, Types.DOUBLE);

            cs.execute();

            double fee = cs.getDouble(2);
            System.out.println("Tong vien phi: " + fee);

            System.out.println("\n===== KET THUC =====");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}