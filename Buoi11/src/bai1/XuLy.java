package bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class XuLy {
    private ArrayList<SinhVien> danhSachSV;
    private ArrayList<GiaoVien> danhSachGV;
    private Scanner sc;
    
    // Constructor
    public XuLy() {
        danhSachSV = new ArrayList<>();
        danhSachGV = new ArrayList<>();
        sc = new Scanner(System.in);
    }
    
    // Kiểm tra CCCD đã tồn tại chưa
    private boolean cccdTonTai(String cccd) {
        // Kiểm tra trong danh sách sinh viên
        for (SinhVien sv : danhSachSV) {
            if (sv.getCccd().equals(cccd)) {
                return true;
            }
        }
        
        // Kiểm tra trong danh sách giáo viên
        for (GiaoVien gv : danhSachGV) {
            if (gv.getCccd().equals(cccd)) {
                return true;
            }
        }
        
        return false;
    }
    
    // Kiểm tra mã sinh viên đã tồn tại chưa
    private boolean maSVTonTai(String maSV) {
        for (SinhVien sv : danhSachSV) {
            if (sv.getMaSV().equalsIgnoreCase(maSV)) {
                return true;
            }
        }
        return false;
    }
    
    // Kiểm tra mã giáo viên đã tồn tại chưa
    private boolean maGVTonTai(String maGV) {
        for (GiaoVien gv : danhSachGV) {
            if (gv.getMaGV().equalsIgnoreCase(maGV)) {
                return true;
            }
        }
        return false;
    }
    
    // 1. Nhập danh sách sinh viên
    public void nhapDanhSachSinhVien() {
        System.out.println("\n=== NHẬP DANH SÁCH SINH VIÊN ===");
        
        int n = nhapSoNguyen("Nhập số lượng sinh viên: ");
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Sinh viên thứ " + (i + 1) + " ---");
            
            SinhVien sv = new SinhVien();
            
            // Nhập thông tin chung
            sv.nhapThongTin();
            
            // Kiểm tra CCCD duy nhất
            while (cccdTonTai(sv.getCccd())) {
                System.out.println("CCCD đã tồn tại! Vui lòng nhập lại.");
                System.out.print("Số CCCD mới (12 số): ");
                String cccdMoi;
                while (true) {
                    cccdMoi = sc.nextLine().trim();
                    if (cccdMoi.matches("\\d{12}")) {
                        sv.setCccd(cccdMoi);
                        break;
                    }
                    System.out.println("CCCD phải có đúng 12 chữ số!");
                }
            }
            
            // Kiểm tra mã sinh viên duy nhất
            while (maSVTonTai(sv.getMaSV())) {
                System.out.println("Mã sinh viên đã tồn tại! Vui lòng nhập mã khác.");
                System.out.print("Mã sinh viên mới: ");
                sv.setMaSV(sc.nextLine().trim());
            }
            
            danhSachSV.add(sv);
            System.out.println("✓ Đã thêm sinh viên: " + sv.getHoTen());
        }
        
        System.out.println("\n✓ Hoàn thành nhập " + danhSachSV.size() + " sinh viên!");
    }
    
    // 2. Nhập danh sách giáo viên
    public void nhapDanhSachGiaoVien() {
        System.out.println("\n=== NHẬP DANH SÁCH GIÁO VIÊN ===");
        
        int n = nhapSoNguyen("Nhập số lượng giáo viên: ");
        
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Giáo viên thứ " + (i + 1) + " ---");
            
            GiaoVien gv = new GiaoVien();
            
            // Nhập thông tin chung
            gv.nhapThongTin();
            
            // Kiểm tra CCCD duy nhất
            while (cccdTonTai(gv.getCccd())) {
                System.out.println("CCCD đã tồn tại! Vui lòng nhập lại.");
                System.out.print("Số CCCD mới (12 số): ");
                String cccdMoi;
                while (true) {
                    cccdMoi = sc.nextLine().trim();
                    if (cccdMoi.matches("\\d{12}")) {
                        gv.setCccd(cccdMoi);
                        break;
                    }
                    System.out.println("CCCD phải có đúng 12 chữ số!");
                }
            }
            
            // Kiểm tra mã giáo viên duy nhất
            while (maGVTonTai(gv.getMaGV())) {
                System.out.println("Mã giáo viên đã tồn tại! Vui lòng nhập mã khác.");
                System.out.print("Mã giáo viên mới: ");
                gv.setMaGV(sc.nextLine().trim());
            }
            
            danhSachGV.add(gv);
            System.out.println("✓ Đã thêm giáo viên: " + gv.getHoTen());
        }
        
        System.out.println("\n✓ Hoàn thành nhập " + danhSachGV.size() + " giáo viên!");
    }
    
    // 3. Xuất danh sách sinh viên
    public void xuatDanhSachSinhVien() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        SinhVien.xuatTieuDe();
        
        int stt = 1;
        for (SinhVien sv : danhSachSV) {
            System.out.printf("%-3d ", stt++);
            sv.xuatThongTin();
        }
        
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Tổng số sinh viên: " + danhSachSV.size());
    }
    
    // 4. Xuất danh sách giáo viên
    public void xuatDanhSachGiaoVien() {
        if (danhSachGV.isEmpty()) {
            System.out.println("\nDanh sách giáo viên trống!");
            return;
        }
        
        GiaoVien.xuatTieuDe();
        
        int stt = 1;
        for (GiaoVien gv : danhSachGV) {
            System.out.printf("%-3d ", stt++);
            gv.xuatThongTin();
        }
        
        System.out.println("═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.println("Tổng số giáo viên: " + danhSachGV.size());
    }
    
    // 5. Thống kê sinh viên theo xếp loại
    public void thongKeSinhVien() {
        if (danhSachSV.isEmpty()) {
            System.out.println("\nDanh sách sinh viên trống!");
            return;
        }
        
        int gioi = 0, kha = 0, tb = 0, yeu = 0;
        
        for (SinhVien sv : danhSachSV) {
            String xepLoai = sv.xepLoaiRenLuyen();
            switch (xepLoai) {
                case "Giỏi": gioi++; break;
                case "Khá": kha++; break;
                case "Trung bình": tb++; break;
                case "Yếu": yeu++; break;
            }
        }
        
        System.out.println("\n=== THỐNG KÊ XẾP LOẠI SINH VIÊN ===");
        System.out.println("Tổng số sinh viên: " + danhSachSV.size());
        System.out.println("Giỏi: " + gioi + " sinh viên (" + String.format("%.1f", (gioi*100.0/danhSachSV.size())) + "%)");
        System.out.println("Khá: " + kha + " sinh viên (" + String.format("%.1f", (kha*100.0/danhSachSV.size())) + "%)");
        System.out.println("Trung bình: " + tb + " sinh viên (" + String.format("%.1f", (tb*100.0/danhSachSV.size())) + "%)");
        System.out.println("Yếu: " + yeu + " sinh viên (" + String.format("%.1f", (yeu*100.0/danhSachSV.size())) + "%)");
    }
    
    // 6. Thống kê giáo viên theo xếp loại
    public void thongKeGiaoVien() {
        if (danhSachGV.isEmpty()) {
            System.out.println("\nDanh sách giáo viên trống!");
            return;
        }
        
        int a = 0, b = 0, c = 0, d = 0;
        
        for (GiaoVien gv : danhSachGV) {
            String xepLoai = gv.xepLoaiThiDua();
            switch (xepLoai) {
                case "A": a++; break;
                case "B": b++; break;
                case "C": c++; break;
                case "D": d++; break;
            }
        }
        
        System.out.println("\n=== THỐNG KÊ XẾP LOẠI GIÁO VIÊN ===");
        System.out.println("Tổng số giáo viên: " + danhSachGV.size());
        System.out.println("Loại A: " + a + " giáo viên (" + String.format("%.1f", (a*100.0/danhSachGV.size())) + "%)");
        System.out.println("Loại B: " + b + " giáo viên (" + String.format("%.1f", (b*100.0/danhSachGV.size())) + "%)");
        System.out.println("Loại C: " + c + " giáo viên (" + String.format("%.1f", (c*100.0/danhSachGV.size())) + "%)");
        System.out.println("Loại D: " + d + " giáo viên (" + String.format("%.1f", (d*100.0/danhSachGV.size())) + "%)");
    }
    
    // Phương thức nhập số nguyên
    private int nhapSoNguyen(String message) {
        while (true) {
            try {
                System.out.print(message);
                int n = Integer.parseInt(sc.nextLine());
                if (n > 0) return n;
                System.out.println("Số lượng phải > 0!");
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        }
    }
    
    // Getter danh sách
    public ArrayList<SinhVien> getDanhSachSV() {
        return danhSachSV;
    }
    
    public ArrayList<GiaoVien> getDanhSachGV() {
        return danhSachGV;
    }
    
    public int getSoLuongSV() {
        return danhSachSV.size();
    }
    
    public int getSoLuongGV() {
        return danhSachGV.size();
    }
}