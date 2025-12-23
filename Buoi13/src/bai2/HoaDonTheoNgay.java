package bai2;
import TaomoiTV.Test;

public class HoaDonTheoNgay extends HoaDon {
    // Thuộc tính riêng
    private int soNgayThue;
    
    // Constructor
    public HoaDonTheoNgay() {
        super();
    }
    
    // Getter - Setter
    public int getSoNgayThue() {
        return soNgayThue;
    }
    
    public void setSoNgayThue(int soNgayThue) {
        this.soNgayThue = soNgayThue;
    }
    
    // Override phương thức tính thành tiền
    @Override
    public double tinhThanhTien() {
        if (soNgayThue <= 7) {
            return soNgayThue * donGia;
        } else {
            // 7 ngày đầu tính đầy đủ, từ ngày thứ 8 trở đi giảm 20%
            double tien7NgayDau = 7 * donGia;
            double tienConLai = (soNgayThue - 7) * donGia * 0.8;
            return tien7NgayDau + tienConLai;
        }
    }
    
    // Phương thức nhập thông tin hóa đơn theo ngày
    public void nhapThongTin() {
        System.out.println("\n=== NHẬP HÓA ĐƠN THUÊ PHÒNG THEO NGÀY ===");
        
        // Nhập thông tin chung từ lớp cha
        super.nhapThongTin();
        
        // Nhập số ngày thuê
        this.soNgayThue = Test.inputPositiveInt("Số ngày thuê: ");
    }
    
    // Phương thức xuất thông tin hóa đơn theo ngày
    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.printf("%-8d %-15s\n",
            soNgayThue,
            String.format("%.2f", tinhThanhTien()));
    }
    
    // Phương thức xuất tiêu đề
    public static void xuatTieuDe() {
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                                 HÓA ĐƠN THUÊ PHÒNG THEO NGÀY");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-12s %-12s %-25s %-10s %-12s %-8s %-15s\n",
            "Mã HĐ", "Ngày HĐ", "Tên khách hàng", "Mã phòng", "Đơn giá", "Ngày", "Thành tiền");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }
}