import java.io.IOException;

public class Bai4 {

    // Method C
    public static void saveToFile() throws IOException {
        System.out.println("Đang lưu dữ liệu vào file...");

        // giả lập lỗi khi ghi file
        throw new IOException("Lỗi khi ghi file!");
    }

    // Method B
    public static void processUserData() throws IOException {
        System.out.println("Đang xử lý dữ liệu người dùng...");

        // gọi method C
        saveToFile();
    }

    // Method A (main)
    public static void main(String[] args) {

        try {
            processUserData();
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi lưu dữ liệu: " + e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy.");
    }
}