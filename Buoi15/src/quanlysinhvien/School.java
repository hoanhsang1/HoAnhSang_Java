package quanlysinhvien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class School {
    // Thuộc tính
    private String maTruong;
    private String tenTruong;
    private LocalDate ngayThanhLap;
    private ArrayList<Faculty> danhSachKhoa;
    private Set<String> danhSachMaTruong; // Để kiểm tra mã trường duy nhất
    
    // Constructor
    public School() {
        danhSachKhoa = new ArrayList<>();
        danhSachMaTruong = new HashSet<>();
    }
    
    // Getter - Setter
    public String getMaTruong() {
        return maTruong;
    }
    
    public void setMaTruong(String maTruong) {
        this.maTruong = maTruong;
    }
    
    public String getTenTruong() {
        return tenTruong;
    }
    
    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }
    
    public LocalDate getNgayThanhLap() {
        return ngayThanhLap;
    }
    
    public void setNgayThanhLap(LocalDate ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }
    
    public ArrayList<Faculty> getDanhSachKhoa() {
        return danhSachKhoa;
    }
    
    // Kiểm tra mã trường đã tồn tại chưa
    public boolean maTruongTonTai(String maTruong) {
        return danhSachMaTruong.contains(maTruong);
    }
    
    // Thêm mã trường vào danh sách (dùng khi nhập mới)
    public void themMaTruong(String maTruong) {
        danhSachMaTruong.add(maTruong);
    }
    
    // Thêm khoa
    public void themKhoa(Faculty khoa) {
        danhSachKhoa.add(khoa);
    }
    
    // Tìm khoa theo mã
    public Faculty timKhoaTheoMa(String maKhoa) {
        for (Faculty khoa : danhSachKhoa) {
            if (khoa.getMaKhoa().equalsIgnoreCase(maKhoa)) {
                return khoa;
            }
        }
        return null;
    }
    
    // Nhập thông tin trường
    public void nhapThongTin() {
        System.out.println("\n=== NHẬP THÔNG TIN TRƯỜNG ===");
        
        // Nhập mã trường (phải duy nhất)
        while (true) {
            System.out.print("Mã trường: ");
            this.maTruong = new Scanner(System.in).nextLine().trim();
            
            if (this.maTruong.isEmpty()) {
                System.out.println("Mã trường không được để trống!");
                continue;
            }
            
            if (maTruongTonTai(this.maTruong)) {
                System.out.println("Mã trường đã tồn tại! Vui lòng nhập mã khác.");
            } else {
                themMaTruong(this.maTruong);
                break;
            }
        }
        
        System.out.print("Tên trường: ");
        this.tenTruong = new Scanner(System.in).nextLine().trim();
        
        // Nhập ngày thành lập
        while (true) {
            System.out.print("Ngày thành lập (dd/MM/yyyy): ");
            String dateString = new Scanner(System.in).nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                this.ngayThanhLap = LocalDate.parse(dateString, formatter);
                break;
            } catch (Exception e) {
                System.out.println("Lỗi: Định dạng ngày không hợp lệ!");
            }
        }
    }
    
    // Xuất thông tin trường
    public void xuatThongTin() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\n══════════════════════════════════════════════");
        System.out.println("            THÔNG TIN TRƯỜNG HỌC");
        System.out.println("══════════════════════════════════════════════");
        System.out.println("Mã trường: " + maTruong);
        System.out.println("Tên trường: " + tenTruong);
        System.out.println("Ngày thành lập: " + ngayThanhLap.format(formatter));
        System.out.println("Số khoa: " + danhSachKhoa.size());
        System.out.println("══════════════════════════════════════════════");
    }
}