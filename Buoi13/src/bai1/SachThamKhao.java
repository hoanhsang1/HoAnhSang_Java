package bai1;

import TaomoiTV.Test;

public class SachThamKhao extends Sach {
    // Thuộc tính riêng
    private double thue;
    
    // Constructor
    public SachThamKhao() {
        super();
    }
    
    // Getter - Setter
    public double getThue() {
        return thue;
    }
    
    public void setThue(double thue) {
        this.thue = thue;
    }
    
    // Override phương thức tính thành tiền
    @Override
    public double tinhThanhTien() {
        return soLuong * donGia + thue;
    }
    
    // Phương thức nhập thông tin sách tham khảo
    public void nhapThongTin() {
        System.out.println("\n=== NHẬP THÔNG TIN SÁCH THAM KHẢO ===");
        
        // Nhập thông tin chung từ lớp cha
        super.nhapThongTin();
        
        // Nhập thuế
        this.thue = Test.inputDouble("Thuế: ");
        if (thue < 0) {
            thue = 0;
            System.out.println("Thuế đã được điều chỉnh thành 0 (vì nhập số âm)");
        }
    }
    
    // Phương thức xuất thông tin sách tham khảo
    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.printf("%-10s %-12s\n",
            String.format("%.2f", thue),
            String.format("%.2f", tinhThanhTien()));
    }
    
    // Phương thức xuất tiêu đề
    public static void xuatTieuDe() {
        System.out.println("\n══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                   DANH SÁCH SÁCH THAM KHẢO");
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-10s %-12s %-12s %-8s %-15s %-10s %-12s\n",
            "Mã sách", "Ngày nhập", "Đơn giá", "SL", "Nhà XB", "Thuế", "Thành tiền");
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }
    
    // Triển khai Comparable để sử dụng sắp xếp từ thư viện
    public int compareTo(SachThamKhao other) {
        return this.maSach.compareTo(other.maSach);
    }
}