package bai4;

import TaomoiTV.Test;

public class BienLai {
    // Thông tin biên lai
    private KhachHang khachHang;
    private int chiSoCu;
    private int chiSoMoi;
    private double soTienPhaiTra;
    
    private Test test;
    
    // Constructor
    public BienLai() {
        this.khachHang = new KhachHang();
        test = new Test();
    }
    
    public BienLai(KhachHang kh, int chiSoCu, int chiSoMoi) {
        this.khachHang = kh;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
        tinhTienDien();
        test = new Test();
    }
    
    // Getter - Setter
    public KhachHang getKhachHang() {
        return khachHang;
    }
    
    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
    
    public int getChiSoCu() {
        return chiSoCu;
    }
    
    public void setChiSoCu(int chiSoCu) {
        this.chiSoCu = chiSoCu;
        tinhTienDien();
    }
    
    public int getChiSoMoi() {
        return chiSoMoi;
    }
    
    public void setChiSoMoi(int chiSoMoi) {
        this.chiSoMoi = chiSoMoi;
        tinhTienDien();
    }
    
    public double getSoTienPhaiTra() {
        return soTienPhaiTra;
    }
    
    // Tính tiền điện (công thức: (số mới - số cũ) * 850000)
    private void tinhTienDien() {
        int soDien = chiSoMoi - chiSoCu;
        if (soDien < 0) {
            soDien = 0;
        }
        this.soTienPhaiTra = soDien * 850000;
    }
    
    // Nhập thông tin biên lai (DÙNG TaomoiTV.Test)
    public void nhapThongTin() {
        System.out.println("\n=== NHẬP THÔNG TIN BIÊN LAI ===");
        
        // Nhập thông tin khách hàng
        khachHang.nhapThongTin();
        
        // Nhập chỉ số điện (DÙNG hàm kiểm tra số nguyên dương từ Test)
        System.out.println("\n--- NHẬP CHỈ SỐ ĐIỆN ---");
        
        // Nhập chỉ số cũ
        chiSoCu = test.inputPositiveInt("Chỉ số cũ (kWh): ");
        
        // Nhập chỉ số mới (phải >= chỉ số cũ)
        while (true) {
            chiSoMoi = test.inputPositiveInt("Chỉ số mới (kWh): ");
            if (chiSoMoi >= chiSoCu) {
                break;
            }
            System.out.println("Chỉ số mới phải >= chỉ số cũ (" + chiSoCu + ")!");
        }
        
        // Tính tiền
        tinhTienDien();
        System.out.println("✓ Đã nhập xong thông tin!");
    }
    
    // Hiển thị thông tin biên lai
    public void hienThiThongTin() {
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("        BIÊN LAI THU TIỀN ĐIỆN");
        System.out.println("══════════════════════════════════════════");
        
        System.out.println("THÔNG TIN KHÁCH HÀNG:");
        System.out.println("├─ Chủ hộ: " + khachHang.getHoTenChuHo());
        System.out.println("├─ Số nhà: " + khachHang.getSoNha());
        System.out.println("└─ Mã công tơ: " + khachHang.getMaSoCongTo());
        
        System.out.println("\nTHÔNG TIN SỬ DỤNG ĐIỆN:");
        int soDien = chiSoMoi - chiSoCu;
        System.out.println("├─ Chỉ số cũ: " + chiSoCu + " kWh");
        System.out.println("├─ Chỉ số mới: " + chiSoMoi + " kWh");
        System.out.println("└─ Số điện tiêu thụ: " + soDien + " kWh");
        
        System.out.println("\nTHANH TOÁN:");
        System.out.println("├─ Đơn giá: 850.000 VNĐ/kWh");
        System.out.printf("└─ Số tiền phải trả: %,.0f VNĐ\n", soTienPhaiTra);
        System.out.println("══════════════════════════════════════════");
    }
    
    // Hiển thị ngắn gọn (cho danh sách)
    public void hienThiThongTinNgan() {
        int soDien = chiSoMoi - chiSoCu;
        System.out.printf("│ %-20s │ %-10s │ %-15s │ %8d │ %8d │ %,15.0f VNĐ │\n",
            khachHang.getHoTenChuHo(),
            khachHang.getSoNha(),
            khachHang.getMaSoCongTo(),
            chiSoCu,
            chiSoMoi,
            soTienPhaiTra);
    }
}
