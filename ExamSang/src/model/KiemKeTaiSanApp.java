package model;

public class KiemKeTaiSanApp {
    public static void main(String[] args) {
        System.out.println("\n" + "★".repeat(60));
        System.out.println("       HỆ THỐNG KIỂM KÊ TÀI SẢN - THU VIEN SANG");
        System.out.println("★".repeat(60));
        System.out.println("Phiên bản: 1.0");
        System.out.println("Ngày: " + java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("★".repeat(60));
        
        try {
            // Tạo đối tượng xử lý
            XuLyPhieuKiemKe xuLy = new XuLyPhieuKiemKe();
            
            // Chạy menu chính
            xuLy.hienThiMenu();
            
        } catch (Exception e) {
            System.out.println("❌ Lỗi khởi động chương trình: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\n" + "★".repeat(60));
        System.out.println("       CHƯƠNG TRÌNH KẾT THÚC");
        System.out.println("★".repeat(60));
    }
}