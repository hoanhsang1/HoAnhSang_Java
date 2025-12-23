package bai2;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Month;
import TaomoiTV.Test;

public class KhachSanX {
    private ArrayList<HoaDonTheoGio> danhSachHDGio;
    private ArrayList<HoaDonTheoNgay> danhSachHDNgay;
    
    // Constructor
    public KhachSanX() {
        danhSachHDGio = new ArrayList<>();
        danhSachHDNgay = new ArrayList<>();
    }
    
    // Kiểm tra mã hóa đơn đã tồn tại chưa
    private boolean maHDTonTai(String maHD) {
        // Kiểm tra trong hóa đơn theo giờ
        for (HoaDonTheoGio hd : danhSachHDGio) {
            if (hd.getMaHoaDon().equalsIgnoreCase(maHD)) {
                return true;
            }
        }
        
        // Kiểm tra trong hóa đơn theo ngày
        for (HoaDonTheoNgay hd : danhSachHDNgay) {
            if (hd.getMaHoaDon().equalsIgnoreCase(maHD)) {
                return true;
            }
        }
        
        return false;
    }
    
    // 1. Nhập danh sách hóa đơn theo giờ
    public void nhapDanhSachHDGio() {
        System.out.println("\n=== NHẬP DANH SÁCH HÓA ĐƠN THEO GIỜ ===");
        
        int n = Test.inputPositiveInt("Nhập số lượng hóa đơn theo giờ: ");
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Hóa đơn theo giờ thứ " + (i + 1) + " ---");
            
            HoaDonTheoGio hd = new HoaDonTheoGio();
            hd.nhapThongTin();
            
            // Kiểm tra mã hóa đơn duy nhất
            while (maHDTonTai(hd.getMaHoaDon())) {
                System.out.println("Mã hóa đơn đã tồn tại! Vui lòng nhập mã khác.");
                hd.setMaHoaDon(Test.inputNonEmptyString("Mã hóa đơn mới: "));
            }
            
            danhSachHDGio.add(hd);
            System.out.println("✓ Đã thêm hóa đơn: " + hd.getMaHoaDon());
        }
        
        System.out.println("\n✓ Hoàn thành nhập " + danhSachHDGio.size() + " hóa đơn theo giờ!");
    }
    
    // 2. Nhập danh sách hóa đơn theo ngày
    public void nhapDanhSachHDNgay() {
        System.out.println("\n=== NHẬP DANH SÁCH HÓA ĐƠN THEO NGÀY ===");
        
        int n = Test.inputPositiveInt("Nhập số lượng hóa đơn theo ngày: ");
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Hóa đơn theo ngày thứ " + (i + 1) + " ---");
            
            HoaDonTheoNgay hd = new HoaDonTheoNgay();
            hd.nhapThongTin();
            
            // Kiểm tra mã hóa đơn duy nhất
            while (maHDTonTai(hd.getMaHoaDon())) {
                System.out.println("Mã hóa đơn đã tồn tại! Vui lòng nhập mã khác.");
                hd.setMaHoaDon(Test.inputNonEmptyString("Mã hóa đơn mới: "));
            }
            
            danhSachHDNgay.add(hd);
            System.out.println("✓ Đã thêm hóa đơn: " + hd.getMaHoaDon());
        }
        
        System.out.println("\n✓ Hoàn thành nhập " + danhSachHDNgay.size() + " hóa đơn theo ngày!");
    }
    
    // 3. Xuất danh sách hóa đơn theo giờ
    public void xuatDanhSachHDGio() {
        if (danhSachHDGio.isEmpty()) {
            System.out.println("\nDanh sách hóa đơn theo giờ trống!");
            return;
        }
        
        HoaDonTheoGio.xuatTieuDe();
        
        int stt = 1;
        double tongTien = 0;
        for (HoaDonTheoGio hd : danhSachHDGio) {
            System.out.printf("%-3d ", stt++);
            hd.xuatThongTin();
            tongTien += hd.tinhThanhTien();
        }
        
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("Tổng số hóa đơn theo giờ: %d | Tổng thành tiền: %.2f\n", 
            danhSachHDGio.size(), tongTien);
    }
    
    // 4. Xuất danh sách hóa đơn theo ngày
    public void xuatDanhSachHDNgay() {
        if (danhSachHDNgay.isEmpty()) {
            System.out.println("\nDanh sách hóa đơn theo ngày trống!");
            return;
        }
        
        HoaDonTheoNgay.xuatTieuDe();
        
        int stt = 1;
        double tongTien = 0;
        for (HoaDonTheoNgay hd : danhSachHDNgay) {
            System.out.printf("%-3d ", stt++);
            hd.xuatThongTin();
            tongTien += hd.tinhThanhTien();
        }
        
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("Tổng số hóa đơn theo ngày: %d | Tổng thành tiền: %.2f\n", 
            danhSachHDNgay.size(), tongTien);
    }
    
    // 5. Tính tổng số lượng cho từng loại thuê phòng
    public void tinhTongSoLuongTungLoai() {
        System.out.println("\n=== TỔNG SỐ LƯỢNG HÓA ĐƠN ===");
        System.out.println("Hóa đơn theo giờ: " + danhSachHDGio.size());
        System.out.println("Hóa đơn theo ngày: " + danhSachHDNgay.size());
        System.out.println("Tổng cộng: " + (danhSachHDGio.size() + danhSachHDNgay.size()));
    }
    
    // 6. Tính trung bình thành tiền của hóa đơn trong tháng 9/2013
    public void tinhTrungBinhThanhTienThang9_2013() {
        ArrayList<HoaDon> danhSachThang9 = new ArrayList<>();
        double tongThanhTien = 0;
        
        // Lọc hóa đơn trong tháng 9/2013
        for (HoaDonTheoGio hd : danhSachHDGio) {
            LocalDate ngayHD = hd.getNgayHoaDon();
            if (ngayHD.getYear() == 2013 && ngayHD.getMonth() == Month.SEPTEMBER) {
                danhSachThang9.add(hd);
                tongThanhTien += hd.tinhThanhTien();
            }
        }
        
        for (HoaDonTheoNgay hd : danhSachHDNgay) {
            LocalDate ngayHD = hd.getNgayHoaDon();
            if (ngayHD.getYear() == 2013 && ngayHD.getMonth() == Month.SEPTEMBER) {
                danhSachThang9.add(hd);
                tongThanhTien += hd.tinhThanhTien();
            }
        }
        
        if (danhSachThang9.isEmpty()) {
            System.out.println("\nKhông có hóa đơn nào trong tháng 9/2013!");
            return;
        }
        
        double trungBinh = tongThanhTien / danhSachThang9.size();
        
        System.out.println("\n=== THỐNG KÊ HÓA ĐƠN THÁNG 9/2013 ===");
        System.out.println("Số lượng hóa đơn: " + danhSachThang9.size());
        System.out.printf("Tổng thành tiền: %.2f\n", tongThanhTien);
        System.out.printf("Trung bình thành tiền: %.2f\n", trungBinh);
        
        // Xuất danh sách hóa đơn tháng 9/2013
        System.out.println("\n═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("                                  DANH SÁCH HÓA ĐƠN THÁNG 9/2013");
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-12s %-12s %-25s %-10s %-12s %-8s %-8s %-15s\n",
            "Mã HĐ", "Ngày HĐ", "Tên khách hàng", "Mã phòng", "Đơn giá", "Loại", "SL", "Thành tiền");
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        
        int stt = 1;
        for (HoaDon hd : danhSachThang9) {
            System.out.printf("%-3d %-12s %-12s %-25s %-10s %-12s ",
                stt++,
                hd.getMaHoaDon(),
                hd.getNgayHoaDon().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                hd.getTenKhachHang(),
                hd.getMaPhong(),
                String.format("%.2f", hd.getDonGia()));
            
            if (hd instanceof HoaDonTheoGio) {
                HoaDonTheoGio hdGio = (HoaDonTheoGio) hd;
                System.out.printf("%-8s %-8d %-15s\n",
                    "Giờ",
                    hdGio.getSoGioThue(),
                    String.format("%.2f", hd.tinhThanhTien()));
            } else {
                HoaDonTheoNgay hdNgay = (HoaDonTheoNgay) hd;
                System.out.printf("%-8s %-8d %-15s\n",
                    "Ngày",
                    hdNgay.getSoNgayThue(),
                    String.format("%.2f", hd.tinhThanhTien()));
            }
        }
        
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
    }
    
    // Getter danh sách
    public ArrayList<HoaDonTheoGio> getDanhSachHDGio() {
        return danhSachHDGio;
    }
    
    public ArrayList<HoaDonTheoNgay> getDanhSachHDNgay() {
        return danhSachHDNgay;
    }
    
    public int getSoLuongHDGio() {
        return danhSachHDGio.size();
    }
    
    public int getSoLuongHDNgay() {
        return danhSachHDNgay.size();
    }
}