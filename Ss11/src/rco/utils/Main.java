package rco.utils;

import rco.utils.Bai1;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Bai1.getConnection()) {
            if (conn != null) {
                System.out.println("Kết nối thành công!");
            } else {
                System.out.println("Kết nối thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}