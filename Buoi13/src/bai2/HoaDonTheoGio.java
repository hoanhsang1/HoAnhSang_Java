package bai2;

public class HoaDonTheoGio extends HoaDon {
    // Thuộc tính riêng
    private int soGioThue;
    
    // Constructor
    public HoaDonTheoGio() {
        super();
    }
    
    // Getter - Setter
    public int getSoGioThue() {
        return soGioThue;
    }
    
    public void setSoGioThue(int soGioThue) {
        this.soGioThue = soGioThue;
    }
    
    // Override phương thức tính thành tiền
    @Override
    public double tinhThanhTien() {
        if (soGioThue > 30) {
            System.out.println("Cảnh báo: Số giờ > 30 không nên dùng hóa đơn theo giờ!");
            return 0;
        }
        
        int gioTinh = soGioThue;
        if (soGioThue > 24 && soGioThue <= 30) {
            gioTinh = 24; // Chỉ tính 24 giờ
        }
        
        return gioTinh * donGia;
    }
    
    // Phương thức nhập thông tin hóa đơn theo giờ
    public void nhapThongTin() {
        System.out.println("\n=== NHẬP HÓA ĐƠN THUÊ PHÒNG THEO GIỜ ===");
        
        // Nhập thông tin chung từ lớp cha
        super.nhapThongTin();
        
        // Nhập số giờ thuê
        while (true) {
            try {
                System.out.print("Số giờ thuê: ");
                this.soGioThue = Integer.parseInt(sc.nextLine());
                if (this.soGioThue > 0 && this.soGioThue <= 30) {
                    break;
                } else if (this.soGioThue > 30) {
                    System.out.println("Số giờ > 30 không nên dùng hóa đơn theo giờ! Vui lòng nhập lại.");
                } else {
                    System.out.println("Số giờ phải > 0!");
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        }
    }
    
    // Phương thức xuất thông tin hóa đơn theo giờ
    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.printf("%-8d %-15s\n",
            soGioThue,
            String.format("%.2f", tinhThanhTien()));
    }
    
    // Phương thức xuất tiêu đề
    public static void xuatTieuDe() {
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                                  HÓA ĐƠN THUÊ PHÒNG THEO GIỜ");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-12s %-12s %-25s %-10s %-12s %-8s %-15s\n",
            "Mã HĐ", "Ngày HĐ", "Tên khách hàng", "Mã phòng", "Đơn giá", "Giờ", "Thành tiền");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }
}