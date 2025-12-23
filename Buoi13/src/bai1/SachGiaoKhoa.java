package bai1;

import TaomoiTV.Test;

public class SachGiaoKhoa extends Sach {
    // Thuộc tính riêng
    private String tinhTrang; // "moi" hoặc "cu"
    
    // Constructor
    public SachGiaoKhoa() {
        super();
    }
    
    // Getter - Setter
    public String getTinhTrang() {
        return tinhTrang;
    }
    
    public void setTinhTrang(String tinhTrang) {
        if (tinhTrang.equalsIgnoreCase("moi") || tinhTrang.equalsIgnoreCase("cu")) {
            this.tinhTrang = tinhTrang;
        } else {
            this.tinhTrang = "moi";
        }
    }
    
    // Override phương thức tính thành tiền
    @Override
    public double tinhThanhTien() {
        if (tinhTrang.equalsIgnoreCase("moi")) {
            return soLuong * donGia;
        } else { // sách cũ
            return soLuong * donGia * 0.5;
        }
    }
    
    // Phương thức nhập thông tin sách giáo khoa
    public void nhapThongTin() {
        System.out.println("\n=== NHẬP THÔNG TIN SÁCH GIÁO KHOA ===");
        
        // Nhập thông tin chung từ lớp cha
        super.nhapThongTin();
        
        // Nhập tình trạng sách
        while (true) {
            String tt = Test.inputNonEmptyString("Tình trạng (moi/cu): ").toLowerCase();
            if (tt.equals("moi") || tt.equals("cu")) {
                this.tinhTrang = tt;
                break;
            }
            System.out.println("Tình trạng phải là 'moi' hoặc 'cu'!");
        }
    }
    
    // Phương thức xuất thông tin sách giáo khoa
    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.printf("%-10s %-12s\n",
            tinhTrang,
            String.format("%.2f", tinhThanhTien()));
    }
    
    // Phương thức xuất tiêu đề
    public static void xuatTieuDe() {
        System.out.println("\n══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                     DANH SÁCH SÁCH GIÁO KHOA");
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-10s %-12s %-12s %-8s %-15s %-10s %-12s\n",
            "Mã sách", "Ngày nhập", "Đơn giá", "SL", "Nhà XB", "T.trạng", "Thành tiền");
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }
    
    // Triển khai Comparable để sử dụng sắp xếp từ thư viện
    public int compareTo(SachGiaoKhoa other) {
        return this.maSach.compareTo(other.maSach);
    }
}