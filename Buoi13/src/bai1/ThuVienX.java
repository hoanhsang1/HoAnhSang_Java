package bai1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import TaomoiTV.Mang;
import TaomoiTV.Toanhoc;
import TaomoiTV.Test;

public class ThuVienX {
    private ArrayList<SachGiaoKhoa> danhSachSGK;
    private ArrayList<SachThamKhao> danhSachSTK;
    
    // Constructor
    public ThuVienX() {
        danhSachSGK = new ArrayList<>();
        danhSachSTK = new ArrayList<>();
    }
    
    // Kiểm tra mã sách đã tồn tại chưa
    private boolean maSachTonTai(String maSach) {
        // Kiểm tra trong sách giáo khoa
        for (SachGiaoKhoa sgk : danhSachSGK) {
            if (sgk.getMaSach().equalsIgnoreCase(maSach)) {
                return true;
            }
        }
        
        // Kiểm tra trong sách tham khảo
        for (SachThamKhao stk : danhSachSTK) {
            if (stk.getMaSach().equalsIgnoreCase(maSach)) {
                return true;
            }
        }
        
        return false;
    }
    
    // 1. Nhập danh sách sách giáo khoa
    public void nhapDanhSachSGK() {
        System.out.println("\n=== NHẬP DANH SÁCH SÁCH GIÁO KHOA ===");
        
        int n = Test.inputPositiveInt("Nhập số lượng sách giáo khoa: ");
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Sách giáo khoa thứ " + (i + 1) + " ---");
            
            SachGiaoKhoa sgk = new SachGiaoKhoa();
            
            // Nhập thông tin sách
            sgk.nhapThongTin();
            
            // Kiểm tra mã sách duy nhất
            while (maSachTonTai(sgk.getMaSach())) {
                System.out.println("Mã sách đã tồn tại! Vui lòng nhập mã khác.");
                sgk.setMaSach(Test.inputNonEmptyString("Mã sách mới: "));
            }
            
            danhSachSGK.add(sgk);
            System.out.println("✓ Đã thêm sách: " + sgk.getMaSach());
        }
        
        System.out.println("\n✓ Hoàn thành nhập " + danhSachSGK.size() + " sách giáo khoa!");
    }
    
    // 2. Nhập danh sách sách tham khảo
    public void nhapDanhSachSTK() {
        System.out.println("\n=== NHẬP DANH SÁCH SÁCH THAM KHẢO ===");
        
        int n = Test.inputPositiveInt("Nhập số lượng sách tham khảo: ");
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Sách tham khảo thứ " + (i + 1) + " ---");
            
            SachThamKhao stk = new SachThamKhao();
            
            // Nhập thông tin sách
            stk.nhapThongTin();
            
            // Kiểm tra mã sách duy nhất
            while (maSachTonTai(stk.getMaSach())) {
                System.out.println("Mã sách đã tồn tại! Vui lòng nhập mã khác.");
                stk.setMaSach(Test.inputNonEmptyString("Mã sách mới: "));
            }
            
            danhSachSTK.add(stk);
            System.out.println("✓ Đã thêm sách: " + stk.getMaSach());
        }
        
        System.out.println("\n✓ Hoàn thành nhập " + danhSachSTK.size() + " sách tham khảo!");
    }
    
    // 3. Xuất danh sách sách giáo khoa
    public void xuatDanhSachSGK() {
        if (danhSachSGK.isEmpty()) {
            System.out.println("\nDanh sách sách giáo khoa trống!");
            return;
        }
        
        SachGiaoKhoa.xuatTieuDe();
        
        int stt = 1;
        for (SachGiaoKhoa sgk : danhSachSGK) {
            System.out.printf("%-3d ", stt++);
            sgk.xuatThongTin();
        }
        
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Tổng số sách giáo khoa: " + danhSachSGK.size());
        System.out.printf("Tổng thành tiền SGK: %.2f\n", tinhTongThanhTienSGK());
    }
    
    // 4. Xuất danh sách sách tham khảo
    public void xuatDanhSachSTK() {
        if (danhSachSTK.isEmpty()) {
            System.out.println("\nDanh sách sách tham khảo trống!");
            return;
        }
        
        SachThamKhao.xuatTieuDe();
        
        int stt = 1;
        for (SachThamKhao stk : danhSachSTK) {
            System.out.printf("%-3d ", stt++);
            stk.xuatThongTin();
        }
        
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Tổng số sách tham khảo: " + danhSachSTK.size());
        System.out.printf("Tổng thành tiền STK: %.2f\n", tinhTongThanhTienSTK());
    }
    
    // 5. Tính tổng thành tiền sách giáo khoa
    public double tinhTongThanhTienSGK() {
        double tong = 0;
        for (SachGiaoKhoa sgk : danhSachSGK) {
            tong += sgk.tinhThanhTien();
        }
        return tong;
    }
    
    // 6. Tính tổng thành tiền sách tham khảo
    public double tinhTongThanhTienSTK() {
        double tong = 0;
        for (SachThamKhao stk : danhSachSTK) {
            tong += stk.tinhThanhTien();
        }
        return tong;
    }
    
    // 7. Tính trung bình cộng đơn giá của các sách tham khảo
    public double tinhTrungBinhDonGiaSTK() {
        if (danhSachSTK.isEmpty()) {
            return 0;
        }
        
        double tongDonGia = 0;
        for (SachThamKhao stk : danhSachSTK) {
            tongDonGia += stk.getDonGia();
        }
        
        return tongDonGia / danhSachSTK.size();
    }
    
    // 8. Xuất sách giáo khoa của nhà xuất bản X
    public void xuatSGKTheoNhaXuatBan() {
        if (danhSachSGK.isEmpty()) {
            System.out.println("\nDanh sách sách giáo khoa trống!");
            return;
        }
        
        String nxb = Test.inputNonEmptyString("\nNhập tên nhà xuất bản cần tìm: ");
        
        ArrayList<SachGiaoKhoa> ketQua = new ArrayList<>();
        for (SachGiaoKhoa sgk : danhSachSGK) {
            if (sgk.getNhaXuatBan().equalsIgnoreCase(nxb)) {
                ketQua.add(sgk);
            }
        }
        
        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy sách giáo khoa của nhà xuất bản: " + nxb);
            return;
        }
        
        System.out.println("\n══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("         SÁCH GIÁO KHOA CỦA NHÀ XUẤT BẢN: " + nxb.toUpperCase());
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-10s %-12s %-12s %-8s %-15s %-10s %-12s\n",
            "Mã sách", "Ngày nhập", "Đơn giá", "SL", "Nhà XB", "T.trạng", "Thành tiền");
        System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────");
        
        int stt = 1;
        for (SachGiaoKhoa sgk : ketQua) {
            System.out.printf("%-3d ", stt++);
            sgk.xuatThongTin();
        }
        
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Tổng số: " + ketQua.size() + " sách");
    }
    
    // 9. Sắp xếp danh sách SGK theo mã sách (ĐÃ SỬA - không dùng thư viện)
    public void sapXepSGKTheoMa() {
        if (danhSachSGK.isEmpty()) {
            System.out.println("\nDanh sách sách giáo khoa trống!");
            return;
        }
        
        // Sử dụng Comparator để sắp xếp (không cần implements Comparable)
        Collections.sort(danhSachSGK, new Comparator<SachGiaoKhoa>() {
            @Override
            public int compare(SachGiaoKhoa s1, SachGiaoKhoa s2) {
                return s1.getMaSach().compareTo(s2.getMaSach());
            }
        });
        
        System.out.println("\n✓ Đã sắp xếp sách giáo khoa theo mã sách (tăng dần)");
    }
    
    // 10. Thống kê đơn giá cao nhất và thấp nhất của STK (ĐÃ SỬA - không dùng thư viện)
    public void thongKeDonGiaSTK() {
        if (danhSachSTK.isEmpty()) {
            System.out.println("\nDanh sách sách tham khảo trống!");
            return;
        }
        
        // Tìm đơn giá cao nhất và thấp nhất
        double maxDonGia = danhSachSTK.get(0).getDonGia();
        double minDonGia = danhSachSTK.get(0).getDonGia();
        
        for (SachThamKhao stk : danhSachSTK) {
            double donGia = stk.getDonGia();
            if (donGia > maxDonGia) {
                maxDonGia = donGia;
            }
            if (donGia < minDonGia) {
                minDonGia = donGia;
            }
        }
        
        System.out.println("\n=== THỐNG KÊ ĐƠN GIÁ SÁCH THAM KHẢO ===");
        System.out.printf("Đơn giá cao nhất: %.2f\n", maxDonGia);
        System.out.printf("Đơn giá thấp nhất: %.2f\n", minDonGia);
        System.out.printf("Trung bình đơn giá: %.2f\n", tinhTrungBinhDonGiaSTK());
    }
    
    // Getter danh sách
    public ArrayList<SachGiaoKhoa> getDanhSachSGK() {
        return danhSachSGK;
    }
    
    public ArrayList<SachThamKhao> getDanhSachSTK() {
        return danhSachSTK;
    }
    
    public int getSoLuongSGK() {
        return danhSachSGK.size();
    }
    
    public int getSoLuongSTK() {
        return danhSachSTK.size();
    }
}